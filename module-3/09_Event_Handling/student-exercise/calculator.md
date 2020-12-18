# Calculator Event Handling Exercise

In this exercise, you'll build a simple calculator. This calculator handles basic operations like addition, subtraction, multiplication, and division. The user interface for this project has already been created, so you'll focus on building out its functionality.

## Exercise Instructions

To get started, open `/js/calculator.js`, and scroll down to the following line of code:

```js
document.addEventListener('LOADED_EVENT_GOES_HERE', () => {
```

The first step is to replace `LOADED_EVENT_GOES_HERE` with the appropriate event that notifies when the DOM content is ready to go. Inside of the anonymous function on that event listener is a series of comments. Follow the comments in order and when completed, the basic functions of a calculator work.

## Running the Exercise Tests

To run the exercise tests, run `npm install` to install the required dependencies. If you look in the `package.json`, you'll see two scripts for running the tests: test and test-headless.

If you want to run the tests in a UI mode, run the command `npm run test`. If you want to run the tests from the command line, run `npm run test-headless`. When your tests are complete, hit `ctrl+c` to stop the integrated HTTP server and stop the script.

If you want to see the tests for this exercise, they are located in `cypress/integration/calculator_spec.js`.
