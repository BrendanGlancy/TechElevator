<template>
  <div class="todo-list">
    <h1>My Daily Routine</h1>
    <input class="filter" type="text" v-model="filterText" placeholder="Filter Todos" />
    <ul>
      <li
        v-for="todo in filteredTodos"
        v-bind:key="todo.name"
        v-bind:class="{ finished: todo.done }"
      >
        <input type="checkbox" v-model="todo.done" />
        {{ todo.name }}
        <span class="delete" v-on:click="deleteTodo(todo)">×</span>
      </li>
    </ul>
    <form v-on:submit.prevent="createTodo">
      <input type="text" v-model="newItem" placeholder="Add new Todo" />
      <button type="submit" class="btn save">Save</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      filterText: "",
      newItem: "",
      todos: [
        {
          name: "Wake up",
          done: false
        },
        {
          name: "5 Minute Morning Movement",
          done: false
        },
        {
          name: "Meditate",
          done: false
        },
        {
          name: "Brush Teeth",
          done: false
        },
        {
          name: "Shower",
          done: false
        }
      ]
    };
  },
  methods: {
    deleteTodo(todoToDelete) {
      this.todos = this.todos.filter((todo) => {
        return todo !== todoToDelete;
      });
    },
    createTodo() {
      this.todos.push({
        name: this.newItem,
        done: false
      });
      this.newItem = "";
    }
  },
  computed: {
    filteredTodos() {
      return this.todos.filter((todo) => {
        return todo.name.includes(this.filterText);
      });
    }
  }
};
</script>

<style>
.todo-list {
  width: 450px;
  background: #fff;
  margin: 50px auto;
  font-family: "Roboto Condensed", sans-serif;
  border-radius: 10px;
}
h1 {
  background: #f2f2f2;
  color: #4b86a6;
  padding: 10px;
  font-size: 24px;
  text-transform: uppercase;
  text-align: center;
  margin-bottom: 20px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
ul {
  list-style-type: none;
  margin: 0px;
  padding: 0px;
}
li {
  font-size: 24px;
  border-bottom: 1px solid #f2f2f2;
  padding: 10px 20px;
}
li:last-child {
  border: 0px;
}
.finished {
  background-color: grey;
}
input[type="text"] {
  font-size: 1em;
  display: block;
  padding: 8px;
}
.delete {
  color: red;
  cursor: pointer;
}
.filter {
  margin: 10px auto;
  width: 90%;
}

form {
  display: flex;
  padding: 20px;
}
form input {
  width: 80%;
  margin-right: 5px !important;
}
form .btn.save {
  font-size: 1em;
}
</style>
