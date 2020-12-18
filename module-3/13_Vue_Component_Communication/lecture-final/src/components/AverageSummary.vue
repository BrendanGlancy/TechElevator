<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ averageRating }}</span>
    Average Rating
  </div>
</template>

<script>
export default {
  name: "average-summary",
  methods: {
    updateFilter() {
      this.$store.commit("UPDATE_FILTER",0); // run the data store mutation UPDATE_FILTER 
    }
  },
  computed: {
    averageRating() {
      const reviews = this.$store.state.reviews;  // go get the reviews from this app's Vuex data store
      let sum = reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / reviews.length).toFixed(2);
    }
  }
};
</script>
