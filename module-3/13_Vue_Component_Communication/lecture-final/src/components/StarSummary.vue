<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ numberOfReviews }}</span>
    {{ rating }} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  props: ["rating"], // props means the data is coming from and external source
                     // in this case it's coming from App.vue as an attribute rating=""
  methods: {
    updateFilter() {
      // call the data store mutation to change the filter value with the rating as an int
      this.$store.commit("UPDATE_FILTER",parseInt(this.rating)); 
    }
  },
  computed: {
    numberOfReviews() {
      const reviews = this.$store.state.reviews; // Get the reviews from this app's Vue data store
      return reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === parseInt(this.rating) ? 1 : 0);
      }, 0);
    }
  }
};
</script>

