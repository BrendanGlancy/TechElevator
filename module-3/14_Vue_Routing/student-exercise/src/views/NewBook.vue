<template>
  <div>
    <new-book-form />
  </div>
</template>

<script> // JavaScript
import NewBookForm from '../components/NewBookForm.vue';

  export default { // Expose data to external processes
    components: { // list of vue components used in this one
        NewBookForm
    }
  }
</script>
<style scoped>
</style>