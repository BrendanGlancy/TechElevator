<template>
  <div>
    <div class="header">
      <h1>{{ title }}</h1>
      <router-link
        tag="button"
        class="btn addNewCard"
        :to="{ name: 'AddCard', params: {boardID: this.boardId} }"
        v-if="!isLoading"
      >Add New Card</router-link>
      <button
        class="btn btn-cancel deleteBoard"
        v-if="!isLoading"
        v-on:click="deleteBoard"
      >Delete Board</button>
    </div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <div v-else>
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      <div class="boards">
        <board-column title="Planned" :cards="planned" :boardID="this.boardId" />
        <board-column title="In Progress" :cards="inProgress" :boardID="this.boardId" />
        <board-column title="Completed" :cards="completed" :boardID="this.boardId" />
      </div>
    </div>
    <div class="board-actions" v-if="!isLoading">
      <router-link to="/">Back to Boards</router-link>
    </div>
  </div>
</template>

<script>
import boardsService from "../services/BoardService";
import BoardColumn from "@/components/BoardColumn";

export default {
  name: "cards-list",
  components: {
    BoardColumn
  },
  data() {
    return {
      title: "",
      boardId: 0,
      isLoading: true,
      errorMsg: ""
    };
  },
  methods: {
    retrieveCards() {
      boardsService
        .getCards(this.boardId)
        .then(response => {
          this.title = response.data.title;
          this.$store.commit("SET_BOARD_CARDS", response.data.cards);
          this.isLoading = false;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Board cards not available. This board may have been deleted or you have entered an invalid board ID."
            );
            this.$router.push("/");
          }
        });
    },
    deleteBoard() {
      
    }
  },
  created() {
    this.boardId = this.$route.params.id;
    this.retrieveCards();
  },
  computed: {
    planned() {
      return this.$store.state.boardCards.filter(
        card => card.status === "Planned"
      );
    },
    inProgress() {
      return this.$store.state.boardCards.filter(
        card => card.status === "In Progress"
      );
    },
    completed() {
      return this.$store.state.boardCards.filter(
        card => card.status === "Completed"
      );
    }
  }
};
</script>

<style>
.boards {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 20px;
}
.board-actions {
  text-align: center;
  padding: 20px 0;
}
.board-actions a:link,
.board-actions a:visited {
  color: blue;
  text-decoration: none;
}
.board-actions a:hover {
  text-decoration: underline;
}
.btn.addNewCard {
  color: #fff;
  background-color: #508ca8;
  border-color: #508ca8;
}
.header {
  display: flex;
  align-items: center;
}
.header h1 {
  flex-grow: 1;
}
</style>
