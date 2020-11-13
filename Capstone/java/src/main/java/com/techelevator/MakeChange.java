package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class MakeChange {


	
	public static String makeChange (double currentMoney) {

	/*********************************************
	 * Instance Variables
	 *********************************************/

		Coin[] coins = new Coin[] { new Quarter(), new Dime(), new Nickel() }; // Instantiate 
		currentMoney *= 100; // multiply the amount of money we have by 100 so it's in cent's
		String result = "";
		
		Map<Coin, Integer> change = new HashMap<Coin, Integer>(); // New Hashmap to store our change
		
		for (Coin coin : coins) { // iterate through the array of coins
			
			if (currentMoney <= 0) { // if there's no money no change
				break;
			}
			
			int cents = (int)currentMoney / coin.getValue(); // find out how many cents are owed by dividing currentmoney by the coins
			
			if (cents > 0) { // if we have change to give
				currentMoney = currentMoney % (coin.getValue() * cents);
				change.put(coin, cents);
			}
		}
		
		for (Coin coin : change.keySet()) {
			result += (change.get(coin) + " " + coin.getName() + "(s)" + " "); // format to return the change
			
		}
		
		return result;
		
		
	}

}
