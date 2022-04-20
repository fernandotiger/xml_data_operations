package com.example.xmlcalculator.entity;

public class OutputEntity {

	public String name;
	
	public Double value;

	public OutputEntity(String name, Double value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	public String getFormattedValue() {
		return String.format("%.2f", value);
	}
}
