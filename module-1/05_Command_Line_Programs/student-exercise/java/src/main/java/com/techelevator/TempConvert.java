package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner keyInput = new Scanner(System.in); // Create a Scanner
		System.out.println("Please enter a Temperature: "); // Prompt 
		double temp = keyInput.nextDouble(); // Read in a variable from input
		keyInput.nextLine();
		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String unit = keyInput.nextLine();

		// after conversion
		if (unit.equals("F")) { // if the unit is F convert from F to C
			double Tc = 0;
			Tc = (temp - 32) / 1.8;
			
			System.out.println(temp + "F is " + Math.round(Tc) + "C");
		} else if (unit.equals("C")) { // if the unit is C convert from C to F
			double Tf = 0;
			Tf = temp * 1.8 + 32;
			
			System.out.println(Math.round(Tf) + "F is " + temp + "C"); // Print the Rounded Temp
		} 


		
	}

}
