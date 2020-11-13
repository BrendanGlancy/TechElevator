package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/***************************************************************************************************
 * Class to Simulate an American Playing Card Hand
 ***************************************************************************************************/
public abstract class CardHand   implements ValidCardHand  { 

	/***********************************************************************************************
	 * Member Data
	 ***********************************************************************************************/
	
	int       numCardsInHand;               // Maximum number of cards in hand
	protected ArrayList<PlayingCard> aHand; // Reference to the PlayingCard Hand 

	/***********************************************************************************************
	 * Constructors
	 ***********************************************************************************************/
	
	public CardHand() {            // Default constructor
		numCardsInHand = 5;        // Default number of cards in a hand
		aHand = new ArrayList<PlayingCard>(numCardsInHand);  // Allocate enough slots for number cards in hand
	}
	
	public CardHand(int numCards) { // Constructor to create a specific number of cards in Hand
		numCardsInHand = numCards;  // Set number of cards in Hand to value passed
		aHand = new ArrayList<PlayingCard>(numCardsInHand);  // Allocate enough slots for number cards in hand
	}

	/***********************************************************************************************
	 * getters
	 ***********************************************************************************************/
	public ArrayList<PlayingCard> getHand() {
		return aHand;
	}

/***************************************************************************************************
 * Overrides of superclass or interface methods
 ***************************************************************************************************/
@Override     // Ask compiler to check to be sure this is a valid override of superclass or interface method
	public void addCard(PlayingCard aCard) {
		aHand.add(aCard);

}
@Override     // Ask compiler to check to be sure this is a valid override of superclass or interface method
	public void clearHand() {   // Remove all cards from Hand
		aHand.clear();
	}

@Override     // Ask compiler to check to be sure this is a valid override of superclass or interface method
	public abstract void dealHand(CardDeck aDeck);

@Override     // Ask compiler to check to be sure this is a valid override of superclass or interface method	
	public void show() {                // Display each card in Hand
		for (PlayingCard aCard : aHand)
		{
			System.out.println(aCard);
		}
			return;
	}

/***************************************************************************************************
 *************************************************************************************************** 
            uuuuuuuuuuuuuuuuuuuu
          u" uuuuuuuuuuuuuuuuuu "u
        u" u$$$$$$$$$$$$$$$$$$$$u "u
      u" u$$$$$$$$$$$$$$$$$$$$$$$$u "u
    u" u$$$$$$$$$$$$$$$$$$$$$$$$$$$$u "u
  u" u$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$u "u
u" u$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$u "u
$ $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ $
$ $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ $
$ $$$" ... "$...  ...$" ... "$$$  ... "$$$ $
$ $$$u `"$$$$$$$  $$$  $$$$$  $$  $$$  $$$ $
$ $$$$$$uu "$$$$  $$$  $$$$$  $$  """ u$$$ $
$ $$$""$$$  $$$$  $$$u "$$$" u$$  $$$$$$$$ $
$ $$$$....,$$$$$..$$$$$....,$$$$..$$$$$$$$ $
$ $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ $
"u "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" u"
  "u "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" u"
    "u "$$$$$$$$$$$$$$$$$$$$$$$$$$$$" u"
      "u "$$$$$$$$$$$$$$$$$$$$$$$$" u"
        "u "$$$$$$$$$$$$$$$$$$$$" u"
          "u """""""""""""""""" u"
            """"""""""""""""""""

 ***************************************************************************************************
/***************************************************************************************************
/***************************************************************************************************
 * 
 *   IMPORTANT: The code that follows is beyond what is taught in the basic Java class
 *   
 *              It is provided to make the class more complete by providing reasonable
 *              functionality.
 *              
 *   THIS CODE WILL NOT BE REVIEWED BY THE INSTRUCTOR IN CLASS.
 *   
 *   You may review it on your own to gain an understanding of what it does, but the instructor
 *   will only entertain questions/review of this code as availability permits.
 *
/***************************************************************************************************
/***************************************************************************************************

/***************************************************************************************************
 * Methods to sort cards in a Hand using Collections class sort() method
 * 
 * The Collection class sort() method provides a way to sort elements in any Collection class object
 * 
 * We are using the Collections sort method that uses a Comparator object:  
 * 
 *            Collections.sort(Collection-object, Comparator-object)
 *            
 * A Comparator object is an object of a class that implements 
 *              the Comparator interface for the class of the objects to be compared
 *              
 * The class of the Comparator object must override the compare() method.
 * 
 * The compare method of the Comparator object class must receive two objects of the class to
 *              be compared and return and int representing the relationship of the two objects:
 *              
 *              0 - Indicates objects were equal
 *             >0 - Indicates 1st object was greater than the second
 *             <0 - Indicates 1st object was less than the second
 * 
 ***************************************************************************************************/

	public void sortByValue() {  // Sort cards by value using Collections sort() method
		Collections.sort(aHand, new valueCompare());
	}

	public void sortByColor() {  // Sort cards by Color using Collections sort() method
		Collections.sort(aHand, new colorCompare());
	}

	public void sortBySuit() {   // Sort cards by Suit using Collections sort() method
		Collections.sort(aHand, new suitCompare());
	}

	/***************************************************************************************************
	 * Embedded classes for Comparator objects used by sorting methods
	 ***************************************************************************************************/

	public class valueCompare implements Comparator<PlayingCard> {      // Compare two PlayingCards by value
		public int compare(PlayingCard Card1, PlayingCard Card2) {
			return Card1.getIntValue() - Card2.getIntValue();
		}
	}

	public class suitCompare implements Comparator<PlayingCard> {       // Compare two PlayingCards by suit
		public int compare(PlayingCard Card1, PlayingCard Card2) {
			return Card1.getSuit().ordinal() - Card2.getSuit().ordinal();
		}
	}

	public class colorCompare implements Comparator<PlayingCard> {       // Compare two PlayingCards by color
		public int compare(PlayingCard Card1, PlayingCard Card2) {
			return Card1.getColor().ordinal() - Card2.getColor().ordinal();
		}
	}
}
