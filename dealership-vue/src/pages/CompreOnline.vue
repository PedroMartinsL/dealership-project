<template>
    <div class="form-page">
      <h1>Escolha o Veículo de interesse</h1>
  
      <form @submit.prevent="handleSubmit">
        <label for="car">Modelo:</label>
        <select id="car" v-model="form.carro" required>
          <option disabled value="">Selecione um modelo *</option>
          <option v-for="modelo in modelos" :key="modelo" :value="modelo">{{ modelo }}</option>
        </select>
  
        <div class="row">
          <input type="text" placeholder="Nome *" v-model="form.nome" required />
          <input type="text" placeholder="Sobrenome *" v-model="form.sobrenome" required />
        </div>
  
        <input type="tel" placeholder="Telefone *" v-model="form.telefone" required />
        <input type="email" placeholder="E-mail *" v-model="form.email" required />
        <input type="text" placeholder="CPF" v-model="form.cpf" />
  
        <h2>Selecione a Concessionária* de Interesse:</h2>
        <div class="row">
          <select v-model="form.uf" required>
            <option disabled value="">(UF)</option>
            <option>SP</option>
            <option>RJ</option>
          </select>
          <select v-model="form.cidade" required>
            <option disabled value="">(Cidade)</option>
            <option>São Paulo</option>
            <option>Rio de Janeiro</option>
          </select>
        </div>
  
        <input type="text" placeholder="Nome da concessionária" v-model="form.concessionaria" />
  
        <h3>Política de privacidade</h3>
        <p>
          O BMW Group Brasil se preocupa com a privacidade dos clientes...
          <br />
          <a href="#">Clique aqui para acessar a Política de Privacidade do BMW Group.</a>
        </p>
  
        <button type="submit">Enviar</button>
      </form>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref } from 'vue'
  
  const modelos = [
    '118i', '218i', '320i', '420i Cabrio', '530e', 'M2 Coupé', 'M4 CS',
    'X1 sDrive20i', 'X3 M40i', 'iX M60', 'i4 Gran Coupé'
  ]
  
  const form = ref({
    carro: '',
    nome: '',
    sobrenome: '',
    telefone: '',
    email: '',
    cpf: '',
    uf: '',
    cidade: '',
    concessionaria: ''
  })
  
  const handleSubmit = () => {
    console.log('Form enviado:', form.value)
    alert('Formulário enviado com sucesso!')
  }
  </script>
  
  <style scoped>
  .form-page {
    max-width: 700px;
    margin: auto;
    padding: 20px;
  }
  
  h1, h2, h3 {
    margin-bottom: 10px;
  }
  
  form {
    display: flex;
    flex-direction: column;
  }
  
  .row {
    display: flex;
    gap: 10px;
  }
  
  input, select, button {
    padding: 10px;
    margin-bottom: 15px;
    width: 100%;
  }
  
  button {
    background-color: #007bff;
    color: white;
    border: none;
    cursor: pointer;
  }
  </style>
  