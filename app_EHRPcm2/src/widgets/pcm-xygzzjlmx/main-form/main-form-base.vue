<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='pcmxygzzjlmx_main' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmxygzzjlmx.main_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="1" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.ygbh.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='ygbh' :itemRules="this.rules.ygbh" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.ygbh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ygbh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ygbh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ygbh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pimpersonname.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='pimpersonname' :itemRules="this.rules.pimpersonname" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.pimpersonname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimpersonname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.pimpersonname.disabled"
  name='pimpersonname'
  deMajorField='pimpersonname'
  deKeyField='pimperson'
  :service="service"
  :acParams="{ serviceName: 'PimPersonService', interfaceName: 'FetchDefault'}"
  valueitem='pimpersonid' 
  :value="data.pimpersonname" 
  editortype="" 
  :pickupView="{ viewname: 'pim-person-kxzxygpickup-view', title: $t('entities.pimperson.views.kxzxygpickupview.title'), deResParameters: [], parameters: [{ pathName: 'pimpeople', parameterName: 'pimperson' }, { pathName: 'kxzxygpickupview', parameterName: 'kxzxygpickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.zz.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='zz' :itemRules="this.rules.zz" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.zz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zz.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zz"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zz.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bm.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='bm' :itemRules="this.rules.bm" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.bm')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bm.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bm"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.bm.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.rzqd.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='rzqd' :itemRules="this.rules.rzqd" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.rzqd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rzqd.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.rzqd"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.rzqd.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zzgw.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='zzgw' :itemRules="this.rules.zzgw" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.zzgw')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zzgw.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zzgw"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zzgw.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmxygzzjlmx.main_form.details.grouppanel1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="1" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.pcmxygzzkhjgjlname.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='pcmxygzzkhjgjlname' :itemRules="this.rules.pcmxygzzkhjgjlname" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.pcmxygzzkhjgjlname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pcmxygzzkhjgjlname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.pcmxygzzkhjgjlname.disabled"
  name='pcmxygzzkhjgjlname'
  deMajorField='pcmxygzzkhjgjlname'
  deKeyField='pcmxygzzkhjgjl'
  :service="service"
  :acParams="{ serviceName: 'PcmXygzzkhjgjlService', interfaceName: 'FetchDefault'}"
  valueitem='pcmxygzzkhjgjlid' 
  :value="data.pcmxygzzkhjgjlname" 
  editortype="" 
  :pickupView="{ viewname: 'pcm-xygzzkhjgjl-pickup-view', title: $t('entities.pcmxygzzkhjgjl.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'pcmxygzzkhjgjls', parameterName: 'pcmxygzzkhjgjl' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.jssj.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='jssj' :itemRules="this.rules.jssj" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.jssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.jssj" :disabled="detailsModel.jssj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.jssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.qssj.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='qssj' :itemRules="this.rules.qssj" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.qssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.qssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.qssj" :disabled="detailsModel.qssj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.qssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zzsj.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='zzsj' :itemRules="this.rules.zzsj" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.zzsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zzsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.zzsj" :disabled="detailsModel.zzsj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.zzsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.fs.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='fs' :itemRules="this.rules.fs" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.fs')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fs.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.fs"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.fs.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pj.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='pj' :itemRules="this.rules.pj" class='' :caption="$t('entities.pcmxygzzjlmx.main_form.details.pj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pj.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.pj" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.pj.disabled"  
    tag='EhrCodeList0046' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>


    </row>
</i-form>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import PcmXygzzjlmxService from '@/service/pcm-xygzzjlmx/pcm-xygzzjlmx-service';
import MainService from './main-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class MainBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof MainBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof MainBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof MainBase
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof MainBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {MainService}
     * @memberof MainBase
     */
    public service: MainService = new MainService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PcmXygzzjlmxService}
     * @memberof MainBase
     */
    public appEntityService: PcmXygzzjlmxService = new PcmXygzzjlmxService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof MainBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof MainBase
     */
    public counterRefresh(){
        const _this:any =this;
        if(_this.counterServiceArray && _this.counterServiceArray.length >0){
            _this.counterServiceArray.forEach((item:any) =>{
                if(item.refreshData && item.refreshData instanceof Function){
                    item.refreshData();
                }
            })
        }
    }


    /**
     * 工作流审批意见控件绑定值
     *
     * @memberof MainBase
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof MainBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof MainBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof MainBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof MainBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof MainBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof MainBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof MainBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof MainBase
     */
    public data: any = {
        srfupdatedate: null,
        srforikey: null,
        srfkey: null,
        srfmajortext: null,
        srftempmode: null,
        srfuf: null,
        srfdeid: null,
        srfsourcekey: null,
        pcmxygzzsqid: null,
        ygbh: null,
        pimpersonname: null,
        zz: null,
        zzid: null,
        bm: null,
        bmid: null,
        rzqd: null,
        zzgw: null,
        pimpersonid: null,
        istemp: null,
        finished: null,
        checkstatus: null,
        pcmxygzzkhjgjlname: null,
        jssj: null,
        qssj: null,
        zzsj: null,
        fs: null,
        pj: null,
        pcmxygzzkhjgjlid: null,
        pcmxygzzjlmxid: null,
        pcmxygzzjlmx:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof MainBase
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof MainBase
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof MainBase
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof MainBase
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof MainBase
     */
    public rules: any = {
        srfupdatedate: [
            { type: 'string', message: '更新时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '更新时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '更新时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '更新时间 值不能为空', trigger: 'blur' },
        ],
        srforikey: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfkey: [
            { type: 'string', message: '试用期员工转正结果引用明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '试用期员工转正结果引用明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '试用期员工转正结果引用明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '试用期员工转正结果引用明细标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '试用期员工转正结果引用明细名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '试用期员工转正结果引用明细名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '试用期员工转正结果引用明细名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '试用期员工转正结果引用明细名称 值不能为空', trigger: 'blur' },
        ],
        srftempmode: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfuf: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfdeid: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfsourcekey: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        pcmxygzzsqid: [
            { type: 'string', message: '试用期员工转正申请标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '试用期员工转正申请标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '试用期员工转正申请标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '试用期员工转正申请标识 值不能为空', trigger: 'blur' },
        ],
        ygbh: [
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'blur' },
        ],
        pimpersonname: [
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
        ],
        zz: [
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'blur' },
        ],
        zzid: [
            { type: 'string', message: '组织ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织ID 值不能为空', trigger: 'blur' },
        ],
        bm: [
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'blur' },
        ],
        bmid: [
            { type: 'string', message: '部门ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门ID 值不能为空', trigger: 'blur' },
        ],
        rzqd: [
            { type: 'string', message: '入职渠道 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '入职渠道 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '入职渠道 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '入职渠道 值不能为空', trigger: 'blur' },
        ],
        zzgw: [
            { type: 'string', message: '转正岗位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '转正岗位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '转正岗位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '转正岗位 值不能为空', trigger: 'blur' },
        ],
        pimpersonid: [
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
        ],
        istemp: [
            { type: 'number', message: '是否为临时数据 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否为临时数据 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '是否为临时数据 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '是否为临时数据 值不能为空', trigger: 'blur' },
        ],
        finished: [
            { type: 'number', message: '是否完成 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否完成 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '是否完成 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '是否完成 值不能为空', trigger: 'blur' },
        ],
        checkstatus: [
            { type: 'string', message: '审核状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '审核状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '审核状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '审核状态 值不能为空', trigger: 'blur' },
        ],
        pcmxygzzkhjgjlname: [
            { type: 'string', message: '考核结果记录 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '考核结果记录 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '考核结果记录 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '考核结果记录 值不能为空', trigger: 'blur' },
        ],
        jssj: [
            { type: 'string', message: '试用期到期时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '试用期到期时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '试用期到期时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '试用期到期时间 值不能为空', trigger: 'blur' },
        ],
        qssj: [
            { type: 'string', message: '到公司时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '到公司时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '到公司时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '到公司时间 值不能为空', trigger: 'blur' },
        ],
        zzsj: [
            { type: 'string', message: '转正时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '转正时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '转正时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '转正时间 值不能为空', trigger: 'blur' },
        ],
        fs: [
            { type: 'number', message: '分数 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '分数 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '分数 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '分数 值不能为空', trigger: 'blur' },
        ],
        pj: [
            { type: 'string', message: '评价 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '评价 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '评价 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '评价 值不能为空', trigger: 'blur' },
        ],
        pcmxygzzkhjgjlid: [
            { type: 'string', message: '试用期员工转正考核结果记录标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '试用期员工转正考核结果记录标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '试用期员工转正考核结果记录标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '试用期员工转正考核结果记录标识 值不能为空', trigger: 'blur' },
        ],
        pcmxygzzjlmxid: [
            { type: 'string', message: '试用期员工转正结果引用明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '试用期员工转正结果引用明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '试用期员工转正结果引用明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '试用期员工转正结果引用明细标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof MainBase
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '员工信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmxygzzjlmx.main_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel1: new FormGroupPanelModel({ caption: '转正考核成绩', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmxygzzjlmx.main_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '试用期员工转正结果引用明细标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '试用期员工转正结果引用明细名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmxygzzsqid: new FormItemModel({ caption: '试用期员工转正申请标识', detailType: 'FORMITEM', name: 'pcmxygzzsqid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ygbh: new FormItemModel({ caption: '员工编号', detailType: 'FORMITEM', name: 'ygbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        pimpersonname: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'pimpersonname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 1 })
, 
        zz: new FormItemModel({ caption: '组织', detailType: 'FORMITEM', name: 'zz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        zzid: new FormItemModel({ caption: '组织ID', detailType: 'FORMITEM', name: 'zzid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bm: new FormItemModel({ caption: '部门', detailType: 'FORMITEM', name: 'bm', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        bmid: new FormItemModel({ caption: '部门ID', detailType: 'FORMITEM', name: 'bmid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        rzqd: new FormItemModel({ caption: '入职渠道', detailType: 'FORMITEM', name: 'rzqd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        zzgw: new FormItemModel({ caption: '转正岗位', detailType: 'FORMITEM', name: 'zzgw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        pimpersonid: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'pimpersonid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        istemp: new FormItemModel({ caption: '是否为临时数据', detailType: 'FORMITEM', name: 'istemp', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        finished: new FormItemModel({ caption: '是否完成', detailType: 'FORMITEM', name: 'finished', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        checkstatus: new FormItemModel({ caption: '审核状态', detailType: 'FORMITEM', name: 'checkstatus', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmxygzzkhjgjlname: new FormItemModel({ caption: '考核结果记录', detailType: 'FORMITEM', name: 'pcmxygzzkhjgjlname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jssj: new FormItemModel({ caption: '试用期到期时间', detailType: 'FORMITEM', name: 'jssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        qssj: new FormItemModel({ caption: '到公司时间', detailType: 'FORMITEM', name: 'qssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zzsj: new FormItemModel({ caption: '转正时间', detailType: 'FORMITEM', name: 'zzsj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        fs: new FormItemModel({ caption: '分数', detailType: 'FORMITEM', name: 'fs', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pj: new FormItemModel({ caption: '评价', detailType: 'FORMITEM', name: 'pj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmxygzzkhjgjlid: new FormItemModel({ caption: '试用期员工转正考核结果记录标识', detailType: 'FORMITEM', name: 'pcmxygzzkhjgjlid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmxygzzjlmxid: new FormItemModel({ caption: '试用期员工转正结果引用明细标识', detailType: 'FORMITEM', name: 'pcmxygzzjlmxid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfupdatedate')
    onSrfupdatedateChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfupdatedate', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srforikey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srforikey')
    onSrforikeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srforikey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfkey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfkey')
    onSrfkeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfkey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfmajortext 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfmajortext')
    onSrfmajortextChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfmajortext', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srftempmode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srftempmode')
    onSrftempmodeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srftempmode', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfuf 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfuf')
    onSrfufChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfuf', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfdeid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfdeid')
    onSrfdeidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfdeid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfsourcekey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmxygzzsqid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pcmxygzzsqid')
    onPcmxygzzsqidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmxygzzsqid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ygbh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ygbh')
    onYgbhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ygbh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pimpersonname')
    onPimpersonnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zz')
    onZzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zzid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zzid')
    onZzidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zzid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bm 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.bm')
    onBmChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bm', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bmid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.bmid')
    onBmidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bmid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rzqd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.rzqd')
    onRzqdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rzqd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zzgw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zzgw')
    onZzgwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zzgw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pimpersonid')
    onPimpersonidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 istemp 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.istemp')
    onIstempChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'istemp', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 finished 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.finished')
    onFinishedChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'finished', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 checkstatus 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.checkstatus')
    onCheckstatusChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'checkstatus', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmxygzzkhjgjlname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pcmxygzzkhjgjlname')
    onPcmxygzzkhjgjlnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmxygzzkhjgjlname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.jssj')
    onJssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 qssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.qssj')
    onQssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'qssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zzsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zzsj')
    onZzsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zzsj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 fs 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.fs')
    onFsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'fs', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pj')
    onPjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmxygzzkhjgjlid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pcmxygzzkhjgjlid')
    onPcmxygzzkhjgjlidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmxygzzkhjgjlid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmxygzzjlmxid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pcmxygzzjlmxid')
    onPcmxygzzjlmxidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmxygzzjlmxid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof MainBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
     * @memberof MainBase
      */
    public ResetData(_datas:any){
        if(Object.keys(_datas).length >0){
            Object.keys(_datas).forEach((name: string) => {
                if (this.data.hasOwnProperty(name)) {
                    this.data[name] = null;
                }
            });
        }
    }

    /**
     * 表单逻辑
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof MainBase
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                

































        if(Object.is(name, 'pimpersonid')){
            const details: string[] = ['ygbh', 'bmid', 'zzid', 'bm', 'zz', 'jssj', 'zzgw', 'qssj', 'rzqd'];
            this.updateFormItems('FillPersonInfo', this.data, details, true);
        }
    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof MainBase
     */
    public formDataChange({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
        if (this.ignorefieldvaluechange) {
            return;
        }
        this.resetFormData({ name: name, newVal: newVal, oldVal: oldVal });
        this.formLogic({ name: name, newVal: newVal, oldVal: oldVal });
        this.dataChang.next(JSON.stringify(this.data));
    }

    /**
     * 表单加载完成
     *
     * @public
     * @param {*} [data={}]
     * @param {string} [action]
     * @memberof MainBase
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.pcmxygzzjlmx){
            Object.assign(this.context,{pcmxygzzjlmx:data.pcmxygzzjlmx})
        }
        this.setFormEnableCond(data);
        this.fillForm(data,action);
        this.oldData = {};
        Object.assign(this.oldData, JSON.parse(JSON.stringify(this.data)));
        this.$store.commit('viewaction/setViewDataChange', { viewtag: this.viewtag, viewdatachange: false });
        this.formLogic({ name: '', newVal: null, oldVal: null });
    }

    /**
     * 值填充
     *
     * @param {*} [_datas={}]
     * @param {string} [action]
     * @memberof MainBase
     */
    public fillForm(_datas: any = {},action:string): void {
        this.ignorefieldvaluechange = true;
        Object.keys(_datas).forEach((name: string) => {
            if (this.data.hasOwnProperty(name)) {
                this.data[name] = _datas[name];
            }
        });
        if(Object.is(action,'loadDraft')){
            this.createDefault();
        }
        if(Object.is(action,'load')){
            this.updateDefault();
        }
        this.$nextTick(function () {
            this.ignorefieldvaluechange = false;
        })
    }

    /**
     * 设置表单项是否启用
     *
     * @public
     * @param {*} data
     * @memberof MainBase
     */
    public setFormEnableCond(data: any): void {
        Object.values(this.detailsModel).forEach((detail: any) => {
            if (!Object.is(detail.detailType, 'FORMITEM')) {
                return;
            }
            const formItem: FormItemModel = detail;
            formItem.setEnableCond(data.srfuf);
        });
    }

    /**
     * 重置草稿表单状态
     *
     * @public
     * @memberof MainBase
     */
    public resetDraftFormStates(): void {
        const form: any = this.$refs.form;
        if (form) {
            form.resetFields();
        }
    }

    /**
     * 重置校验结果
     *
     * @memberof MainBase
     */
    public resetValidates(): void {
        Object.values(this.detailsModel).forEach((detail: any) => {
            if (!Object.is(detail.detailType, 'FORMITEM')) {
                return;
            }
            const formItem: FormItemModel = detail;
            formItem.setError('');
        });
    }

    /**
     * 填充校验结果 （后台）
     *
     * @param {any[]} fieldErrors
     * @memberof MainBase
     */
    public fillValidates(fieldErrors: any[]): void {
        fieldErrors.forEach((error: any) => {
            const formItem: FormItemModel = this.detailsModel[error.field];
            if (!formItem) {
                return;
            }
            this.$nextTick(() => {
                formItem.setError(error.message);
            });
        });
    }

    /**
     * 表单校验状态
     *
     * @returns {boolean} 
     * @memberof MainBase
     */
    public formValidateStatus(): boolean {
        const form: any = this.$refs.form;
        let validatestate: boolean = true;
        form.validate((valid: boolean) => {
            validatestate = valid ? true : false;
        });
        return validatestate
    }

    /**
     * 获取全部值
     *
     * @returns {*}
     * @memberof MainBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof MainBase
     */
    public onFormItemValueChange($event: { name: string, value: any }): void {
        if (!$event) {
            return;
        }
        if (!$event.name || Object.is($event.name, '') || !this.data.hasOwnProperty($event.name)) {
            return;
        }
        this.data[$event.name] = $event.value;
    }

    /**
     * 设置数据项值
     *
     * @param {string} name
     * @param {*} value
     * @returns {void}
     * @memberof MainBase
     */
    public setDataItemValue(name: string, value: any): void {
        if (!name || Object.is(name, '') || !this.data.hasOwnProperty(name)) {
            return;
        }
        if (Object.is(this.data[name], value)) {
            return;
        }
        this.data[name] = value;
    }



    /**
     * 分组界面行为事件
     *
     * @param {*} $event
     * @memberof MainBase
     */
    public groupUIActionClick($event: any): void {
        if (!$event) {
            return;
        }
        const item:any = $event.item;
    }

    /**
     * Vue声明周期(处理组件的输入属性)
     *
     * @memberof MainBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof MainBase
     */    
    public afterCreated(){
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('autoload', action)) {
                    this.autoLoad(data);
                }
                if (Object.is('load', action)) {
                    this.load(data);
                }
                if (Object.is('loaddraft', action)) {
                    if(this.context.srfsourcekey){
                        this.copy(this.context.srfsourcekey);
                    }else{
                        this.loadDraft(data);
                    }
                }
                if (Object.is('save', action)) {
                    this.save(data,data.showResultInfo);
                }
                if (Object.is('remove', action)) {
                    this.remove(data);
                }
                if (Object.is('saveandexit', action)) {
                    this.saveAndExit(data);
                }
                if (Object.is('saveandnew', action)) {
                    this.saveAndNew(data);
                }
                if (Object.is('removeandexit', action)) {
                    this.removeAndExit(data);
                }
                if (Object.is('refresh', action)) {
                    this.refresh(data);
                }
            });
        }
        this.dataChang
            .pipe(
                debounceTime(300),
                distinctUntilChanged()
            ).subscribe((data: any) => {
                if (this.autosave) {
                    this.autoSave();
                }
                const state = !Object.is(JSON.stringify(this.oldData), JSON.stringify(this.data)) ? true : false;
                this.$store.commit('viewaction/setViewDataChange', { viewtag: this.viewtag, viewdatachange: state });
            });
    }

    /**
     * vue 生命周期
     *
     * @memberof MainBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof MainBase
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
        if (this.dataChangEvent) {
            this.dataChangEvent.unsubscribe();
        }
    }

    /**
     * 拷贝内容
     *
     * @param {*} [arg={}]
     * @memberof @memberof MainBase
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.pcmxygzzjlmx = copyData.srfkey;
        copyData.pcmxygzzjlmxid = copyData.srfkey;
        Object.assign(this.context,{pcmxygzzjlmx:copyData.pcmxygzzjlmx})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof MainBase
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'pcmxygzzjlmx_main',popTitle:'主编辑表单'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public refresh(args: any[]): void {
        let arg: any = {};
        Object.assign(arg,args[0]);
        if (this.data.srfkey && !Object.is(this.data.srfkey, '')) {
            Object.assign(arg, { srfkey: this.data.srfkey });
            this.load(arg);
            return;
        }
        if (this.data.srfkeys && !Object.is(this.data.srfkeys, '')) {
            Object.assign(arg, { srfkey: this.data.srfkeys });
            this.load(arg);
            return;
        }
    }

    /**
     * 自动加载
     *
     * @param {*} [arg={}]
     * @returns {void}
     * @memberof MainBase
     */
    public autoLoad(arg: any = {}): void {
        if (arg.srfkey && !Object.is(arg.srfkey, '')) {
            Object.assign(arg, { srfkey: arg.srfkey });
            this.load(arg);
            return;
        }
        if (arg.srfkeys && !Object.is(arg.srfkeys, '')) {
            Object.assign(arg, { srfkey: arg.srfkeys });
            this.load(arg);
            return;
        }
        this.loadDraft(arg);
    }

    /**
     * 加载
     *
     * @public
     * @param {*} [opt={}]
     * @memberof MainBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'PcmXygzzjlmxCKEditView视图表单loadAction参数未配置' });
            return;
        }
        const arg: any = { ...opt };
        let viewparamResult:any = Object.assign(arg,this.viewparams);
        const get: Promise<any> = this.service.get(this.loadAction,JSON.parse(JSON.stringify(this.context)),{viewparams:viewparamResult}, this.showBusyIndicator);
        get.then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                this.onFormLoad(data,'load');
                this.$emit('load', data);
                this.$nextTick(() => {
                    this.formState.next({ type: 'load', data: data });
                });
            }
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 加载草稿
     *
     * @param {*} [opt={}]
     * @memberof MainBase
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'PcmXygzzjlmxCKEditView视图表单loaddraftAction参数未配置' });
            return;
        }
        const arg: any = { ...opt } ;
        let viewparamResult:any = Object.assign(arg,this.viewparams);
        let post: Promise<any> = this.service.loadDraft(this.loaddraftAction,JSON.parse(JSON.stringify(this.context)),{viewparams:viewparamResult}, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                }
                return;
            }

            const data = response.data;
            if(data.pcmxygzzjlmx){
                Object.assign(this.context,{pcmxygzzjlmx:data.pcmxygzzjlmx})
            }
            this.resetDraftFormStates();
            this.onFormLoad(data,'loadDraft');
            this.$emit('load', data);
            this.$nextTick(() => {
                this.formState.next({ type: 'load', data: data });
            });
            setTimeout(() => {
                const form: any = this.$refs.form;
                if (form) {
                    form.fields.forEach((field: any) => {
                        field.validateMessage = "";
                        field.validateState = "";
                        field.validateStatus = false;
                    });
                }
            });
        }).catch((response: any) => {
            if (response && response.status  && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 自动保存
     *
     * @param {*} [opt={}]
     * @memberof MainBase
     */
    public autoSave(opt: any = {}): void {
        if (!this.formValidateStatus()) {
            return;
        }
        const arg: any = { ...opt };
        const data = this.getValues();
        Object.assign(arg, data);
        const action: any = Object.is(data.srfuf, '1') ? this.updateAction : this.createAction;
        if(!action){
            let actionName:any = Object.is(data.srfuf, '1')?"updateAction":"createAction";
            this.$Notice.error({ title: '错误', desc: 'PcmXygzzjlmxCKEditView视图表单'+actionName+'参数未配置' });
            return;
        }
        Object.assign(arg,{viewparams:this.viewparams});
        const post: Promise<any> = this.service.add(action, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                }
                return;
            }

            const data = response.data;
            this.onFormLoad(data,'autoSave');
            this.$emit('save', data);
            this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
            this.$nextTick(() => {
                this.formState.next({ type: 'save', data: data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 保存
     *
     * @param {*} [opt={}]
     * @param {boolean} [showResultInfo] 
     * @param {boolean} [ifStateNext] formState是否下发通知
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async save(opt: any = {}, showResultInfo?: boolean, ifStateNext: boolean = true): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            showResultInfo = showResultInfo === undefined ? true : false;
            if (!this.formValidateStatus()) {
                this.$Notice.error({ title: '错误', desc: '值规则校验异常' });
                return;
            }
            const arg: any = { ...opt };
            const data = this.getValues();
            Object.assign(arg, data);
            Object.assign(arg, this.context);
            if (ifStateNext) {
                this.drcounter = 0;
                if(this.drcounter !== 0){
                    this.drsaveopt = opt;
                    this.formState.next({ type: 'beforesave', data: arg });//先通知关系界面保存
                    this.saveState = resolve;
                    return;
                }
            }
            const action: any = Object.is(data.srfuf, '1') ? this.updateAction : this.createAction;
            if(!action){
                let actionName:any = Object.is(data.srfuf, '1')?"updateAction":"createAction";
                this.$Notice.error({ title: '错误', desc: 'PcmXygzzjlmxCKEditView视图表单'+actionName+'参数未配置' });
                return;
            }
            Object.assign(arg,{viewparams:this.viewparams});
            const post: Promise<any> = Object.is(data.srfuf, '1')?this.service.update(action, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(action,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
            post.then((response: any) => {
                if (!response.status || response.status !== 200) {
                    if (response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                    }
                    return;
                }

                const data = response.data;
                this.onFormLoad(data,'save');
                this.$emit('save', data);
                this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: data });
                });
                if (showResultInfo) {
                    this.$Notice.success({ title: '', desc: (data.srfmajortext ? data.srfmajortext : '') + '&nbsp;保存成功！' });
                }
                resolve(response);
            }).catch((response: any) => {
                if (response && response.status  && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
                    reject(response);
                    return;
                }
                reject(response);
            });
        })
    }

    /**
    * 删除
    *
    * @public
    * @param {*} [opt={}]
    * @memberof MainBase
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'PcmXygzzjlmxCKEditView视图表单removeAction参数未配置' });
                return;
            }
            const arg: any = opt[0];
            const _this: any = this;
            Object.assign(arg,{viewparams:this.viewparams});
            this.service.delete(_this.removeAction, JSON.parse(JSON.stringify(this.context)),arg, showResultInfo).then((response: any) => {
                if (response) {
                    const data = response.data;
                    this.$emit('remove',data);
                    this.formState.next({ type: 'remove', data: data });
                    this.data.ismodify = false;
                    this.$Notice.success({ title: '', desc: (data.srfmajortext ? data.srfmajortext : '') + '&nbsp;删除成功！' });
                    resolve(response);
                }
            }).catch((error: any) => {
                const { data: _data } = error;
                this.$Notice.error({ title: _data.title, desc: _data.message });
                reject(error);
            });
        });
    }

    /**
     * 工作流启动
     *
     * @param {*} [data={}]
     * @param {*} [localdata={}]
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async wfstart(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            const _this: any = this;
            const post: Promise<any> = _this.save({},false);
            post.then((response:any) =>{
                const arg:any = response.data;
                if(this.viewparams){
                    Object.assign(arg,{viewparams:this.viewparams});
                }
                const result: Promise<any> = this.service.wfstart(_this.WFStartAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator,localdata);
                result.then((response: any) => {
                    if (!response || response.status !== 200) {
                        if(response.data){
                            this.$Notice.error({ title: '', desc: '工作流启动失败, ' + response.data.message });
                        }
                        return;
                    }
                    this.$Notice.info({ title: '', desc: '工作流启动成功' });
                    resolve(response);
            }).catch((response: any) => {
                if (response && response.status && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
                    reject(response);
                    return;
                }
                reject(response);
            });
            }).catch((response: any) => {
                    if (response && response.status && response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                        reject(response);
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: '错误', desc: '系统异常' });
                        reject(response);
                        return;
                    }
                    reject(response);
            })
        });
    }

    /**
     * 工作流提交
     *
     * @param {*} [data={}]
     * @param {*} [localdata={}]
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.pcmxygzzjlmx || Object.is(arg.pcmxygzzjlmx, '')) {
            return;
        }
        const post: Promise<any> = Object.is(arg.srfuf, '1')?this.service.update(this.updateAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(this.createAction,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
        post.then((response:any) =>{
                const arg:any = response.data;
                // 保存完成UI处理
                this.onFormLoad(arg,'save');
                this.$emit('save', arg);
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: arg });
                });
                // 准备提交参数
                if(this.viewparams){
                    Object.assign(arg,{viewparams:this.viewparams});
                }
                // 强制补充srfwfmemo
                if(this.srfwfmemo){
                    Object.assign(arg,{srfwfmemo:this.srfwfmemo});
                }
                const result: Promise<any> = this.service.wfsubmit(_this.WFSubmitAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator,localdata);
                result.then((response: any) => {
                    if (!response || response.status !== 200) {
                        if(response.data){
                            this.$Notice.error({ title: '', desc: '工作流提交失败, ' + response.data.message });
                        }
                        return;
                    }
                    this.onFormLoad(arg,'submit');
                    this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
                    this.$Notice.info({ title: '', desc: '工作流提交成功' });
                    resolve(response);
            }).catch((response: any) => {
                if (response && response.status && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
                    reject(response);
                    return;
                }
                reject(response);
            });
            }).catch((response: any) => {
                    if (response && response.status && response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                        reject(response);
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: '错误', desc: '系统异常' });
                        reject(response);
                        return;
                    }
                    reject(response);
            })
        })
    }

    /**
     * 表单项更新
     *
     * @param {string} mode 界面行为名称
     * @param {*} [data={}] 请求数据
     * @param {string[]} updateDetails 更新项
     * @param {boolean} [showloading] 是否显示加载状态
     * @returns {void}
     * @memberof MainBase
     */
    public updateFormItems(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
        if (!mode || (mode && Object.is(mode, ''))) {
            return;
        }
        const arg: any = { ...data };
        Object.assign(arg,this.viewparams);
        const post: Promise<any> = this.service.frontLogic(mode,JSON.parse(JSON.stringify(this.context)),arg, showloading);
        post.then((response: any) => {
            if (!response || response.status !== 200) {
                this.$Notice.error({ title: '错误', desc: '表单项更新失败' });
                return;
            }
            const data = response.data;
            const _data: any = {};
            updateDetails.forEach((name: string) => {
                if (!data.hasOwnProperty(name)) {
                    return;
                }
                Object.assign(_data, { [name]: data[name] });
            });
            this.setFormEnableCond(_data);
            this.fillForm(_data,'updateFormItem');
            this.formLogic({ name: '', newVal: null, oldVal: null });
            this.dataChang.next(JSON.stringify(this.data));
            this.$nextTick(() => {
                this.formState.next({ type: 'updateformitem', ufimode: arg.srfufimode, data: _data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof MainBase
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public saveAndExit(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.currentAction = "saveAndExit";
            _this.save([arg]).then((res) =>{
                if(res){
                    _this.closeView(res.data);
                }
                resolve(res);
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
     * 保存并新建
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public saveAndNew(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.currentAction = "saveAndNew";
            _this.save([arg]).then((res) =>{
                _this.ResetData(res);
                _this.loadDraft({});
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
     * 删除并退出
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public removeAndExit(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.remove([arg]).then((res) =>{
                if(res){
                  _this.closeView(res.data);
                }
                resolve(res);
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
    * 关系界面数据保存完成
    *
    * @param {any} $event
    * @memberof MainBase
    */
    public drdatasaved($event:any){
        let _this = this;
        this.drcounter--;
        if(this.drcounter === 0){
            this.save(this.drsaveopt, undefined, false).then((res) =>{
                this.saveState(res);
                this.drsaveopt = {};
                if(Object.is(_this.currentAction, "saveAndNew")){
                    _this.ResetData(res);
                    _this.loadDraft({});
                }else if(Object.is(_this.currentAction, "saveAndExit")){
                    if(res){
                        _this.closeView(res.data);
                    }
                }
            });
        }
    }

    /**
     * 新建默认值
     * @memberof MainBase
     */
    public createDefault(){                    
        if (this.data.hasOwnProperty('istemp')) {
            this.data['istemp'] = 0;
        }
        if (this.data.hasOwnProperty('finished')) {
            this.data['finished'] = 0;
        }
        if (this.data.hasOwnProperty('checkstatus')) {
            this.data['checkstatus'] = '2';
        }
    }

    /**
     * 更新默认值
     * @memberof MainBase
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './main-form.less';
</style>