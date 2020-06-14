<template>
  <div class="app-stepper">
    <el-input-number :value="currentVal" :disabled="disabled" @change="onChange" :min="min" :max="max" :step="step"></el-input-number>
  </div>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from "vue-property-decorator";

@Component({})
export default class AppStepper extends Vue {
    /**
     * 传入值
     * @type {any}
     * @memberof AppStepper
     */
    @Prop() public value?:any;

    /**
     * 属性项名称
     *
     * @type {string}
     * @memberof AppPicker
     */
    @Prop() public name!: string;

    /**
     * 是否禁用
     * @type {boolean}
     * @memberof AppStepper
     */
    @Prop() public disabled?: boolean;
  
    /**
     * 步长
     * @type {number}
     * @memberof AppStepper
     */
    @Prop({default:1}) public step!: number;

    /**
     * 最小值
     * @type {number}
     * @memberof AppStepper
     */
    @Prop({default:0}) public min!: number;

    /**
     * 最大值
     * @type {number}
     * @memberof AppStepper
     */
    @Prop({default:100}) public max!: number;

    /**
     * 当前值
     *
     * @memberof AppStepper
     */
    get currentVal() {
        return this.value ? this.value : 0;
    }

    /**
     * change
     */
    public onChange(val: any) {
        this.$emit('change', { name: this.name, value: val });
    }


}
</script>

<style lang='less'>
@import "./app-stepper.less";
</style>