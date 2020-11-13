package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		Map<String, String> animals = new TreeMap<String, String>();
		
		if (animalName == null) { // check if null was entered
			return "unknown";
		}
		
		String name = ""; // declear name string because Eclipse was upset
		
		animals.put("rhino", "Crash"); // my map
		animals.put("giraffe", "Tower");
		animals.put("elephant", "Herd");
		animals.put("lion", "Pride");
		animals.put("crow", "Murder");
		animals.put("pigeon", "Kit");
		animals.put("flamingo", "Pat");
		animals.put("deer", "Herd");
		animals.put("dog", "Pack");
		animals.put("crocodile", "Float");
		
		
		if (animals.get(animalName.toLowerCase()) != null) { // if we have a name return the name of it's pack
			name = animals.get(animalName.toLowerCase());
		} else { // else return unknown
			name = "unknown";
		}
		
		
		return name;
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		Map<String, Double> item = new HashMap<String, Double>(); // new map
		
		double discount = 0.00;
		
		if (itemNumber == null) { // check if input is empty
			return discount;
		}
		
		item.put("KITCHEN4001", 0.20); // defines out new map
		item.put("GARAGE1070", 0.15);
		item.put("LIVINGROOM", 0.10);
		item.put("KITCHEN6073", 0.40);
		item.put("BEDROOM3434", 0.60);
		item.put("BATH0073", 0.15);
		
		if (item.get(itemNumber.toUpperCase()) != null) { // if the item has a discount
			discount = item.get(itemNumber.toUpperCase()); // variable discount is set to that number
		} else { // else return 0
			discount = 0.00;
		}
		
		
		return discount;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		
		int halfPeter = peterPaul.get("Peter") / 2; // divide by two out here so there is not a rounding error with int
		int Peter = peterPaul.get("Peter");
		
		if (peterPaul.get("Peter") > 0 && peterPaul.get("Paul") < 1000) { // if Peter has more than 0 and Paul has less than 10
			peterPaul.put("Paul", peterPaul.get("Paul") + halfPeter); // adds half Peters money
			peterPaul.put("Peter", Peter - halfPeter); // Subtracts half of Peters money from Peter
		} else {
			return peterPaul; // else do nothing
					
		}
		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		
		int peter = peterPaul.get("Peter"); // Variables 
		int paul = peterPaul.get("Paul"); 
		int peterFourth = peter / 4; 
		int paulFourth = paul / 4; 
		int combined = paulFourth + peterFourth; 
		
		if (peter >= 5000 && paul >= 10000) { // if Peter has more than 50$ and Paul has more than 100
			peterPaul.put("Paul", paul - paulFourth); // subtract a 1/4 from Peter and Paul
			peterPaul.put("Peter", peter - peterFourth);
			peterPaul.put("PeterPaulPartnership", combined); // add in the combined
			return peterPaul;
		} else {
			return peterPaul;
		}
		
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		
		Map<String, String> returnMap = new HashMap<String, String>(); // new map
		
		
		for (int i = 0; i <= words.length-1; i++) {
			returnMap.put(words[i].charAt(0) + "", words[i].charAt(words[i].length()-1) + ""); // make the beginning and end letter strings and add them to the new map
		}
		return returnMap;
		
		
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> multiple = new HashMap<String, Integer>();
		
		
		for (String s : words) {
			
			if (!multiple.containsKey(s)) { // if a word doesn't appear twice 
				multiple.put(s, 1); // put a one with the word
			} else {
				int howMany = multiple.get(s); // .get() returns the value of the specified key
				multiple.put(s, howMany + 1); // put the word with the number of times it occurred
			}
		}
		return multiple;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> intCount = new HashMap<Integer, Integer>();

		
		for (int i : ints) {
			if (!intCount.containsKey(i)) {
				intCount.put(i, 1);
			} else {
				int count = intCount.get(i);
				intCount.put(i, count + 1);
			}
		}
		
		return intCount;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		Map<String, Boolean> returnMap = new HashMap<String, Boolean>();
		
		for (String s : words) {
			
			if (!returnMap.containsKey(s)) {
				returnMap.put(s, false);
			} else {
				returnMap.put(s, true);
			}
		}
		return returnMap;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse, Map<String, Integer> remoteWarehouse) {
		Set<String> keys = remoteWarehouse.keySet();

		for (String s : keys) {
			if(!mainWarehouse.containsKey(s)) { // if the key isn't in the main string add it
				mainWarehouse.put(s, remoteWarehouse.get(s));
			} else {
				mainWarehouse.put(s, mainWarehouse.get(s) + remoteWarehouse.get(s)); // if it is add the numbers together
			}
		}
		
		return mainWarehouse;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		
		return null;
	}

}
