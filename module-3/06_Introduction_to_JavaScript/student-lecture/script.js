/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment
// Semi colons are usually optional in JavaScript

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const numDaysInWeek = 7; // const define a variable whose value cannot be changed
  // log to the console
  // To make a string you can use " or '
  console.log("There are: " + numDaysInWeek + " days in a week");

  // We can also enclose the line to display in tick marks/accent marks
  // place variables to be substituted in an EL expression
  // EL = Expression Language - it's a way to specify variables in a string
  console.log(`There are ${numDaysInWeek} day in a week`);
  // Declares a variable those value can be changed
  // ALWAYS use let not var to define a variable that can be changed
  // Use of var to define variables can lead to confusing and hard to debug code
  let daysInMonth = 30;
  console.log(`There are ${daysInMonth} in November`);
  // Declares a variable that will always be an array
  
  // Arrays in JavaScript are JSON arrays - JSON = JavaScript Object Notation
  // Arrays are enclosed in [] - values are seperated with commas
  const weekdays = ["Monday"
    ,"Tuesday"
    ,"Wesnesday"
    ,"Thursday"
    ,"Friday"
    ,"Saturday"
    ,"Sunday"
    ];
  console.table(weekdays);
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 * Just like in Java you need to pass in param1 and param2 
 * for the method below to work correctly
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality - values are the same, the datatypes may be different
 *
 * === is strict equality - values and datatypes must be the same
 *
 * if you were to call equality(1, "1") it would return
 * x == y : true
 * x === y : false
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 * this concept can make your life easier 
 * if you divide a number by a string you will get falsy
 * if you pass this nothing you get falsy as oppose to passing any value 
 * you would get truthy
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

/**
 * {} object [] array
 * JavaScript may use JSON objects to hold related data
 * JavaScript objects aren't the same as Java Objects
 * Java objects are assoicated with a class while JavaScript Objects are 
 * Stand alone
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = { // JavaScript Object
    firstName: "Bill", // element in the object
    lastName: "Lumbergh",
    age: 42,
    employees: [ // element in the object that's an array
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ]
  };

  // Log the object
  console.log(person);
  // Log the first and last name
  
  // Log each employee
  function toString() {
    return `${this.lastName}, ${this.firstName}, ${this.age}`
  }
  
  for (let i = 0; i < person.employees.length; i++) {
    console.log(`Employee #${i+1} is ${person.employees[i]}`)
  }
  
  console.log(person.toString())
  
};


/*
########################
Function Overloading
this is an important object oriented programming concept
function overloading is when you have two functions 
by the same name that take differenet parameters
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  return num1 + num2;
}

function Add(num1, num2, num3) {
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`); // First index of the string
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`); // First index of the string
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`); // Second index of the string

  console.log(`.substr(value.2,3) - ${value.substr(2,3)}`); // string.substr(string,start-index, end-index)
  console.log(`.substring(value.2,3) - ${value.substring(2,3)}`); // string.substring(string, start-index, end-index)
  // ^ works just like java substring


  /**
   *
   * Array Manipulations Examples
   *
  */
  


}

function arrayFunctions() {
  let stooges = [
    "Moe"
    ,"Curly"
    ,"Larry"
  ]

  stooges.push("Shemp") // add an element to the end of the array

  stooges.unshift("Curly Joe") // add curly joe to the beginning of an array
  // inserts at index 3 and moves everything down
  stooges.splice(3, 0, "Groucho", "Chico", "Harpo") // insert elements starting at index 2
  console.table(stooges)

  // splice deletes elements, the second int you pass it is how many items you are going to delete
  // this self of stooges can be editted like a queue or stack
  
  stooges.splice(3,1) // delete one element starting at element 3

  stooges.shift() // remove one element from the start of the array

  stooges.pop() // remove one element fromt he end of an array

  // Array manipulation in JavaScript is pretty easy
  

}
