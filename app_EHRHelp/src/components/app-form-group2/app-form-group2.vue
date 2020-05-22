
<template>
     <span>未实现</span>
</template>
<script lang="ts">
import { Vue, Component, Prop, } from 'vue-property-decorator';


@Component({})
export default class AppFormGroup2 extends Vue {

    /**
     * 标题
     *
     * @type {string}
     * @memberof AppFormGroup2
     */
    @Prop() public caption?: string;

    /**
     * 内置界面样式
     * 
     * @type {string}
     * @memberof AppFormGroup2
     */
    @Prop() public uiStyle?: string;

    /**
     * 布局模式
     *
     * @type {string}
     * @memberof AppFormGroup2
     */
    @Prop() public layoutType?: string;

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof AppFormGroup2
     */
    @Prop({ default: true }) public isShowCaption!: boolean;

    /**
     * 界面行为组
     *
     * @type {*}
     * @memberof AppFormGroup2
     */
    @Prop() public uiActionGroup?: any;

    /**
     * 标题栏关闭模式
     * 0: 不支持关闭
     * 1: 默认打开
     * 2： 默认关闭
     *
     * @type {(number | 0 | 1 | 2)} 
     * @memberof AppFormGroup2
     */
    @Prop({ default: 0 }) public titleBarCloseMode!: number | 0 | 1 | 2;

}
</script>
<style lang="less">
@import './app-form-group2.less';
</style>