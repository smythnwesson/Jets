package com.skilldistillery.jets.entities;

public class ReconJet extends Jets implements GetIntel {

	public ReconJet() {
		super();
	}

	public ReconJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	@Override
	public void UAV() {
		System.out.println("Launching UAV, prepare to recieve intel");
	}
	

}
