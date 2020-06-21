<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='trmtrainteacher_main_2' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.trmtrainteacher.main_2_form.details.group1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.grouppanel4.visible" :style="{}"  :lg="{ span: 16, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel4.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.trmtrainteacher.main_2_form.details.grouppanel4')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="1" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.pimpersonname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='pimpersonname' :itemRules="this.rules.pimpersonname" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.pimpersonname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimpersonname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pimpersonname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pimpersonname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jslx.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='jslx' :itemRules="this.rules.jslx" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.jslx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jslx.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.jslx" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.jslx.disabled"  
    tag='EhrCodeList0111' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.dj.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='dj' :itemRules="this.rules.dj" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.dj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.dj.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.dj" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.dj.disabled"  
    tag='EhrCodeList0032' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zjhm.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='zjhm' :itemRules="this.rules.zjhm" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.zjhm')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zjhm.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zjhm"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zjhm.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.xb.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='xb' :itemRules="this.rules.xb" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.xb')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xb.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.xb"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.xb.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.nl.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='nl' :itemRules="this.rules.nl" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.nl')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nl.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.nl"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.nl.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.lxdh.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='lxdh' :itemRules="this.rules.lxdh" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.lxdh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.lxdh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.lxdh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.lxdh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.trmtrainagencyname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='trmtrainagencyname' :itemRules="this.rules.trmtrainagencyname" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.trmtrainagencyname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.trmtrainagencyname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.trmtrainagencyname.disabled"
  name='trmtrainagencyname'
  deMajorField='trmtrainagencyname'
  deKeyField='trmtrainagency'
  :service="service"
  :acParams="{ serviceName: 'TrmTrainAgencyService', interfaceName: 'FetchDefault'}"
  valueitem='trmtrainagencyid' 
  :value="data.trmtrainagencyname" 
  editortype="" 
  :pickupView="{ viewname: 'trm-train-agency-pickup-view', title: $t('entities.trmtrainagency.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.jglb.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='jglb' :itemRules="this.rules.jglb" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.jglb')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jglb.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='jglb' :value="data.jglb" tag='EhrCodeList0130' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zjkssj.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='zjkssj' :itemRules="this.rules.zjkssj" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.zjkssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zjkssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.zjkssj" :disabled="detailsModel.zjkssj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.zjkssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jf.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='jf' :itemRules="this.rules.jf" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.jf')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jf.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.jf"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.jf.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfgx.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='sfgx' :itemRules="this.rules.sfgx" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.sfgx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sfgx.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
  v-model="data.sfgx" 
  :data="data" 
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.sfgx.disabled" 
  style="width:100px;width: 100px;" 
  tag='EhrCodeList0401' 
  codelistType='STATIC'
  placeholder='请选择...'>
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormorgname.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='ormorgname' :itemRules="this.rules.ormorgname" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.ormorgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormorgname.error" :isEmptyCaption="false" labelPos="LEFT">
    
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
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel3.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel3.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.trmtrainteacher.main_2_form.details.grouppanel3')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.zp.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='zp' :itemRules="this.rules.zp" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.zp')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zp.error" :isEmptyCaption="false" labelPos="LEFT">
     <app-image-upload :multiple="false" :formState="formState" :ignorefieldvaluechange="ignorefieldvaluechange" @formitemvaluechange="onFormItemValueChange" :data="JSON.stringify(this.data)" name='zp' :value="data.zp" :disabled="detailsModel.zp.disabled" :uploadparams='{}' :exportparams='{}' ></app-image-upload>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel2.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel2.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.trmtrainteacher.main_2_form.details.grouppanel2')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="1" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.bz.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='bz' :itemRules="this.rules.bz" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.bz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bz.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bz"  :disabled="detailsModel.bz.disabled" type='textarea' style="" ></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pj.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='pj' :itemRules="this.rules.pj" class='' :caption="$t('entities.trmtrainteacher.main_2_form.details.pj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pj.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pj"  :disabled="detailsModel.pj.disabled" type='textarea' style="" ></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.trmtrainteacher.main_2_form.details.grouppanel1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="1" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.druipart1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-druipart
    
    :formState="formState"
    :isForbidLoad="this.data.srfuf === '0'"
    paramItem='trmtrainteacher' 
    :parentdata='{"srfparentdefname":"TRMTRAINTEACHERID","srfparentdename":"TRMTRAINTEACHER","SRFPARENTTYPE":"DER1N","srfparentmode":"DER1N_TRMTEACHERTRAIN_TRMTRAINTEACHER_TRMTRAINTEACHERID","SRFDER1NID":"DER1N_TRMTEACHERTRAIN_TRMTRAINTEACHER_TRMTRAINTEACHERID"}'
    :parameters="[
        { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
    ]"
    :context="context"
    :viewparams="viewparams"
    :localContext ='{}'
    :localParam ='{}'
    parameterName='trmtrainteacher'
    parentName="TrmTrainTeacher"  
    refviewtype='DEGRIDVIEW' 
    refreshitems='' 
    :ignorefieldvaluechange="ignorefieldvaluechange"
    viewname='trm-teacher-train-grid-view' 
    :data="JSON.stringify(this.data)" 
    @drdatasaved="drdatasaved($event)"
    style=";overflow: auto;">
</app-form-druipart>

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
import TrmTrainTeacherService from '@/service/trm-train-teacher/trm-train-teacher-service';
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
     * @type {TrmTrainTeacherService}
     * @memberof Main_2Base
     */
    public appEntityService: TrmTrainTeacherService = new TrmTrainTeacherService({ $store: this.$store });
    


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
        pimpersonname: null,
        jslx: null,
        dj: null,
        zjhm: null,
        xb: null,
        nl: null,
        lxdh: null,
        trmtrainagencyname: null,
        jglb: null,
        zjkssj: null,
        jf: null,
        sfgx: null,
        ormorgname: null,
        zp: null,
        bz: null,
        trmtrainagencyid: null,
        pj: null,
        trmtrainteacherid: null,
        ormorgid: null,
        trmtrainteacher:null,
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
            { type: 'string', message: '培训教师标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训教师标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训教师标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训教师标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '培训教师名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训教师名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训教师名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训教师名称 值不能为空', trigger: 'blur' },
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
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '姓名 值不能为空', trigger: 'blur' },
        ],
        jslx: [
            { type: 'string', message: '讲师类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '讲师类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '讲师类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '讲师类型 值不能为空', trigger: 'blur' },
        ],
        dj: [
            { type: 'string', message: '等级 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '等级 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '等级 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '等级 值不能为空', trigger: 'blur' },
        ],
        zjhm: [
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '证件号码 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '证件号码 值不能为空', trigger: 'blur' },
        ],
        xb: [
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'blur' },
        ],
        nl: [
            { type: 'number', message: '年龄 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '年龄 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '年龄 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '年龄 值不能为空', trigger: 'blur' },
        ],
        lxdh: [
            { type: 'string', message: '联系电话 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '联系电话 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '联系电话 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '联系电话 值不能为空', trigger: 'blur' },
        ],
        trmtrainagencyname: [
            { type: 'string', message: '所属机构 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属机构 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所属机构 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所属机构 值不能为空', trigger: 'blur' },
        ],
        jglb: [
            { type: 'string', message: '机构性质 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '机构性质 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '机构性质 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '机构性质 值不能为空', trigger: 'blur' },
        ],
        zjkssj: [
            { type: 'string', message: '执教开始时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '执教开始时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '执教开始时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '执教开始时间 值不能为空', trigger: 'blur' },
        ],
        jf: [
            { type: 'number', message: '积分 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '积分 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '积分 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '积分 值不能为空', trigger: 'blur' },
        ],
        sfgx: [
            { type: 'number', message: '是否共享 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否共享 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '是否共享 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '是否共享 值不能为空', trigger: 'blur' },
        ],
        ormorgname: [
            { type: 'string', message: '所属单位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属单位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所属单位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所属单位 值不能为空', trigger: 'blur' },
        ],
        zp: [
            { type: 'string', message: '照片 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '照片 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '照片 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '照片 值不能为空', trigger: 'blur' },
        ],
        bz: [
            { type: 'string', message: '讲师介绍 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '讲师介绍 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '讲师介绍 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '讲师介绍 值不能为空', trigger: 'blur' },
        ],
        trmtrainagencyid: [
            { type: 'string', message: '培训机构标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训机构标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训机构标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训机构标识 值不能为空', trigger: 'blur' },
        ],
        pj: [
            { type: 'string', message: '评价 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '评价 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '评价 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '评价 值不能为空', trigger: 'blur' },
        ],
        trmtrainteacherid: [
            { type: 'string', message: '培训教师标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训教师标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训教师标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训教师标识 值不能为空', trigger: 'blur' },
        ],
        ormorgid: [
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof Main_2Base
     */
    public detailsModel: any = {
        grouppanel4: new FormGroupPanelModel({ caption: '培训讲师信息', detailType: 'GROUPPANEL', name: 'grouppanel4', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.trmtrainteacher.main_2_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel3: new FormGroupPanelModel({ caption: '', detailType: 'GROUPPANEL', name: 'grouppanel3', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.trmtrainteacher.main_2_form', extractMode: 'ITEM', details: [] } })
, 
        group1: new FormGroupPanelModel({ caption: '培训讲师信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.trmtrainteacher.main_2_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel2: new FormGroupPanelModel({ caption: '评价信息', detailType: 'GROUPPANEL', name: 'grouppanel2', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.trmtrainteacher.main_2_form', extractMode: 'ITEM', details: [] } })
, 
        druipart1: new FormDRUIPartModel({ caption: '', detailType: 'DRUIPART', name: 'druipart1', visible: true, isShowCaption: true, form: this })
, 
        grouppanel1: new FormGroupPanelModel({ caption: '讲师授课记录', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.trmtrainteacher.main_2_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '培训教师标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '培训教师名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonname: new FormItemModel({ caption: '姓名', detailType: 'FORMITEM', name: 'pimpersonname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jslx: new FormItemModel({ caption: '讲师类型', detailType: 'FORMITEM', name: 'jslx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        dj: new FormItemModel({ caption: '等级', detailType: 'FORMITEM', name: 'dj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zjhm: new FormItemModel({ caption: '证件号码', detailType: 'FORMITEM', name: 'zjhm', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        xb: new FormItemModel({ caption: '性别', detailType: 'FORMITEM', name: 'xb', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        nl: new FormItemModel({ caption: '年龄', detailType: 'FORMITEM', name: 'nl', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        lxdh: new FormItemModel({ caption: '联系电话', detailType: 'FORMITEM', name: 'lxdh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtrainagencyname: new FormItemModel({ caption: '所属机构', detailType: 'FORMITEM', name: 'trmtrainagencyname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jglb: new FormItemModel({ caption: '机构性质', detailType: 'FORMITEM', name: 'jglb', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zjkssj: new FormItemModel({ caption: '执教开始时间', detailType: 'FORMITEM', name: 'zjkssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jf: new FormItemModel({ caption: '积分', detailType: 'FORMITEM', name: 'jf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sfgx: new FormItemModel({ caption: '是否共享', detailType: 'FORMITEM', name: 'sfgx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgname: new FormItemModel({ caption: '所属单位', detailType: 'FORMITEM', name: 'ormorgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zp: new FormItemModel({ caption: '照片', detailType: 'FORMITEM', name: 'zp', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bz: new FormItemModel({ caption: '讲师介绍', detailType: 'FORMITEM', name: 'bz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtrainagencyid: new FormItemModel({ caption: '培训机构标识', detailType: 'FORMITEM', name: 'trmtrainagencyid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pj: new FormItemModel({ caption: '评价', detailType: 'FORMITEM', name: 'pj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtrainteacherid: new FormItemModel({ caption: '培训教师标识', detailType: 'FORMITEM', name: 'trmtrainteacherid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgid: new FormItemModel({ caption: '组织标识', detailType: 'FORMITEM', name: 'ormorgid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
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
     * 监控表单属性 pimpersonname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.pimpersonname')
    onPimpersonnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jslx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.jslx')
    onJslxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jslx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 dj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.dj')
    onDjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'dj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zjhm 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.zjhm')
    onZjhmChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zjhm', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xb 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.xb')
    onXbChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xb', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 nl 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.nl')
    onNlChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'nl', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 lxdh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.lxdh')
    onLxdhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'lxdh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtrainagencyname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.trmtrainagencyname')
    onTrmtrainagencynameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtrainagencyname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jglb 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.jglb')
    onJglbChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jglb', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zjkssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.zjkssj')
    onZjkssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zjkssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jf 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.jf')
    onJfChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jf', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfgx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.sfgx')
    onSfgxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfgx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.ormorgname')
    onOrmorgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zp 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.zp')
    onZpChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zp', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.bz')
    onBzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtrainagencyid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.trmtrainagencyid')
    onTrmtrainagencyidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtrainagencyid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.pj')
    onPjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtrainteacherid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.trmtrainteacherid')
    onTrmtrainteacheridChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtrainteacherid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.ormorgid')
    onOrmorgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgid', newVal: newVal, oldVal: oldVal });
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
        if(data.trmtrainteacher){
            Object.assign(this.context,{trmtrainteacher:data.trmtrainteacher})
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
        copyData.trmtrainteacher = copyData.srfkey;
        copyData.trmtrainteacherid = copyData.srfkey;
        Object.assign(this.context,{trmtrainteacher:copyData.trmtrainteacher})
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
        _this.$print({id:'trmtrainteacher_main_2',popTitle:'主编辑表单（外部）'});
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
            this.$Notice.error({ title: '错误', desc: 'TrmTrainTeacherWBEditView视图表单loadAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'TrmTrainTeacherWBEditView视图表单loaddraftAction参数未配置' });
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
            if(data.trmtrainteacher){
                Object.assign(this.context,{trmtrainteacher:data.trmtrainteacher})
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
            this.$Notice.error({ title: '错误', desc: 'TrmTrainTeacherWBEditView视图表单'+actionName+'参数未配置' });
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
                this.drcounter = 1;
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
                this.$Notice.error({ title: '错误', desc: 'TrmTrainTeacherWBEditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'TrmTrainTeacherWBEditView视图表单removeAction参数未配置' });
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
        if (!arg.trmtrainteacher || Object.is(arg.trmtrainteacher, '')) {
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
    }

    /**
     * 更新默认值
     * @memberof Main_2Base
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './main-2-form.less';
</style>