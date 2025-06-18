<template>
  <div>
    <h2>Cadastro de Usuário</h2>
    <form @submit.prevent="enviarUsuario">
      <input v-model="name" type="text" placeholder="Nome" required />
      <input v-model="email" type="email" placeholder="Email" required />
      <input v-model="password" type="password" placeholder="Senha" required />
      <button type="submit">{{ userId ? 'Atualizar' : 'Cadastrar' }}</button>
    </form>

    <hr />

    <h3>Usuários cadastrados:</h3>
    <ul>
      <li v-for="user in users" :key="user.id">
        {{ user.props.name }} | {{ user.props.email }} | {{ user.roles?.join(', ') || 'CLIENT' }}
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios from 'axios'

const getToken = () => localStorage.getItem('access_token')

const name = ref('')
const email = ref('')
const password = ref('')
const userId = ref<number | null>(null)
const users = ref<any[]>([])

const enviarUsuario = async () => {
  try {
    const data = { name: name.value, email: email.value, password: password.value, roles: ["CLIENT"] }
    const url = userId.value ? `/users/${userId.value}` : '/users'
    const method = userId.value ? 'put' : 'post'



    await axios[method](url, data, {
      headers: { Authorization: `Bearer ${getToken()}` }
    })

    alert(userId.value ? 'Usuário atualizado!' : 'Usuário cadastrado!')
    limparCampos()
    buscarUsuarios()
  } catch (error) {
    alert('Erro ao salvar usuário.')
  }
}

const buscarUsuarios = async () => {
  const response = await axios.get('/users', {
    headers: { Authorization: `Bearer ${getToken()}` }
  })
  users.value = response.data
}

const editarUsuario = (user: any) => {
  userId.value = user.id
  name.value = user.name
  email.value = user.email
  password.value = ""
}

const limparCampos = () => {
  name.value = ''
  email.value = ''
  password.value = ''
  userId.value = null
}

onMounted(() => buscarUsuarios())
</script>
