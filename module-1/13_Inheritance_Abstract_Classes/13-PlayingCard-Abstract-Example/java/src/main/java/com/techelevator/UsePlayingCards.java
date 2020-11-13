package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class UsePlayingCards {

	public static void main(String[] args) {
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");
		System.out.println("aUSACard is : \n" + aUSACard);
		
		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES");
		System.out.println("aUSACard2 is : \n" + aUSACard2);
		
		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES");
		System.out.println("aUSACard3 is : \n" + aUSACard3);
		
		ItalianPlayingCard anItalianCard1 = new ItalianPlayingCard(13, "SWORDS");
		System.out.println("anItalianCard1 is : \n" + anItalianCard1);
		
		ItalianPlayingCard anItalianCard2 = new ItalianPlayingCard(9, "COINS");
		System.out.println("anItalianCard2 is : \n" + anItalianCard2);
		
		SwissPlayingCard aSwissCard1 = new SwissPlayingCard(13, "ROSES");
		System.out.println("aSwissCard1 is : \n" + aSwissCard1);
		
		SwissPlayingCard aSwissCard2 = new SwissPlayingCard(9, "SHIELDS");
		System.out.println("aSwissCard2 is : \n" + aSwissCard2);
		
		SwissPlayingCard aSwissCard3 = new SwissPlayingCard(10, "ACORNS");
		System.out.println("anSwissCard3 is : \n" + aSwissCard3);
		
	System.out.println("\n----- Polymorphism example follows ------ \n");
		
		
		List<PlayingCard> someCards = new ArrayList<PlayingCard>();
		
		someCards.add(anItalianCard1);
		someCards.add(aUSACard);
		someCards.add(aSwissCard2);
		
		for(PlayingCard aCard : someCards) {
			aCard.showCard();
		}
			
	}

}
