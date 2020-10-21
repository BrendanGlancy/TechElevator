package com.techelevator;

public class IntroToClassesCard {
        //------------------------------------------------------------------------------------------------------------
        // Application program main() for the Intro To Classes App
        //------------------------------------------------------------------------------------------------------------
        public static void main(String[] args) {
        /*
        *  This program will demonstrate several concepts presented in the Java cohort
        *  in the topic Introduction to Classes 	
        *  
        *  This is the application program that will instantiate and manipulate objects of our class
        *  to do some actual work	
        */
        // instantiate a PlayingCard object
        // Class name = new Class();
        //                          constructor() 	
        	PlayingCard aCard = new PlayingCard();    // create an instance of a PlayingCard
        	                                          // using the default constructor 
        	
        	System.out.println("aCard is: " + aCard); // Display our PlayingCard object
//                                          + PlayingCard object - + requires a String to concatenate
//                                                                 it doesn't know what to do with a PlayingCard object
//                                                                 is there a way available to convert a PlayingCard to a String?
//                                                                       Yes - using the PlayingCard class toString() method
//                                          + String - created using the PlayingCard and the Object class toString()
//                                                     PlayingCard class toString() returns a String containing:
//                                                            the values in the member data with descriptive phrase

// Create a queen of hearts that is face up - use the 4-arg ctor available in the class
        PlayingCard jessCard = new PlayingCard(12, "Hearts", "Red", true);
        System.out.println("jessCard is: " + jessCard);
        
// As a user, I would like to be able to get the individual values in the object
        
        System.out.println("jessCard value is: " + jessCard.getCardValue());System.out.println("jessCard value is: " + jessCard.getCardValue());
        System.out.println("jessCard suitis: " + jessCard.getCardSuit());
        System.out.println("jessCard is: " + jessCard.isFaceUp());

// Create a 3 diamonds which is red
        PlayingCard anotherCard = new PlayingCard();  // Instantiate a default PlayingCard
        anotherCard.setCardValue(3);                  // Change value
        anotherCard.setCardSuit("Diamonds");          // Change suit
        anotherCard.setCardColor("Red");              // Change color
        
        System.out.println("another card is: " + anotherCard);
        }
        
}
		 

