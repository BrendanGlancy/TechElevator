package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*********************************************
 * The class for our Display of the CSV file
 *********************************************/


public class VendingMachineOptions {
	
	Map<String, Item> foodChoices;
	
	public VendingMachineOptions() throws FileNotFoundException {
		foodChoices = new LinkedHashMap<>();
		getMapOfItem();
		
	}
	
	public Map<String, Item> getFoodChoices() {
		return foodChoices;
	}

	public Map<String, Item> getMapOfItem() throws FileNotFoundException {
		
		/*********************************************
		 * File scanner to read in the CSV file
		 *********************************************/
		
		String fileName = "";
		
		
		
		/*********************************************
		 * WARNING 
		 *
		 * Hard Coded file names
		 *********************************************/
		
	
			//fileName = "/Users/brendanglancy/Desktop/TE/Capstone/capstone/java-module-1-capstone-team-2/Capstone/java/vendingmachine.csv";
		
			fileName = "vendingmachine.csv";
		
		File vendingMachineInventory = new File(fileName);
		
		
		
		try(Scanner fileScanner = new Scanner(vendingMachineInventory)) {
			
		/*********************************************
		 * While the file has next line
		 * 
		 * Take the line and split it into String[] by |
		 * Instantiate a new item type
		 * Set Slot Price and Name
		 *********************************************/

			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] splitLine = line.split("\\|");
				
				switch (splitLine[0].charAt(0)) {
				case 'A':
					ChipItem chips = new ChipItem();
					chips.setSlot(splitLine[0]);
					chips.setName(splitLine[1]);
					chips.setPrice(Double.parseDouble(splitLine[2]));
					foodChoices.put(splitLine[0], chips);
					break;
				case 'B':
					CandyItem candy = new CandyItem();
					candy.setSlot(splitLine[0]);
					candy.setName(splitLine[1]);
					candy.setPrice(Double.parseDouble(splitLine[2]));
					foodChoices.put(splitLine[0], candy);
					break;
				case 'C':
					BeverageItem beverage = new BeverageItem();
					beverage.setSlot(splitLine[0]);
					beverage.setName(splitLine[1]);
					beverage.setPrice(Double.parseDouble(splitLine[2]));
					foodChoices.put(splitLine[0], beverage);
					break;
				case 'D':
					GumItem gum = new GumItem();
					gum.setSlot(splitLine[0]);
					gum.setName(splitLine[1]);
					gum.setPrice(Double.parseDouble(splitLine[2]));
					foodChoices.put(splitLine[0], gum);
					break;
				// Default means we have no CSV file 
				default:
					System.out.println("Souce file not found");
				}
			}
		}
		return foodChoices;
}
	
}// logic to verify if the file exits..

