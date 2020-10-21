package com.techelevator;

import java.util.Scanner;

/*********************************************************************
 * Sample logic for Fibonacci problem
 **********************************************************************
* 1. Get the upper limit for the sequence from the user.
* 2. Define a variable to hold the previously processed loop value
* 3. Display a zero which is always the first number in the sequence
* 4. Loop from 1 to the limit value 
*    (the for loop variable is the current loop value)
*    (NOTE:  DO NOT CODE AN INCREMENT IN THE for STATEMENT  
*     e.g. for (init; condition;)
*    a. Display the current loop value 
*       (you may need to include a ' , ' somewhere too)
*    b. Create a variable to hold the sum of the current loop value 
*              and the previous loop value
*    c. Remember the current loop value in the variable 
*              that is holding the previously processed loop value
*    d. Set the loop variable to the sum of the 
*              previous loop value + current loop value (step b)
***********************************************************************/

public class Fibonacci {

	public static void main(String[] args) {

		int entFib, first = 0, second = 1; // initialize the user input and first two numbers in the Fibonacci Sequence
		Scanner fibNum = new Scanner(System.in);
		System.out.println("Please enter the Fibonacci Number: "); // Prompt 
		entFib = fibNum.nextInt(); 
		

		
		
		while (first<=entFib) { // While the number we are on is still smaller than the user input
			if (first * 1.5 > entFib) { // This should remove the extra comma at the end of the loop 
				System.out.print(first+" "); // Prints the numbers up to user input
			} else if (first <= entFib) {
				System.out.print(first+", "); // Prints the numbers up to user input
			}
			
			int sumOfTwo = first + second; // add the first two numbers
			first = second; // first number = second 
			second = sumOfTwo; // second is the sum of the first two 
			
		}

		

	}

}
