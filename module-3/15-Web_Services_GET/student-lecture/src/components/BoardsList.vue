<template>
  <div>
    <h1>My Kanban Boards</h1>
    <div class="boards">
      <div class="loading" v-if="isLoading">
        <img src="../assets/squirrel.gif" />
      </div>
      <div
        class="board"
        v-for="board in boards"
        v-bind:key="board.id"
        v-bind:style="{ 'background-color': board.backgroundColor }"
        v-else
      >
        <router-link v-bind:to="{ name: 'Board', params: { id: board.id } }">
          {{ board.title }}
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import boardsService from '../services/BoardService';

export default {
  data() {
    return {
      boards: [],
      isLoading: true
    };
  },

  // the API call is don and creates a promise which is returned to the caller
  // A promise is an object that will automatically update when the API call is complete
  // .then - waits for the promise to be updated as completed
  // When the promise is fulfilled, the response data is returned

  created() {
    boardsService.getBoards().then(response => { // call the boardsService getBoards() function
      // and wiat for it to complete
      this.boards = response.data; // when the API call completes, assign the data 
      this.isLoading = false;
    });
  }
};
</script>

<style scoped>
.boards {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.board {
  background-color: #f7fafc;
  border-radius: 10px;
  padding: 40px;
  flex: 1;
  margin: 0 20px;
  text-align: center;
}
.loading {
  flex: 3;
}
.board a:link,
.board a:visited {
  color: rgb(243, 243, 243);
  text-decoration: none;
}
</style>
