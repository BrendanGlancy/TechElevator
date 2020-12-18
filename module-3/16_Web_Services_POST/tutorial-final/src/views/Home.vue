<template>
  <div class="home">
    <h1>My Documents</h1>
    <router-link :to="{ name: 'CreateDocument' }"
      >Create New Document</router-link
    >
    <document-list />
  </div>
</template>

<script>
import DocumentList from '@/components/DocumentList';

export default {
  components: {
    DocumentList
  }
};
</script>

<style>
.home a {
  float: right;
}
.home a:link,
.home a:visited {
  padding: 20px 20px 20px 0;
  text-align: right;
  color: blue;
  text-decoration: none;
}
.home a:hover {
  text-decoration: underline;
}
</style>
