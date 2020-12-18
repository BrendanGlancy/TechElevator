<template>
  <div class="board">
    <h2>{{ title }}</h2>
    <div class="cards">
      <div
        class="card"
        v-for="card in cards"
        v-bind:key="card.id"
        v-on:click="viewCardDetails(card.id)"
      >
        <div class="header">
          <h3>{{ card.title }}</h3>
          <img :src="card.avatar" class="avatar" />
        </div>
        <div class="footer">
          <span class="date">{{ card.date }}</span>
          <span class="pill" :class="getTagClass(card.tag)">{{
            card.tag
          }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'board-column',
  props: ['title', 'cards', 'boardID'],
  methods: {
    viewCardDetails(cardID) {
      this.$router.push(`/board/${this.boardID}/card/${cardID}`);
    },
    getTagClass(tag) {
      let clazz = '';
      switch (tag) {
        case 'Feature Request':
          clazz = 'feature';
          break;
        case 'Design':
          clazz = 'design';
          break;
        case 'Q&A':
          clazz = 'qa';
          break;
      }
      return clazz;
    }
  }
};
</script>

<style scoped>
.board {
  background-color: #f7fafc;
  border-radius: 10px;
  padding: 0 20px 20px 20px;
}
.card {
  background: #fff;
  border-radius: 0.25rem;
  padding: 10px;
  border: 1px;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.1), 0 1px 2px 0 rgba(0, 0, 0, 0.06);
  margin-bottom: 10px;
  cursor: pointer;
}
.card:last-child {
  margin-bottom: 0px;
}
.card h3 {
  margin-top: 0px;
  font-size: 0.875rem;
}
.card .header {
  display: flex;
  justify-content: space-between;
}
.card .header img {
  border-radius: 9999px;
  width: 32px;
  align-self: flex-start;
}
.card .footer {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin: 20px 0 10px 0;
  font-size: 0.75rem;
}
.pill {
  padding: 8px;
  border-radius: 20px;
  font-size: 0.7rem;
}
.design {
  background-color: #faf5ff;
  color: #6b46c1;
}
.qa {
  background-color: #f0fff4;
  color: #2c7a7b;
}

.feature {
  background-color: #e6fffa;
  color: #2c7a7b;
}
</style>
