<template>
    <section class="highlight-section">
      
    <!-- HighLight 1 -->

      <div
        class="highlight"
        :style="{ backgroundImage: `url(${mercedesBanner})` }"
      >
        <div class="highlight-content">
          <h2>Mercedes-Benz GLB.</h2>
          <p>Design moderno com 7 lugares. Pronta entrega.</p>
          <router-link to="/saibamais/glb">
            <button>Saiba mais</button>
        </router-link>

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
          <router-link to="/saibamais/phantom">
            <button>Saiba mais</button>
          </router-link>
        </div>
      </div>
    </section>
  </template>
  
  <script setup lang="ts">
  import mercedesBanner from '../assets/mercedes/mercedes-banner.jpeg'
  import rollBanner from '../assets/rolls/roll-banner.jpg'
  </script>
  