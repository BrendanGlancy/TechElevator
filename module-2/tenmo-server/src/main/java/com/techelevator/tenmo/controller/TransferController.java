package com.techelevator.tenmo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.exceptions.BrokeUserException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.JDBCAccountDAO;
import com.techelevator.tenmo.model.JDBCTransferDAO;
import com.techelevator.tenmo.model.Transfer;

@RestController
public class TransferController {

	
	private JDBCTransferDAO transferDAO;
	private JDBCAccountDAO accountDAO;
    
    
    // Constructor
    public TransferController(JDBCTransferDAO transferDAO, JDBCAccountDAO accountDAO) {
       this.transferDAO = transferDAO;
       this.accountDAO = accountDAO;
    }
    
    @RequestMapping(value = "transfers", method = RequestMethod.GET)
    public List<Transfer> listAllTransfers() {
    	List<Transfer> transfer = transferDAO.getAllTransfers();
    	logAPICall("GET - transfers");
    	return transfer;
    }
    
    @RequestMapping(value = "transfers/{id}", method = RequestMethod.GET)
    public Transfer getTransferById(@PathVariable int id) {
    	Transfer transfer = transferDAO.getTransferById(id);
    	logAPICall("GET - transfers by id: " + id);
    	return transfer;
    }
    
    @RequestMapping(value = "transfers/accounts/{id}", method = RequestMethod.GET)
    public List<Transfer> getAllTransfersByAccountId(@PathVariable int id) {
    	List<Transfer> transfers = transferDAO.getAllTransfersByAccountId(id);
    	return transfers;
    }
    
    @RequestMapping(value = "transfers/accountFrom/{id}")
    public List<Transfer> getTransfersByAccountFromId(@PathVariable int id) {
    	List<Transfer> transfers = transferDAO.getTransfersByFromId(id);
    	return transfers;
    }
    
    @RequestMapping(value = "transfers/accountTo/{id}")
    public List<Transfer> getTransfersByAccountToId(@PathVariable int id) {
    	List<Transfer> transfers = transferDAO.getTransfersByToId(id);
    	return transfers;
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "transfers", consumes = "application/json", method = RequestMethod.POST)
    public Transfer createTransfer(@RequestBody Transfer transfer) throws BrokeUserException {
    	logAPICall("Sending $" + transfer.getAmount() + 
			" from " + transfer.getAccountFrom() + " to " + transfer.getAccountTo());
    	Transfer transfers =  transferDAO.createTransfer(transfer);
		try {
			updateAccountBalance(transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
		} catch(BrokeUserException ex) {
			System.out.println(ex);
		}
    	return transfers;
    }
    
    public void logAPICall(String message) {
    	LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
	    String timeNow = now.format(formatter);
	    System.out.println(timeNow + ": " + message);
    }
    
    
    @RequestMapping(method = RequestMethod.PUT)
    private void updateAccountBalance(int accountFrom, int accountTo, double amount) throws BrokeUserException {
    	if(accountDAO.checkValidTransfer(accountFrom, amount)) {
        	logAPICall("Updating balances");
    		accountDAO.addBalance(accountTo, amount);
    		accountDAO.subtractBalance(accountFrom, amount);
    	}
    	else {
    		throw new BrokeUserException("Transfer amount was greater than account balance.");
    	}
    }
    
    @RequestMapping(value = "transfers/status/{statusId}/", method = RequestMethod.PUT)
    public void updateTransferStatus(@PathVariable int statusId, @RequestParam(value = "transId") int transId) {
    	transferDAO.updateTransferStatus(transId, statusId);
    }
}
