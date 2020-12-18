<template> 
    <div class='main'>
         <h2>Product Reviews for {{ title }}</h2>      <!-- use a mustache expression {{ variable }} to hold a place data in our html -->
          <p class='description'>{{words}} </p> <!-- use a mustache expression {{ variable }} to hold a place data in our html -->
          <div class="well-display">
              <div class="well"> <!-- average rating box -->
              <span class="amount">{{numberFromAverageRating}}</span>
                Average Rating
              </div>
              <div class="well"> <!-- # 1 star rating box -->
              <span class="amount">{{numberOfOneStarReviews}}</span>
                  1 Star Rating
              </div>
              <div class="well"> <!-- # 2 star rating box -->
              <span class="amount">{{numberOfTwoStarReviews}}</span>
                  2 Star Rating
              </div>
              <div class="well"> <!-- # 3 star rating box -->
              <span class="amount">{{numberOfThreeStarReviews}}</span>
                  3 Star Rating
              </div>
              <div class="well"> <!-- # 4 star rating box -->
              <span class="amount">{{numberOfFourStarReviews}}</span>
                  4 Star Rating
              </div>
              <div class="well"> <!-- # 5 star rating box -->
              <span class="amount">{{numberOfFiveStarReviews}}</span>
                  5 Star Rating
              </div>
          </div>
          <!-- v-bind will allow you to connect a piece of data to an attribute for an element -->
          <!-- adding a class="the-value" -->
          <!-- loop through the array here in the HTML defining elements for each review -->
          <!-- Use the vue V4 statement to loop through the array -->
          <!-- v-for=(element-name in array-name) - element-name contains the current value -->
          <!-- v-for requires a v-bind to connect a key to a value related to the array -->
          <!-- the key is used to maintain a sequence of the display when add.remove elements -->
          <div 
                class="review"
                v-bind:class="{ favorited: reviews.favorited }"
                v-for="aReview in reviews" v-bind:key="aReview.id"
            >
                <h4>{{ aReview.reviewer }}</h4>
                <div class="rating"> <!-- stars will go here -->
                    <img
                        src="../assets/star.png"
                        v-bind:title="review.rating + ' Star Review '"
                        class="ratingStar"
                        v-for="n in aReview.rating" v-bind:key="n"
                    >
                        
                </div> 
                <h3>{{ aReview.title }}</h3>
                <p>{{ aReview.review }}</p>
          </div>
    </div>
</template>

<script> // JavaScript for the component
export default { // data to be shared with Vue
    name: 'product-review', // Component name in kabob-case ( - between the words )
    data() { // data function is provided for Vue to call when it needs data for the app
        return { // we return a JavaScript object with the data we want to share with Vue
            title: 'Cigar Party for Dummies',
            words: 'Host and plan the perfect cigar party for all your squirrley friends',
            reviews: [
        {
          reviewer: "Malcolm Gladwell",
          title: "What a book!",
          review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
          rating: 3,
          favorited: false
        },
        {
          reviewer: "Tim Ferriss",
          title: "Had a cigar party started in less than 4 hours.",
          review:
            "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
          rating: 4,
          favorited: false
        },
        {
          reviewer: "Ramit Sethi",
          title: "What every new entrepreneurs needs. A door stop.",
          review:
            "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
          rating: 1,
          favorited: false
        },
        {
          reviewer: "Gary Vaynerchuk",
          title: "And I thought I could write",
          review:
            "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
          rating: 3,
          favorited: false
        }
      ]
    };
  },
  computed: { // Stuff in here is computed every time a value changes in the data
  // Computed values aren't function they represent values just like variables
    numberFromAverageRating() {
        // Get the sum of all the ratings and divide 
        let sum = this.reviews.reduce((totalRating, aReview) => {
            totalRating += aReview.rating; // total rating += the sum of all the ratings
            return totalRating;
        },0)
        return sum / this.reviews.length;
    },
    numberOfOneStarReviews() {  
        // go through the array and count the number of one star reviews
        // reduce the array to the number of 1-star reviews 
        // call the array function reduce using the reviews array in this component
        // reduce takes on a parameter which is a function that takes a variable to hold the result
        // and an array element 
        // the function passed to reduce will modify the variable using the array element
        return this.reviews.reduce((currentCount, aReview) => {
            // add one to current count, if the rating is a 1
            if (aReview.rating === 1) {
                currentCount++;
            }
            return currentCount;
        },0)
    },
    numberOfTwoStarReviews() {
        return this.reviews.reduce((currentCount, aReview) => {
            // add one to current count, if the rating is a 1
            if (aReview.rating === 2) {
                currentCount++;
            }
            return currentCount;
        },0)
    },
    numberOfThreeStarReviews() {
        return this.reviews.reduce((currentCount, aReview) => {
            // add one to current count, if the rating is a 1
            if (aReview.rating === 3) {
                currentCount++;
            }
            return currentCount;
        },0)
    },
    numberOfFourStarReviews() {
        return this.reviews.reduce((currentCount, aReview) => {
            // add one to current count, if the rating is a 1
            if (aReview.rating === 4) {
                currentCount++;
            }
            return currentCount;
        },0)
    },
    numberOfFiveStarReviews() {
        return this.reviews.reduce((currentCount, aReview) => {
            // add one to current count, if the rating is a 1
            if (aReview.rating === 5) {
                currentCount++;
            }
            return currentCount;
        },0)
    }
  }

        }

    

</script> 

<style scoped>
    div.main {
        margin: 1rem 0;
    }
    div.main div.well-display {
        display: flex;
        justify-content: space-around;
    }
    div.main div.well-display div.well {
        display: inline-block;
        width: 15%;
        border: 1px black solid;
        border-radius: 6px;
        text-align: center;
        margin: 0.25rem;
    }
    div.main div.well-display div.well span.amount {
        color: darkslategray;
        display: block;
        font-size: 2.5rem;
    }
    div.main div.review {
        border: 1px black solid;
        border-radius: 6px;
        padding: 1rem;
        margin: 10px;
    }
    div.main div.review.favorited {
        background-color: lightyellow;
    }
    div.main div.review div.rating {
        height: 2rem;
        display: inline-block;
        vertical-align: top;
        margin: 0 0.5rem;
    }
    div.main div.review div.rating img {
        height: 100%;
    }
    div.main div.review p {
        margin: 20px;
    }
    div.main div.review h3 {
        display: inline-block;
    }
    div.main div.review h4 {
        font-size: 1rem;
    }
</style>