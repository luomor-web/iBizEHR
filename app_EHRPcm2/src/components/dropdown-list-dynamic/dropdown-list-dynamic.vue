<template>
    <i-select
        class='dropdown-list-dynamic'
        :transfer="true"
        v-model="currentVal"
        :disabled="disabled === true ? true : false"
        :clearable="true"
        :filterable="filterable === true ? true : false"
        @on-open-change="onClick"
        :placeholder="$t('components.dropDownListDynamic.placeholder')">
        <i-option v-for="(item, index) in items" :key="index" :value="item.value">{{($t('userCustom.'+tag+'.'+item.value)!== ('userCustom.'+tag+'.'+item.value))?$t('userCustom.'+tag+'.'+item.value) : item.text}}</i-option>
    </i-select>
</template>

<script lang="ts">
import { Vue, Component, Watch, Prop, Model } from 'vue-property-decorator';
import CodeListService from "@service/app/codelist-service";

@Component({
})
export default class DropDownListDynamic extends Vue {
    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof DropDownListDynamic
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 额外参数
     *
     * @type {*}
     * @memberof DropDownListDynamic
     */
    public otherParam:any;

    /**
     * 查询参数
     * @type {*}
     * @memberof DropDownListDynamic
     */
    public queryParam:any;

    /**
     * 当前选中值
     * @type {any}
     * @memberof DropDownListDynamic
     */
    @Model('change') readonly itemValue!: any;

    /**
     * 代码表标识
     *
     * @type {string}
     * @memberof DropDownListDynamic
     */
    @Prop() public tag?: string;

    /**
     * 代码表类型
     *
     * @type {string}
     * @memberof DropDownListDynamic
     */
    @Prop() public codelistType?: string;

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof DropDownListDynamic
     */
    @Prop() public data?: any;

  /**
     * 监听表单数据
     *
     * @memberof DropDownListDynamic
     */    
    @Watch('data',{ deep: true })
    onDataChange(newVal: any, val: any){
        if(newVal){
            
        }
    }

    /**
     * 传入额外参数
     *
     * @type {*}
     * @memberof DropDownListDynamic
     */
    @Prop() public itemParam?: any;

    /**
     * 是否禁用
     * @type {any}
     * @memberof DropDownListDynamic
     * 
     */
    @Prop() public disabled?: any;

    /**
     * 是否支持过滤
     * @type {boolean}
     * @memberof DropDownListDynamic
     */
    @Prop() public filterable?: boolean;

    /**
     * 下拉选提示内容
     * @type {string}
     * @memberof DropDownListDynamic
     */
    @Prop() public placeholder?: string;


    /**
     * 计算属性(当前值)
     * @type {any}
     * @memberof DropDownListDynamic
     */
    set currentVal(val: any) {
        const type: string = this.$util.typeOf(val);
        val = Object.is(type, 'null') || Object.is(type, 'undefined') ? undefined : val;
        this.$emit('change', val);
    }

    /**
     * 获取值对象
     *
     * @memberof DropDownListDynamic
     */
    get currentVal() {
        return this.itemValue;
    }

    /**
     * 代码表
     *
     * @type {any[]}
     * @memberof DropDownListDynamic
     */
    public items: any[] = [];

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppAutocomplete
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
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof DropDownListDynamic
     */
    public handlePublicParams(arg: any) {
        // 合并表单参数
        arg.param = this.viewparams ? JSON.parse(JSON.stringify(this.viewparams)) : {};
        arg.context = this.context ? JSON.parse(JSON.stringify(this.context)) : {};
        // 附加参数处理
        if (this.itemParam.context) {
          let _context = this.$util.formatData(this.data,arg.context,this.itemParam.context);
            Object.assign(arg.context,_context);
        }
        if (this.itemParam.param) {
          let _param = this.$util.formatData(this.data,arg.param,this.itemParam.param);
            Object.assign(arg.param,_param);
        }
    }

    /**
     * vue  生命周期
     *
     * @memberof DropDownListDynamic
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
     * @memberof DropDownListDynamic
     */
    public onClick($event:any){
        if($event){
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

}
</script>

<style lang='less'>
@import './dropdown-list-dynamic.less';
</style>