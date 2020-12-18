<template>
  <div class="book-container">
    <book-card v-for="book in $store.state.books" v-bind:book="book" v-bind:key="book.title" />
  </div>
</template>

<script>
import BookCard from './BookCard.vue'

//import component from ''


export default {
  components: { BookCard },
  name: 'reading-list', 
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>