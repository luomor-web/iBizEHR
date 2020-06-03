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
            this.handleOtherParam();
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
     * 处理额外参数
     */
    public handleOtherParam(){
        if(this.itemParam){
            this.queryParam = {};
            this.otherParam = this.itemParam.parentdata;
            if(this.otherParam && Object.keys(this.otherParam).length >0){
                Object.keys(this.otherParam).forEach((item:any) =>{
                    let value: string | null = this.otherParam[item];
                    if (value && value.startsWith('%') && value.endsWith('%')) {
                        const key = value.substring(1, value.length - 1);
                        if (this.data && this.data.hasOwnProperty(key)) {
                            value = (this.data[key] !== null && this.data[key] !== undefined) ? this.data[key] : null;
                        } else {
                            value = null;
                        }
                    }
                    Object.assign(this.queryParam,{[item]:value});
                })
            }
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
          this.codeListService.getItems(this.tag,{},this.queryParam).then((res:any) => {
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
                this.codeListService.getItems(this.tag,{},this.queryParam).then((res:any) => {
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