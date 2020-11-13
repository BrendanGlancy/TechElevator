package com.techelevator;

import com.techelevator.PokerHand.PokerHandRanking;

public class TestCardApp {

	public static void main(String[] args) {

		CardDeck myDeck = new CardDeck();
//		CardHand myHand = new CardHand();
		PokerHand myPokerHand = new PokerHand();

		System.out.println("-----------------------------------------------------");
		System.out.println("-- Showing Cards in Deck                           --");
		System.out.println("-----------------------------------------------------");

		myDeck.showDeck();

		System.out.println("-----------------------------------------------------");
		System.out.println("-- Removing Jokers from Deck                       --");
		System.out.println("-----------------------------------------------------");

		System.out.println("Number Jokers Removed: " + myDeck.removeJokers());

		System.out.println("-----------------------------------------------------");
		System.out.println("-- Shuffling Deck                                  --");
		System.out.println("-----------------------------------------------------");

		myDeck.shuffleDeck();

		System.out.println("-----------------------------------------------------");
		System.out.println("-- Dealing Cards from Deck                         --");
		System.out.println("-----------------------------------------------------");

		while (myDeck.anyCardsInDeck())
			System.out.println(myDeck.dealCard().toString());

		System.out.println("-----------------------------------------------------");
		System.out.println("-- Dealing Cards to a PokerHand                    --");
		System.out.println("-----------------------------------------------------");

		myDeck.resetDeck(false);
		myDeck.shuffleDeck();

		myPokerHand.dealHand(myDeck);
		
		myPokerHand.show();
		
		System.out.println("-----------------------------------------------------");
		System.out.println("-- Sorting PokerHand by Value                      --");
		System.out.println("-----------------------------------------------------");
		  
		myPokerHand.sortByValue();  
		myPokerHand.show();
		  
		System.out.println("-----------------------------------------------------");
		System.out.println("-- Sorting PokerHand by Color                      --");
		System.out.println("-----------------------------------------------------");
		
		myPokerHand.sortByColor(); 
		myPokerHand.show();
		  
		System.out.println("-----------------------------------------------------");
		System.out.println("-- Sorting PokerHand by Suit                       --");
		System.out.println("-----------------------------------------------------");
		  
		myPokerHand.sortBySuit();  
		myPokerHand.show();
		  
		System.out.println("-----------------------------------------------------");
		System.out.println("-- Test Hand Ranking                               --");
		System.out.println("-----------------------------------------------------");
	  	
		System.out.printf("Hands found: %d\n", findHand(10, PokerHandRanking.PAIR, false));
		System.out.println("-----------------------------------------------------");
		System.out.printf("Hands found: %d\n", findHand(10, PokerHandRanking.TWOPAIR, false));
		System.out.println("-----------------------------------------------------");
		System.out.printf("Hands found: %d\n", findHand(50, PokerHandRanking.FLUSH, false));
		System.out.println("-----------------------------------------------------");
		System.out.printf("Hands found: %d\n", findHand(1000, PokerHandRanking.STRAIGHT, false));
		System.out.println("-----------------------------------------------------");
		System.out.printf("Hands found: %d\n", findHand(1000, PokerHandRanking.FULLHOUSE, false));
		System.out.println("-----------------------------------------------------");
		System.out.printf("Hands found: %d\n", findHand(20000, PokerHandRanking.FOUROFAKIND, true));
		System.out.println("-----------------------------------------------------");
		System.out.printf("Hands found: %d\n", findHand(100000, PokerHandRanking.STRAIGHTFLUSH,true));
		System.out.println("-----------------------------------------------------");
		System.out.printf("Hands found: %d\n", findHand(1000000, PokerHandRanking.ROYALSTRAIGHTFLUSH, true));
		System.out.println("-----------------------------------------------------");		 
	}
	
//**********************************************************************************
//  Determine if a particular poker hand is dealt in a specified number of hands
//**********************************************************************************
	/**
	 * @param numTries   - Number of hands to deal
	 * @param whatRank   - PokerHandRaking to look for
	 * @param showResult - true / false
	 * @return
	 */
	public static int findHand(int numTries, PokerHandRanking whatRank, boolean showResult)
	{
		int numFound = 0; 
		
		CardDeck  aDeck      = new CardDeck();
		PokerHand aPokerHand = new PokerHand();
	
		System.out.printf("Looking for %s in %,d hands...\n\n", whatRank, numTries);
			
		for (int i = 0; i < numTries; i++) { 
		 
		  aPokerHand.clearHand(); 
		  aDeck.resetDeck(false); 
		  aDeck.shuffleDeck();

		  aPokerHand.dealHand(aDeck);
		  
		  if (aPokerHand.rankHand() == whatRank) {
			  if (showResult) { System.out.println("\n"+ aPokerHand.rankHand()+ "\n");
			                    aPokerHand.show();
			                  }
			  numFound++;
			  } 
		  }
		 return numFound;
		 
	}
}



