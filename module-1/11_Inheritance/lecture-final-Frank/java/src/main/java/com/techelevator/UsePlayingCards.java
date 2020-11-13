package com.techelevator;

public class UsePlayingCards {
/*************************************************************************************
 * This is the application program - main()
 *
 *  instantiate objects and manipulate objetcs using methods to their work done
 *************************************************************************************/
	public static void main(String[] args) {
		System.out.println("\nInstantiating aUSACard as an ace of Hearts");
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");  // Instantiate an Ace of Hearts
		System.out.println("aUSACard is : \n" + aUSACard); // Java uses the PlayingCard(super toString())
		
		System.out.println("\nInstantiating aUSACard2 with a value that exceeds maximum");
		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES"); // Value exceeds maximum
		System.out.println("aUSACard2 is : \n" + aUSACard2);

		System.out.println("\nInstantiating aUSACard3 with a value that is below minimum");

		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES"); // Value less than minimum
		System.out.println("aUSACard3 is : \n" + aUSACard3);	

		System.out.println("\nComparing aUSACard2 and aUSACard3");
		
		if (aUSACard2.equals(aUSACard3)) {               // uses the super class .equals()
			System.out.println("They are equal");
		}
		else {
			System.out.println("They are NOT equal");
		}
	
		ItalianPlayingCard frank = new ItalianPlayingCard(46, "Browns", "Orange");
		
		System.out.println("frank card is: " + frank);
	}

}
