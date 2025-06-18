<template>
  <div>
    <h2>Cadastro de Motor</h2>
    <form @submit.prevent="enviarEngine">

      <div>
  <label>Tipo do Motor:</label>
  <select v-model="type" required>
    <option disabled value="">Selecione</option>
    
    <option value="ELECTRIC">Elétrico</option>
    <option value="INTERNAL_COMBUSTION">Combustão Interna</option>
    <option value="HYBRID">Híbrido</option>
  </select>
</div>

     
      <div>
        <label>Potência (hp):</label>
        <input v-model="horsepower" type="number" placeholder="Ex: 450" required />
      </div>



      <button type="submit">Enviar</button>
    </form>

    <hr />

    <h3>Motores cadastrados:</h3>
    <ul>
      <li v-for="engine in engines" :key="engine.id || (engine.type + '-' + engine.horsepower)">
        Tipo: {{ engine.engineType}} |
        Potência: {{ engine.horsepower }} hp |
        Ativado?: {{ engine.active }} 
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios from 'axios'

const type = ref('')
const horsepower = ref(0)
const engines = ref<any[]>([])

const getToken = () => localStorage.getItem('access_token')

const enviarEngine = async () => {
  try {
    await axios.post('/engines', {
      engineType: type.value,
      horsepower: horsepower.value,
      active: true
    }, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    })
    alert("Motor enviado com sucesso!")
    buscarEngines()
  } catch (error) {
    console.error("Erro ao enviar motor:", error)
    alert("Erro ao enviar motor.")
  }
}

const buscarEngines = async () => {
  try {
    const response = await axios.get('/engines', {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    })
    engines.value = response.data
  } catch (error) {
    console.error("Erro ao buscar motores:", error)
  }
}

onMounted(() => buscarEngines())
</script>
