<template>
<div>
  <el-rate
  :value ="currentVal"
  :disabled="disabled"
  :max="max"
  @change="change"
  >
  </el-rate>
</div>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from "vue-property-decorator";

@Component({})
export default class AppRate extends Vue {
 /**
   * 传入值
   * @type {any}
   * @memberof AppRate
   */
  @Prop() public value?:any;

  /**
   * 是否禁用
   * @type {boolean}
   * @memberof AppRate
   */
  @Prop() public disabled?: boolean;
  
    /**
    * 最大值
    * @type {number}
    * @memberof AppRate
    */
    @Prop({default:5}) public max!: number;

  /**
   * 当前值
   *
   * @memberof AppRate
   */
  get currentVal() {
      return this.value;
  }

  /**
   * change
   */
  public change(val: any) {
    this.$emit("change", val); 
  }


}
</script>

<style lang='less'>
@import "./app-rate.less";
</style>