<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="title">Title</label>
      <input name="title" type="text" v-model="title" />
    </div>
    <div class="field">
      <label for="messageText">Message</label>
      <input name="messageText" type="text" v-model="messageText" />
    </div>
    <div class="actions">
      <button type="submit" v-on:click="updateMessage()">Update Message</button>
    </div>
  </form>
</template>

<script>
import messageService from "../services/MessageService";

export default {
  name: "create-message",
  props: ["topicId", "messageId"],
  data() {
    return {
      title: "",
      messageText: ""
    };
  },
  methods: {
    updateMessage() {
      const message = {
        id: this.messageId,
        topicId: this.topicId,
        title: this.title,
        messageText: this.messageText
      };
      // call update in message service
      messageService.update(message);
      this.$router.push(`/${message.topicId}`);
    }
  },
  created() {
    messageService
      .get(this.messageId)
      .then(response => {
        this.$store.commit("SET_ACTIVE_MESSAGE", response.data);
        this.title = response.data.title;
        this.messageText = response.data.messageText;
      })
      .catch(error => {
        if (error.response.status == 404) {
          this.$router.push("/not-found");
        }
      });
  }
};
</script>

<style>
</style>
