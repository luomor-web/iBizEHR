<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='pcmydlzmx_main' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmydlzmx.main_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="1" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.ygbh.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='ygbh' :itemRules="this.rules.ygbh" class='' :caption="$t('entities.pcmydlzmx.main_form.details.ygbh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ygbh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ygbh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ygbh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pimpersonname.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='pimpersonname' :itemRules="this.rules.pimpersonname" class='' :caption="$t('entities.pcmydlzmx.main_form.details.pimpersonname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimpersonname.error" :isEmptyCaption="false" labelPos="LEFT">
    
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
  :acParams="{ serviceName: 'PimPersonService', interfaceName: 'FetchYXZFPRYDS'}"
  valueitem='pimpersonid' 
  :value="data.pimpersonname" 
  editortype="" 
  :pickupView="{ viewname: 'pim-person-yxzfppickup-view', title: $t('entities.pimperson.views.yxzfppickupview.title'), deResParameters: [], parameters: [{ pathName: 'pimpeople', parameterName: 'pimperson' }, { pathName: 'yxzfppickupview', parameterName: 'yxzfppickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.zz.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='zz' :itemRules="this.rules.zz" class='' :caption="$t('entities.pcmydlzmx.main_form.details.zz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zz.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zz"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zz.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bm.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='bm' :itemRules="this.rules.bm" class='' :caption="$t('entities.pcmydlzmx.main_form.details.bm')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bm.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bm"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.bm.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.yrank.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='yrank' :itemRules="this.rules.yrank" class='' :caption="$t('entities.pcmydlzmx.main_form.details.yrank')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.yrank.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.yrank" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.yrank.disabled"  
    tag='EhrCodeList0025' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.yzw.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='yzw' :itemRules="this.rules.yzw" class='' :caption="$t('entities.pcmydlzmx.main_form.details.yzw')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.yzw.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.yzw" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.yzw.disabled"  
    tag='EhrCodeList0233' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ygw.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='ygw' :itemRules="this.rules.ygw" class='' :caption="$t('entities.pcmydlzmx.main_form.details.ygw')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ygw.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.ygw" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.ygw.disabled"  
    tag='EhrCodeList0050' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.lxdh.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='lxdh' :itemRules="this.rules.lxdh" class='' :caption="$t('entities.pcmydlzmx.main_form.details.lxdh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.lxdh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.lxdh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.lxdh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmydlzmx.main_form.details.grouppanel1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="1" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.sxrq.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='sxrq' :itemRules="this.rules.sxrq" class='' :caption="$t('entities.pcmydlzmx.main_form.details.sxrq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sxrq.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.sxrq" :disabled="detailsModel.sxrq.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.sxrq = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfhmd.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='sfhmd' :itemRules="this.rules.sfhmd" class='' :caption="$t('entities.pcmydlzmx.main_form.details.sfhmd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sfhmd.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-radio-group 
  v-model="data.sfhmd"
  :data="data" 
  :context="context"
  :viewparams="viewparams"   
  :disabled="detailsModel.sfhmd.disabled"  
  name="sfhmd" 
  :localContext ='{ }' 
  :localParam ='{ }' 
  tag='EhrCodeList0401' 
  codelistType='STATIC' 
  style="">
</app-radio-group>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.lzmtrname.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='lzmtrname' :itemRules="this.rules.lzmtrname" class='' :caption="$t('entities.pcmydlzmx.main_form.details.lzmtrname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.lzmtrname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.lzmtrname.disabled"
  name='lzmtrname'
  deMajorField='pimpersonname'
  deKeyField='pimperson'
  :service="service"
  :acParams="{ serviceName: 'PimPersonService', interfaceName: 'FetchAuthPerson'}"
  valueitem='lzmtrid' 
  :value="data.lzmtrname" 
  editortype="" 
  :pickupView="{ viewname: 'pim-person-pickup-view', title: $t('entities.pimperson.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'pimpeople', parameterName: 'pimperson' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.fj.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='fj' :itemRules="this.rules.fj" class='' :caption="$t('entities.pcmydlzmx.main_form.details.fj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fj.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-file-upload :formState="formState" :ignorefieldvaluechange="ignorefieldvaluechange" @formitemvaluechange="onFormItemValueChange" :data="JSON.stringify(this.data)" name='fj' :value="data.fj" :disabled="detailsModel.fj.disabled" :uploadparams='{}' :exportparams='{}'  style="overflow: auto;"></app-file-upload>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.yytype.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='yytype' :itemRules="this.rules.yytype" class='' :caption="$t('entities.pcmydlzmx.main_form.details.yytype')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.yytype.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.yytype" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.yytype.disabled"  
    tag='EhrCodeList0217' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.lzqx.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='lzqx' :itemRules="this.rules.lzqx" class='' :caption="$t('entities.pcmydlzmx.main_form.details.lzqx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.lzqx.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.lzqx"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.lzqx.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bz.visible" :style="{}"  :md="{ span: 24, offset: 0 }" :lg="{ span: 24, offset: 0 }" :xl="{ span: 24, offset: 0 }">
    <app-form-item name='bz' :itemRules="this.rules.bz" class='' :caption="$t('entities.pcmydlzmx.main_form.details.bz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bz.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bz"  :disabled="detailsModel.bz.disabled" type='textarea' style="" ></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.remarks.visible" :style="{}"  :md="{ span: 12, offset: 0 }" :lg="{ span: 24, offset: 0 }" :xl="{ span: 24, offset: 0 }">
    <app-form-item name='remarks' :itemRules="this.rules.remarks" class='' :caption="$t('entities.pcmydlzmx.main_form.details.remarks')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.remarks.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.remarks"  :disabled="detailsModel.remarks.disabled" type='textarea' style="" ></input-box>
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
import PcmYdlzmxService from '@/service/pcm-ydlzmx/pcm-ydlzmx-service';
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
     * @type {PcmYdlzmxService}
     * @memberof MainBase
     */
    public appEntityService: PcmYdlzmxService = new PcmYdlzmxService({ $store: this.$store });
    


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
        pimpersonid: null,
        ygbh: null,
        pimpersonname: null,
        zz: null,
        zzid: null,
        bm: null,
        bmid: null,
        yrank: null,
        yzw: null,
        ygw: null,
        lxdh: null,
        sxrq: null,
        sfhmd: null,
        lzmtrname: null,
        lzmtrid: null,
        fj: null,
        yytype: null,
        lzqx: null,
        bz: null,
        remarks: null,
        isfinished: null,
        pcmydlzmxid: null,
        pcmydlzmx:null,
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
            { type: 'string', message: '异动离职明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '异动离职明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '异动离职明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '异动离职明细标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '异动离职明细名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '异动离职明细名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '异动离职明细名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '异动离职明细名称 值不能为空', trigger: 'blur' },
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
        pimpersonid: [
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
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
            { required: true, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
        ],
        zz: [
            { type: 'string', message: '所属组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属组织 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所属组织 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所属组织 值不能为空', trigger: 'blur' },
        ],
        zzid: [
            { type: 'string', message: '所属组织标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属组织标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所属组织标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所属组织标识 值不能为空', trigger: 'blur' },
        ],
        bm: [
            { type: 'string', message: '所属部门 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属部门 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所属部门 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所属部门 值不能为空', trigger: 'blur' },
        ],
        bmid: [
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'blur' },
        ],
        yrank: [
            { type: 'string', message: '职级 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职级 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职级 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职级 值不能为空', trigger: 'blur' },
        ],
        yzw: [
            { type: 'string', message: '所属职务 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属职务 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所属职务 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所属职务 值不能为空', trigger: 'blur' },
        ],
        ygw: [
            { type: 'string', message: '所属岗位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属岗位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所属岗位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所属岗位 值不能为空', trigger: 'blur' },
        ],
        lxdh: [
            { type: 'string', message: '联系电话 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '联系电话 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '联系电话 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '联系电话 值不能为空', trigger: 'blur' },
        ],
        sxrq: [
            { type: 'string', message: '离职日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '离职日期 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '离职日期 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '离职日期 值不能为空', trigger: 'blur' },
        ],
        sfhmd: [
            { type: 'number', message: '是否加入黑名单 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否加入黑名单 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '是否加入黑名单 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '是否加入黑名单 值不能为空', trigger: 'blur' },
        ],
        lzmtrname: [
            { type: 'string', message: '离职面谈人 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '离职面谈人 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '离职面谈人 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '离职面谈人 值不能为空', trigger: 'blur' },
        ],
        lzmtrid: [
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
        ],
        fj: [
            { type: 'string', message: '离职面谈附件 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '离职面谈附件 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '离职面谈附件 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '离职面谈附件 值不能为空', trigger: 'blur' },
        ],
        yytype: [
            { type: 'string', message: '离职理由 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '离职理由 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '离职理由 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '离职理由 值不能为空', trigger: 'blur' },
        ],
        lzqx: [
            { type: 'string', message: '离职去向 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '离职去向 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '离职去向 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '离职去向 值不能为空', trigger: 'blur' },
        ],
        bz: [
            { type: 'string', message: '原因详情 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '原因详情 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '原因详情 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '原因详情 值不能为空', trigger: 'blur' },
        ],
        remarks: [
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'blur' },
        ],
        isfinished: [
            { type: 'string', message: '是否完成 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '是否完成 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '是否完成 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '是否完成 值不能为空', trigger: 'blur' },
        ],
        pcmydlzmxid: [
            { type: 'string', message: '异动离职明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '异动离职明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '异动离职明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '异动离职明细标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof MainBase
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '人员信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmydlzmx.main_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel1: new FormGroupPanelModel({ caption: '离职信息', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmydlzmx.main_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '异动离职明细标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '异动离职明细名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonid: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'pimpersonid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ygbh: new FormItemModel({ caption: '员工编号', detailType: 'FORMITEM', name: 'ygbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        pimpersonname: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'pimpersonname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zz: new FormItemModel({ caption: '所属组织', detailType: 'FORMITEM', name: 'zz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        zzid: new FormItemModel({ caption: '所属组织标识', detailType: 'FORMITEM', name: 'zzid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bm: new FormItemModel({ caption: '所属部门', detailType: 'FORMITEM', name: 'bm', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        bmid: new FormItemModel({ caption: '部门标识', detailType: 'FORMITEM', name: 'bmid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        yrank: new FormItemModel({ caption: '职级', detailType: 'FORMITEM', name: 'yrank', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        yzw: new FormItemModel({ caption: '所属职务', detailType: 'FORMITEM', name: 'yzw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        ygw: new FormItemModel({ caption: '所属岗位', detailType: 'FORMITEM', name: 'ygw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        lxdh: new FormItemModel({ caption: '联系电话', detailType: 'FORMITEM', name: 'lxdh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        sxrq: new FormItemModel({ caption: '离职日期', detailType: 'FORMITEM', name: 'sxrq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sfhmd: new FormItemModel({ caption: '是否加入黑名单', detailType: 'FORMITEM', name: 'sfhmd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        lzmtrname: new FormItemModel({ caption: '离职面谈人', detailType: 'FORMITEM', name: 'lzmtrname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        lzmtrid: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'lzmtrid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        fj: new FormItemModel({ caption: '离职面谈附件', detailType: 'FORMITEM', name: 'fj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        yytype: new FormItemModel({ caption: '离职理由', detailType: 'FORMITEM', name: 'yytype', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        lzqx: new FormItemModel({ caption: '离职去向', detailType: 'FORMITEM', name: 'lzqx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bz: new FormItemModel({ caption: '原因详情', detailType: 'FORMITEM', name: 'bz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        remarks: new FormItemModel({ caption: '备注', detailType: 'FORMITEM', name: 'remarks', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        isfinished: new FormItemModel({ caption: '是否完成', detailType: 'FORMITEM', name: 'isfinished', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmydlzmxid: new FormItemModel({ caption: '异动离职明细标识', detailType: 'FORMITEM', name: 'pcmydlzmxid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
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
     * 监控表单属性 yrank 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.yrank')
    onYrankChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'yrank', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 yzw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.yzw')
    onYzwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'yzw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ygw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ygw')
    onYgwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ygw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 lxdh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.lxdh')
    onLxdhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'lxdh', newVal: newVal, oldVal: oldVal });
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
     * 监控表单属性 sfhmd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sfhmd')
    onSfhmdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfhmd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 lzmtrname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.lzmtrname')
    onLzmtrnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'lzmtrname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 lzmtrid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.lzmtrid')
    onLzmtridChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'lzmtrid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 fj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.fj')
    onFjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'fj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 yytype 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.yytype')
    onYytypeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'yytype', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 lzqx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.lzqx')
    onLzqxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'lzqx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.bz')
    onBzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 remarks 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.remarks')
    onRemarksChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'remarks', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 isfinished 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.isfinished')
    onIsfinishedChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'isfinished', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmydlzmxid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pcmydlzmxid')
    onPcmydlzmxidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmydlzmxid', newVal: newVal, oldVal: oldVal });
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
            const details: string[] = ['bm', 'zzid', 'yrank', 'ygw', 'pimpersonname', 'zz', 'bmid', 'pimpersonid', 'ygbh', 'yzw', 'lxdh'];
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
        if(data.pcmydlzmx){
            Object.assign(this.context,{pcmydlzmx:data.pcmydlzmx})
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
        copyData.pcmydlzmx = copyData.srfkey;
        copyData.pcmydlzmxid = copyData.srfkey;
        Object.assign(this.context,{pcmydlzmx:copyData.pcmydlzmx})
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
        _this.$print({id:'pcmydlzmx_main',popTitle:'主编辑表单'});
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
            this.$Notice.error({ title: '错误', desc: 'PcmYdlzmxEditView2视图表单loadAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'PcmYdlzmxEditView2视图表单loaddraftAction参数未配置' });
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
            if(data.pcmydlzmx){
                Object.assign(this.context,{pcmydlzmx:data.pcmydlzmx})
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
            this.$Notice.error({ title: '错误', desc: 'PcmYdlzmxEditView2视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PcmYdlzmxEditView2视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PcmYdlzmxEditView2视图表单removeAction参数未配置' });
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
        if (!arg.pcmydlzmx || Object.is(arg.pcmydlzmx, '')) {
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
        if (this.data.hasOwnProperty('sfhmd')) {
            this.data['sfhmd'] = 0;
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