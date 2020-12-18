<template>
    <section class="todo-list">
        <h1>My Daily Routine</h1>
        <ul>
            <li v-for="todo in todos" v-bind:key="todo.name"  v-bind:class="{ 'todo-completed': todo.done }">
                <input type="checkbox" v-model="todo.done"/>
                <span v-bind:class="{ completed: todo.done }">{{todo.name}}</span>
            </li>
        </ul>
    </section>
</template>

<script>
export default {
  data() {
    return {
        todos: [
          { name: 'Wake up', done: false, category: 'Home' },
          { name: '5 Minute Morning Movement', done: false, category: 'Home' },
          { name: 'Meditate', done: false, category: 'Home' },
          { name: 'Brush teeth', done: false, category: 'Home' },
          { name: 'Shower', done: false, category: 'Home' },
          { name: 'Answer email', done: false, category: 'Work' },
          { name: 'Stand up meeting', done: false, category: 'Work' },
          { name: 'Fix a bug', done: false, category: 'Work' },
        ]
    }
  }
}
</script>

<style>
.todo-list {
    width:450px;
    background: #fff;
    margin: 50px auto;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 10px;
}
h1 {
    background:#f2f2f2;
    color:#4b86A6;
    padding:10px;
    font-size:24px;
    text-transform: uppercase;
    text-align: center;
    margin-bottom: 0px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
ul {
    list-style-type: none;
    margin:0px;
    padding:0px;
}
li {
    font-size: 24px;
    border-bottom:1px solid #f2f2f2;
    padding:10px 20px;
}
li:last-child{
    border:0px;
}
li.todo-completed {
    text-decoration: line-through;
    color: darkgray;
}
</style>
