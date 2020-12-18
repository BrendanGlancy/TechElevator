<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="title">Title</label>
      <input type="text" v-model="topic.title" />
    </div>
    <div class="actions">
      <router-link to="/">
        <button type="submit" v-on:click="saveTopic()">Save Document</button>
      </router-link>
    </div>
  </form>
</template>

<script>
import topicService from "../services/TopicService";

export default {
  name: "create-topic",
  data() {
    return {
      topic: {
        id: Math.floor(Math.random() * (1000 - 100) + 100),
        title: ""
      }
    };
  },
  methods: {
    saveTopic() {
      topicService.add(this.topic).then(response => {
        this.topic = response.data
      })
    }
  }
};
</script>

<style>
form {
  padding: 20px;
  font-size: 16px;
}
form * {
  box-sizing: border-box;
  line-height: 1.5;
}
.field {
  display: flex;
  flex-direction: column;
}
.field label {
  margin: 4px 0;
  font-weight: bold;
}
.field input,
.field textarea {
  padding: 8px;
  font-size: 18px;
}
.field textarea {
  height: 300px;
}
.actions {
  text-align: right;
  padding: 10px 0;
}
</style>
