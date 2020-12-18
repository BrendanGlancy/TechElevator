<template>   <!-- HTML for the component -->
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- A Vue component is used as a tag in your html    -->
    <!-- Vue component names are coded in kabob-case so you tell them apart from standard html -->
    <product-review></product-review> <!-- Our Vue component - note: kabob-case -->
  </div>
</template>

<script>     // JavaScript for the component
// the src folded is considered the root folder for the project
// directory references are relative to src folder
import ProductReview from './components/ProductReview.vue'  // Go get the ProductReview.vue code

// Allow Vue to access the data in this JavaScript code so it can use and manipulate it
export default {  // export exposes data from JavaScript to outsied processes - like Vue
  name: 'App',    // name of the application
  components: {   // JavaScript object with elements containing the Vue components used
    ProductReview // Tells Vue we are using the ProductReview component - match the import name
  } 
}
</script>

<style>      /* CSS for the component */
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
