package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/******************************************************************************************
 * BankCustomer
 * 
 * 
 ******************************************************************************************/
public class BankCustomer {
	private String name;
	private String address;
	private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();   // List of Accountable objects - superClass to bankAccount, savingAccount, CheckAccount
    
    public BankCustomer(String name, String address, String phoneNumber, List<Accountable> accounts) {
    	this.name = name;
    	this.address = address;
    	this.phoneNumber = phoneNumber;
    	this.accounts = accounts;
    }
    
    public BankCustomer() {
    	
    }
    
    /******************************************************************************************
     * Getters
     ******************************************************************************************/

	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Accountable[] getAccounts() {
		return accounts.toArray(new Accountable[accounts.size()]);
	}
	
	 /******************************************************************************************
     * Setters
     ******************************************************************************************/
    
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	 /******************************************************************************************
     * Method addAccount - Adds newAccount to the customer's list of accounts. 
     ******************************************************************************************/
    
    public void addAccount(Accountable newAccount) {
    	accounts.add(newAccount);
    }
    
    /******************************************************************************************
     * Method addAccount - Adds newAccount to the customer's list of accounts. 
     * 
     * Customers whose combined account balances (credits minus debts) are at least \$25,000
     *  are considered VIP customers and receive special privileges.
     *  
     ******************************************************************************************/
    
    public boolean isVip() { // not working
    	int total = 0; // holds the value of the combine account balances
    	
    	for (int i = 0; i < accounts.size(); i++) {
    		total += accounts.get(i).getBalance(); // add the account balances to total
    	}
    	if (total >= 25000) {
    		return true;
    	} else {
    		return false;
    	}
    	
    	
    	
    	
    }
    
    
} 