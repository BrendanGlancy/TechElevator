package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program"); 

		int score1 = 10;
		int score2 = 20;
		int score3 = 50;
	    int score4 = 67; // added another score
		
		int sum = 0;
		double avg = 0;
		
		// Code is "tightly coupled" - when data changes we have to change code 
		//      to still correct
		// "tightly coupled" code can be hard to change
		
		sum = score1 + score2 + score3 + score4; // need to update when data changes
		avg = sum / 4;                           // need to update when data changes
		
		System.out.println("The sum of the numbers is " + sum);
		System.out.printf("The average of the numbers is %.1f\n", avg);
	//------------------------------------------------------------------------------------
		
		// This code is "loosely coupled" a change to the data DOES NOT require a change to code
		// making the program more flexible and easier to change
		
		
		int[] scores = {10, 20, 50,67, 124, 87};  // Define and initialize an array at the same time
	                                              // # elements is determined by the number of values
		/* alternate coding solution
		int numberElements = 6;
		int[] scores = new int[numberElements];       // 6-element array initializing elements to 0
		
		scores[0] = 10;
		scores[1] = 20;
		scores[2] = 50;
		scores[3] = 67;	 
		scores[4] = 124;
		scores[5] = 67;
		*/
		// add up the scores and place them in variable sum
		
		// go through the array one element at a time adding each element to sum
		
		// We can use a for-loop to iterate through the array - go through one at at a time
		
		// for (loop-variable=initial-value; loop-condition; increment) {}
		//
		//    loop-variable is used control the loop - for an array initialize to 0 to start at beginning
		//
		//    loop-condition - loop as long as condition is true - for array loop-var < array.length
		//                                                         loop-var goes from 0 to last valid index
		//
		//    increment - be done at the end of each loop - for an array it add 1 to loop variable
		//
		//    inside the loop us loop variable as the index for the array
		
		sum = 0;   // reset sum to 0 in case it already has a value in it
		//                    
		for (int i=0; i < scores.length; i++) {  // i=0, 1, 2, 3, 4 - stop before loop when its 4
			sum = sum + scores[i];               // scores[0], scores[1], scores[2], scores[3]
		}
		
		avg = sum / scores.length;      // divide by the number of elements in the array   
		
		System.out.println("The sum of the numbers is " + sum);
		System.out.printf("The average of the numbers is %.1f", avg);
	//----------------------------------------------------------------------------------------------------
	}   
   
}