<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='pimtitle_main_2' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimtitle.main_2_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.pimtitlecataloguename.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pimtitlecataloguename' :itemRules="this.rules.pimtitlecataloguename" class='' :caption="$t('entities.pimtitle.main_2_form.details.pimtitlecataloguename')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimtitlecataloguename.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.pimtitlecataloguename.disabled"
  name='pimtitlecataloguename'
  deMajorField='pimtitlecataloguename'
  deKeyField='pimtitlecatalogue'
  :service="service"
  :acParams="{ serviceName: 'PimTitleCatalogueService', interfaceName: 'FetchNotRootDQ'}"
  valueitem='pimtitlecatalogueid' 
  :value="data.pimtitlecataloguename" 
  editortype="" 
  :pickupView="{ viewname: 'pimtitlecataloguenot-pickup-view', title: $t('entities.pimtitlecatalogue.views.notpickupview.title'), deResParameters: [], parameters: [{ pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' }, { pathName: 'notpickupview', parameterName: 'notpickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.zchqrq.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zchqrq' :itemRules="this.rules.zchqrq" class='' :caption="$t('entities.pimtitle.main_2_form.details.zchqrq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zchqrq.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.zchqrq" :disabled="detailsModel.zchqrq.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.zchqrq = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zcbh.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zcbh' :itemRules="this.rules.zcbh" class='' :caption="$t('entities.pimtitle.main_2_form.details.zcbh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zcbh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zcbh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zcbh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zcdj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zcdj' :itemRules="this.rules.zcdj" class='' :caption="$t('entities.pimtitle.main_2_form.details.zcdj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zcdj.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.zcdj" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.zcdj.disabled"  
    tag='EhrCodeList0024' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.majorengaged.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='majorengaged' :itemRules="this.rules.majorengaged" class='' :caption="$t('entities.pimtitle.main_2_form.details.majorengaged')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.majorengaged.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.majorengaged"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.majorengaged.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.careername.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='careername' :itemRules="this.rules.careername" class='' :caption="$t('entities.pimtitle.main_2_form.details.careername')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.careername.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.careername"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.careername.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.lssuingagency.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='lssuingagency' :itemRules="this.rules.lssuingagency" class='' :caption="$t('entities.pimtitle.main_2_form.details.lssuingagency')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.lssuingagency.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.lssuingagency"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.lssuingagency.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.reviewbody.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='reviewbody' :itemRules="this.rules.reviewbody" class='' :caption="$t('entities.pimtitle.main_2_form.details.reviewbody')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.reviewbody.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.reviewbody"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.reviewbody.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.employtime.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='employtime' :itemRules="this.rules.employtime" class='' :caption="$t('entities.pimtitle.main_2_form.details.employtime')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.employtime.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.employtime" :disabled="detailsModel.employtime.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.employtime = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfzgzc.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sfzgzc' :itemRules="this.rules.sfzgzc" class='' :caption="$t('entities.pimtitle.main_2_form.details.sfzgzc')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sfzgzc.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
  v-model="data.sfzgzc" 
  :data="data" 
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.sfzgzc.disabled" 
  style="width:100px;width: 100px;" 
  tag='EhrCodeList0401' 
  codelistType='STATIC'
  placeholder='请选择...'>
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.fj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='fj' :itemRules="this.rules.fj" class='' :caption="$t('entities.pimtitle.main_2_form.details.fj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fj.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-file-upload :formState="formState" :ignorefieldvaluechange="ignorefieldvaluechange" @formitemvaluechange="onFormItemValueChange" :data="JSON.stringify(this.data)" name='fj' :value="data.fj" :disabled="detailsModel.fj.disabled" :uploadparams='{}' :exportparams='{}'  style="overflow: auto;"></app-file-upload>
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
import PimTitleService from '@/service/pim-title/pim-title-service';
import Main_2Service from './main-2-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class Main_2Base extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof Main_2Base
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof Main_2Base
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof Main_2Base
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof Main_2Base
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Main_2Base
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof Main_2Base
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof Main_2Base
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {Main_2Service}
     * @memberof Main_2Base
     */
    public service: Main_2Service = new Main_2Service({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PimTitleService}
     * @memberof Main_2Base
     */
    public appEntityService: PimTitleService = new PimTitleService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof Main_2Base
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof Main_2Base
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
     * @memberof Main_2Base
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof Main_2Base
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof Main_2Base
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof Main_2Base
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof Main_2Base
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof Main_2Base
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof Main_2Base
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof Main_2Base
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof Main_2Base
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof Main_2Base
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof Main_2Base
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof Main_2Base
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof Main_2Base
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof Main_2Base
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof Main_2Base
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof Main_2Base
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof Main_2Base
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Main_2Base
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof Main_2Base
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof Main_2Base
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
        pimtitlecataloguename: null,
        zchqrq: null,
        zcbh: null,
        zcdj: null,
        majorengaged: null,
        careername: null,
        lssuingagency: null,
        reviewbody: null,
        employtime: null,
        sfzgzc: null,
        jlss: null,
        fj: null,
        pimtitlecatalogueid: null,
        pimtitleid: null,
        pimtitle:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof Main_2Base
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof Main_2Base
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof Main_2Base
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof Main_2Base
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof Main_2Base
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
            { type: 'string', message: '职称信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职称信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职称信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职称信息标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
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
        pimtitlecataloguename: [
            { type: 'string', message: '职称名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职称名称 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '职称名称 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '职称名称 值不能为空', trigger: 'blur' },
        ],
        zchqrq: [
            { type: 'string', message: '职称获取日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职称获取日期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职称获取日期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职称获取日期 值不能为空', trigger: 'blur' },
        ],
        zcbh: [
            { type: 'string', message: '证书编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证书编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '证书编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '证书编号 值不能为空', trigger: 'blur' },
        ],
        zcdj: [
            { type: 'string', message: '职称等级 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职称等级 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职称等级 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职称等级 值不能为空', trigger: 'blur' },
        ],
        majorengaged: [
            { type: 'string', message: '专业类别 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '专业类别 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '专业类别 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '专业类别 值不能为空', trigger: 'blur' },
        ],
        careername: [
            { type: 'string', message: '专业名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '专业名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '专业名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '专业名称 值不能为空', trigger: 'blur' },
        ],
        lssuingagency: [
            { type: 'string', message: '签发机构 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '签发机构 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '签发机构 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '签发机构 值不能为空', trigger: 'blur' },
        ],
        reviewbody: [
            { type: 'string', message: '评审单位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '评审单位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '评审单位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '评审单位 值不能为空', trigger: 'blur' },
        ],
        employtime: [
            { type: 'string', message: '职称聘用时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职称聘用时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职称聘用时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职称聘用时间 值不能为空', trigger: 'blur' },
        ],
        sfzgzc: [
            { type: 'number', message: '是否最高职称 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否最高职称 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '是否最高职称 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '是否最高职称 值不能为空', trigger: 'blur' },
        ],
        jlss: [
            { type: 'string', message: '记录所属 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '记录所属 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '记录所属 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '记录所属 值不能为空', trigger: 'blur' },
        ],
        fj: [
            { type: 'string', message: '附件 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '附件 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '附件 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '附件 值不能为空', trigger: 'blur' },
        ],
        pimtitlecatalogueid: [
            { type: 'string', message: '职称管理标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职称管理标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职称管理标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职称管理标识 值不能为空', trigger: 'blur' },
        ],
        pimtitleid: [
            { type: 'string', message: '职称信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职称信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职称信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职称信息标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof Main_2Base
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '职称信息基本信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimtitle.main_2_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '职称信息标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
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
        pimtitlecataloguename: new FormItemModel({ caption: '职称名称', detailType: 'FORMITEM', name: 'pimtitlecataloguename', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zchqrq: new FormItemModel({ caption: '职称获取日期', detailType: 'FORMITEM', name: 'zchqrq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zcbh: new FormItemModel({ caption: '证书编号', detailType: 'FORMITEM', name: 'zcbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zcdj: new FormItemModel({ caption: '职称等级', detailType: 'FORMITEM', name: 'zcdj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        majorengaged: new FormItemModel({ caption: '专业类别', detailType: 'FORMITEM', name: 'majorengaged', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        careername: new FormItemModel({ caption: '专业名称', detailType: 'FORMITEM', name: 'careername', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        lssuingagency: new FormItemModel({ caption: '签发机构', detailType: 'FORMITEM', name: 'lssuingagency', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        reviewbody: new FormItemModel({ caption: '评审单位', detailType: 'FORMITEM', name: 'reviewbody', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        employtime: new FormItemModel({ caption: '职称聘用时间', detailType: 'FORMITEM', name: 'employtime', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sfzgzc: new FormItemModel({ caption: '是否最高职称', detailType: 'FORMITEM', name: 'sfzgzc', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jlss: new FormItemModel({ caption: '记录所属', detailType: 'FORMITEM', name: 'jlss', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        fj: new FormItemModel({ caption: '附件', detailType: 'FORMITEM', name: 'fj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimtitlecatalogueid: new FormItemModel({ caption: '职称管理标识', detailType: 'FORMITEM', name: 'pimtitlecatalogueid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimtitleid: new FormItemModel({ caption: '职称信息标识', detailType: 'FORMITEM', name: 'pimtitleid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
     */
    @Watch('data.pimpersonid')
    onPimpersonidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimtitlecataloguename 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.pimtitlecataloguename')
    onPimtitlecataloguenameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimtitlecataloguename', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zchqrq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.zchqrq')
    onZchqrqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zchqrq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zcbh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.zcbh')
    onZcbhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zcbh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zcdj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.zcdj')
    onZcdjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zcdj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 majorengaged 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.majorengaged')
    onMajorengagedChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'majorengaged', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 careername 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.careername')
    onCareernameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'careername', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 lssuingagency 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.lssuingagency')
    onLssuingagencyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'lssuingagency', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 reviewbody 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.reviewbody')
    onReviewbodyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'reviewbody', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 employtime 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.employtime')
    onEmploytimeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'employtime', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfzgzc 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.sfzgzc')
    onSfzgzcChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfzgzc', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jlss 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.jlss')
    onJlssChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jlss', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 fj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.fj')
    onFjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'fj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimtitlecatalogueid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.pimtitlecatalogueid')
    onPimtitlecatalogueidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimtitlecatalogueid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimtitleid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.pimtitleid')
    onPimtitleidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimtitleid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof Main_2Base
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
     * @memberof Main_2Base
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
     * @memberof Main_2Base
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                

























    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof Main_2Base
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
     * @memberof Main_2Base
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.pimtitle){
            Object.assign(this.context,{pimtitle:data.pimtitle})
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof Main_2Base
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
     * @memberof Main_2Base
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof Main_2Base
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
     * @memberof @memberof Main_2Base
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.pimtitle = copyData.srfkey;
        copyData.pimtitleid = copyData.srfkey;
        Object.assign(this.context,{pimtitle:copyData.pimtitle})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof Main_2Base
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'pimtitle_main_2',popTitle:'主编辑表单(个人)'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'PIMTITLEGREditView视图表单loadAction参数未配置' });
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
     * @memberof Main_2Base
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'PIMTITLEGREditView视图表单loaddraftAction参数未配置' });
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
            if(data.pimtitle){
                Object.assign(this.context,{pimtitle:data.pimtitle})
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
     * @memberof Main_2Base
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
            this.$Notice.error({ title: '错误', desc: 'PIMTITLEGREditView视图表单'+actionName+'参数未配置' });
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
     * @memberof Main_2Base
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
                this.$Notice.error({ title: '错误', desc: 'PIMTITLEGREditView视图表单'+actionName+'参数未配置' });
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
    * @memberof Main_2Base
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'PIMTITLEGREditView视图表单removeAction参数未配置' });
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.pimtitle || Object.is(arg.pimtitle, '')) {
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
     * @memberof Main_2Base
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
    * @memberof Main_2Base
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
     * @memberof Main_2Base
     */
    public createDefault(){                    
        if (this.data.hasOwnProperty('pimpersonid')) {
            this.data['pimpersonid'] = this.context['SRFSELFSERVICEID'];
        }
        if (this.data.hasOwnProperty('jlss')) {
            this.data['jlss'] = '20';
        }
    }

    /**
     * 更新默认值
     * @memberof Main_2Base
     */
    public updateDefault(){                    
        if (this.data.hasOwnProperty('pimpersonid') && !this.data.pimpersonid) {
            this.data['pimpersonid'] = this.context['SRFSELFSERVICEID'];
        }
    }

    
}
</script>

<style lang='less'>
@import './main-2-form.less';
</style>