<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='ormorgsector_bmbzgl' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.ormorgsector.bmbzgl_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="1" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.ordervalue.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ordervalue' :itemRules="this.rules.ordervalue" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.ordervalue')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ordervalue.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ordervalue"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ordervalue.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.orgsectorname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='orgsectorname' :itemRules="this.rules.orgsectorname" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.orgsectorname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.orgsectorname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.orgsectorname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.orgsectorname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.orgcode.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='orgcode' :itemRules="this.rules.orgcode" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.orgcode')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.orgcode.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.orgcode"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.orgcode.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.shortname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='shortname' :itemRules="this.rules.shortname" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.shortname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.shortname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.shortname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.shortname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bmlx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='bmlx' :itemRules="this.rules.bmlx" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.bmlx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bmlx.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.bmlx" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.bmlx.disabled"  
    tag='EhrCodeList0019' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.orgname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='orgname' :itemRules="this.rules.orgname" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.orgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.orgname.error" :isEmptyCaption="false" labelPos="LEFT">
    
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
  :acParams="{ serviceName: 'OrmOrgService', interfaceName: 'FetchKZXLXZ'}"
  valueitem='orgid' 
  :value="data.orgname" 
  editortype="" 
  :pickupView="{ viewname: 'ormorgxmbqpickup-view', title: $t('entities.ormorg.views.xmbqpickupview.title'), deResParameters: [], parameters: [{ pathName: 'ormorgs', parameterName: 'ormorg' }, { pathName: 'xmbqpickupview', parameterName: 'xmbqpickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.belongregion.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='belongregion' :itemRules="this.rules.belongregion" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.belongregion')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.belongregion.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.belongregion" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.belongregion.disabled"  
    tag='EhrCodeList0250' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.qy.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='qy' :itemRules="this.rules.qy" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.qy')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.qy.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.qy" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.qy.disabled"  
    tag='EhrCodeList0219' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gkjz.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='gkjz' :itemRules="this.rules.gkjz" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.gkjz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gkjz.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.gkjz" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.gkjz.disabled"  
    tag='EhrCodeList0156' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bmbzrs.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='bmbzrs' :itemRules="this.rules.bmbzrs" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.bmbzrs')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bmbzrs.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bmbzrs"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.bmbzrs.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.startstopsign.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='startstopsign' :itemRules="this.rules.startstopsign" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.startstopsign')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.startstopsign.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-radio-group 
  v-model="data.startstopsign"
  :data="data" 
  :context="context"
  :viewparams="viewparams"   
  :disabled="detailsModel.startstopsign.disabled"  
  name="startstopsign" 
  :localContext ='{ }' 
  :localParam ='{ }' 
  tag='EhrCodeList0086' 
  codelistType='STATIC' 
  style="">
</app-radio-group>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.belongou.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='belongou' :itemRules="this.rules.belongou" class='' :caption="$t('entities.ormorgsector.bmbzgl_form.details.belongou')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.belongou.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.belongou"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.belongou.disabled" type='text'  style=""></input-box>
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
import OrmOrgsectorService from '@/service/orm-orgsector/orm-orgsector-service';
import BMBZGLService from './bmbzgl-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class BMBZGLBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof BMBZGLBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof BMBZGLBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof BMBZGLBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof BMBZGLBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof BMBZGLBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof BMBZGLBase
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof BMBZGLBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {BMBZGLService}
     * @memberof BMBZGLBase
     */
    public service: BMBZGLService = new BMBZGLService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {OrmOrgsectorService}
     * @memberof BMBZGLBase
     */
    public appEntityService: OrmOrgsectorService = new OrmOrgsectorService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof BMBZGLBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof BMBZGLBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof BMBZGLBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof BMBZGLBase
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof BMBZGLBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof BMBZGLBase
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof BMBZGLBase
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof BMBZGLBase
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof BMBZGLBase
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof BMBZGLBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof BMBZGLBase
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof BMBZGLBase
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof BMBZGLBase
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof BMBZGLBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof BMBZGLBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof BMBZGLBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof BMBZGLBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof BMBZGLBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof BMBZGLBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof BMBZGLBase
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
        ordervalue: null,
        orgsectorname: null,
        orgcode: null,
        shortname: null,
        bmlx: null,
        orgname: null,
        belongregion: null,
        qy: null,
        gkjz: null,
        bmbzrs: null,
        sjbzrs: null,
        startstopsign: null,
        belongou: null,
        orgid: null,
        referjoblevel: null,
        orgtype: null,
        orgsectorid: null,
        ormorgsector:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof BMBZGLBase
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof BMBZGLBase
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof BMBZGLBase
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof BMBZGLBase
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof BMBZGLBase
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
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '部门名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门名称 值不能为空', trigger: 'blur' },
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
        ordervalue: [
            { type: 'number', message: '排序 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '排序 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '排序 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '排序 值不能为空', trigger: 'blur' },
        ],
        orgsectorname: [
            { type: 'string', message: '名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '名称 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '名称 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '名称 值不能为空', trigger: 'blur' },
        ],
        orgcode: [
            { type: 'string', message: '编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '编号 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '编号 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '编号 值不能为空', trigger: 'blur' },
        ],
        shortname: [
            { type: 'string', message: '简称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '简称 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '简称 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '简称 值不能为空', trigger: 'blur' },
        ],
        bmlx: [
            { type: 'string', message: '类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '类型 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '类型 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '类型 值不能为空', trigger: 'blur' },
        ],
        orgname: [
            { type: 'string', message: '所属组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属组织 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '所属组织 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '所属组织 值不能为空', trigger: 'blur' },
        ],
        belongregion: [
            { type: 'string', message: '所属区域 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属区域 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所属区域 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所属区域 值不能为空', trigger: 'blur' },
        ],
        qy: [
            { type: 'string', message: '补贴标准 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '补贴标准 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '补贴标准 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '补贴标准 值不能为空', trigger: 'blur' },
        ],
        gkjz: [
            { type: 'string', message: '编制控制 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '编制控制 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '编制控制 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '编制控制 值不能为空', trigger: 'blur' },
        ],
        bmbzrs: [
            { type: 'number', message: '人数编制 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '人数编制 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '人数编制 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '人数编制 值不能为空', trigger: 'blur' },
        ],
        sjbzrs: [
            { type: 'string', message: '实际编制人数 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '实际编制人数 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '实际编制人数 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '实际编制人数 值不能为空', trigger: 'blur' },
        ],
        startstopsign: [
            { type: 'string', message: '启停标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '启停标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '启停标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '启停标识 值不能为空', trigger: 'blur' },
        ],
        belongou: [
            { type: 'string', message: '所属OU 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属OU 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所属OU 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所属OU 值不能为空', trigger: 'blur' },
        ],
        orgid: [
            { type: 'string', message: '组织机构标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织机构标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织机构标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织机构标识 值不能为空', trigger: 'blur' },
        ],
        referjoblevel: [
            { type: 'string', message: '参照职务层级 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '参照职务层级 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '参照职务层级 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '参照职务层级 值不能为空', trigger: 'blur' },
        ],
        orgtype: [
            { type: 'string', message: '组织类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织类型 值不能为空', trigger: 'blur' },
        ],
        orgsectorid: [
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof BMBZGLBase
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '部门/项目部信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.ormorgsector.bmbzgl_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '部门信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '部门标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '部门名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ordervalue: new FormItemModel({ caption: '排序', detailType: 'FORMITEM', name: 'ordervalue', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        orgsectorname: new FormItemModel({ caption: '名称', detailType: 'FORMITEM', name: 'orgsectorname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        orgcode: new FormItemModel({ caption: '编号', detailType: 'FORMITEM', name: 'orgcode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        shortname: new FormItemModel({ caption: '简称', detailType: 'FORMITEM', name: 'shortname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bmlx: new FormItemModel({ caption: '类型', detailType: 'FORMITEM', name: 'bmlx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        orgname: new FormItemModel({ caption: '所属组织', detailType: 'FORMITEM', name: 'orgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        belongregion: new FormItemModel({ caption: '所属区域', detailType: 'FORMITEM', name: 'belongregion', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        qy: new FormItemModel({ caption: '补贴标准', detailType: 'FORMITEM', name: 'qy', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gkjz: new FormItemModel({ caption: '编制控制', detailType: 'FORMITEM', name: 'gkjz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bmbzrs: new FormItemModel({ caption: '人数编制', detailType: 'FORMITEM', name: 'bmbzrs', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sjbzrs: new FormItemModel({ caption: '实际编制人数', detailType: 'FORMITEM', name: 'sjbzrs', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        startstopsign: new FormItemModel({ caption: '启停标识', detailType: 'FORMITEM', name: 'startstopsign', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        belongou: new FormItemModel({ caption: '所属OU', detailType: 'FORMITEM', name: 'belongou', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        orgid: new FormItemModel({ caption: '组织机构标识', detailType: 'FORMITEM', name: 'orgid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        referjoblevel: new FormItemModel({ caption: '参照职务层级', detailType: 'FORMITEM', name: 'referjoblevel', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        orgtype: new FormItemModel({ caption: '组织类型', detailType: 'FORMITEM', name: 'orgtype', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        orgsectorid: new FormItemModel({ caption: '部门标识', detailType: 'FORMITEM', name: 'orgsectorid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ordervalue 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.ordervalue')
    onOrdervalueChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ordervalue', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgsectorname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.orgsectorname')
    onOrgsectornameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgsectorname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgcode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.orgcode')
    onOrgcodeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgcode', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 shortname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.shortname')
    onShortnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'shortname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bmlx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.bmlx')
    onBmlxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bmlx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.orgname')
    onOrgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 belongregion 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.belongregion')
    onBelongregionChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'belongregion', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 qy 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.qy')
    onQyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'qy', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gkjz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.gkjz')
    onGkjzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gkjz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bmbzrs 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.bmbzrs')
    onBmbzrsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bmbzrs', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sjbzrs 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.sjbzrs')
    onSjbzrsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sjbzrs', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 startstopsign 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.startstopsign')
    onStartstopsignChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'startstopsign', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 belongou 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.belongou')
    onBelongouChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'belongou', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.orgid')
    onOrgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 referjoblevel 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.referjoblevel')
    onReferjoblevelChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'referjoblevel', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgtype 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.orgtype')
    onOrgtypeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgtype', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgsectorid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof BMBZGLBase
     */
    @Watch('data.orgsectorid')
    onOrgsectoridChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgsectorid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof BMBZGLBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                


















        if (Object.is(name, '') || Object.is(name, 'startstopsign')) {
            let ret = true;
            const _startstopsign = this.data.startstopsign;
            if (this.$verify.testCond(_startstopsign, 'NOTEQ', '1')) {
                ret = false;
            }
            this.rules.gkjz.some((rule: any) => {
                if (rule.hasOwnProperty('required')) {
                    rule.required = ret;
                }
                return false;
            });
        }

        if (Object.is(name, '') || Object.is(name, 'startstopsign')) {
            let ret = true;
            const _startstopsign = this.data.startstopsign;
            if (this.$verify.testCond(_startstopsign, 'NOTEQ', '1')) {
                ret = false;
            }
            this.rules.bmbzrs.some((rule: any) => {
                if (rule.hasOwnProperty('required')) {
                    rule.required = ret;
                }
                return false;
            });
        }








    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.ormorgsector){
            Object.assign(this.context,{ormorgsector:data.ormorgsector})
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof BMBZGLBase
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
     * @memberof @memberof BMBZGLBase
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.ormorgsector = copyData.srfkey;
        copyData.orgsectorid = copyData.srfkey;
        Object.assign(this.context,{ormorgsector:copyData.ormorgsector})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof BMBZGLBase
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'ormorgsector_bmbzgl',popTitle:'部门/项目部信息<主编辑>'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'ORMORGSECTOREditView9_EditMode视图表单loadAction参数未配置' });
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
     * @memberof BMBZGLBase
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'ORMORGSECTOREditView9_EditMode视图表单loaddraftAction参数未配置' });
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
            if(data.ormorgsector){
                Object.assign(this.context,{ormorgsector:data.ormorgsector})
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
     * @memberof BMBZGLBase
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
            this.$Notice.error({ title: '错误', desc: 'ORMORGSECTOREditView9_EditMode视图表单'+actionName+'参数未配置' });
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
     * @memberof BMBZGLBase
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
                this.$Notice.error({ title: '错误', desc: 'ORMORGSECTOREditView9_EditMode视图表单'+actionName+'参数未配置' });
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
    * @memberof BMBZGLBase
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'ORMORGSECTOREditView9_EditMode视图表单removeAction参数未配置' });
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.ormorgsector || Object.is(arg.ormorgsector, '')) {
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
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
    * @memberof BMBZGLBase
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
     * @memberof BMBZGLBase
     */
    public createDefault(){                    
        if (this.data.hasOwnProperty('gkjz')) {
            this.data['gkjz'] = '20';
        }
        if (this.data.hasOwnProperty('startstopsign')) {
            this.data['startstopsign'] = '1';
        }
    }

    /**
     * 更新默认值
     * @memberof BMBZGLBase
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './bmbzgl-form.less';
</style>