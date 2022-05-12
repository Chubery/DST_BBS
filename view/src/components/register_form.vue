<template>
    <div class="title">
        <p>欢迎注册DCT玩家交流论坛</p>
    </div>

    <el-form ref="form" :model="form" :rules="rules" label-width="90px" label-position="left">

        <el-form-item label="用户名" prop="username">
            <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
        </el-form-item>

        <el-form-item label="电子邮箱" prop="email">
            <el-input v-model="form.email" placeholder="请输入电子邮箱"></el-input>
        </el-form-item>

        <el-form-item label="密码" prop="password">
            <el-input v-model="form.password" placeholder="请输入密码" show-password></el-input>
        </el-form-item>

        <el-form-item label="确认密码" prop="cpassword">
            <el-input v-model="form.cpassword" placeholder="请再次输入密码" show-password></el-input>
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
            <el-button type="primary" plain @click="register('form')">注册</el-button>

            <div style="line-height: 40px;">
                <span>已有账号？</span><a href="javascript:;" @click="gotoLogin">前往登录</a>
            </div>
        </div>

    </el-form>
</template>

<script setup>
import { Refresh } from "@element-plus/icons-vue";

</script>

<script>
import axios from "axios";

export default {
    name: "register_form",
    data() {
        const checkUsername = (rule, value, callback) => {
            setTimeout(() => {
                axios.post(this.$baseUrl+'/user/checkname', {username: this.form.username, password: this.form.password, email: this.form.email, captcha: this.form.captcha})
                    .then((res) =>{
                        if (!res.data.success) {
                            callback(new Error(res.data.msg));
                        } else {
                            callback();
                        }
                    })
            }, 1000)
        }

        const checkEmail = (rule, value, callback) => {
            let t  = /^[A-Za-zd0-9]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/;
            if (!t.test(this.form.email)) {
                callback(new Error('电子邮箱格式不正确'));
            } else {
                callback();
            }
        }

        const checkPass = (rule, value, callback) => {
            if (value !== this.form.password) {
                callback(new Error('两次输入密码不一致'));
            } else {
                callback()
            }
        }

        return {
            src: '',
            error: false,
            errorMsg: '',
            form: {
                username: '',
                password: '',
                cpassword: '',
                email: '',
                captcha: '',
            },
            rules: {
                username: [
                    {
                        required: true,
                        message: '用户名不能为空',
                        trigger: 'blur',
                    },
                    {
                        min: 4,
                        max: 16,
                        message: '用户名长度应在4-16个字符之间',
                        trigger: 'blur',
                    },
                    {
                        validator: checkUsername,
                        trigger: 'blur'
                    }
                ],
                password: [
                    {
                        required: true,
                        message: '密码不能为空',
                        trigger: 'blur',
                    },
                    {
                        min: 6,
                        max: 16,
                        message: '密码长度应在6-16个字符之间',
                        trigger: 'blur',
                    },
                ],
                cpassword: [
                    {
                        required: true,
                        message: '确认密码不能为空',
                        trigger: 'blur',
                    },
                    {
                        validator: checkPass,
                        trigger: 'blur'
                    }
                ],
                email: [
                    {
                        required: true,
                        message: '电子邮箱不能为空',
                        trigger: 'blur'
                    },
                    {
                        validator: checkEmail,
                        trigger: 'blur'
                    }
                ]
                ,
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

        register(formName) {
            this.$refs[formName].validate((valid) => {
                if (!valid) {
                    return false;
                } else {
                    axios.post(this.$baseUrl+'/user/register', {username: this.form.username, password: this.form.password, email: this.form.email, captcha: this.form.captcha})
                        .then((res) => {
                            if (res.data.success) {
                                this.$refs['form'].resetFields();
                                this.$message({
                                    message: '注册成功',
                                    type: 'success'
                                })
                                setTimeout(() => {
                                    this.$router.push('/login');

                                }, 500);
                            } else {
                                this.error = true;
                                this.errorMsg = res.data.msg;
                                this.form.password = '';
                                this.form.cpassword = '';
                                this.form.captcha = '';
                            }
                        })
                }
            })
        }
        ,

        gotoLogin() {
            this.$router.push('/login');
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