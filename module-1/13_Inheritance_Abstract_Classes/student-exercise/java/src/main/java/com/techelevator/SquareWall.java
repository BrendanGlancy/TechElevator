package com.techelevator;

public class SquareWall extends RectangleWall{
	
	/*******************************************************************
	 * Instance Variable
	 *******************************************************************/
	
	private int sideLength;
	
	/*******************************************************************
	 * Constructor
	 *******************************************************************/
	
	
	public SquareWall(String name, String color, int sideLength) {
		super(name, color, sideLength, sideLength);
		this.sideLength = sideLength;
	}
	
	/*******************************************************************
	 * Getter
	 *******************************************************************/
	
	public int getSideLength() {
		return sideLength;
	}



	/*******************************************************************
	 * Method toString()
	 *******************************************************************/
	
	public String toString() {
		return getName() + " (" +  getSideLength() + "x" + getSideLength() + ") " + "square";
	}

	@Override
	public int getArea() {
		return getSideLength() * getSideLength();
	}
	

}
