package com.techelevator;

public class TriangleWall extends Wall {
	
	/*******************************************************************
	 * Instance Variables
	 *******************************************************************/
	
	private int base;
	private int height;
	
	/*******************************************************************
	 * Constructor
	 *******************************************************************/
	
	public TriangleWall(String name, String color, int base, int height) {
		super(name, color);
		this.base = base;
		this.height = height;
	}
	
	/*******************************************************************
	 * Getters
	 *******************************************************************/
	
	public int getBase() {
		return base;
	}

	public int getHeight() {
		return height;
	}
	
	
	/*******************************************************************
	 * Methods
	 *******************************************************************/
	
	
	@Override
	public int getArea() {
		return (getBase() * getHeight()) / 2;
	}
	
	

	@Override
	public String toString() {
		return getName() + " (" +  getBase() + "x" + getHeight() + ") " + "triangle";
	}

	

}
