import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import installElementPlus from './plugins/element'
import * as ElIconModules from "@element-plus/icons";
import {transElIconName} from "./utils/utils";
import $ from 'jquery';
import axios from 'axios';

const app = createApp(App)
for (let iconName in ElIconModules) {
    app.component(transElIconName(iconName), ElIconModules[iconName])
};
installElementPlus(app);

axios.defaults.withCredentials = true;

app.config.globalProperties.$baseUrl='http://localhost:8080';
app.use(store).use(router).mount('#app');