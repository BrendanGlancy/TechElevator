package com.techelevator.frank;

import java.time.LocalDate;

public class VinylRecord extends CollectionItem{

	int yearRecorded;
	String artist;
	String label;
	double diameter;
	int speed;

	public VinylRecord(String itemName, LocalDate whenAddedToCollection, int purchaseAmt, boolean willingToSell,
			int yearRecorded, String artist, String label, double diameter, int speed) {
		super(itemName, whenAddedToCollection, purchaseAmt, willingToSell);
		this.yearRecorded = yearRecorded;
		this.artist = artist;
		this.label = label;
		this.diameter = diameter;
		this.speed = speed;
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
		VinylRecord other = (VinylRecord) obj;
		if (artist == null) {
			if (other.artist != null) {
				return false;
			}
		} else if (!artist.equals(other.artist)) {
			return false;
		}
		if (Double.doubleToLongBits(diameter) != Double.doubleToLongBits(other.diameter)) {
			return false;
		}
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		if (speed != other.speed) {
			return false;
		}
		if (yearRecorded != other.yearRecorded) {
			return false;
		}
		return true;
	}



	@Override
	public String toString() {
		return "VinylRecord [yearRecorded=" + yearRecorded + ", artist=" + artist + ", label=" + label + ", diameter="
				+ diameter + ", speed=" + speed + ", getItemName()=" + getItemName() + ", getWhenAddedToCollection()="
				+ getWhenAddedToCollection() + ", getPurchaseAmt()=" + getPurchaseAmt() + ", isWillingToSell()="
				+ isWillingToSell() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}

	
	

}
