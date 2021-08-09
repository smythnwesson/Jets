package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.*;

public class JetsApplication {
	
	private AirField airField = new AirField();
	String fileName = "JetsList.txt";
	List<Jets> jets = airField.getJets();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetsApp1 = new JetsApplication();
		jetsApp1.launch();

	}

	public JetsApplication() {
	}

	private void launch() {
		// create a body that launches the application

		airField.loadJets();
		System.out.println("The pilots are starting their jets.");

		System.out.println("Please select an option from the menu below.");
//		JetsApplication jetsApp = new JetsApplication();
		displayUserMenu();

	}

	private void displayUserMenu() {
		// create a body that has a user menu and prompts
		// the user to select an option via scanner input
		// create a loop that allows the user to cycle through
		// the menu as many times as they wish until selecting quit
		// the application will then shut down and the jets will return
		// to the air field.
		boolean keepGoing = true;

		do {
			System.out.println("-------------------------------");
			System.out.println("1) List Fleet");
			System.out.println("2) Fly all jets");
			System.out.println("3) View fastest jet");
			System.out.println("4) View jet with longest range");
			System.out.println("5) Load the Cargo Jet");
			System.out.println("6) Dogfight!");
			System.out.println("7) Add a jet to Fleet");
			System.out.println("8) Remove a jet from Fleet");
			System.out.println("9) Quit");
			System.out.println("-------------------------------");
			int jetsMenu = sc.nextInt();

			switch (jetsMenu) {
			case 1:
				displayFleet();

				break;
			case 2:
				flyAll();
				break;
			case 3:
				fastestJet();
				break;
			case 4:
				longestRange();
				break;
			case 5:
				loadCargo();
				break;
			case 6:
				fight();
				break;
			case 7:
				addJet();
				break;
			case 8:
				removeJet();
				break;
			case 9:
				System.out.println("Jets are returning to airfield for refuel. Goodbye");
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid entry. Please try again.");
			}
		} while (keepGoing);
		sc.close();

	}

	private void displayFleet() {
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(jets.get(i));

		}
	}

	private void flyAll() {
            
		for (Jets jets2 : jets) {
			double fuelTime = (double)((int) ((jets2.getRange() / jets2.getSpeed()) * 10)) / 10;

			System.out.println(jets2.getModel() + " is flying and has " + fuelTime +
					" hours before refuel.");
			
		}

	}

	private void fastestJet() {
		double speed = 0.0;
		Jets jet = jets.get(0);
		for (Jets jets2 : jets) {
			if (jets2.getSpeed() > speed) {
				speed = jets2.getSpeed();
				jet = jets2;

			}
		}

		System.out.println(jet);
	}

	private void longestRange() {
		int range = 0;
		Jets jet = jets.get(0);
		for (Jets jets2 : jets) {
			if (jets2.getRange() > range) {
				range = jets2.getRange();
				jet = jets2;
			}
		}
		System.out.println(jet);
	}

	private void loadCargo() {
		for (Jets jets2 : jets) {
			if (jets2 instanceof CargoPlane) {
				((CargoPlane) jets2).loadCargo();
			}

		}
	}

	private void fight() {
		for (Jets jets2 : jets) {
			if (jets2 instanceof FighterJet) {
				((FighterJet) jets2).fight();
			}

		}
	}

	private void addJet() {
		System.out.println(
				"What type of jet would you like to add:\n 1) Cargo Jet \n" + " 2) Fighter Jet \n 3) Recon Jet");
		int jetType = sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter the model of the jet you wish to add: ");
		String model = sc.nextLine();
		System.out.println("What is the speed of the jet in mph: ");
		double speed = sc.nextDouble();
		System.out.println("What is the range of the jet in miles: ");
		int range = sc.nextInt();
		System.out.println("What is the price of the jet: ");
		long price = sc.nextLong();

		switch (jetType) {
		case 1:
			jets.add(new CargoPlane(model, speed, range, price));
			break;
		case 2:
			jets.add(new FighterJet(model, speed, range, price));
			break;
		case 3:
			jets.add(new ReconJet(model, speed, range, price));
			break;
		default:
			System.out.println("Invalid jet. Please select a jet from the options provided.");
			break;
		}


	}

	private void removeJet() {
		for (int i = 0; i < jets.size(); i++) {
			System.out.println((i + 1) + ". " + jets.get(i));
		}
		System.out.println("Which number jet would you like to remove? ");
		int rmv = sc.nextInt();
		jets.remove(rmv - 1);

	}
}
