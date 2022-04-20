package com.example.xmlcalculator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.xmlcalculator.entity.CityEntity;
import com.example.xmlcalculator.entity.OperationEntity;
import com.example.xmlcalculator.entity.OutputEntity;

public class ProcessOperation {

	private List<OperationEntity> operationList;
	
	private List<Command> commandList;
	
	public ProcessOperation(List<OperationEntity> operationList) {
		this.operationList = operationList;
	}
	
	private void loadCommandsFromOperations() {
		this.commandList = new ArrayList<>();
		
		this.operationList.forEach(operation -> this.commandList.add(OperationCommandFactory.getCommand(operation)));
	}
	
	public List<OutputEntity> executeOperations(List<CityEntity> dataList){
		if(Objects.isNull(this.commandList)) {
			loadCommandsFromOperations();
		}
		List<OutputEntity> outputList = new ArrayList<>();
		
		commandList.forEach(command -> outputList.add(command.execute(dataList)));
		
		return outputList;
	}
	
	
}
