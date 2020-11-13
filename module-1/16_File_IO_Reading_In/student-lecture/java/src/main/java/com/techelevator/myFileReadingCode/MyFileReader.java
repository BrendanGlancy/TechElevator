package com.techelevator.myFileReadingCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/***************************************************************
 * Lecture code
 * 
 * Using the file numbers.txt
 * 
 * 100,200,150
 * 140,120,130
 * 1,2,3,4,5,6,7,8,9
 * 90,80,70,60
 ***************************************************************/

public class MyFileReader {
	
	/***************************************************************
	 * This program will read each line from the numbers.txt file and
	 * display each number in the line and the sum of the numbers
	 * 
	 * @throws FileNotFoundException
	 ***************************************************************/

	public static void main(String[] args) throws FileNotFoundException {
		// Define the input file and scanner object to read it
		// File is in the data folder of the project folder
		
	
		
		File myFile = new File("data/numbers.txt"); // Assign a File object to our numbers.txt file
		// Check to be sure the File object is assigned to an existing file
		if (!myFile.exists() || !(myFile.isFile())) {
			System.out.println("path specified is not an existing file");
			System.exit(16);
		}
		Scanner theFile = new Scanner(myFile); // Assign the file object to a scanner so we can read it

		int sum = 0; // Hold the sum of the number in the line
		String theLine = ""; // Hold the line with the numbers from the file

		/***************************************************************
		 * 1 Loop through the file one line at a time while there are lines in the file
		 * 2  Break the line up to individual values based on the comma separating the value
		 * 3  For each value inside the line ..
		 * 4    Convert the individual values from String to numerics
		 * 5    Add each value from the line to the sum
		 * 6    Display the values in the line
		 * 7  Display the sum of the values
		 * 8  Reset the sum before looping again
		 * 
		 * 9 Close the file to avoid a resource leak
		 ***************************************************************/

		
		// 1
		while(theFile.hasNextLine() ) {

			// Read a line from the file and store it in theLine
			theLine = theFile.nextLine();
			
			// 2
			String[] theValues = theLine.split(",");
			
			// 3
			for (int i = 0; i < theValues.length; i++) {
				
				// 4
				int number = Integer.parseInt(theValues[i]); // Converts to integer
				
				// 5
				sum += number; // adds each value from line to sum
				
				// 6
				System.out.println("Input Line Value[" + i + "] is: " + number); // Displays
				
			}
			
			// 7
			System.out.println("The sum of the values in the line is: " + sum); // Displays sum
			
			// 8 
			sum = 0; // reset the sum
		}
		
		// 9
		theFile.close(); // close the file

		
	}
}