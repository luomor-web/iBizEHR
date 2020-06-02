<template>
<div class="ibiz-date-picker">
  <div class="date-picker-text">{{$t('components.dateRange.startText')}}</div>
  <el-date-picker
    v-model="value"
    type="daterange"
    :range-separator="rangeSeparatorr ? rangeSeparatorr : $t('components.dateRange.rangeSeparatorr')"
    :start-placeholder="startPlaceholder ? startPlaceholder : $t('components.dateRange.startPlaceholder')"
    :end-placeholder="endPlaceholder ? endPlaceholder : $t('components.dateRange.endPlaceholder')"
    :disabled="disabled"
    value-format="yyyy-MM-dd"
    @change="change"
    :format="format"
  ></el-date-picker>
  <div class="date-picker-text">{{$t('components.dateRange.endText')}}</div>
</div>

</template>
<script lang = 'ts'>
import { Component, Vue, Model, Prop } from "vue-property-decorator";

@Component({
})
export default class DateRange extends Vue {
  /**
   * 日期格式
   * @type {any}
   * @memberof DateRange
   */
  @Prop() format?: string;
  
  /**
   * 是否禁用
   *
   * @type {*}
   * @memberof DateRange
   */
  @Prop() public disabled?: boolean;

  /**
   * 结束日期Placeholder
   *
   * @type {*}
   * @memberof DateRange
   */
  @Prop() public endPlaceholder?: string;

  /**
   * 中间Placeholder
   *
   * @type {*}
   * @memberof DateRange
   */
  @Prop() public rangeSeparatorr?: string;

  /**
   * 开始日期Placeholder
   *
   * @type {*}
   * @memberof DateRange
   */
  @Prop() public startPlaceholder?: string;

  /**
   * 双向绑定值
   * @type {any}
   * @memberof DateRange
   */
  @Prop() value?: any;



  /**
   * 选中时间事件
   * @type {any}
   * @memberof DateRange
   */
  public change() {
    this.$emit("on-change", this.value);
  }



  /**
   * 编辑器名称
   *
   * @type {string}
   * @memberof DateRange
   */
  @Prop() public name?: string;

  
}
</script>
<style lang = "less">
@import "./date-picker-range.less";
</style>