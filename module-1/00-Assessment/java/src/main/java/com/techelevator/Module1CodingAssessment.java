package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	/*********************************************
	 * Instance Variables
	 *********************************************/
	 
	 private String title = "";
	 private String format = "";
	 private boolean isPremiumMovie;
	 private double rentalPrice = 0;
	 
	 public int daysLate;
	 static List<String> inputList;
	 
	 
	/*********************************************
	 * Constructor
	 * 
	 * @param title
	 * @param format
	 * @param isPrimiumMovie
	 *********************************************/
	 
	 public Module1CodingAssessment(String title, String format, boolean isPremiumMovie) {
		 this.title = title;
		 this.format = format;
		 this.isPremiumMovie = isPremiumMovie;
	 }
	 
	 /*********************************************
	 * Main Method
	 * @throws IOException 
	 *********************************************/
	 
	 public static void main(String[] args) {
		 // Instantiate an object (or objects) in main() or Main() and use the object(s) to test your methods.
		 Module1CodingAssessment.readIn();
		
		 
	 }
	 
	 /*********************************************
	 * Read In Method
	 * @return 
	 * @throws IOException 
	 *********************************************/
	 
	 public static void readIn() throws IOException {
		 File movieInput = new File("/Users/brendanglancy/Desktop/TE/brendanglancy-java/module-1/00-Assessment/java/MovieInput.csv");
		 
		 try(Scanner fileScanner = new Scanner(movieInput)) {
			 while (fileScanner.hasNextLine()) {
				 String line = fileScanner.nextLine();
				 String[] splitLine = line.split(",");
				 setTitle(splitLine[0]);
				 setFormat(splitLine[1]);
				 inputList.add(line);
				 if (splitLine[2].equals("FALSE")) {
					 setPremiumMovie(false);
				 } else if (splitLine[2].equals("TRUE")) {
					 setPremiumMovie(true);
				 }
				 
				
				
				 
			 }
			 
		 }
		 }
	 
	 
	 /*********************************************
	 * Create a method that determines the movie's late fee using an input
	 * 
	 * @param daysLate
	 *********************************************/
	 
	 public Double lateFee(int daysLate) {
		 
		 double returnMoney = 0.00;
		 
		 if (daysLate == 0) {
			 returnMoney = 0.00;
		 } else if (daysLate == 1) {
			 returnMoney = 1.99;
		 } else if (daysLate == 2) {
			 returnMoney = 3.99;
		 } else if (daysLate >= 3) {
			 returnMoney = 19.99;
		 }
		 
		 return returnMoney;
	 }
	 
	 /*********************************************
	 * Override Method
	 * 
	 * toString() -
	 * "MOVIE - {title} - {format} {rental price}" where {title}, {format}, and {rental price}
	 *********************************************/
	 
	 @Override
	 public String toString() {
		 return ("MOVIE - " + getTitle() + getFormat() + getRentalPrice());
	 }
	 
	/*********************************************
	* Getters
	*********************************************/

	public String getTitle() {
		return title;
	}

	public int getDaysLate() {
		return daysLate;
	}

	public String getFormat() {
		return format;
	}

	public boolean isPremiumMovie() {
		return isPremiumMovie;
	}
	
	public double getRentalPrice() {
		
		if (getFormat().equals("VHS")) {
			rentalPrice = 0.99;
		} else if (getFormat().equals("DVD")) {
			rentalPrice = 1.99;
		} else if (getFormat().equals("BluRay")) {
			rentalPrice = 2.99;
		}
		
		if (isPremiumMovie() == true) {
			rentalPrice += 1;
		}
		return rentalPrice + lateFee(daysLate);
	}
	
	/*********************************************
	* Setters
	*********************************************/

	public static void setPremiumMovie(boolean isPremiumMovie) {
		this.isPremiumMovie = isPremiumMovie;
	}

	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public void setDaysLate(int daysLate) {
		this.daysLate = daysLate;
	}
	
	public static void setTitle(String title) {
		this.title = title;
	}
	
	public static void setFormat(String format) {
		this.format = format;
	}

}
