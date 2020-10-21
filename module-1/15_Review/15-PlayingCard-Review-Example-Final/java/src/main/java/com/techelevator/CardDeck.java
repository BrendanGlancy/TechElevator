package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import com.techelevator.PlayingCard.CardSuit;
import com.techelevator.PlayingCard.CardValue;
/***************************************************************************************************
 * Class to Simulate a Standard Deck of  American Playing Cards
 ***************************************************************************************************/

public class CardDeck {
	/***************************************************************************************************
	 * Standard Deck represented as a Queue / LinkedList
	 ***************************************************************************************************/

	LinkedList<PlayingCard> deckOfCards = new LinkedList<PlayingCard>();  // Define a Queue to hold PlayingCards
	
	/***************************************************************************************************
	 * Number of non-Joker cards per suit
	 ***************************************************************************************************/
	private static final int numberCardsForSuit = 13; 

	/***************************************************************************************************
	 * Default Constructor
	 ***************************************************************************************************/
	
	public CardDeck() {
		resetDeck(true); // create deck with jokers
	}

	/***************************************************************************************************
	 * Display cards in deck
	 ***************************************************************************************************/
	
	public void showDeck() {
		System.out.println("Number of Cards in Deck: " + deckOfCards.size());
		for (PlayingCard aCard : deckOfCards) {
			aCard.showCardWithHash();
		}
	}
	/***************************************************************************************************
	 * Answer question are they any cards in the deck
	 ***************************************************************************************************/
	
	public boolean anyCardsInDeck() {
		if (deckOfCards.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/***************************************************************************************************
	 * Deal a card from the top of the deck
	 ***************************************************************************************************/
	public PlayingCard dealCard() {
		if (deckOfCards.size() > 0) {
			return deckOfCards.remove();
		}
		else {
			 return null;
		}
	}
	/***************************************************************************************************
	 * Create a deck with or without Jokers
	 ***************************************************************************************************/
	public void resetDeck(boolean withJoker) {
		deckOfCards.clear();              // Remove any existing cards from the deck

		for (int i = 1; i <= numberCardsForSuit; i++) {    // Generate a set of clubs
			deckOfCards.add(new PlayingCard(i, PlayingCard.CardSuit.CLUB));
		}
		for (int i = 1; i <= numberCardsForSuit; i++) {    // Generate a set of hearts
			deckOfCards.add(new PlayingCard(i, PlayingCard.CardSuit.HEART));
		}
		for (int i = 1; i <= numberCardsForSuit; i++) {    // Generate a set of spades
			deckOfCards.add(new PlayingCard(i, PlayingCard.CardSuit.SPADE));
		}
		for (int i = 1; i <= numberCardsForSuit; i++) {     // Generate a set of diamonds
			deckOfCards.add(new PlayingCard(i, PlayingCard.CardSuit.DIAMOND));
		}

		if (withJoker) {  // If Jokers requested, add them
			deckOfCards.add(new PlayingCard(CardValue.JOKER, CardSuit.JOKER));
			deckOfCards.add(new PlayingCard(CardValue.JOKER, CardSuit.JOKER));
		}
	}
	/***************************************************************************************************
	 * Create New Deck with Shuffled Cards
	 ***************************************************************************************************/
	public void shuffleDeck() {
		resetDeck(false);                  // Reload deck without Jokers
		Collections.shuffle(deckOfCards);  // Use Collections class shuffle() to randomize cards in deck
	}
	
	/***************************************************************************************************
	 * Remove any Jokers from a Deck
	 ***************************************************************************************************/
	public int removeJokers() {
		ArrayList<PlayingCard> aJoker = new ArrayList<PlayingCard>();  // Needed to hold a Joker
		aJoker.add(new PlayingCard(CardValue.JOKER, CardSuit.JOKER));  // Add a Joker to ArrayList
		int numCardsBefore = deckOfCards.size();                       // Remember # cards before removal
		deckOfCards.removeAll(aJoker);                                 // Remove any Jokers from deck
		return numCardsBefore - deckOfCards.size();                    // Return # of Jokers removed
	}
}