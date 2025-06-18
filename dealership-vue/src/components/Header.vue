<template>
  <header class="site-header">
    <div class="container">
      <div class="logo-nome">
        <img src="../assets/bmw/logo-bmw.png" alt="BMW" class="logo" />
        <span class="titulo">Dealership</span>
      </div>      

      <nav class="nav-links">
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/modelos">Modelos</RouterLink>
        <RouterLink to="/about">About</RouterLink>
        <a :href="authAccess">Login</a>

        <button class="hamburger" @click="menuAberto = !menuAberto">
          ☰
        </button>
      </nav>
    </div>

    <div class="hamburger-menu" v-if="menuAberto">
      <RouterLink to="/cadastro-carro">Carro</RouterLink>
      <RouterLink to="/cadastro-customization">Personalização</RouterLink>
      <RouterLink to="/cadastro-engine">Motor</RouterLink>
      <RouterLink to="/cadastro-order">Pedido</RouterLink>
      <RouterLink to="/cadastro-store">Loja</RouterLink>
      <RouterLink to="/cadastro-user">Usuário</RouterLink>
    </div>
  </header>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { RouterLink } from 'vue-router'

const authAccess = 'http://localhost:8080/oauth2/authorize' +
  '?response_type=code' +
  '&client_id=dealership-vue' +
  '&redirect_uri=http://localhost:5173/authorized';

const menuAberto = ref(false);

</script>
<style scoped>
.site-header {
  background-color: black;
  color: white;
  padding: 1rem 0;
  position: relative;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo-nome {
  display: flex;
  align-items: center;
}

.logo {
  height: 40px;
  margin-right: 10px;
}

.titulo {
  font-size: 1.2rem;
  font-weight: bold;
}

.nav-links {
  display: flex;
  align-items: center;
  gap: 1rem;
}

nav a,
.hamburger-menu a {
  color: white;
  text-decoration: none;
  font-size: 0.9rem;
  font-weight: bold;
}

nav a:hover,
.hamburger-menu a:hover {
  text-decoration: underline;
}

.hamburger {
  background: none;
  border: none;
  color: white;
  font-size: 1.5rem;
  cursor: pointer;
}

.hamburger-menu {
  background-color: #222;
  display: flex;
  flex-direction: column;
  position: absolute;
  top: 70px;
  right: 10px;
  padding: 1rem;
  border-radius: 8px;
  border: 1px solid #333;
  z-index: 999;
}

.hamburger-menu a {
  margin: 0.5rem 0;
}
</style>
