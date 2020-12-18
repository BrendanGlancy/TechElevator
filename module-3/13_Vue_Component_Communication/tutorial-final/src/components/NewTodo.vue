<template>
  <section class="new-todo">
      <form v-on:submit.prevent="saveTodo">
        <input type="text" placeholder="Name" v-model="newTodo.name">
        <select v-model="newTodo.category">
          <option value="">--- Select a category ---</option>
          <option value="Home">Home</option>
          <option value="Work">Work</option>
        </select>
        <button>Add</button>
      </form>
  </section>
</template>

<script>
export default {
  data() {
    return {
      newTodo: {
        name: '',
        category: '',
        done: false
      }
    }
  },
  methods: {
    saveTodo() {
      this.newTodo.done = false;
      this.$store.commit('ADD_NEW_TODO', this.newTodo);
      this.newTodo = {
        name: '',
        category: '',
        done: false
      };
    }
  }
}
</script>

<style>
.new-todo {
    width:450px;
    background: #fff;
    margin: auto;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 10px;
}
input, select, button {
  padding: 5px 5px;
  margin: 5px;
}
</style>