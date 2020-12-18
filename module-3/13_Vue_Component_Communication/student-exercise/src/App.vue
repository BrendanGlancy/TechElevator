<template>
  <div id="app">
    <h1>Reading List</h1>
    <reading-list />
    <new-book-form />
  </div>
</template>

<script>
import NewBookForm from './components/NewBookForm.vue';
import ReadingList from './components/ReadingList.vue';



export default {
  name: 'app',
  components: {
    ReadingList,
    NewBookForm
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}
</style>