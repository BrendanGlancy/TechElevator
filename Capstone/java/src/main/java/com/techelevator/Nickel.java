package com.techelevator;

public class Nickel implements Coin{

	// get the name of the coin
	@Override
	public String getName() {
		return "Nickel";
	}

	// get the value of the coin
	@Override
	public int getValue() {
		return 5;
	}

}
