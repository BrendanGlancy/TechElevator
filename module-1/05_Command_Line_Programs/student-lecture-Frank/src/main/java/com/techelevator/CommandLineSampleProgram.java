package com.techelevator;

import java.util.Scanner;

public class CommandLineSampleProgram {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Frank's Command Line Sample Program");

		// read input from the Keyboard
		// to do that we have to define a java scanner object
		// Remember your program knows what you tell it

		// System.in is an object pre-defined by Java to represent the keyboard

		System.out.println("Type some text here: "); // Frank says this is for the human beings out there
		Scanner theKeyboard = new Scanner(System.in); // Create a Scanner to interact with System.in
		// Scanner is named because it scans the keyboard and returns the values to the program
		String aLine = ""; // hold a line of input from the keyboard

		aLine = theKeyboard.nextLine(); // get a line from the keyboard, you have to store the keyboard input in a varible
		System.out.println("The line you entered was: " + aLine); // displays the line entered


		System.out.println("Enter a number: "); // Prompt
		int aNumber = theKeyboard.nextInt(); // Captures a number from input and stores it as an int
		System.out.println("You entered the number: " + aNumber + "\nThe number times 2: " + (aNumber * 2)); // returns your number and 2x your number

		System.out.println("Please enter another number: ");
		aNumber = theKeyboard.nextInt(); // Captures a number from input and stores it as an int
		System.out.println("You entered the number: " + aNumber + "\nThe number times 2: " + (aNumber * 2));

		// The next scanner does not let us enter any input, Frank wants us to notice this
		// The problem here is that: when you type in a line in a keyboard and press enter
		// the enter key is converted to a new line character, scanner scans the keyboard for characters
		// until it sees a new line character (enter), returns all the characters up to but not including
		// the new line character, (enter)
		// the .nextLine() method removes the new-line left in the keyboard, but .nextInt leaves the next-line in
		// the keyboard, its there next time it scans. 
		// ALL the .nextX() methods do the same thing as nextInt
		// If the new-line is in the keyboard when you call nextLine, scanner sees the new-line and STOPS, returning null
		// You need to clear the keyboard before you do a nextLine() after any nextX() 
		// The easiest way to do it, do nextLine() and don't store the value

		theKeyboard.nextLine(); // clears any new line left in the buffer

		System.out.println("Enter more text here: "); // Frank says this is for the human beings out there
		aLine = theKeyboard.nextLine(); // get a line from the keyboard, you have to store the keyboard input in a varible
		System.out.println("The line you entered was: " + aLine); // displays the line entered

		// Ask the user to enter a series of numbers one at a time or the word "end" to stop
		// Sum and print the sum when they want to stop

		do {
			System.out.println("Please enter a number of end to stop: ");
			aLine = theKeyboard.nextLine();
		}

		int sum = 0;

		while(true) {
			if (aLine == "end") {
				break; // breaks out of loop 
			}
			sum = sum + Integer.parseInt(aLine);
		}
		System.out.println("The sum of the numbers is: " + sum);
	}

}
