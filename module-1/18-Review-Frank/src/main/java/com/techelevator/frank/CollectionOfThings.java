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

public class CollectionOfThings {
	
	public static enum ITEM_TYPE {VINYL, COIN, STAMP, WINE, THING };
	
	Map<ITEM_TYPE,List<CollectionItem>> itemsInCollection;

	// Default Constructor
	public CollectionOfThings() throws FileNotFoundException {
		// Instantiate a Map and assign to our member data variable
		// To initalize the item map data must be loaded from a file


		itemsInCollection = new HashMap<ITEM_TYPE,List<CollectionItem>>(); // value is a List of Collection Item Objects
		
		loadCollectionFromFile();	
	}

	public void addItem(char itemCode, CollectionItem anItem) {
		
		ITEM_TYPE itemType = ITEM_TYPE.THING;
		
		switch (itemCode) {
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
		List<CollectionItem> listOfItems = new ArrayList<>();
		if (itemsInCollection.containsKey(itemType)) {  // if the item collection Map has an entree for this type
			listOfItems = itemsInCollection.get(itemType); // retrieve the ArrayList associated with it
		}
		listOfItems.add(anItem); // Add the new item to the ArrayList
		itemsInCollection.put(itemType, listOfItems); // Put the ArrayList bakc in the Map with the item type as key
		}
	
	public void displayCollection() {

		// Displays each item in the item collection map
		
		Set<ITEM_TYPE> theKeys = itemsInCollection.keySet(); // Get a set of the Key values for the Map
		
		for(ITEM_TYPE anItemKey : theKeys) {
			List<CollectionItem> theItems = itemsInCollection.get(anItemKey);
			
			System.out.println("\nThere are " 
			                  + itemsInCollection.get(anItemKey).size() // The number of elements in the ArrayList retrieved from the map
			                  + " " + anItemKey // Displays the key
			                  + " items in the Collection");
			
			for (CollectionItem anItem : theItems) // Loop through the ArrayList retrieved from the Map one element at a time
				System.out.println(anItem); // Display the current element - the class of the objects toString()
		}
	}
	
	// if you have something complicated to do you should seprate it into different methods and then call the methods
	// if you have more than 10 lines make it a method, so it's easier to read Franks Words, not exacty Java rule
	private void loadCollectionFromFile() throws FileNotFoundException  {

		// TODO - add code to verify the file exists
	
		File collectionFile = new File("collection.txt");
		Scanner theCollectionFile = new Scanner(collectionFile);
	
		while (theCollectionFile.hasNextLine()) {
			String theLine = theCollectionFile.nextLine();
			if (theLine.startsWith("*")) {
				continue;
			}
			String lineFields[] = theLine.split("\\|"); // Split the line into individual string values 
			// Because the | in java is a reserved character we have to use the escape sequence -> \\
		
			switch (lineFields[0]) {
				case "C":
					addCoin2Collection(lineFields);
					break;
				case "W":
					addWine2Collection(lineFields);
					break;
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
	
	// Convert the data from the file from a String to the type required by the Coin class before I can create the 
	public CollectionItem addCoin2Collection(String[] fieldsInLine) {
		String[] dateParts = fieldsInLine[2].split("/");
		LocalDate purchaseDate =  LocalDate.of(Integer.parseInt(dateParts[2]) // Convert the year as a String to an int
				                             , Integer.parseInt(dateParts[0]) // Convert the month as a String to an int
				                            , Integer.parseInt(dateParts[1])); // Convert the day as a String to an int
		
		int purchaseAmt = (int) (Double.parseDouble(fieldsInLine[3]) * 100);
		
		Coin aCoin = new Coin (fieldsInLine[1]
				              ,purchaseDate
				              ,purchaseAmt
				              ,Boolean.parseBoolean(fieldsInLine[4]) // You can do the conversion in the arguement
				              ,Integer.parseInt(fieldsInLine[5])
				              ,fieldsInLine[6].charAt(0)
				              ,fieldsInLine[7]
				              ,fieldsInLine[8]);	
		
		addItem(fieldsInLine[0].charAt(0), aCoin); // Call the addItem() with the item type character ('C', 'W', 'V')
		
		return aCoin;
	}
	
	private void addWine2Collection(String[] fieldsInLine) {
		// TODO - Add Wine item to collection
	}
	
	private void addVinyl2Collection(String[] fieldsInLine) {
		// TODO - Add Vinyl item to collection
	}
	
	}
	
	

