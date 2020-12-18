const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() { 
  const pageTitle = document.getElementById('page-title'); // Get a reference to the id='page-title' in the DOM
// pageTitle now points to the element in the DOM with the id='page-title'
   pageTitle.querySelector('.name').innerText = name; // go to the element referenced by page title
                                                      // find the class='name' and set it's text to our variable name
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description; // Get a reference to the element with class='desciption'
                                                                  // Set it's innerText to our description variable
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {
  const main = document.getElementById('main'); // Get a reference to element with id='main'
// Loop through the array of review objects and add them to the DOM (so the user can see them)
  reviews.forEach((aReview) => {  // Loop through the array called views with each element named aReview in the loop
      const newReview = document.createElement('div'); // Create a div to hold the new review to be added to the DOM
      newReview.setAttribute('class', 'review');       // adding a "class='review" attribute to the div

      // run the functions to add the additional info to the reviews
      addReviewer(newReview, aReview.reviewer);  // Call addReviewer() with the parent and the reviewer name
      addRating(newReview,aReview.rating);       // Call addRating() with the parent and the rating
      addTitle(newReview, aReview.title);        // Call addTitle() with the parent and the title
      addReview(newReview,aReview.review);       // call addReview() with the parent and reg review text

      // At this point we have a new div (element) with what we want in it, but it has not been added to the DOM
      // Add the new element to the DOM as a child of element with the id='main' as indicated in the html

      main.insertAdjacentElement('beforeend', newReview); // Add the newReview to the end of the element with id main
    })
  
}

/**
 * I will creating a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} el: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const reviewer = document.createElement('div'); // Create a div to hold the reviewer's name
  reviewer.innerText = name;                      // Set the content of the div to the name passed as second argument
  parent.appendChild(reviewer);                   // add the div as a child of the parent passed in as first parameter
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
const rating = document.createElement('div');   // Create a div to hold the rating stars
rating.setAttribute('class','rating');          // Add a class='ratingStar' to the new div
for (let i=0; i< numberOfStars; i++){           // Loop put put one star image for rating value
  const star = document.createElement('img');   //     create and img element for a star
  star.src='img/star.png';                      //     set the src= for the image to the star picture
  star.setAttribute('class','img');             //     set class='img' to new img
  rating.appendChild(star);                     //     add star image to rating
}
parent.appendChild(rating);                     // Add the rating to parent
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  const h3 = document.createElement('h3');  // Create new h3 for title
  h3.innerText = title;                     // Set the text to 2nd parameter
  parent.appendChild(h3);                   // Add new h3 to parent
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const feedback = document.createElement('p');  // Create a paragraph element for review
  feedback.innerText = review;                   // Set text to 2nd parameter
  parent.appendChild(feedback);                  // Add the new paragraph to the parent
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
