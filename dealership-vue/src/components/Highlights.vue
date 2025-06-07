<template>
    <section class="highlight-section">
      
    <!-- HighLight 2 -->
     
      <div
        class="highlight"
        :style="{ backgroundImage: `url(${mercedesBanner})` }"
      >
        <div class="highlight-content">
          <h2>Mercedes-Benz GLB.</h2>
          <p>Design moderno com 7 lugares. Pronta entrega.</p>
          <button>Saiba mais</button>
        </div>
      </div>

      <div class="highlight-separator"></div>
  
      <!-- HighLight 2 -->
      <div
        class="highlight"
        :style="{ backgroundImage: `url(${rollBanner})` }"
      >
        <div class="highlight-content">
          <h2>Rolls-Royce Phantom.</h2>
          <p>Exclusividade, luxo e potência à sua altura.</p>
          <button>Saiba mais</button>
        </div>
      </div>
    </section>
  </template>
  
  <script setup lang="ts">
  import mercedesBanner from '../assets/mercedes-banner.jpeg'
  import rollBanner from '../assets/roll-banner.jpg'
  </script>
  