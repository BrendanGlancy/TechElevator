package com.techelevator;

import java.util.Scanner;  // Include the code to support Scanner objects

public class CommandLineSampleProgram {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Frank's Command Line Sample Program");
		
		// Read input from the keyboard
		
		// Define a Java Scanner object to represent the keyboard in the program
		// System.in is an object pre-defined by Java to represent the keyboard
		// Scanner - scan the keyboard input and return values to the program 
			
		Scanner theKeyboard = new Scanner(System.in);  // Create a Scanner to interact with System.in
		
		String aLine = "";     // Hold a line of input from the keyboard
		
		System.out.print("\nPlease enter a line a press enter: ");  // prompt the user to enter something in the keyboard
		aLine = theKeyboard.nextLine();                           // Get a line from the keyboard and store it in our aLine variable
		System.out.println("The line you entered was: " + aLine); // Display the line they entered
	
		System.out.println("\nPlease enter a number: " );
		int aNumber = theKeyboard.nextInt();  // Get a number from the keyboard and store it in aNumber
		System.out.print("You entered the number: " + aNumber + " Twice that is: " + aNumber * 2);
	
		System.out.println("\nPlease enter another number: " );
		aNumber = theKeyboard.nextInt();  // Get a number from the keyboard and store it in aNumber
		System.out.print("You entered the number: " + aNumber + " Twice that is: " + aNumber * 2);
		
		// When you type a line in the keyboard and press enter
		//    the enter key is converted to new-line character
		// Scanner scans the keyboard for characters until it sees a new-line character (enter)
		//    returns all the characters up to but not including the new-line
		// .nextLine() - removes the new-line left in the keyboard
		// .nextInt()  - leaves the enter in the keyboard, so it's there the next time Scanner scans
		//               all the .nextXxxxx (numeric nexts do the same thing)
		// if the new-line is in the keyboard when you do nextLine() and .nextXxxxx (any numeric)
		//    Scanner sees the new-line and stops - returns nothing to the program
		// You need to clear the keyboard before you do a nextLine() after a nextXxxxx (any numeric)
		//    the easiest way to clear the new-line from the keyboard is do nextLine() and don't store the value
		
		theKeyboard.nextLine(); // Clear any new-line left in the buffer
		
		System.out.print("\nPlease enter another line a press enter: ");  // prompt the user to enter something in the keyboard
		aLine = theKeyboard.nextLine();                           // Get a line from the keyboard and store it in our aLine variable
		System.out.println("The line you entered was: " + aLine); // Display the line they entered
	
		// Ask the user to enter a series of numbers one at time or the word "end" to stop
		// sum and print the sum when they want to stop
		// Loop asking the user for input until they enter the word "end"

		int sum = 0; // hold the sum of the numbers
		
		while(true) {   // Loop forever - we will decide when to break out of loop
			System.out.println("Please enter a number o2 end to stop:");  // Asking for a number or a string
			aLine = theKeyboard.nextLine();  // Get a line from the keyboard

			if(aLine.equals("end")) {  // Because Strings are special we need a special to compare them 
				break;     // break out of the loop
			}
			sum = sum + Integer.parseInt(aLine); // convert the String the user entered to an int
			                                     //     and add the number the user entered to sum	
		}
		System.out.println("The sum or the numbers is: " + sum);
		
		//-----------------------------------------------------------------------------------
		// Another technique to: 
		// Ask the user to enter a series of numbers one at time or the word "end" to stop
		// sum and print the sum when they want to stop
		// Loop asking the user for input until they enter the word "end"
		
		sum = 0; // hold the sum of the numbers
		
		System.out.println("\n\n-------- Running Another Technique to loop until user wants to end-------\n");
		
		System.out.println("Please enter a number or end to stop:");  // Asking for a number or a string
		aLine = theKeyboard.nextLine();  // Get a line from the keyboard
		
		while(!aLine.equals("end")) {   // Loop forever - we will decide when to break out of loop
			sum = sum + Integer.parseInt(aLine); // convert the String the user entered to an int
			                                     //     and add the number the user entered to sum	
			System.out.println("Please enter a number of end to stop:");  // Asking for a number or a string
			aLine = theKeyboard.nextLine();      // Get a line from the keyboard
		}
		System.out.println("The sum of the numbers is: " + sum);
	
	
	System.out.println("\n\nThank you for participating in our little example"); // End graciously
	}
	}
