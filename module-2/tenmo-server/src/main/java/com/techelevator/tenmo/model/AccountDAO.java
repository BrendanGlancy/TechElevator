package com.techelevator.tenmo.model;

import java.sql.JDBCType;
import java.util.List;

public interface AccountDAO {
	
	// need account id
	// Account balance
	
	public double getAccountBalance(int id);
	
	public Account getAccountById(int id);
	
	public double addBalance(long id, double amount);
		
	public double subtractBalance(long id, double amount);

	public Account getAccountByUserId(long id);
	
	public boolean checkValidTransfer(long id, double amount);

	public List<Account> getAllAccounts();
}
