<template>
  <div class="home">
    <h1>Topic Message Board</h1> <!-- Component is referenced in kabob-case -->
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
