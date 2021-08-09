package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jets;

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
		JetsApplication jetsApp2 = new JetsApplication();
		airField.loadJets();
		System.out.println("The pilots are starting their jets.");
		for (Jets jets2 : airField.getJets()) {
			System.out.println(jets2);

			
		}
		
		
		System.out.println("Please select an option from the menu below.");
//		JetsApplication jetsApp = new JetsApplication();
		jetsApp2.displayUserMenu();

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
				
				System.out.println("you pressed 1");
				
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			case 9:
				System.out.println("Goodbye");
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

}
