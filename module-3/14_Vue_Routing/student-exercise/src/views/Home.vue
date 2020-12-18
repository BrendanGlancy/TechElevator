<template>
  <div>
    <best-seller-list /> <!-- include the ProductList.Vue component -->
    <new-releases-list />
  </div>
</template>

<script> // JavaScript
import NewReleasesList from '../components/NewReleasesList.vue';
import BestSellerList from '../components/BestSellerList.vue';
  export default { // Expose data to external processes
    components: { // list of vue components used in this one
        BestSellerList,
        NewReleasesList
    },
    computed: {}
  }
</script>
<style scoped>
</style>
