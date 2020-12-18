<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="title">Title</label>
      <input type="text" v-model="title" />
    </div>
    <div class="actions">
      <router-link to="/">
        <button type="submit" v-on:click="updateTopic()">Save Document</button>
      </router-link>
    </div>
  </form>
</template>

<script>
import topicService from "../services/TopicService";

export default {
  name: "create-topic",
  props: ["topicID"],
  data() {
    return {
      title: ""
    };
  },
  methods: {
    updateTopic() {
      const topic = { id: this.topicID, title: this.title };
      topicService.update(topic).then(response => {
        this.topic = response.data
      })
    }
  },
  created() {
    topicService
      .get(this.topicID)
      .then(response => {
        this.$store.commit("SET_ACTIVE_TOPIC", response.data);
        this.title = response.data.title;
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
