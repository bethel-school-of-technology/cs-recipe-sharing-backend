package com.receipeshare.controllers;

public class Ingredients {
	
	private String name;
	private Integer amount;
	private String measurement;
	
	public void addNewIngredient(String name, Integer amount, String measurement) {
		this.name = name;
		this.amount = amount;
		this.measurement = measurement;
	}
	
	public String getName() {
		return name;
	}
	public void setIngredient(String name) {
		this.name = name;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getMeasurement() {
		return measurement;
	}
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	
	

}
