package com.techelevator;

/***************************************************************************************
 * Generic Playing Card Class
 ***************************************************************************************/
public class PlayingCard {
	/***************************************************************************************
	 * Member Instance Variables - Each instance of the class gets a set
	 ***************************************************************************************/
	private int value;          // Card value
	private String color;       // Card color  
	private String suit;        // Card suit 

	/***************************************************************************************
	 * 3-arg constructor when user uses value, suit and color to instantiate 
	 ***************************************************************************************/
	
	public PlayingCard(int value, String suit, String color) {
		this.value = value;   // this object's value should be set equal to the parameter called value
		this.suit  = suit;
		this.color = color;
	}

	/***************************************************************************************
	 * Getters - allow users to "see" the values in a Playing Card object
	 ***************************************************************************************/
	public int getValue() {
		return value;
	}
	public String getColor() {
		return color;
	}
	public String getSuit() {
		return suit;
	}
	/***************************************************************************************
	 * Setters - allow users to change the values in a Playing Card object
	 ***************************************************************************************/
	public void setValue(int value) {
		this.value = value;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	/***************************************************************************************
	 * toString() override for the Object class: String toString() 
	 *                            to present the values of a Playing Card object as a String
	 ***************************************************************************************/
	@Override   // for the Object class: String toString() 
	public String toString() {
		return "PlayingCard [value=" + value + ", color=" + color + ", suit=" + suit + ", getValue()=" + getValue()
				+ ", getColor()=" + getColor() + ", getSuit()=" + getSuit() + "]";
	}
	/***************************************************************************************
	 * equals() override for the Object class: boolean equals(Object) 
	 *                   to allow users to see if two Playing Cards have all the same values
	 ***************************************************************************************/
	@Override  // for the Object class: boolean equals(Object) 
	public boolean equals(Object obj) {    // Note: Parameter is a generic Object class because this is an override
		if (this == obj) {                 // If PlayingCard is being compared to itself...
			return true;                   //      it must be equal - return false
		}
		if (obj == null) {                 // If PlayingCard is being compared to a null object...
			return false;                  //       it must be unequal - return false
		}
		if (getClass() != obj.getClass()) {// If PlayingCard is being compared to a non-PlayingCard object...
			return false;                  //       it must be unequal - return false
		}
		PlayingCard other = (PlayingCard) obj; // Instantiate a PlayingCard from the object passed as parametr
		if (color != other.color) {            // If colors are not	equal...
			return false;                      //       it must be unequal - return false
		}
		if (suit != other.suit) {              // If suits are not equal...
			return false;                      //       it must be unequal - return false
		}
		if (value != other.value) {            // If values are not equal...
			return false;                      //       it must be unequal - return false
		}
		return true;                           // All of the above are true, the objects are equal - return true
	}
	/***************************************************************************************
	 * clone() method to create a copy of a PlayingCard from a PlayingCard
	 ***************************************************************************************/
	public PlayingCard clone() {
		return new PlayingCard(this.value, this.suit, this.color);  // Use 3-arg ctor to create ne object
	}
}
