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
  // If the html content supports a template 
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
  const main = document.getElementById('main');
  // Clone the template and get a regference to it (this does what all the createElements did)
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerHTML = review.reviewer;
  tmpl.querySelector('h3').innerHTML = review.title;
  tmpl.querySelector('p').innerHTML = review.review;
  // there will always be 1 star because it is a part of the template, so we start at one
  for (let i = 1; i < review.rating; ++i) { // add stars if the rating was greater than 1
    const img = tmpl.querySelector('img').cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  main.appendChild(tmpl);
}

// LECTURE STARTS HERE ---------------------------------------------------------------

/**************************************
 * These functions will execute when the page is loaded into the browser
 *
 * Since these functions contain statements that manipulat the DOM
 * if the DOM has not yet been created when they run, they will fail 
 *
 * So we should wait unti the DOM is created before allowing them to run
 *
 * Luckily, the browser will tell us when it has finished creating the DOM
 * by firing / triggering the DOMContentLoaded event
 **************************************/

// wait untit the DOM is loaded before manipulating it
document.addEventListener('DOMContentLoaded', () => {
  // set the product  
  setPageTitle();   
  // set the product// set the product reviews page title
  setPageDescription();
  // display all of the product reviews on our page
  displayReviews();


  /**
   * Take an event on the description and swap out the description for a text box.
   */
  const descriptionLine = document.querySelector('.description')

  // add an event handler for the event to the descriptionLine using an anonymous function 
  // which will call the function provided to us passing a reference to the element 
  descriptionLine.addEventListener('click', function (event) {
      toggleDescriptionEdit(event.target);
  })

  const theInputBox = document.getElementById('inputDesc') // get a reference to the input box
  theInputBox.addEventListener('keyup', (event) => {
    if (event.Booleankey === 'Enter') { // if the key that was pressed was the enter Booleankey
      exitDescriptionEdit(event.target, true);
    }
    if (event.Booleankey === 'Escape') { // if the key that was pressed was the enter Booleankey
      exitDescriptionEdit(event.target, false);                                  
    }                           
  })
  // Add an event listener to the button for the add review
  const theAddReview = document.getElementById('btnToggleForm')
  theAddReview.addEventListener('click', (event) => {
   showHideForm(); // run the function
  })

  // Add an event listener
  const theSaveReview = document.getElementById('btnSaveReview')
  theSaveReview.addEventListener('click', (event) => {
    saveReview();
  })
  
});

/**
 * This function is used when the description line is clicked
 *
 * @param {element-clicked} the element the user clicked which causes this function to run
 */
function toggleDescriptionEdit(desc) {
  // get a reference to the next sibling of the element clicked
  const textBox = desc.nextElementSibling;
  // allow us to access the input element 
  textBox.value = description; // set the initial value of the input box to the default description
  textBox.classList.remove('d-none'); // un-hide the input box by removing the d-none class
  desc.classList.add('d-none');  // hide the element that was clicked by adding the d-none class  
  textBox.focus();
}

/**
 * Take an event on the text box and set the description to the contents
 * of the text box and then hide the text box and show the description.
 *
 * @param {Event} event the event object
 * @param {Boolean} save should we save the description text
 */
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling;
  if (save) {
    desc.innerText = textBox.value;
  }
  textBox.classList.add('d-none');
  desc.classList.remove('d-none');
}

/**
 * I will show / hide the add review form
 */
function showHideForm() { // this will hide or show the form for a review 
  const form = document.querySelector('form');
  const btn = document.getElementById('btnToggleForm');

  if (form.classList.contains('d-none')) { // if the form is currrently hidden (class has d-none)
    form.classList.remove('d-none'); // Remove the d-none to display the form
    btn.innerText = 'Hide Form'; // Change the button to say 'Hide Form'
    document.getElementById('name').focus(); // find the element with the id='name'
  } else {
    resetFormValues();
    form.classList.add('d-none');
    btn.innerText = 'Add Review';
  }
}

/**
 * I will reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');
  const inputs = form.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = '';
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}

/**
 * I will save the review that was added using the add review from
 */
function saveReview() {
  const nameBox = document.getElementById('name')
  const titleBox = document.getElementById('title')
  const reviewBox = document.getElementById('review')
  const ratingBox = document.getElementById('rating')

  const newReview = {
    reviewer: nameBox.value, // create a reviewer in the new review with the value from the name input box
    title: titleBox.value,
    review: reviewBox.value,
    rating: ratingBox.value
  }
  
  // add the new review to the review array
  reviews.push(newReview);
  displayReview(newReview); // add the new review to the DOM
  showHideForm();
}
