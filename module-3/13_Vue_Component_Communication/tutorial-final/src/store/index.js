import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    todos: [
      { name: "Wake up", done: false, category: "Home" },
      { name: "5 Minute Morning Movement", done: false, category: "Home" },
      { name: "Meditate", done: false, category: "Home" },
      { name: "Brush teeth", done: false, category: "Home" },
      { name: "Shower", done: false, category: "Home" },
      { name: "Answer email", done: false, category: "Work" },
      { name: "Stand up meeting", done: false, category: "Work" },
      { name: "Fix a bug", done: false, category: "Work" }
    ]
  },
  mutations: {
    ADD_NEW_TODO(state, todo) {
      state.todos.push(todo);
    },
    FLIP_DONE(state, todoToChange) {
      todoToChange.done = ! todoToChange.done;
    }
  },
  actions: {},
  modules: {},
  strict: true
});
