<template>
    <div>
        <div v-if="this.uiStyle === 'STYLE2'">
             <app-form-item2
                :caption="caption"
                :labelStyle="labelStyle"
                :error="error"
                :labelPos="labelPos"
                :labelWidth="labelWidth"
                :isShowCaption="isShowCaption"
                :isEmptyCaption="isEmptyCaption"
                :name="name"
                :uiStyle="uiStyle"
                :itemRules="itemRules">
                <slot></slot>
            </app-form-item2>
        </div>
        <div v-if="this.uiStyle !== 'STYLE2'">
            <form-item
                :prop="name"
                :error="error"
                :required="required"
                :rules="rules"
                :class="classes"
                :label-width="this.isShowCaption ? !Object.is(this.labelPos, 'TOP') ? this.labelWidth : null : 0">
                    <span slot='label' v-if="this.isShowCaption && this.labelWidth > 0"  :class="labelclasses">
                        {{this.isEmptyCaption ? '' : this.caption}}
                    </span>
                    <slot></slot>
            </form-item>
        </div>
    </div>
</template>
<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';

@Component({})
export default class AppFormItem extends Vue {

    /**
     * 名称
     *
     * @type {string}
     * @memberof AppFormItem
     */
    @Prop() public caption!: string;

    /**
     * 错误信息
     *
     * @type {string}
     * @memberof AppFormItem
     */
    @Prop() public error?: string;

    /**
     * label样式
     *
     * @type {string}
     * @memberof AppFormItem
     */
    @Prop() public labelStyle?: string;

    /**
     * 标签位置
     *
     * @type {(string | 'BOTTOM' | 'LEFT' | 'NONE' | 'RIGHT' | 'TOP')}
     * @memberof AppFormItem
     */
    @Prop() public labelPos?: string | 'BOTTOM' | 'LEFT' | 'NONE' | 'RIGHT' | 'TOP';

    /**
     * 标签宽度
     *
     * @type {number}
     * @memberof AppFormItem
     */
    @Prop({}) public labelWidth!: number;

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof AppFormItem
     */
    @Prop() public isShowCaption?: boolean;

    /**
     * 标签是否空白
     *
     * @type {boolean}
     * @memberof AppFormItem
     */
    @Prop() public isEmptyCaption?: boolean;

    /**
     * 表单项名称
     *
     * @type {string}
     * @memberof AppFormItem
     */
    @Prop() public name!: string;

    /**
     * 内置样式
     *
     * @type {string}
     * @memberof AppFormItem
     */
    @Prop() public uiStyle?: string;

    /**
     * 表单项值规则
     *
     * @type {string}
     * @memberof AppFormItem
     */
    @Prop() public itemRules!: any;

    /**
     * 值规则数组
     *
     * @type {any[]}
     * @memberof AppFormItem
     */
    public rules: any[] = [];

    /**
     * 是否必填
     *
     * @type {boolean}
     * @memberof AppFormItem
     */
    public required: boolean = false;

    /**
     * 表单项值规则监控
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppFormItem
     */
    @Watch('itemRules',{deep:true})
    onItemRulesChange(newVal: any, oldVal: any) {
        if (newVal) {
            try {
                this.rules = [];
                const _rules: any[] = newVal;
                this.rules = [..._rules];
                this.rules.some((rule: any) => {
                    if (rule.hasOwnProperty('required')) {
                        this.required = rule.required;
                        return true;
                    }
                    return false;
                });
            } catch (error) {
            }
        }
    }

    /**
     * 计算样式
     *
     * @readonly
     * @type {string []}
     * @memberof AppFormItem
     */
    get classes(): string[] {
        return [
            'app-form-item',
            Object.is(this.labelPos, 'TOP') ? 'app-form-item-label-top' : ''
        ];
    }

    /**
     * label样式
     *
     * @readonly
     * @type {string}
     * @memberof AppFormItem
     */
    get labelclasses():string{
        return this.labelStyle?this.labelStyle:'';
    }

    /**
     * vue 生命周期
     *
     * @memberof AppFormItem
     */
    public mounted() {
        if (this.itemRules) {
            try {
                const _rules: any[] = this.itemRules;
                this.rules = [..._rules];
                this.rules.some((rule: any) => {
                    if (rule.hasOwnProperty('required')) {
                        this.required = rule.required;
                        return true;
                    }
                    return false;
                });
            } catch (error) {
            }
        }
    }

}
</script>
<style lang='less'>
@import './app-form-item.less';
</style>