package com.techelevator;
/*******************************************************************
 * The `Wall` class can't be instantiated.
 *******************************************************************/

public abstract class Wall {
	
	/*******************************************************************
	 * Instance Variables
	 *******************************************************************/
	
	private String name;
	private String color;
	
	/*******************************************************************
	 * Constructor
	 *******************************************************************/
	
	
	public Wall(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	/*******************************************************************
	 * Getters
	 *******************************************************************/
	
	
	public String getName() {
		return name;
	}


	public String getColor() {
		return color;
	}
	
	

	/*******************************************************************
	 * 
	 * It also has one public method that subclasses must implement. `getArea()
 	 *  takes no parameters and returns an integer representing the total area of the wall.
 	 *  
	 *******************************************************************/
	
	
	public abstract int getArea(); // this is an abstract method which meaning no return statement in this class

	

	

	

	

}
