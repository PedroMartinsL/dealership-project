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

      <button type="submit">{{ storeId ? 'Atualizar' : 'Cadastrar' }}</button>
    </form>

    <hr />

    <h3>Lojas cadastradas:</h3>

    <ul>
      <li v-for="store in stores" :key="store.id">
        {{ store.logo }} - {{ store.street }}, {{ store.addressNumber }} - {{ store.city }} / {{ store.state }}
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, type Ref } from 'vue'
import axios from 'axios'

interface Store {
  id: number
  logo: string
  street: string
  city: string
  addressNumber: string
  state: string
}

const logo = ref('')
const street = ref('')
const city = ref('')
const addressNumber = ref('')
const state = ref('')
const storeId = ref<number | null>(null)

const stores: Ref<Store[]> = ref([])

const getToken = () => localStorage.getItem('access_token')

const enviarLoja = async () => {
  try {
    const data = {
      logo: logo.value,
      street: street.value,
      city: city.value,
      addressNumber: addressNumber.value,
      state: state.value
    }

    const url = storeId.value ? `/stores/${storeId.value}` : '/stores'
    const method = storeId.value ? 'put' : 'post'

    await axios[method](url, data, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    })

    alert(storeId.value ? "Loja atualizada com sucesso!" : "Loja cadastrada com sucesso!")
    limparCampos()
    buscarLojas()
  } catch (error) {
    console.error("Erro ao salvar loja:", error)
    alert("Erro ao salvar loja.")
  }
}

const buscarLojas = async () => {
  try {
    const response = await axios.get('/stores', {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    })
    stores.value = response.data.stores


  } catch (error) {
    console.error("Erro ao buscar lojas:", error)
  }
}

const editarLoja = (store: Store) => {
  storeId.value = store.id
  logo.value = store.logo
  street.value = store.street
  city.value = store.city
  addressNumber.value = store.addressNumber
  state.value = store.state
}

const limparCampos = () => {
  logo.value = ''
  street.value = ''
  city.value = ''
  addressNumber.value = ''
  state.value = ''
  storeId.value = null
}

onMounted(() => buscarLojas())
</script>
