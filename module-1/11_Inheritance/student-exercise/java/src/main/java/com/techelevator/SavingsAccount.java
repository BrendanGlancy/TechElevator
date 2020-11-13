package com.techelevator;

/*********************************************************
 * 
 * @author brendanglancy
 *
 * A `SavingsAccount` "is-a" `BankAccount`, but it also has some additional rules:
 * 
 * If the current balance is less than $150 when a withdrawal is made,
 *  an additional $2 service charge is withdrawn from the account. 
 *  
 * If a withdrawal is requested for more than the current balance, 
 *  the withdrawal fails and the balance remains the same. No fees are incurred.
 *  
 *  
 *********************************************************/

public class SavingsAccount extends BankAccount {
	
	
	// 2-args constructor
	public SavingsAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
		// TODO Auto-generated constructor stub
	}
	
	// 3-args constructor
	public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
	}

	/**********************************************************
	 * Override method
	 * 
	 * Implement the conditions to make a withdraw from the savings class
	 * 
	 **********************************************************/
	
	@Override
	public int withdraw(int amountToWithdraw) {
		
		if (amountToWithdraw > getBalance()) { // if you don't have enough money return the account balance
			return getBalance();
			
		} else if (getBalance() >= amountToWithdraw) { // if you do have enough money
			
			if (getBalance() - amountToWithdraw < 150) { // and you have less than 150$ 
				super.withdraw(amountToWithdraw + 2); // withdraw the amount given + 2$
				return getBalance(); // return the balance
			}
		}
		return super.withdraw(amountToWithdraw); 
	}

}
