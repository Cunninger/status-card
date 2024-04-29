import { createApp } from 'vue'
import axios from 'axios'
import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(router)

app.config.globalProperties.$http = axios.create({
    baseURL: 'http://localhost:7788'
})

app.mount('#app')
