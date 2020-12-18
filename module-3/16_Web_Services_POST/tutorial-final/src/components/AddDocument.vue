<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="name">Name</label>
      <input type="text" v-model="document.name" />
    </div>
    <div class="field">
      <label for="author">Author</label>
      <input type="text" v-model="document.author" />
    </div>
    <div class="field">
      <label for="content">Content</label>
      <textarea spellcheck="false" v-model="document.content" />
    </div>
    <div class="actions">
      <button type="button" v-on:click="cancel()">Cancel</button>&nbsp;
      <button type="submit" v-on:click="saveDocument()">Save Document</button>
    </div>
  </form>
</template>

<script>
import docsService from "../services/DocsService";
import moment from "moment";
import faker from "faker";

const date = moment(new Date());

export default {
  name: "add-document",
  data() {
    return {
      document: {
        id: Math.floor(Math.random() * (1000 - 100) + 100),
        name: "",
        author: "",
        avatar: faker.image.avatar(),
        content: "",
        lastOpened: date.format("MMMM Do YYYY")
      }
    };
  },
  methods: {
    saveDocument() {
      docsService
        .create(this.document)
        .then(response => {
          if (response.status === 201) {
            this.$router.push("/");
          }
        })
        .catch(error => {
          console.error(error);
        });
    },
    cancel() {
      this.$router.push("/");
    }
  }
};
</script>

<style scoped>
form {
  padding: 20px;
  font-size: 16px;
  width: 500px;
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
}
.field textarea {
  height: 300px;
}
.actions {
  text-align: right;
  padding: 10px 0;
}
</style>
