<template>
    <div class="about-container">
      <div class="about-image">
        <img :src="imagePath" alt="Foto" />
      </div>
  
      <div class="about-content">
        <h2>{{ title }} <span></span></h2>
        <h3>{{ subtitle }}</h3>
        <p>{{ description }}</p>
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  const props = defineProps<{
    image: string
    title: string
    subtitle: string
    description: string
  }>()
  
  const imagePath = new URL(props.image, import.meta.url).href
  </script>
  
  <style scoped>
  .about-container {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    flex-wrap: wrap;
    gap: 2rem;
    max-width: 1000px;
    margin: 0 auto;
  }
  
  .about-image img {
    width: 250px;
    border: 5px solid #00ffff;
    border-radius: 16px;
    object-fit: cover;
  }
  
  .about-content {
    max-width: 500px;
    text-align: left;
  }
  
  .about-content h2 {
    font-size: 2rem;
    margin-bottom: 0.5rem;
  }
  
  .about-content span {
    color: #00ffff;
  }
  
  .about-content h3 {
    font-size: 1.3rem;
    margin-bottom: 1rem;
    font-weight: bold;
  }
  
  .about-content p {
    font-size: 1rem;
    margin-bottom: 1.5rem;
    line-height: 1.6;
  }
  
  .about-content button {
    padding: 0.6rem 2rem;
    background: #00ffff;
    color: black;
    border: none;
    border-radius: 30px;
    font-weight: bold;
    font-size: 0.9rem;
    cursor: pointer;
    transition: 0.3s;
  }
  
  .about-content button:hover {
    background: #00cccc;
  }
  </style>
  