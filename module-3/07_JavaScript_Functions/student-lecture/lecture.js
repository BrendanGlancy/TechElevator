/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}
/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */

function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  console.log(`1st param: ${firstParameter}`);
  console.log(`2nd param: ${secondParameter}`);
  return firstParameter * secondParameter;
}
  
 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
    // You can reference a var variable before its defined without error 
    // its content will be undefined, but you can refernce it 
    // this can cause a large amount of confusion when debugging
    console.log(`the var variable contains ${thisVisibleEveryWhere}`);
    // var ignores scope for visibility
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
 
}

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  console.log(listOfQuirks.join(separator));
  return description + listOfQuirks.join(separator);
}

/**
 * Takes an array and, using array reduce with an anonymous function, generates
 * their sum.
 *
 * .reduce - return an array reduce/converted to a single value using anonymous function
 * .reduce will go through one element at a time passing an element to an anonymous function
 *
 * there is an implied for loop that uses the array
 *
 * syntax: arrayname.reduce(anonymous-function)
 *  the anonymous function will recieve two values (reducer, element-in-array)
 *  the reducer holds the value from the anonymous function each time through
 *  the loop
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce((sum, aNumber) => {
  return sum += aNumber;
  } );
  // to achieve the same result as reduce in this function we would have to
  // let sum = 0;
  // for (let i = 0; i < numbersToSum.length; i++) {
  //  sum += numbersToSum[i]
  //  }
  //  return sum;
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * use .filter when you want to select elements from an array
 *
 * .filter will return an array of elements that anon-funct said should be in the new array
 *
 * the anonymous function tells the filter to add the element it was given to the new
 * array by returning true when the anon-funct recieved the element
 * the anon-funct decideds which elements in array should be included in the new array
 *
 * syntax: arrayname.filter(anon-funct) - the anon funct will recieve an array element 
 * and return true if the element should be included in the new array (is the 
 * element the one we want) return false if the element should not be included
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
 /* return numbersToFilter.filter((anElement) => {
    if (anElement % 3 === 0) {
      return true;
    } 
      return false;
    })*/
  // an easier way to do the code above ^
  return numbersToFilter.filter((anElement) => { return anElement % 3 === 0} );
  // array functions may also use named functions as their callback functions
}


/**
 * This example was added by Frank at the last minute and has no test.
 * Give the browser the html and use the inspect to to run it
 * 
 * The map function will return an array created from the elements passed to it
 * 
 * @param - None
 * @returns {arrray created from values passed to it}
 */

function mapArrayFunctionExampleFromBook() {
  let numbersToSquare = [1, 2, 3, 4];
  console.log(`Array calling map to create new array with values squared: `)
  console.table(numbersToSquare);

  let squaredNumbers = numbersToSquare.map( (number) => { // Send an element to anon-funct one at a time
    // square the element passed and add it to the map
      return number * number;
  });

  console.log(`Array returned from map with values in passed array squared: `)
  console.table(squaredNumbers);
}
