<template>
  <div class="home">
    <h1>Topic Message Board</h1>
    <topic-list />
  </div>
</template>

<script>
import TopicList from '@/components/TopicList.vue';

export default {
  name: 'Home',
  components: {
    TopicList
  }
}
</script>
