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
  const pageTitle = document.getElementById('page-title'); // get a reference to the element with the id page-title
  pageTitle.querySelector('.name').innerText = name; // Set the text element with the class='name' to the value in pageTitle
}
/**
 * Add our product description to the page.
 */
function setPageDescription() {document.querySelector('.description').innerText=description;}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {
  const divMain = document.getElementById('main')
  // Create out div elements
  reviews.forEach((aReview) => {
    const newReview = document.createElement('div')
    newReview.setAttribute('class', 'review')

    // run the helper functions to add the rest of the elements to div
    addReviewer(newReview, aReview.reviewer) // Add reviewer elements to the div 
    addRating(newReview, aReview.rating) // Add rating elements to the div
    addTitle(newReview, aReview.title) // Add title elements to the div
    addReview(newReview, aReview.review) // Add review elements to the div

    // get a reference to the div where the reviews
    divMain.insertAdjacentElement('beforeend', newReview);
  });
  
}

/**
 * I will creating a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} el: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const theReviewer = document.createElement('h4');
  theReviewer.innerText = name;
  parent.appendChild(theReviewer);
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  const theRating = document.createElement('div');
  theRating.setAttribute('class', 'rating');

  for (let i = 0; i < numberOfStars; i++) { // loop for the value in rating for the book
    const aStar = document.createElement('img');
    aStar.setAttribute('class', 'ratingStar');
    aStar.src='img/star.png';
    theRating.appendChild(aStar);
  }
  parent.appendChild(theRating);
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  const theTitle = document.createElement('h3');
  theTitle.innerText = title;
  parent.appendChild(theTitle)
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const theReview = document.createElement('div');
  theReview.innerText = review;
  parent.appendChild(theReview);
}

/*******************************************
 * Here is where we call the functions written above to manipulate 
 * the DOM
 *******************************************/

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
