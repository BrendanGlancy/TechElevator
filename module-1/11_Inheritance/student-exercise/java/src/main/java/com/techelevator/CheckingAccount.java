package com.techelevator;

/***************************************************
 * 
 * @author brendanglancy
 *
 * A `CheckingAccount` "is-a" `BankAccount`, but it also has some additional rules:
 *
 * If the balance falls below $0.00 and is less than -$100.00,
 * a $10.00 overdraft fee is also charged against the account.
 *  
 *  Checking account can't be overdrawn by $100.00 or more.
 *   If a withdrawal request leaves the account $100 or more overdrawn,
 *    it fails and the balance remains the same.
 *     For example,
 *     if the current balance is -$89.00, and the amount to withdraw is $10.00,
 *      the resulting balance is -$99.00.
 *       The withdraw is permitted since the new balance is less than -$100.00.
 *        The $10.00 overdraft fee is then charged against the account,
 *         resulting in a final balance of -$109.00.
 *         A withdrawal of $11.00 in the same situation fails 
 *         because the new balance is -$100.00 which is equal to ***but not less than*** the limit of -$100.00.
 *         
 *          
 ***************************************************/

public class CheckingAccount extends BankAccount {
	
	// 2-arg constructor
	public CheckingAccount(String accountHolderName, String accountNumber) {
		// invoke the super class constructor on these two variables
		super(accountHolderName, accountNumber);
	}
	
	// 3-arg constructor
	public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
		// invoke the super class constructor on these three variables
		super(accountHolderName, accountNumber, balance);
	}

	/**********************************************************
	 * Override method
	 * 
	 * Implement the conditions of withdrawing from the Checking class
	 * 
	 **********************************************************/
	
	@Override
	public int withdraw(int amountToWithdraw) {
		// if the balance is less than or equal to 100
		if (getBalance() <= -100) {
			
			return getBalance(); // return the balance
		}
		
		int balance = getBalance() - amountToWithdraw; // set balance equal to the amount in the account minus the withdraw
		
		if (balance > 0) {
			super.withdraw(amountToWithdraw); // if it's positive make the withdraw
		}

		/******************************************************
		* Checking Account is a subclass of BankAccount
		* So it has an instance of BankAccount as part of itself
		*
		* A subclass has access to super class methods by using the super keyword
		*
		* We need to subtract the amountToWithdraw from the balance
		* We use the BankAccount withdraw() method to do that
		*
		*******************************************************/
		 
		if (balance < 0 && balance >= -100) { // if it's negative and greater than or equal to -100 
			amountToWithdraw = amountToWithdraw + 10; // withdraw with the 10$ fee
			super.withdraw(amountToWithdraw); // go into the super class bank account and withdraw the amount to withdraw
		}
		
		return getBalance();
		
	}
	

}
