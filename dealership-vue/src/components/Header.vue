  <template>
    <header>
      <img src="../assets/bmw/logo-bmw.png" alt="BMW" />
      <nav>
        <router-link to="/">Home</router-link>
        <router-link to="/modelos">Modelos</router-link>
        <router-link to="/compre-online">Compre Online</router-link>
        <a href="#">Configure o seu</a>
        <a href="#">Recall</a>
      </nav>
  </header>
</template>

<script setup lang="ts">
import { RouterLink } from 'vue-router'
</script>
