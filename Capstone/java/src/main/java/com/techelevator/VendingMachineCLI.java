package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**************************************************************************************************************************
*  This is your Vending Machine Command Line Interface (CLI) class
*
*  It is the main process for the Vending Machine
*
*  THIS is where most, if not all, of your Vending Machine interactions should be coded
*  
*  It is instantiated and invoked from the VendingMachineApp (main() application)
*  
*  Your code vending machine related code should be placed in here
***************************************************************************************************************************/

import com.techelevator.view.Menu;         // Gain access to Menu class provided for the Capstone

public class VendingMachineCLI {

    // Main menu options defined as constants

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE      = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
	private static final String MAIN_MENU_OPTION_SALESREPORT   = "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE,
													    MAIN_MENU_OPTION_EXIT,
													    MAIN_MENU_OPTION_SALESREPORT
													    };
	
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {
			PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION
	};
	
	private static final String FEED_OPTION_1 = "add $1";
	private static final String FEED_OPTION_2 = "add $2";
	private static final String FEED_OPTION_3 = "add $5";
	private static final String FEED_OPTION_4 = "add $10";
	private static final String FEED_OPTION_5 = "Exit the menu";
	private static final String[] FEED_MENU_OPTIONS = { FEED_OPTION_1,
														   FEED_OPTION_2,
														   FEED_OPTION_3,
														   FEED_OPTION_4,
														   FEED_OPTION_5};
	
	// Set up the way we are formatting our Date
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
	Date date = new Date();
	
	// Set up the way we return the change
	CustomerMoney currentMoney = new CustomerMoney();
	MakeChange makeChange = new MakeChange();
	List<String> audit = new ArrayList<String>();
	
	static VendingMachineOptions foodChoices; // Make a new LinkedHashMap under the same name 
	
	// Set up the file we will be writing to
	File log = new File("log.txt");
	static File salesReportFile = new File("SalesReport.txt");
	//static File salesReportFile = new File("/Users/brendanglancy/Desktop/TE/Capstone/capstone/java-module-1-capstone-team-2/Capstone/java" ,"SalesReport.txt");

	// instantiate a new map to put the sales report in
	private static LinkedHashMap<String, Integer> salesReportMap = new LinkedHashMap<>();

	
	private Menu vendingMenu;              // Menu object to be used by an instance of this class
	
	// Scanner to read in input
	static Scanner input = new Scanner(System.in);
	
	// Constructor
	public VendingMachineCLI(Menu menu) throws FileNotFoundException {  // Constructor - user will pas a menu for this class to use
		this.vendingMenu = menu;           // Make the Menu the user object passed, our Menu
		foodChoices = new VendingMachineOptions();
	
	}
	/**************************************************************************************************************************
	*  VendingMachineCLI main processing loop
	*  
	*  Display the main menu and process option chosen
	*
	*  It is invoked from the VendingMachineApp program
	*
	*  THIS is where most, if not all, of your Vending Machine objects and interactions 
	*  should be coded
	*
	*  Methods should be defined following run() method and invoked from it
	 * @throws IOException 
	*
	***************************************************************************************************************************/

	public void run() throws IOException {
		
		

		boolean shouldProcess = true;         // Loop control variable
		
		while(shouldProcess) {                // Loop until user indicates they want to exit
			
			String choice = (String)vendingMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS);  // Display menu and get choice
			
			switch(choice) {                  // Process based on user menu choice
			
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					displayItems();           // invoke method to display items in Vending Machine
					break;                    // Exit switch statement
			
				case MAIN_MENU_OPTION_PURCHASE:
					purchaseItems();          // invoke method to purchase items from Vending Machine
					break;                    // Exit switch statement
			
				case MAIN_MENU_OPTION_EXIT:
					endMethodProcessing();    // Invoke method to perform end of method processing
					shouldProcess = false;    // Set variable to end loop
					break;                    // Exit switch statement
					
				case MAIN_MENU_OPTION_SALESREPORT:
					getSalesReportMap();
					break;
			}	
		}
		return;                               // End method and return to caller
	}

/********************************************************************************************************
 * Methods used to perform processing
 *
 * @throws I/OException 
 ********************************************************************************************************/

	public void displayItems() throws FileNotFoundException {      // static attribute used as method is not associated with specific object instance
		// Code to display items in Vending Machine
		System.out.println("Number of choices = " + foodChoices.getFoodChoices().size());
		for (String f : foodChoices.getFoodChoices().keySet()) {
			
			System.out.print(" " + foodChoices.getFoodChoices().get(f).getSlot() + " |");
			System.out.print(" " + foodChoices.getFoodChoices().get(f).getName() + " |");
			System.out.print(" " + foodChoices.getFoodChoices().get(f).getPrice() + " | ");
			
			if (foodChoices.getFoodChoices().get(f).getInventory() != 0) { // if we have enough inventory
				System.out.println(foodChoices.getFoodChoices().get(f).getInventory());
			} else {
				System.out.println("SOLD OUT"); // if we don't print sold out
				
			}
		}
	}

/********************************************************************************************************
 * Methods used to purchase an item out of the vending machine
 *
 * @throws I/OException 
 ********************************************************************************************************/
	
	public void purchaseItems() throws IOException {	 // static attribute used as method is not associated with specific object instance
		
		try(PrintWriter logFileWriter = new PrintWriter(log)) { // try to create 
		
		System.out.println("Current Money Provided: " + currentMoney.getCurrentMoney());
		
		String purchaseItemChoice = (String)vendingMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
		
		
		while (true) {
		if (purchaseItemChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
			
			while (true) {
				
				String feedMoneyOptions = (String)vendingMenu.getChoiceFromOptions(FEED_MENU_OPTIONS);
				
				double add = 0; // Store the amount of money put into the machine
				System.out.println("Option chosen = " + feedMoneyOptions);
				

/********************************************************************************************************
 * Logic to feed money into the machine and record 
 ********************************************************************************************************/

			if(feedMoneyOptions.equals(FEED_OPTION_1)) {
				currentMoney.addCurrentMoney(1.0);
				add = 1.0;
				
			} else if (feedMoneyOptions.equals(FEED_OPTION_2)) {
				currentMoney.addCurrentMoney(2.0);
				add = 2.0;
			
			} else if (feedMoneyOptions.equals(FEED_OPTION_3)) {
				currentMoney.addCurrentMoney(5.0);
				add = 5.0;
				
			} else  if (feedMoneyOptions.equals(FEED_OPTION_4)){
				currentMoney.addCurrentMoney(10.0);
				add = 10.0;
				
			} else if (feedMoneyOptions.equals(FEED_OPTION_5)) {
				System.out.println("Exiting..");
				break;
			} 
			// add the the audit string in a format for log.txt
			audit.add(dateFormat.format(date) + " FEED MONEY: " + "$" + String.format("%.2f", add) + "      " + "$" + String.format("%.2f" , currentMoney.getCurrentMoney()));
			
			}
				
			
			
			
			
		} else if (purchaseItemChoice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
			
			// show the list of products available
			
			for (String s : foodChoices.getFoodChoices().keySet()) {
				
				
				System.out.print(" " + foodChoices.getFoodChoices().get(s).getSlot() + " |");
				System.out.print(" " + foodChoices.getFoodChoices().get(s).getName() + " |");
				System.out.print(" " + foodChoices.getFoodChoices().get(s).getPrice() + " | ");
				
				if (foodChoices.getFoodChoices().get(s).getInventory() != 0) { // if we have enough inventory
					System.out.println(foodChoices.getFoodChoices().get(s).getInventory());
				} else {
					System.out.println("SOLD OUT"); // if we don't print sold out
					
				}
				
			} 
			
			// customer enters a code to select an item
				
			

				System.out.print("Please enter the code of the item you would like: ");

				String itemCodeChoice = input.nextLine().toUpperCase();
				double priorBalance = 0.00;
				
					if (currentMoney.getCurrentMoney() < foodChoices.getFoodChoices().get(itemCodeChoice).getPrice() || foodChoices.getFoodChoices().get(itemCodeChoice) == null && foodChoices.getFoodChoices().get(itemCodeChoice).getInventory() >= 0){
						System.out.println("Insufficient Funds");
					}
					
					else {
						
						

						System.out.println(foodChoices.getFoodChoices().get(itemCodeChoice).dispense(foodChoices.getFoodChoices().get(itemCodeChoice).getName()) + " There are: " + foodChoices.getFoodChoices().get(itemCodeChoice).getInventory() + " Left in Inventory");
						
						if(foodChoices.getFoodChoices().get(itemCodeChoice).getInventory() >= 0) {
							currentMoney.subtractCurrentMoney(foodChoices.getFoodChoices().get(itemCodeChoice).getPrice());
							priorBalance = (currentMoney.getCurrentMoney() + foodChoices.getFoodChoices().get(itemCodeChoice).getPrice());
							// add the the audit string in a format for log.txt
							audit.add(dateFormat.format(date) + " " + foodChoices.getFoodChoices().get(itemCodeChoice).getName() + "      " +(foodChoices.getFoodChoices().get(itemCodeChoice).getSlot() 
									+ " $" + priorBalance + " $" + currentMoney.getCurrentMoney()));
							
						} 
						
					}


					
					

				
			// if the code doesn't exist customer is informed and returned to the purchase menu
			
			// if the product is sold out, the customer is informed and returned to the purchase menu
			
			// if a valid product is selected it is dispensed to the customer
			
			// Update current money
			
			// Return to the purchase menu
			
	} else if (purchaseItemChoice.equals(PURCHASE_MENU_FINISH_TRANSACTION)){
			// add the the audit string in a format for log.txt
			audit.add(dateFormat.format(date) + " " + "GIVE CHANGE: " + "$" + String.format("%.2f", currentMoney.getCurrentMoney())
				+ " $" + String.format("%.2f", 0.0));
			System.out.println("Your Change is: " + MakeChange.makeChange(currentMoney.getCurrentMoney()));
			currentMoney.subtractCurrentMoney(currentMoney.getCurrentMoney());
			
			// customer's money is returned using nickels, dimes, quarters (smallest amount of coins possible)
			
			// The machine's current balance should be updated to $0
			
			// user should be returned to the main menu to continue using the vending machine
			
			// Write the transaction to log.txt
			
			
			
			
				
				System.out.println("Log file exists: " + log.exists());
				System.out.println("Lines in audit: " + audit.size());

				for (String j : audit) {
					
					logFileWriter.println(j + "\n");
					
				
				}
				
				logFileWriter.flush();
				logFileWriter.close();
				}
			
			
			break;
			
			}
		
		
		
		}
		
		
		
	}
	
	public void endMethodProcessing() { // static attribute used as method is not associated with specific object instance
		
		
	}
	
public static void getSalesReportMap() throws FileNotFoundException {
		

		PrintWriter pw = new PrintWriter(salesReportFile); // New print writer for the sales report
		
		for (String s : foodChoices.getFoodChoices().keySet()) { // iterate through the keyset of foodChoices
			
			if (foodChoices.getFoodChoices().get(s).getInventory() < 5) { // if theres less than 5 left
				
				salesReportMap.put(foodChoices.getFoodChoices().get(s).getName(), 5 - foodChoices.getFoodChoices().get(s).getInventory()); // put Name of the item and how many were sold 
			}
			
		}
		
		
		System.out.println("Sales Report file exists: " + salesReportFile.exists());
		
		System.out.println("Lines in sales report: " + salesReportMap.size()); // stops at this line
		
		// keep track of how much money was spent
		double salesTotal = 0.00;
		
		
		for (Map.Entry<String, Integer> entry : salesReportMap.entrySet()) { // go through separate the strings and int 
			String key = entry.getKey();
			int value = entry.getValue();
			pw.println(key + "|" + value); 
			
		}
		

		// iterater through any items that were sold and add their price to salesTotal
		for (String f : foodChoices.getFoodChoices().keySet()) {
			
				if (foodChoices.getFoodChoices().get(f).getInventory() < 5) {
					salesTotal += foodChoices.getFoodChoices().get(f).getPrice();

			}
			

		}
		// print total sales then flush and close
		pw.println("Total Sales: $" + salesTotal);
		pw.flush();
		pw.close();
	}
	
	
}
