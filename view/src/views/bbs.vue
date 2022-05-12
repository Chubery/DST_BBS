<template>
    <div style=" background-color: rgb(236, 245, 255); min-height: 961px">
        <div style="width: 100%; position: fixed; background-color: #79bbff; z-index: 999;">
            <tbar></tbar>
        </div>
        <div class="banner">
            <div class="b_title">
                <p>欢迎来到DST社区交流论坛</p>
                <p>在这里你可以交流游戏心得或者在这里发布你的申请</p>
            </div>
        </div>
        <div style="width: 1140px; margin: 20px auto 0;">
            <el-container>


                <el-aside width="200px">
                    <div>
                        <button class="s_btn" v-if="isLogin" @click="drawer = true;resetForm('subForm')">发布主题</button>
                        <button class="s_btn" v-if="!isLogin" disabled="disabled">登录后发帖</button>
                    </div>
                    <div>
                        <a href="javascript:;" @click="getAllSubject">全部主题</a>
                    </div>
                    <div>
                        <p>分类</p>
                        <div v-for="tab in tabs">
                            <a href="javascript:;" @click="selectSubject(tab.l_id)">{{tab.l_name}}</a>
                        </div>
                    </div>

                </el-aside>


                <el-main>

                    <div v-for="subject in subject">
                        <a href="" class="subject">
                            <div class="subject_user">
                                <el-avatar :size="60" :src="circleUrl"></el-avatar>
                                <p>{{subject.username}}</p>
                            </div>
                            <div class="subject_main">
                                <div class="subject_title">
                                    <div>
                                        <h3 style="color: black;">{{subject.s_title}}</h3>
                                        <div class="subject_tag">
                                            <el-tag size="mini" type="primary" effect="dark">{{subject.l_name}}</el-tag>
                                            <p style="color: #c0c4cc;">{{subject.last_reply_username}}回复于{{subject.last_reply_time}}</p>
                                        </div>
                                    </div>
                                    <div>
                                        <el-icon :size="20" color="#409eff">
                                            <ChatDotRound />
                                        </el-icon>
                                        <span style="color: black">{{subject.reply_count}}</span>
                                    </div>
                                </div>
                                <div class="">
                                    <p class="detail">{{subject.s_detail}}</p>
                                </div>
                            </div>
                        </a>
                    </div>



                </el-main>

            </el-container>
        </div>
    </div>

    <div>
        <el-drawer v-model="drawer" title="编辑您想发布的主题" :direction="direction" :before-close="handleClose" size="40%" :append-to-body="true">
            <div style="width: 90%; margin: 0 auto">

                <el-form ref="subForm" :model="subForm" :rules="rules" label-width="150px" label-position="left">

                    <el-form-item label="主题标题" prop="s_title">
                        <el-input v-model="subForm.s_title"></el-input>
                    </el-form-item>

                    <el-form-item label="主题标签" prop="l_id">
                        <el-radio-group v-model="subForm.l_id" size="small">
                            <el-radio-button v-for="tab in tabs" :label="tab.l_id">{{tab.l_name}}</el-radio-button>
                        </el-radio-group>
                    </el-form-item>

                    <el-form-item label="主题内容" prop="s_detail">
                        <el-input v-model="subForm.s_detail" type="textarea" :rows="3"></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="addSubject">Create</el-button>
                    </el-form-item>

                </el-form>
            </div>
        </el-drawer>
    </div>

</template>

<script>
import axios from "axios";
import tbar from "../components/bbs/tbar";
import { ChatDotRound } from "@element-plus/icons-vue";
import {defineComponent, ref} from 'vue'
import { ElMessageBox } from 'element-plus'

export default {
    inject: ['reload'],
    name: "bbs",
    components: {
        tbar: tbar,
        ChatDotRound,
    },
    data() {
        return {
            isLogin: false,
            circleUrl:
                'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
            tabs: [],
            subject: [
                {
                    's_id': 1,
                    'uid': 1,
                    'username': 'admin',
                    'l_id': 1,
                    'l_name': '闲聊茶馆',
                    's_title': '这是一条测试标题',
                    's_detail' : '这是一条测试内容aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
                    'reply_count' : 0,
                    'create_time': '2021-12-22',
                    'last_reply_time': '2021-12-22',
                    'last_reply_username': 'admin'
                }
            ],
            subForm: {
                s_title: '',
                l_id: '',
                s_detail: '',
            },
            rules: {
                s_title: [
                    {
                        required: true,
                        message: '主题标题不能为空',
                        trigger: 'blur',
                    },
                ],
                l_id: [
                    {
                        required: true,
                        message: '必须选择一个主题标签',
                        trigger: 'blur',
                    },
                ],
                s_detail: [
                    {
                        required: true,
                        message: '主题内容不能为空',
                        trigger: 'blur',
                    },
                ],
            },
        }
    },
    watch: {
        drawer(nd, od) {
            if (!nd) {
                this.resetForm('subForm');
            }
        }
    },
    methods: {
        getLabel() {
            axios.get(this.$baseUrl+'/label/all')
                .then((res) => {
                    this.tabs =  res.data.data;
                })
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
            this.subForm.s_detail = '';
            this.subForm.l_id = '';
            this.subForm.s_title = '';
        },
        checkLogin() {
            axios.get(this.$baseUrl+'/user/check')
                .then((res) => {
                    if (res.data.success) {
                        this.isLogin = true;
                    } else {
                        this.isLogin = false;
                    }
                })
        },
        addSubject() {
            axios.post(this.$baseUrl+'/subject/add', {s_title: this.subForm.s_title, l_id: this.subForm.l_id, s_detail: this.subForm.s_detail})
                .then((res) => {
                    if (res.data.success) {
                        this.resetForm('subForm');
                        this.$message({
                            message: '发布成功!',
                            type: 'success'
                        })
                        setTimeout(() => {
                            this.drawer = false;
                            this.reload();
                        }, 500);
                    } else {

                    }
                })
        },
        getAllSubject() {
            axios.get(this.$baseUrl+'/subject/all')
                .then((res) => {
                    this.subject = res.data.data;
                })
        },
        selectSubject(l_id) {
            axios.post(this.$baseUrl + '/subject/select/' + l_id)
                .then((res) => {
                    this.subject = res.data.data;
                })
        }


    },
    created() {
        this.getLabel();
        this.checkLogin();
        this.getAllSubject();
    },
    setup() {
        const drawer = ref(false)
        const direction = ref('rtl')
        const handleClose = (done) => {
            ElMessageBox.confirm('是否退出编辑主题？（退出后将不会保存已编辑内容）')
                .then(() => {
                    done();
                })
                .catch(() => {
                    // catch error
                })
        }
        return {
            drawer,
            direction,
            handleClose,
        }
    },
}



</script>

<style scoped>
.banner {
    height: 205px;
    background: url("../assets/img_main/ge.jpg") fixed;
}
.b_title {
    width: 400px;
    height: 100px;
    position: relative;
    top: 75px;
    left: 390px;
}
.b_title>p:nth-child(1) {
    font-size: 28px;
    margin-bottom: 10px;
}

.s_btn {
    width: 180px;
    height: 40px;
    background-color: white;
    color: #409eff;
    border: #409eff 1px solid;
    border-radius: 10px;
    transition: 0.5s;
}
.s_btn:hover {
    background-color: #409eff;
    color: white;
}

.subject {
    display: flex;
    flex-direction: row;
    justify-content: space-around;

    height: 135px;
    padding: 20px;
    margin-left: 30px;
    margin-bottom: 20px;

    text-decoration: none;
    background-color: rgba(255, 255, 255, 0.4);
    border: #e9e9eb 1px solid;
    border-radius: 20px;


    transition: 200ms;
}
.subject:hover {
    background-color: white;
}
.subject_user {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    width: 18%;
}
.subject_user > p {
    color: black;
    font-size: 18px;
}

.subject_main {
    width: 75%;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
}
.subject_title {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}

.subject_tag {
    margin-top: 8px;
    display: flex;
    flex-direction: row;
}
.subject_tag > p {
    margin-left: 80px;
}

.detail {
    overflow: hidden;
    display: -webkit-box;
    word-wrap: break-word;
    word-break: break-all;
    overflow: hidden;
    -webkit-line-clamp: 3;
    -webkit-box-orient: vertical;

    color: #909399;
}

</style>