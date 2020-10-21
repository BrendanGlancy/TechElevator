package com.techelevator;

public class IntroToClassesCard {
	
	//*****************************************************************************
	// main() is the starting method of all applications
	//
	// The class that contains main() is the application
	//*****************************************************************************
	
	public static void main(String[] args) {
        
        /*
         *  This program will demonstrate several concepts presented in the Java Cohort
		 *  in the topic Introduction to Classes 		
        */
		
		System.out.println("Executing: PlayingCard aCard = new PlayingCard();\n");
		
		PlayingCard aCard = new PlayingCard();   // Instantiate a default PlayingCard
		                                         // Default (0-arg) ctor is run

		aCard.showCard();                        // Use the PlayingCard object to run the ShowCard() method
		
		System.out.println("-----------------------------------------------------------------------------------");
		
		System.out.println("Executing: PlayingCard theCard = new PlayingCard(8,Spades,Green,true);\n");
		
		PlayingCard theCard = new PlayingCard(8,"Spades","Green",true);   // Instantiate a new PlayingCard 
		                                                                  // using the 4-arg ctor
		
		theCard.showCard();                       // Use the PlayingCard object to run the ShowCard() method
		
		System.out.println("-----------------------------------------------------------------------------------");
		
		System.out.println("Executing: PlayingCard myCard = new PlayingCard(1,Spades);\n");
		
		PlayingCard myCard = new PlayingCard(1,"Spades");         // Instantiate a new PlayingCard 
		
		myCard.showCard();                       // Use the PlayingCard object to run the ShowCard() method                                                // using the 2-arg ctor

        System.out.println("-----------------------------------------------------------------------------------");
		
        System.out.println("Executing: PlayingCard myCard = new PlayingCard(14,Diamonds);\n");
		
		PlayingCard yourCard = new PlayingCard(14,"Diamonds");    // Instantiate a new PlayingCard with invalid value
                                                                  // using the 2-arg ctor

        yourCard.showCard();                       // Use the PlayingCard object to run the ShowCard() method

        System.out.println("-----------------------------------------------------------------------------------");
        
        System.out.println("myCard's value is: " + myCard.getValue());    // Use the PlayingCard method to retrieve 
		                                                                  //     the card value in the object
		
		System.out.println("-----------------------------------------------------------------------------------");

		// Determine if card value makes it a face card
		// Using a member method of PlayingCard
				
		System.out.println("Card value is: " + myCard.getValue() + " which means face card is " + myCard.isFaceCard());
		System.out.println("Changing card value to 13");
		myCard.setValue(13);
		System.out.println("Card value is: " + myCard.getValue() + " which means face card is " + myCard.isFaceCard());
			
		System.out.println("-----------------------------------------------------------------------------------");

		// Flip the card - if it's face up it should be made face down and vice-versa
		// Using a member method of PlayingCard
		
		System.out.println("   Right now, Is the card face up? " + theCard.isShowing());
		theCard.flip();          // run the flip() method on a PlayingCard object
		System.out.println("After flip(), Is the card face up? " + theCard.isShowing());
		
		System.out.println("-----------------------------------------------------------------------------------");

		// Find out if two cards are equal
		// two cards are equal when all attributes are the same, or all attributes except whether they faceUp/down

		PlayingCard codyCard = new PlayingCard();
		PlayingCard sethCard = new PlayingCard();
	
		
		
	}
}
		 

