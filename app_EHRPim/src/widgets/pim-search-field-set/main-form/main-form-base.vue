<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='pimsearchfieldset_main' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimsearchfieldset.main_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.pimsearchfieldsetname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='pimsearchfieldsetname' :itemRules="this.rules.pimsearchfieldsetname" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.pimsearchfieldsetname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimsearchfieldsetname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pimsearchfieldsetname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pimsearchfieldsetname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.entityname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='entityname' :itemRules="this.rules.entityname" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.entityname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.entityname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.entityname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.entityname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.entitylogicname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='entitylogicname' :itemRules="this.rules.entitylogicname" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.entitylogicname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.entitylogicname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.entitylogicname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.entitylogicname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.columnlogicname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='columnlogicname' :itemRules="this.rules.columnlogicname" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.columnlogicname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.columnlogicname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.columnlogicname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.columnlogicname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.columnname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='columnname' :itemRules="this.rules.columnname" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.columnname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.columnname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.columnname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.columnname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.tname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='tname' :itemRules="this.rules.tname" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.tname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.tname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.tname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.tname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.vname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='vname' :itemRules="this.rules.vname" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.vname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.vname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.vname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.vname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.fieldtype.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='fieldtype' :itemRules="this.rules.fieldtype" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.fieldtype')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fieldtype.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.fieldtype"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.fieldtype.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.searchtag.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='searchtag' :itemRules="this.rules.searchtag" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.searchtag')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.searchtag.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
  v-model="data.searchtag" 
  :data="data" 
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.searchtag.disabled" 
  style="width:100px;width: 100px;" 
  tag='EhrCodeList0401' 
  codelistType='STATIC'
  placeholder='请选择...'>
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.isshown.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='isshown' :itemRules="this.rules.isshown" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.isshown')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.isshown.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
  v-model="data.isshown" 
  :data="data" 
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.isshown.disabled" 
  style="width:100px;width: 100px;" 
  tag='EhrCodeList0401' 
  codelistType='STATIC'
  placeholder='请选择...'>
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.columnwidth.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='columnwidth' :itemRules="this.rules.columnwidth" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.columnwidth')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.columnwidth.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.columnwidth"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.columnwidth.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pxh.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='pxh' :itemRules="this.rules.pxh" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.pxh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pxh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pxh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pxh.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.codelistid.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='codelistid' :itemRules="this.rules.codelistid" class='' :caption="$t('entities.pimsearchfieldset.main_form.details.codelistid')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.codelistid.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.codelistid"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.codelistid.disabled" type='text'  style=""></input-box>
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
import PimSearchFieldSetService from '@/service/pim-search-field-set/pim-search-field-set-service';
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
     * @type {PimSearchFieldSetService}
     * @memberof MainBase
     */
    public appEntityService: PimSearchFieldSetService = new PimSearchFieldSetService({ $store: this.$store });
    


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
        pimsearchfieldsetname: null,
        entityname: null,
        entitylogicname: null,
        columnlogicname: null,
        columnname: null,
        tname: null,
        vname: null,
        fieldtype: null,
        searchtag: null,
        isshown: null,
        columnwidth: null,
        pxh: null,
        codelistid: null,
        pimsearchfieldsetid: null,
        pimsearchfieldset:null,
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
            { type: 'string', message: '组合查询条件设置标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组合查询条件设置标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组合查询条件设置标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组合查询条件设置标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '组合查询条件设置名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组合查询条件设置名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组合查询条件设置名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组合查询条件设置名称 值不能为空', trigger: 'blur' },
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
        pimsearchfieldsetname: [
            { type: 'string', message: '组合查询条件设置名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组合查询条件设置名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组合查询条件设置名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组合查询条件设置名称 值不能为空', trigger: 'blur' },
        ],
        entityname: [
            { type: 'string', message: '实体名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '实体名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '实体名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '实体名称 值不能为空', trigger: 'blur' },
        ],
        entitylogicname: [
            { type: 'string', message: '实体逻辑名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '实体逻辑名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '实体逻辑名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '实体逻辑名称 值不能为空', trigger: 'blur' },
        ],
        columnlogicname: [
            { type: 'string', message: '列逻辑名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '列逻辑名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '列逻辑名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '列逻辑名称 值不能为空', trigger: 'blur' },
        ],
        columnname: [
            { type: 'string', message: '列名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '列名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '列名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '列名称 值不能为空', trigger: 'blur' },
        ],
        tname: [
            { type: 'string', message: '表名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '表名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '表名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '表名称 值不能为空', trigger: 'blur' },
        ],
        vname: [
            { type: 'string', message: '视图名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '视图名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '视图名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '视图名称 值不能为空', trigger: 'blur' },
        ],
        fieldtype: [
            { type: 'string', message: '属性类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '属性类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '属性类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '属性类型 值不能为空', trigger: 'blur' },
        ],
        searchtag: [
            { type: 'number', message: '是否可查 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否可查 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '是否可查 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '是否可查 值不能为空', trigger: 'blur' },
        ],
        isshown: [
            { type: 'number', message: '是否可见 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否可见 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '是否可见 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '是否可见 值不能为空', trigger: 'blur' },
        ],
        columnwidth: [
            { type: 'number', message: '宽度 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '宽度 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '宽度 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '宽度 值不能为空', trigger: 'blur' },
        ],
        pxh: [
            { type: 'number', message: '排序号 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '排序号 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '排序号 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '排序号 值不能为空', trigger: 'blur' },
        ],
        codelistid: [
            { type: 'string', message: '代码表 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '代码表 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '代码表 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '代码表 值不能为空', trigger: 'blur' },
        ],
        pimsearchfieldsetid: [
            { type: 'string', message: '组合查询条件设置标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组合查询条件设置标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组合查询条件设置标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组合查询条件设置标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof MainBase
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '组合查询条件设置基本信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimsearchfieldset.main_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '组合查询条件设置标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '组合查询条件设置名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimsearchfieldsetname: new FormItemModel({ caption: '组合查询条件设置名称', detailType: 'FORMITEM', name: 'pimsearchfieldsetname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        entityname: new FormItemModel({ caption: '实体名称', detailType: 'FORMITEM', name: 'entityname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        entitylogicname: new FormItemModel({ caption: '实体逻辑名称', detailType: 'FORMITEM', name: 'entitylogicname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        columnlogicname: new FormItemModel({ caption: '列逻辑名称', detailType: 'FORMITEM', name: 'columnlogicname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        columnname: new FormItemModel({ caption: '列名称', detailType: 'FORMITEM', name: 'columnname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        tname: new FormItemModel({ caption: '表名称', detailType: 'FORMITEM', name: 'tname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        vname: new FormItemModel({ caption: '视图名称', detailType: 'FORMITEM', name: 'vname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        fieldtype: new FormItemModel({ caption: '属性类型', detailType: 'FORMITEM', name: 'fieldtype', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        searchtag: new FormItemModel({ caption: '是否可查', detailType: 'FORMITEM', name: 'searchtag', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        isshown: new FormItemModel({ caption: '是否可见', detailType: 'FORMITEM', name: 'isshown', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        columnwidth: new FormItemModel({ caption: '宽度', detailType: 'FORMITEM', name: 'columnwidth', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pxh: new FormItemModel({ caption: '排序号', detailType: 'FORMITEM', name: 'pxh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        codelistid: new FormItemModel({ caption: '代码表', detailType: 'FORMITEM', name: 'codelistid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimsearchfieldsetid: new FormItemModel({ caption: '组合查询条件设置标识', detailType: 'FORMITEM', name: 'pimsearchfieldsetid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
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
     * 监控表单属性 pimsearchfieldsetname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pimsearchfieldsetname')
    onPimsearchfieldsetnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimsearchfieldsetname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 entityname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.entityname')
    onEntitynameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'entityname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 entitylogicname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.entitylogicname')
    onEntitylogicnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'entitylogicname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 columnlogicname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.columnlogicname')
    onColumnlogicnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'columnlogicname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 columnname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.columnname')
    onColumnnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'columnname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 tname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.tname')
    onTnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'tname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 vname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.vname')
    onVnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'vname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 fieldtype 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.fieldtype')
    onFieldtypeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'fieldtype', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 searchtag 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.searchtag')
    onSearchtagChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'searchtag', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 isshown 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.isshown')
    onIsshownChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'isshown', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 columnwidth 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.columnwidth')
    onColumnwidthChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'columnwidth', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pxh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pxh')
    onPxhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pxh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 codelistid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.codelistid')
    onCodelistidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'codelistid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimsearchfieldsetid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pimsearchfieldsetid')
    onPimsearchfieldsetidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimsearchfieldsetid', newVal: newVal, oldVal: oldVal });
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
        if(data.pimsearchfieldset){
            Object.assign(this.context,{pimsearchfieldset:data.pimsearchfieldset})
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
        copyData.pimsearchfieldset = copyData.srfkey;
        copyData.pimsearchfieldsetid = copyData.srfkey;
        Object.assign(this.context,{pimsearchfieldset:copyData.pimsearchfieldset})
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
        _this.$print({id:'pimsearchfieldset_main',popTitle:'主编辑表单'});
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
            this.$Notice.error({ title: '错误', desc: 'PimSearchFieldSetEditView视图表单loadAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'PimSearchFieldSetEditView视图表单loaddraftAction参数未配置' });
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
            if(data.pimsearchfieldset){
                Object.assign(this.context,{pimsearchfieldset:data.pimsearchfieldset})
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
            this.$Notice.error({ title: '错误', desc: 'PimSearchFieldSetEditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PimSearchFieldSetEditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PimSearchFieldSetEditView视图表单removeAction参数未配置' });
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
        if (!arg.pimsearchfieldset || Object.is(arg.pimsearchfieldset, '')) {
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