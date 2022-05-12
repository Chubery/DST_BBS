<template>
    <div class="title">
        <p>欢迎登录DCT玩家交流论坛</p>
    </div>

    <el-form ref="form" :model="form" :rules="rules" label-width="90px" label-position="left">

        <el-form-item label="用户名" prop="username">
            <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
        </el-form-item>

        <el-form-item label="密码" prop="password">
            <el-input v-model="form.password" placeholder="请输入密码" show-password></el-input>
        </el-form-item>

        <div class="captcha">
            <el-form-item label="验证码" prop="captcha">
                <el-input v-model="form.captcha" placeholder="请输入验证码"></el-input>
            </el-form-item>

            <div class="captcha">
                <el-image style="width: 100px; height: 40px;" :src="src"></el-image>

                <div style="margin-left: 20px; top: 3px">
                    <el-button circle size="small" @click="getImg">
                        <el-icon>
                            <Refresh />
                        </el-icon>
                    </el-button>
                </div>
            </div>

        </div>

        <el-alert style="margin-bottom: 22px;" v-show="error" title="登录失败" type="error" :closable="false"  center show-icon> {{ errorMsg }} </el-alert>

        <div class="login_btn">
            <el-button type="success" plain @click="login('form')">登录</el-button>

            <div style="line-height: 40px;">
                <span>没有账号？</span><a href="javascript:;" @click="gotoRegister">前往注册</a>
            </div>
        </div>

    </el-form>

</template>

<script setup>
import { Refresh } from "@element-plus/icons-vue";

</script>

<script>

import axios from "axios";
import { ElMessage } from 'element-plus'

export default {
    name: "login_form",
    data() {
        return {
            src: '',
            error: false,
            errorMsg: '',
            form: {
                username: '',
                password: '',
                captcha: '',
            },
            rules: {
                username: [
                    {
                        required: true,
                        message: '用户名不能为空',
                        trigger: 'blur',
                    },
                ],
                password: [
                    {
                        required: true,
                        message: '密码不能为空',
                        trigger: 'blur',
                    },
                ],
                captcha: [
                    {
                        required: true,
                        message: '验证码不能为空',
                        trigger: 'blur',
                    },
                ],
            }
        }
    },
    methods: {
        getImg() {
            let _this = this;
            axios.get(this.$baseUrl+'/captcha', {
                responseType: 'arraybuffer',
                headers: {
                    'Authorization': localStorage.getItem('access_token') || ''
                }
            }).then(response => {
                return 'data:image/jpg;base64,' + btoa(
                    new Uint8Array(response.data)
                        .reduce((data, byte) => data + String.fromCharCode(byte), '' )
                );
            }).then(data => {
                this.src = data;
            })
        },

        login(formName) {
            this.$refs[formName].validate((valid) => {
                if(!valid) {
                    return false;
                } else {
                    axios.post(this.$baseUrl+'/user/login', {username: this.form.username, password: this.form.password, captcha: this.form.captcha})
                        .then((res) => {
                            if (res.data.success) {
                                this.$refs['form'].resetFields();
                                this.$message({
                                    message: '登录成功!',
                                    type: 'success'
                                })
                                setTimeout(() => {
                                    this.$router.push('/bbs');

                                }, 500);
                            } else {
                                this.error = true;
                                this.errorMsg = res.data.msg;
                                this.form.password = '';
                                this.form.captcha = '';
                                this.getImg();
                            }
                        })

                }
            })
        },

        gotoRegister() {
            this.$router.push('/register');
        },

    },
    created() {
        this.getImg();
    }
}
</script>

<style scoped>
.title {
    margin-bottom: 30px;
    text-align: center;
    font-size: 18px;
}

.captcha {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
.login_btn {
    padding: 0 30px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
.login_btn > div > a {
    text-decoration: none;
    color: #409eff;
}
.login_btn > div > a:hover {
    text-decoration: underline;
}
</style>