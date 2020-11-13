package com.techelevator.frank;

import java.time.LocalDate;

public class Coin extends CollectionItem {

	int    coinYear;
	char   coinMint;
	String coinFace;
	String coinMaterial;
		
	public Coin(String itemName, LocalDate whenAddedToCollection, int purchaseAmt, boolean willingToSell, int coinYear,
			char coinMint, String coinFace, String coinMaterial) {
		super(itemName, whenAddedToCollection, purchaseAmt, willingToSell);
		this.coinYear = coinYear;
		this.coinMint = coinMint;
		this.coinFace = coinFace;
		this.coinMaterial = coinMaterial;
	}

	@Override
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
		Coin other = (Coin) obj;
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
