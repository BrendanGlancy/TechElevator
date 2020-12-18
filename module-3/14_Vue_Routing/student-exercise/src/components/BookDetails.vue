<template>
 <div>
     <h2 class="book-title">{{ book.title }}</h2>
     <h3 class="book-author">{{ book.author }}</h3>
     <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
     <p>{{book.read === true ? "I have read this book" : "I have not read this book yet"}}</p>
 </div>
</template>

<script>
export default {
    name: 'book-detail',
    computed: {
        book() {
            let currentBook = this.$store.state.books.find((aBook) => {
                return aBook.isbn === this.$route.params.isbn
            })
            if (currentBook != null) {
                return currentBook;
            } else {
                return this.$store.state.popularBooks.find((aBook) => {
                    return aBook.isbn === this.$route.params.isbn;
                })
            }
        }
    }
}


</script>