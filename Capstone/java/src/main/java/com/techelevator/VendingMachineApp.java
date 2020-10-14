package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.techelevator.view.Menu;   // Bring in Menu class provided

public class VendingMachineApp {
	/*************************************************************************************************************************
	*  This is the application program to instantiate the VendingMachineCLI main program and start it running
	*  
	*  DO NOT PUT ANY NEW CODE HERE WITHOUT CHECKING WITH YOUR INSTRUCTOR FIRST!
	 * @throws IOException 
	***************************************************************************************************************************/
		
		public static void main(String[] args) throws IOException {
			Menu appMenu = new Menu(System.in, System.out);                // Instantiate a menu for Vending Machine CLI main program to use
			VendingMachineCLI vendingCli = new VendingMachineCLI(appMenu); // Instantiate the Vending Machine CLI main program passing it the Menu object to use
			vendingCli.run();                                              // Tell the Vending MachineCLI process to start running
		}
	}


