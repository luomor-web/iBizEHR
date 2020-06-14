<template>
    <div>
        <div style="position: relative;width: 100%;">
            <el-select :value="value" multiple filterable remote :remote-method="onSearch" size="small" style="width:100%;" @change="onSelect" @remove-tag="onRemove" :disabled="disabled">
                <el-option v-for="(item, index) in items" :key="index" :label="item[deMajorField]" :value="item[deKeyField]"></el-option>
            </el-select>
            <span style="position: absolute;right: 5px;color: #c0c4cc;top: 0;font-size: 13px;">
                <i class="el-icon-search" @click="openView"></i>
            </span>
        </div>
    </div>
</template>
<script lang = 'ts'>
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { AppModal } from '@/utils';

@Component({
})
export default class AppMpicker extends Vue {

    /**
     * 传入url
     */
    @Prop() url?: any;

    /**
     * 表单数据
     */
    @Prop() activeData?: any;

    /**
     * 是否禁用
     */
    @Prop() disabled?: boolean;

    /**
     * 编辑器参数
     */
    @Prop() editorParams?: any;

    /**
     * 表单项值
     */
    @Prop() curvalue?: any;

    /**
     * 局部上下文导航参数
     * 
     * @type {any}
     * @memberof AppMpicker
     */
    @Prop() public localContext!:any;

    /**
     * 局部导航参数
     * 
     * @type {any}
     * @memberof AppMpicker
     */
    @Prop() public localParam!:any;

    /**
     * 表单项名称
     */
    @Prop() name: any;
    
    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop() public viewparams!: any;

    /**
     * AC参数
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop({default: () => {}}) public acParams?: any;

    /**
     * 应用实体主信息属性名称
     *
     * @type {string}
     * @memberof AppMpicker
     */
    @Prop({default: 'srfmajortext'}) public deMajorField!: string;

    /**
     * 应用实体主键属性名称
     *
     * @type {string}
     * @memberof AppMpicker
     */
    @Prop({default: 'srfkey'}) public deKeyField!: string;

    /**
     * 表单服务
     *
     * @type {*}
     * @memberof AppMpicker
     */
    @Prop() public service?: any;

    /**
     * 打开对应的选择视图
     */
    @Prop() pickupView?: any;

    /**
     * 当前表单项绑定值key的集合
     */
    public value: any = [];

    /**
     * 所有操作过的下拉选选项
     */
    public items: Array<any> = [];

    /**
     * 选中项key-value键值对
     * 
     */
    public selectItems: Array<any> = [];

    /**
     * 监听curvalue值
     * @param newVal 
     * @param val 
     */
    @Watch('curvalue', {immediate:true, deep: true })
    oncurvalueChange(newVal: any, val: any) {
        this.value = [];
        this.selectItems = [];
        if (newVal) {
            this.selectItems = this.parseValue(JSON.parse(newVal));
            this.selectItems.forEach((item: any) => {
                this.value.push(item[this.deKeyField]);
                let index = this.items.findIndex((i) => Object.is(i[this.deKeyField], item[this.deKeyField]));
                if (index < 0) {
                    this.items.push({ [this.deMajorField]: item[this.deMajorField], [this.deKeyField]: item[this.deKeyField] });
                }
            });
        }
        this.$forceUpdate();
    }

    /**
     * 远程执行搜索
     *
     * @param {*} query
     * @memberof AppMpicker
     */
    public onSearch(query: any) {
        // 公共参数处理
        let data: any = {};
        const bcancel: boolean = this.handlePublicParams(data);
        if (!bcancel) {
            return;
        }
        // 参数处理
        let _context = data.context;
        let _param = data.param;
        Object.assign(_param ,{ query: query });
        if (this.activeData) {
            Object.assign(_param, { srfreferdata: this.activeData });
        }
        // 错误信息国际化
        let error: string = (this.$t('components.appMpicker.error') as any);
        let miss: string = (this.$t('components.appMpicker.miss') as any);
        let requestException: string = (this.$t('components.appMpicker.requestException') as any);
        if(!this.service){
            this.$Notice.error({ title: error, desc: miss+'service' });
        } else if(!this.acParams.serviceName) {
            this.$Notice.error({ title: error, desc: miss+'serviceName' });
        } else if(!this.acParams.interfaceName) {
            this.$Notice.error({ title: error, desc: miss+'interfaceName' });
        } else {
          this.service.getItems(this.acParams.serviceName,this.acParams.interfaceName, _context, _param).then((response: any) => {
              if (!response) {
                  this.$Notice.error({ title: error, desc: requestException });
              } else {
                  this.items = [...response];
              }
          }).catch((error: any) => {
              console.log(error);
          });
        }
    }

    /**
     * 下拉选中回调
     *
     * @param {*} selects
     * @memberof AppMpicker
     */
    public onSelect(selects: any) {
        let val: Array<any> = [];
        if (selects.length > 0) {
            selects.forEach((select: any) => {
                let index = this.items.findIndex((item) => Object.is(item[this.deKeyField], select));
                if (index >= 0) {
                    let item = this.items[index];
                    val.push({ [this.deKeyField]: item[this.deKeyField], [this.deMajorField]: item[this.deMajorField] });
                } else {
                    index = this.selectItems.findIndex((item: any) => Object.is(item[this.deKeyField], select));
                    if (index >= 0) {
                        let item = this.selectItems[index];
                        val.push(item);
                    }
                }
            });
            let value = val.length > 0 ? JSON.stringify(this.formatValue(val)) : '';
            this.$emit('formitemvaluechange', { name: this.name, value: value });
        }
    }

    /**
     * 移除标签回调
     *
     * @param {*} tag
     * @memberof AppMpicker
     */
    public onRemove(tag: any) {
        let index = this.selectItems.findIndex((item: any) => Object.is(item[this.deKeyField], tag));
        if (index >= 0) {
            this.selectItems.splice(index, 1);
            let value = this.selectItems.length > 0 ? JSON.stringify(this.formatValue(this.selectItems)) : '';
            this.$emit('formitemvaluechange', { name: this.name, value: value });
        }
    }

    /**
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof AppMpicker
     */
    public handlePublicParams(arg: any): boolean {
        if (!this.activeData) {
            this.$Notice.error({ title: (this.$t('components.AppMpicker.error') as any), desc: (this.$t('components.AppMpicker.formdataException') as any) });
            return false;
        }
        // 合并表单参数
        arg.param = this.viewparams ? JSON.parse(JSON.stringify(this.viewparams)) : {};
        arg.context = this.context ? JSON.parse(JSON.stringify(this.context)) : {};
        // 附加参数处理
        if (this.localContext && Object.keys(this.localContext).length >0) {
            let _context = this.$util.computedNavData(this.activeData,arg.context,arg.param,this.localContext);
            Object.assign(arg.context,_context);
        }
        if (this.localParam && Object.keys(this.localParam).length >0) {
            let _param = this.$util.computedNavData(this.activeData,arg.param,arg.param,this.localParam);
            Object.assign(arg.param,_param);
        }
        return true;
    }

    /**
     * 打开视图
     *
     * @returns
     * @memberof AppMpicker
     */
    public openView() {
        if (this.disabled) {
            return;
        }
        if (this.pickupView && Object.keys(this.pickupView).length > 0) {
            // 参数处理
            const view = { ...this.pickupView };
            // 公共参数处理
            let data: any = {};
            const bcancel: boolean = this.handlePublicParams(data);
            if (!bcancel) {
                return;
            }
            // 参数处理
            let _context = data.context;
            let _viewparams = data.param;
            let _selectItems = JSON.parse(JSON.stringify(this.selectItems));
            if(!Object.is(this.deKeyField,"srfkey")){
                _selectItems.forEach((item:any, index:number)=>{
                    _selectItems[index].srfkey = item[this.deKeyField];
                });
            }
            _context = Object.assign(_context, { srfparentdata: { srfparentkey: this.activeData[this.deKeyField] }, });
            _viewparams = Object.assign(_viewparams,{ selectedData: [..._selectItems]});
            let formdata = this.activeData;
            const modal: Subject<any> = this.$appmodal.openModal(view, _context, _viewparams)
            modal.subscribe((result: any) => {
                if (!result || !Object.is(result.ret, 'OK')) {
                    return;
                }
                let selects: Array<any> = [];
                if (result.datas && Array.isArray(result.datas)) {
                    result.datas.forEach((select: any) => {
                        selects.push({ [this.deKeyField]: select[this.deKeyField], [this.deMajorField]: select[this.deMajorField] });
                        let index = this.items.findIndex((item) => Object.is(item[this.deKeyField], select[this.deKeyField]));
                        if (index < 0) {
                            this.items.push({ [this.deMajorField]: select[this.deMajorField], [this.deKeyField]: select[this.deKeyField] });
                        }
                    });
                }
                if (this.name && this.activeData) {
                    let value = selects.length > 0 ? JSON.stringify(this.formatValue(selects)) : '';
                    this.$emit('formitemvaluechange', { name: this.name, value: value });
                }
            })
        }
    }

    /**
     * 解析值,把srfkey和srfmajortext解析成实体属性名
     *
     * @param {any[]} value 需要转换的数组
     * @memberof AppMpicker
     */
    public parseValue(value: any[]){
        let result = [];
        if(this.deKeyField !== "srfkey" || this.deMajorField !== "srfmajortext"){
            value.forEach((item: any) => {
                result.push({[this.deMajorField]: item.srfmajortext, [this.deKeyField]: item.srfkey});
            });
        }else{
            result = value;
        }
        return result;
    }

    /**
     * 格式化值，把实体属性名格式化成srfkey和srfmajortext
     *
     * @param {any[]} value 需要转换的数组
     * @memberof AppMpicker
     */
    public formatValue(value: any[]){
        let result = [];
        if(this.deKeyField !== "srfkey" || this.deMajorField !== "srfmajortext"){
            value.forEach((item: any) => {
                result.push({srfmajortext : item[this.deMajorField], srfkey : item[this.deKeyField]});
            });
        }else{
            result = value;
        }
        return result;
    }


}
</script>
<style lang="less">
@import './app-mpicker.less';
</style>