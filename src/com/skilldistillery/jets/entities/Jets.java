package com.skilldistillery.jets.entities;

public abstract class Jets {
private String model;
private double speed;
private int range;
private long price;

public Jets() {}

public Jets(String model, double speed, int range, long price) {
	this.model = model;
	this.speed = speed;
	this.range = range;
	this.price = price;
}

public void fly() {
	System.out.println("The jets are flying");
	//create a body to allow all jets to fly or individual jets if called.
}


public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public double getSpeed() {
	return speed;
}

public void setSpeed(double speed) {
	this.speed = speed;
}

public int getRange() {
	return range;
}

public void setRange(int range) {
	this.range = range;
}

public long getPrice() {
	return price;
}

public void setPrice(long price) {
	this.price = price;
}

@Override
public String toString() {
	return "Jets [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
}

public void fight() {
	
}

public void UAV() {
	
}





}