<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='vacleavedetail_jhqjmx' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.vacleavedetail.jhqjmx_form.details.group1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.pimpersonname.visible" :style="{}"  :lg="{ span: 9, offset: 0 }" :xl="{ span: 9, offset: 0 }">
    <app-form-item name='pimpersonname' :itemRules="this.rules.pimpersonname" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.pimpersonname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimpersonname.error" :isEmptyCaption="false" labelPos="LEFT">
    
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
  :pickupView="{ viewname: 'pim-person-pickup-view', title: $t('entities.pimperson.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'pimpeople', parameterName: 'pimperson' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.qjzl.visible" :style="{}"  :lg="{ span: 9, offset: 0 }" :xl="{ span: 9, offset: 0 }">
    <app-form-item name='qjzl' :itemRules="this.rules.qjzl" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.qjzl')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.qjzl.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.qjzl" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.qjzl.disabled"  
    tag='EhrCodeList0013' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.hyzk.visible" :style="{}"  :lg="{ span: 9, offset: 0 }" :xl="{ span: 9, offset: 0 }">
    <app-form-item name='hyzk' :itemRules="this.rules.hyzk" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.hyzk')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.hyzk.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.hyzk" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.hyzk.disabled"  
    tag='EhrCodeList0075' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.tqlx.visible" :style="{}"  :lg="{ span: 9, offset: 0 }" :xl="{ span: 9, offset: 0 }">
    <app-form-item name='tqlx' :itemRules="this.rules.tqlx" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.tqlx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.tqlx.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.tqlx" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.tqlx.disabled"  
    tag='EhrCodeList0245' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.njsy.visible" :style="{}"  :lg="{ span: 18, offset: 0 }">
    <app-form-item name='njsy' :itemRules="this.rules.njsy" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.njsy')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.njsy.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='njsy' :value="data.njsy" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.tips.visible" :style="{}"  :lg="{ span: 18, offset: 0 }">
    <app-form-item name='tips' :itemRules="this.rules.tips" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.tips')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.tips.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='tips' :value="data.tips" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.grouppanel1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.vacleavedetail.jhqjmx_form.details.grouppanel1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.jhkssj.visible" :style="{}"  :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
    <app-form-item name='jhkssj' :itemRules="this.rules.jhkssj" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.jhkssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jhkssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.jhkssj" :disabled="detailsModel.jhkssj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.jhkssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jhkssxw.visible" :style="{}"  :lg="{ span: 3, offset: 0 }" :xl="{ span: 3, offset: 0 }">
    <app-form-item name='jhkssxw' :itemRules="this.rules.jhkssxw" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.jhkssxw')" uiStyle="DEFAULT" :labelWidth="0" :isShowCaption="false" :error="detailsModel.jhkssxw.error" :isEmptyCaption="false" labelPos="NONE">
    
 <dropdown-list 
    v-model="data.jhkssxw" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.jhkssxw.disabled"  
    tag='EhrCodeList0110' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jhjssj.visible" :style="{}"  :lg="{ span: 6, offset: 0 }" :xl="{ span: 6, offset: 0 }">
    <app-form-item name='jhjssj' :itemRules="this.rules.jhjssj" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.jhjssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jhjssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.jhjssj" :disabled="detailsModel.jhjssj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.jhjssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jhjssxw.visible" :style="{}"  :lg="{ span: 3, offset: 0 }" :xl="{ span: 3, offset: 0 }">
    <app-form-item name='jhjssxw' :itemRules="this.rules.jhjssxw" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.jhjssxw')" uiStyle="DEFAULT" :labelWidth="0" :isShowCaption="false" :error="detailsModel.jhjssxw.error" :isEmptyCaption="false" labelPos="NONE">
    
 <dropdown-list 
    v-model="data.jhjssxw" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.jhjssxw.disabled"  
    tag='EhrCodeList0110' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jhts.visible" :style="{}"  :lg="{ span: 9, offset: 0 }" :xl="{ span: 9, offset: 0 }">
    <app-form-item name='jhts' :itemRules="this.rules.jhts" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.jhts')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jhts.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.jhts"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.jhts.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.state.visible" :style="{}"  :lg="{ span: 9, offset: 0 }" :xl="{ span: 9, offset: 0 }">
    <app-form-item name='state' :itemRules="this.rules.state" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.state')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.state.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.state" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.state.disabled"  
    tag='EhrCodeList0134' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.fj.visible" :style="{}"  :lg="{ span: 18, offset: 0 }">
    <app-form-item name='fj' :itemRules="this.rules.fj" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.fj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fj.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-file-upload :formState="formState" :ignorefieldvaluechange="ignorefieldvaluechange" @formitemvaluechange="onFormItemValueChange" :data="JSON.stringify(this.data)" name='fj' :value="data.fj" :disabled="detailsModel.fj.disabled" :uploadparams='{}' :exportparams='{}'  style="overflow: auto;"></app-file-upload>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bz.visible" :style="{}"  :lg="{ span: 18, offset: 0 }">
    <app-form-item name='bz' :itemRules="this.rules.bz" class='' :caption="$t('entities.vacleavedetail.jhqjmx_form.details.bz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bz.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bz"  :disabled="detailsModel.bz.disabled" type='textarea' style="" ></input-box>
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
import VacLeaveDetailService from '@/service/vac-leave-detail/vac-leave-detail-service';
import JHQJMXService from './jhqjmx-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class JHQJMXBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof JHQJMXBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof JHQJMXBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof JHQJMXBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof JHQJMXBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof JHQJMXBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof JHQJMXBase
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof JHQJMXBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {JHQJMXService}
     * @memberof JHQJMXBase
     */
    public service: JHQJMXService = new JHQJMXService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {VacLeaveDetailService}
     * @memberof JHQJMXBase
     */
    public appEntityService: VacLeaveDetailService = new VacLeaveDetailService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof JHQJMXBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof JHQJMXBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof JHQJMXBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof JHQJMXBase
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof JHQJMXBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof JHQJMXBase
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof JHQJMXBase
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof JHQJMXBase
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof JHQJMXBase
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof JHQJMXBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof JHQJMXBase
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof JHQJMXBase
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof JHQJMXBase
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof JHQJMXBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof JHQJMXBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof JHQJMXBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof JHQJMXBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof JHQJMXBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof JHQJMXBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof JHQJMXBase
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
        pimpersonname: null,
        qjzl: null,
        hyzk: null,
        tqlx: null,
        njsy: null,
        tips: null,
        jhkssj: null,
        jhkssxw: null,
        jhjssj: null,
        jhjssxw: null,
        jhts: null,
        state: null,
        fj: null,
        bz: null,
        pimpersonid: null,
        vacleavedetailid: null,
        vacleavedetail:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof JHQJMXBase
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof JHQJMXBase
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof JHQJMXBase
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof JHQJMXBase
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof JHQJMXBase
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
            { type: 'string', message: '请销假明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '请销假明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '请销假明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '请销假明细标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '请销假明细名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '请销假明细名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '请销假明细名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '请销假明细名称 值不能为空', trigger: 'blur' },
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
        pimpersonname: [
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
        ],
        qjzl: [
            { type: 'string', message: '请假种类 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '请假种类 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '请假种类 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '请假种类 值不能为空', trigger: 'blur' },
        ],
        hyzk: [
            { type: 'string', message: '婚姻状况 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '婚姻状况 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '婚姻状况 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '婚姻状况 值不能为空', trigger: 'blur' },
        ],
        tqlx: [
            { type: 'string', message: '探亲类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '探亲类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '探亲类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '探亲类型 值不能为空', trigger: 'blur' },
        ],
        njsy: [
            { type: 'string', message: '假期使用情况 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '假期使用情况 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '假期使用情况 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '假期使用情况 值不能为空', trigger: 'blur' },
        ],
        tips: [
            { type: 'string', message: '温馨提示 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '温馨提示 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '温馨提示 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '温馨提示 值不能为空', trigger: 'blur' },
        ],
        jhkssj: [
            { type: 'string', message: '计划开始时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '计划开始时间 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '计划开始时间 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '计划开始时间 值不能为空', trigger: 'blur' },
        ],
        jhkssxw: [
            { type: 'string', message: '计划开始上下午 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '计划开始上下午 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '计划开始上下午 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '计划开始上下午 值不能为空', trigger: 'blur' },
        ],
        jhjssj: [
            { type: 'string', message: '计划结束时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '计划结束时间 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '计划结束时间 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '计划结束时间 值不能为空', trigger: 'blur' },
        ],
        jhjssxw: [
            { type: 'string', message: '计划结束上下午 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '计划结束上下午 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '计划结束上下午 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '计划结束上下午 值不能为空', trigger: 'blur' },
        ],
        jhts: [
            { type: 'number', message: '计划天数 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '计划天数 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '计划天数 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '计划天数 值不能为空', trigger: 'blur' },
        ],
        state: [
            { type: 'string', message: '状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '状态 值不能为空', trigger: 'blur' },
        ],
        fj: [
            { type: 'string', message: '附件 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '附件 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '附件 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '附件 值不能为空', trigger: 'blur' },
        ],
        bz: [
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'blur' },
        ],
        pimpersonid: [
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
        ],
        vacleavedetailid: [
            { type: 'string', message: '请销假明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '请销假明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '请销假明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '请销假明细标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof JHQJMXBase
     */
    public detailsModel: any = {
        grouppanel1: new FormGroupPanelModel({ caption: '计划', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.vacleavedetail.jhqjmx_form', extractMode: 'ITEM', details: [] } })
, 
        group1: new FormGroupPanelModel({ caption: '请假明细', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.vacleavedetail.jhqjmx_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '请销假明细标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '请销假明细名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonname: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'pimpersonname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        qjzl: new FormItemModel({ caption: '请假种类', detailType: 'FORMITEM', name: 'qjzl', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        hyzk: new FormItemModel({ caption: '婚姻状况', detailType: 'FORMITEM', name: 'hyzk', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        tqlx: new FormItemModel({ caption: '探亲类型', detailType: 'FORMITEM', name: 'tqlx', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        njsy: new FormItemModel({ caption: '假期使用情况', detailType: 'FORMITEM', name: 'njsy', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        tips: new FormItemModel({ caption: '温馨提示', detailType: 'FORMITEM', name: 'tips', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        jhkssj: new FormItemModel({ caption: '计划开始时间', detailType: 'FORMITEM', name: 'jhkssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jhkssxw: new FormItemModel({ caption: '计划开始上下午', detailType: 'FORMITEM', name: 'jhkssxw', visible: true, isShowCaption: false, form: this, disabled: false, enableCond: 3 })
, 
        jhjssj: new FormItemModel({ caption: '计划结束时间', detailType: 'FORMITEM', name: 'jhjssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jhjssxw: new FormItemModel({ caption: '计划结束上下午', detailType: 'FORMITEM', name: 'jhjssxw', visible: true, isShowCaption: false, form: this, disabled: false, enableCond: 3 })
, 
        jhts: new FormItemModel({ caption: '计划天数', detailType: 'FORMITEM', name: 'jhts', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        state: new FormItemModel({ caption: '状态', detailType: 'FORMITEM', name: 'state', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        fj: new FormItemModel({ caption: '附件', detailType: 'FORMITEM', name: 'fj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bz: new FormItemModel({ caption: '备注', detailType: 'FORMITEM', name: 'bz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonid: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'pimpersonid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        vacleavedetailid: new FormItemModel({ caption: '请销假明细标识', detailType: 'FORMITEM', name: 'vacleavedetailid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.pimpersonname')
    onPimpersonnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 qjzl 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.qjzl')
    onQjzlChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'qjzl', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 hyzk 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.hyzk')
    onHyzkChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'hyzk', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 tqlx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.tqlx')
    onTqlxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'tqlx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 njsy 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.njsy')
    onNjsyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'njsy', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 tips 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.tips')
    onTipsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'tips', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jhkssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.jhkssj')
    onJhkssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jhkssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jhkssxw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.jhkssxw')
    onJhkssxwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jhkssxw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jhjssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.jhjssj')
    onJhjssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jhjssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jhjssxw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.jhjssxw')
    onJhjssxwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jhjssxw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jhts 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.jhts')
    onJhtsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jhts', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 state 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.state')
    onStateChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'state', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 fj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.fj')
    onFjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'fj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.bz')
    onBzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.pimpersonid')
    onPimpersonidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 vacleavedetailid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof JHQJMXBase
     */
    @Watch('data.vacleavedetailid')
    onVacleavedetailidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'vacleavedetailid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof JHQJMXBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                













        if (Object.is(name, '') || Object.is(name, 'qjzl')) {
            let ret = false;
            const _qjzl = this.data.qjzl;
            if (this.$verify.testCond(_qjzl, 'EQ', 'TQ')) {
                ret = true;
            }
            this.detailsModel.hyzk.setVisible(ret);
        }

        if (Object.is(name, '') || Object.is(name, 'hyzk')) {
            let ret = false;
            const _hyzk = this.data.hyzk;
            if (this.$verify.testCond(_hyzk, 'EQ', '20')) {
                ret = true;
            }
            this.detailsModel.tqlx.setDisabled(!ret);
        }
        if (Object.is(name, '') || Object.is(name, 'qjzl')) {
            let ret = false;
            const _qjzl = this.data.qjzl;
            if (this.$verify.testCond(_qjzl, 'EQ', 'TQ')) {
                ret = true;
            }
            this.detailsModel.tqlx.setVisible(ret);
        }

        if (Object.is(name, '') || Object.is(name, 'qjzl')) {
            let ret = false;
            const _qjzl = this.data.qjzl;
            if (this.$verify.testCond(_qjzl, 'ISNOTNULL', '')) {
                ret = true;
            }
            this.detailsModel.njsy.setVisible(ret);
        }

        if (Object.is(name, '') || Object.is(name, 'tips')) {
            let ret = false;
            const _tips = this.data.tips;
            if (this.$verify.testCond(_tips, 'ISNOTNULL', '')) {
                ret = true;
            }
            this.detailsModel.tips.setVisible(ret);
        }












        if(Object.is(name, 'qjzl')){
            const details: string[] = ['tqlx', 'jhts', 'tips', 'hyzk', 'njsy'];
            this.updateFormItems('GetNianJia', this.data, details, true);
        }

        if(Object.is(name, 'jhkssj')){
            const details: string[] = ['jhts'];
            this.updateFormItems('CalcPlanDays', this.data, details, true);
        }

        if(Object.is(name, 'jhkssxw')){
            const details: string[] = ['jhts'];
            this.updateFormItems('CalcPlanDays', this.data, details, true);
        }

        if(Object.is(name, 'jhjssj')){
            const details: string[] = ['jhts'];
            this.updateFormItems('CalcPlanDays', this.data, details, true);
        }

        if(Object.is(name, 'jhjssxw')){
            const details: string[] = ['jhts'];
            this.updateFormItems('CalcPlanDays', this.data, details, true);
        }
    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.vacleavedetail){
            Object.assign(this.context,{vacleavedetail:data.vacleavedetail})
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof JHQJMXBase
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
     * @memberof @memberof JHQJMXBase
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.vacleavedetail = copyData.srfkey;
        copyData.vacleavedetailid = copyData.srfkey;
        Object.assign(this.context,{vacleavedetail:copyData.vacleavedetail})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof JHQJMXBase
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'vacleavedetail_jhqjmx',popTitle:'计划请假明细'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'VacLeaveDetailEditView视图表单loadAction参数未配置' });
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
     * @memberof JHQJMXBase
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'VacLeaveDetailEditView视图表单loaddraftAction参数未配置' });
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
            if(data.vacleavedetail){
                Object.assign(this.context,{vacleavedetail:data.vacleavedetail})
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
     * @memberof JHQJMXBase
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
            this.$Notice.error({ title: '错误', desc: 'VacLeaveDetailEditView视图表单'+actionName+'参数未配置' });
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
     * @memberof JHQJMXBase
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
                this.$Notice.error({ title: '错误', desc: 'VacLeaveDetailEditView视图表单'+actionName+'参数未配置' });
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
    * @memberof JHQJMXBase
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'VacLeaveDetailEditView视图表单removeAction参数未配置' });
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.vacleavedetail || Object.is(arg.vacleavedetail, '')) {
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
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
    * @memberof JHQJMXBase
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
     * @memberof JHQJMXBase
     */
    public createDefault(){                    
        if (this.data.hasOwnProperty('jhkssj')) {
          this.data['jhkssj'] = this.$util.dateFormat(new Date());
        }
        if (this.data.hasOwnProperty('state')) {
            this.data['state'] = '10';
        }
    }

    /**
     * 更新默认值
     * @memberof JHQJMXBase
     */
    public updateDefault(){                    
        if (this.data.hasOwnProperty('state') && !this.data.state) {
            this.data['state'] = '10';
        }
    }

    
}
</script>

<style lang='less'>
@import './jhqjmx-form.less';
</style>