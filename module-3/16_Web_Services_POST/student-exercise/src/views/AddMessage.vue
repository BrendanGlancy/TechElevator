<template>
  <div>
    <h1>Add New Message</h1>
    <create-message v-bind:topicId="parseInt(this.$route.params.topicId)" />
  </div>
</template>

<script>
import CreateMessage from "@/components/CreateMessage";

export default {
  components: {
    CreateMessage
  }
};
</script>

<style>
</style>
