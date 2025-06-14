<template>
    <div>
      <h2>Cadastro de Usuário</h2>
      <form @submit.prevent="enviarUsuario">
        <div>
          <label>Nome:</label>
          <input v-model="name" type="text" required />
        </div>
  
        <div>
          <label>Email:</label>
          <input v-model="email" type="email" required />
        </div>
  
        <div>
          <label>Senha:</label>
          <input v-model="password" type="password" required />
        </div>
  
        <div>
          <label>Roles (separadas por vírgula):</label>
          <input v-model="rolesTexto" type="text" placeholder="admin,user" required />
        </div>
  
        <button type="submit">Enviar</button>
      </form>
  
      <hr />
  
      <h3>Usuários cadastrados:</h3>
      <ul>
        <li v-for="user in users" :key="user.email">
          Nome: {{ user.name }} | Email: {{ user.email }} | Roles: {{ user.roles?.join(', ') }}
        </li>
      </ul>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  const name = ref('');
  const email = ref('');
  const password = ref('');
  const rolesTexto = ref('');
  const users = ref<any[]>([]);
  
  const enviarUsuario = async () => {
    try {
      await axios.post('http://localhost:8080/users', {
        name: name.value,
        email: email.value,
        password: password.value,
        roles: rolesTexto.value.split(',').map(role => role.trim())
      });
      alert("Usuário cadastrado com sucesso!");
      buscarUsuarios();
    } catch (error) {
      console.error(error);
      alert("Erro ao cadastrar usuário.");
    }
  };
  
  const buscarUsuarios = async () => {
    try {
      const response = await axios.get('http://localhost:8080/users');
      users.value = response.data;
    } catch (error) {
      console.error("Erro ao buscar usuários:", error);
    }
  };
  
  onMounted(() => buscarUsuarios());
  </script>
  