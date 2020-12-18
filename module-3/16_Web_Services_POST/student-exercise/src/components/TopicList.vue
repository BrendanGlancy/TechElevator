<template>
  <div class="topic-list">
    <table>
      <thead>
        <tr>
          <th>Topic</th>
          <th>Edit</th>
          <th>Delete</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="topic in this.$store.state.topics" v-bind:key="topic.id">
          <td width="80%">
            <router-link
              v-bind:to="{ name: 'Messages', params: { id: topic.id } }"
            >{{ topic.title }}</router-link>
          </td>
          <td>
            <router-link :to="{ name: 'EditTopic', params: {id: topic.id} }">Edit</router-link>
          </td>
          <td>
            <a href="#" v-on:click="deleteTopic(topic.id)">Delete</a>
          </td>
        </tr>
      </tbody>
    </table>
  </div> 
</template>

<script>
import topicService from "@/services/TopicService.js";

export default {
  name: "topic-list",
  methods: {
    getTopics() {
      topicService.list().then(response => {
        this.$store.commit("SET_TOPICS", response.data);
      });
    },
    deleteTopic(id) {
      topicService.delete(id)
      topicService.list();
      this.getTopics();
    }
  },
  created() {
    this.getTopics();
  }
};
</script>

<style>
.topic-list {
  margin: 0 auto;
  max-width: 800px;
}
.topic {
  font-size: 24px;
  border-bottom: 1px solid #f2f2f2;
  padding: 10px 20px;
}
.topic:last-child {
  border: 0px;
}
table {
  text-align: left;
  width: 800px;
  border-collapse: collapse;
}
td {
  padding: 4px;
}
tbody tr:nth-child(even) {
  background-color: #f2f2f2;
}

.topic-list a:link,
.topic-list a:visited {
  color: blue;
  text-decoration: none;
}
.topic-list a:hover {
  text-decoration: underline;
}
</style>
