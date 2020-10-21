package com.techelevator.myFileProcessingCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFileProcessor {

	/*********************************************************************************
	 * This program will read each line from the numbers.txt file
	 * and write each number in the line and the sum of those numbers to a file
	 * @throws IOException 
	 *********************************************************************************/
	
	public static void main(String[] args) throws IOException {
		
		// Define a Scanner for user input
		Scanner theKeyboard = new Scanner(System.in);
		
		// Define the input file and Scanner object to read it - file is in the data folder of the project folder
		File myFile = new File("./data/numbers.txt");  // Assign a File object to numbers.txt

		// Check to be sure the File Object is assigned an existing file - terminate if not
		if (!myFile.exists() || !myFile.isFile()) {
			System.out.println("path specified is not an existing file");
			System.exit(16);   // terminate program
		}
		
		Scanner theFile = new Scanner(myFile);         // Assign the File Object to a Scanner
		
	/*********************************************************************************
	 * Define the objects necessary to write to a disk file
	 *********************************************************************************/
		File diskFile = new File("BigFile.txt"); // Define a File object to the disk file
		
		PrintWriter outFile = null;
		
		/*********************************************************************************
		 *  If the file doesn't exist then 
		 *********************************************************************************/
		
		if (diskFile.exists()) {
			 // if the output file already exists - tell the user we are adding to the end of the file
			// and define the objects to do so
			System.out.println(diskFile + " already exists - will add new data to the end of it");
			// To add to end of and existing file - append the file
			// Define a FileWriter object and tell it we want to append to the file
			
			// FileWriter(a-File-Object, boolean) - boolean-true - append, boolean-false - overwrite the file
			FileWriter aFileWriter = new FileWriter(diskFile, true);
			
			// Define a BufferedWriter for the FileWriter, you want to enable buffering for the file
			// BufferedWriter(a-File-Writer-Object)
			BufferedWriter aBufferedWriter = new BufferedWriter(aFileWriter);
			
			// Define a PrintWriter Object for the BufferedWriter
			outFile = new PrintWriter(aBufferedWriter);
		
		} else {
			outFile = new PrintWriter(diskFile); // define a PrintWriter object to use the file object
		}
		// PrintWriter will destroy any existing file associated with the file object
		
		
		
		int linesProcessed = 0;

		int lineTotal  = 0;  // hold the sum of the numbers in the line we read
		String theLine = ""; // hold the line with the numbers from the file
		
		// Loop through the file one line at a time while there are lines in the file
		while(theFile.hasNextLine()) {
			// Read a line from the file and store it in theLine
			theLine = theFile.nextLine();
			// Break the line up into separate values based on the , separating the value
			String[] theValues = theLine.split(",");
			// count the number of line processed
			linesProcessed++;
			System.out.println(linesProcessed + "/23");
			//    For each value in the line...
			for(int i=0; i < theValues.length; i++) {
				// Convert the individual value from String to numeric so we can add them
				int aValue = Integer.parseInt(theValues[i]);
				// Add each value from the line to sum
				lineTotal += aValue;
				// Display the values in the line
				outFile.println("Input Line Value[" +i+"] is: " + aValue); // Print to the disk file object instead of the system
				linesProcessed++;
				System.out.println(linesProcessed + "/23");
			}
		//    Display the sum of the values
			outFile.println("The sum of the values in the line is: " + lineTotal);
		//    Reset sum before looping again to be sure we only get the sum of the numbers in the line
		    lineTotal = 0;
		}
		// Close the file to any data still in the buffer to disk, and avoid a resource leak
		outFile.close();
		theFile.close();
		
		System.out.println("Complete");
	}
}