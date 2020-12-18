<template>
  <section class="todo-summary">
      <div>
          <h3>Home</h3>
          <p>{{ completedHomeTodos }} / {{ totalHomeTodos }}</p>
      </div>
      <div>
          <h3>Work</h3>
          <p>{{ completedWorkTodos }} / {{ totalWorkTodos }}</p>
      </div>
  </section>
</template>

<script>
export default {
    computed: {
        totalHomeTodos() {
            return this.$store.state.todos.filter((todo) => {
                return todo.category === 'Home';
            }).length;
        },
        completedHomeTodos() {
            return this.$store.state.todos.filter((todo) => {
                return todo.done === true && todo.category === 'Home';
            }).length;
        },
        totalWorkTodos() {
            return this.$store.state.todos.filter((todo) => {
                return todo.category === 'Work';
            }).length;
        },
        completedWorkTodos() {
            return this.$store.state.todos.filter((todo) => {
                return todo.done === true && todo.category === 'Work';
            }).length;
        },
    }
}
</script>

<style>
.todo-summary {
    width:600px;
    background: #fff;
    margin: auto;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 10px;
    display: flex;
    justify-content:space-evenly;
}

.todo-summary div {
    border: 1px black solid;
    padding: 20px;
    border-radius: 5px;
    display: inline-block;
    text-align: center;
    width: 40%;
}

.todo-summary div p {
    font-size: 2em;
    margin: 3px;
}
</style>