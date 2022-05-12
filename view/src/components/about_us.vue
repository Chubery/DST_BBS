<template>
    <div ref="a" class="about_us">
        <div class="a">
            <div class="left">
                <div class="about_title">
                    <p style="font-size: 32px">关于我们</p>
                </div>
                <div class="about">
                    <p>
                        DST_CoupleUnion&nbsp;&nbsp;&nbsp;&nbsp;(简称DST)
                    </p>
                    <br/>
                    <p>
                        DST_CoupleUnion，创建于2020-04-07，服主：Magic_muggle、XYu_mi。原版生存服务器，服务器现成员数量150+，每一个玩家都会经过多次审核筛选才会进入服务器。服务器内分工明确，拥有相对完善的后勤系统。领域：生电，建筑等等。
                    </p>
                    <ul class="about_ul">

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
            <div class="img">
                <div>
                    <div class="img_anime">
                        <p class="img_anime_t">重生点</p>
                        <p class="img_anime_s">1234</p>
                    </div>
                    <img src="../assets/img_main/spawn.png" alt="">
                </div>
                <div>
                    <div class="img_anime">
                        <p class="img_anime_t">1234</p>
                        <p class="img_anime_s">1234</p>
                    </div>
                    <img src="../assets/img_main/ksrl.png" alt="">
                </div>
                <div>
                    <div class="img_anime">
                        <p class="img_anime_t">1234</p>
                        <p class="img_anime_s">1234</p>
                    </div>
                    <img src="../assets/img_main/zsjxz.png" alt="">
                </div>
                <div>
                    <div class="img_anime">
                        <p class="img_anime_t">1234</p>
                        <p class="img_anime_s">1234</p>
                    </div>
                    <img src="../assets/img_main/fmxz.png" alt="">
                </div>
            </div>
        </div>
        <div class="video_btn">
            <a href="https://www.bilibili.com/video/BV1mf4y1272x" target="_blank">
                <el-icon :size="70" color="#fff">
                    <i-caret-right />
                </el-icon>
            </a>
        </div>
        <div class="xcp">
            <p>观看宣传片</p>
        </div>
    </div>
    <div style="height: 161px"></div>
</template>

<script>
export default {
    name: "about_us"
}
</script>

<style scoped>
.about_us {
    width: 100%;
    height: 400px;
    padding: 200px 0;
    background: #f2f6fc;
}
.a {
    width: 1440px;
    margin: 0px auto;
    display: flex;
    justify-content: space-between;
}
.left {
    width: 640px;
    height: 360px;
    font-family: 'Hiragino Sans GB';
}
.about_title {
    padding-bottom: 15px;
    padding-left: 30px;
    border-bottom: #69c2c8 2px solid;
}
.about {
    padding: 20px 30px;
    font-size: 19px;
    line-height: 170%;
    color: #606266;
}
.about_ul {
    list-style: none;
    padding: 40px 0px 0px;
    margin-left: 30px;
}
.about_ul li span {
    margin-left: 15px;
    position: relative;
    top: -3px;
}

.img {
    width: 720px;
    display: flex;
    flex-wrap: wrap;

}
.img > div {
    width: 360px;
    height: 240px;
    overflow: hidden;
}
.img > div > img {
    width: 480px;
}


.img_anime {
    position: absolute;
    width: 360px;
    height: 240px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    transition: 0.6s cubic-bezier(0, 0, 0, 1);
    color: white;
}
.img_anime_t {
    width: 100%;
    font-size: 22px;
    text-align: center;
    opacity: 0;
    transform: translateY(-25px);
    transition: 0.3s cubic-bezier(0, 0, 0, 1);
}
.img_anime_s {
    text-align: center;
    transform: translateY(25px);
    opacity: 0;
    transition: 0.3s cubic-bezier(0, 0, 0, 1);
}
.img_anime:hover {
    background-color: rgba(105, 194, 200, 0.7);

}
.img_anime:hover > .img_anime_t {
    opacity: 1;
    transform: translateY(0px);
}
.img_anime:hover > .img_anime_s {
    opacity: 1;
    transform: translateY(0px);
}




.video_btn {
    width: 100px;
    height: 100px;
    margin: 70px auto 0px;
    background: #69c2c8;
    border-radius: 50px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.25);
    transition: 0.5s;
}
.video_btn:hover {
    background: #67c23a;
    transform: scale(1.1);
}
.video_btn a {
    position: relative;
    left: 15px;
    top: 15px;
}
.xcp {
    width: 100%;
    margin-top: 5px;
    display: flex;
    justify-content: center;
    color: #909399;
}


</style>