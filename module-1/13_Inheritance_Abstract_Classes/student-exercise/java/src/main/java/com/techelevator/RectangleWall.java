package com.techelevator;

public class RectangleWall extends Wall {
	
	/*******************************************************************
	 * Instance Variables
	 *******************************************************************/
	
	private int length;
	private int height;
	
	/*******************************************************************
	 * Constructor
	 *******************************************************************/
	
	public RectangleWall(String name, String color, int length, int height) {
		super(name, color);
		this.length = length;
		this.height = height;
	}
	
	
	/*******************************************************************
	 * Getters
	 *******************************************************************/
	
	public int getLength() {
		return length;
	}

	public int getHeight() {
		return height;
	}
	
	
	/*******************************************************************
	 * Methods
	 *******************************************************************/

	
	public int getArea() {
		return getHeight() * getLength();
	}

	/*******************************************************************
	 * Method - toString()
	 *******************************************************************/
	
	public String toString() {
		return getName() + " (" +  getLength() + "x" + getHeight() + ") " + "rectangle";
	}

	

	

}
