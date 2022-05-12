<template>
    <div class="top_bar">
        <div class="out">
            <div class="left">
                <p>{{ servername }}</p>
            </div>
            <div class="right">
                <div :class="{'active': 1 === isActive}" @click="scrollTo(1)">
                    <a>主页</a>
                </div>
                <div :class="{'active': 2 === isActive}" @click="scrollTo(2)">
                    <a>关于服务器</a>
                </div>
                <div :class="{'active': 3 === isActive}" @click="scrollTo(3)">
                    <a>我们的优势</a>
                </div>
                <div :class="{'active': 4 === isActive}" @click="scrollTo(4)">
                    <a>加入我们</a>
                </div>
                <div class="to_bbs">
                    <router-link to="bbs">前往论坛</router-link>
                </div>

            </div>
        </div>
    </div>
</template>

<script>

export default {
    name: "topBar",
    data() {
        return {
            servername: 'DST_CoupleUnion',
            isActive: 1
        }
    },
    methods: {
        scrollTo(index) {
            this.isActive = index;

            if (index == 1) {
                this.$parent.to1()
            } else if (index == 2) {
                this.$parent.to2()
            } else if (index == 3) {
                this.$parent.to3()
            } else if (index == 4) {
                this.$parent.to4()
            }
        },

        findWhere() {
            let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;
            this.isActive = Math.floor(scrollTop/961) + 1;
        }
    },
    mounted() {
        let timeId;
        window.addEventListener(
            'scroll', ()=> {
                clearTimeout(timeId);
                timeId = setTimeout( ()=> {

                    this.findWhere()

                    // console.log('嘿嘿');
                }, 100);
            }
        )
    }
}
</script>

<style scoped>
.top_bar {
    width: 100%;
    height: 50px;
    background: rgba(255, 255, 255, 0.85);
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    position: fixed;
    z-index: 100;
}
.out {
    width: 1140px;
    height: 100%;
    margin: 0px auto;
    font-size: 18px;
    line-height: 50px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
.right {
    display: flex;
    flex-direction: row;
    justify-content: right;

}
.right > div{
    width: 120px;
    background: none;
    font-size: 17px;
    text-align: center;
    transition: 0.1s;
}


.right:nth-child(n) {
    color: #909399;
}
.right div:hover {
    background: rgba(236, 245, 255, 0.2);
    border-bottom: #a0cfff 3px solid;
}
.right div:hover > a {
    color: black;
}

.active {
    color: black;
    border-bottom: #a0cfff 3px solid;
}
.to_bbs > a {
    color: #909399;
    text-decoration: none;
}
</style>