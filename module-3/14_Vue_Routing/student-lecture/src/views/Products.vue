<!-- Products view , we need to tell the router it's managing this view -->
<!-- this view will be managed by the Vue router -->
<!-- Vue COMPONENTS are inclued here instead of App.vue -->
<template>
  <div class="products">
    <h1>Products</h1>
    <product-list /> <!-- include the ProductList.Vue component -->
  </div>
</template>

<script> // JavaScript
                          // @ is short-hand for the root folder of the app
  import ProductList from '@/components/ProductsList'; 
  export default { // Expose data to external processes
    components: { // list of vue components used in this one
      ProductList
    }
  }
</script>
<style scoped>
</style>
