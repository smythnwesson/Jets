package com.skilldistillery.jets.entities;

public class CargoPlane extends Jets implements LoadCargo{

	public CargoPlane() {
		super();
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	

	@Override
	public void loadCargo() {
		System.out.println("Loading all cargo on: " + this.getModel());
		
	}
}
		
	

	
