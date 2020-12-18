<template>
  <div class="comments">
    <h2>Comments</h2>
    <div class="comment" v-for="comment in comments" v-bind:key="comment.id">
      <h3>{{ comment.author }}</h3>
      <p class="postedOn">{{ comment.postedOn }}</p>
      <p>{{ comment.body }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'comments-list',
  props: ['comments']
};
</script>

<style scoped>
.comments {
  background-color: #f7fafc;
  border-radius: 10px;
  padding: 10px 20px 20px 20px;
}
.comments h2 {
  margin: 0 0 30px 0;
}
.comment {
  margin: 20px 0;
  border-bottom: 1px solid rgb(180, 180, 180);
}
.comment:last-child {
  border-bottom: none;
}
.comment h3 {
  margin-bottom: 0;
}
.postedOn {
  margin-top: 4px;
  font-size: 0.75rem;
}
</style>
