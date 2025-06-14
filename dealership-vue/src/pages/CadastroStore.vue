<template>
    <div>
      <h2>Cadastro de Loja</h2>
      <form @submit.prevent="enviarLoja">
        <div>
          <label>Logo (URL ou Nome):</label>
          <input v-model="logo" type="text" required />
        </div>
  
        <div>
          <label>Rua:</label>
          <input v-model="street" type="text" required />
        </div>
  
        <div>
          <label>Cidade:</label>
          <input v-model="city" type="text" required />
        </div>
  
        <div>
          <label>Número:</label>
          <input v-model="addressNumber" type="text" required />
        </div>
  
        <div>
          <label>Estado:</label>
          <input v-model="state" type="text" required />
        </div>
  
        <button type="submit">Enviar</button>
      </form>
  
      <hr />
  
      <h3>Lojas cadastradas:</h3>
      <ul>
        <li v-for="store in stores" :key="store.logo + store.addressNumber">
          {{ store.logo }} - {{ store.street }}, {{ store.addressNumber }} - {{ store.city }} / {{ store.state }}
        </li>
      </ul>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  const logo = ref('');
  const street = ref('');
  const city = ref('');
  const addressNumber = ref('');
  const state = ref('');
  const stores = ref<any[]>([]);
  
  const enviarLoja = async () => {
    try {
      await axios.post('http://localhost:8080/stores', {
        logo: logo.value,
        street: street.value,
        city: city.value,
        addressNumber: addressNumber.value,
        state: state.value
      });
      alert("Loja cadastrada com sucesso!");
      buscarLojas();
    } catch (error) {
      console.error(error);
      alert("Erro ao cadastrar loja.");
    }
  };
  
  const buscarLojas = async () => {
    try {
      const response = await axios.get('http://localhost:8080/stores');
      stores.value = response.data;
    } catch (error) {
      console.error("Erro ao buscar lojas:", error);
    }
  };
  
  onMounted(() => buscarLojas());
  </script>
  