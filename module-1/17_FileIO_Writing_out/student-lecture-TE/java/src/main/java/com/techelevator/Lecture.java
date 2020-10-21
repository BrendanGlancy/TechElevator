package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.print("Enter the path of a file or directory >>> ");
		String path = userInput.nextLine();
		File f = new File(path);

		/*
		 * The File class allows us to inspect various attributes of a file system object
		 */

		/* ***************************
		 * INSPECTING THE FILESYSTEM
		 * ***************************/

		System.out.println();
		if (f.exists()) { // returns true if a file or directory exists at the file system location, otherwise returns false
			System.out.println("name: " + f.getName());
			System.out.println("absolutePath: " + f.getAbsolutePath());
			if (f.isDirectory()) {
				System.out.println("type: directory");
			} else if (f.isFile()) {
				System.out.println("type: file");
			}
			System.out.println("size : " + f.length());
		} else {
			System.out.println(f.getAbsolutePath() + " does not exist.");
		}

		/*
		 * The File class also allows us to manipulate file system objects
		 * */

		/* ************************
		 * CREATING A DIRECTORY
		 * ************************/

		System.out.println();
		System.out.println("Let's create a new directory.");
		System.out.print("Enter the path of the new directory >>> ");
		path = userInput.nextLine();
		File newDirectory = new File(path);

		if (newDirectory.exists()) {
			System.out.println("Sorry, " + newDirectory.getAbsolutePath() + " already exists.");
			System.exit(1);
		} else {
			if (newDirectory.mkdir()) {
				System.out.println("New directory created at " + newDirectory.getAbsolutePath());
			} else {
				System.out.println("Could not create directory.");
				System.exit(1);
			}
		}

		/* ************************
		 * CREATING A FILE
		 * ************************/

		System.out.println();
		System.out.println("Now let's put a file in the directory.");
		System.out.print("Enter a name for the new file >>> ");
		String fileName = userInput.nextLine();
		File newFile = new File(newDirectory, fileName); // Give file ctor the folder and filename to associate the file object with
		// if the directory is ommitted, the default directory is the one you're in  

		newFile.createNewFile();
		System.out.println();
		System.out.println("name: " + newFile.getName());
		System.out.println("absolutePath: " + newFile.getAbsolutePath());
		System.out.println("size : " + newFile.length());

		/* ************************
		 * WRITING TO A FILE
		 * ************************/

		System.out.println();
		System.out.println("Now let's write something in the new file.");
		System.out.print("Enter a message to be stored in the new file >>> ");
		String message = userInput.nextLine();

		try (PrintWriter writer = new PrintWriter(newFile)) {
			writer.println(message);
		} // When we exit the try block, this cause the file to be closed and an automatic flush of the buffer to trigger

		System.out.println();
		System.out.println("name: " + newFile.getName());
		System.out.println("absolutePath: " + newFile.getAbsolutePath());
		System.out.println("size : " + newFile.length());

	}

}
