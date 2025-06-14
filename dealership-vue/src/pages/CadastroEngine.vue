<template>
    <div>
      <h2>Cadastro de Motor</h2>
      <form @submit.prevent="enviarEngine">
        <div>
          <label>Tipo:</label>
          <input v-model="type" type="text" placeholder="Ex: V8 Turbo" required />
        </div>
  
        <div>
          <label>Potência (hp):</label>
          <input v-model="horsepower" type="number" placeholder="Ex: 450" required />
        </div>
  
        <div>
          <label>Velocidade Máxima (km/h):</label>
          <input v-model="maxSpeed" type="number" placeholder="Ex: 320" required />
        </div>
  
        <button type="submit">Enviar</button>
      </form>
  
      <hr />
  
      <h3>Motores cadastrados:</h3>
      <ul>
        <li v-for="engine in engines" :key="engine.type + '-' + engine.horsepower">
          Tipo: {{ engine.type }} |
          Potência: {{ engine.horsepower }} hp |
          Máx: {{ engine.maxSpeed }} km/h
        </li>
      </ul>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  const type = ref('');
  const horsepower = ref(0);
  const maxSpeed = ref(0);
  const engines = ref<any[]>([]);
  
  const enviarEngine = async () => {
    try {
      await axios.post('http://localhost:8080/engines', {
        type: type.value,
        horsepower: horsepower.value,
        maxSpeed: maxSpeed.value
      });
      alert("Motor enviado com sucesso!");
      buscarEngines();
    } catch (error) {
      console.error(error);
      alert("Erro ao enviar motor.");
    }
  };
  
  const buscarEngines = async () => {
    try {
      const response = await axios.get('http://localhost:8080/engines');
      engines.value = response.data;
    } catch (error) {
      console.error("Erro ao buscar motores:", error);
    }
  };
  
  onMounted(() => buscarEngines());
  </script>
  