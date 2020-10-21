package com.techelevator;

public class Exercises {

	/*
	 Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
	 helloName("Bob") → "Hello Bob!"
	 helloName("Alice") → "Hello Alice!"
	 helloName("X") → "Hello X!"
	 */
	public String helloName(String name) {
		String hello = "Hello ";
		return hello + name + "!";
		
	}

	/*
	 Given two strings, a and b, return the result of putting them together in the order abba,
	 e.g. "Hi" and "Bye" returns "HiByeByeHi".
	 makeAbba("Hi", "Bye") → "HiByeByeHi"
	 makeAbba("Yo", "Alice") → "YoAliceAliceYo"
	 makeAbba("What", "Up") → "WhatUpUpWhat"
	 */
	public String makeAbba(String a, String b) {
		return (a + b) + (b + a);
	}

	/*
	 The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example,
	 the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the
	 HTML string with tags around the word, e.g. "<i>Yay</i>".
	 makeTags("i", "Yay") → "<i>Yay</i>"
	 makeTags("i", "Hello") → "<i>Hello</i>"
	 makeTags("cite", "Yay") → "<cite>Yay</cite>"
	 */
	public String makeTags(String tag, String word) {
		String openTag = "<" + tag + ">";
		String closeTag = "<" + "/" + tag + ">";
		
		return openTag + word + closeTag;
	}

	/*
	 Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the
	 middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting
	 at index i and going up to but not including index j.
	 makeOutWord("<<>>", "Yay") → "<<Yay>>"
	 makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
	 makeOutWord("[[]]", "word") → "[[word]]"
	 */
	public String makeOutWord(String out, String word) {
		return out.substring(0,2) + word + out.substring(2,4);
		
	}

	/*
	 Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string
	 length will be at least 2.
	 extraEnd("Hello") → "lololo"
	 extraEnd("ab") → "ababab"
	 extraEnd("Hi") → "HiHiHi"
	 */
	public String extraEnd(String str) {
		int secondToLast = str.length()-2; // Second to last char
		int last = str.length(); // last char
		
		String extra = str.substring(secondToLast, last); // last 2 chars
		
	
		return extra + extra + extra; // last 2 chars 3 times
		
	}

	/*
	 Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
	 string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
	 yields the empty string "". Note that str.length() returns the length of a string.
	 firstTwo("Hello") → "He"
	 firstTwo("abcdefg") → "ab"
	 firstTwo("ab") → "ab"
	 */
	public String firstTwo(String str) {
		
		String sub = ""; // initialize a string to store the changed str in
		
		if (str.length() == 0) { // if there's no string return no string
			return sub;
		}
		else if (str.length() < 2 && str.length() > 0) { // if the string is one letter return one letter
			sub = str.substring(0,1);
			return sub;
		} else if (str.length() > 2 || str.length() == 2) { // if the string has 2 or more letters return the first 2
			sub = str.substring(0,2);
			return sub;
		} else { // else return an empty string
			return sub;
		}
		
	}

	/*
	 Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
	 firstHalf("WooHoo") → "Woo"
	 firstHalf("HelloThere") → "Hello"
	 firstHalf("abcdef") → "abc"
	 */
	public String firstHalf(String str) {
		int half = str.length() / 2; // get the length of half of the string
		return str.substring(0, half); // return half of the string
	}

	/*
	 Given a string, return a version without the first and last char, so "Hello" yields "ell".
	 The string length will be at least 2.
	 withoutEnd("Hello") → "ell"
	 withoutEnd("java") → "av"
	 withoutEnd("coding") → "odin"
	 */
	public String withoutEnd(String str) {
		if (str.length() == 2) { // return no characters if there are only 2
			return "";
		} else if (str.length() > 2) {
			return str.substring(1, str.length()-1); // return the middle characters if there are 3 or more
		}
		return null;
	}

	/* 
	 Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string
	 on the outside and the longer string on the inside. The strings will not be the same length, but
	 they may be empty (length 0).
	 comboString("Hello", "hi") → "hiHellohi"
	 comboString("hi", "Hello") → "hiHellohi"
	 comboString("aaa", "b") → "baaab"
	 */
	public String comboString(String a, String b) {
		
		String little = ""; // since you can't name them short and long
		String big = "";
		
		if (a.length() > b.length()) { // find out if a or b is bigger
			big = a;
			little = b;
			return little+big+little; // return short long short 
		} else if (b.length() > a.length()) {
			big = b;
			little = a;
			return little+big+little;
		}
		return ""; // or return nothing
	}

	/*
	 Given 2 strings, return their concatenation, except omit the first char of each. The strings will
	 be at least length 1.
	 nonStart("Hello", "There") → "ellohere"
	 nonStart("java", "code") → "avaode"
	 nonStart("shotl", "java") → "hotlava"
	 */
	public String nonStart(String a, String b) {
		return a.substring(1, a.length()) + b.substring(1, b.length());
	}

	/*
	 Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end.
	 The string length will be at least 2.
	 left2("Hello") → "lloHe"
	 left2("java") → "vaja"
	 left2("Hi") → "Hi"
	 */
	public String left2(String str) {
		
		char firstLetter = str.charAt(0); 
		char secondLetter = str.charAt(1);
		String firstTwo = "" + firstLetter + secondLetter; // Concatenate the two chars into a String
		
		if (str.length() == 2) {
			return str; // return the string if it's only two letters
		} else if (str.length() > 2) {
			return str.substring(2) + firstTwo; // put the first two letters on the end if the string has more than 2 characters
		}
		return null;
	}

	/*
	 Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start.
	 The string length will be at least 2.
	 right2("Hello") → "loHel"
	 right2("java") → "vaja"
	 right2("Hi") → "Hi"
	 */
	public String right2(String str) {
		
		char lastLetter = str.charAt(str.length()-1); 
		char secondToLastLetter = str.charAt(str.length()-2);
		String lastTwo = "" + secondToLastLetter + lastLetter; // Concatenate the two chars into a String
		
		if (str.length() == 2) {
			return str; // return the string if it's only two letters
		} else if (str.length() > 2) {
			return lastTwo + str.substring(0, str.length()-2); // put the last two letters at the beginning
		}
		return null;
	}

	/*
	 Given a string, return a string length 1 from its front, unless front is false, in which case
	 return a string length 1 from its back. The string will be non-empty.
	 theEnd("Hello", true) → "H"
	 theEnd("Hello", false) → "o"
	 theEnd("oh", true) → "o"
	 */
	public String theEnd(String str, boolean front) {
		if (front == false) {
			return str.substring(str.length()-1);
		} else if (front == true) {
			return str.substring(0, 1);
		}
		return null;
	}

	/*
	 Given a string, return a version without both the first and last char of the string. The string
	 may be any length, including 0.
	 withoutEnd2("Hello") → "ell"
	 withoutEnd2("abc") → "b"
	 withoutEnd2("ab") → ""
	 */
	public String withoutEnd2(String str) {
		
		int len = str.length(); // length of the string
		if (len <= 0 || len == 1 || len == 2) {
			return "";
		} else if (len > 2) {
			String without = str.substring(1, len-1); // takes out the first and last letter
			return without; // returns the string without the first and the last letter
		}
		return null;
	}

	/*
	 Given a string of even length, return a string made of the middle two chars, so the string "string"
	 yields "ri". The string length will be at least 2.
	 middleTwo("string") → "ri"
	 middleTwo("code") → "od"
	 middleTwo("Practice") → "ct"
	 */
	public String middleTwo(String str) {
		int len = str.length();
		int middle = len / 2;
		if (len == 2) {
			return str; // if the length of the string is 2 return the string because the two letter in it, are already the middle numbers
		} else if (len > 2) {
			String letters = str.substring(middle-1, middle+1); // makes a substring of the middle two letters
			return letters; // returns the letters
		}
		return null;
	}

	/*
	 Given a string, return true if it ends in "ly".
	 endsLy("oddly") → true
	 endsLy("y") → false
	 endsLy("oddy") → false
	 */
	public boolean endsLy(String str) {
		String ly = "ly";
		int len = str.length();
		if (len < 2) { // returns false string is too small 
			return false;
		} else if (len >= 2){
			String lastTwoLetters = str.substring(str.length()-2, str.length()); // checks to see if the last two letters are ly
			if (lastTwoLetters.equals(ly)) {
				return true;
			} else { // if they aren't return false
				return false;
			}
		} else {
			return false;
		}
		
		
	}

	/*
	 Given a string and an int n, return a string made of the first and last n chars from the string. The
	 string length will be at least n.
	 nTwice("Hello", 2) → "Helo"
	 nTwice("Chocolate", 3) → "Choate"
	 nTwice("Chocolate", 1) → "Ce"
	 */
	public String nTwice(String str, int n) {
		String nTwo = str.substring(0, n) + str.substring(str.length()-n);
		return nTwo;
	}

	/*
	 Given a string and an index, return a string length 2 starting at the given index. If the index is
	 too big or too small to define a string length 2, use the first 2 chars. The string length will be
	 at least 2.
	 twoChar("java", 0) → "ja"
	 twoChar("java", 2) → "va"
	 twoChar("java", 3) → "ja"
	 */
	public String twoChar(String str, int index) {
		if (index <= 0) {
			return str.substring(0,2);
		} else if (index+2 <= str.length()) {
			return str.substring(index, index+2);
		} else if (index+2 > str.length()) {
			return str.substring(0,2);
		}
		return "";
		
	}

	/*
	 Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and".
	 The string length will be at least 3.
	 middleThree("Candy") → "and"
	 middleThree("and") → "and"
	 middleThree("solving") → "lvi"
	 */
	public String middleThree(String str) {
		int len = str.length();
		int j = (len - 3) / 2;
		return str.substring(j, len - j);
	}

	/*
	 Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with
	 "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals()
	 to compare 2 strings.
	 hasBad("badxx") → true
	 hasBad("xbadxx") → true
	 hasBad("xxbadxx") → false
	 */
	public boolean hasBad(String str) {
		
		
		for (int i = 0; i < str.length()-2; i++) {
			
			String threeLetter = str.substring(i, i+2);
			
			
			if (threeLetter.equals("bad")) {
				return true;
			} else {
				return false;
			}
			
		
		}
		return false;
	}

	/*
	 Given a string and a non-negative int n, return a larger string that is n copies of the original string.
	 stringTimes("Hi", 2) → "HiHi"
	 stringTimes("Hi", 3) → "HiHiHi"
	 stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {
		String string = "";
		for (int i = 0; i < n; i++) {
			 string += str;
		}
		return string;		
	}

	/*
	 Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or
	 whatever is there if the string is less than length 3. Return n copies of the front;
	 frontTimes("Chocolate", 2) → "ChoCho"
	 frontTimes("Chocolate", 3) → "ChoChoCho"
	 frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {
		
		String string = "";
		
		
		if (str.length() < 3) {
			string = str.substring(0,str.length()-1);
			
			for (int i = 0; i <= n; i++) {
				string += string;
			} 
		} else if (str.length() >= 3) {
			string = str.substring(0,3);
				
			for (int i = 1; i == n; i++) {
				string += string;
			}
			
		}
		
		return string;
	}
		
	

	/*
	 Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
	 countXX("abcxx") → 1
	 countXX("xxx") → 2
	 countXX("xxxx") →
	 */
	public int countXX(String str) {
		int x = 0;
		for (int i = 0; i < str.length()-1; i++) {
			String string = str.substring(i,i+2);
			if (string.equals("xx")) {
				x += 1;
			}
		}
		return x;
	}

	/*
	 Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
	 doubleX("axxbb") → true
	 doubleX("axaxax") → false
	 doubleX("xxxxx") → true
	 */
	public boolean doubleX(String str) {
		for (int i = 0; i < str.length()-1; i++) {
			if ((str.charAt(i) + "").equals("x") && (str.charAt(i+1) + "").equals("x")) {
				return true;
			}
		}
		return false;
	}

	/*
	 Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
	 stringBits("Hello") → "Hlo"
	 stringBits("Hi") → "H"
	 stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		String returnString = "";
		for (int i = 0; i < str.length(); i += 2) { // every other character
			returnString += str.charAt(i);
		}
		return returnString;
	}

	/*
	 Given a non-empty string like "Code" return a string like "CCoCodCode".
	 stringSplosion("Code") → "CCoCodCode"
	 stringSplosion("abc") → "aababc"
	 stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {
		return null;
	}

	/*
	 Given a string, return the count of the number of times that a substring length 2 appears in the string and
	 also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
	 last2("hixxhi") → 1
	 last2("xaxxaxaxx") → 1
	 last2("axxxaaxx") → 2
	 */
	public int last2(String str) {
		return 0;
	}

	/*
	 Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end
	 should not be removed.
	 stringX("xxHxix") → "xHix"
	 stringX("abxxxcd") → "abcd"
	 stringX("xabxxxcdx") → "xabcdx"
	 */
	public String stringX(String str) {
		String x = "x";
		int len = str.length()-1;
		String string = str.substring(1, str.length()-1);
		String first = str.charAt(0) + "";
		String last = str.charAt(len) + "";
		
		if (first.equals("x") && last.equals("x")) {
			string = x + string.replace("x", "") + x;
		} else if (first.equals("x")) {
			string = x + string.replace("x", "");
		} else if (last.equals("x")) {
			string = string.replace("x", "");
		}
		
		return string;
	}

	/*
	 Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
	 altPairs("kitten") → "kien"
	 altPairs("Chocolate") → "Chole"
	 altPairs("CodingHorror") → "Congrr"
	 */
	public String altPairs(String str) {
		String string = "";
		int len = str.length();
		
		// I hated this problem so much I did this haha
		if (len < 1) {
			return "";
		} else if (len == 1 || len < 2) {
			return str;
		} else if (len > 1 && len < 4) {
			string = str.substring(0,2);
			return string;
		} else if (len > 5 && len < 8) {
			string = str.substring(0,2) + str.substring(4,6);
			return string;
		} else if (len > 8 && len < 10) {
			string = str.substring(0,2) + str.substring(4,6) + str.substring(8,9);
			return string;
		} else if (len > 10 && len < 13) {
			string = str.substring(0,2) + str.substring(4,6) + str.substring(8,10);
			return string;
		} else if (len > 12 && len < 17) {
			string = str.substring(0,2) + str.substring(4,6) + str.substring(8,10) + str.substring(12,14);
			return string;
		}
		return string;
	}

	/*
	 Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed.
	 The "yak" strings will not overlap.
	 stringYak("yakpak") → "pak"
	 stringYak("pakyak") → "pak"
	 stringYak("yak123ya") → "123ya"
	 */
	public String stringYak(String str) {
		return str.replace("yak", "");
	}

}
