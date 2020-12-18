import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    books: [
      {
        title: "Kafka by the Shore",
        author: "Haruki Murakami",
        read: false,
        isbn: "9781400079278"
      },
      {
        title: "The Girl With All the Gifts",
        author: "M.R. Carey",
        read: true,
        isbn: "9780356500157"
      },
      {
        title: "The Old Man and the Sea",
        author: "Ernest Hemingway",
        read: true,
        isbn: "9780684830490"
      },
      {
        title: "Le Petit Prince",
        author: "Antoine de Saint-Exupéry",
        read: false,
        isbn: "9783125971400"
      }
    ],
    popularBooks: [
      {
        title: "The Testaments",
        author: "Margaret Atwood",
        bestSeller: true,
        newRelease: true,
        isbn: "9780385543781"
      },
      {
        title: "Normal People",
        author: "Sally Rooney",
        bestSeller: false,
        newRelease: true,
        isbn: "9781984822178"
      },
      {
        title: "Where the Forest Meets the Stars",
        author: "Glendy Vanderah",
        bestSeller: false,
        newRelease: true,
        isbn: "9781542040068"
      },
      {
        title: "Talking to Strangers",
        author: "Malcolm Gladwell",
        bestSeller: true,
        newRelease: false,
        isbn: "9780316478526"
      },
      {
        title: "Embrace Your Weird",
        author: "Felicia Day",
        bestSeller: true,
        newRelease: false,
        isbn: "9781982113223"
      },
      {
        title: "Recursion",
        author: "Blake Crouch",
        bestSeller: false,
        newRelease: true,
        isbn: "9781524759780"
      },
      {
        title: "This Is How You Lose the Time War",
        author: "Amal El-Mohtar",
        bestSeller: false,
        newRelease: true,
        isbn: "9781534431003"
      },
      {
        title: "Flatland",
        author: "Edwin A. Abbott",
        bestSeller: true,
        newRelease: false,
        isbn: "048627263X"
      },
      {
        title: "Things Fall Apart",
        author: "Chinua Achebe",
        bestSeller: true,
        newRelease: false,
        isbn: "9780449208106"
      },
    ]
  },
  mutations: {
    SET_READ_STATUS(state, payload) {
      payload.book.read = payload.value;
    },
    SAVE_BOOK(state, book) {
      state.books.push(book);
    }
  },
  actions: {},
  modules: {},
  strict: true
});
