# Event Handlers Exercise - Shopping List

In this exercise, you'll build on the shopping list exercise that you've been working on. The starting code for this exercise and the automated tests are located in `shopping-list`.

## Exercise

If you open `js/shopping-list.js`, there are three variables declared for you:

* **allItemsIncomplete:** You'll use this later.
* **pageTitle:** The title of the page.
* **groceries:** An array of groceries that is displayed in your shopping list.

This application is similar to a previous exercise you worked on. 

Right now the following methods are called at the end of `shopping-list.js`. There is an event you can listen for where these would be better suited to run from. Create an event listener for this special event and place the two methods inside of it. This is also where the rest of your code should go.
 
### Mark item complete

When a user clicks on an item in the shopping list, it should be marked complete. To do so, add the `.completed` class to the list item and the icon. You should check the item to make sure it doesn't already have the completed class. There is no sense in performing your logic on an item that is already complete.

### Mark item incomplete

When a user double clicks on an item in the shopping list, it should be marked incomplete. To do so, remove the `.completed` class to the list item and the icon. You should check the item to make sure it has the completed class. There is no sense in performing your logic on an item that isn't completed.

### Toggle All

When your application loads, all of the items are incomplete, and the button on the page says `Mark All Complete`. When you click on this button, all of the items in the list should be marked completed. The button's text should also switch to say `Mark All Incomplete`. If you were to click on the button again, it would mark all of the items in the list incomplete.

> HINT: You can use the variable `allItemsIncomplete` to track the current state of the button. Whenever you mark all items complete or incomplete, make sure to update this variable to keep track of where you are.

> NOTE: The labels 'Mark All Complete' and 'Mark All Incomplete' are case sensitive. If you don't type them exactly as they appear in the exercise notes, your tests fail.

## Tests

If you haven't done so already, run `npm install`. This installs any dependencies that you need to run your tests. Once you've completed this step, run the tests using this command: 

```
npm run test
```

The tests are located in `cypress/integration/shopping-list.spec.js`:

* Parent container `shopping-list` should exist
* Should have a title of My Shopping List
* Should have 10 items on the shopping list
* Each item in the list should not have the class completed until it has been clicked on
* Each item in the list that is completed can be double-clicked on and marked incomplete
* Clicking on the mark all completed button should set all items to complete
* Clicking on the mark all incomplete button should set all items to incomplete
