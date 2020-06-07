
<template>
  <div>
    <form-item
      :prop="name"
      :error="error"
      :required="required"
      :rules="rules"
      :class="classes"
      :label-width="isShowCaption ? !Object.is(labelPos, 'TOP') ?  labelWidth : null : 0"
      :ref="name"
    >
      <span
        v-if="isShowCaption && labelWidth > 0"
        slot="label" :class="labelclasses"
      >{{isEmptyCaption ? '' : caption}}</span>
      <div class="app-editor-contant">{{$slots.default}}</div>
      <div
        v-if="_formitem && _formitem.validateState && Object.is(_formitem.validateState, 'error')"
        class="app-error-tip"
      >
        <poptip trigger="hover" placement="left" width="300" word-wrap="true" transfer="true">
          <icon type="ios-information-circle-outline" color="#ed4014" size="20"></icon>
          <div slot="content" class="app-form-item-error-info">
            <div class="icon">
              <icon type="ios-information-circle-outline" color="#ed4014" size="20"></icon>
            </div>
            <div class="contant">{{_formitem.validateMessage}}</div>
          </div>
        </poptip>
      </div>
    </form-item>
  </div>
</template>
<script lang="ts">
import { Vue, Component, Prop, Watch } from "vue-property-decorator";

@Component({})
export default class AppFormItem2 extends Vue {
  /**
   * 名称
   *
   * @type {string}
   * @memberof AppFormItem2
   */
  @Prop() public caption!: string;

  /**
   * 错误信息
   *
   * @type {string}
   * @memberof AppFormItem2
   */
  @Prop() public error?: string;

  /**
    * label样式
    *
    * @type {string}
    * @memberof AppFormItem2
    */
  @Prop() public labelStyle?: string;

  /**
   * 标签位置
   *
   * @type {(string | 'BOTTOM' | 'LEFT' | 'NONE' | 'RIGHT' | 'TOP')}
   * @memberof AppFormItem2
   */
  @Prop() public labelPos?:
    | string
    | "BOTTOM"
    | "LEFT"
    | "NONE"
    | "RIGHT"
    | "TOP";

  /**
   * 标签宽度
   *
   * @type {number}
   * @memberof AppFormItem2
   */
  @Prop({}) public labelWidth!: number;

  /**
   * 是否显示标题
   *
   * @type {boolean}
   * @memberof AppFormItem2
   */
  @Prop() public isShowCaption?: boolean;

  /**
   * 标签是否空白
   *
   * @type {boolean}
   * @memberof AppFormItem2
   */
  @Prop() public isEmptyCaption?: boolean;

  /**
   * 表单项名称
   *
   * @type {string}
   * @memberof AppFormItem2
   */
  @Prop() public name!: string;

  /**
   * 内置样式
   *
   * @type {string}
   * @memberof AppFormItem2
   */
  @Prop() public uiStyle?: string;

  /**
   * 表单项值规则
   *
   * @type {string}
   * @memberof AppFormItem2
   */
  @Prop() public itemRules!: any;

  /**
   * 值规则数组
   *
   * @type {any[]}
   * @memberof AppFormItem2
   */
  public rules: any[] = [];

  /**
   * 是否必填
   *
   * @type {boolean}
   * @memberof AppFormItem2
   */
  public required: boolean = false;

  /**
   * 表单项值规则监控
   *
   * @param {*} newVal
   * @param {*} oldVal
   * @memberof AppFormItem2
   */
  @Watch("itemRules")
  onItemRulesChange(newVal: any, oldVal: any) {
    if (newVal) {
      try {
        this.rules = [];
        const _rules: any[] = newVal;
        this.rules = [..._rules];
        this.rules.some((rule: any) => {
          if (rule.hasOwnProperty("required")) {
            this.required = rule.required;
            return true;
          }
          return false;
        });
      } catch (error) {}
    }
  }

  /**
   * 计算样式
   *
   * @readonly
   * @type {string[]}
   * @memberof AppFormItem2
   */
  get classes(): string[] {
    return [
      "app-form-item2",
      Object.is(this.labelPos, "TOP") ? "app-form-item-label-top" : ""
    ];
  }

  /**
    * label样式
    *
    * @readonly
    * @type {string}
    * @memberof AppFormItem2
    */
  get labelclasses():string{
      return this.labelStyle?this.labelStyle:'';
  }

  /**
   * vue 生命周期
   *
   * @memberof AppFormItem2
   */
  public mounted() {
    if (this.itemRules) {
      try {
        const _rules: any[] = this.itemRules;
        this.rules = [..._rules];
        this.rules.some((rule: any) => {
          if (rule.hasOwnProperty("required")) {
            this.required = rule.required;
            return true;
          }
          return false;
        });
      } catch (error) {}
    }
  }
}
</script>
<style lang="less">
@import "./app-form-item2.less";
</style>