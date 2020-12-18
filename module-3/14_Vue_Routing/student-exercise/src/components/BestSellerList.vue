<template>
<section>
    <h2>Best Sellers</h2>
  <div class="best-seller-list">
    <book-card v-for="book in books" v-bind:book="book" v-bind:key="book.isbn" v-bind:enable-add="true" />
  </div>
  </section>
</template>

<script>
import BookCard from '@/components/BookCard.vue';

export default {
  name: "best-seller-list",
  computed: {
    books() {
      return this.$store.state.popularBooks.filter((book) => {
        return book.bestSeller === true;
      });
    }
  },
  components: {
    BookCard
  }
}
</script>

<style>
.best-seller-list {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>