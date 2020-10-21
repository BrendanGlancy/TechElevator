package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/****************************************************************************************************
 * American Playing Card Class - subclass of generic PlayingCard
 ***************************************************************************************************/

public class AmericanPlayingCard extends PlayingCard  {
	/************************************************************************************************
	 * Constants for values related to American Playing Cards
	 ***********************************************************************************************/	
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;

	/**************************************************************************************************
	 * Maps used to validate/limit suits, colors and value names for American Playing Cards
	 * 
	 * Maps are static because we only need one instance for all objects to use
	 * The data in the Maps will be same for all instances of objects 
	 *     and doesn't change for any object
	 *************************************************************************************************/	
	
	private static Map<String,  String> suitMap  = new HashMap<String , String>();  
	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>(); 
	
	/***************************************************************************************************
	 *Invoke method to populate maps with valid suits, colors & value names for American Playing Cards
	 *
	 * We need to define an anonymous static method to run the inializeMaps() method.
	 * This will be run automatically when the process using this class is started
	 * 
	 * Normally a class method is run when it is used with an object of the class.
	 * 
	 * static methods may be run without an object of a class.
	 * 
	 * any static initialization methods must be run when a process first starts
	 **************************************************************************************************/	
	
	static {             // static anonymous method to initialize maps before are ever used
       initializeMaps();
    }
	/***************************************************************************************************
	 * 0-arg / Default Constructor
	 **************************************************************************************************/		
	public AmericanPlayingCard() // subclass, default ctor
	{
		// The very first thing a subclass constructor must do is invoke a super class ctor
		// the keyword super is used to reference the anything in the super class
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);  // Invoke 3-arg ctor in superclass
	} 
	/***************************************************************************************************
	 * 2-arg Constructor for a user provided value and suit
	 ***************************************************************************************************/	
	public AmericanPlayingCard(int value, String suit) {
		// call the super class 3-arg ctor with the value and suit from the user
		//    and the color for the suit from our suitMap
		//    we are calling the class member method using the return value as a parameter
		//    we are NOT handling what if user gives us an invalid suit - null as color
		//
		// If you see the word super followed by parens it's referencing a super class ctor
		
		super(value, suit, suitMap.get(suit));       // Determine color and call super class 3-arg ctor
	
		// once the super class object is initialized - check the value and make it correct
		
		if (value > MAXVALUE) {                      // If value provided is greater than max value allowed         
			setValue(MAXVALUE);                      //      set it to max value allowed
		}
		if (value < MINVALUE) {                      // If value provided is greater than min value allowed  
			setValue(MINVALUE);                      //      set it to min value allowed
		}
	}
	/****************************************************************************************************
	 * Initialize Maps to valid suit/color combinations and value names
	 * 
	 * static for a method means there is only one regardless of the number of instantiated objects
	 *                           it can only change static data members
	 *                           the Maps are defined as static for the class
	 ***************************************************************************************************/	
	private static void initializeMaps() {
		// suitMap contains valid suits and their associated color
		//     if the gives us a suit not in this Map, we know it's an invalid suit
		suitMap.put("SPADES"  , "BLACK");
		suitMap.put("CLUBS"   , "BLACK");
		suitMap.put("DIAMONDS", "RED");
		suitMap.put("HEARTS"  , "RED");
	  
		// valueMap - associate word to values of the cards
		
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
	/***********************************************************************************************
	 * toString() override for the PlayingCard class: String toString() 
	 *                            to present the values of a AmericanPlaying Card object as a String
	 ************************************************************************************************/
	@Override   // for the Object class: String toString() 
	public String toString() {
		return "AmericanPlayingCard [value=" + getValue() + ", color=" + getColor() + ", suit=" + getSuit() +"]";
	}
}








