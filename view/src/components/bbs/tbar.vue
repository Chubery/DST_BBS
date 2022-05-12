<template>
    <div class="out">
        <div class="t">
            <div class="flex_basic">
                <p style="color: white">{{ servername }}</p>
                <a href="https://space.bilibili.com/356497384" target="_blank" class="top_link">bilibili</a>
                <a href="javascript:;" @click="$router.push('/')" class="top_link">官网</a>
            </div>
            <div>
                <div v-show='!isLogin'>
                    <el-button type="success" plain round @click="gotoLogin">登录</el-button>
                    <el-button type="primary" plain round @click="gotoRegister">注册</el-button>
                </div>
                <div v-show="isLogin">
                    <el-dropdown>
                        <span class="el-dropdown-link">
                            <el-avatar :size="20" :src="circleUrl"></el-avatar>
                            {{username}}
                            <el-icon class="el-icon--right">
                                <i-arrow-down />
                            </el-icon>
                        </span>
                        <template #dropdown>
                            <el-dropdown-menu>
                                <el-dropdown-item><User style="width: 1em; height: 1em;margin-right: 8px" />个人主页</el-dropdown-item>
                                <el-dropdown-item><Setting style="width: 1em; height: 1em; margin-right: 8px;" />设置</el-dropdown-item>
                                <el-dropdown-item @click="logout" divided><Watermelon style="width: 1em; height: 1em; margin-right: 8px;" />登出</el-dropdown-item>
                            </el-dropdown-menu>
                        </template>
                    </el-dropdown>
                </div>
            </div>
        </div>
    </div>

</template>

<script setup>
import {User, Setting, Watermelon} from "@element-plus/icons-vue";
</script>

<script>
import axios from "axios";

export default {
    inject: ['reload'],
    name: "tbar",
    data() {
        return {
            servername: 'DST_CoupleUnion',
            isLogin: false,
            username: 'Admin',
            circleUrl:
                'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
        }
    },
    methods: {
        checkLogin() {
            axios.get(this.$baseUrl+'/user/check')
                .then((res) => {
                    if (res.data.success) {
                        this.isLogin = true;
                        this.username = res.data.data.username;
                    }
                })
        },
        logout() {
            axios.get(this.$baseUrl+'/user/logout')
                .then(() => {
                    this.checkLogin();
                    this.reload();
                })
        },

        gotoLogin() {
            this.$router.push('/login');
        },

        gotoRegister() {
            this.$router.push('/register');
        }
    },
    created() {
        this.checkLogin();
    }
}
</script>

<style scoped>
.flex_basic {
    display: flex;
    flex-direction: row;

}
.flex_basic > a {
    margin-left: 20px;
}

.out {
    width: 100%;
}


.t {
    width: 1140px;
    height: 50px;
    margin: 0 auto;
    line-height: 50px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.top_link {
    text-decoration: none;
    color: white;
}
.top_link:hover {
    text-decoration: underline;
}
</style>