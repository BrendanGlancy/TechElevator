<template>
  <form v-on:submit.prevent="addNewReview">
    <div class="form-element">
      <label for="reviewer">Name:</label>
      <input id="reviewer" type="text" v-model="newReview.reviewer" />
    </div>
    <div class="form-element">
      <label for="title">Title:</label>
      <input id="title" type="text" v-model="newReview.title" />
    </div>
    <div class="form-element">
      <label for="rating">Rating:</label>
      <select id="rating" v-model.number="newReview.rating">
        <option value="1">1 Star</option>
        <option value="2">2 Stars</option>
        <option value="3">3 Stars</option>
        <option value="4">4 Stars</option>
        <option value="5">5 Stars</option>
      </select>
    </div>
    <div class="form-element">
      <label for="review">Review</label>
      <textarea id="review" v-model="newReview.review"></textarea>
    </div>
    <div class="actions">
      <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
      <button>Submit</button>
    </div>
  </form>
</template>

<script>
export default {
  name: "add-review",
  data() {
    return {
      newReview: {
        id: 0,
        reviewer: "",
        title: "",
        rating: 0,
        review: ""
      }
    };
  },
  methods: {
    addNewReview() {
      const productID = this.$route.params.id;
      this.newReview.id = productID;
      this.$store.commit("ADD_REVIEW", this.newReview);
      // TODO: send the visitor back to the product page to see the new review
    },
    resetForm() {
      this.newReview = {};
    }
  }
};
</script>

<style scoped>
form {
  width: 500px;
  margin: 20px;
}
.form-element label {
  width: 100px;
  vertical-align: top;
}
.form-element input,
select,
textarea {
  width: 400px;
  font-size: 1.1rem;
}
.form-element textarea {
  height: 150px;
}
.actions {
  float: right;
}
.actions button {
  margin-left: 10px;
}
</style>
