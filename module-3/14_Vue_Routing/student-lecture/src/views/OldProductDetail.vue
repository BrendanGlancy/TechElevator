<!-- ProductDetail router view component -->
<template>
  <div id='app' class='main'>
    <h1>Product Name:</h1>
  </div>
</template>


<script>

// We need to ge the product id to be displayed in this page
// The product id is coming from the url path: product/:id
// Vue router creates the page when it gets a path it knows about
export default {
  created() { // define code to be run for the created hook in the view process
    // this code will run before Vue compiles the template which generates the HTML for the page 
    // get the id from the URL and set the activeProductID in the data store
    const currentProductID = this.$route.params.id;
    this.$store.commit("SET_ACTIVE_PRODUCT", currentProductID); // tell datastore to SET_ACTIVE_PROJECT to currentProductID
  },
  computed: {
    product() { // this function will get the current product's data from the data store
      // go to the Datastore products array and find the product with the id in path
      // We can use the array find() method to locate the element we want
      // like most array functions find loops through an array sending the current element ->
      // to a function provided to it, the function is usually one statement and anonymous
      // the product data we want is stored in currentProductID
      const theProducts = this.$store.state.products.find(aProduct => aProduct.id === this.$store.state.activeProduct);
    
      return theProducts;
    }
  }

}
</script>

<style scoped>
</style>
