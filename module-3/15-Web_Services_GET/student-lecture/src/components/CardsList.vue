<template>
  <div>
    <h1>{{ title }}</h1>
    <div class="loading" v-if="isLoading">
      <!-- Use the BoardColumn.vue component passing it some values -->
      <!-- Passing it: the words for the title -->
      <!-- the word "planned" for the -->
      <!-- the value in the id parameter from the path -->
      <img src="../assets/squirrel.gif" />
    </div>
    <div class="boards" v-else>
      <board-column
        title="Planned"
        v-bind:cards="planned"
        v-bind:boardID="this.$route.params.id"
      />
      <board-column
        title="In Progress"
        v-bind:cards="inProgress"
        v-bind:boardID="this.$route.params.id"
      />
      <board-column
        title="Completed"
        v-bind:cards="completed"
        v-bind:boardID="this.$route.params.id"
      />
    </div>
    <div class="board-actions" v-if="!isLoading"> <!-- display this div if the page doesn't load-->
      <router-link to="/">Back to Boards</router-link>
    </div>
  </div>
</template>

<script>
import boardsService from '../services/BoardService';
import BoardColumn from '@/components/BoardColumn';

export default {
  name: 'cards-list',
  components: {
    BoardColumn
  },
  data() {
    return {
      title: '',
      cards: [],
      isLoading: true
    };
  },
  created() {
    boardsService.getCards(this.$route.params.id).then(response => {
      this.title = response.data.title;
      this.cards = response.data.cards;
      this.isLoading = false;
    });
  },
  computed: {
    planned() {
      return this.cards.filter(card => card.status === 'Planned');
    },
    inProgress() {
      return this.cards.filter(card => card.status === 'In Progress');
    },
    completed() {
      return this.cards.filter(card => card.status === 'Completed');
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
</style>
