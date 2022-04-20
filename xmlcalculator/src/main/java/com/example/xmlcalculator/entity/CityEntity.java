package com.example.xmlcalculator.entity;

public class CityEntity {

	private String name;
	
	private Integer population;
	
	private Double area;

	public CityEntity(String name, Integer population, Double area) {
		this.name = name;
		this.population = population;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}
	
	
}
