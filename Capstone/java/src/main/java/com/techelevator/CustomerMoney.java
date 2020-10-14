package com.techelevator;

public class CustomerMoney {
	
	/*********************************************
	 * Instance Variables
	 *********************************************/
	
	private double currentMoney = 0.00; // default starting money in Vending machine
	
	/*********************************************
	 * Getter
	 *********************************************/
	
	public double getCurrentMoney() {
		return currentMoney; // returns the amount of money in the machine
	}
	
	/*********************************************
	 * Methods 
	 * Add
	 * Subtract 
	 * 
	 * @param moneyToAdd
	 * @param moneyToSub
	 *********************************************/
	
	public void addCurrentMoney(double moneyToAdd) {
		this.currentMoney += moneyToAdd;
	}
	

	public void subtractCurrentMoney(double moneyToSub) {
		if (moneyToSub <= this.currentMoney) { // if we have enough money
			this.currentMoney -= moneyToSub; // then subtract
		} 
		
	}

}
