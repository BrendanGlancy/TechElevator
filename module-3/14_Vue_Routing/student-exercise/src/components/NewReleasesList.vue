<template>
<section>
  <h2>New Releases</h2>
  <div class="new-releases-list">

    <book-card v-for="book in books" v-bind:book="book" v-bind:key="book.isbn" v-bind:enable-add="true" />
  </div>
  </section>
</template>

<script>
import BookCard from '@/components/BookCard.vue';

export default {
  name: "new-releases-list",
  computed: {
    books() {
      return this.$store.state.popularBooks.filter((book) => {
        return book.newRelease === true;
      });
    }
  },
  components: {
    BookCard
  }
}
</script>

<style>
.new-releases-list {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>