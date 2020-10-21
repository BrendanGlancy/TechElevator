package com.techelevator;
 
public class BankAccount implements Accountable {

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    // Update the balance by using the DollarAmount.Plus method
    public int deposit(int amountToDeposit) {
        balance += amountToDeposit;
        return balance;
    }

    // Update the balance by using the DollarAmount.Minus method
    public int withdraw(int amountToWithdraw) {
        balance -= amountToWithdraw;
        return balance;
    }
    
    /******************************************************************************************
     * Method transferTo - allow all bankAccounts to transfer money to another bank account.
     *  
     ******************************************************************************************/
    
    public int transferTo(BankAccount destinationAccount, int transferAmount) {
    	int newBalance = this.getBalance() - transferAmount;
    	
    	
    	if (newBalance < 0) {
    		 return this.getBalance();
    	} else {
    		this.withdraw(transferAmount);
    		destinationAccount.deposit(transferAmount);
    	}
    	
    	return this.balance;
    }

}
