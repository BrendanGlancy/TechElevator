package com.techelevator;
 
import java.util.ArrayList;


public interface CardHand { // Define the behaviors for any thing that wants to a type of CardHand
	// Any class that implements the CardHand Must be sure these methods are defined 
	
	public ArrayList<PlayingCard> getHand(); // returns the cards in the CardHand as an ArrayList

	public void addCard(PlayingCard aCard); // add the PlayingCard passed as a parameter to the CardHand
	
	public void emptyHand(); // remove all the PlayingCard objects in a CardHand

	public void show(); // show each PlayingCard in the CardHand

}
