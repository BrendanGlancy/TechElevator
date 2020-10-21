package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program"); 

		int score1 = 10;
		int score2 = 20;
		int score3 = 50;

		int sum = 0;
		double avg = 0;

		sum = score1 + score2 + score3;
		

		// Code "tightly coupled" - when the data changes we have to change the code 
		// To still correct
		// "Tightly coupled" code can be hard to change
		// Were going to use arrays to make our code independent of the data


		// ------------------------------------------------------------------------------------------

		// The code below is "loosely coupled" a change to the data DOES NOT require a change to a code
		// making the program more flexible and easier to change

		int[] scores = {10, 20, 50, 67, 124, 87}; // define and initialize an array at the same time
		// # elements is determined by the number of values
		// you would use this technique above if you knew the values 
		// you will initalize arrays both ways, "be aware of that" 
		// go through the array one element at a time adding each element to sum
		// we can use a for loop to iterate through the array

		// inside the loop use the loop varible as the index for the array we are going through

		
		sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum = sum + scores[i]; // the loop variable is use to control the loop, for an array you initalize it to 0
		} // loop-variable is used to control the loop - gor an array initialize to - to start at the beginning 
	
		avg = sum / 3;

		System.out.println("The sum of the numbers is " + sum);
		System.out.printf("The average of the numbers is %.1f", avg);
	} // loop-condition - loop as long as condition is true - for array loop-var < array.lenght loop-var goes from 0 to last valid index
   
}