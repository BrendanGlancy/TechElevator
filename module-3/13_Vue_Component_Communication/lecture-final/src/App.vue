<template>
  <div id="app" class="main">
    <h1>Product Reviews for {{ $store.state.name }} </h1> <!-- get the name value form the data store -->
    <p class="description">{{ $store.state.description }}</p>
    <div class="well-display">
      <!-- include each component on the page using it as kabob-case html tag -->
      <average-summary /> 
      <star-summary rating="1"/> <!-- pass a value for rating to StarSummary component-->
      <star-summary rating="2"/> <!-- pass a value for rating to StarSummary component-->
      <star-summary rating="3"/> <!-- pass a value for rating to StarSummary component-->
      <star-summary rating="4"/> <!-- pass a value for rating to StarSummary component-->
      <star-summary rating="5"/> <!-- pass a value for rating to StarSummary component-->
    </div>
    <add-review />
    <review-list /> 
    <!-- <review-table /> -->  <!-- de-comment this an comment out ReviewList to see table format -->
  </div>
</template>

<script>
// We need to import the code for each compnent we are using
import AverageSummary from "./components/AverageSummary.vue";
import StarSummary from "./components/StarSummary.vue";
import AddReview from "./components/AddReview.vue";
import ReviewList from "./components/ReviewList.vue";
//import ReviewTable from "./components/ReviewTable.vue"; // de-comment this and comment out ReviewList to see table format

export default {
  name: "app",
  components: {    // List of the Vue components used
    AverageSummary,
    StarSummary,
    AddReview,
    ReviewList
    // ReviewTable   // de-comment this and comment out ReviewList to see table format
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
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

div.main div.well-display div.well {
  cursor: pointer;
}
</style>
