import Vue from 'vue'      // Give me access to the Vue code
import Vuex from 'vuex'    // Give mr access to Vuex

Vue.use(Vuex)    // Tell Vue I am using Vuex

// export will expose data from teh JavaScript file to outside processes
export default new Vuex.Store({  // Instantiate a Vuex data store
  state: {    // This is the object that holds all the data in the data store
    name: 'Cigar Parties for Dummies',
    description: 'Host and plan the perfect cigar party for all of your squirrelly friends.',
    filter: 0,
    reviews: [
      {
        reviewer: 'Malcolm Gladwell',
        title: 'What a book!',
        review:
          "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
        rating: 3,
        favorited: false
      },
      {
        reviewer: 'Tim Ferriss',
        title: 'Had a cigar party started in less than 4 hours.',
        review:
          "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
        rating: 4,
        favorited: false
      },
      {
        reviewer: 'Ramit Sethi',
        title: 'What every new entrepreneurs needs. A door stop.',
        review:
          "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
        rating: 1,
        favorited: false
      },
      {
        reviewer: 'Gary Vaynerchuk',
        title: 'And I thought I could write',
        review:
          "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
        rating: 3,
        favorited: false
      }
    ],
  },  // end of state object
  mutations: {  // processes to make changes to the data store - used by components
    // the data store to use is automatically passed to mutation as 1st parameter
    // we chose to call it state in this code
    ADD_REVIEW(state, review) {
      state.reviews.unshift(review);  // add to start of reviews array
    },
    UPDATE_FILTER(state, newFilter) {
      state.filter = newFilter;          // set the filter property to the value passed
    },
    FLIP_FAVORITED(state, reviewToChange) {
      reviewToChange.favorited = ! reviewToChange.favorited;  // reverse the value of favorited
                                                              //    in the review passed in to the mutation
    }
  },
  actions: {
  },
  modules: {
  },
  strict: true    // should the rule about only mutations can change data in the data store be enforced?
})
