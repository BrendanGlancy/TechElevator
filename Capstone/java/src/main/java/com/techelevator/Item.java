package com.techelevator;

public interface Item {

	// Get the name of the item type
	public String getName();
	
	// Get the price of the item type
	public Double getPrice();
	
	// Get the slot of the item type
	public String getSlot();
	
	// Get the inventory of the item type
	public int getInventory();
	
	// Method to purchase an item 
	public void purchase();
			
	// Method to dispense an item
	public String dispense(String getName);
	
}
