<template>
    <div class="main">
        <div ref="background" class="background">
            <topbar></topbar>
            <div class="title">
                <div class="text_box">
                    <div class="text">
                        <p>
                            <span style="font-size: 96px">DST</span><span style="font-size: 44px"> _ CoupleUnion</span>
                        </p>
                        <p style="font-size: 24px">
                            红石 建筑 原版生存服务器
                        </p>

                    </div>
                </div>
            </div>
        </div>
        <about ref="about"></about>
        <advantage ref="advantage"></advantage>
        <join ref="join"></join>
    </div>

    <el-backtop></el-backtop>

</template>

<script>
import topbar from "../components/topbar";
import about_us from "../components/about_us";
import TopBar from "../components/topbar";
import advantage from "../components/advantage";
import join_us from "../components/join_us";

export default {
    name: "main",
    components: {
        TopBar,
        topbar: topbar,
        about: about_us,
        advantage: advantage,
        join: join_us
    },
    data() {
        return {

        }
    },
    methods: {
        to1() {
            this.$refs.background.scrollIntoView({
                behavior: "smooth",
                block: "start"
            });
        },
        to2() {
            this.$refs.about.$refs.a.scrollIntoView({
                behavior: "smooth",
                block: "start"
            });
        },
        to3() {
            this.$refs.advantage.$refs.a.scrollIntoView({
                behavior: "smooth",
                block: "start"
            });
        },
        to4() {
            this.$refs.join.$refs.a.scrollIntoView({
                behavior: "smooth",
                block: "start"
            });
        }
    }
}
</script>

<style scoped>
.main {
    height: 3844px;
}
.background {
    width: 100%;
    height: 961px;
    background: url("../assets/img_main/background.png") fixed;
}
.title {
    width: 1140px;
    height: 100%;
    position: relative;
    top: -50px;
    margin: 0px auto;
    padding-top: 50px;
    z-index: 1;
}
.text_box {
    width: 50%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;

}
.text {
    padding-bottom: 120px;
    color: white;
}

</style>