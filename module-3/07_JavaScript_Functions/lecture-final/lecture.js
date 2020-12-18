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
function multiplyNoUndefined(firstParameter=0, secondParameter=0) {
  console.log(`1st parm: ${firstParameter}`)
  console.log(`2nd parm: ${secondParameter}`)
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

    // You can reference a var variable BEFORE its defined without error
    //       it's content will be undefined, but you can reference it
    //       this can cause an large amount of confusion when debugging
    console.log(`the var variable contains ${thisIsVisibleEveryWhere}`);

  } // end of block causes all variables in the block to disappear

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }

  {
    var thisIsVisibleEveryWhere = 3;  // This variable is visible in the entire function
                                      // var ignores scope rules for visibility
  }
}

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;

  // join takes the elements in the array and makes them a string with the separator between the elements
  console.log(listOfQuirks.join(separator));

  return description + listOfQuirks.join(separator);
}

/**
 * Takes an array and, using array reduce with an anonymous function, generates
 * their sum.
 *
 * .reduce - return an array reduced/converted to a single value using an anonymous function
 * .reduce will go through one element at a time passing an element to the anonymous function
 *         (there is an implied for-loop using the array)
 * 
 * syntax: arrayname.reduce(anonymous-function)
 * 
 *         the anonymous function will receive two values (reducer, element-in-array)
 *           the reducer hold the value from the anonymous function each time through the loop 
 * 
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {

  // sum is the reducer which will hold the value for each interaction of the loop
  //     the anonymous function will change the value each time it is called
  //
  // aNumber is an element in the array
  //
  // .reduce will call the anonymous function with each element in the array
  //
  // a CallBack function is a function passed as a parameter to another function
  //                          that the function receiving the parameter, calls

  return numbersToSum.reduce((sum, aNumber) => {   
                                                 return sum += aNumber;                                      
                                               }  );
  //   return numbersToSum.reduce((sum, aNumber) => { return sum += aNumber; });
  //   return numbersToSum.reduce(
  //                             (sum, aNumber) => { return sum += aNumber; }
  //                             );
      /*
   * to achieve the same result as reduce in this function using a for-loop:
   *
   *    let sum = 0;
   *    for(let i=0; i < numbersToSum.length; i++) {
   *       sum += numbersToSum[i]
   *    }
   *    return sum;
   *
  */
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 * 
 * Use .filter when you want to select elements from an array
 * 
 * .filter will return an array of elements that an anon-func said should be in the new array
 * 
 * .filter will go through the array one element at a time passing element to anon-func
 * 
 * The anonymous function tells filter to add the element it was given to the new array
 *     by returning true when the anon-func received the element
 * The anon-func decides which elements in an array should be included in the new array
 * 
 * syntax: arrayname.filter(anon-func) - the anon-func will receive an array element
 *                                       and return true if the element should be included
 *                                       in the new array (is the element one we want?)
 *                                       return false if teh element should not be included
 *                                       (it's an element we don't want)
 */
function allDivisibleByThree(numbersToFilter) {
  return numbersToFilter.filter((anElement) => { return anElement % 3 === 0 })
}
                                              /* alternate way to do this
                                                if (anElement % 3 === 0) {  // if the element evenly divisible by 3
                                                                          return true; // we want it
                                                }
                                                return false;            // if not, we don't want it
                                            
                                    
                                              */
/*
 * array functions may also use named functions as their callback functions
 * an element from the array is automatically passed to the named function
 *    (You do not specify a parameter in the named function call)
 */
function allDivisibleBy3(numbersToFilter) {
  return numbersToFilter.filter(isDivisibleByThree) // an array element is automatically passed
}
function isDivisibleByThree(anElement) {
 return anElement % 3 === 0 
}
/**
 * This example was added by Frank at the last minute and has no test.
 * Give the browser the html and use the inspect to to run it
 * 
 * The map function will return an array created from the elements passed to it
 * 
 * @param - None
 * @returns {array created from values passed to it}
 */

function mapArrayFunctionExampleFromBook() {

// This will create an array containing all the values in another array squared
//  use .map function

let numbersToSquare = [1, 2, 3, 4];
console.log(`Array calling map to create new array with values squared: `)
console.table(numbersToSquare);

let squaredNumbers = numbersToSquare.map( (number) => {  // Send an element to anon-func one at a time
    return number * number;  // square the element passed and add it to a new array
});

console.log(`Array returned from map with values in passed array squared: `)
console.table(squaredNumbers);
}
