<template>
  <div>
    <h2>Cadastro de Personalização</h2>
    <form @submit.prevent="enviarCustomization">
      <input v-model="customColor" type="number" placeholder="ID da Cor" required />
      <input v-model="customWheel" type="number" placeholder="ID da Roda" required />
      <input v-model="customCoating" type="number" placeholder="ID do Revestimento" required />
      <button type="submit">Enviar</button>
    </form>

    <hr />

    <h3>Personalizações cadastradas:</h3>
    <ul>
      <li v-for="item in customizations" :key="item.customColor + '-' + item.customWheel">
        Cor: {{ item.customColor }} | Roda: {{ item.customWheel }} | Revestimento: {{ item.customCoating }}
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import axios from 'axios';

const customColor = ref(0);
const customWheel = ref(0);
const customCoating = ref(0);
const customizations = ref<any[]>([]);

const enviarCustomization = async () => {
  try {
    await axios.post('http://localhost:8080/customizations', {
      customColor: customColor.value,
      customWheel: customWheel.value,
      customCoating: customCoating.value
    });
    alert("Personalização enviada com sucesso!");
    buscarCustomizations();
  } catch (error) {
    console.error(error);
    alert("Erro ao enviar personalização.");
  }
};

const buscarCustomizations = async () => {
  try {
    const response = await axios.get('http://localhost:8080/customizations');
    customizations.value = response.data;
  } catch (error) {
    console.error("Erro ao buscar personalizações:", error);
  }
};

onMounted(() => buscarCustomizations());
</script>

  