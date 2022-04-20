package com.example.xmlcalculator.service;

import java.util.List;

import com.example.xmlcalculator.entity.CityEntity;
import com.example.xmlcalculator.entity.OperationEntity;
import com.example.xmlcalculator.entity.OutputEntity;

public abstract class Command {

	public static final String OP_ATTRIBUTE = "attrib";
	protected OperationEntity operation;
	
	public abstract OutputEntity execute(List<CityEntity> dataList);
	
	protected double getValueAcordingToType(CityEntity city) {
		if(operation.getType().equals(OP_ATTRIBUTE)) {
			return city.getPopulation().doubleValue();
		} else {
			return city.getArea();
		}
	}
}
