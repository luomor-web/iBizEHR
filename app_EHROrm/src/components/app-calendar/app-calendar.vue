<template>
    <FullCalendar ref="appCalendar" height="parent" :locales="locales" locale="zh-cn" :header="header" class="app-calendar" :events="items" defaultView="dayGridMonth" :plugins="calendarPlugins" @eventClick="onClick"/>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from "vue-property-decorator";
import FullCalendar from '@fullcalendar/vue';
import dayGridPlugin from '@fullcalendar/daygrid';
import allLocales from '@fullcalendar/core/locales-all';

import '@fullcalendar/core/main.css';
import '@fullcalendar/daygrid/main.css';

@Component({
    components: {
        FullCalendar
    }
})
export default class AppCalendar extends Vue {

    /**
     * 数据集
     *
     * @type {string}
     * @memberof AppCalendar
     */
    @Prop() datas?: string;

    /**
     * 类型
     *
     * @type {string}
     * @memberof aaa
     */
    @Prop() type?: string;

    /**
     * 数据集对象
     *
     * @protected
     * @type {any[]}
     * @memberof AppCalendar
     */
    protected items: any[] = [];

    /**
     * 头部设置
     *
     * @protected
     * @memberof AppCalendar
     */
    protected header: any = {
        left: 'prev,next today',
        center: 'title',
        right: false
    };

    /**
     * 语言资源
     *
     * @protected
     * @memberof AppCalendar
     */
    public locales = allLocales;

    /**
     * 日历插件
     *
     * @protected
     * @type {any[]}
     * @memberof aaa
     */
    protected calendarPlugins: any[] = [dayGridPlugin];

    /**
     * 数据集监听
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppCalendar
     */
    @Watch('datas')
    onDatasChange(newVal: any, oldVal: any) {
        if(newVal) {
            this.items = this.prepareItems(JSON.parse(newVal));
        }
    }

    /**
     * 类型监听
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppCalendar
     */
    @Watch('type')
    onTypeChange(newVal: any, oldVal: any) {
        if(Object.is(newVal, 'calendar')) {
            let appCalendar: any = this.$refs.appCalendar;
            let api = appCalendar.getApi();
            api.updateSize()
        }
    }

    /**
     * 生命周期
     *
     * @memberof AppCalendar
     */
    public mounted() {
        if(this.datas) {
            this.items = this.prepareItems(JSON.parse(this.datas));
        }
    }

    /**
     * 准备数据
     *
     * @param {*} datas
     * @memberof AppCalendar
     */
    public prepareItems(datas: any[]): any[] {
        let items: any[] = [];
        datas.forEach((data: any) => {
            if(!data.hasOwnProperty('date')) {
                data.date = data.create_date;
                data.id = data.srfkey;
            }
            items.push(data);
        })
        return items;
    }

    /**
     * 数据点击
     *
     * @param {*} datas
     * @memberof AppCalendar
     */
    public onClick($event: any) {
        let item = this.items.find((item: any) => item.srfkey == $event.event.id);
        if(item) {
            this.$emit('click', item);
        }
    }
}
</script>

<style lang="less">
.app-calendar {
    height: 100%;
    width: 100%;
}
</style>