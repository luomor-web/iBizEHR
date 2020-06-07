<template>
    <el-timeline class="app-timeline">
        <template v-for="(item, index) of items">
            <el-timeline-item :key="index" :timestamp="item.name" placement="top">
                <template v-for="data of item.items">
                    <div :key="data.srfkey" class="app-timeline-item-title" @click="onClick(data)">
                        <card>
                            <div>{{data.name}}</div>
                            <div>{{data.actor || data.create_uid_text}}</div>
                            <div>{{data.time || data.create_date}}</div>
                        </card>
                    </div>
                </template>
            </el-timeline-item>
        </template>
    </el-timeline>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from "vue-property-decorator";

@Component({})
export default class AppTimeline extends Vue {

    /**
     * 数据集
     *
     * @type {string}
     * @memberof AppTimeline
     */
    @Prop() datas?: string;

    /**
     * 数据集对象
     *
     * @protected
     * @type {any[]}
     * @memberof AppTimeline
     */
    protected items: any[] = [];

    /**
     * 数据集监听
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppTimeline
     */
    @Watch('datas')
    onDatasChange(newVal: any, oldVal: any) {
        if(newVal) {
            this.prepareData(JSON.parse(newVal))
        }
    }

    /**
     * 生命周期
     *
     * @memberof AppTimeline
     */
    public mounted() {
        if(this.datas) {
            this.prepareData(JSON.parse(this.datas))
        }
    }

    /**
     * 准备数据
     *
     * @param {*} datas
     * @memberof AppTimeline
     */
    public prepareData(datas: any[] = []) {
        let format: any = this.getFormat();
        datas.forEach((data: any) => {
            let time = data.time || data.create_date;
            if(format.test(time)) {
                time.replace(format, (str: string) => {
                    let item: any = this.items.find((item: any) => Object.is(item.name, str));
                    if(!item) {
                        item = {name: str, items: [data]};
                        this.items.push(item);
                    } else {
                        item.items.push(data);
                    }
                });
            }
        })
    }

    /**
     * 获取时间格式
     *
     * @memberof AppTimeline
     */
    public getFormat() {
        return /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})/;
    }

    /**
     * 选中
     *
     * @param {*} item
     * @memberof AppTimeline
     */
    public onClick(item: any) {
        this.$emit('click', item);
    }
}
</script>

<style lang="less">
.app-timeline {
    margin-left: 50px;
    .el-timeline-item__timestamp {
        color: initial;
        font-weight: bold;
    }
    .app-timeline-item-title {
        cursor: pointer;
        width: 350px;
        margin-bottom: 5px;
    }
    .app-timeline-item-title:hover {
        color: #108cee;
    }
}
</style>