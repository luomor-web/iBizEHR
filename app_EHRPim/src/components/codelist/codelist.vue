<template>
    <div class="codelist">
        <span v-if="ifEmpty">{{$t('codelist.'+tag+'.empty')}}</span>
        <template v-if="!ifEmpty">
          <template v-for="(item, index) in items">
              <span>{{ index != 0 ? textSeparator : ''}}</span>
              <i v-if="item.iconCls" :class="item.iconCls"></i>
              <span :class="item.textCls" :style="{color:item.color}">{{isUseLangres ? $t(item.text) : item.text}}</span>
          </template>
        </template>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model, Watch } from 'vue-property-decorator';
import CodeListService from "@service/app/codelist-service";

@Component({})
export default class CodeList extends Vue {
    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof CodeList
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 代码表标识
     *
     * @type {string}
     * @memberof CodeList
     */
    @Prop() public tag!: string;

    /**
     * 代码表类型
     *
     * @type {string}
     * @memberof AppCheckBox
     */
    @Prop() public codelistType?: string;

    /**
     * 当前值
     * @type {any}
     * @memberof SelectPicker
     * 
     */
    @Prop() public value?: string;

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
    @Prop({default:'、'}) public textSeparator?: string;

    /**
     * 值分隔符
     * @type {boolean}
     * @memberof SelectPicker
     */
    @Prop({default:','}) public valueSeparator?: string;

    /**
     * 是否为空
     *
     * @memberof CodeList
     */
    public ifEmpty:boolean = false;

    /**
     * 显示数据集合
     *
     * @type {any[]}
     * @memberof CodeList
     */
    public items: any[] = [];

    /**
     * vue  生命周期
     *
     * @memberof CodeList
     */
    public created() {
        this.dataHandle();
    }

    /**
     * 是否使用多语言资源
     * @type {boolean}
     * @memberof CodeList
     */
    public isUseLangres:boolean = false;

   /**
     * 数据值变化
     *
     * @param {*} newval
     * @param {*} val
     * @returns
     * @memberof CodeList
     */
    @Watch('value')
    public onValueChange(newVal: any, oldVal: any) {
        this.dataHandle();

    }

    /**
     * 数据处理
     *
     * @memberof CodeList
     */
    private dataHandle(){
      this.isUseLangres = false;
      let _this = this;
      // 空值判断
      if(Object.is(this.$util.typeOf(this.value), 'undefined') || Object.is(this.$util.typeOf(this.value), 'null')){
          this.ifEmpty = true;
          return;
      }
      this.ifEmpty = false;
      // 动态代码表处理
      if (Object.is(this.codelistType, "DYNAMIC")) {
          this.codeListService.getItems(this.tag).then((res: any) => {
              let items = res;
              _this.setItems(items, _this);
          }).catch((error: any) => {
              console.log(`----${_this.tag}----代码表不存在`);
          });
      // 静态处理
      } else if(Object.is(this.codelistType, "STATIC")){
          this.isUseLangres = true;
          let items = this.$store.getters.getCodeListItems(this.tag);
          _this.setItems(items, _this);
      }
    }

    /**
     * 解析代码表和vlaue，设置items
     *
     * @private
     * @param {any[]} items 代码表数据
     * @param {*} value
     * @returns {*}
     * @memberof CodeList
     */
    private setItems(items: any[], _this: any){
        if (items) {
            let result:any = [];
            if(Object.is(_this.renderMode,"NUM")){
                _this.isUseLangres = false;
                items.map((_item: any, index: number)=>{
                    const nValue = parseInt((_this.value as any), 10);
                    const codevalue = _item.value;
                    if((parseInt(codevalue, 10) & nValue) > 0){
                        result.push(_item);
                    } 
                });
            } else {
                let values: any[] = Object.is(_this.$util.typeOf(_this.value), 'number') ? [_this.value] : [...(_this.value as any).split(_this.valueSeparator)];
                values.map((value:any ,index: number)=>{
                    const item = _this.getItem(items, value); 
                    if(item){
                      result.push(item);
                    } 
                });
            }
            // 设置items
            if(result.length != 0){
                _this.items = result;
            }else{
                _this.items = [{text:_this.value}];
            }
        }
    }

    /**
     * 获取代码项
     *
     * @private
     * @param {any[]} items
     * @param {*} value
     * @returns {*}
     * @memberof CodeList
     */
    private getItem(items: any[], value: any): any {
        let result: any = {};
        const arr: Array<any> = items.filter(item => {return item.value == value});
        if (arr.length !== 1) {
            return undefined;
        }
        result = { ...arr[0] };
        if(Object.is(this.codelistType,'STATIC')){
            let value = JSON.parse(JSON.stringify(result));
            value.text = 'codelist.'+this.tag+'.'+value.value;
            return value;
        }else{
            return result;
        }
    }

}
</script>

<style lang='less'>
  .codelist {
    white-space: nowrap;
    text-overflow: ellipsis;
    word-break: break-all;
    overflow: hidden;
  }
</style>