package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		double length, f, m;
		Scanner keyInput = new Scanner(System.in); // Create a Scanner
		System.out.println("Please enter a length: "); // Prompt 
		length = keyInput.nextDouble(); // Read in a variable from input
		keyInput.nextLine();
		System.out.println("Is the measurement (m)eters or (f)eet?");
		String unit = keyInput.nextLine();

		// after conversion
		if (unit.equals("m")) { // if the unit is F convert from F to C
			f = length * 3.2808399;
			System.out.println(Math.round(f) + "f is " + length + "m.");
			
		} else if (unit.equals("f")) { // if the unit is C convert from C to F
			m = length * 0.3048;
			System.out.println(length + " feet is " + Math.round(m) + " meters.");
		} 


		
	}


	}


