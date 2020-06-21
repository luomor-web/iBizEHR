<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='pcmddsqdmx_main' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmddsqdmx.main_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.pimdistirbutionname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='pimdistirbutionname' :itemRules="this.rules.pimdistirbutionname" class='' :caption="$t('entities.pcmddsqdmx.main_form.details.pimdistirbutionname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimdistirbutionname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.pimdistirbutionname.disabled"
  name='pimdistirbutionname'
  deMajorField='pimpersonname'
  deKeyField='pimdistirbution'
  :service="service"
  :acParams="{ serviceName: 'PimDistirbutionService', interfaceName: 'FetchKDDYXZFP'}"
  valueitem='pimdistirbutionid' 
  :value="data.pimdistirbutionname" 
  editortype="" 
  :pickupView="{ viewname: 'pim-distirbution-kddpickup-view', title: $t('entities.pimdistirbution.views.kddpickupview.title'), deResParameters: [{ pathName: 'pimpeople', parameterName: 'pimperson' }, ], parameters: [{ pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' }, { pathName: 'kddpickupview', parameterName: 'kddpickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.sxrq.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='sxrq' :itemRules="this.rules.sxrq" class='' :caption="$t('entities.pcmddsqdmx.main_form.details.sxrq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sxrq.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.sxrq" :disabled="detailsModel.sxrq.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.sxrq = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormorgname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='ormorgname' :itemRules="this.rules.ormorgname" class='' :caption="$t('entities.pcmddsqdmx.main_form.details.ormorgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormorgname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ormorgname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ormorgname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.orgname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='orgname' :itemRules="this.rules.orgname" class='' :caption="$t('entities.pcmddsqdmx.main_form.details.orgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.orgname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.orgname.disabled"
  name='orgname'
  deMajorField='orgname'
  deKeyField='ormorg'
  :service="service"
  :acParams="{ serviceName: 'OrmOrgService', interfaceName: 'FetchDefault'}"
  valueitem='orgid' 
  :value="data.orgname" 
  editortype="" 
  :pickupView="{ viewname: 'orm-org-pickup-view', title: $t('entities.ormorg.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'ormorgs', parameterName: 'ormorg' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormorgsectorname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='ormorgsectorname' :itemRules="this.rules.ormorgsectorname" class='' :caption="$t('entities.pcmddsqdmx.main_form.details.ormorgsectorname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormorgsectorname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ormorgsectorname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ormorgsectorname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.orgsectorname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='orgsectorname' :itemRules="this.rules.orgsectorname" class='' :caption="$t('entities.pcmddsqdmx.main_form.details.orgsectorname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.orgsectorname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ ORMORG:"%orgid%" }' 
  :localParam ='{ n_orgid_eq:"%orgid%" }' 
  :disabled="detailsModel.orgsectorname.disabled"
  name='orgsectorname'
  deMajorField='orgsectorname'
  deKeyField='ormorgsector'
  :service="service"
  :acParams="{ serviceName: 'OrmOrgsectorService', interfaceName: 'FetchDefault'}"
  valueitem='orgsectorid' 
  :value="data.orgsectorname" 
  editortype="" 
  :pickupView="{ viewname: 'orm-orgsector-pickup-view', title: $t('entities.ormorgsector.views.pickupview.title'), deResParameters: [{ pathName: 'ormorgs', parameterName: 'ormorg' }, ], parameters: [{ pathName: 'ormorgsectors', parameterName: 'ormorgsector' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormyzw.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='ormyzw' :itemRules="this.rules.ormyzw" class='' :caption="$t('entities.pcmddsqdmx.main_form.details.ormyzw')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormyzw.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ormyzw"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ormyzw.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormdutyname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='ormdutyname' :itemRules="this.rules.ormdutyname" class='' :caption="$t('entities.pcmddsqdmx.main_form.details.ormdutyname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormdutyname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.ormdutyname.disabled"
  name='ormdutyname'
  deMajorField='ormdutyname'
  deKeyField='ormduty'
  :service="service"
  :acParams="{ serviceName: 'OrmDutyService', interfaceName: 'FetchDefault'}"
  valueitem='ormdutyid' 
  :value="data.ormdutyname" 
  editortype="" 
  :pickupView="{ viewname: 'orm-duty-pickup-view', title: $t('entities.ormduty.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'ormduties', parameterName: 'ormduty' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormygw.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='ormygw' :itemRules="this.rules.ormygw" class='' :caption="$t('entities.pcmddsqdmx.main_form.details.ormygw')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormygw.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ormygw"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ormygw.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormpostname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='ormpostname' :itemRules="this.rules.ormpostname" class='' :caption="$t('entities.pcmddsqdmx.main_form.details.ormpostname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormpostname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.ormpostname.disabled"
  name='ormpostname'
  deMajorField='ormpostname'
  deKeyField='ormpost'
  :service="service"
  :acParams="{ serviceName: 'OrmPostService', interfaceName: 'FetchDefault'}"
  valueitem='ormpostid' 
  :value="data.ormpostname" 
  editortype="" 
  :pickupView="{ viewname: 'orm-post-pickup-view', title: $t('entities.ormpost.views.pickupview.title'), deResParameters: [{ pathName: 'ormorgs', parameterName: 'ormorg' }, ], parameters: [{ pathName: 'ormposts', parameterName: 'ormpost' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.rzwj.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='rzwj' :itemRules="this.rules.rzwj" class='' :caption="$t('entities.pcmddsqdmx.main_form.details.rzwj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rzwj.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-file-upload :formState="formState" :ignorefieldvaluechange="ignorefieldvaluechange" @formitemvaluechange="onFormItemValueChange" :data="JSON.stringify(this.data)" name='rzwj' :value="data.rzwj" :disabled="detailsModel.rzwj.disabled" :uploadparams='{}' :exportparams='{}'  style="overflow: auto;"></app-file-upload>
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
import PcmDdsqdmxService from '@/service/pcm-ddsqdmx/pcm-ddsqdmx-service';
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
     * @type {PcmDdsqdmxService}
     * @memberof MainBase
     */
    public appEntityService: PcmDdsqdmxService = new PcmDdsqdmxService({ $store: this.$store });
    


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
        pimdistirbutionid: null,
        pimdistirbutionname: null,
        sxrq: null,
        pcmddsqdid: null,
        pcmddsqdname: null,
        ormorgname: null,
        orgname: null,
        ormorgsectorname: null,
        orgsectorname: null,
        ormyzw: null,
        ormdutyname: null,
        ormygw: null,
        ormpostname: null,
        lx: null,
        sfgbdd: null,
        rzwj: null,
        finishdd: null,
        orgsectorid: null,
        ormdutyid: null,
        ormpostid: null,
        orgid: null,
        pcmddsqdmxid: null,
        pcmddsqdmx:null,
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
            { type: 'string', message: '调动申请单明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '调动申请单明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '调动申请单明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '调动申请单明细标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '调动申请单明细名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '调动申请单明细名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '调动申请单明细名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '调动申请单明细名称 值不能为空', trigger: 'blur' },
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
        pimdistirbutionid: [
            { type: 'string', message: '分配信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '分配信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '分配信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '分配信息标识 值不能为空', trigger: 'blur' },
        ],
        pimdistirbutionname: [
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
        ],
        sxrq: [
            { type: 'string', message: '生效日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '生效日期 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '生效日期 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '生效日期 值不能为空', trigger: 'blur' },
        ],
        pcmddsqdid: [
            { type: 'string', message: '调动申请单标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '调动申请单标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '调动申请单标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '调动申请单标识 值不能为空', trigger: 'blur' },
        ],
        pcmddsqdname: [
            { type: 'string', message: '标题 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '标题 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '标题 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '标题 值不能为空', trigger: 'blur' },
        ],
        ormorgname: [
            { type: 'string', message: '原组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '原组织 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '原组织 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '原组织 值不能为空', trigger: 'blur' },
        ],
        orgname: [
            { type: 'string', message: '新组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '新组织 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '新组织 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '新组织 值不能为空', trigger: 'blur' },
        ],
        ormorgsectorname: [
            { type: 'string', message: '原部门/项目 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '原部门/项目 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '原部门/项目 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '原部门/项目 值不能为空', trigger: 'blur' },
        ],
        orgsectorname: [
            { type: 'string', message: '新部门/项目 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '新部门/项目 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '新部门/项目 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '新部门/项目 值不能为空', trigger: 'blur' },
        ],
        ormyzw: [
            { type: 'string', message: '原职务 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '原职务 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '原职务 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '原职务 值不能为空', trigger: 'blur' },
        ],
        ormdutyname: [
            { type: 'string', message: '新职务 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '新职务 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '新职务 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '新职务 值不能为空', trigger: 'blur' },
        ],
        ormygw: [
            { type: 'string', message: '原岗位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '原岗位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '原岗位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '原岗位 值不能为空', trigger: 'blur' },
        ],
        ormpostname: [
            { type: 'string', message: '新岗位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '新岗位 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '新岗位 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '新岗位 值不能为空', trigger: 'blur' },
        ],
        lx: [
            { type: 'string', message: '类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '类型 值不能为空', trigger: 'blur' },
        ],
        sfgbdd: [
            { type: 'number', message: '是否干部调动 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否干部调动 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '是否干部调动 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '是否干部调动 值不能为空', trigger: 'blur' },
        ],
        rzwj: [
            { type: 'string', message: '任职文件 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '任职文件 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '任职文件 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '任职文件 值不能为空', trigger: 'blur' },
        ],
        finishdd: [
            { type: 'number', message: '完成调动 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '完成调动 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '完成调动 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '完成调动 值不能为空', trigger: 'blur' },
        ],
        orgsectorid: [
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'blur' },
        ],
        ormdutyid: [
            { type: 'string', message: '职务ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职务ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职务ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职务ID 值不能为空', trigger: 'blur' },
        ],
        ormpostid: [
            { type: 'string', message: '岗位ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '岗位ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '岗位ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '岗位ID 值不能为空', trigger: 'blur' },
        ],
        orgid: [
            { type: 'string', message: '组织机构标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织机构标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织机构标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织机构标识 值不能为空', trigger: 'blur' },
        ],
        pcmddsqdmxid: [
            { type: 'string', message: '调动申请单明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '调动申请单明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '调动申请单明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '调动申请单明细标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof MainBase
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '调动明细', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmddsqdmx.main_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '调动申请单明细标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '调动申请单明细名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimdistirbutionid: new FormItemModel({ caption: '分配信息标识', detailType: 'FORMITEM', name: 'pimdistirbutionid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimdistirbutionname: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'pimdistirbutionname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        sxrq: new FormItemModel({ caption: '生效日期', detailType: 'FORMITEM', name: 'sxrq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmddsqdid: new FormItemModel({ caption: '调动申请单标识', detailType: 'FORMITEM', name: 'pcmddsqdid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmddsqdname: new FormItemModel({ caption: '标题', detailType: 'FORMITEM', name: 'pcmddsqdname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgname: new FormItemModel({ caption: '原组织', detailType: 'FORMITEM', name: 'ormorgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        orgname: new FormItemModel({ caption: '新组织', detailType: 'FORMITEM', name: 'orgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgsectorname: new FormItemModel({ caption: '原部门/项目', detailType: 'FORMITEM', name: 'ormorgsectorname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        orgsectorname: new FormItemModel({ caption: '新部门/项目', detailType: 'FORMITEM', name: 'orgsectorname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormyzw: new FormItemModel({ caption: '原职务', detailType: 'FORMITEM', name: 'ormyzw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        ormdutyname: new FormItemModel({ caption: '新职务', detailType: 'FORMITEM', name: 'ormdutyname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormygw: new FormItemModel({ caption: '原岗位', detailType: 'FORMITEM', name: 'ormygw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        ormpostname: new FormItemModel({ caption: '新岗位', detailType: 'FORMITEM', name: 'ormpostname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        lx: new FormItemModel({ caption: '类型', detailType: 'FORMITEM', name: 'lx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sfgbdd: new FormItemModel({ caption: '是否干部调动', detailType: 'FORMITEM', name: 'sfgbdd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        rzwj: new FormItemModel({ caption: '任职文件', detailType: 'FORMITEM', name: 'rzwj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        finishdd: new FormItemModel({ caption: '完成调动', detailType: 'FORMITEM', name: 'finishdd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        orgsectorid: new FormItemModel({ caption: '部门标识', detailType: 'FORMITEM', name: 'orgsectorid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormdutyid: new FormItemModel({ caption: '职务ID', detailType: 'FORMITEM', name: 'ormdutyid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormpostid: new FormItemModel({ caption: '岗位ID', detailType: 'FORMITEM', name: 'ormpostid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        orgid: new FormItemModel({ caption: '组织机构标识', detailType: 'FORMITEM', name: 'orgid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmddsqdmxid: new FormItemModel({ caption: '调动申请单明细标识', detailType: 'FORMITEM', name: 'pcmddsqdmxid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
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
     * 监控表单属性 pimdistirbutionid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pimdistirbutionid')
    onPimdistirbutionidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimdistirbutionid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimdistirbutionname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pimdistirbutionname')
    onPimdistirbutionnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimdistirbutionname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sxrq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sxrq')
    onSxrqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sxrq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmddsqdid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pcmddsqdid')
    onPcmddsqdidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmddsqdid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmddsqdname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pcmddsqdname')
    onPcmddsqdnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmddsqdname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormorgname')
    onOrmorgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.orgname')
    onOrgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgsectorname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormorgsectorname')
    onOrmorgsectornameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgsectorname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgsectorname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.orgsectorname')
    onOrgsectornameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgsectorname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormyzw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormyzw')
    onOrmyzwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormyzw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormdutyname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormdutyname')
    onOrmdutynameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormdutyname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormygw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormygw')
    onOrmygwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormygw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormpostname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormpostname')
    onOrmpostnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormpostname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 lx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.lx')
    onLxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'lx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfgbdd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sfgbdd')
    onSfgbddChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfgbdd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rzwj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.rzwj')
    onRzwjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rzwj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 finishdd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.finishdd')
    onFinishddChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'finishdd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgsectorid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.orgsectorid')
    onOrgsectoridChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgsectorid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormdutyid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormdutyid')
    onOrmdutyidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormdutyid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormpostid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormpostid')
    onOrmpostidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormpostid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.orgid')
    onOrgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmddsqdmxid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pcmddsqdmxid')
    onPcmddsqdmxidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmddsqdmxid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof MainBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
        if (Object.is(name, 'orgid')) {
            this.onFormItemValueChange({ name: 'orgsectorname', value: null });
            this.onFormItemValueChange({ name: 'orgsectorid', value: null });
        }
        if (Object.is(name, 'orgid')) {
            this.onFormItemValueChange({ name: 'orgsectorid', value: null });
        }
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
        if(data.pcmddsqdmx){
            Object.assign(this.context,{pcmddsqdmx:data.pcmddsqdmx})
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
        copyData.pcmddsqdmx = copyData.srfkey;
        copyData.pcmddsqdmxid = copyData.srfkey;
        Object.assign(this.context,{pcmddsqdmx:copyData.pcmddsqdmx})
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
        _this.$print({id:'pcmddsqdmx_main',popTitle:'调动申请明细'});
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
            this.$Notice.error({ title: '错误', desc: 'PcmDdsqdmxEditView视图表单loadAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'PcmDdsqdmxEditView视图表单loaddraftAction参数未配置' });
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
            if(data.pcmddsqdmx){
                Object.assign(this.context,{pcmddsqdmx:data.pcmddsqdmx})
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
            this.$Notice.error({ title: '错误', desc: 'PcmDdsqdmxEditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PcmDdsqdmxEditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PcmDdsqdmxEditView视图表单removeAction参数未配置' });
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
        if (!arg.pcmddsqdmx || Object.is(arg.pcmddsqdmx, '')) {
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
        if (this.data.hasOwnProperty('lx')) {
            this.data['lx'] = '10';
        }
        if (this.data.hasOwnProperty('sfgbdd')) {
            this.data['sfgbdd'] = 0;
        }
        if (this.data.hasOwnProperty('finishdd')) {
            this.data['finishdd'] = 1;
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