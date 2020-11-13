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
		 *  A class is a group of related components in Java - MORE THIS WHOLE WEEK!
		 *  
		 *  An object is an instance of a class.
		 *  
		 *  String is a class, so anything defined as a String is an object.
		 *  
		 *  Object-Oriented Programming (OOP) - Our focus is on the object, not the process 
		 *  									We need objects to do anything
		 *  
		 *  When we code, we code:  object.method(parameters)
		 *  
		 *       an object.method(parameters)
		 *  	System.out.println("some stuff to display)
		 */

		/* create an new instance of String using a literal 
		 * 
		 *    String  name  = new String();  // create a uninitialized String - no data associated with it
		 *    
		 *    String  name  = "value:;       // create an initialized String
		 *    
		 *    String name   = "";            // create an empty string - data is empty (nothing in it)
		 * 
		 */
		String firstName = "Boris";     // Create a String initialized to Boris
		
		String lastName = "Isakov";
		
		// + may be used to concatenate Strings - defined especially for String by the String class
		
		String fullName = firstName + "-" + lastName;
		
		System.out.println("fullName is: " + fullName);
		

//--------------------------------------------------------------------------------------------------------		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		/*
		 * A member method is a method provided by a class to manipulate objects of the class
		 */
		
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

		/* Java, like most IDEs, has feature called intellisense which suggests code you might want
		 * 
		 * Intellisense shows you:  methodname(parameters) : return-type - Class that defines method
		 * 
		 *     equals(Object anObject) : boolean - String
		 *     
		 *     equals is a String class method that receives an Object and returns a boolean
		 *     
		 *     If you click on the method - pop-up with a description of the method
		 * 
		 * Every class is a member of the Object class.
		 * 
		 * 
		 */
		// position:  123456789012  - position starts at 1
		//    index:  012345678901  - index starts at 0
		// fullName - Boris Isalov
		System.out.println("fullName is: " + fullName);
		
		System.out.println("fullName.length() returns: " + fullName.length());

		System.out.println("fullName.charAt(0) returns: " + fullName.charAt(0));   // First char in fullName
		System.out.println("fullName.charAt(5) returns: " + fullName.charAt(5));   // the delimiter in fullName
		System.out.println("fullName.charAt(10) returns: " + fullName.charAt(10)); // the 2nd 'o' in fullName
		
		System.out.println("fullName.startsWith(\"b\") returns: " + fullName.startsWith("b")); 
		System.out.println("fullName.startsWith(\"B\") returns: " + fullName.startsWith("B")); 
		
		System.out.println("fullName.toUpperCase returns: " + fullName.toUpperCase()); 
		System.out.println("fullName.toLowerCase returns: " + fullName.toLowerCase()); 
		System.out.println("fullName is still: " + fullName);
		// you can chain methods in a single expression  -  toLowerCase() returns a String.anyStringMethod()
		System.out.println("fullName.startsWith(\"b\") returns: " + fullName.toLowerCase().startsWith("b"));
	
		
		// Give me the chars from index 6 to end
		System.out.println("fullName.substring(6) returns: " + fullName.substring(6));  
		
		// Give me the chars at index 6 and 7 - you must specify the index AFTER the one you want to end at
		System.out.println("fullName.substring(6,8) returns: " + fullName.substring(6,8));  
		
		// Give me the chars at index 4 thru 9 - you must specify the index AFTER the one you want to end at
		System.out.println("fullName.substring(4,10) returns: " + fullName.substring(4,10)); 
		
		// At what index does the delimiter ("-") start full name?
		System.out.println("fullName.indexOf(\"-\") returns: " + fullName.indexOf("-")); 
		
		// Get all the characters after the delimiter ("-") in full name with the delimiter?
		System.out.println("fullName.substring(fullName.indexOf(\"-\")+1) returns: " 
		                  + fullName.substring(fullName.indexOf("-")+1)); 
		
		// Get all the characters after the delimiter ("-") in full name with the delimiter?
		int indexOfDash = fullName.indexOf("-");  // Find the index of the "-"
		System.out.println("fullName.substring(indexOfDash+1) returns: " 
				          + fullName.substring(indexOfDash+1)); 
		
//--------------------------------------------------------------------------------------------------	
		
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
		 *   NO they are not the same object, although they do contain the same data
		 */

		if (hello1 == hello2) {                    // == chekcs to see if the locations are equal, not the content
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;   // Assigning a String to a Sting DOES NOT CREATE A NEW STRING
		                          //    It gives a second name to original String
								  // Both names reference the same data (contain the sameelocation)
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}
		System.out.println("Because they both contain they same location, using hello1 or hello3 is the same result...");
		System.out.println("Hello1 is: "   + hello1);
		System.out.println("Hello3 is: " + hello3);
	
		/*
		 * Because Strings are immutable, causing a new String to created when a new value is assigned 
		 * 
		 * Assigning a new value to hello1 creates a new String
		 * 
		 * hello1 and hello3 no longer contain the same reference and therefore do not return the same result
		 */
		System.out.println("\nAssign the string \"Howdy\") to hello1 and print hello1\n");
		hello1 = "Howdy";
		
		System.out.println("hello1 contains: " + hello1);
		System.out.println("hello3 contains: " + hello3);
	

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
		
		String[] listOfWeights = weights.split(",");  // Create an array of elements from weight based the ","
		
		int sumOfWeights = 0;  // Hold the sum of the weights
		
		for(int i=0; i < listOfWeights.length; i++) {    // Loop through the listOfWeights array one at a time
			System.out.println("weight at index ["+i+"] is: " + listOfWeights[i]);  // Display current element
			int weightAsInt = Integer.parseInt(listOfWeights[i].trim()); // Convert the String weight in element to an int
			                                                             //    use trim() to remove any leading or trailing spaces
			sumOfWeights = sumOfWeights + weightAsInt;
		}
		System.out.println("Sum of the weights is: " + sumOfWeights);

	}
}
