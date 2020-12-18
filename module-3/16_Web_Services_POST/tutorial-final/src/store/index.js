import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    docs: [],
    activeDocument: {
      id: null,
      name: '',
      author: '',
      lastOpened: null,
      content: ''
    }
  },
  mutations: {
    SET_DOCUMENTS(state, data) {
      state.docs = data;
    },
    SET_ACTIVE_DOCUMENT(state, data) {
      state.activeDocument = data;
    }
  },
  actions: {

  },
  modules: {
  },
  strict: true
})
