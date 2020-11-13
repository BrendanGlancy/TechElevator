package com.techelevator.myFileReadingCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {

	/*********************************************************************************
	 * This program will read each line from the numbers.txt file
	 * and display each number in the line and the sum of those numbers
	 * @throws FileNotFoundException 
	 *********************************************************************************/
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// Define the input file and Scanner object to read it - file is in the data folder of the project folder
		File myFile = new File("./data/numbers.txt");  // Assign a File object to numbers.txt

		// Check to be sure the File Object is assigned an existing file - terminate if not
		if (!myFile.exists() || !myFile.isFile()) {
			System.out.println("path specified is not an existing file");
			System.exit(16);   // terminate program
		}
		
		Scanner theFile = new Scanner(myFile);         // Assign the File Object to a Scanner
		
		int lineTotal  = 0;  // hold the sum of the numbers in the line we read
		String theLine = ""; // hold the line with the numbers from the file
		
		// Loop through the file one line at a time while there are lines in the file
		while(theFile.hasNextLine()) {
			// Read a line from the file and store it in theLine
			theLine = theFile.nextLine();
			// Break the line up into separate values based on the , separating the value
			String[] theValues = theLine.split(",");
			//    For each value in the line...
			for(int i=0; i < theValues.length; i++) {
				// Convert the individual value from String to numeric so we can add them
				int aValue = Integer.parseInt(theValues[i]);
				// Add each value from the line to sum
				lineTotal += aValue;
				// Display the values in the line
				System.out.println("Input Line Value[" +i+"] is: " + aValue);
			}
		//    Display the sum of the values
			System.out.println("The sum of the values in the line is: " + lineTotal);
		//    Reset sum before looping again to be sure we only get the sum of the numbers in the line
		    lineTotal = 0;
		}
		// Close the file to avoid a resource leak
		theFile.close();
	}
}