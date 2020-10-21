package com.techelevator;

public class PlayingCard {
	// A class to represent/model a PlayingCard

	/*******************************************
	 * Define the data members of the class
	 * 
	 * Data in a class includes an access modifier that specifies 
	 * who/what has access to the data
	 * 
	 * public - anyone has access
	 * private - only members of the class
	 * 
	 * 
	 *******************************************/
	private int cardValue; // value of the card ace - 1, j - 11, q - 12, k - 13
	private String cardSuit; // suit of the card
	private String cardShape;
	private String cardColor;
	private boolean faceUp;

	/*******************************************
	 * Methods to support the class
	 *******************************************/
	
	// toString() method to convert our class to a string
	// access modifier, return type, name(parameters)
	// An override is a method with the same name and parameters as a higher level method, but different level behavior

	public String toString() { // returns a string
		return "Card Value: " + cardValue + "\nCard suit: " + cardSuit + "\nCard shape: " + cardShape + "\nCard Color: " + cardColor + "\nFace up or Down(T/F): " + faceUp;
	} // wow my first class in Java, for Tech Elevator

	/*******************************************
	 * Methods initialize a new object - we want to control the values assigned to our objects
	 * 
	 * a constructor is a class method that initializes object for the class when they are created
	 * 
	 * Constructors have special requirements:
	 * 
	 * 1. They have the same name as the class
	 * 2. They cannot return anything - not even void - omit the return datatype on the signature 
	 * 3.
	 * 
	 * You may have as many constructors as you would like as long as the Parameters are different
	 * 
	 * a default construction as you need as long as the parameters are different
	 * 
	 * If you don't provide a constructor Java runs it's own default constructor which initializes:
	 * numeric to 0, Objects to null and boolean to false
	 * 
	 * 
	 *******************************************/
	
	// a default constructor - create a default PlayingCard
	
	// default cardValue - 1 (Ace)
	// default cardSuit - Spades
	// default cardColor - Black
	// default cardSpace - Rectangle 
	// default faceUp - false
	
	public PlayingCard() { // default constructor
		cardValue = 1;
		cardSuit = "Spades";
		cardColor = "Black";
		cardShape = "Rectangle";
		faceUp = false;
	}

	// Create a constuctor to create a PlayingCard with value entered by the user

	public PlayingCard(int value, String suit, String color, boolean faceUp) {
		cardValue = value;
		cardSuit = suit;
		cardColor = color;
		cardShape = "Rectangle";
		this.faceUp = faceUp; // Parameter has the same name as a data member variable 
		// the data member is used instead of the parameter
		// instead of changing the name, use the this.

		// getters and setters
		// getter - returns value from the class to the user
		// setter - receive value from the user to set data member

		// Eclipse can write the getters and setters for you
		
	
		


	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public String getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}

	public String getCardShape() {
		return cardShape;
	}

	public void setCardShape(String cardShape) {
		this.cardShape = cardShape;
	}

	public String getCardColor() {
		return cardColor;
	}

	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}


}
