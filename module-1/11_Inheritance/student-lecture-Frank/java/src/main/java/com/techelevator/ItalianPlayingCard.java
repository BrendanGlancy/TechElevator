package com.techelevator;
/********************************************************
 * 
 * @author brendanglancy
 * 
 * 
 * Through inheritance we can use code that already exist and not have to rewrite it
 *
 ********************************************************/

public class ItalianPlayingCard extends PlayingCard {
	
	public ItalianPlayingCard(int value, String suit, String color) {
		super(value, suit, color); // call the 3-arg super class constructor 
		// with parameters from the user
	}
	

}
