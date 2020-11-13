package com.techelevator.tenmo.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCAccountDAO  implements AccountDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCAccountDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	/*********************************************
	 * Interface methods
	 *********************************************/


	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		String query = "SELECT account_id, balance, user_id FROM accounts";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query);
		while(results.next()) {
			Account accountResult = mapRowToAccount(results);
			accounts.add(accountResult);
		}
		return accounts;
	}
	
	@Override
	public double getAccountBalance(int id) {
		Account account = getAccountById(id);
		return account.getBalance();
	}


	/*********************************************
	 * As an authenticated user of the system,
	 *  I need to be able to see my Account Balance.
	 *********************************************/
	
	@Override
	public Account getAccountById(int id) {
		String query = "SELECT * FROM accounts WHERE account_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query, id);
		if(results.next()) {
			return mapRowToAccount(results);
		}
		System.out.println("Account not found");
		return null;
	}


	@Override
	public double addBalance(long id, double amount) {
		String query = "UPDATE accounts SET balance = (balance + ?) WHERE user_id = ?";
		jdbcTemplate.update(query, amount, id);
		return getAccountBalance((int)id);
	}


	@Override
	public double subtractBalance(long id, double amount) {
		if(checkValidTransfer((int)id, amount)) {
			String query = "UPDATE accounts SET balance = (balance - ?) WHERE user_id = ?";
			jdbcTemplate.update(query, amount, id);
		}
		else {
			System.out.println("Transaction could not be completed: Not enough money in account");
			System.out.println("Get a Job.");
		}
		return getAccountBalance((int)id);
	}


	@Override
	public boolean checkValidTransfer(long id, double amount) {
		
		if(amount > getAccountBalance((int)id)) {
			return false;
		}
		return true;
	}
	
	private Account mapRowToAccount(SqlRowSet result) {
		Account account = new Account();
		account.setAccountId(result.getInt("account_id"));
		account.setBalance(result.getDouble("balance"));
		account.setUserId(result.getInt("user_id"));
		return account;
	}


	@Override
	public Account getAccountByUserId(long id) {
		String query = "SELECT * FROM accounts WHERE user_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query, id);
		if(results.next()) {
			return mapRowToAccount(results);
		}
		System.out.println("Account not found");
		return null;
		
	}
	
	

}
