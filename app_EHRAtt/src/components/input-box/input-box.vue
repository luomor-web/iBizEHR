<template>
  <div class="input-unit">
    <i-input
      :placeholder="placeholder"
      :size="size"
      :type="type"
      v-model="CurrentVal"
      :disabled="disabled ? true : false"
      @on-enter="enter"
    ></i-input>
    <div class="unit-text">{{unit}}</div>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model, Emit } from "vue-property-decorator";
import { Subject } from "rxjs";
import { debounceTime, distinctUntilChanged } from "rxjs/operators";

@Component({})
export default class InputBox extends Vue {
  /**
   * 双向绑定值
   * @type {any}
   * @memberof InputBox
   */
  @Model("change") readonly itemValue?: any;

  /**
   * 单位
   * @type {String}
   * @memberof InputBoxUnit
   */
  @Prop() public unit?: string;

  /**
   * 大小
   * @type {String}
   * @memberof InputBoxUnit
   */
  @Prop() public size?: string;

  /**
   * placeholder值
   * @type {String}
   * @memberof InputBox
   */
  @Prop() public placeholder?: string;

  /**
   * 是否禁用
   * @type {boolean}
   * @memberof InputBox
   */
  @Prop() public disabled?: boolean;

  /**
   * 属性类型
   *
   * @type {string}
   * @memberof InputBox
   */
  @Prop() public type?: string;

  /**
   * 当前值
   *
   * @memberof InputBox
   */
  get CurrentVal() {
    return this.itemValue;
  }

  /**
   * 值变化
   *
   * @memberof InputBox
   */
  set CurrentVal(val: any) {
    let _data: any = val;
    if (Object.is(this.type, "number") && val && !isNaN(val)) {
      try {
        _data = isNaN(Number(val)) ? null : Number(val);
      } catch (error) {}
    }
    if (Object.is(_data, "")) {
      _data = null;
    }
    this.$emit("change", _data);
  }

  /**
   * 回车事件
   *
   * @param {*} $event
   * @memberof InputBox
   */
  @Emit()
  public enter($event: any) {
    if (!$event || $event.keyCode !== 13) {
      return;
    }
    return $event;
  }
}
</script>

<style lang='less'>
@import "./input-box.less";
</style>