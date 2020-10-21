package com.techelevator;

import java.util.Scanner;

/********************************************************************************
* Sample logic for converting a decimal value to a binary value
*********************************************************************************
* 1. Define an array to hold binary digits; 
*    (Define a size for the largest number of digits you expect)
* 2. Get decimal number(s) from user
* 3. Define a variable to use as an index into array of binary digits
* 4. Initialize index for binary digit array to first element
* 5. Loop to determine the binary digits in the decimal number:
*
*    (while the decimal number is not zero):
*        a. Store the remainder of the decimal number divided by 2 
*           into the current array element of binary digit array
*        b. Increment the index for accessing binary digit array
*        c. Store the quotient of the decimal number divided by 2 
*                 back into the decimal number
*  
* 5. Loop to print out the values in the binary digit array backwards.
*    (Be sure you start at the last value place in the array 
*        and not the last element IN the array)
********************************************************************************/

public class DecimalToBinary {

	public static void main(String[] args) {
		
		String binary = ""; // We store the binary as a string because the number of digits depends on the user input
		
		Scanner keyInput = new Scanner(System.in);  // Declear a new scanner
		System.out.println("Please enter a number to convert to binary: "); // Prompt
		int userInput = keyInput.nextInt(); // user input variable stored 

		if (userInput < 0) {
			System.out.println("Please enter a positive number ");
		} else if (userInput == 0){
			System.out.println("Converted to binary: 0");
		} else {
			while (userInput>0) {
				binary = (userInput%2)+ binary; // if user input has a remainder of 1 or 0 it's stored in binary string
				userInput = userInput / 2; // divide the user input in half after getting 1 digit of binary then repeat to get another
			}
			System.out.println("binary is: " + binary); // print out the converted decimal to binary

		}


		} 
		

	}


