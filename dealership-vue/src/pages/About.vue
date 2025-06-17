<template>
    <section class="about-section">
      <AboutCard
        image="../assets/pessoal/Gabriel Lopes.jpg"
        title="Gabriel Lopes"
        subtitle="Desenvolvedor da Aplicação Frontend"
        description="O 'Agiota' dos carros da concessionária! Ele é o cara que consegue qualquer coisa que você imaginar, sempre com um sorriso no rosto e uma oferta irrecusável! Se você estiver atrás de uma Brasília amarela ou de um Fusca zero quilômetro, é com ele — Esse cara tem a solução!"
      />
  
      <div class="divider"></div>
  
      <AboutCard
        image="../assets/pessoal/Pedro.jpg"
        title="Pedro Martins"
        subtitle="Desenvolvedor da Aplicação Back-end"
        description="O artista dos designs na concessionária. Pedro é mestre das pinturas, transformando qualquer carro em uma obra de arte! Se você quer personalizar, é com ele. Este homem tem uma quinzena de possibilidades!"
      />
  
      <div class="divider"></div>
  
      <AboutCard
        image="../assets/pessoal/Profe Augusto.jpg"
        title="Mestre Augusto Cesar"
        subtitle="Dono da concessionária"
        description="O imperador que trocou Roma pelo Brasil e se tornou uma lenda na concessionária e no mundo da programação! Comanda tudo com autoridade, visão e carisma, é o verdadeiro chefe dos paranauês."
      />
    </section>
  </template>
  
  <script setup lang="ts">
  import AboutCard from '../components/AboutCard.vue'
  </script>
  
  <style scoped>
  .about-section {
    background-color: #111;
    color: white;
    padding: 2rem;
  }
  
  .divider {
    width: 100%;
    height: 10px;
    background-color: #00ffff;
    margin: 3rem 0;
  }
  </style>
  