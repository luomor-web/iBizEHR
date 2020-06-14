<template>
    <div class="app-picker-select-view">
        <Dropdown :visible="visible" trigger="custom" style="left:0px;width: 100%" @on-clickoutside="() => {triggerMenu(false);}" >
          <Input v-if="isSingleSelect" v-model="queryValue" class="tree-input" type="text" :placeholder="placeholder ? placeholder : $t('components.appPickerSelectView.placeholder')" :disabled="disabled" @on-change="OnInputChange" @on-focus="()=>{triggerMenu(true);}" >
              <template v-slot:suffix>
                  <i v-if="queryValue && !disabled" class='el-icon-circle-close' @click="onClear"></i>
                  <Icon :type="visible ? 'ios-arrow-up' : 'ios-arrow-down'" class="icon-arrow" @click="() => {triggerMenu();}"></Icon>
                  <icon v-if="linkview" type="ios-open-outline" @click="openLinkView"/>
              </template>
          </Input>
          <el-select v-if="!isSingleSelect" popper-class="select-no-dropdown" :value="keySet" multiple filterable remote :remote-method="($event) => {this.queryValue = $event;}" size="small" style="width:100%;" @change="onSelectChange" @focus="() => {triggerMenu(true);}" :disabled="disabled">
                <el-option v-for="(item, index) in items" :key="index" :label="item.srfmajortext" :value="item[deKeyField]"></el-option>
          </el-select>
          <DropdownMenu slot="list">
              <component
                :is="pickupView.viewname"
                :viewdata="viewdata"
                :viewparam="viewparam"
                :isShowButton="false"
                :viewDefaultUsage="false"
                @viewdataschange="onViewdatasChange"
                style="height:100%;">
              </component>
          </DropdownMenu>
        </Dropdown>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ViewTool } from '@/utils/view-tool/view-tool';

@Component({
})
export default class AppPickerSelectView extends Vue {
    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppPickerSelectView
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppPickerSelectView
     */
    @Prop() public viewparams!: any;

    /**
     * 是否单选
     *
     * @type {*}
     * @memberof AppPickerSelectView
     */
    @Prop({default: 'true'}) public isSingleSelect!: any;
    
    /**
     * 当前多选框选中值的key集合
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    public keySet: any = [];
    
    /**
     * 当前多选框选中项对象集合
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    public selectItems: Array<any> = [];
    
    /**
     * 所有操作过的下拉选项对象集合
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    public items: Array<any> = [];
    
    /**
     * 视图参数
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    public viewparam: any = JSON.stringify(this.viewparams);
    
    /**
     * 视图上下文
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    public viewdata: any = JSON.stringify(this.context);

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppPickerSelectView
     */
    @Prop() public data!: any;

    /**
     * 值
     *
     * @type {*}
     * @memberof AppPickerSelectView
     */
    @Prop() public value: any;

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof AppPickerSelectView
     */
    @Prop({default: false}) public disabled!: boolean;
    
    /**
     * 应用实体主信息属性名称
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    @Prop({default: 'srfmajortext'}) public deMajorField!: string;

    /**
     * 应用实体主键属性名称
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    @Prop({default: 'srfkey'}) public deKeyField!: string;

    /**
     * 输入框值(搜索值)
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    public queryValue: any = '';

    /**
     * 值项名称
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    @Prop() public valueitem!: string;

    /**
     * 关联视图名称
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    @Prop() public pickupView?: any;

    /**
     * 数据链接视图参数
     *
     * @type {*}
     * @memberof AppPickerSelectView
     */
    @Prop() public linkview?: any;

    /**
     * 提示信息
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    @Prop() public placeholder!: string;

    /**
     * 属性项名称
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    @Prop() public name!: string;

    /**
     * 局部上下文导航参数
     * 
     * @type {any}
     * @memberof AppPickerSelectView
     */
    @Prop() public localContext!:any;

    /**
     * 局部导航参数
     * 
     * @type {any}
     * @memberof AppPickerSelectView
     */
    @Prop() public localParam!:any;

    /**
     * 下拉显示控制变量
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    public visible: boolean = false;

    /**
     * 父视图数据
     *
     * @type {string}
     * @memberof AppPickerSelectView
     */
    public srfparentdata: any = {};

    /**
     * 输入框change事件
     * 
     * @param $event 事件对象
     * @memberof AppPickerSelectView
     */
    public OnInputChange($event: any){
        let _viewdata =  Object.assign({ query: this.queryValue }, JSON.parse(this.viewdata)) ;
        this.viewdata = JSON.stringify(_viewdata);
    }

    /**
     * 输入框change事件
     * 
     * @param $event 事件对象
     * @memberof AppPickerSelectView
     */
    public triggerMenu(visible?: boolean){
        if(this.disabled){
          return;
        }
        if (!visible) {
            this.visible = !this.visible;
        } else {
            this.visible = visible;
        }
    }

    /**
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof AppPickerSelectView
     */
    public handlePublicParams(arg: any): boolean {
        if (!this.data) {
            this.$Notice.error({ title: (this.$t('components.appPickerSelectView.error') as any), desc: (this.$t('components.appPickerSelectView.formdataException') as any) });
            return false;
        }
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
        return true;
    }

    /**
     * 监控值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPickerSelectView
     */
    @Watch('data',{deep:true})
    onActivedataChange(newVal: any, oldVal: any) {
        // 公共参数处理
        let data: any = {};
        const bcancel: boolean = this.handlePublicParams(data);
        if (!bcancel) {
            return;
        }
        // 参数处理
        this.viewdata = JSON.stringify(data.context);
        this.viewparam = JSON.stringify(data.param);
    }

    /**
     * 值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPickerSelectView
     */
    @Watch('value', { deep: true })
    public onValueChange(newVal: any, oldVal: any) {
        if(this.isSingleSelect){
            this.queryValue = newVal;
            if (!this.data || !this.valueitem || !this.data[this.valueitem]) {
                this.$Notice.error({ title: (this.$t('components.appPickerSelectView.error') as any), desc: (this.$t('components.appPickerSelectView.editor') as any)+this.name+(this.$t('components.appPickerSelectView.valueitemException') as any) });
            }else{
                let _viewparam = JSON.parse(this.viewparam);
                _viewparam.selectedData = [{srfkey: this.data[this.valueitem], srfmajortext: this.value }];
                this.viewparam = JSON.stringify(_viewparam);
            }
        }else{
            this.keySet = [];
            this.selectItems = [];
            if (newVal) {
                this.selectItems = JSON.parse(newVal);
                this.selectItems.forEach((item: any) => {
                    this.keySet.push(item.srfkey);
                    let index = this.items.findIndex((i) => Object.is(i.srfkey, item.srfkey));
                    if (index < 0) {
                        this.items.push({ srfmajortext : item.srfmajortext, srfkey: item.srfkey });
                    }
                });
                let _viewparam = JSON.parse(this.viewparam);
                _viewparam.selectedData = this.selectItems;
                this.viewparam = JSON.stringify(_viewparam);
            }
        }
        this.$forceUpdate();
    }

    /**
     * 生命周期
     *
     * @memberof AppPickerSelectView
     */
    public created() {
        // 公共参数处理
        let data: any = {};
        const bcancel: boolean = this.handlePublicParams(data);
        if (!bcancel) {
            return;
        }
        // 参数处理
        this.viewdata = JSON.stringify(data.context);
        this.viewparam = JSON.stringify(data.param);
    }

    /**
     * vue 生命周期
     *
     * @memberof AppPickerSelectView
     */
    public destroyed() {

    }

    /**
     * 设置值
     *
     * @param {*} item
     * @memberof AppPickerSelectView
     */
    public onViewdatasChange($event: any) {
        if($event.length == 0){
            this.onClear(null);
            return;
        }
        if(this.isSingleSelect){
             this.visible = false;
            if (this.valueitem) {
                let tempvalue = $event[0][this.deKeyField] ? $event[0][this.deKeyField] : $event[0].srfkey;
                this.$emit('formitemvaluechange', { name: this.valueitem, value: tempvalue });
            }
            if (this.name) {
                let tempvalue = $event[0][this.deMajorField] ? $event[0][this.deMajorField] : $event[0].srfmajortext;
                this.$emit('formitemvaluechange', { name: this.name, value: tempvalue });
            }
        }else{
            let selects: Array<any> = [];
            if ($event && Array.isArray($event)) {
                $event.forEach((select: any) => {
                    selects.push({ srfkey: select.srfkey, srfmajortext: select.srfmajortext });
                    let index = this.items.findIndex((item) => Object.is(item.srfkey, select.srfkey));
                    if (index < 0) {
                        this.items.push({ srfmajortext : select.srfmajortext, srfkey: select.srfkey });
                    }
                });
            }
            if (this.name) {
                let value = selects.length > 0 ? JSON.stringify(selects) : '';
                this.$emit('formitemvaluechange', { name: this.name, value: value });
            }
        }
    }

    /**
     * 清除
     */
    public onClear($event: any): void {
        if (this.valueitem) {
            this.$emit('formitemvaluechange', { name: this.valueitem, value: '' });
        }
        if (this.name) {
            this.$emit('formitemvaluechange', { name: this.name, value: '' });
        }
        this.$forceUpdate();
    }

    
    /**
     * 打开链接视图
     *
     * @memberof AppPickerSelectView
     */
    public openLinkView($event: any): void {
        if (!this.data || !this.valueitem || !this.data[this.valueitem]) {
            console.error({ title: (this.$t('components.appPickerSelectView.error') as any), desc: (this.$t('components.appPickerSelectView.editor') as any)+this.name+(this.$t('components.appPickerSelectView.valueitemException') as any) });
            return;
        }
        // 公共参数处理
        let data: any = {};
        const bcancel: boolean = this.handlePublicParams(data);
        if (!bcancel) {
            return;
        }
        // 参数处理
        let _context = data.context;
        let _param = data.param;
        Object.assign(_context, { [this.deKeyField]: this.data[this.valueitem] });
        const view = JSON.parse(JSON.stringify(this.linkview));
        const viewname2: string = this.$util.srfFilePath2(view.viewname);
        view.viewname = viewname2;

        if (Object.is(view.placement, 'INDEXVIEWTAB') || Object.is(view.placement, '')) {
            this.openIndexViewTab(view, _context, _param);
        } else if (Object.is(view.placement, 'POPOVER')) {
            this.openPopOver($event, view, _context, _param);
        } else if (Object.is(view.placement, 'POPUPMODAL')) {
            this.openPopupModal(view, _context, _param);
        } else if (view.placement.startsWith('DRAWER')) {
            this.openDrawer(view, _context, _param);
        }
    }

    /**
     * 路由模式打开视图
     *
     * @private
     * @param {string} viewpath
     * @param {*} data
     * @memberof AppPickerSelectView
     */
    private openIndexViewTab(view: any, context: any, param: any): void {
        const routePath = this.$viewTool.buildUpRoutePath(this.$route, this.context, view.deResParameters, view.parameters, [context] , param);
        this.$router.push(routePath);
    }

    /**
     * 气泡卡片模式打开
     *
     * @private
     * @param {*} $event
     * @param {*} view
     * @param {*} data
     * @memberof AppPickerSelectView
     */
    private openPopOver($event: any, view: any, context: any, param: any): void {
        let container: Subject<any> = this.$apppopover.openPop($event, view, context, param);
        container.subscribe((result: any) => {
            if (!result || !Object.is(result.ret, 'OK')) {
                return;
            }
            this.openViewClose(result);
        });
    }


    /**
     * 模态模式打开视图
     *
     * @private
     * @param {*} view
     * @param {*} data
     * @memberof AppPickerSelectView
     */
    private openPopupModal(view: any, context: any, param: any): void {
        let container: Subject<any> = this.$appmodal.openModal(view, context, param);
        container.subscribe((result: any) => {
            if (!result || !Object.is(result.ret, 'OK')) {
                return;
            }
            this.openViewClose(result);
        });
    }

    /**
     * 抽屉模式打开视图
     *
     * @private
     * @param {*} view
     * @param {*} data
     * @memberof AppPickerSelectView
     */
    private openDrawer(view: any, context: any, param: any): void {
        let container: Subject<any> = this.$appdrawer.openDrawer(view, context, param);
        container.subscribe((result: any) => {
            if (!result || !Object.is(result.ret, 'OK')) {
                return;
            }
            this.openViewClose(result);
        });
    }

    /**
     * 打开页面关闭
     *
     * @param {*} result
     * @memberof AppPickerSelectView
     */
    public openViewClose(result: any) {
        let item: any = {};
        if (result.datas && Array.isArray(result.datas)) {
            Object.assign(item, result.datas[0]);
        }

        if (this.data) {
            if (this.valueitem) {
                this.$emit('formitemvaluechange', { name: this.valueitem, value: item[this.deKeyField]?item[this.deKeyField]:item["srfkey"] });
            }
            if (this.name) {
                this.$emit('formitemvaluechange', { name: this.name, value: item[this.deMajorField]?item[this.deMajorField]:item["srfmajortext"] });
            }
        }
    }
    
    /**
     * 下拉选中回调
     *
     * @param {*} selects 当前选中的key值集合
     * @memberof AppPickerSelectView
     */
    public onSelectChange(selects: any) {
        let val: Array<any> = [];
        if (selects.length > 0) {
            selects.forEach((select: any) => {
                let index = this.items.findIndex((item) => Object.is(item[this.deKeyField], select));
                if (index >= 0) {
                    val.push(this.items[index]);
                }
            });
        }
        let value = val.length > 0 ? JSON.stringify(val) : '';
        this.$emit('formitemvaluechange', { name: this.name, value: value });
    }

}
</script>

<style lang='less'>
@import './app-picker-select-view.less';
</style>