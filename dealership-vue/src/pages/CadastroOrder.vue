<template>
  <div>
    <h2>Cadastro de Pedido</h2>
    <form @submit.prevent="enviarPedido">
      <div>
        <label>ID do Carro:</label>
        <input v-model="carId" type="number" required />
      </div>

      <div>
        <label>ID do Usuário:</label>
        <input v-model="userId" type="number" required />
      </div>

      <div>
        <label>ID da Personalização:</label>
        <input v-model="customizationId" type="number" required />
      </div>

      <div>
        <label>ID da Loja:</label>
        <input v-model="storeId" type="number" required />
      </div>

      <div>
        <label>Data do Pedido:</label>
        <input v-model="orderInstant" type="datetime-local" required />
      </div>

      <button type="submit">Enviar</button>
    </form>

    <hr />

    <h3>Pedidos cadastrados:</h3>
    <ul>
      <li v-for="order in orders" :key="order.id || order.orderInstant">
        Carro ID: {{ order.car?.id }} |
        Usuário ID: {{ order.user?.id }} |
        Personalização ID: {{ order.customization?.id }} |
        Loja ID: {{ order.store?.id }} |
        Data: {{ order.orderInstant }}
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios from 'axios'

const carId = ref(0)
const userId = ref(0)
const customizationId = ref(0)
const storeId = ref(0)
const orderInstant = ref('')
const orders = ref<any[]>([])

const getToken = () => localStorage.getItem('access_token')

const enviarPedido = async () => {
  try {
    await axios.post('/orders', {
      car: { id: carId.value },
      user: { id: userId.value },
      customization: { id: customizationId.value },
      store: { id: storeId.value },
      orderInstant: orderInstant.value
    }, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    })

    alert("Pedido enviado com sucesso!")
    buscarPedidos()
  } catch (error) {
    console.error("Erro ao enviar pedido:", error)
    alert("Erro ao enviar pedido.")
  }
}

const buscarPedidos = async () => {
  try {
    const response = await axios.get('/orders', {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    })
    orders.value = response.data
  } catch (error) {
    console.error("Erro ao buscar pedidos:", error)
  }
}

onMounted(() => buscarPedidos())
</script>
