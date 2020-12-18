<template>
  <div id="app">
    <nav>
      <router-link v-bind:to="{name: 'home'}">Home</router-link> |
      <router-link v-bind:to="{name: 'portfolio'}">Portfolio</router-link> |
      <router-link v-bind:to="{name: 'hobby'}">Hobby</router-link>
    </nav>
    <router-view></router-view>
  </div>
</template>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
li {
    width: fit-content;
    margin: 0 auto;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  text-decoration: none;
  color: #42b983;
}
</style>
