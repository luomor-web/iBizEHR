<template>
  <div class="column-render">
    {{textValue}}
    <template v-if="Object.is(type,'input')">
        <input-box :disabled="disabled" v-model="editorvalue" @change="($event)=>{onEditorValueChange($event)}"></input-box>
    </template>
    <template v-else-if="Object.is(type,'dropdown')">
        <i-select v-model="editorvalue"  :disabled="disabled" :clearable="true" :placeholder="$t('components.appColumnRender.select')" >
            <i-option v-for="(item, index) in codelist" :key="index" :value="item.value">{{item.text}}</i-option>
        </i-select>
    </template>
    <template v-else>
      <span>{{type}}{{$t('components.appColumnRender.unsupported')}}</span>
    </template>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model, Emit, Watch } from "vue-property-decorator";
import { Subject } from "rxjs";
import { debounceTime, distinctUntilChanged } from "rxjs/operators";

@Component({
})
export default class AppColumnRender extends Vue {
    /**
     * 值
     * @type {any}
     * @memberof AppColumnRender
     */
    @Prop() public value?: any;

    /**
     * 是否禁用
     * @type {boolean}
     * @memberof AppColumnRender
     */
    @Prop() public disabled?: boolean;

    /**
     * 列字段名称
     *
     * @type {string}
     * @memberof AppColumnRender
     */
    @Prop() public name?: string;

    /**
     * 表格行数据
     *
     * @type {string}
     * @memberof AppColumnRender
     */
    @Prop() public row?: any;

    /**
     * 自定义样式
     *
     * @type {string}
     * @memberof AppColumnRender
     */
    @Prop() public customStyle?: string;

    /**
     * 文本信息
     * @type {String}
     * @memberof AppColumnRender
     */
    public textValue: string = "";

    /**
     * 编辑器类型
     * @type {String}
     * @memberof AppColumnRender
     */
    public type: string = "";

    /**
     * 值项名称
     *
     * @type {string}
     * @memberof AppColumnRender
     */
    public valueitem: string = "";

    /**
     * 编辑器值
     * @type {any}
     * @memberof AppColumnRender
     */
     public editorvalue: any = "";

    /**
     * 代码表选项数组
     * @memberof AppColumnRender
     */
     public codelist: any = [];

    public created(){
        this.onValueChange(this.value,"");
    }


    /**
     * 自定义列值监控
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppColumnRender
     */
    @Watch('value')
    onValueChange(newVal: any, oldVal: any) {
        if (newVal) {
            let arrs = newVal.split("%");
            this.textValue = arrs[0];
            let params = [];
            if(arrs[1]){
                (arrs[1].split(";")).forEach((item:any)=>{
                    let temp = item.split("=");
                    if(Object.is(temp[0], "type")){
                        this.type = temp[1];
                    } else if(Object.is(temp[0], "value")) {
                      this.valueitem = temp[1];
                        if(this.valueitem && this.row[this.valueitem]){
                          this.editorvalue = this.row[this.valueitem];
                        }
                    } else if(Object.is(temp[0], "codelist")) {
                        this.codelist = temp[1];
                    }
                });
            }
        }
    }

    /**
     * 编辑器值变化回调
     * @param item 
     */
    public onEditorValueChange(item: any): void {
        if (this.name) {
            // this.$emit('griditemvaluechange', { name: this.name, value: item });
        }
        if (this.valueitem) {
            this.$emit('griditemvaluechange', { name: this.valueitem, value: item });
        }
    }

}
</script>

<style lang='less'>
@import "./app-column-render.less";
</style>