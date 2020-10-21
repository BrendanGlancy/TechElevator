package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes
		 *
		 * A class is a group of related components in Java - MORE TOMORROW
		 * An object is an instance of a class.
		 * String is a class, so anything defined as a string is an object
		 * OOP (Object oriented programing) - you need objects to do anything 
		 *
		 * an object| method | (parameters)
		 * System.out.print();
		 *
		 *
		 *
		 */

		/* create an new instance of String using a literal */

		// Franks notes
		String firstName = "Boris"; // created a string initialized to Boris
		String lastName = "Isakov";
		String fullName = firstName + " " + lastName;
		System.out.println("fullName is: " + fullName);



//--------------------------------------------------------------------------------------------------------		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		/* Commonly used methods:  stringname.methodname(parameters)
		 *
		 * .length() - return the number of characters in a String
		 * .charAt(index) - returns the character at the index - 0 is first character
		 * .endsWith(search-string) - return true if the String ends with the search-string 
		 * .startsWith(search-string) - return true if the String starts with the search-string
		 * .indexOf(search-string) - return the index of the start of the 1st occurrence of search-string in the String
		 * .lastIndexOf(search-string) - return the index of the start of the last occurrence of search-string in the Stri
		 * .substring(start-index) - return from the start-index to rest of String
		 * .substring(start-index,end-index) - return from the start-index to the end-index (but not the char at end-index)
		 * .toLowerCase() - return the String in all lowercase
		 * .toUpperCase() - return the String in all uppercase
		 * .trim() - return the String with spaces removed from beginning and end of the String
		 * .split(delimiter) - returns and array of strings containing the characters between the delimiter specified
		 */

		/*
		 * Java like most IDEs, has a feature called intellisense which suggest code you might want
		 * 
		 * Intellisense shows you: methodname(parameters) : return-type - Class that defines method
		 *
		 * equals(Object anObject) : boolean - String
		 *
		 * equals is a String class method that receives an Object and returns a boolean
		 * 
		 * If you click on the method - pop-up with a description of the method
		 *
		 * Every class is a member of the Object class.
		 *
		 */

		System.out.println("fullName.length() returns: " + fullName.length());
		System.out.println("fullName.charAt(0) returns: " + fullName.charAt(0)); // Displays first Character in fullName
		System.out.println("fullName.charAt(fullName.length-1) returns: " + fullName.charAt(fullName.length()-1)); // returns the last character

		System.out.println("fullName.toUpperCase() returns: " + fullName.toUpperCase()); // Converts everything to uppercase and it doesn't change
		// the original data
		// toLowerCase works in the same way, calling either doesn't change the original
		
		// you can chain methods in a single expression, usually they're chained with .methodName();
		System.out.println("fullName.startsWith(\"b\") returns: " + fullName.toLowerCase().startsWith("b"));


		// Gives the character from index[6] to the end 
		System.out.println("fullName.substring(6) returns: " + fullName.substring(6));

		// Give me the chars at index 4 thru 9 - you must specify the index after the one you want to end at
		System.out.println("fullName.substring(4, 10) returns: " + fullName.substring(4,10));

		// At what index does the delimiter ("-") start full name?
		System.out.println("fullName.indexOf(\" \") returns: " + fullName.indexOf(" "));

		// Get all the character after the delimiter (" ") in full name
		System.out.println("fullName.substring(fullName.indexOf(\" \")+1) returns: " +
							fullName.substring(fullName.indexOf(" ")+1));

		// Get all the Characters after the delimiter (" ") in full name with the delimiter?
		int indexOfSpace = fullName.indexOf(" "); // find the value of the space
		System.out.println("fullName.substring(indexOfSpace+1) returns: " + fullName.substring(indexOfSpace+1));

//--------------------------------------------------------------------------------------------------------	
		
		/*   A String may also be created easily from an array of characters (char) */

		char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' }; // Array of characters (String)
		
		String hello1 = new String(helloArray);  // Create a String using the array of characters
		String hello2 = new String(helloArray);  // Create a String using the array of characters
		
//--------------------------------------------------------------------------------------------------------			
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? 
		 * No they are not the Same object , although they do contain the same data
		 * 
		 */

		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1; // Assigning a String to a String Does Not create a new String
		// it gives a second name to original String
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}
		System.out.println("Assign the string \"Howdy\" to hello3");

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

//--------------------------------------------------------------------------------------------------------			
		System.out.println();
		System.out.println("**************************");
		System.out.println("****** USING .split ******");
		System.out.println("**************************");
		System.out.println();

		String weights = "100, 200, 300";

		String[] listOfWeights = weights.split(", "); // Create an array of elements from weight based on the ","

		for (int i = 0; i < listOfWeights.length; i++) {
			System.out.println("weight at index [" + i + "] is: " + listOfWeights[i]); // Display the current element
		}


	}
}
