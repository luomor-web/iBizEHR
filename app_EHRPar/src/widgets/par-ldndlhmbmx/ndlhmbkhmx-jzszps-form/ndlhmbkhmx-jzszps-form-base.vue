<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='parldndlhmbmx_ndlhmbkhmx_jzszps' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.mblx.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
    <app-form-item name='mblx' :itemRules="this.rules.mblx" class='' :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.mblx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.mblx.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.mblx" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.mblx.disabled"  
    tag='EhrCodeList0199' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.parldndlhmbmxname.visible" :style="{}"  :lg="{ span: 18, offset: 0 }">
    <app-form-item name='parldndlhmbmxname' :itemRules="this.rules.parldndlhmbmxname" class='' :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.parldndlhmbmxname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.parldndlhmbmxname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.parldndlhmbmxname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.parldndlhmbmxname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.mblhyq.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='mblhyq' :itemRules="this.rules.mblhyq" class='' :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.mblhyq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.mblhyq.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.mblhyq"  :disabled="detailsModel.mblhyq.disabled" type='textarea' style="" ></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.fz.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='fz' :itemRules="this.rules.fz" class='' :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.fz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fz.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.fz"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.fz.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.khbf.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='khbf' :itemRules="this.rules.khbf" class='' :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.khbf')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.khbf.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.khbf"  :disabled="detailsModel.khbf.disabled" type='textarea' style="" ></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.wcqk.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='wcqk' :itemRules="this.rules.wcqk" class='' :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.wcqk')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.wcqk.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.wcqk"  :disabled="detailsModel.wcqk.disabled" type='textarea' style="" ></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zmcl.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='zmcl' :itemRules="this.rules.zmcl" class='' :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.zmcl')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zmcl.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-file-upload :formState="formState" :ignorefieldvaluechange="ignorefieldvaluechange" @formitemvaluechange="onFormItemValueChange" :data="JSON.stringify(this.data)" name='zmcl' :value="data.zmcl" :disabled="detailsModel.zmcl.disabled" :uploadparams='{}' :exportparams='{}'  style="overflow: auto;"></app-file-upload>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zpfs.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
    <app-form-item name='zpfs' :itemRules="this.rules.zpfs" class='' :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.zpfs')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zpfs.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zpfs"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zpfs.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.fgldpf.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
    <app-form-item name='fgldpf' :itemRules="this.rules.fgldpf" class='' :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.fgldpf')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fgldpf.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.fgldpf"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.fgldpf.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jzszpsfs.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
    <app-form-item name='jzszpsfs' :itemRules="this.rules.jzszpsfs" class='' :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.jzszpsfs')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jzszpsfs.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.jzszpsfs"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.jzszpsfs.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.spzt.visible" :style="{}"  :lg="{ span: 6, offset: 0 }">
    <app-form-item name='spzt' :itemRules="this.rules.spzt" class='' :caption="$t('entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form.details.spzt')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.spzt.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.spzt" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.spzt.disabled"  
    tag='EhrCodeList0209' 
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
import ParLdndlhmbmxService from '@/service/par-ldndlhmbmx/par-ldndlhmbmx-service';
import NDLHMBKHMX_JZSZPSService from './ndlhmbkhmx-jzszps-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class NDLHMBKHMX_JZSZPSBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {NDLHMBKHMX_JZSZPSService}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public service: NDLHMBKHMX_JZSZPSService = new NDLHMBKHMX_JZSZPSService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {ParLdndlhmbmxService}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public appEntityService: ParLdndlhmbmxService = new ParLdndlhmbmxService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof NDLHMBKHMX_JZSZPSBase
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
        parldndlhmbid: null,
        parldndlhmbname: null,
        mblx: null,
        parldndlhmbmxname: null,
        mblhyq: null,
        fz: null,
        khbf: null,
        zt: null,
        xgrz: null,
        wcqk: null,
        zmcl: null,
        zpfs: null,
        fgldpf: null,
        jzszpsfs: null,
        spzt: null,
        parldndlhmbmxid: null,
        parldndlhmbmx:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof NDLHMBKHMX_JZSZPSBase
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof NDLHMBKHMX_JZSZPSBase
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof NDLHMBKHMX_JZSZPSBase
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof NDLHMBKHMX_JZSZPSBase
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof NDLHMBKHMX_JZSZPSBase
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
            { type: 'string', message: '量化目标明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '量化目标明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '量化目标明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '量化目标明细标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '量化目标 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '量化目标 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '量化目标 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '量化目标 值不能为空', trigger: 'blur' },
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
        parldndlhmbid: [
            { type: 'string', message: '年度量化目标ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '年度量化目标ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '年度量化目标ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '年度量化目标ID 值不能为空', trigger: 'blur' },
        ],
        parldndlhmbname: [
            { type: 'string', message: '年度量化目标名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '年度量化目标名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '年度量化目标名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '年度量化目标名称 值不能为空', trigger: 'blur' },
        ],
        mblx: [
            { type: 'string', message: '目标类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '目标类型 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '目标类型 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '目标类型 值不能为空', trigger: 'blur' },
        ],
        parldndlhmbmxname: [
            { type: 'string', message: '量化目标 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '量化目标 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '量化目标 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '量化目标 值不能为空', trigger: 'blur' },
        ],
        mblhyq: [
            { type: 'string', message: '目标量化要求 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '目标量化要求 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '目标量化要求 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '目标量化要求 值不能为空', trigger: 'blur' },
        ],
        fz: [
            { type: 'number', message: '分值 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '分值 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '分值 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '分值 值不能为空', trigger: 'blur' },
        ],
        khbf: [
            { type: 'string', message: '考核办法 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '考核办法 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '考核办法 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '考核办法 值不能为空', trigger: 'blur' },
        ],
        zt: [
            { type: 'string', message: '状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '状态 值不能为空', trigger: 'blur' },
        ],
        xgrz: [
            { type: 'string', message: '修改日志 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '修改日志 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '修改日志 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '修改日志 值不能为空', trigger: 'blur' },
        ],
        wcqk: [
            { type: 'string', message: '完成情况 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '完成情况 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '完成情况 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '完成情况 值不能为空', trigger: 'blur' },
        ],
        zmcl: [
            { type: 'string', message: '证明材料 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证明材料 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '证明材料 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '证明材料 值不能为空', trigger: 'blur' },
        ],
        zpfs: [
            { type: 'number', message: '自评分数 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '自评分数 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '自评分数 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '自评分数 值不能为空', trigger: 'blur' },
        ],
        fgldpf: [
            { type: 'number', message: '分管领导评分 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '分管领导评分 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '分管领导评分 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '分管领导评分 值不能为空', trigger: 'blur' },
        ],
        jzszpsfs: [
            { type: 'number', message: '集中述职评审分数 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '集中述职评审分数 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '集中述职评审分数 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '集中述职评审分数 值不能为空', trigger: 'blur' },
        ],
        spzt: [
            { type: 'string', message: '审批状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '审批状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '审批状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '审批状态 值不能为空', trigger: 'blur' },
        ],
        parldndlhmbmxid: [
            { type: 'string', message: '量化目标明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '量化目标明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '量化目标明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '量化目标明细标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '年度量化目标明细', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.parldndlhmbmx.ndlhmbkhmx_jzszps_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '量化目标明细标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '量化目标', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        parldndlhmbid: new FormItemModel({ caption: '年度量化目标ID', detailType: 'FORMITEM', name: 'parldndlhmbid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        parldndlhmbname: new FormItemModel({ caption: '年度量化目标名称', detailType: 'FORMITEM', name: 'parldndlhmbname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        mblx: new FormItemModel({ caption: '目标类型', detailType: 'FORMITEM', name: 'mblx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        parldndlhmbmxname: new FormItemModel({ caption: '量化目标', detailType: 'FORMITEM', name: 'parldndlhmbmxname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        mblhyq: new FormItemModel({ caption: '目标量化要求', detailType: 'FORMITEM', name: 'mblhyq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        fz: new FormItemModel({ caption: '分值', detailType: 'FORMITEM', name: 'fz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        khbf: new FormItemModel({ caption: '考核办法', detailType: 'FORMITEM', name: 'khbf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zt: new FormItemModel({ caption: '状态', detailType: 'FORMITEM', name: 'zt', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        xgrz: new FormItemModel({ caption: '修改日志', detailType: 'FORMITEM', name: 'xgrz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        wcqk: new FormItemModel({ caption: '完成情况', detailType: 'FORMITEM', name: 'wcqk', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zmcl: new FormItemModel({ caption: '证明材料', detailType: 'FORMITEM', name: 'zmcl', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zpfs: new FormItemModel({ caption: '自评分数', detailType: 'FORMITEM', name: 'zpfs', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        fgldpf: new FormItemModel({ caption: '分管领导评分', detailType: 'FORMITEM', name: 'fgldpf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jzszpsfs: new FormItemModel({ caption: '集中述职评审分数', detailType: 'FORMITEM', name: 'jzszpsfs', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        spzt: new FormItemModel({ caption: '审批状态', detailType: 'FORMITEM', name: 'spzt', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        parldndlhmbmxid: new FormItemModel({ caption: '量化目标明细标识', detailType: 'FORMITEM', name: 'parldndlhmbmxid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 parldndlhmbid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.parldndlhmbid')
    onParldndlhmbidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'parldndlhmbid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 parldndlhmbname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.parldndlhmbname')
    onParldndlhmbnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'parldndlhmbname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 mblx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.mblx')
    onMblxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'mblx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 parldndlhmbmxname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.parldndlhmbmxname')
    onParldndlhmbmxnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'parldndlhmbmxname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 mblhyq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.mblhyq')
    onMblhyqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'mblhyq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 fz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.fz')
    onFzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'fz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 khbf 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.khbf')
    onKhbfChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'khbf', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zt 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.zt')
    onZtChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zt', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xgrz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.xgrz')
    onXgrzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xgrz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 wcqk 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.wcqk')
    onWcqkChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'wcqk', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zmcl 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.zmcl')
    onZmclChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zmcl', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zpfs 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.zpfs')
    onZpfsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zpfs', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 fgldpf 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.fgldpf')
    onFgldpfChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'fgldpf', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jzszpsfs 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.jzszpsfs')
    onJzszpsfsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jzszpsfs', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 spzt 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.spzt')
    onSpztChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'spzt', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 parldndlhmbmxid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    @Watch('data.parldndlhmbmxid')
    onParldndlhmbmxidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'parldndlhmbmxid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                


























    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.parldndlhmbmx){
            Object.assign(this.context,{parldndlhmbmx:data.parldndlhmbmx})
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof @memberof NDLHMBKHMX_JZSZPSBase
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.parldndlhmbmx = copyData.srfkey;
        copyData.parldndlhmbmxid = copyData.srfkey;
        Object.assign(this.context,{parldndlhmbmx:copyData.parldndlhmbmx})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof NDLHMBKHMX_JZSZPSBase
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'parldndlhmbmx_ndlhmbkhmx_jzszps',popTitle:'年度量化目标考核明细（集中述职评审）'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'ParLdndlhmbmxKHEditView视图表单loadAction参数未配置' });
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'ParLdndlhmbmxKHEditView视图表单loaddraftAction参数未配置' });
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
            if(data.parldndlhmbmx){
                Object.assign(this.context,{parldndlhmbmx:data.parldndlhmbmx})
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
            this.$Notice.error({ title: '错误', desc: 'ParLdndlhmbmxKHEditView视图表单'+actionName+'参数未配置' });
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
                this.$Notice.error({ title: '错误', desc: 'ParLdndlhmbmxKHEditView视图表单'+actionName+'参数未配置' });
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
    * @memberof NDLHMBKHMX_JZSZPSBase
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'ParLdndlhmbmxKHEditView视图表单removeAction参数未配置' });
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.parldndlhmbmx || Object.is(arg.parldndlhmbmx, '')) {
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
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
    * @memberof NDLHMBKHMX_JZSZPSBase
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
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public createDefault(){                    
    }

    /**
     * 更新默认值
     * @memberof NDLHMBKHMX_JZSZPSBase
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './ndlhmbkhmx-jzszps-form.less';
</style>