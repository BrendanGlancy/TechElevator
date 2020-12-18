const name = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerHTML = name;
} 

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerHTML = description;
}

/**
 * I will display all of the reviews in the reviews array
 */
function displayReviews() {
  // If the html content supports  a template, add the template to the DOM
  if ('content' in document.createElement('template')) {
    // now that we have the template in the DOM we have to add content
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 *
 * @param {Object} review The review to display
 */
function displayReview(review) {
  // Get a reference to the element with id='main'
  const main = document.getElementById('main');
  // clone the template and get a reference to it (this does what all the createElements did)
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerText = review.reviewer;  // add content to 
  tmpl.querySelector('h3').innerText = review.title;     //     the elements 
  tmpl.querySelector('p').innerText = review.review;     //         in the template
  // there will always be 1 star because it is a part of the template so we start for loop at 1
  for (let i = 1; i < review.rating; ++i) {  // add stars if the rating was greater than 1
    const img = tmpl.querySelector('img').cloneNode(); // Make a copy of the img element node
    tmpl.querySelector('.rating').appendChild(img);    //    add new img element to rating div
  }
  main.appendChild(tmpl);  // Add the template to the DOM
}

// LECTURE STARTS HERE ---------------------------------------------------------------
/***************************************************************************************
 * These functions will execute when the page is loaded into the browser
 * 
 * Since these functions contains statements that manipulate the DOM
 * if the DOM has not yet been created when they run, they will fail
 * 
 * So we should wait until the DOM is created before allowing them to run
 * 
 * Luckily, the browser will tell us when it has finished creating the DOM
 * by firing/trigger/causing the DOMContentLoaded event
 ***************************************************************************************/
// wait until the DOM is loaded/created before manipulating the DOM with these function.
// add an event handler to the document to be run whe DOMContentLoaded event happens
//      .addEventListener(event-to-listen-for, function-to-handle-event)
document.addEventListener('DOMContentLoaded', () => {  
                                                    // set the product reviews page title
                                                    setPageTitle();
                                                    // set the product reviews page description
                                                    setPageDescription();
                                                    // display all of the product reviews on our page
                                                    displayReviews();
/**
 * Take an event on the description and swap out the description for a text box using the function provided
 */
const descriptionLine = document.querySelector('.description'); // Get a reference to element we want the Event handler on

// add an event handler for the click event  to the description line using an anon-func which will call 
//         the function provided to us passing it a reference to the element clicked (event.target)
// event.target - get the target of the event from the event object (the element that was click in this case)
descriptionLine.addEventListener('click', (event) => { // an anon-func that takes the event object as a parameter
                                                       toggleDescriptionEdit(event.target)
                                                      });
// Add an event handler to the input box to accept the input and change the description when they press enter
  const theInputBox = document.getElementById('inputDesc'); // Get a reference to the input box
  theInputBox.addEventListener('keyup', (event)=> {
  if (event.key === 'Enter') { // if the key they pressed was the Enter
    exitDescriptionEdit(event.target, true); // run the function provided to accept the input and set the description
  }
  if (event.key === 'Escape') { // if teh key they pressed was Escape 
    exitDescriptionEdit(event.target, false); // run the function provided to discard changes 
  }
})
// Add an event listener to the button for add a review
const theAddReview = document.getElementById('btnToggleForm');
theAddReview.addEventListener('click', (event) => {
  showHideForm();  // run the function to show/hide the form
})

// Add an event listener for the 'SaveReview' button that will run the function SaveReview
const theSaveReviewButton = document.getElementById('btnSaveReview');
theSaveReviewButton.addEventListener('click', (event) => {
  // Due this being a submit button for a form - we do not want to go to the server wit an HTTP request
  // We want to handle he button processing
  event.preventDefault(); // Tell the button to not perform it's default behavior to submit to API
  saveReview();
})

}) // End of the event handling code from DOMContentLoadedEvent

/** 
 * This function is used when the description line is clicked 
 * 
 * @param {element-clicked} the element the user clicked which caused this function to run
 */

function toggleDescriptionEdit(desc) {
  const textBox = desc.nextElementSibling;  // Get a reference to the next sibling of the element clicked
                                            //   allow us to access the input element following the description
  textBox.value = description;              // set the initial value of the input box to the default description
  // .classlist represents the list of classes currently assigned to element - use it to add/remove move classes
  textBox.classList.remove('d-none');       // un-hide the input box by removing the d-none class
  desc.classList.add('d-none');             // hide the element that was clicked by adding the d-none class
  textBox.focus();                          // put the cursor (focus) in the input box
} 

/**
 * Take an event on the text box and set the description to the contents
 * of the text box and then hide the text box and show the description.
 *
 * @param {Event} event the event object
 * @param {Boolean} save should we save the description text
 */
function exitDescriptionEdit(textBox, save) {  // receive the element where Enter or Escape was pressed
                                               // The second parameter is a boolean indicate should the content be saved or not
  let desc = textBox.previousElementSibling;   // Get a reference to element that is a previous sibling to this one (description line)
  if (save) {                       // save was requested (true)
    desc.innerText = textBox.value; //    set the description content to the content of teh input box
  }
  textBox.classList.add('d-none');  // hide the input box (add d-none to it's class)
  desc.classList.remove('d-none');  // display the description box (remove d-none from class)
}

/**
 * I will show / hide the add review form
 */
function showHideForm() {                              // This will hide or show the form for a review
  const form = document.querySelector('form');         // Get a reference to the form in the html
  const btn = document.getElementById('btnToggleForm');// Get a reference to 'Add Review' button in the html

  if (form.classList.contains('d-none')) {     // If the form is currently hidden (class has d-none)
    form.classList.remove('d-none');           //    Remove the d-none to display the form
    btn.innerText = 'Hide Form';               //    Change button to say 'Hide Form'
    document.getElementById('name').focus();   //    Find the element with the id='name' and put the cursor in it 
  } else {                                     // if the form is currently displayed
    resetFormValues();                         //    reset the form values using function provided
    form.classList.add('d-none');              //    Add the d-none class to the form to hide oy
    btn.innerText = 'Add Review';              //    Make the button say 'Add Review'
  }
}

/**
 * I will reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');    // Get a reference to teh form in the html
  const inputs = form.querySelectorAll('input');  // Get an array of references for all the input boxes in the form
  inputs.forEach((input) => {                     // Loop through the array of input nox references
    input.value = '';                             //    Set the current input box value to an empty string
  });
  document.getElementById('rating').value = 1;    // Set the rating to 1
  document.getElementById('review').value = '';   // Set the review to an empty string
}

/**
 * I will save the review that was added using the add review from
 */
function saveReview() {
// We need to add an element to our reviews array with the values from the form
// Each array element is a JavaScript object

// Get a reference to input box in the form
const nameBox = document.getElementById('name');
const titleBox = document.getElementById('title');
const reviewBox = document.getElementById('review');
const ratingBox = document.getElementById('rating');

// Get the values from the form and create a new element to add to the reviews array
const newReview = {
  reviewer: nameBox.value,  // create a reviewer in the new review with the value from the name input box
  title: titleBox.value,    // create a title in the new review with the value from the title input b
  review: reviewBox.value,  // create a review in the new review with the value from the review input b
  rating: ratingBox.value   // create a rating in the new review with the value from the rating input b
}
// Add the new review object to the reviews array
reviews.push(newReview);   // Add the new review to the array in memory
displayReview(newReview);  // Add the new review to the DOM/HTML for display
showHideForm();            // Hide the form now that we have save the data

}
