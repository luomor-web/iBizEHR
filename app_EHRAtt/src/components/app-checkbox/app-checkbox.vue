<template>
  <div class="checkbox">
    <checkbox v-model="CurrentVal" :disabled="disabled"></checkbox>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model, Emit } from "vue-property-decorator";
import { Subject } from "rxjs";
import { debounceTime, distinctUntilChanged } from "rxjs/operators";

@Component({})
export default class AppCheckbox extends Vue {
  /**
   * 传入值
   * @type {any}
   * @memberof checkbox
   */
  @Prop() public value?:any;

  /**
   * 是否禁用
   * @type {boolean}
   * @memberof checkbox
   */
  @Prop() public disabled?: boolean;


  /**
   * 当前值
   *
   * @memberof checkbox
   */
  get CurrentVal() {
      if(this.value == 0){
        return false;
      }else if(this.value ==1){
        return true;
      }
  }

  /**
   * 值变化
   *
   * @memberof checkbox
   */
  set CurrentVal(val: any) {
      this.$emit("change", val?1:0); 
  }
}
</script>

<style lang='less'>
@import "./app-checkbox.less";
</style>