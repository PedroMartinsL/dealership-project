import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/cars': 'http://localhost:8080/',
      '/users': 'http://localhost:8080/',
      '/customizations': 'http://localhost:8080/',
      '/engines': 'http://localhost:8080/',
      '/orders': 'http://localhost:8080/',
      '/stores': 'http://localhost:8080/',
      '/oauth2/token': 'http://localhost:8080/',
    },
  },
  resolve: {
    alias: {
      '@': path.resolve(__dirname, './src')
    }
  }
})

