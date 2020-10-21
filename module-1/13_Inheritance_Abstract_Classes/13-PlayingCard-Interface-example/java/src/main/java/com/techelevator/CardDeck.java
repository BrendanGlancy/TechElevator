package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
/**************************************************
 * 
 * @author brendanglancy
 *
 *
 * This is a class to module a standard 52 deck of cards
 * with optional Jokers
 * 
 **************************************************/

public class CardDeck {
	// the deck is a Queue, first in first out data structure
	
	LinkedList<PlayingCard> deckOfCards = new LinkedList<PlayingCard>();
	private int numCardsInDeck = 54;

	public CardDeck() {
		resetDeck(true); // reset deck with jokers
	}

	public void showDeck() {
		System.out.println("Number of Cards in Deck: " + deckOfCards.size());
		for (PlayingCard aCard : deckOfCards) {
			System.out.println(aCard);
		}
	}

	public boolean anyCardsInDeck() {
		if (deckOfCards.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public PlayingCard dealCard() {
		if (deckOfCards.size() > 0) {
			return deckOfCards.remove();
		}
		else {
			 return null;
		}
	}

	public void resetDeck(boolean withJoker) { // Initialize a deck of card with jokers if withJoker is true
		deckOfCards.clear();

		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "CLUBS"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "HEARTS"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "Spades"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "DIAMONDS"));
		}

		if (withJoker) {
			deckOfCards.add(new PlayingCard(0, "JOKER"));
			deckOfCards.add(new PlayingCard(0, "JOKER"));
		}
	}

	public void shuffleDeck() {
		resetDeck(false);  // reset the deck with no jokers
		Collections.shuffle(deckOfCards); // use the collection class shuffle method to shuffle the deck
	}

}