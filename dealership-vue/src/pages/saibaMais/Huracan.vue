<template>
  <section class="banner">
    <img src="@/assets/lambo/lambo1.webp" alt="Lamborghini Huracan" class="banner-img" />
    <div class="banner-text">
      <h1>Lamborghini Huracan</h1>
      <p>Design moderno com 7 lugares, perfeito para toda a família.</p>
    </div>
  </section>

  <section class="features">
    <div class="feature-box">
      <img src="@/assets/lambo/lamboInterior1.webp" alt="Interior" />
      <div class="feature-caption">Amplo espaço interno com tecnologia embarcada de ponta</div>
    </div>

    <div class="feature-box">
      <img src="@/assets/lambo/lamboMotor1.jpg" alt="Motor" />
      <div class="feature-caption">Potência e eficiência em cada detalhe</div>
    </div>
  </section>
</template>

<script setup lang="ts"></script>

<style scoped>
.banner {
  position: relative;
}
.banner-img {
  width: 100%;
  height: auto;
}
.banner-text {
  position: absolute;
  bottom: 0;
  background: rgba(0, 0, 0, 0.7);
  width: 100%;
  padding: 1rem;
  color: white;
  text-align: center;
}

.features {
  display: flex;
  justify-content: center;
  gap: 2rem;
  padding: 2rem;
  flex-wrap: wrap;
  background-color: #111;
}

.feature-box {
  max-width: 400px;
  text-align: center;
}

.feature-box img {
  width: 100%;
  border-radius: 8px;
}

.feature-caption {
  color: white;
  margin-top: 0.5rem;
}
</style>
