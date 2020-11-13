package com.techelevator.frank;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/******************************************************************************************
 * This class will be used to hold a information about various things a user might collect
 * 
 * A text file called collection.txt will have one line for each item a person collects
 * 
 * The file containing the items will be loaded in to a Collection class object for ease
 *     access and manipulation
 *****************************************************************************************/
public class CollectionOfThings {

	// enum provides a data type limited to specific constant values
	// as a data type variables can be defined as the enum type 
	// variables defined as an enum may be assigned the constants defined for the enum
	// use enum when you want to limit the values for a variable to a know set of values
	
	// It's OK to make enum public so users have access because they are constants they can't be changed
	// enums are generally defined as static so there is only one copy shared by all objects of the class
	public static enum ITEM_TYPE {VINYL, COIN, STAMP, WINE, THING };  // Allowable values for items in the collection
	
	// The items will be stored in a Map with the item type as the key and a list of objects as the value
	// We are associating an ITEM_TYPE with a List of all of the items of that type we are holding
	Map<ITEM_TYPE,List<CollectionItem>> itemsInCollection;

	// Default ctor
	public CollectionOfThings() throws FileNotFoundException {
		// ctor are run whenever and object of the class is instantiated
		// This ctor will instantiate and initialize any objects necessary
		//     To initialize the item map data must be loaded from a file
		
		// Instantiate a Map and assign to our member data variable
		itemsInCollection = new HashMap<ITEM_TYPE,List<CollectionItem>>(); // value is a List of Collection Item objects

		// Method in the class to load the items from the file into our item Map
		loadCollectionFromFile();	
	}
// Add a CollectionItem object to our item Map - receives teh itemCode from the file 'C' 'W' 'V' and teh object to be added
	public void addItem(char itemCode, CollectionItem anItem) {
		
		ITEM_TYPE itemType = ITEM_TYPE.THING;   // Set the default ITEM_TYPE to be a generic THING
		
		switch (itemCode) {   // Set the ITEM_TYPE to the approprate value based on the item code in the file
			case 'v': 
			case 'V':
				itemType = ITEM_TYPE.VINYL;
				break;
			case 'c': 
			case 'C':
				itemType = ITEM_TYPE.COIN;
				break;
			case 's': 
			case 'S':
				itemType = ITEM_TYPE.STAMP;
				break;
			case 'w': 
			case 'W':
				itemType = ITEM_TYPE.WINE;
				break;
			default:
				itemType = ITEM_TYPE.THING;
		}
		// At the point we have everything we need to add the item to item collection Map
		
		List<CollectionItem> listOfItems = new ArrayList<>();  // Instantiate an ArrayList to hold the new item in case we don't already have one
		
		if (itemsInCollection.containsKey(itemType)) {     // if the item collection Map has an entry for this type
			listOfItems = itemsInCollection.get(itemType); // retrieve the ArrayList associated with it 
		}                                                  //    and assign it to the ArrayList we created above
	    // At this point the listOfItems ArrayList is either empty or the the one from the Map
		
		listOfItems.add(anItem);                     // Add the new item to the ArrayList
		itemsInCollection.put(itemType, listOfItems);// Put the ArrayList back in the map with the item type as key
		}
	
	public void displayCollection() {
		
		// Display each item in the item collection Map
		
		Set<ITEM_TYPE> theKeys = itemsInCollection.keySet();   // Get a set of the keys values for the Map
		
		for(ITEM_TYPE anItemKey : theKeys) {                   // Loop through the key values from beginning to end
			List<CollectionItem> theItems = itemsInCollection.get(anItemKey);  // Retrieve the value for the current key
			
			System.out.println("\nThere are " 
			                  + itemsInCollection.get(anItemKey).size() // The number of elements in the ArrayList retrieved from the Map
			                  + " " + anItemKey                         // Display the current key for the Map
			                  + " items in the Collection");
	//     define an object of the super class (CollectionItem)
			for (CollectionItem anItem : theItems)    // Loop through the ArrayList retrieved from the Map one element at a time
				System.out.println(anItem);           // display the current element - the class of the object's toString() is used
		}                                             //    Polymorphism is used to run the appropriate ToString()
	}
	// This method will load the collection data from a file into the item Map
	private void loadCollectionFromFile() throws FileNotFoundException  {
	
		// TODO - add code to verify the file actually exists and is a file
		
		File collectionFile = new File("collection.txt");         // Define a File object for the disk file
		Scanner theCollectionFile = new Scanner(collectionFile);  // Define a Scanner object for the File object
	
		while (theCollectionFile.hasNextLine()) {           // Loop as long as there are lines in the file
			String theLine = theCollectionFile.nextLine();  // Read a line from the file and store it in theLine variable
			if (theLine.startsWith("*")) {                  // If the line starts with an "*", it's a comment
				continue;                                   //    so skip processing of the line - ignore the line
			}
			String lineFields[] = theLine.split("\\|");     // split the line into individual String values based on the |
		                                                    // because the | has a special meaning in Java - use the escape sequence for |
// switch as alternative to a series of if, ==, else statement 
			switch (lineFields[0]) {                // Look at linesFields[0]
				case "C":                           // if it's a "C"
					addCoin2Collection(lineFields); //    add it to item collection as a Coin passing the array of fields from the line
					break;                          //    and go to the end of the switch
				case "W":                           // if it's a "W"
					addWine2Collection(lineFields); //    add it to item collection as a Wine passing the array of fields from the line
					break;                          //    and go to the end of the switch
				case "V":
					addVinyl2Collection(lineFields);
					break;
			}
		
//		System.out.println("--------------------------");
//		for (String aField : lineFields) {
//			System.out.println(aField);
//		}
		}
			theCollectionFile.close();
	}
	
	public CollectionItem addCoin2Collection(String[] fieldsInLine) { // Add the data from the file as a Coin to the item collection
		// Convert the data from the file from a String to the type required by the Coin class before I can create the Coin
		//                   purchaseDate from file
		String[] dateParts = fieldsInLine[2].split("/");                     // separate the month/day/year into separate Strings

		// LocalDate.of() will create a LocalDate object from integers passed in as year, month, day
		LocalDate purchaseDate =  LocalDate.of(Integer.parseInt(dateParts[2])  // Convert the year as a String to an int
				                             , Integer.parseInt(dateParts[0])  // Convert the month as a String to an int
				                             , Integer.parseInt(dateParts[1]));// Convert the day as a String to an int
		
		int purchaseAmt = (int) (Double.parseDouble(fieldsInLine[3]) * 100); // Convert amt from "3.00" (double value) to pennies
		
		// Instantiate a Coin object using the data from the file to add to the item collection Map
		Coin aCoin = new Coin (fieldsInLine[1]
				              ,purchaseDate
				              ,purchaseAmt
				              ,Boolean.parseBoolean(fieldsInLine[4])  // You may be able to do conversions in the argument
				              ,Integer.parseInt(fieldsInLine[5])      // You may be able to do conversions in the argument
				              ,fieldsInLine[6].charAt(0)              // charAt(index) return the char at the index of a String
				              ,fieldsInLine[7]
				              ,fieldsInLine[8]);	
		
		addItem(fieldsInLine[0].charAt(0), aCoin);  // Call the addItem() with the item type character ('C', 'W', 'V')
		                                            //      and CollectionItem object (Coin in this case)
		
		return aCoin;
	}
	
	private void addWine2Collection(String[] fieldsInLine) {
		// TODO - Add Wine item to collection
	}
	
	private void addVinyl2Collection(String[] fieldsInLine) {
		// TODO - Add Vinyl item to collection
	}
	
	}
	
	

