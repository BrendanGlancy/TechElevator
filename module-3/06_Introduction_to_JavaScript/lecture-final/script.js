/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

// semi-colons are usually optional in JavaScript

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 * We will learn A LOT more about functions tomorrow
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const numDaysInWeek = 7 // const defines a variable whose value cannot be changed

  // Java syntax for Strings with variable may be used 
  console.log("There are " + numDaysInWeek + " days in a week")
  
  // We can also enclose the line to display in tick marks/accent marks and
  //    place variables to be substituted in an EL expression ${variable}
  // EL=Expression Language - it's a way to specify variables in a string 
  // Think of the EL expression -${variable} - as a placeholder for a value
  console.log(`There are ${numDaysInWeek} days in a week`);

  // Declares a variable those value can be changed
  // ALWAYS use let NOT var to define a variable that can be changed
  //    (the reason will become clear tomorrow)
  // Use of var to define variables can lead to confusing and hard to debug code
  let daysInMonth = 30; // It's November

  console.log(`There are ${daysInMonth} in November`);

  // Declares a variable that will always be an array

  // Arrays in JavaScript are JSON arrays - JSON=JavaScriptObjectNotation
  // Array is enclosed in [] - values are seprated with commas

  const weekdays = [
                    "Monday"
                   ,"Tuesday"
                   ,"Wednesday"
                   ,"Thursday"
                   ,"Friday"
                   ,"Saturday"
                   ,"Sunday"
                   ];

console.table(weekdays);  // .table formats the array to make easier to read
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types. (Nothing in JavaScript has a type)
 * We will learn A LOT more about functions tomorrow
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality - values are the same, datatypes may be different
 * === is strict equality - values and datatypes must be the same
 * typeof returns the current type of a variable based on it's content
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
 * Each value is inherently true or false.
 * false, 0, '', null, undefined, and NaN are always false
 * everything else is always truthy
 * @param {Object} x The object to check for truth or false,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

/**
 * JavaScript may use JSON objects to hold related data
   (JavaScript objects are NOT the same as Java objects)  

  Objects are simple key-value pairs enclosed in {} separated by commas
    - values can be any data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {       // JavaScript object
    firstName: "Bill",   // element in the object
    lastName: "Lumbergh",// element in the object
    age: 42,             // element in the object
    employees: [         // element in the object that's an array
      "Peter Gibbons",        // element in the array
      "Milton Waddams",       // element in the array
      "Samir Nagheenanajar",  // element in the array
      "Michael Bolton"        // element in the array  
    ],
    // define a toString function for the object so JavaScript knows how to convert it a string
    // We are telling JavaScript what a string version of this object looks likes
    toString : function() { // element in the object that is a function
      return `${this.lastName}, ${this.firstName}, ${this.age}`
    }
  };

  // Log the object
  console.log(person); 
  console.table(person);
  console.log(`  Display using console.log  : ${person}`); // treat person as string not an object
  console.table(`Display using console.table: ${person}`); 

  // Log the first and last name
  console.log(`${person.firstName}`) // To reference elements in an object{ object.element-name}

  // Log each employee - each employee is an element in an array in the object
  // Use object.arrayname to access the array use index inside [] to access an element
  for (let i=0; i < person.employees.length; i++) {
    console.log(`Employee #${i+1} is ${person.employees[i]}`)
  }
  // We can execute/run and function in the object using object.function()
  console.log(person.toString()) // run the toString function in the object
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overridden and the most recent one will be used.
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
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);  // First occurrence of the string
  console.log(`.indexOf('l') - ${value.indexOf("l")}`);          // First occurrence of the string
  console.log(`.lastIndexOf('l') - ${value.lastIndexOf("l")}`);  // last occurrence of the string
 
  console.log(`.substr(value,2,3) - ${value.substr(2,3)}`);       // string.substr(start-index, #-chars)
  console.log(`.substring(value,2,3) - ${value.substring(2,3)}`); // string.substring(start-index, end-index)
                                                                  // return the chars starting at start-index
                                                                  //    up to but not including the char at end-index
                                                                  //    just like Java
    /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}
    /*
    ############################
    Array Manipulation Examples
    ############################
    */

    function arrayFunctions() {
      let stooges = [
                    "Moe"
                   ,"Larry"
                   ,"Curly"
                   ]
      
    console.table(stooges)

    stooges.push("Shemp");  // add an element to end of the array
    console.table(stooges);

    stooges.unshift("Curly Joe") // add an element to the start of the array
    console.table(stooges);

    stooges.splice(3,0,"Groucho", "Chico", "Harpo") // insert elements starting at index 3 and delete 0 elements
    console.table(stooges);

    stooges.splice(3,1) // delete 1 element starting at element 3
    console.table(stooges);

    stooges.splice(3,2) // remove 2 elements starting at index 3
    console.table(stooges);

    stooges.shift() // remove one element from the start of the array
    console.table(stooges);

    stooges.pop()   // remove one element from the end of the array
    console.table(stooges);

    let marxBros = [
                   "Groucho"
                  ,"Chico"
                  ,"Harpo"
                ]
    let oldFunnyGuys = stooges.concat(marxBros)  // Combine two arrays
    console.table(oldFunnyGuys)
    }


