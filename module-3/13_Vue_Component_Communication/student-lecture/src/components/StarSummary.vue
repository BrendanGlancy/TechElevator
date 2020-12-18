<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ numberOfReviews }}</span>
    {{ rating }} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  props: ["rating"], // props means the data is coming from an external source
  methods: {
    updateFilter() {
     this.$store.commit("UPDATE_FILTER", parseInt(this.rating));
    }
  },
  computed: {
    numberOfReviews() {
      const reviews = this.$store.state.reviews; // Get the reviews from this apps
      // Vue data store
      return reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === parseInt(this.rating) ? 1 : 0);
      }, 0);
    }
  } 
};
</script>

