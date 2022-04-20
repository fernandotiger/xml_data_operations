package com.example.xmlcalculator.service;

import java.util.List;

import com.example.xmlcalculator.entity.CityEntity;
import com.example.xmlcalculator.entity.OperationEntity;
import com.example.xmlcalculator.entity.OutputEntity;

public class MinCommand extends Command{

	
	public MinCommand(OperationEntity operation) {
		super.operation = operation;
	}

	@Override
	public OutputEntity execute(List<CityEntity> cityList) {
		double sumResult = cityList.get(0).getArea();
		for(CityEntity city : cityList) {
			if(city.getName().matches(operation.getFilter()) && city.getArea() < sumResult) {
				sumResult = super.getValueAcordingToType(city);
			}
		}
		return new OutputEntity(operation.getName(), sumResult);
	}
	
	

}
