<template>
    <div ref="a" class="join">
        <p class="title">加入我们</p>
        <div class="line"></div>

        <div class="join_main">
            <div style="border-right: 2px solid #EBEEF5">
                <p class="join_title">加入外服</p>
                <br>
                <p class="join_title2">欢迎加入DST外服</p>
                <br>
                <p class="join_title3">请前往论坛进行申请</p>
                <br>
                <ul class="join_ul">

                    <li>
                        <el-icon :size="20" color="#67c23a">
                            <i-check />
                        </el-icon>
                        <span>服务器24小时运行</span>
                    </li>
                    <li>
                        <el-icon :size="20" color="#67c23a">
                            <i-check />
                        </el-icon>
                        <span>低卡顿</span>
                    </li>
                    <li>
                        <el-icon :size="20" color="#67c23a">
                            <i-check />
                        </el-icon>
                        <span>服内成员150+</span>
                    </li>
                </ul>
            </div>
            <div>
                <p class="join_title">加入内服</p>
                <br>
                <p class="join_title2">欢迎加入DST外服</p>
                <br>
                <p class="join_title3">请前往论坛进行申请</p>
                <br>
                <ul class="join_ul">

                    <li>
                        <el-icon :size="20" color="#67c23a">
                            <i-check />
                        </el-icon>
                        <span>服务器24小时运行</span>
                    </li>
                    <li>
                        <el-icon :size="20" color="#67c23a">
                            <i-check />
                        </el-icon>
                        <span>低卡顿</span>
                    </li>
                    <li>
                        <el-icon :size="20" color="#67c23a">
                            <i-check />
                        </el-icon>
                        <span>服内成员150+</span>
                    </li>
                </ul>
            </div>
        </div>

        <div class="goto">
            <router-link to="bbs">前往论坛</router-link>
        </div>

        <div class="footer">
            <div class="a1">
                <p>© 2021 DST_CoupleUnion All Rights Reserved.</p>
            </div>

        </div>



    </div>
</template>

<script>
export default {
    name: "join_us"
}
</script>

<style scoped>
.join {
    width: 100%;
    height: 861px;
    padding-top: 100px;
}
.title {
    text-align: center;
    font-size: 40px;
}
.line {
    width: 1140px;
    margin: 20px auto;
    border-bottom: #EBEEF5 3px solid;
}
.join_main {
    width: 1140px;
    margin: 50px auto 0;
    display: flex;
}
.join_main div {
    width: 50%;
    padding: 20px 80px;
}
.join_title {
    /*text-align: center;*/
    font-size: 30px;
    color: #69c2c8;
}
.join_title2 {
    font-size: 20px;
    color: #606266;
    /*text-align: center;*/
}
.join_title3 {
    color: #f56c6c;
}



.join_ul {
    list-style: none;
    padding: 0;
}
.join_ul li span {
    margin-left: 15px;
    position: relative;
    top: -3px;
}

.goto {
    width: 140px;
    height: 50px;
    margin: 20px auto 40px;
    border: #69c2c8 2px solid;
    text-align: center;
    line-height: 50px;
    color: #69c2c8;
    font-size: 17px;
    border-radius: 20px;
    transition: 0.5s;
}
.goto:hover {
    background-color: #69c2c8;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.goto:hover > a {
    color: white;
}
.goto > a {
    color: #69c2c8;
    text-decoration: none;
    display: block;
}

.footer {
    background-color: #f2f6fc;
    height: 360px;
}
.a1 {
    width: 1140px;
    margin: 0 auto;
    padding-top: 120px;
    color: #909399;

}
</style>