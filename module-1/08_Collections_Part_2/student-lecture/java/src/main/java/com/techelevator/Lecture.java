package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

// Map is a Collection Class that allows the storage of key-value pairs
// Use it to associate one value (the key) to another value (the value)
// A map is also known as an associative array

// Keys are unique - only one entry with a specific 

// Types of Maps
// HashMap - unordered 
// TreeMap - ordered map - ordered in key sequence
// LinkedHashMap - ordered map - ordered in which they are added 

// 

//Kinds of maps: HashMap - un-ordered Map - entries may be in any order

// To define a Map:
// Map<key-datatype, value-datatype> name = new HashMap<key-datatype, value-datatype>();


		Map<String, String> residence = new HashMap<String, String>();

		// Add some entries to the Map
		residence.put("Brendan", "North Canton");
		residence.put("Brandon", "Mayfield");
		residence.put("Jake", "Cleveland");
		residence.put("Cody", "Akron");
		residence.put("Boris", "Twinsburg");

		System.out.println("Cody lives in " + residence.get("Cody")); // the method .get() - is case sensitive
		System.out.println("Boris lives in " + residence.get("Boris")); // returns Boris
		System.out.println("Dame Judy Dench lives in " + residence.get("Judy")); // returns nothing because Judy isn't in our list


		System.out.println("--------------------------------------------------------------------------------------");
		// How can we display everything in our map
		// Get a list of all the keys in the map
		// Iterate through the list of keys using a for loop or a for-each loop

		// There's a method Call :
		// .keySet() - Return a Set Object with all the keys in a Map
		
		// A set is a collection class of un-ordered elements that must have unique values
		// (different than an arrayList in that values do not have to unique in Arraylist)
		
		// Set(datatype-of-keys)
		Set<String> theKeys = residence.keySet(); // Get a list of keys in the map and store in theKeys
		
		// Iterate through the set of keys using the values to access the map


		// good way to get all the values in a map
		for (String aName : theKeys) {
			System.out.println("Map key: " + aName + ", Map value: " + residence.get(aName)); // you don't know the order the elements are going to be displayed
		}
		
		// key values in a map must be unique 
		// if you try to add an entry with a key value that already exsist 
		// it doesn't give any indication the key already existed and the value was updated

		System.out.println("Try to add both Jakes");
		residence.put("Jake", "Strongsville");
		
		System.out.println("Jake lives in: " + residence.get("Jake"));

		// Entries can be removed from a map using the .remove() method
		// .remove(key-to-be-removed)

		System.out.println("Frank lives in " + residence.get("Frank")); // removes before
		residence.remove("Frank");
		System.out.println("Frank lives in " + residence.get("Frank")); // and after

		// if you try to remove something that's not in the map no error indication
		
		// residence. all the method you can use with map, there's quite a bit

	}

}
