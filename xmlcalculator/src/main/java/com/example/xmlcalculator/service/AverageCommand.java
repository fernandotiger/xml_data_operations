package com.example.xmlcalculator.service;

import java.util.List;

import com.example.xmlcalculator.entity.CityEntity;
import com.example.xmlcalculator.entity.OperationEntity;
import com.example.xmlcalculator.entity.OutputEntity;

public class AverageCommand extends Command{

	public AverageCommand(OperationEntity operation) {
		this.operation = operation;
	}

	@Override
	public OutputEntity execute(List<CityEntity> cityList) {
		double sumResult  = 0d;
		int filteredListSize = 0;
		for(CityEntity city : cityList) {
			if(city.getName().matches(operation.getFilter())) {
				sumResult+= super.getValueAcordingToType(city);
				filteredListSize++;
			}
		}
		filteredListSize = filteredListSize == 0 ? 1 : filteredListSize;
		return new OutputEntity(operation.getName(), (sumResult / filteredListSize));
	}
	
	

}
