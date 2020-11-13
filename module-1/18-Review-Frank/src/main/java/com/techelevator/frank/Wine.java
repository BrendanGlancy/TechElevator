package com.techelevator.frank;

import java.time.LocalDate;

public class Wine extends CollectionItem {

	int wineYear;
	String wineMaker;
	String wineCountry;
	String wineVariety;

	public Wine(String itemName, LocalDate whenAddedToCollection, int purchaseAmt, boolean willingToSell, int wineYear,
			String wineMaker, String wineCountry, String wineVariety) {
		super(itemName, whenAddedToCollection, purchaseAmt, willingToSell);
		this.wineYear = wineYear;
		this.wineMaker = wineMaker;
		this.wineCountry = wineCountry;
		this.wineVariety = wineVariety;
	}
	@Override
	public String toString() {
		return "Wine [wineYear=" + wineYear + ", wineMaker=" + wineMaker + ", wineCountry=" + wineCountry
				+ ", wineVariety=" + wineVariety + ", getItemName()=" + getItemName() + ", getWhenAddedToCollection()="
				+ getWhenAddedToCollection() + ", getPurchaseAmt()=" + getPurchaseAmt() + ", isWillingToSell()="
				+ isWillingToSell() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}

	

	
	
}
