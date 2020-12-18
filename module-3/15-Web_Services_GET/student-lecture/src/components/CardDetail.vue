<template>
  <div>
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>
    <router-link v-bind:to="{ name: 'Board', params: {id: $route.params.boardID }}" >
       Back to Board
    </router-link>  
  </div>
</template>

<script>
import theBoardServices from '../services/BoardService'
export default {
  name: "card-detail",
  data() { // Contains data used in the page
    return {
      card: { // Hold the data for the card being displayed                       
        title: '',                                                                
        description: '',                                                          
        status: '',                                                               
        comments: []                                                         
      }
    }
  },
  created() { // we need to be sure we have the data before the page is displayed
    // Call the getCard service with the board id and card id we want
    theBoardServices.getCard(this.$route.params.boardID, this.$route.params.cardID)
      .then(apiData => {
        this.card = apiData;
    })
  }
};
</script>
