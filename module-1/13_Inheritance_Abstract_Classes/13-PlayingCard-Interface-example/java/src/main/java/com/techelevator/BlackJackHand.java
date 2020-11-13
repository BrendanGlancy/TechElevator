package com.techelevator;
 
import java.util.ArrayList;

// You may see some people put final on a class, Final on a class means it cannot be used as a super class
// Why would you want a class to be final? Java defines it's built in classes as final so you can't use them as a super class 

public class BlackJackHand	 implements CardHand { // This class is a type of CardHand - the implements keyword is how you use an interface with your class

	private int numCardsInHand = 2;
	
	private ArrayList<PlayingCard> aHand;
	
	public BlackJackHand() {
		aHand = new ArrayList<PlayingCard>(numCardsInHand); // you can provide an estimate of how many elements for an ArrayList 
		// to be sure there is enough room in memory to hold the # of elements
	}
	
	@Override // demonstrate were overridding the methods we made in the CardHand interface
	public ArrayList<PlayingCard> getHand() { // final on a method means you can't override this 
		return aHand;
	}

	@Override
	public void addCard(PlayingCard aCard) {
		aHand.add(aCard);
		numCardsInHand++;
	}

	@Override
	public void emptyHand() { // if you remove one of these methods java will throw you an error, because we need all the methods from CardHand
		aHand.clear();

	}

	@Override
	public void show() {
		for (PlayingCard aCard : aHand)
		{
			System.out.println(aCard);
		}
			return;
	}
	
	public final void dealHand(CardDeck aDeck) { // final on this method so no one can change how cards are dealt
		// can't deal in reverse or any other order than below
		for (int i=0; i < numCardsInHand; i++ ) {
			aHand.add(aDeck.dealCard());
		}	
	}
	
}
	
