package com.techelevator;

// interface defines behaviors/methods that must be implemented if a class wants to
// a type of this interface

public interface ValidCardHand { // if a class wants to be a valid card hand they must implement these methods 

	// you cannot put code in here since it's an interface, just declear methods
	
	public void clearHand();                // Remove all cards from a hand
	public void show();                     // Display all cards in a hand 
	public void dealHand(CardDeck aDeck);   // Fill a hand from a CardDeck object
	public void addCard(PlayingCard aCard); // Add card to a hand
}
