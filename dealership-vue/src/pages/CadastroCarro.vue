<template>
  <div>
    <h2>Cadastro de Carro</h2>
    <form @submit.prevent="enviarCarro">
      <input v-model="model" placeholder="Modelo" required />
      <input v-model="engine" placeholder="Motor" required />
      <input v-model="weight" placeholder="Peso" type="number" required />
      <input v-model="autonomyKm" placeholder="Autonomia" type="number" required />
      <label>
        Ativo: <input v-model="active" type="checkbox" />
      </label>
      <button type="submit">Enviar</button>
    </form>

    <hr />

    <h3>Carros cadastrados:</h3>
    <ul>
      <li v-for="carro in carros" :key="carro.model">
        {{ carro.model }} - {{ carro.engine }} - {{ carro.weight }}kg - {{ carro.autonomyKm }}km - Ativo: {{ carro.active ? 'Sim' : 'Não' }}
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import axios from 'axios';

const model = ref('');
const engine = ref('');
const weight = ref(0);
const autonomyKm = ref(0);
const active = ref(true);
const carros = ref<any[]>([]);

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
    buscarCarros();
  } catch (error) {
    alert("Erro ao enviar carro.");
    console.error(error);
  }
};

const buscarCarros = async () => {
  try {
    const response = await axios.get('http://localhost:8080/cars');
    carros.value = response.data;
  } catch (error) {
    console.error("Erro ao buscar carros:", error);
  }
};

onMounted(() => buscarCarros());
</script>
