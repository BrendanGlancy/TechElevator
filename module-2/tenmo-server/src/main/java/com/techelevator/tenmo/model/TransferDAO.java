package com.techelevator.tenmo.model;

import java.util.List;

public interface TransferDAO {
	
	public List<Transfer> getAllTransfers();
	public Transfer getTransferById(int id);
	
	
	
	public List<Transfer> getAllTransfersByAccountId(int id);
	public List<Transfer> getTransfersByFromId(int id);
	public List<Transfer> getTransfersByToId(int id);
}
