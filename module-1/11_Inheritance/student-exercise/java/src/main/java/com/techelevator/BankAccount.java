package com.techelevator;
/**********************************************************
 * Currently working 13/13 Mon 12:40
 **********************************************************/

/************************************************************
 * 
 * @author brendanglancy
 *
 * The `BankAccount` class represents a simple checking or savings account at a bank.
 * 
 * A new bank account requires an account holder name and account number. 
 * The balance defaults to a 0 dollar balance if not specified.
 * 
 * A new bank account requires an account holder name and account number.
 * The balance is initialized to the dollar balance given.
 *  
 ************************************************************/

public class BankAccount {
	
	/********************************************************
	 * Member Instance Variables 
	 ********************************************************/
	
	private String accountHolderName; // Returns the account holder name that the account belongs to.
	private String accountNumber; // Returns the account number that the account belongs to.
	private int balance; // Returns the balance value of the bank account in dollars.
	
	public BankAccount(String accountHolderName, String accountNumber) {
		
		/*****************************************************
		 * A new bank account requires an account holder name and account number.
		 * 
		 * The balance defaults to a 0 dollar balance if not specified.
		 *****************************************************/
		
		this.accountHolderName = accountHolderName; 
		this.accountNumber = accountNumber;
		balance = 0;
	}
	
	public BankAccount(String accountHolderName, String accountNumber, int balance) {
		
		/******************************************************
		 *  A new bank account requires an account holder name and account number.
		 * 
		 * The balance is initialized to the dollar balance given.
		 ******************************************************/
		
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.balance = balance;
		
	}
	
	/**********************************************************
	 * Getters - allow users to see the values in a Bank account object
	 **********************************************************/
	
	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public int getBalance() {
		return balance;
	}
	
	/**********************************************************
	 * Methods
	 **********************************************************/
	
	public int deposit(int amountToDeposit) {
		balance += amountToDeposit; // adds a deposit to balance
		return balance;
	}
	
	public int withdraw(int amountToWithdraw) {
		balance -= amountToWithdraw; // subtracts a withdraw from balance
		return balance;
	}
	

}
