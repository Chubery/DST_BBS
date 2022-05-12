<template>
    <div ref="a" class="advantage">
        <p class="title">我们的优势</p>
        <div class="line"></div>
        <p class="f_title">红石，建筑，生存</p>
        <div class="adv">
            <div class="adv_box">
                <div class="icon">
                    <el-icon :size="50" color="#67c23a">
                        <i-opportunity />
                    </el-icon>
                </div>
                <p class="t1">
                    有自主设计能力
                </p>
                <p class="t2">
                    服务器内玩家有着多项设计
                </p>
            </div>
            <div class="adv_box">
                <div class="icon">
                    <el-icon :size="50" color="#67c23a">
                        <i-sunny />
                    </el-icon>
                </div>
                <p class="t1">
                    温馨氛围感
                </p>
                <p class="t2">
                    玩家之间一直都很和睦
                </p>

            </div>
            <div class="adv_box">
                <div class="icon">
                    <el-icon :size="50" color="#67c23a">
                        <i-chat-dot-round />
                    </el-icon>
                </div>
                <p class="t1">
                    消息受理
                </p>
                <p class="t2">
                    7*24小时全天接受反馈信息。
                </p>

            </div>
            <div class="adv_box">
                <div class="icon">
                    <el-icon :size="50" color="#67c23a">
                        <i-cpu />
                    </el-icon>
                </div>
                <p class="t1">
                    高性能服务器
                </p>
                <p class="t2">
                    处理器为 i9 10900k 主频可达5.1Ghz
                </p>

            </div>
            <div class="adv_box">
                <div class="icon">
                    <el-icon :size="50" color="#67c23a">
                        <i-avatar />
                    </el-icon>
                </div>
                <p class="t1">
                    专业的管理团队
                </p>
                <p class="t2">
                    我们的专业运维团队时刻准备着处理服务器的问题


                </p>

            </div>
            <div class="adv_box">
                <div class="icon">
                    <el-icon :size="50" color="#67c23a">
                        <i-help />
                    </el-icon>
                </div>
                <p class="t1">
                    适应全种类玩家
                </p>
                <p class="t2">
                    适合各种技术水平玩家的不同类型服务器
                </p>

            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "advantage"
}
</script>

<style scoped>
.advantage {
    /*background-color: #67c23a;*/

    height: 861px;
    padding-top: 100px;
}
.title {
    text-align: center;
    font-size: 36px;
}
.line {
    width: 1140px;
    margin: 20px auto;
    border-bottom: #EBEEF5 3px solid;
}
.f_title {
    text-align: center;
    font-size: 20px;
    color: #909399;
}
.adv {
    width: 1140px;
    margin: 30px auto;
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;

}
.adv_box {
    width: 365px;
    height: 300px;
    margin: 10px 5px;
    border-radius: 4px;
    background-color: white;
    text-align: center;


    transition: 0.5s;

}
.adv_box:hover {
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);

}
.icon {
    width: 100%;
    text-align: center;
    margin: 50px 0;
}
.t1 {
    color: #69c2c8;
    font-size: 20px;
    margin-bottom: 30px;
}
.t2 {
    color: #909399;
    font-size: 16px;
}


</style>