package com.techelevator;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PlayingCard {
	
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "JOKER";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;
	private static Map<String,  String> suitMap  = new HashMap<String , String>();  
	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>();
	
	static {              // Call static method to initialize maps 
		                  //   Run when first object is instantiated before the constructor
		initializeMaps(); // static method to initialize maps
	}
	
	private int value;    
	private String color;    
	private String suit;     
	
	
	public PlayingCard(int value, String suit) {
		setValue(value);
		setSuit(suit);     // suit must be set before setColor can run successfully
		setColor();
	}
	
	public int getValue() {
		return value;
	}
	public String getColor() {
		return color;
	}
	public String getSuit() {
		return suit;
	}
	public void setValue(int value) {
		if (value >= MINVALUE && value <= MAXVALUE) { // if valid value specified
		this.value = value;                           // set value to value specified
		}
		else {
			this.value = DEFAULTCARDVALUE;            // set value to default if invalid value specified
	    }
	}
	public void setColor() {
		this.color = this.suitMap.get(suit.toUpperCase());
	}
	public void setSuit(String suit) {
		this.suit = suit.toUpperCase();
		if (this.suit == null) {         // if invalid suit specified
			this.suit = DEFAULTSUIT;     // set suit to default suit
		}
	}
	public String getValueName() {
		return valueMap.get(getValue());
	}
	
	static private void initializeMaps() {   // needs to be static due to use in static method above
		suitMap.put("SPADES"   , "BLACK");
		suitMap.put("CLUBS"    , "BLACK");
		suitMap.put("DIAMONDS" , "RED");
		suitMap.put("HEARTS"   , "RED");
		suitMap.put(DEFAULTSUIT, DEFAULTCOLOR);
		
		valueMap.put(0,"Joker");
		valueMap.put(1,"Ace");
		valueMap.put(2,"Two");
		valueMap.put(3,"Three");
		valueMap.put(4,"Four");
		valueMap.put(5,"Five");
		valueMap.put(6,"Six");
		valueMap.put(7,"Seven");
		valueMap.put(8,"Eight");
		valueMap.put(9,"Nine");
		valueMap.put(10,"Ten");
		valueMap.put(11,"Jack");
		valueMap.put(12,"Queen");
		valueMap.put(13,"King");
	}
	
	@Override   // Ask compiler to verify this is a proper Override - same name, same parameters, same return-type
	public String toString() {
		return "PlayingCard [value=" + value + ", color=" + color + ", suit=" + suit + ", getValue()=" + getValue()
				+ " getValueName()=" + getValueName() + ", getColor()=" + getColor() + ", getSuit()=" + getSuit() + "]";
	}
	
	@Override   // Ask compiler to verify this is a proper Override - same name, same parameters, same return-type
	public boolean equals(Object obj) {  // Receive any type of Object
		if (this == obj) {  // If compare a PlayingCard to itself
			return true;
		}
		if (obj == null) {  // If compare to an undefined PlayingCard
			return false;
		}
		if (getClass() != obj.getClass()) {  // If compare to an object of a different class
			return false;                    // getClass() return the Class of an object
		}
		PlayingCard other = (PlayingCard) obj;  // Define a PlayingCard for the object that was passed
		if (color != other.color) {
			return false;
		}
		if (suit != other.suit) {
			return false;
		}
		if (value != other.value) {
			return false;
		}
		return true;
	}
}
