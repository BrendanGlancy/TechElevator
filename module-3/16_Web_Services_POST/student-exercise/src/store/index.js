import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    topics: [],
    activeTopic: {
      id: 0,
      title: '',
      messages: []
    },
    activeMessage: {
      id: null,
      topicId: null,
      title: '',
      messageText: ''
    }
  },
  mutations: {
    SET_TOPICS(state, data) {
      state.topics = data;
    },
    SET_ACTIVE_TOPIC(state, data) {
      state.activeTopic = data;
    },
    DELETE_MESSAGE(state, id) {
      state.activeTopic.messages.splice(
        state.activeTopic.messages.findIndex(message => message.id === id),
        1
      )
    },
    SET_ACTIVE_MESSAGE(state, data) {
      state.activeMessage = data;
    },
  },
  actions: {
  },
  modules: {
  }
})
