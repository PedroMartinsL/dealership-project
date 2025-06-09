import { createApp } from 'vue'
<<<<<<< Updated upstream
=======
import App from './App.vue'
import router from './router' 

>>>>>>> Stashed changes
import './style.css'
import App from './App.vue'

<<<<<<< Updated upstream
createApp(App).mount('#app')
=======
const app = createApp(App)

app.use(router) 
app.mount('#app')
>>>>>>> Stashed changes
