package com.techelevator;

/**
 * CreditCardAccount
 */
public class CreditCardAccount implements Accountable {
	
/*******************************************************************
 * Place the code for  your CreditCard class here
 *******************************************************************/
	
	private String accountHolder;
	private String accountNumber;
	private static int debt;
	
	/*******************************************************************
	 * 2-arg constructor
	 *******************************************************************/
	
	public CreditCardAccount(String accountHolder, String accountNumber) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		debt = 0;
	}
	
	
	
	/*******************************************************************
	 * Getters
	 *******************************************************************/
	
	public String getAccountHolder() {
		return accountHolder;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public static int getDebt() {
		return debt;
	}
	
	/*******************************************************************
	 * Methods
	 *******************************************************************/
	
	public int pay(int amountToPay) {
		return debt -= amountToPay;
	}
	
	public int charge(int amountToCharge) {
		return debt += amountToCharge;
	}


    public int getBalance() {
    	//***************************************************************
    	// This should return the negative of the debt data member
    	//***************************************************************
    	
        return -debt;
    }

	

 

}