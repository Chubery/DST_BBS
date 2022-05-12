<template>
    <div>
        <div class="top">
            <div class="top_left">
                <p>DST_CoupleUnion</p>
                <a href="https://space.bilibili.com/356497384" target="_blank" class="top_link">bilibili</a>
                <a href="javascript:;" @click="$router.push('/')" class="top_link">官网</a>
            </div>
            <div>
                <a href="javascript:;" @click="$router.push('/bbs')" class="top_link">返回论坛</a>
            </div>
        </div>

        <div class="main">
            <div class="form_out">
                <div class="form_pic">
                    <div class="pic_font">
                        <p><span>DST</span><span>_CoupleUnion</span></p>
                        <p>红石 建筑 原版生存服务器</p>
                    </div>
                </div>
                <div class="form_div">
                    <login-form></login-form>
                </div>
            </div>

        </div>

        <div class="foot">

        </div>
    </div>
</template>

<script>
import login_form from "../components/login_form";
import register_form from "../components/register_form";

export default {
    inject: ['reload'],
    name: "login",
    components: {
        loginForm: login_form,
        registerForm: register_form,
    },
    data() {
        return {
            login: true,
        }
    },
    methods: {
    }

}
</script>

<style scoped>
.top {
    height: 50px;
    padding: 0 350px;
    background-color: #a0cfff;
    color: white;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    line-height: 50px;
}
.top_left {
    display: flex;
    flex-direction: row;
}
.top_left > a {
    margin-left: 25px;
}
.top_link {
    text-decoration: none;
    color: white;
}
.top_link:hover {
    text-decoration: underline;
}

.main {
    height: 670px;
    padding-top: 100px;
    background-color: #f4f4f5;
}
.form_out {
    width: 1240px;
    margin: 0 auto;
    background-color: white;
    box-shadow: 0 0px 20px 0 rgba(0, 0, 0, 0.25);
    display: flex;
    flex-direction: row;
    justify-content: center;
}
.form_pic {
    background: url("../assets/img_main/background.png") no-repeat center;
    width: 680px;
    height: 550px;
    overflow: hidden;
}
.pic_font {
    color: white;
    margin-top: 220px;
    margin-left: 115px;
}
.pic_font > p:nth-child(1) > span:nth-child(1) {
    font-size: 60px;
}
.pic_font > p:nth-child(1) > span:nth-child(2) {
    font-size: 26px;
}
.pic_font > p:nth-child(2) {
    font-size: 18px;
    margin-top: 10px;
}
.form_div {
    width: 500px;
    padding: 40px 60px;
}

.foot {
    height: 141px;
    background-color: #a0cfffff;
}
</style>