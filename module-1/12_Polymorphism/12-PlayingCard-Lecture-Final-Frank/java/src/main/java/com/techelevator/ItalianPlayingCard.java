package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ItalianPlayingCard extends PlayingCard {
	
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;

	private static Map<String,  String> suitMap  = new HashMap<String , String>();  
	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>(); 
	
	static {
		initializeMaps();
	}
	
	public ItalianPlayingCard() 
	{
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);
	} 

	public ItalianPlayingCard(int value, String suit) {
		super(value,                                                        // Call super ctor with value passed
			  suitMap.containsKey(suit) ? suit : DEFAULTSUIT,               // If valid suit passed, use it otherwise use DEFAULTSUIT
			  suitMap.get(suit) != null ? suitMap.get(suit) : DEFAULTCOLOR);// If valid suit passed, use color for suit otherwise use DEFAULTCOLOR  
			
		if (value > MAXVALUE) {
			setValue(MAXVALUE);
		}
		if (value < MINVALUE) {
			setValue(MINVALUE);
		}
		if (value > 7 && value < 10) {
			setValue(MINVALUE);
		}
		
	}
		
	static private void initializeMaps() {
		suitMap.put("COINS"    , "YELLOW");
		suitMap.put("CUPS"     , "BLUE");
		suitMap.put("SWORDS"   , "RED");
		suitMap.put("BATONS"   , "BLACK");
		suitMap.put(DEFAULTSUIT, DEFAULTCOLOR);
		
		valueMap.put(0,"Joker");
		valueMap.put(1,"One");
		valueMap.put(2,"Two");
		valueMap.put(3,"Three");
		valueMap.put(4,"Four");
		valueMap.put(5,"Five");
		valueMap.put(6,"Six");
		valueMap.put(7,"Seven");
		valueMap.put(10,"Ten");
		valueMap.put(11,"Fante");
		valueMap.put(12,"Cavallo");
		valueMap.put(13,"Re");
	}
	
	@Override
	public String toString() {
		return "ItalianPlayingCard: " 
	          +"Value: "    + valueMap.get(getValue())
	          +" - Color: " + suitMap.get(getSuit()) 
			  +" - Suit: "  + getSuit()
			  +" - super.toString()=" + super.toString() + "\n";
	}

	public void showCard() {
		System.out.println(this.toString());
	}
}
