<template>
  <div>
    <h2>{{ document.name }}</h2>
    <p>
      <strong>Author:</strong>
      {{ document.author }} |
      <strong>Last Opened by Me:</strong>
      {{ document.lastOpened }}
    </p>
    <textarea v-model="document.content" spellcheck="false" />
    <div class="back">
      <router-link :to="{ name: 'Home' }">Return to Documents List</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "document-detail",
  data() {
    return {
      document: {
        id: null,
        name: "",
        author: "",
        lastOpened: null,
        content: ""
      }
    };
  }
};
</script>

<style scoped>
textarea {
  width: 500px;
  height: 500px;
}
.back {
  margin-top: 20px;
}

a:link,
a:visited {
  color: blue;
  text-decoration: none;
}
a:hover {
  text-decoration: underline;
}
</style>
