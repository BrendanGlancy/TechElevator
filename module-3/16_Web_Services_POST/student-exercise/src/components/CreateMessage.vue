<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="title">Title</label>
      <input type="text" name="title" v-model="message.title" />
    </div>
    <div class="field">
      <label for="messageText">Message</label>
      <input type="text" name="messageText" v-model="message.messageText" />
    </div>
    <div class="actions">
      <router-link to="/${message.topicId}">
        <button type="submit" v-on:click="saveMessage()">Save Message</button>
      </router-link> 
    </div>
  </form>
</template>

<script>
import messageService from "../services/MessageService";

export default {
  name: "create-message",
  props: ["topicId"],
  data() {
    return {
      message: {
        id: Math.floor(Math.random() * (1000 - 100) + 100),
        topicId: this.topicId,
        title: "",
        messageText: ""
      }
    };
  },
  methods: {
    saveMessage() {
      messageService.add(this.message).then(response => {
        this.message = response.data
      })
    }
  }
};
</script>

<style>
</style>
