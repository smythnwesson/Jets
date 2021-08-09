package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jets> jetFleet = new ArrayList<>();

	public AirField() {}

	public void loadJets() {
		try {
			FileReader fr = new FileReader("JetsList.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			while ((line = br.readLine()) != null) {
				String [] pieces = line.split(",");
				Jets allJets = null;
				if(pieces[0].equals("FighterJet")) {
					allJets = new FighterJet(pieces[1], Double.parseDouble(pieces[2]),
							Integer.parseInt(pieces[3]), Long.parseLong(pieces[4]));
				}
				else if(pieces[0].equals("Cargo")) {
					allJets = new CargoPlane(pieces[1], Double.parseDouble(pieces[2]),
							Integer.parseInt(pieces[3]), Long.parseLong(pieces[4]));
				}
				
				else if(pieces[0].equals("UAV")) {
					allJets = new ReconJet(pieces[1], Double.parseDouble(pieces[2]),
							Integer.parseInt(pieces[3]), Long.parseLong(pieces[4]));
				}
				jetFleet.add(allJets);
			}
			br.close();
			
				
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.err.println("Problem while reading " + "JetsList.txt" + ": " + e.getMessage());
			return;
		}
	}

	public List<Jets> getJets() {
		return jetFleet;
	}

	public void setJets(List<Jets> jets) {
		this.jetFleet = jets;
	}

	@Override
	public String toString() {
		return "AirField [jets=" + jetFleet + "]";
	}

}
