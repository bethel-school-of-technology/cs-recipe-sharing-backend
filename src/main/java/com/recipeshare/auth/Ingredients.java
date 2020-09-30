package com.recipeshare.auth;

public class Ingredients {

    private String name;
    private Integer amount;
    private String measurement;

    public void newIngredient(String name, Integer amount, String measurement) {
        this.name = name;
        this.amount = amount;
        this.measurement = measurement;
    }

    public String getName() {
        return name;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }
    

		
	
	}
