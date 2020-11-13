package com.techelevator.tenmo.model;

import java.text.NumberFormat;

public class Transfer {
	private int transferId;
	private int transferTypeId;
	private int transferStatusId;
	private int accountFrom;
	private int accountTo;
	private double amount;
	
	// transfer types, TODO create values for types
	
	// transfer statuses, TODO create values for statuses
	
	public int getTransferId() {
		return transferId;
	}
	
	/*********************************************
	 * Getters and Setters
	 *********************************************/
	
	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}
	
	public int getTransferTypeId() {
		return transferTypeId;
	}
	
	public void setTransferTypeId(int transferTypeId) {
		this.transferTypeId = transferTypeId;
	}
	
	public int getTransferStatusId() {
		return transferStatusId;
	}
	
	public void setTransferStatusId(int transferStatusId) {
		this.transferStatusId = transferStatusId;
	}
	
	public int getAccountFrom() {
		return accountFrom;
	}
	
	public void setAccountFrom(int accountFrom) {
		this.accountFrom = accountFrom;
	}
	
	public int getAccountTo() {
		return accountTo;
	}
	
	public void setAccountTo(int accountTo) {
		this.accountTo = accountTo;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		
		String typeString = "";
		
		switch(transferTypeId) {
		
		case 1:
			typeString = "Request";
			break;
		case 2:
			typeString = "Send";
			break;
		}
		
		String s = "";
		
		switch(transferStatusId) {
		case 1:
			s = "Pending";
			break;
		case 2:
			s = "Approved";
			break;
		case 3:
			s = "Rejected";
			break;
		}
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		
		return "___________________________________________________\nTransfer id: " + transferId + "\n Transfer Type: " + typeString + "\n Transfer Status id:" + s + "\n account from: "  + accountFrom + "\n account to: " + accountTo + "\n amount: " + formatter.format(amount);
	}
	
	
	

}


