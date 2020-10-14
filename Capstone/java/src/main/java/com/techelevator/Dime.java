package com.techelevator;

public class Dime implements Coin {

	// Get the name of the type of coin
	@Override
	public String getName() {
		return "Dime";
	}

	// Get the value of the coin
	@Override
	public int getValue() {
		return 10;
	}

}
