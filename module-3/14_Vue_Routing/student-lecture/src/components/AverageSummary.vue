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
      this.$store.commit("UPDATE_FILTER", 0);
    }
  },
  computed: {
    averageRating() {
      const reviews = this.$store.state.products.find(
        p => p.id == this.$store.state.activeProduct
      ).reviews;
      let sum = reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      if (sum === 0) {
        return 0;
      } else {
        return sum / reviews.length;
      }
    }
  }
};
</script>
