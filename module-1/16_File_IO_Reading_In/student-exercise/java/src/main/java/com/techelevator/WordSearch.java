package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/***************************************************************
 * This program asks the user for a search string 
 * and a filesystem path for a text file.
 * 
 * searches the file for occurrences of the search string 
 * and each time it finds a line that matches
 * it displays the line number 
 * and contents of the line it was found in on the console.
 * 
 ***************************************************************/

public class WordSearch {

	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException {
		// Define the input file and scanner object to read it
		
		
		/***************************************************************
		 * Get the file name from the user and check to see if it's valid
		 ***************************************************************/
		
		// Scan the user input for the file name
		Scanner fileScanner = new Scanner(System.in); // Scanner for file name
		System.out.println("What is the file that should be searched?"); // Prompt
		// Read in the user input
		String fileName = fileScanner.nextLine(); // Store the file name in this String
		
		File inputFile = new File(fileName);
		
		
		// Check to see if the file exist and we have the correct path name
		if (!inputFile.exists() || !(inputFile.isFile())) {
			System.out.println("path specified is not an existing file");
			System.exit(16);
		}
		
		/***************************************************************
		 * After Checking if the file name is valid
		 * 
		 * 1 Ask the user for a word to search
		 * 2 Ask the user if the search should be case sensitive
		 * 3 Read in each line of the file and split up each word
		 * 4 For each line in the file
		 * 		5 If the word we're searching for is in the line 
		 * 		6 print it with the line number
		 * 7 Close all the scanners
		 ***************************************************************/
		
		// Assign the file Object to a Scanner so we can read it in
		try (Scanner theFile = new Scanner(inputFile)) {
		
			// 1
			Scanner keySearch = new Scanner(System.in); // scanner for keyWord search
			System.out.println("What is the search word you are looking for?"); // Prompt
			// Read in the user input
			String wordToSearch = keySearch.nextLine(); // Store the word to search in this string
			
			// 2
			Scanner caseSense = new Scanner(System.in); // Scanner for case sensitive
			System.out.println("Should the search be case sensitive (Y/N)"); // Prompt
			// Read in the user input
			String yesOrNo = caseSense.nextLine(); // Store the word to search in this string
			// Check to see if the user wants a case sensitive search
			String wordToSearchUpper = ""; // empty string to hold word to search non case sensitive
			if ((yesOrNo.toUpperCase()).equals("Y")) {
				
			} else if ((yesOrNo.toUpperCase()).equals("N")) {
				wordToSearch = wordToSearch.toLowerCase();
			}
			// 3
			// while loop to read through the file one line at a time while it still has lines
			
			int lineNumber = 0; // variable to store the line number
			while (theFile.hasNextLine()) {
				lineNumber++;
				String lineFromFile = theFile.nextLine(); // read in the line from the file
				String[] words = lineFromFile.split(" "); // split each word by spaces
				
				// 4
				for (int i = 0; i < words.length; i++) {
					// 5
					if (lineFromFile.contains(wordToSearch)) {
						// 6
						System.out.println(lineNumber + ") " + lineFromFile); // if the line has the word we're searching print the line
						break;
					} else {
						break;
					}
				}
				}
			// 7
		caseSense.close();
		keySearch.close();
		}
		fileScanner.close();

	}

}
