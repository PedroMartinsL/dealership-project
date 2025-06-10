<template>
  <header class="site-header">
    <div class="container">
      <img src="@/assets/bmw/logo-bmw.png" alt="BMW" class="logo" />
      <nav>
        <router-link to="/">Home</router-link>
        <router-link to="/modelos">Modelos</router-link>
        <router-link to="/compre-online">Compre Online</router-link>
        <a href="#">Configure o seu</a>
        <a href="#">Recall</a>
      </nav>
    </div>
  </header>
</template>

<script setup lang="ts">
import { RouterLink } from 'vue-router'
</script>

<style scoped>
.site-header {
  background-color: black;
  padding: 1rem 0;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.logo {
  height: 40px;
}

nav {
  display: flex;
  gap: 1rem;
}

nav a {
  color: white;
  text-decoration: none;
  font-size: 0.9rem;
  font-weight: bold;
}

nav a:hover {
  text-decoration: underline;
}
</style>
