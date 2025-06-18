<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router'; // IMPORTAR useRouter
import axios from 'axios';

const route = useRoute();
const router = useRouter(); // INICIALIZAR useRouter
const code = ref('');
const userData = ref(null);

onMounted(async () => {
  const receivedCode = route.query.code as string;

  if (receivedCode) {
    code.value = receivedCode;

    try {
      // Etapa 1 – Trocar o code por access_token
      const tokenResponse = await axios.post('/oauth2/token', new URLSearchParams({
        grant_type: 'authorization_code',
        code: receivedCode,
        redirect_uri: 'http://localhost:5173/authorized',
      }), {
        headers: {
          'Authorization': 'Basic ZGVhbGVyc2hpcC12dWU6dXBlLWFwcA==',
          'Content-Type': 'application/x-www-form-urlencoded',
        }
      });

      const tokenData = tokenResponse.data;

      const accessToken = tokenData.access_token;
      if (!accessToken) {
        console.error('Access token não retornado!');
        return;
      }

      localStorage.setItem('access_token', accessToken);

      // Etapa 2 – Buscar usuários com o token
      const userResponse = await axios.get('/users', {
        headers: {
          Authorization: `Bearer ${accessToken}`
        }
      });

      userData.value = userResponse.data;

      // Redirecionar corretamente
      router.push('/');

    } catch (err) {
      console.error('Erro durante o fluxo de autorização:', err);
    }
  }
});
</script>



  //Colocar o acesso Token no Storage para toda a apliccao conseguir pegar ele. 
 