<template>
    <div v-if="refviewname" class="app-embed-picker">
        <div :style="{ height: placeholder ? 'calc(100% - 32px)' : '100%' }">
            <component
              :is="refviewname"
              :viewdata="viewdata"
              :viewparam="viewparam"
              :viewDefaultUsage="false"
              @viewdataschange="setValue(args)"
              style="height:100%;">
            </component>
        </div>
        <template v-if="placeholder">
            <div v-if="value" class="app-embed-value">{{value}}</div>
            <div v-else class="app-embed-placeholder">{{placeholder}}</div>
        </template>
    </div>
    <div v-else>{{emptyText}}</div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';

@Component({})
export default class AppEmbedPicker extends Vue {

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    @Prop() public viewparams!: any;

    /**
     * 视图参数
     *
     * @type {string}
     * @memberof AppTreePicker
     */
    public viewparam: any = JSON.stringify(this.viewparams);;
    
    /**
     * 视图参数
     *
     * @type {string}
     * @memberof AppTreePicker
     */
    public viewdata: any = JSON.stringify(this.context);

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppPicker
     */
    @Prop() public data!: any;

    /**
     * 值
     *
     * @type {*}
     * @memberof AppEmbedPicker
     */
    @Prop() public value: any;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppEmbedPicker
     */
    @Prop() public formState!: Subject<any>

    /**
     * 视图状态事件
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof SelectType
     */
    protected formStateEvent: Subscription | undefined;

    /**
     * 值项名称
     *
     * @type {string}
     * @memberof AppPicker
     */
    @Prop() public valueItem?: string;

    /**
     * 关联视图名称
     *
     * @type {string}
     * @memberof AppPicker
     */
    @Prop() public refviewname?: string;

    /**
     * 提示信息
     *
     * @type {string}
     * @memberof AppEmbedPicker
     */
    @Prop() public placeholder!: string;

    /**
     * 空值文本
     *
     * @type {string}
     * @memberof EmbedPicker
     */
    @Prop() public emptyText?: string;

    /**
     * 属性项名称
     *
     * @type {string}
     * @memberof AppPicker
     */
    @Prop() public name!: string;

    /**
     * 关联视图参数
     *
     * @type {*}
     * @memberof AppEmbedPicker
     */
    @Prop() public itemParam: any;

    /**
     * 是否忽略之变化
     *
     * @type {boolean}
     * @memberof AppEmbedPicker
     */
    @Prop() public ignorefieldvaluechange!: boolean;

    /**
     * 重置项
     *
     * @type {string}
     * @memberof AppEmbedPicker
     */
    @Prop() public refreshitems?: string;

    /**
     * 设置视图参数
     *
     * @memberof AppEmbedPicker
     */
    public setViewParam(activeData: any) {
        if (!this.itemParam || !activeData) {
            return;
        }
        let arg: any = {};
        // 合并视图上下文参数和视图参数
        let param: any = JSON.parse(JSON.stringify(this.viewparams));
        let context: any = JSON.parse(JSON.stringify(this.context));
        // 附加参数处理
        if (this.itemParam.context) {
            let _context = this.$util.formatData(activeData,this.itemParam.context);
            Object.assign(context,_context);
        }
        if (this.itemParam.param) {
            let _param = this.$util.formatData(activeData,this.itemParam.param);
            Object.assign(param,_param);
        }
        if (this.itemParam.parentdata) {
            let _parentdata = this.$util.formatData(activeData,this.itemParam.parentdata);
            Object.assign(param,_parentdata);
        }
        this.viewdata = JSON.stringify(context);
        this.viewparam = JSON.stringify(param);
    }

    /**
     * 监控值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppFormDRUIPart
     */
    @Watch('data')
    onActivedataChange(newVal: any, oldVal: any) {
        const newFormData: any = JSON.parse(newVal);
        const oldDormData: any = JSON.parse(oldVal);
        this.setViewParam(newFormData);
        if (!this.refreshitems || this.ignorefieldvaluechange) {
            return;
        }
        if(Object.is(newFormData[this.refreshitems], oldDormData[this.refreshitems])) {
            return;
        }
        this.setValue([{srfmajortext: null, srfkey: null}]);
    }

    /**
     * 生命周期
     *
     * @memberof AppEmbedPicker
     */
    public created() {
        if(this.formState) {
            this.formStateEvent = this.formState.subscribe(({ tag, action, data }) => {
                if (Object.is('load', action)) {
                    this.setViewParam(JSON.parse(this.data));
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof SelectType
     */
    public destroyed() {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * 设置值
     *
     * @param {*} item
     * @memberof AppEmbedPicker
     */
    public setValue(item: any) {
        if (this.valueItem) {
            this.$emit('formitemvaluechange', { name: this.valueItem, value: item[0].srfkey });
        }
        if (this.name) {
            this.$emit('formitemvaluechange', { name: this.name, value: item[0].srfmajortext });
        }
    }

}
</script>

<style lang='less'>
@import './app-embed-picker.less';
</style>