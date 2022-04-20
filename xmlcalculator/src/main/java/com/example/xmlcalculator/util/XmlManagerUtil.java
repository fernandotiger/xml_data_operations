package com.example.xmlcalculator.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.example.xmlcalculator.entity.CityEntity;
import com.example.xmlcalculator.entity.OperationEntity;
import com.example.xmlcalculator.entity.OutputEntity;

public class XmlManagerUtil {
	
	private String dataFile;
    
	private String operationFile;
   
	private String outputFile;
	
	private DocumentBuilder db;
	
	private NodeList objectList;
	
	public XmlManagerUtil(String dataFile, String operationFile, String outputFile) {
		this.dataFile = dataFile;
		this.operationFile = operationFile;
		this.outputFile = outputFile;
	}

	public void initXmlLoader() throws ParserConfigurationException,  IOException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
        db = dbf.newDocumentBuilder();      
		
	}
	
	public XmlManagerUtil loadData() throws SAXException, IOException {
		
		Document docData = this.db.parse(new File(this.dataFile));
	         
	    docData.getDocumentElement().normalize();

	    this.objectList = docData.getElementsByTagName("city");
	    
	    return this;
	}
	
	public List<CityEntity> getDataList() {
		List<CityEntity> dataList = new ArrayList<>();
		for (int i = 0; i < this.objectList.getLength(); i++) {
            Node node = this.objectList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                dataList.add(new CityEntity(element.getAttribute("name"), 
                							Integer.parseInt(element.getAttribute("population")), 
                							Double.parseDouble(element.getElementsByTagName("area").item(0).getTextContent())));
            }
		}
		return dataList;
	}


	public XmlManagerUtil loadOperations() throws SAXException, IOException {

        Document docOperations = this.db.parse(new File(this.operationFile));
	         
        docOperations.getDocumentElement().normalize();

        this.objectList = docOperations.getElementsByTagName("operation");
        return this;
	}
	

	public List<OperationEntity> getOperationList() {
		List<OperationEntity> operationList = new ArrayList<>();
		for (int i = 0; i < this.objectList.getLength(); i++) {
            Node node = this.objectList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                operationList.add(new OperationEntity(element.getAttribute("name"), 
                							element.getAttribute("type"), 
                							element.getAttribute("func"),
                							element.getAttribute("attrib"), element.getAttribute("filter")));
            }
		}
		return operationList;
	}

	public void createResultFile(List<OutputEntity> outputOperations) throws TransformerException {
		Document document = db.newDocument();
		Element results = document.createElement("results");
        
        outputOperations.forEach(output ->{
        	// result element
            Element result = document.createElement("result");
            Attr name = document.createAttribute("name");
            name.setValue(output.getName());
            result.setAttributeNode(name);
            Attr value = document.createAttribute("value");
            value.setValue(output.getFormattedValue());
            result.setAttributeNode(value);
            results.appendChild(result);
        });
        document.appendChild(results);
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(this.outputFile));
        transformer.transform(domSource, streamResult);
    }
}
