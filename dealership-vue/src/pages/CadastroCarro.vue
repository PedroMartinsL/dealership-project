<template>
    <div>
      <h2>Cadastro de Carro</h2>
      <form @submit.prevent="enviarCarro">
        <div>
          <label>Modelo:</label>
          <input v-model="model" type="text" placeholder="Ex: Civic" required />
        </div>
  
        <div>
          <label>Motor:</label>
          <input v-model="engine" type="text" placeholder="Ex: 1.8 Flex" required />
        </div>
  
        <div>
          <label>Peso (kg):</label>
          <input v-model="weight" type="number" placeholder="Ex: 1200" required />
        </div>
  
        <div>
          <label>Autonomia (km):</label>
          <input v-model="autonomyKm" type="number" placeholder="Ex: 450" required />
        </div>
  
        <div>
          <label>Ativo:</label>
          <input v-model="active" type="checkbox" />
        </div>
  
        <button type="submit">Enviar</button>
      </form>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref } from 'vue';
  import axios from 'axios';
  
  const model = ref('');
  const engine = ref('');
  const weight = ref(0);
  const autonomyKm = ref(0);
  const active = ref(true);
  
  const enviarCarro = async () => {
    try {
      await axios.post('http://localhost:8080/cars', {
        model: model.value,
        engine: engine.value,
        weight: weight.value,
        autonomyKm: autonomyKm.value,
        active: active.value
      });
      alert("Carro enviado com sucesso!");
    } catch (error) {
      console.error(error);
      alert("Erro ao enviar carro.");
    }
  };
  </script>
  