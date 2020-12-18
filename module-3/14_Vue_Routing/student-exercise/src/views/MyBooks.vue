<template>
  <div>
    <reading-list />
    <router-link v-bind:to="{name: 'add-book'}">Add Book to Reading List</router-link>
  </div>
</template>

<script> // JavaScript
import ReadingList from '../components/ReadingList.vue';
  export default { // Expose data to external processes
    components: { // list of vue components used in this one
        ReadingList
    }
  }
</script>
<style scoped>
</style>