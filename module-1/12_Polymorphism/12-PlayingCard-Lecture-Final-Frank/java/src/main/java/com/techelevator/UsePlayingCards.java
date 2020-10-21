package com.techelevator;

public class UsePlayingCards {

	public static void main(String[] args) {
		
		/******************************************************************************************************
		 * Review concepts of Inheritance
		 * 
		 * Polymorphism examples near the bottom of this code
		 ******************************************************************************************************/
		
		PlayingCard aCard = new PlayingCard(1,"Spades", "Black");
		aCard.showCard();    // PlayingCardObject.showCard() - runs the showCard() in PlayingCard class 
		
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");
		System.out.println("aUSACard is :");
		aUSACard.showCard();  // AmericanPlayingCardObject.showCard() - runs the showCard() in AmericanPlayingCard class

		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES");
		System.out.println("aUSACard2 is :" );
		aUSACard2.showCard();
		
		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES");
		System.out.println("aUSACard3 is :");
		aUSACard3.showCard();
			
		AmericanPlayingCard aUSACard4 = new AmericanPlayingCard(11, "JASON");
		System.out.println("aUSACard4 is :");
		aUSACard4.showCard();
		
		ItalianPlayingCard anItalianCard1 = new ItalianPlayingCard(13, "SWORDS");
		System.out.println("anItalianCard1 is :");
		anItalianCard1.showCard(); // ItalianPlayingCardObject.showCard() - runs the showCard() in ItalianPlayingCard class
		
		ItalianPlayingCard anItalianCard2 = new ItalianPlayingCard(9, "COINS");
		System.out.println("anItalianCard2 is :");
		anItalianCard2.showCard();
		
		ItalianPlayingCard anItalianCard3 = new ItalianPlayingCard(11, "JASON");
		System.out.println("anItalianCard3 is :");
		anItalianCard3.showCard();
		
		SwissPlayingCard aSwissCard1 = new SwissPlayingCard(13, "ROSES");
		System.out.println("aSwissCard1 is :");
		aSwissCard1.showCard();  // SwissPlayingCardObject.showCard() - runs the showCard() in SwissPlayingCard class
		
		SwissPlayingCard aSwissCard2 = new SwissPlayingCard(9, "SHIELDS");
		System.out.println("aSwissCard2 is :");
		aSwissCard2.showCard();
			
		SwissPlayingCard aSwissCard3 = new SwissPlayingCard(10, "ACORNS");
		System.out.println("anSwissCard3 is :");
		aSwissCard3.showCard();
			
		SwissPlayingCard aSwissCard4 = new SwissPlayingCard(11, "JASON");
		System.out.println("anSwissCard4 is :");
		aSwissCard4.showCard();		
		
		/******************************************************************************************************
		 * Polymorphism examples follow
		 ******************************************************************************************************/
		
		System.out.println("\n--- Start of Polymorhism example ---\n");
		
		PlayingCard myCard = null;         // super class object
		
		AmericanPlayingCard dougCard 	= new AmericanPlayingCard(1,"SPADES");  // subclass object to super class object
		ItalianPlayingCard  melissaCard = new ItalianPlayingCard(10,"COINS");   // subclass object to super class object
		SwissPlayingCard    codyCard    = new SwissPlayingCard(12,"BALLS");     // subclass object to super class object
		
		myCard = codyCard;  // Assign a subclass object to a superclass object
		
		myCard.showCard();  // superClassObject.method();  - Same statement runs different versions of showCard
		                    //                               due to polymorphism - class of the content of myCard
		                    //                               NOT the class of myCard determines the version of method to run
		
		System.out.println("\n --- Using Polymorphism with an Array example ---\n");
		
		 
		PlayingCard[] cardArray = new PlayingCard[5];  // define an array of super class objects
		
		cardArray[0] = dougCard;                             // assign subclass objects as elements in super class array
		cardArray[1] = new SwissPlayingCard(1, "ACORNS");    // assign subclass objects as elements in super class array
		cardArray[2] = codyCard;                             // assign subclass objects as elements in super class array
		cardArray[3] = melissaCard;                          // assign subclass objects as elements in super class array
		cardArray[4] = new ItalianPlayingCard(10, "SWORDS"); // assign subclass objects as elements in super class array
		
		for (int i=0; i < cardArray.length; i++) {  // Loop through array one element at a time
 			cardArray[i].showCard();                // Use the current element to run showCard() for the subclass
		}
		// Calling a method with a subclass object
		PlayingCard anotherCard = null;
		
		anotherCard = melissaCard;
		displayCard(anotherCard);
		
		anotherCard = dougCard;
		displayCard(anotherCard);
		
		anotherCard = new AmericanPlayingCard(6,"HEARTS");
		displayCard(anotherCard);
		
	}
public static void displayCard(PlayingCard aCard) {   // method receiving a super class object
	System.out.println("--- in the displayCard() method");
	aCard.showCard();    // Use the superclass object to run the showCard()
}
}
