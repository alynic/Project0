/**
 * Alyssa Andrade
 * Project 0 (Upgraded with Improvements)
 * May 14, 2021
 * 
 * Create a Unit Converter utilizing the minimum:
 * 		while loop
 * 		Scanner
 * 		switch
 * 
 * For improvements:
 * 		Break the input collection to a separate method
 * 		Break each unit conversion to a separate method
 * 		Instead of the user selecting their conversion directly from the first menu, have two layers of menus:
 *			Volume conversions
 *				Teaspoons to Tablespoons
 *				Teaspoons to Cups
 *				...
 *			Distance conversions
 *				Feet to Meters
 *				Miles to Kilometers
 */

package main;

import java.util.Scanner;

public class Converter {
	
	public static void main(String[] args) {
		
		boolean valid = true;		// holds value for if user wants to continue or exit
		String menuSelection;		// holds value for user input a or b
		Scanner scanner = new Scanner(System.in);
		
		//create class instance
		Converter con = new Converter();
		
		// runs while user selects 1-3; stops when 4 is entered
		while(valid) {		
			
			con.printFirstMenu();								// prints first menu options 
			menuSelection = scanner.next();						// get user input; saves into menuSelection variable
			valid = con.menuSwitch(scanner, menuSelection);		// uses user's input for first switch; saves user's second input into valid variable to check if the while loop will continue
			
		}//end while
		
		scanner.close();

	}//end main
	
	
	
	public void printFirstMenu(){
		//Print FIRST menu
		System.out.println("\nPlease select your FIRST option:\n" +
							"	a) Volume Conversions\n" +
							"	b) Distance Conversions\n" +
							"	4. Quit\n");
		System.out.print("Your FIRST option: ");
	}
	
	public boolean menuSwitch(Scanner scanner, String menuSelection) {
		boolean valid = true;
		String secondMenuSel;		// holds value for user input 1,2,4 || 1,4
		double userInput = 0;		// holds user quantity for input number
		double result = 0;			// holds user result for quantity
		
		// handles user's choice a or b
		switch(menuSelection) {
			case "a":
				printSecondMenu1();
				
				secondMenuSel = scanner.next();		// Get user input
				
				// handles user's choice between 1-4
				switch(secondMenuSel) { 
					case "1":
						convertCupsToTeaspoon(userInput, scanner, result);
						break;
					case "2":
						convertGallontoImperial(userInput, scanner, result);
						break;
					case "4":		// handles "go back to first option"
						break;
					case "5":
						printThankYou();
						valid = false;
						break;
					default:		// handles any character input
						printErrorMessage2();
						break;
				}
				break;		// stops from running case "b"
				
			case "b":
				printSecondMenu2();
				
				secondMenuSel = scanner.next();		// Get user input
				
				// runs depending on what choice user made
				switch(secondMenuSel) { 
					case "1":
						convertMilesToKilometers(userInput, scanner, result);
						break;
					case "4":		// handles "go back to first option"
						break;
					case "5":
						printThankYou();
						valid = false;
						break;
					default:		// handles any character input
						printErrorMessage2();
						break;
				}
				break;		// stops from running default
				
			case "4":
				printThankYou();
				valid = false;
				break;
				
			default:
				printErrorMessage1();
				break;
		}//end switch
		
		return valid;
	}
	
	public void printSecondMenu1() {
		//Print SECOND menu v1
		System.out.println("\nPlease select a SECOND option:\n" +
							"	1. Cups to Teaspoons\n" +
							"	2. US Gallons to Imperial Gallons\n" +
							"	4. Go back to first option\n" +
							"	5. Quit\n");
		System.out.print("\nYour SECOND option: ");
	}
	
	public void convertCupsToTeaspoon(double userInput, Scanner scanner, double result) {
		System.out.print("Please enter initial amount of cups: ");
		userInput = scanner.nextInt();
		result = userInput * 48;
		System.out.println("\n" + userInput + " Cup(s) is approximately " + result + " Teaspoon(s)\n");
	}
	
	public void convertGallontoImperial(double userInput, Scanner scanner, double result) {
		System.out.print("Please enter initial amount of US Gallons: ");
		userInput = scanner.nextInt();
		result = userInput / .832674;
		System.out.println("\n" + userInput + " US Gallon(s) is approximately " + result + " Imperial Gallon(s)\n");
	}
	
	public void printSecondMenu2() {
		//Print SECOND menu v2
		System.out.println("\nPlease select a SECOND option:\n" +
							"	1. Miles to Kilometers\n" +
							"	4. Go back to first option\n" +
							"	5. Quit");
		System.out.print("\nYour SECOND option: ");
	}
	
	public void convertMilesToKilometers(double userInput, Scanner scanner, double result) {
		System.out.print("Please enter initial amount of Miles: ");
		userInput = scanner.nextInt();
		result = userInput * 1.60934;
		System.out.println("\n" + userInput + " Mile(s) is approximately " + result + " Kilometer(s)\n");
	}
	
	public void printThankYou() {
		System.out.println("\nThank you for using this amazing converter!");
	}

	public void printErrorMessage1() {
		System.out.println("\n!!!!!Please enter letter a or b or 4 to quit!!!!!\n");
	}
	
	public void printErrorMessage2() {
		System.out.println("\n!!!!!Please enter a number between 1-5!!!!!\n");
	}

}//end class
