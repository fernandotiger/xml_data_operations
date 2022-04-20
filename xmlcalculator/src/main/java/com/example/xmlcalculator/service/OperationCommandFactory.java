package com.example.xmlcalculator.service;

import com.example.xmlcalculator.entity.OperationEntity;

public class OperationCommandFactory {

	public static Command getCommand(OperationEntity operation) {
		switch (operation.getFunc()) {
		case "average":
			return new AverageCommand(operation);
		case "sum":
			return new SumCommand(operation);
		case "min":
			return new MinCommand(operation);
		case "max":
			return new MaxCommand(operation);
		default:
			return null;
		}
	}
}
