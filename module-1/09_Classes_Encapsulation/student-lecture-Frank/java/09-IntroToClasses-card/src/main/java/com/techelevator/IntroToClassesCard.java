package com.techelevator;



public class IntroToClassesCard {
        //------------------------------------------------------------------------------------------------------------
        // Application program for the Intro To Classes App
        //------------------------------------------------------------------------------------------------------------
        public static void main(String[] args) {
        /*
        *  This program will demonstrate several concepts presented in the Java cohort
        *  in the topic Introduction to Classes 		
        */
        	
        // instantiate a PlayingCard object
        // Class name = new Class();

                PlayingCard aCard = new PlayingCard(); // create an instance of our playing card

                System.out.println("aCard is " + aCard); // Display our PlayingCard object
                // requires a string to concatenate, it doesn't know what to do with PlayingCard object

                // is there a way available to convert PlayingCard to a string
                // Yes - using the Object class toString() method
                // every class in Java has the characteristics of an object

                // The object class toString method returns a string containing
                // The package name, ClassName@hashcode

                // Create a queen of hearts 


                PlayingCard jessCard = new PlayingCard(12, "Hearts", "Red", true);
                System.out.println("jessCard is: " + jessCard);
                
                // Even though we passed in true it returns false, before we use the keyword this. which says to use the dataMember following it
                
                // As a user I would like to be able to get individual card values
                
                // Create 3 diamonds which is red 
                
                PlayingCard anotherCard = new PlayingCard(); // Instantiate a default playing card
                anotherCard.setCardValue(3);
                anotherCard.setCardSuit("Diamonds");
                anotherCard.setCardColor("red");
                
                System.out.println("Another card is: " + anotherCard);
                
                
	
	}
}
		 

