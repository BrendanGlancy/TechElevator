package com.techelevator.tenmo.models;

public class Account {
	private int accountId;
	private int userId;
	private double balance;
	
	public int getAccountId() {
		return accountId;
	}
	
	
	/*********************************************
	 * Getters and Setters
	 *********************************************/
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(userId) + " " + Double.toString(balance);
	}
	
	

}
