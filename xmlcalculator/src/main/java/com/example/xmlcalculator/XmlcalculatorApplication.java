package com.example.xmlcalculator;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import com.example.xmlcalculator.entity.CityEntity;
import com.example.xmlcalculator.entity.OperationEntity;
import com.example.xmlcalculator.entity.OutputEntity;
import com.example.xmlcalculator.service.ProcessOperation;
import com.example.xmlcalculator.util.XmlManagerUtil;

@SpringBootApplication
public class XmlcalculatorApplication {

	public static void main(String[] args) {
		
		
		XmlManagerUtil loader = new XmlManagerUtil(args[0], args[1], args[2]);
		//XmlManagerUtil loader = new XmlManagerUtil("x:\\xxxx\\xxxx\\_data.xml", "x:\\xxxx\\xxxx\\operations.xml", "x:\\xxxx\\xxxx\\output.xml");
		try {
			loader.initXmlLoader();
			List<CityEntity> dataList = loader.loadData().getDataList();
			List<OperationEntity> operationList = loader.loadOperations().getOperationList();
			
			ProcessOperation processOperation = new ProcessOperation(operationList);
			
			List<OutputEntity> outputOperations = processOperation.executeOperations(dataList);
			showResultInConsole(outputOperations);
			loader.createResultFile(outputOperations);
			
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		
	}

	private static void showResultInConsole(List<OutputEntity> outputOperations) {
		System.out.println("");
		outputOperations.forEach(result -> {
			if(result != null) {
				System.out.println(result.getName() + "  --   "+result.getFormattedValue());
			}
		});
	}

}
