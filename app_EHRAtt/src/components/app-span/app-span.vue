<template>
    <codelist v-if="tag" :tag="tag" :value="value" :codelistType="codelistType" :renderMode="renderMode" :valueSeparator="valueSeparator" :textSeparator="textSeparator" :data="data" :itemParam="itemParam" :context="context" :viewparams="viewparams"></codelist>
    <app-upload-file-info v-else-if="Object.is(this.editorType,'PICTURE') || Object.is(this.editorType,'PICTURE_ONE') || Object.is(this.editorType,'FILEUPLOADER')" :value="value" :name="name"></app-upload-file-info>
    <span class="app-span" v-else >{{text}}</span>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch, Model } from 'vue-property-decorator';

@Component({})
export default class AppSpan extends Vue {

    /**
     * 当前值
     * 
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public value?: any;

    /**
     * 当前表单项名称
     * 
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public name?: any;

    /**
     * 代码表标识
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop() public tag?: string;

    /**
     * 代码表类型
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop() public codelistType?: string;

    /**
     * 获取或模式
     * @type {boolean}
     * @memberof AppSpan
     */
    @Prop({default:"STR"}) public renderMode?: string;

    /**
     * 文本分隔符
     * @type {boolean}
     * @memberof AppSpan
     */
    @Prop({default:'、'}) public textSeparator?: string;

    /**
     * 值分隔符
     * @type {boolean}
     * @memberof AppSpan
     */
    @Prop({default:','}) public valueSeparator?: string;

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public data?: any;

    /**
     * 传入额外参数
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public itemParam?: any;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public viewparams!: any;

    /**
     * 监控表单属性 data 值
     *
     * @memberof AppSpan
     */
    @Watch('value')
    onDataChange(newVal: any, oldVal: any) {
        if(newVal !== oldVal){
           this.load();
        }
    }

    /**
     * 显示值
     * @type {*}
     * @memberof AppSpan
     */
    public text:any = '';

    /**
     * 编辑器类型
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop() public editorType?: string;

    /**
     * vue  生命周期
     *
     * @memberof AppSpan
     */
    public created() {
        this.load();
    }

    /**
     * 处理数据
     * 
     * @memberof AppSpan
     */
    public load(){
        if(!this.value || this.tag){
            return;  //代码表走codelist组件

        }else if(this.editorType === "ADDRESSPICKUP"){
            JSON.parse(this.value).forEach((item:any,index:number) => {
              this.text += index === 0 ? item.srfmajortext : ","+item.srfmajortext;
            });
        }else{
            this.text = this.value;
        }
    }
    
}
</script>

<style lang='less'>
@import './app-span.less';
</style>