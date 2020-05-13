<template>
    <codelist v-if="tag" :tag="tag" :value="value" :codelistType="codelistType" :renderMode="renderMode" :valueSeparator="valueSeparator" :textSeparator="textSeparator"></codelist>
    <span class="app-span" v-else >{{text}}</span>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch, Model } from 'vue-property-decorator';
import CodeListService from "@service/app/codelist-service";

@Component({})
export default class DropDownList extends Vue {

    /**
     * 当前值
     * 
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public value?: any;

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
     * @memberof SelectPicker
     */
    @Prop({default:"STR"}) public renderMode?: string;

    /**
     * 文本分隔符
     * @type {boolean}
     * @memberof SelectPicker
     */
    @Prop({default:"、"}) public textSeparator?: string;

    /**
     * 值分隔符
     * @type {boolean}
     * @memberof SelectPicker
     */
    @Prop({default:";"}) public valueSeparator?: string;

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
        } else if(Object.is(this.editorType,'PICTURE') || Object.is(this.editorType,'PICTURE_ONE') || Object.is(this.editorType,'FILEUPLOADER')){
            let files: any[] = JSON.parse(this.value);
            let names: any[] = [];
            if(files.length && files.length > 0){
                files.forEach((item:any) => {
                    names.push(item.name);
                });
                this.text = names.join(',');
            }
        }else{
            this.text = this.value;
        }
    }
    
}
</script>

<style lang='less'>
@import './app-span.less';
</style>