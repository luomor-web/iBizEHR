<template>
    <i-select
        class='dropdown-list-mpicker'
        multiple 
        :transfer="true"
        v-model="currentVal"
        :disabled="disabled === true ? true : false"
        :clearable="true"
        :filterable="filterable === true ? true : false"
        @on-open-change="onClick"
        :placeholder="$t('components.dropDownListMpicker.placeholder')">
        <i-option v-for="(item, index) in items" :key="index" :value="item.value" :label="item.text">
          <Checkbox :value = "(currentVal.indexOf(item.value))==-1?false:true">
             {{Object.is(codelistType,'STATIC') ? $t('codelist.'+tag+'.'+item.value) : item.text}}
          </Checkbox>
        </i-option>
    </i-select>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model } from 'vue-property-decorator';
import CodeListService from "@service/app/codelist-service";
@Component({
})
export default class DropDownListMpicker extends Vue {
    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof DropDownListMpicker
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 当前选中值
     * @type {any}
     * @memberof DropDownListMpicker
     */
    @Model('change') readonly itemValue!: any;

    /**
     * 代码表标识
     *
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop() public tag?: string;

    /**
     * 代码表类型
     *
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop() public codelistType?: string;

    /**
     * 代码表值分隔符
     *
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop({default:','}) public valueSeparator?: string;

    /**
     * 是否禁用
     * @type {any}
     * @memberof DropDownListMpicker
     * 
     */
    @Prop() public disabled?: any;

    /**
     * 是否支持过滤
     * @type {boolean}
     * @memberof DropDownListMpicker
     */
    @Prop() public filterable?: boolean;

    /**
     * 下拉选提示内容
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop() public placeholder?: string;

    /**
     * 局部上下文导航参数
     * 
     * @type {any}
     * @memberof DropDownListMpicker
     */
    @Prop() public localContext!:any;

    /**
     * 局部导航参数
     * 
     * @type {any}
     * @memberof DropDownListMpicker
     */
    @Prop() public localParam!:any;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop() public viewparams!: any;

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop() public data?: any;

    /**
     * 计算属性(当前值)
     * @type {any}
     * @memberof DropDownListMpicker
     */
    set currentVal(val: any) {
        const type: string = this.$util.typeOf(val);
        val = Object.is(type, 'null') || Object.is(type, 'undefined') ? [] : val;
        let value = val.length > 0 ? val.join(this.valueSeparator) : '';
        this.$emit('change', value);
    }

    /**
     * 获取值对象
     *
     * @memberof DropDownListMpicker
     */
    get currentVal() {
        return this.itemValue? this.itemValue.split(this.valueSeparator):[];
    }

    /**
     * 代码表
     *
     * @type {any[]}
     * @memberof DropDownListMpicker
     */
    public items: any[] = [];

    /**
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof DropDownList
     */
    public handlePublicParams(arg: any) {
        // 合并表单参数
        arg.param = this.viewparams ? JSON.parse(JSON.stringify(this.viewparams)) : {};
        arg.context = this.context ? JSON.parse(JSON.stringify(this.context)) : {};
        // 附加参数处理
        if (this.localContext && Object.keys(this.localContext).length >0) {
            let _context = this.$util.computedNavData(this.data,arg.context,arg.param,this.localContext);
            Object.assign(arg.context,_context);
        }
        if (this.localParam && Object.keys(this.localParam).length >0) {
            let _param = this.$util.computedNavData(this.data,arg.param,arg.param,this.localParam);
            Object.assign(arg.param,_param);
        }
    }

    /**
     * vue  生命周期
     *
     * @memberof DropDownListMpicker
     */
    public created() {
      if(this.tag && Object.is(this.codelistType,"STATIC")){
          const codelist = this.$store.getters.getCodeList(this.tag);
          if (codelist) {
              this.items = [...JSON.parse(JSON.stringify(codelist.items))];
          } else {
              console.log(`----${this.tag}----代码表不存在`);
          }
      }else if(this.tag && Object.is(this.codelistType,"DYNAMIC")){
          // 公共参数处理
          let data: any = {};
          this.handlePublicParams(data);
          // 参数处理
          let _context = data.context;
          let _param = data.param;
          this.codeListService.getItems(this.tag,_context,_param).then((res:any) => {
              this.items = res;
          }).catch((error:any) => {
              console.log(`----${this.tag}----代码表不存在`);
          });
      }
    }
    
    /**
     * 下拉点击事件
     *
     * @param {*} $event
     * @memberof DropDownListMpicker
     */
    public onClick($event:any){
        if(this.tag && Object.is(this.codelistType,"DYNAMIC")){
            // 公共参数处理
            let data: any = {};
            this.handlePublicParams(data);
            // 参数处理
            let _context = data.context;
            let _param = data.param;
            this.codeListService.getItems(this.tag,_context,_param).then((res:any) => {
                this.items = res;
            }).catch((error:any) => {
                console.log(`----${this.tag}----代码表不存在`);
            });
        }
    }

}
</script>

<style lang='less'>
@import './dropdown-list-mpicker.less';
</style>