<template>
  <div>
    <h1>Edit Message</h1>
    <update-message
      v-bind:topicId="parseInt($route.params.topicId)"
      v-bind:messageId="parseInt($route.params.messageId)"
    />
  </div>
</template>

<script>
import UpdateMessage from "@/components/UpdateMessage";

export default {
  components: {
    UpdateMessage
  }
};
</script>

<style>
</style>
