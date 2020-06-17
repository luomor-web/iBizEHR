<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='trmdemdeftion_main_3' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.trmdemdeftion.main_3_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.xh.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='xh' :itemRules="this.rules.xh" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.xh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.xh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.xh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.trmdepartname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='trmdepartname' :itemRules="this.rules.trmdepartname" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.trmdepartname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.trmdepartname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.trmdepartname.disabled"
  name='trmdepartname'
  deMajorField='trmdepartname'
  deKeyField='trmdepart'
  :service="service"
  :acParams="{ serviceName: 'TrmDepartService', interfaceName: 'FetchDefault'}"
  valueitem='trmdepartid' 
  :value="data.trmdepartname" 
  editortype="" 
  :pickupView="{ viewname: 'trm-depart-pickup-view', title: $t('entities.trmdepart.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'trmdeparts', parameterName: 'trmdepart' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.trmdemdeftionname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='trmdemdeftionname' :itemRules="this.rules.trmdemdeftionname" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.trmdemdeftionname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.trmdemdeftionname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.trmdemdeftionname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.trmdemdeftionname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pxmk.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pxmk' :itemRules="this.rules.pxmk" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.pxmk')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pxmk.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.pxmk" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.pxmk.disabled"  
    tag='EhrCodeList0171' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.xqfl.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='xqfl' :itemRules="this.rules.xqfl" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.xqfl')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xqfl.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.xqfl" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.xqfl.disabled"  
    tag='EhrCodeList0154' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pxdx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pxdx' :itemRules="this.rules.pxdx" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.pxdx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pxdx.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pxdx"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pxdx.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.trmtraincoursename.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='trmtraincoursename' :itemRules="this.rules.trmtraincoursename" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.trmtraincoursename')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.trmtraincoursename.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.trmtraincoursename.disabled"
  name='trmtraincoursename'
  deMajorField='trmtraincoursename'
  deKeyField='trmtraincourse'
  :service="service"
  :acParams="{ serviceName: 'TrmTrainCourseService', interfaceName: 'FetchDefault'}"
  valueitem='trmtraincourseid' 
  :value="data.trmtraincoursename" 
  editortype="" 
  :pickupView="{ viewname: 'trm-train-course-pickup-view', title: $t('entities.trmtraincourse.views.pickupview.title'), deResParameters: [{ pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' }, ], parameters: [{ pathName: 'trmtraincourses', parameterName: 'trmtraincourse' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.pxzynr.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pxzynr' :itemRules="this.rules.pxzynr" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.pxzynr')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pxzynr.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pxzynr"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pxzynr.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pxkssj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pxkssj' :itemRules="this.rules.pxkssj" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.pxkssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pxkssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.pxkssj" :disabled="detailsModel.pxkssj.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.pxkssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pxjssj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pxjssj' :itemRules="this.rules.pxjssj" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.pxjssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pxjssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.pxjssj" :disabled="detailsModel.pxjssj.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.pxjssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pxdd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pxdd' :itemRules="this.rules.pxdd" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.pxdd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pxdd.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pxdd"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pxdd.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pxrs.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pxrs' :itemRules="this.rules.pxrs" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.pxrs')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pxrs.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pxrs"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pxrs.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormorgname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ormorgname' :itemRules="this.rules.ormorgname" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.ormorgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormorgname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.ormorgname.disabled"
  name='ormorgname'
  deMajorField='orgname'
  deKeyField='ormorg'
  :service="service"
  :acParams="{ serviceName: 'OrmOrgService', interfaceName: 'FetchDefault'}"
  valueitem='ormorgid' 
  :value="data.ormorgname" 
  editortype="" 
  :pickupView="{ viewname: 'orm-org-pickup-view', title: $t('entities.ormorg.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'ormorgs', parameterName: 'ormorg' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.bmjzsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='bmjzsj' :itemRules="this.rules.bmjzsj" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.bmjzsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bmjzsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.bmjzsj" :disabled="detailsModel.bmjzsj.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.bmjzsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bz.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='bz' :itemRules="this.rules.bz" class='' :caption="$t('entities.trmdemdeftion.main_3_form.details.bz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bz.error" :isEmptyCaption="false" labelPos="LEFT">
    <div class="ivu-input-wrapper ivu-input-wrapper-default ivu-input-type">
    <textarea class="ivu-input" v-model="data.bz" :disabled="detailsModel.bz.disabled" style=""></textarea>
</div>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>


    </row>
</i-form>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import TrmDemdeftionService from '@/service/trm-demdeftion/trm-demdeftion-service';
import Main_3Service from './main-3-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class Main_3Base extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof Main_3
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof Main_3
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof Main_3
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof Main_3
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Main_3
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof Main_3
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof Main_3
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {Main_3Service}
     * @memberof Main_3
     */
    public service: Main_3Service = new Main_3Service({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {TrmDemdeftionService}
     * @memberof Main_3
     */
    public appEntityService: TrmDemdeftionService = new TrmDemdeftionService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof Main_3
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof Main_3
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
     * @memberof Main_3
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof Main_3
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof Main_3
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof Main_3
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof Main_3
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof Main_3
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof Main_3
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof Main_3
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof Main_3
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof Main_3
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof Main_3
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof Main_3
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof Main_3
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof Main_3
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof Main_3
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof Main_3
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof Main_3
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Main_3
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof Main_3
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof Main_3
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
        xh: null,
        trmdepartname: null,
        trmdemdeftionname: null,
        pxmk: null,
        xqfl: null,
        pxdx: null,
        trmtraincoursename: null,
        pxzynr: null,
        pxkssj: null,
        pxjssj: null,
        pxdd: null,
        pxrs: null,
        ormorgname: null,
        bmjzsj: null,
        bz: null,
        trmdemdeftionid: null,
        trmtraincourseid: null,
        ormorgid: null,
        trmdepartid: null,
        trmdemdeftion:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof Main_3
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof Main_3
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof Main_3
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof Main_3
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof Main_3
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
            { type: 'string', message: '需求调查定义标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '需求调查定义标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '需求调查定义标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '需求调查定义标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '培训汇总 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训汇总 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训汇总 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训汇总 值不能为空', trigger: 'blur' },
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
        xh: [
            { type: 'string', message: '排序号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '排序号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '排序号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '排序号 值不能为空', trigger: 'blur' },
        ],
        trmdepartname: [
            { type: 'string', message: '培训需求名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训需求名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训需求名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训需求名称 值不能为空', trigger: 'blur' },
        ],
        trmdemdeftionname: [
            { type: 'string', message: '培训汇总 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训汇总 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训汇总 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训汇总 值不能为空', trigger: 'blur' },
        ],
        pxmk: [
            { type: 'string', message: '培训模块 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训模块 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训模块 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训模块 值不能为空', trigger: 'blur' },
        ],
        xqfl: [
            { type: 'string', message: '需求分类 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '需求分类 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '需求分类 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '需求分类 值不能为空', trigger: 'blur' },
        ],
        pxdx: [
            { type: 'string', message: '培训对象 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训对象 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训对象 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训对象 值不能为空', trigger: 'blur' },
        ],
        trmtraincoursename: [
            { type: 'string', message: '培训课程 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训课程 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训课程 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训课程 值不能为空', trigger: 'blur' },
        ],
        pxzynr: [
            { type: 'string', message: '培训主要内容 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训主要内容 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训主要内容 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训主要内容 值不能为空', trigger: 'blur' },
        ],
        pxkssj: [
            { type: 'string', message: '培训开始时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训开始时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训开始时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训开始时间 值不能为空', trigger: 'blur' },
        ],
        pxjssj: [
            { type: 'string', message: '培训结束时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训结束时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训结束时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训结束时间 值不能为空', trigger: 'blur' },
        ],
        pxdd: [
            { type: 'string', message: '培训地点 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训地点 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训地点 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训地点 值不能为空', trigger: 'blur' },
        ],
        pxrs: [
            { type: 'number', message: '培训人数 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '培训人数 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '培训人数 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '培训人数 值不能为空', trigger: 'blur' },
        ],
        ormorgname: [
            { type: 'string', message: '单位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '单位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '单位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '单位 值不能为空', trigger: 'blur' },
        ],
        bmjzsj: [
            { type: 'string', message: '报名截止时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '报名截止时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '报名截止时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '报名截止时间 值不能为空', trigger: 'blur' },
        ],
        bz: [
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'blur' },
        ],
        trmdemdeftionid: [
            { type: 'string', message: '需求调查定义标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '需求调查定义标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '需求调查定义标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '需求调查定义标识 值不能为空', trigger: 'blur' },
        ],
        trmtraincourseid: [
            { type: 'string', message: '培训课程标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训课程标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训课程标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训课程标识 值不能为空', trigger: 'blur' },
        ],
        ormorgid: [
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'blur' },
        ],
        trmdepartid: [
            { type: 'string', message: '培训需求填报标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训需求填报标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训需求填报标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训需求填报标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof Main_3
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '需求调查定义', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.trmdemdeftion.main_3_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '需求调查定义标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '培训汇总', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        xh: new FormItemModel({ caption: '排序号', detailType: 'FORMITEM', name: 'xh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmdepartname: new FormItemModel({ caption: '培训需求名称', detailType: 'FORMITEM', name: 'trmdepartname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmdemdeftionname: new FormItemModel({ caption: '培训汇总', detailType: 'FORMITEM', name: 'trmdemdeftionname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pxmk: new FormItemModel({ caption: '培训模块', detailType: 'FORMITEM', name: 'pxmk', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        xqfl: new FormItemModel({ caption: '需求分类', detailType: 'FORMITEM', name: 'xqfl', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pxdx: new FormItemModel({ caption: '培训对象', detailType: 'FORMITEM', name: 'pxdx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtraincoursename: new FormItemModel({ caption: '培训课程', detailType: 'FORMITEM', name: 'trmtraincoursename', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pxzynr: new FormItemModel({ caption: '培训主要内容', detailType: 'FORMITEM', name: 'pxzynr', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pxkssj: new FormItemModel({ caption: '培训开始时间', detailType: 'FORMITEM', name: 'pxkssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pxjssj: new FormItemModel({ caption: '培训结束时间', detailType: 'FORMITEM', name: 'pxjssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pxdd: new FormItemModel({ caption: '培训地点', detailType: 'FORMITEM', name: 'pxdd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pxrs: new FormItemModel({ caption: '培训人数', detailType: 'FORMITEM', name: 'pxrs', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgname: new FormItemModel({ caption: '单位', detailType: 'FORMITEM', name: 'ormorgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bmjzsj: new FormItemModel({ caption: '报名截止时间', detailType: 'FORMITEM', name: 'bmjzsj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bz: new FormItemModel({ caption: '备注', detailType: 'FORMITEM', name: 'bz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmdemdeftionid: new FormItemModel({ caption: '需求调查定义标识', detailType: 'FORMITEM', name: 'trmdemdeftionid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtraincourseid: new FormItemModel({ caption: '培训课程标识', detailType: 'FORMITEM', name: 'trmtraincourseid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgid: new FormItemModel({ caption: '组织标识', detailType: 'FORMITEM', name: 'ormorgid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmdepartid: new FormItemModel({ caption: '培训需求填报标识', detailType: 'FORMITEM', name: 'trmdepartid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.xh')
    onXhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmdepartname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.trmdepartname')
    onTrmdepartnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmdepartname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmdemdeftionname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.trmdemdeftionname')
    onTrmdemdeftionnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmdemdeftionname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pxmk 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.pxmk')
    onPxmkChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pxmk', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xqfl 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.xqfl')
    onXqflChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xqfl', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pxdx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.pxdx')
    onPxdxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pxdx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtraincoursename 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.trmtraincoursename')
    onTrmtraincoursenameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtraincoursename', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pxzynr 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.pxzynr')
    onPxzynrChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pxzynr', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pxkssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.pxkssj')
    onPxkssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pxkssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pxjssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.pxjssj')
    onPxjssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pxjssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pxdd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.pxdd')
    onPxddChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pxdd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pxrs 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.pxrs')
    onPxrsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pxrs', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.ormorgname')
    onOrmorgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bmjzsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.bmjzsj')
    onBmjzsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bmjzsj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.bz')
    onBzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmdemdeftionid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.trmdemdeftionid')
    onTrmdemdeftionidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmdemdeftionid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtraincourseid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.trmtraincourseid')
    onTrmtraincourseidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtraincourseid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.ormorgid')
    onOrmorgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmdepartid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_3
     */
    @Watch('data.trmdepartid')
    onTrmdepartidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmdepartid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof Main_3
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
      * @memberof EditForm
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
     * @memberof Main_3
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                





























    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof Main_3
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
     * @memberof Main_3
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.trmdemdeftion){
            Object.assign(this.context,{trmdemdeftion:data.trmdemdeftion})
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
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof Main_3
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
     * @memberof Main_3
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof Main_3
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
     * @memberof @memberof Main_3
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.trmdemdeftion = copyData.srfkey;
        copyData.trmdemdeftionid = copyData.srfkey;
        Object.assign(this.context,{trmdemdeftion:copyData.trmdemdeftion})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof Main_3
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'trmdemdeftion_main_3',popTitle:'主编辑表单(通知不带明细)'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'TrmDemdeftionTZFEditView视图表单loadAction参数未配置' });
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
     * @memberof Main_3
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'TrmDemdeftionTZFEditView视图表单loaddraftAction参数未配置' });
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
            if(data.trmdemdeftion){
                Object.assign(this.context,{trmdemdeftion:data.trmdemdeftion})
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
     * @memberof Main_3
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
            this.$Notice.error({ title: '错误', desc: 'TrmDemdeftionTZFEditView视图表单'+actionName+'参数未配置' });
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
     * @memberof Main_3
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
                this.$Notice.error({ title: '错误', desc: 'TrmDemdeftionTZFEditView视图表单'+actionName+'参数未配置' });
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
    * @memberof EditForm
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'TrmDemdeftionTZFEditView视图表单removeAction参数未配置' });
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
     * @memberof Main_3
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
     * @memberof Main_3
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.trmdemdeftion || Object.is(arg.trmdemdeftion, '')) {
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
     * @memberof Main_3
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
     * @memberof Main_3
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof Main_3
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
     * @memberof Main_3
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
     * @memberof Main_3
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
    * @memberof Main_3
    */
    public drdatasaved($event:any){
        let _this = this;
        this.drcounter--;
        if(this.drcounter > 0){
            return;
        }
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

    /**
     * 新建默认值
     * @memberof Main_3
     */
    public createDefault(){                    
    }

    /**
     * 更新默认值
     * @memberof Main_3
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './main-3-form.less';
</style>