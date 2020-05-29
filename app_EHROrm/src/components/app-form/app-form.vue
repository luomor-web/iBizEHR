<template>
  <i-form form="form">
    <row >
      <slot></slot>
    </row>
  </i-form>
</template>
<script lang = 'ts'>
import { Component, Vue, Prop } from 'vue-property-decorator';

@Component({})
export default class AppForm extends Vue {

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof Form
     */
    @Prop() public form?: any;

    /**
     * 表单名称
     *
     * @type {string}
     * @memberof Form
     */
    @Prop() public name?: string;
}
</script>
<style lang = "less">
@import './app-form.less';
</style>