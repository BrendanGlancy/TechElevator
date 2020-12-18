/*
1. **sumDouble** Given two int values, return their sum. Unless the two values are the 
    same, then return double their sum.

		sumDouble(1, 2) → 3
		sumDouble(3, 2) → 5
		sumDouble(2, 2) → 8
        */
  // working
function sumDouble(x, y) {
  // return result;
  if (x == y) {
  	return (x + y) * 2
  }
  return x + y;
}

/*
2. **hasTeen** We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
    Given 3 int values, return true if 1 or more of them are teen.

		hasTeen(13, 20, 10) → true
		hasTeen(20, 19, 10) → true
		hasTeen(20, 10, 13) → true
*/
function hasTeen(x, y, z) {
  if (x >= 13 && x <= 19 || y >= 13 && y <= 19 || z >= 13 && z <= 19) {
    return true
  } else {
    return false
  }
}
/* 
3. **lastDigit** Given two non-negative int values, return true if they have the same 
    last digit, such as with 27 and 57.

		lastDigit(7, 17) → true
		lastDigit(6, 17) → false
		lastDigit(3, 113) → true
*/
function lastDigit(x, y) {
  if (x % 10 == y % 10) {
    return true
  } else {
    return false
  }
}
/*
4. **seeColor** Given a string, if the string begins with "red" or "blue" return that color 
    string, otherwise return the empty string.

		seeColor("redxx") → "red"
		seeColor("xxred") → ""
        seeColor("blueTimes") → "blue"
*/
function seeColor(color) {
  if (color.substring(0, 3) == "red") {
    return "red";
  } else if (color.substring(0, 4) == "blue") {
    return "blue";
  } else {
    return "";
  }
}
/*
5. **oddOnly** Write a function that given an array of integer of any length, filters out 
    the even number, and returns a new array of just the the odd numbers.

		oddOnly([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]) → [1, 3, 5, 7, 9, 11];
		oddOnly([2, 4, 8, 32, 256]); → []
*/
function oddOnly(arr) {
  return arr.filter(n => n % 2 !== 0);
}

/*
6. **frontAgain** Given a string, return true if the first 2 chars in the string also appear 
    at the end of the string, such as with "edited".

		frontAgain("edited") → true
		frontAgain("edit") → false
		frontAgain("ed") → true
*/
function frontAgain(s) {                                                      
   if (s.substring(0, 2) == "ed" && s.substring(s.length - 2, s.length) == "ed") {                                             return true;                                                               
    } else if (s.length == 2) {
      return true;
    } else {
     return false;                                                                  
    }                                                                             
  }    
/*
7. **cigarParty** When squirrels get together for a party, they like to have cigars. 
A squirrel party is successful when the number of cigars is between 40 and 60, inclusive. 
Unless it is the weekend, in which case there is no upper bound on the number of cigars. 
Write a squirrel party function that return true if the party with the given values is successful, 
or false otherwise.

		cigarParty(30, false) → false
		cigarParty(50, false) → true
		cigarParty(70, true) → true
*/
function cigarParty(n, bool) {
  if (n >= 40 && bool == true) {
    return true;
  } else if (n >= 40 && n <= 60 && bool == false) {
    return true;
  } else {
    return false;
  }
}
/*
8. **fizzBuzz** Because you know you can't live without it, FizzBuzz.

		fizzBuzz(3) → "Fizz"
		fizzBuzz(1) → 1
		fizzBuzz(10) → "Buzz"
		fizzBuzz(15) → "FizzBuzz"
		fizzBuzz(8) → 8
*/
function fizzBuzz(n) {
  let str = "";
  for (i = 0; i <= n; i++) {

    if (!(n % 3)) {
      str += "Fizz"
    }
    if (!(n % 5)){
      str += "Buzz"
    }
  
    return str || n;
  }
}
/*
9. **filterEvens** Write a function that filters an array to only include even numbers.

	filterEvens([]) → []
	filterEvens([1, 3, 5]) → []
	filterEvens([2, 4, 6]) → [2, 4, 6]
	filterEvens([100, 8, 21, 24, 62, 9, 7]) → [100, 8, 24, 62]
*/
function filterEvens(arr) {
  return arr.filter(n => n % 2 === 0);
}
/*
10. **filterBigNumbers** Write a function that filters numbers greater than or equal to 100.

	filterBigNumbers([7, 10, 121, 100, 24, 162, 200]) → [121, 100, 162, 200]
	filterBigNumbers([3, 2, 7, 1, -100, -120]) → []
	filterBigNumbers([]) → []
*/
function filterBigNumbers(arr) {
  let output = [];
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] >= 100) {
      output.push(arr[i]);
    }
  }
  
  return output;
  
}

/*
11. **filterMultiplesOfX** Write a function to filter numbers that are a multiple of a 
parameter, `x` passed in.

	filterMultiplesOfX([3, 5, 1, 9, 18, 21, 42, 67], 3) → [3, 9, 18, 21, 42]
	filterMultiplesOfX([3, 5, 10, 20, 18, 21, 42, 67], 5) → [5, 10, 20]
*/
function filterMultiplesOfX(arr, a) {
  let output = [];
  for (let i = 0; i < arr.length; i++) {
     if (arr[i] % a === 0) {
       output.push(arr[i]);
     }
   }

   return output;

 }                  
/*
12. **createObject** Write a function that creates an object with a property called 
firstName, lastName, and age. Populate the properties with your values.

	createObject() →

	{
		firstName,
		lastName,
		age
	}
*/
function createObject() {
// needs to be a { to create an object
  let person = {
	firstName: "Brendan",
	lastName: "Glancy",
	age: 19
  }
  return person;
}
