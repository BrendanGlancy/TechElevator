package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FizzWriter {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		// Define a file Object to a disk file
		File diskFile = new File("FizzBuzz.txt");
		
		// Define a PrintWriter 
		PrintWriter outFile = null;
		
		if (diskFile.exists()) { // If the file we're trying to add already exists 
			// tell the user it will be overridden
			System.out.println(diskFile + " already exists, and will be overridden");
			outFile = new PrintWriter(diskFile);
		} else {
			// Create a new diskFile and tell the user where it is
			outFile = new PrintWriter(diskFile);
			System.out.println("New File FizzBuzz.txt has been created in:\n" + diskFile.getAbsolutePath());
		}
		
		
		for (int i = 1; i <= 300; i++) {
			
			// These are some weird conditions to whoever wrote the readme
			if (i % 3 == 0 && i % 5 == 0 || i % 10 == 3 && i / 10 == 5 || i == 35) {
				outFile.println("FizzBuzz");
			} else if (i % 3 == 0 && i % 5 != 0 && i != 35|| i % 10 == 3 || i % 100 >= 30 && i % 100 <= 39 && i != 35) {
				outFile.println("Fizz");
			} else if (i % 3 != 0 && i % 5 == 0 && i != 35 || i % 10 == 5 || i % 100 >= 50 && i % 100 <= 59 && i != 35) {
				outFile.println("Buzz");
			} else 
				outFile.println(i + "");
			}
		
			System.out.println("FizzBuzz.txt has been created.");
			
			outFile.close();
		}
		
		
	}


