<template>
  <div id="app">
    <user-list></user-list>
  </div>
</template>

<script>
import UserList from "./components/UserList.vue";

export default {
  name: "app",
  components: {
    UserList
  }
};
</script>
