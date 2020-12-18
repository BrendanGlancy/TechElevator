<template>
  <div class="topic-details">
    <h1>{{ this.$store.state.activeTopic.title }}</h1>
    <router-link
      :to="{ name: 'AddMessage', params: {topicId: $store.state.activeTopic.id} }"
      class="addMessage"
    >Add New Message</router-link>
    <div
      v-for="message in this.$store.state.activeTopic.messages"
      v-bind:key="message.id"
      class="topic-message bubble"
    >
      <h3 class="message-title">{{ message.title }}</h3>
      <p class="message-body">{{ message.messageText }}</p>
      <router-link
        :to="{name: 'EditMessage', params: {topicId: $store.state.activeTopic.id, messageId: message.id} }"
        tag="button"
        class="btnEditMessage"
      >Edit</router-link>
      <button class="btnDeleteMessage" v-on:click="deleteMessage(message.id)">Delete</button>
    </div>
  </div>
</template>

<script>
import topicService from "@/services/TopicService.js";
import messageService from "@/services/MessageService.js";

export default {
  name: "topic-details",
  props: {
    topicId: Number
  },
  methods: {
    deleteMessage(id) {
      messageService.delete(id)
      this.$store.commit("DELETE_MESSAGE", id);
    }
  },
  created() {
    topicService
      .get(this.topicId)
      .then(response => {
        this.$store.commit("SET_ACTIVE_TOPIC", response.data);
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
/** page structure **/
.topic-details {
  padding: 20px 20px;
  margin: 0 auto;
  max-width: 600px;
}

/** ios1-ios6 bubbles **/
.topic-details .bubble {
  box-sizing: border-box;
  width: auto;
  position: relative;
  clear: both;

  background: #95c2fd;
  background-image: -webkit-gradient(
    linear,
    left bottom,
    left top,
    color-stop(0.15, #bee2ff),
    color-stop(1, #95c2fd)
  );
  background-image: -webkit-linear-gradient(bottom, #bee2ff 15%, #95c2fd 100%);
  background-image: -moz-linear-gradient(bottom, #bee2ff 15%, #95c2fd 100%);
  background-image: -ms-linear-gradient(bottom, #bee2ff 15%, #95c2fd 100%);
  background-image: -o-linear-gradient(bottom, #bee2ff 15%, #95c2fd 100%);
  background-image: linear-gradient(to top, #bee2ff 15%, #95c2fd 100%);
  filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#95c2fd', endColorstr='#bee2ff');

  border: solid 1px rgba(0, 0, 0, 0.5);
  -webkit-border-radius: 20px;
  -moz-border-radius: 20px;
  border-radius: 20px;

  -webkit-box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  -moz-box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  margin-bottom: 20px;
  padding: 6px 20px;
  color: #000;
  text-shadow: 0 1px 1px rgba(255, 255, 255, 0.8);
  word-wrap: break-word;
}

.addMessage {
  display: block;
  padding: 0 0 10px 10px;
}
a.addMessage:link,
a.addMessage:visited {
  color: blue;
  text-decoration: none;
}
a.addMessage:hover {
  text-decoration: underline;
}
</style>
