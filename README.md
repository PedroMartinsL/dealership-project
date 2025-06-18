# 🏎️ Projeto Concessionária (Dealership) – Website + API REST com Spring Boot

Este projeto simula o site institucional de uma concessionária de veículos de luxo, combinando uma interface moderna desenvolvida em **Vue 3 + TypeScript** com um back-end robusto em **Spring Boot**, totalmente integrado via API REST.

O objetivo é exibir modelos de veículos, permitir cadastro de interesse de usuários e gerenciar dados administrativos como carros, usuários, pedidos e personalizações.

---

## 📸 Demonstração

![image](https://github.com/user-attachments/assets/3085c4a8-65f4-41a9-b5f8-f057777e19b7)

---

## 🛠️ Tecnologias Utilizadas

### 🔹 Front-End
- [Vue 3](https://vuejs.org/)
- [TypeScript](https://www.typescriptlang.org/)
- [Vite](https://vitejs.dev/)
- [Vue Router](https://router.vuejs.org/)
- [Axios](https://axios-http.com/)
- CSS3 com escopos globais e locais (scoped)

### 🔹 Back-End
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [H2 Database](https://www.h2database.com/) ou PostgreSQL

---

## 🌐 Funcionalidades

### 🔹 Front-End (Vue 3 + TypeScript)
- Navegação entre páginas com Vue Router
- Páginas com destaque visual e responsividade
- Apresentação de modelos com imagens, descrições e botão de ação
- Formulário de interesse com campos obrigatórios e validação
- Consumo da API com Axios (GET/POST)
- Menu fixo e responsivo

### 🔹 Back-End (Spring Boot)
- Estrutura por camadas: Controller, Service, Repository
- Endpoints organizados por entidade (`/cars`, `/users`, `/orders`, etc.)
- Validação de campos obrigatórios
- Integração com o front-end via requisições HTTP

### 🔹 Banco de Dados
- Banco relacional (H2 ou PostgreSQL)
- Tabelas principais:
  - `Car`
  - `User`
  - `Customization`
  - `Order`
  - `Store`
  - `Engine`
- Relacionamentos entre entidades
- Operações CRUD testadas com Spring Data JPA

---

## 🔧 Casos de Uso Implementados

- ✅ Cadastrar um carro
- ✅ Cadastrar uma personalização
- ✅ Cadastrar um motor
- ✅ Cadastrar um pedido
- ✅ Cadastrar uma loja
- ✅ Cadastrar um usuário

---

## 📁 Estrutura do Projeto

```
dealership-project/
├── dealership-vue/           # Projeto Front-End
│   ├── public/
│   ├── src/
│   │   ├── assets/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── router/
│   │   ├── App.vue
│   │   ├── main.ts
│   │   └── style.css
│   ├── index.html
│   └── vite.config.ts
│
├── dealership-springboot/    # Projeto Back-End
│   ├── src/main/java/
│   │   └── com/dealership/
│   │       ├── controller/
│   │       ├── service/
│   │       ├── repository/
│   │       └── model/
│   ├── application.properties
│   └── pom.xml
```

---

## ⚙️ Como Rodar o Projeto

### 🔹 Front-End

```bash
cd dealership-vue
npm install
npm run dev
```

Abra `http://localhost:5173`

### 🔹 Back-End

```bash
cd dealership-springboot
./mvnw spring-boot:run
```

Acesse `http://localhost:8080` para visualizar a API REST.

---

## 🔗 Rotas do Front-End

| Caminho               | Componente Vue             |
|-----------------------|----------------------------|
| `/`                   | `Home.vue`                 |
| `/modelos`            | `Modelos.vue`              |
| `/compre-online`      | `CompreOnline.vue`         |
| `/saibamais/huracan`  | `Huracan.vue`              |
| `/saibamais/glb`      | `Glb.vue`                  |
| `/saibamais/phantom`  | `Phantom.vue`              |

---

## 👨‍💻 Desenvolvedor Backend

**Pedro Martins de Lemos**   

## 👨‍💻 Desenvolvedor Frontend

**Gabriel Lopes de Albuquerque**  

---

## 📄 Licença

Este projeto é de uso acadêmico e pessoal.  
Imagens utilizadas são meramente ilustrativas.
