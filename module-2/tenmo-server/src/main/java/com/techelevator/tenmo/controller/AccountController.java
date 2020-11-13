package com.techelevator.tenmo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AccountDAO;
import com.techelevator.tenmo.model.JDBCAccountDAO;
import com.techelevator.tenmo.security.jwt.TokenProvider;

@RestController
public class AccountController {

    private JDBCAccountDAO accountDAO;
    
    
    // Constructor
    public AccountController(JDBCAccountDAO accountDAO) {
       this.accountDAO = accountDAO;
    }
    

    @RequestMapping(value = "accounts", method = RequestMethod.GET)
    public List<Account> listAllAccounts() {
    	List<Account> account = accountDAO.getAllAccounts();
    	
    	return account;
    }
    
    @RequestMapping(value = "accounts/{id}", method = RequestMethod.GET)
    public Account getAccountByUserId(@PathVariable long id) {
    	Account account = accountDAO.getAccountByUserId(id);
    	return account;
    	
    }
    
    @RequestMapping(value = "accounts/send", method = RequestMethod.PUT)
    public void transferMoney(@RequestParam(value="account_from") Long fromId,
							  @RequestParam(value="account_to") Long toId, 
							  @RequestParam(value="amount") double amount) {
    	logAPIcall("Sending $" + amount + " from " + fromId + " to " + toId);
    	accountDAO.addBalance(toId, amount);
    	accountDAO.subtractBalance(fromId, amount);
    }
    
    public void logAPIcall(String message) {
    	LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
	    String timeNow = now.format(formatter);
	    System.out.println(timeNow + ": " + message);
    }
}
