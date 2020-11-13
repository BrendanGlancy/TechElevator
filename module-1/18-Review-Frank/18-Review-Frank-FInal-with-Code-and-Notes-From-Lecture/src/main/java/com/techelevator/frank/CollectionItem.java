package com.techelevator.frank;

import java.time.LocalDate;
/***************************************************************************************************
 * Define a generic Collection item - common data and methods
 * 
 * Used as a super class to each individual item type - not meant instantiated - abstract
 * 
 * Because it contains data and/or methods with bodies - it cannot be an interface
 **************************************************************************************************		// Use LocalDateTime.now() to get the current date and time to millisecond
*/
public abstract class CollectionItem {
	
	private String itemName;
	private LocalDate whenAddedToCollection;  // This is a LocalDate object NOT a String
	private int purchaseAmt;                  // pennies not dollars
	private boolean willingToSell;            // boolean NOT a String
	
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

	@Override
	// toString() is used by Java whenever it needs a String version of your class
	//            like for displaying with System.out.print
	// If the toString() method is not specified for the Class, the Object class toString() method is used
	//            which returns a String contain   package-name.ClassName@Location (Not the data in your class)
	public String toString() {
		// return a String with the name of the class and an identifier for each data item=value for the item
		return "CollectionItem [itemName=" + itemName + ", whenAddedToCollection=" + whenAddedToCollection
				+ ", purchaseAmt=" + purchaseAmt + ", willingToSell=" + willingToSell + "]";
	}

	@Override
	// Object is the super class for all Object in Java
	// To make a method parameter as generic as possible, define it as an Object type
	//           so any type of object can be sent in to the method as a parameter
	//  CollectionItemObject.equals(anotherObject)
	//         this                    obj
	public boolean equals(Object obj) { // this equals() is receive any type of object as a parameter 
		if (this == obj)  // is the object passed as a parameter the same as the object we're comparing it to
			return true;  //       if it is, they're equal
		if (obj == null)  // is the object passed null
			return false; //       if it is, they're not equal
		if (getClass() != obj.getClass())  // is the class of the object passed NOT the same as the class of the object being compared to
			return false;                  //     if it is, they're not equal
		CollectionItem other = (CollectionItem) obj;  // instantiate a specific class object for the generic Object passed
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
