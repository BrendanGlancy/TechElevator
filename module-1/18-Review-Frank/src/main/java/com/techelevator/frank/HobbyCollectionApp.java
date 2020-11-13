package com.techelevator.frank;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class HobbyCollectionApp {

	public static void main(String[] args) throws FileNotFoundException {
		 
		System.out.println("Welcome to My Hobby Collection Program!");
		System.out.println("You started it on: " + LocalDateTime.now());
		
		CollectionOfThings myCollection = new CollectionOfThings();
		
		myCollection.displayCollection();
		
		System.out.println("\nI Hope you enjoyed My Hobby Collection Program!");
		System.out.println("You ended it on: " + LocalDateTime.now());
	}
}
