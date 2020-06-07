<template>
    <div class="data-reveal-type">
        <div class='show-type'>
            <button-group v-show="!showTypeDir">
                <i-button class="collapse-btn" type="primary" @click="clickCollapse('left')">
                    <icon type="ios-arrow-back"/>
                </i-button>
                <i-button v-show="showTypeDir"></i-button>
            </button-group>
            <button-group v-show="showTypeDir">
                <el-tooltip content="默认">
                    <i-button  :type="activeType == 'default' ? 'primary' : 'default'" @click="onClickChange('default')">
                        <i class="fa fa-table" aria-hidden="true"></i>
                    </i-button>
                </el-tooltip>
                <el-tooltip content="日历">
                    <i-button :type="activeType == 'calendar' ? 'primary' : 'default'" @click="onClickChange('calendar')">
                        <i class="fa fa-calendar" aria-hidden="true"></i>
                    </i-button>
                </el-tooltip>
                <el-tooltip content="时间轴">
                    <i-button :type="activeType == 'timeline' ? 'primary' : 'default'" @click="onClickChange('timeline')">
                        <i class="fa fa-list-alt" aria-hidden="true"></i>
                    </i-button>
                </el-tooltip>
                <i-button class="collapse-btn" type="primary" @click="clickCollapse('right')">
                    <icon type="ios-arrow-forward"/>
                </i-button>
            </button-group>
        </div>
        <div class="data-reveal-content" v-show="Object.is(activeType, 'default')">
            <slot></slot>
        </div>
        <div class="data-reveal-content" v-show="Object.is(activeType, 'calendar')">
            <app-calendar :type="activeType" :datas="datas" @click="onClick"></app-calendar>
        </div>
        <div class="data-reveal-content" v-show="Object.is(activeType, 'timeline')">
            <app-timeline :datas="datas" @click="onClick"></app-timeline>
        </div>
    </div>
</template>

<script lang="ts">
import {Vue, Component, Prop, Watch} from 'vue-property-decorator';
import AppTimeline from '@components/app-timeline/app-timeline.vue';
import AppCalendar from '@components/app-calendar/app-calendar.vue';

@Component({
    components: {
        AppTimeline,
        AppCalendar
    }
})
export default class DataRevealType extends Vue {

    /**
     * 数据集
     *
     * @type {string}
     * @memberof DataRevealType
     */
    @Prop() datas?: string;

    /**
     * 激活类型
     *
     * @protected
     * @type {string}
     * @memberof DataRevealType
     */
    protected activeType: string = 'default';

    /**
     * 工具栏伸缩
     *
     * @protected
     * @type {boolean}
     * @memberof DataRevealType
     */
    public showTypeDir: boolean = false;

    /**
     * 切换展现类型
     *
     * @param {string} type
     * @memberof DataRevealType
     */
    public onClickChange(type: string) {
        this.activeType = type;
    }

    /**
     * 选中
     *
     * @param {*} item
     * @memberof DataRevealType
     */
    public onClick(item: any) {
        this.$emit('click', item);
    }

    /**
     * 点击伸缩
     *
     * @param {*} type
     * @memberof DataRevealType
     */
    public clickCollapse(type: string) {
        this.showTypeDir = Object.is(type, 'left') ? true : false;
    }
}
</script>

<style lang="less">
@import './data-reveal-type.less';
</style>