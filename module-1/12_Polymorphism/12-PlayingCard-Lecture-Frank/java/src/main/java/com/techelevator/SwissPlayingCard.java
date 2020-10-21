package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SwissPlayingCard extends PlayingCard {
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 6;

	private static Map<String,  String> suitMap  = new HashMap<String , String>();  
	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>(); 
	
	static {
		initializeMaps();
	}
	
	public SwissPlayingCard() 
	{
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);
	} 

	public SwissPlayingCard(int value, String suit) {
		super(value,                                                        // Call super ctor with value passed
			  suitMap.containsKey(suit) ? suit : DEFAULTSUIT,               // If valid suit passed, use it otherwise use DEFAULTSUIT
			  suitMap.get(suit) != null ? suitMap.get(suit) : DEFAULTCOLOR);// If valid suit passed, use color for suit otherwise use DEFAULTCOLOR  
		
		if (value > MAXVALUE) {
			setValue(MAXVALUE);
		}
		if (value < MINVALUE) {
			setValue(MINVALUE);
		}
	}
		
	

	static private void initializeMaps() {
		suitMap.put("BALLS"    , "YELLOW");
		suitMap.put("SHIELDS"  , "BLACK");
		suitMap.put("ROSES"    , "RED");
		suitMap.put("ACORNS"   , "GREEN");
		suitMap.put(DEFAULTSUIT, DEFAULTCOLOR);
		
		valueMap.put(0 ,"Joker");
		valueMap.put(1 ,"As");
		valueMap.put(6 ,"Six");
		valueMap.put(7 ,"Seven");
		valueMap.put(8 ,"Eight");
		valueMap.put(9 ,"Nine");
		valueMap.put(10,"Banner");
		valueMap.put(11,"Under");
		valueMap.put(12,"Ober");
		valueMap.put(13,"König");
	}
	
	@Override
	public String toString() {
		return "SwissPlayingCard: " 
	          +"Value: "    + valueMap.get(getValue())
	          +" - Color: " + suitMap.get(getSuit()) 
			  +" - Suit: "  + getSuit()
			  +" - super.toString()=" + super.toString() + "\n";
	}

	public void showCard() {
		System.out.println(this.toString());
	}
}
