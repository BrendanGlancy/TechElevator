package com.techelevator.exceptions;

public class OverdraftException extends Exception {

	private double overdraftAmount = 0;
	
	public OverdraftException(String message, double overdraftAmount) {
		super(message);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}
}
