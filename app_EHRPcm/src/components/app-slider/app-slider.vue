<template>
<div>
  <el-slider 
    v-model ="currentVal"
    :disabled="disabled"
    :step="step"
    :min="min"
    :max="max"
    @change="change">
  </el-slider >
</div>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from "vue-property-decorator";

@Component({})
export default class AppSlider extends Vue {
    /**
    * 传入值
    * @type {any}
    * @memberof AppSlider
    */
    @Prop() public value?:any;

    /**
    * 是否禁用
    * @type {boolean}
    * @memberof AppSlider
    */
    @Prop() public disabled?: boolean;

    /**
    * 属性项名称
    *
    * @type {string}
    * @memberof AppPicker
    */
    @Prop() public name!: string;

    /**
    * 步长
    * @type {number}
    * @memberof AppSlider
    */
    @Prop({default:1}) public step!: number;

    /**
    * 最小值
    * @type {number}
    * @memberof AppSlider
    */
    @Prop({default:0}) public min!: number;

    /**
    * 最大值
    * @type {number}
    * @memberof AppSlider
    */
    @Prop({default:100}) public max!: number;
    

    /**
    * 当前值
    *
    * @memberof AppSlider
    */
    currentVal: number = 0;

    /**
     * 值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPicker
     */
    @Watch('value')
    public onValueChange(newVal: any, oldVal: any) {
        this.currentVal = parseInt(newVal);
    }

    /**
     * change事件
     *
     * @param {*} val
     * @memberof AppPicker
     */
    public change(val: any) {
        this.$emit('change', { name: this.name, value: val });
    }


}
</script>

<style lang='less'>
@import "./app-slider.less";
</style>