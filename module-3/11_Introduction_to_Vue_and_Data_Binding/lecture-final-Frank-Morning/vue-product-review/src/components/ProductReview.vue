<template>  <!-- HTML for the component -->

    <div id='main'> 
        <h2>Product Reviews for {{ title }}</h2>      <!-- use a mustache expression {{ variable }} to hold a place data in our html -->
        <p class='description'>{{words}} </p> <!-- use a mustache expression {{ variable }} to hold a place data in our html -->
    </div>
</template>

<script>    // JavaScript for the component
export default {  // data to be shared with Vue
    name: 'product-review',  // component name in kabob-case (- between the words)
    data() {      // data() function is provided for Vue to vall when it needs data for the component
        return {  // we return an JavaScript object with the data we want to share with Vue
            title: 'Cigar Parties for Dummies',
            words: 'Host and plan the perfect cigar party for all your squirrelly friends'
        }
    }    
}
</script>
<style scoped>  /* CSS for the component scoped indicates teh styling should be limited this component only */
                /* Becuase this component may be used with other components with similiar structure         */
                /* and/or class and id names, we domn't want to impact styling on those pages               */
                /* nor do WE want to impact styling on componets used with us                               */
div.main {
  margin: 1rem 0;
}

div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review.favorited {
  background-color: lightyellow;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}
</style>