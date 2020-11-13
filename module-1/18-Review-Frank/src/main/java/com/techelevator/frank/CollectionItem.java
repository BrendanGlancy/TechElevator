package com.techelevator.frank;

import java.time.LocalDate;

/*********************************************************************
* Define a generic Collection item - common data and methods
*
* Used as a super class to each individual item type - not meant instantiated - abstract
*
* Because it contains data and/or methods with bodies - it cannot be an interface
**********************************************************************/

public class CollectionItem {
	
	private String itemName;
	private LocalDate whenAddedToCollection;
	private int purchaseAmt;
	private boolean willingToSell;
	
	public CollectionItem(String itemName, LocalDate whenAddedToCollection, int purchaseAmt, boolean willingToSell) {

		this.itemName = itemName;
		this.whenAddedToCollection = whenAddedToCollection;
		this.purchaseAmt = purchaseAmt;
		this.willingToSell = willingToSell;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public LocalDate getWhenAddedToCollection() {
		return whenAddedToCollection;
	}

	public void setWhenAddedToCollection(LocalDate whenAddedToCollection) {
		this.whenAddedToCollection = whenAddedToCollection;
	}

	public int getPurchaseAmt() {
		return purchaseAmt;
	}

	public void setPurchaseAmt(int purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}

	public boolean isWillingToSell() {
		return willingToSell;
	}

	public void setWillingToSell(boolean willingToSell) {
		this.willingToSell = willingToSell;
	}

	// toString() is used by Java whenever it needs a String version of your class
	// Like for Displaying System.out.print
	// If the toString() method is not specified for the class, the object class toString() method is used
	// Which returns a String contain package-name.ClassName@Location (Not the data in your class)
	@Override
	public String toString() {
		return "CollectionItem [itemName=" + itemName + ", whenAddedToCollection=" + whenAddedToCollection
				+ ", purchaseAmt=" + purchaseAmt + ", willingToSell=" + willingToSell + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + purchaseAmt;
		result = prime * result + ((whenAddedToCollection == null) ? 0 : whenAddedToCollection.hashCode());
		result = prime * result + (willingToSell ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) { // this equals() is receive any type of object as a parameter
		if (this == obj) // is the object passed as a parameter the same as the object we're comparing it to
			return true; // if it is, they're equal
		if (obj == null) // is the object passed null
			return false; // if the object is null they're not equal
		if (getClass() != obj.getClass())
			return false;
		CollectionItem other = (CollectionItem) obj; // Instantiate a specific class object for the generic object passed
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (purchaseAmt != other.purchaseAmt)
			return false;
		if (whenAddedToCollection == null) {
			if (other.whenAddedToCollection != null)
				return false;
		} else if (!whenAddedToCollection.equals(other.whenAddedToCollection))
			return false;
		if (willingToSell != other.willingToSell)
			return false;
		return true;
	}
	
	
	
}
