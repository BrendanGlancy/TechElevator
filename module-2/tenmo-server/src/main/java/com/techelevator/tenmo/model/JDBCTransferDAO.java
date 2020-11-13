package com.techelevator.tenmo.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCTransferDAO implements TransferDAO {

	private JdbcTemplate jdbcTemplate;
	
	/*********************************************
   	 * Constructor
   	 *********************************************/
	
	public JDBCTransferDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/*********************************************
   	 * Method to get all transfers 
   	 * returns a list
   	 *********************************************/
	
	@Override
	public List<Transfer> getAllTransfers() {
		List<Transfer> transfers = new ArrayList<>();
		String query = "SELECT * FROM transfers";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query);
		while(results.next()) {
			Transfer transferResult = mapRowToTransfer(results);
			transfers.add(transferResult);
		}
		return transfers;
	}
	
	/*********************************************
   	 * Method to get all transfers by id
   	 * returns a list
   	 *********************************************/

	@Override
	public Transfer getTransferById(int id) {
		String query = "SELECT * FROM transfers WHERE transfer_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query, id);
		if(results.next()) {
			return mapRowToTransfer(results);
		}
		System.out.println("No transfer exists with the id " + id);
		return null;
	}

	private Transfer mapRowToTransfer(SqlRowSet results) {
		Transfer transfer = new Transfer();
		transfer.setAccountFrom(results.getInt("account_from"));
		transfer.setAccountTo(results.getInt("account_to"));
		transfer.setAmount(results.getDouble("amount"));
		transfer.setTransferId(results.getInt("transfer_id"));
		transfer.setTransferStatusId(results.getInt("transfer_status_id"));
		transfer.setTransferTypeId(results.getInt("transfer_type_id"));
		return transfer;
	}
	
	/*********************************************
   	 * Method to send a transfer
   	 *********************************************/

	/*@Override
	public void sendTransfer(Transfer newTransfer) {
		
		String sqlCreateTransfer = "INSERT INTO transfers (name) VALUES (?) RETURNING transfer_id";
		Long id = jdbcTemplate.queryForObject(sqlCreateTransfer, Long.class, Transfer.getTransferId());
		
	}*/
	
	/*********************************************
   	 * Method to get all transfers by account id
   	 *********************************************/
	
	@Override
	public List<Transfer> getAllTransfersByAccountId(int id) {
		List<Transfer> transfers = new ArrayList<>();
		String query = "SELECT * FROM transfers WHERE account_from IN(?) OR account_to IN(?)";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query, id, id);
		while(results.next()) {
			Transfer transfer = mapRowToTransfer(results);
			transfers.add(transfer);
		}
		return transfers;
	}
	
	/*********************************************
   	 * Method to get all transfers from an account id
   	 *********************************************/
	
	@Override
	public List<Transfer> getTransfersByFromId(int id) {
		List<Transfer> transfers = new ArrayList<>();
		String query = "SELECT * FROM transfers WHERE account_from IN(?) OR account_to IN(?)";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query, id, id);
		while(results.next()) {
			Transfer transfer = mapRowToTransfer(results);
			transfers.add(transfer);
		}
		return transfers;
	}
	
	/*********************************************
   	 * Method to get all transfers to an account id
   	 *********************************************/
	
	@Override
	public List<Transfer> getTransfersByToId(int id) {
		List<Transfer> transfers = new ArrayList<>();
		String query = "SELECT * FROM transfers WHERE account_from IN(?) OR account_to IN(?)";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query, id, id);
		while(results.next()) {
			Transfer transfer = mapRowToTransfer(results);
			transfers.add(transfer);
		}
		return transfers;
	}
	
	/*********************************************
   	 * Method to create a transfer
   	 *********************************************/
	
	public Transfer createTransfer(Transfer transfer) {
		String query = "INSERT INTO transfers (transfer_type_id, transfer_status_id, account_from, account_to, amount)"
					+  " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, transfer.getTransferTypeId(), transfer.getTransferStatusId(), 
				transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
		return transfer;
	}
	
	public void updateTransferStatus(int transId, int statusId) {
		String query = "UPDATE transfers SET transfer_status_id = ? WHERE transfer_id = ?";
		jdbcTemplate.update(query, statusId, transId);
	}
}
