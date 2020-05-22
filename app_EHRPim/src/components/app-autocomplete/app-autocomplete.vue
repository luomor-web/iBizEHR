<template>
    <el-autocomplete 
      class='text-value' 
      :value-key="deMajorField" 
      :disabled="disabled" 
      v-model="curvalue" 
      size='small'
      :trigger-on-focus="true" 
      :fetch-suggestions="onSearch" 
      @select="onACSelect"
      @input="onInput" 
      @blur="onBlur" 
      style='width:100%;'>
        <template v-slot:suffix>
            <i v-if="curvalue && !disabled" class='el-icon-circle-close' @click="onClear"></i>
            <i class="el-icon-arrow-down"></i>
        </template>
    </el-autocomplete>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';

@Component({
})
export default class AppAutocomplete extends Vue {

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppAutocomplete
     */
    @Prop() public data: any;

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
     * AC参数
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    @Prop({default: {}}) public acParams?: any;

    /**
     * 表单服务
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    @Prop() public service?: any;

    /**
     * 应用实体主信息属性名称
     *
     * @type {string}
     * @memberof AppAutocomplete
     */
    @Prop({default: 'srfmajortext'}) public deMajorField!: string;

    /**
     * 应用实体主键属性名称
     *
     * @type {string}
     * @memberof AppAutocomplete
     */
    @Prop({default: 'srfkey'}) public deKeyField!: string;

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof AppAutocomplete
     */
    @Prop() public disabled?: boolean;

    /**
     * 属性项名称
     *
     * @type {string}
     * @memberof AppAutocomplete
     */
    @Prop() public name!: string;

    /**
     * 编辑器参数
     *
     * @type {string}
     * @memberof AppAutocomplete
     */
    @Prop() public itemParam?: any;

    /**
     * 值项名称
     *
     * @type {string}
     * @memberof AppAutocomplete
     */
    @Prop() public valueitem?: string;

    /**
     * 值
     *
     * @type {*}
     * @memberof AppPicker
     */
    @Model('change') public value?: any;

    /**
     * 当前值
     *
     * @type {string}
     * @memberof AppPicker
     */
    public curvalue: string = '';

    /**
     * 远程请求url 地址
     *
     * @type {string}
     * @memberof AppAutocomplete
     */
    @Prop() public url?: string;

    /**
     * 数组
     *
     * @type {any[]}
     * @memberof AppAutocomplete
     */
    public items: any[] = [];

    /**
     * 输入状态
     *
     * @type {boolean}
     * @memberof AppAutocomplete
     */
    public inputState: boolean = false;

    /**
     * 值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPicker
     */
    @Watch('value')
    public onValueChange(newVal: any, oldVal: any) {
        this.curvalue = newVal;
    }

    /**
     * 执行搜索数据
     * @param query 
     * @param callback 
     */
    public onSearch(query: any, callback: any): void {
        // 处理搜索参数
        query = !query ? '' : query;
        if (!this.inputState && Object.is(query, this.value)) {
            query = '';
        }
        this.inputState = false;
        // 合并视图上下文参数和视图参数
        let param: any = JSON.parse(JSON.stringify(this.viewparams));
        let context: any = JSON.parse(JSON.stringify(this.context));
        Object.assign(param, { query: query });
        // 附加参数处理
        if (this.itemParam.context) {
            let _context = this.$util.formatData(this.data,this.itemParam.context);
            Object.assign(context,_context);
        }
        if (this.itemParam.param) {
            let _param = this.$util.formatData(this.data,this.itemParam.param);
            Object.assign(param,_param);
        }
        if (this.itemParam.parentdata) {
            let _parentdata = this.$util.formatData(this.data,this.itemParam.parentdata);
            Object.assign(param,_parentdata);
        }
        // 错误信息国际化
        let error: string = (this.$t('components.appAutocomplete.error') as any);
        let miss: string = (this.$t('components.appAutocomplete.miss') as any);
        let requestException: string = (this.$t('components.appAutocomplete.requestException') as any);

        if(!this.service){
            this.$Notice.error({ title: error, desc: miss+'service' });
        } else if(!this.acParams.serviceName) {
            this.$Notice.error({ title: error, desc: miss+'serviceName' });
        } else if(!this.acParams.interfaceName) {
            this.$Notice.error({ title: error, desc: miss+'interfaceName' });
        } else {
          this.service.getItems(this.acParams.serviceName,this.acParams.interfaceName, context, param).then((response: any) => {
              if (!response) {
                  this.$Notice.error({ title: error, desc: requestException });
              } else {
                  this.items = [...response];
              }
              if (callback) {
                  callback(this.items);
              }
          }).catch((error: any) => {
              if (callback) {
                  callback([]);
              }
          });
        } 
    }

    /**
     * 选中数据回调
     * @param item 
     */
    public onACSelect(item: any): void {
      if (this.name) {
          this.$emit('formitemvaluechange', { name: this.name, value: item[this.deMajorField] });
      }
      if (this.valueitem) {
          this.$emit('formitemvaluechange', { name: this.valueitem, value: item[this.deKeyField] });
      }
  }

    /**
     * 输入过程中
     *
     * @memberof AppAutocomplete
     */
    public onInput($event: any) {
        if (Object.is($event, this.value)) {
            this.inputState = true;
        }
    }

    /**
     * 失去焦点事件
     * @param e 
     */
    public onBlur(e: any): void {
        let val: string = e.target.value;
        if (!Object.is(val, this.value)) {
            this.onACSelect({ [this.deMajorField]: val, [this.deKeyField]: '' });
        }
        this.$forceUpdate();
    }

    /**
     * 清除
     */
    public onClear($event: any): void {
        if (this.name) {
            this.$emit('formitemvaluechange', { name: this.name, value: '' });
        }
        if (this.valueitem) {
            this.$emit('formitemvaluechange', { name: this.valueitem, value: '' });
        }
        this.$forceUpdate();
    }

}
</script>

<style lang='less'>
@import './app-autocomplete.less';
</style>