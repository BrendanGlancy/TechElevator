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
	
	public ItalianPlayingCard() 
	{
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);
		initializeMaps();
	} 

	public ItalianPlayingCard(int value, String suit) {
		super(value, suit, suitMap.get(suit));{
	
		if (value > MAXVALUE) {
			setValue(MAXVALUE);
		}
		if (value < MINVALUE) {
			setValue(MINVALUE);
		}
		if (value > 7 && value < 10) {
			setValue(MINVALUE);
		}
		initializeMaps();
		}
		
	}

	private void initializeMaps() {
		suitMap.put("COINS"  , "YELLOW");
		suitMap.put("CUPS"   , "BLUE");
		suitMap.put("SWORDS" , "RED");
		suitMap.put("BATONS" , "BLACK");
		
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
