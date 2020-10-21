package com.techelevator.frank;

import java.time.LocalDate;

public class Wine extends CollectionItem {

	// Additional data needed by this class no provided by super class
	int wineYear;
	String wineMaker;
	String wineCountry;
	String wineVariety;

	// Additional methods needed by this class no provided by super class
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
