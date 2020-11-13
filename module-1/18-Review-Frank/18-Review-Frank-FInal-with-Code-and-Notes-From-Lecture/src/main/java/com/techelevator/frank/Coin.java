package com.techelevator.frank;

import java.time.LocalDate;
/*****************************************************************************************
 * This is a subclass of Collection item
 * 
 * it only needs to specify things it needs not provided by super class
 *****************************************************************************************/
public class Coin extends CollectionItem {

	// Additional data needed by this class no provided by super class
	
	int    coinYear;
	char   coinMint;      // a single character NOT a String
	String coinFace;
	String coinMaterial;
		
	// Additional methods needed by this class no provided by super class
	public Coin(String itemName, LocalDate whenAddedToCollection, int purchaseAmt, boolean willingToSell, int coinYear,
			char coinMint, String coinFace, String coinMaterial) {
		super(itemName, whenAddedToCollection, purchaseAmt, willingToSell);
		this.coinYear = coinYear;
		this.coinMint = coinMint;
		this.coinFace = coinFace;
		this.coinMaterial = coinMaterial;
	}

	@Override
	// CoinObject,equals(anotherObject)
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Coin other = (Coin) obj;  // Instantiate a Coin from the generic object passed in
		if (coinFace == null) {
			if (other.coinFace != null) {
				return false;
			}
		} else if (!coinFace.equals(other.coinFace)) {
			return false;
		}
		if (coinMaterial == null) {
			if (other.coinMaterial != null) {
				return false;
			}
		} else if (!coinMaterial.equals(other.coinMaterial)) {
			return false;
		}
		if (coinMint != other.coinMint) {
			return false;
		}
		if (coinYear != other.coinYear) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Coin [coinYear=" + coinYear + ", coinMint=" + coinMint + ", coinFace=" + coinFace + ", coinMaterial="
				+ coinMaterial + ", getItemName()=" + getItemName() + ", getWhenAddedToCollection()="
				+ getWhenAddedToCollection() + ", getPurchaseAmt()=" + getPurchaseAmt() + ", isWillingToSell()="
				+ isWillingToSell() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
}
