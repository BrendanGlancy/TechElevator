package com.techelevator.frank;

import java.io.FileNotFoundException;  // include the code to support FileNotFoundExecption
import java.time.LocalDateTime;        // include the code to support LocalDateTime

public class HobbyCollectionApp {

	// Because this program is using something that does File I/O (CollectionOfThings() ctor
	// It needs to either catch the File I/O exceptions
	//                 or use a throws statement acknowledges I know I am using something that can cause an exception
	public static void main(String[] args) throws FileNotFoundException  {
		 
		System.out.println("Welcome to My Hobby Collection Program!");
		
		// Use LocalDateTime.now() to get the current date and time to millisecond
		// Use LocalDate.now() to get the current date
		// Use LocalTime.now() to get the time to millisecond

		System.out.println("You started it on: " + LocalDateTime.now());
		
		// Instantiate a default CollectionOfThings object
		CollectionOfThings myCollection = new CollectionOfThings(); // run the CollectionOfThings ctor IT does File I/O
		
		// Display the contents of the CollectionOfThings object 
		myCollection.displayCollection();
	
		// Added to demonstrate why we need a toString() method for our classes
		System.out.println("\nMy collection contains: " + myCollection);
		                                             // + (concatenation) needs a String
		                                             // myCollection is NOT a String its a CollectOfThings
		                                             // It looks for a toString() in CollectionOfThings
		                                             //     there is not a toString() method in ColloectionOfThings
		                                             //     so it uses the Object class toString()
		
		System.out.println("\nI Hope you enjoyed My Hobby Collection Program!");
		System.out.println("You ended it on: " + LocalDateTime.now());
	}
}
