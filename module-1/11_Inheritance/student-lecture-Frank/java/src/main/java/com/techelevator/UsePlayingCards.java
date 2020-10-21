package com.techelevator;

/**********************************************************************
 * 
 * @author brendanglancy
 * 
 * This is the application program, we know this because it contains the main() method
 * 
 * instantiate objects and manipulate objects using methods to their work done
 *
 **********************************************************************/

public class UsePlayingCards {

	public static void main(String[] args) {
		System.out.println("\nInstantiating aUSACard as an ace of Hearts");
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");  // Instantiate an Ace of Hearts
		System.out.println("aUSACard is : \n" + aUSACard); // Java uses the playingCard(super toString()) to make this happen

		// Java uses the toString() method that was passed from the PlayingCard class to the AmericanPlayingCard class to this Appilcation class
		
		System.out.println("\nInstantiating aUSACard2 with a value that exceeds maximum");
		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES"); // Value exceeds maximum
		System.out.println("aUSACard2 is : \n" + aUSACard2);

		System.out.println("\nInstantiating aUSACard3 with a value that is below minimum");

		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES"); // Value less than minimum
		System.out.println("aUSACard3 is : \n" + aUSACard3);	

		System.out.println("\nComparing aUSACard2 and aUSACard3");
		
		if (aUSACard2.equals(aUSACard3)) {
			System.out.println("They are equal");
		}
		else {
			System.out.println("They are NOT equal");
		}
		
		ItalianPlayingCard frank = new ItalianPlayingCard(12, "Yodas", "Green");
		
		System.out.println("frank card is: " + frank);
	}

}
