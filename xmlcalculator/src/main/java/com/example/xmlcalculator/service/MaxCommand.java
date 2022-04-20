package com.example.xmlcalculator.service;

import java.util.List;

import com.example.xmlcalculator.entity.CityEntity;
import com.example.xmlcalculator.entity.OperationEntity;
import com.example.xmlcalculator.entity.OutputEntity;

public class MaxCommand extends Command{

	public MaxCommand(OperationEntity operation) {
		this.operation = operation;
	}

	@Override
	public OutputEntity execute(List<CityEntity> cityList) {
		double sumResult = 0;
		for(CityEntity city : cityList) {
			if(city.getName().matches(operation.getFilter()) && city.getPopulation() > sumResult) {
				sumResult = super.getValueAcordingToType(city);
			}
		}
		return new OutputEntity(operation.getName(), sumResult);
	}
	
	

}
