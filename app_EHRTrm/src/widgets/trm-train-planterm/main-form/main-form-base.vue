<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='trmtrainplanterm_main' style="">
    <input style="display:none;" />
    <row >
    <tabs :animated="false" name='main' :value="detailsModel.form.activiedPage" 
        @on-click="detailsModel.form.clickPage($event)">
            <tab-pane v-show="detailsModel.formpage1.visible" name='formpage1' :index="0" tab='main' class=''  
                :label="(h) =>{
                    return h('span',{
                        class:'caption'
                    },[
                    $t('entities.trmtrainplanterm.main_form.details.formpage1')
                    ])
                }">
                    
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.trmtrainplanterm.main_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.trmtrainplanname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='trmtrainplanname' :itemRules="this.rules.trmtrainplanname" class='' :caption="$t('entities.trmtrainplanterm.main_form.details.trmtrainplanname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.trmtrainplanname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.trmtrainplanname.disabled"
  name='trmtrainplanname'
  deMajorField='trmdemdeftionname'
  deKeyField='trmtrainplan'
  :service="service"
  :acParams="{ serviceName: 'TrmTrainPlanService', interfaceName: 'FetchDefault'}"
  valueitem='trmtrainplanid' 
  :value="data.trmtrainplanname" 
  editortype="" 
  :pickupView="{ viewname: 'trm-train-plan-pickup-view', title: $t('entities.trmtrainplan.views.pickupview.title'), deResParameters: [{ pathName: 'pimpeople', parameterName: 'pimperson' }, ], parameters: [{ pathName: 'trmtrainplans', parameterName: 'trmtrainplan' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.nd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='nd' :itemRules="this.rules.nd" class='' :caption="$t('entities.trmtrainplanterm.main_form.details.nd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nd.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.nd" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.nd.disabled"  
    tag='EhrCodeList0009' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.trmtrainplantermname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='trmtrainplantermname' :itemRules="this.rules.trmtrainplantermname" class='' :caption="$t('entities.trmtrainplanterm.main_form.details.trmtrainplantermname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.trmtrainplantermname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.trmtrainplantermname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.trmtrainplantermname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jhkssj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='jhkssj' :itemRules="this.rules.jhkssj" class='' :caption="$t('entities.trmtrainplanterm.main_form.details.jhkssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jhkssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.jhkssj" :disabled="detailsModel.jhkssj.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.jhkssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jhjssj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='jhjssj' :itemRules="this.rules.jhjssj" class='' :caption="$t('entities.trmtrainplanterm.main_form.details.jhjssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jhjssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.jhjssj" :disabled="detailsModel.jhjssj.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.jhjssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.trmtrainagencyname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='trmtrainagencyname' :itemRules="this.rules.trmtrainagencyname" class='' :caption="$t('entities.trmtrainplanterm.main_form.details.trmtrainagencyname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.trmtrainagencyname.error" :isEmptyCaption="false" labelPos="LEFT">
    
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
<i-col v-show="detailsModel.pxdd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pxdd' :itemRules="this.rules.pxdd" class='' :caption="$t('entities.trmtrainplanterm.main_form.details.pxdd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pxdd.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-mpicker
    :activeData="data"
    :disabled="detailsModel.pxdd.disabled"
    :curvalue="data.pxdd"
    name="pxdd"
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :service="service"
    deMajorField='trmdemdeftionname'
    deKeyField='trmtrainplan'
    :acParams="{ serviceName: 'TrmTrainPlanService', interfaceName: 'FetchDefault'}"
    :pickupView="{ viewname: 'trm-train-address-mpickup-view', title: $t('entities.trmtrainaddress.views.mpickupview.title'), deResParameters: [], parameters: [{ pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' }, { pathName: 'mpickupview', parameterName: 'mpickupview' } ], placement:'' }"
    @formitemvaluechange="onFormItemValueChange" 
    style="">
</app-mpicker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.trmtraincoursename.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='trmtraincoursename' :itemRules="this.rules.trmtraincoursename" class='' :caption="$t('entities.trmtrainplanterm.main_form.details.trmtraincoursename')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.trmtraincoursename.error" :isEmptyCaption="false" labelPos="LEFT">
    
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
<i-col v-show="detailsModel.trmtrainteachername.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='trmtrainteachername' :itemRules="this.rules.trmtrainteachername" class='' :caption="$t('entities.trmtrainplanterm.main_form.details.trmtrainteachername')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.trmtrainteachername.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-mpicker
    :activeData="data"
    :disabled="detailsModel.trmtrainteachername.disabled"
    :curvalue="data.trmtrainteachername"
    name="trmtrainteachername"
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :service="service"
    deMajorField='trmtrainteachername'
    deKeyField='trmtrainteacher'
    :acParams="{ serviceName: 'TrmTrainTeacherService', interfaceName: 'FetchDefault'}"
    :pickupView="{ viewname: 'trm-train-teacher-mpickup-view', title: $t('entities.trmtrainteacher.views.mpickupview.title'), deResParameters: [{ pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' }, ], parameters: [{ pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' }, { pathName: 'mpickupview', parameterName: 'mpickupview' } ], placement:'' }"
    @formitemvaluechange="onFormItemValueChange" 
    style="">
</app-mpicker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.bzr.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='bzr' :itemRules="this.rules.bzr" class='' :caption="$t('entities.trmtrainplanterm.main_form.details.bzr')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bzr.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-mpicker
    :activeData="data"
    :disabled="detailsModel.bzr.disabled"
    :curvalue="data.bzr"
    name="bzr"
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :service="service"
    :acParams="{ }"
    :pickupView="{ viewname: 'trm-hmatser-mpickup-view', title: $t('entities.trmhmatser.views.mpickupview.title'), deResParameters: [{ pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' }, ], parameters: [{ pathName: 'trmhmatsers', parameterName: 'trmhmatser' }, { pathName: 'mpickupview', parameterName: 'mpickupview' } ], placement:'' }"
    @formitemvaluechange="onFormItemValueChange" 
    style="">
</app-mpicker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.bjzt.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='bjzt' :itemRules="this.rules.bjzt" class='' :caption="$t('entities.trmtrainplanterm.main_form.details.bjzt')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bjzt.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.bjzt" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.bjzt.disabled"  
    tag='EhrCodeList0017' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>


            </tab-pane> 
            <tab-pane v-show="detailsModel.formpage2.visible" name='formpage2' :index="1" tab='main' class=''  
                :label="(h) =>{
                    return h('span',{
                        class:'caption'
                    },[
                    $t('entities.trmtrainplanterm.main_form.details.formpage2')
                    ])
                }">
                    
<i-col v-show="detailsModel.druipart1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-druipart
    
    :formState="formState"
    :isForbidLoad="this.data.srfuf === '0'"
    paramItem='trmtrainplanterm' 
    :parentdata='{"srfparentdefname":"TRMTRAINPLANTERMID","srfparentdename":"TRMTRAINPLANTERM","SRFPARENTTYPE":"DER1N","srfparentmode":"DER1N_TRMTRIANPERSON_TRMTRAINPLANTERM_TRMTRAINPLANTERMID","SRFDER1NID":"DER1N_TRMTRIANPERSON_TRMTRAINPLANTERM_TRMTRAINPLANTERMID"}'
    :parameters="[
        { pathName: 'pimpeople', parameterName: 'pimperson' },
    ]"
    :context="context"
    :viewparams="viewparams"
    :localContext ='{}'
    :localParam ='{}'
    parameterName='trmtrainplanterm'
    parentName="TrmTrainPlanterm"  
    refviewtype='DEGRIDVIEW' 
    refreshitems='' 
    :ignorefieldvaluechange="ignorefieldvaluechange"
    viewname='trm-train-person-grid-view' 
    :data="JSON.stringify(this.data)" 
    @drdatasaved="drdatasaved($event)"
    style=";overflow: auto;">
</app-form-druipart>

</i-col>


            </tab-pane> 
            <tab-pane v-show="detailsModel.formpage3.visible" name='formpage3' :index="2" tab='main' class=''  
                :label="(h) =>{
                    return h('span',{
                        class:'caption'
                    },[
                    $t('entities.trmtrainplanterm.main_form.details.formpage3')
                    ])
                }">
                    
<i-col v-show="detailsModel.druipart2.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-druipart
    
    :formState="formState"
    :isForbidLoad="this.data.srfuf === '0'"
    paramItem='trmtrainplanterm' 
    :parentdata='{"srfparentdefname":"TRMTRAINPLANTERMID","srfparentdename":"TRMTRAINPLANTERM","SRFPARENTTYPE":"DER1N","srfparentmode":"DER1N_ATTENDANCERECORD_TRMTRAINPLANTERM_TRMTRAINPLANTERMID","SRFDER1NID":"DER1N_ATTENDANCERECORD_TRMTRAINPLANTERM_TRMTRAINPLANTERMID"}'
    :parameters="[
        { pathName: 'pimpeople', parameterName: 'pimperson' },
    ]"
    :context="context"
    :viewparams="viewparams"
    :localContext ='{}'
    :localParam ='{}'
    parameterName='trmtrainplanterm'
    parentName="TrmTrainPlanterm"  
    refviewtype='DEGRIDVIEW' 
    refreshitems='' 
    :ignorefieldvaluechange="ignorefieldvaluechange"
    viewname='att-endance-record-grid-view' 
    :data="JSON.stringify(this.data)" 
    @drdatasaved="drdatasaved($event)"
    style=";overflow: auto;">
</app-form-druipart>

</i-col>


            </tab-pane> 
            <tab-pane v-show="detailsModel.formpage4.visible" name='formpage4' :index="3" tab='main' class=''  
                :label="(h) =>{
                    return h('span',{
                        class:'caption'
                    },[
                    $t('entities.trmtrainplanterm.main_form.details.formpage4')
                    ])
                }">
                    
<i-col v-show="detailsModel.druipart3.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-druipart
    
    :formState="formState"
    :isForbidLoad="this.data.srfuf === '0'"
    paramItem='trmtrainplanterm' 
    :parentdata='{"srfparentdefname":"TRMTRAINPLANTERMID","srfparentdename":"TRMTRAINPLANTERM","SRFPARENTTYPE":"DER1N","srfparentmode":"DER1N_TRMCOUARRANGE_TRMTRAINPLANTERM_TRMTRAINPLANTERMID","SRFDER1NID":"DER1N_TRMCOUARRANGE_TRMTRAINPLANTERM_TRMTRAINPLANTERMID"}'
    :parameters="[
        { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
    ]"
    :context="context"
    :viewparams="viewparams"
    :localContext ='{}'
    :localParam ='{}'
    parameterName='trmtrainplanterm'
    parentName="TrmTrainPlanterm"  
    refviewtype='DEGRIDVIEW' 
    refreshitems='' 
    :ignorefieldvaluechange="ignorefieldvaluechange"
    viewname='trm-couarrange-grid-view' 
    :data="JSON.stringify(this.data)" 
    @drdatasaved="drdatasaved($event)"
    style=";overflow: auto;">
</app-form-druipart>

</i-col>


            </tab-pane> 
    </tabs>
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
import TrmTrainPlantermService from '@/service/trm-train-planterm/trm-train-planterm-service';
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
     * @type {TrmTrainPlantermService}
     * @memberof MainBase
     */
    public appEntityService: TrmTrainPlantermService = new TrmTrainPlantermService({ $store: this.$store });
    


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
        trmtrainplanname: null,
        nd: null,
        trmtrainplantermname: null,
        jhkssj: null,
        jhjssj: null,
        trmtrainagencyname: null,
        pxdd: null,
        trmtraincoursename: null,
        trmtrainteachername: null,
        bzr: null,
        bjzt: null,
        trmtrainplanid: null,
        trmtraincourseid: null,
        trmtrainagencyid: null,
        trmtrainplantermid: null,
        trmtrainplanterm:null,
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
            { type: 'string', message: '培训立项标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训立项标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训立项标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训立项标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '培训立项名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训立项名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训立项名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训立项名称 值不能为空', trigger: 'blur' },
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
        trmtrainplanname: [
            { type: 'string', message: '培训计划 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训计划 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训计划 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训计划 值不能为空', trigger: 'blur' },
        ],
        nd: [
            { type: 'string', message: '年度 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '年度 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '年度 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '年度 值不能为空', trigger: 'blur' },
        ],
        trmtrainplantermname: [
            { type: 'string', message: '培训立项名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训立项名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训立项名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训立项名称 值不能为空', trigger: 'blur' },
        ],
        jhkssj: [
            { type: 'string', message: '培训开始时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训开始时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训开始时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训开始时间 值不能为空', trigger: 'blur' },
        ],
        jhjssj: [
            { type: 'string', message: '培训结束时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训结束时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训结束时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训结束时间 值不能为空', trigger: 'blur' },
        ],
        trmtrainagencyname: [
            { type: 'string', message: '培训机构 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训机构 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训机构 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训机构 值不能为空', trigger: 'blur' },
        ],
        pxdd: [
            { type: 'string', message: '培训地点 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训地点 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训地点 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训地点 值不能为空', trigger: 'blur' },
        ],
        trmtraincoursename: [
            { type: 'string', message: '课程 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '课程 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '课程 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '课程 值不能为空', trigger: 'blur' },
        ],
        trmtrainteachername: [
            { type: 'string', message: '讲师 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '讲师 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '讲师 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '讲师 值不能为空', trigger: 'blur' },
        ],
        bzr: [
            { type: 'string', message: '班主任 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '班主任 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '班主任 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '班主任 值不能为空', trigger: 'blur' },
        ],
        bjzt: [
            { type: 'string', message: '班级状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '班级状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '班级状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '班级状态 值不能为空', trigger: 'blur' },
        ],
        trmtrainplanid: [
            { type: 'string', message: '培训计划标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训计划标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训计划标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训计划标识 值不能为空', trigger: 'blur' },
        ],
        trmtraincourseid: [
            { type: 'string', message: '培训课程标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训课程标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训课程标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训课程标识 值不能为空', trigger: 'blur' },
        ],
        trmtrainagencyid: [
            { type: 'string', message: '培训机构标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训机构标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训机构标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训机构标识 值不能为空', trigger: 'blur' },
        ],
        trmtrainplantermid: [
            { type: 'string', message: '培训立项标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训立项标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训立项标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训立项标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof MainBase
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '培训立项信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.trmtrainplanterm.main_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        druipart1: new FormDRUIPartModel({ caption: '', detailType: 'DRUIPART', name: 'druipart1', visible: true, isShowCaption: true, form: this })
, 
        formpage2: new FormPageModel({ caption: '参培人员', detailType: 'FORMPAGE', name: 'formpage2', visible: true, isShowCaption: true, form: this })
, 
        druipart2: new FormDRUIPartModel({ caption: '', detailType: 'DRUIPART', name: 'druipart2', visible: true, isShowCaption: true, form: this })
, 
        formpage3: new FormPageModel({ caption: '班级考勤记录', detailType: 'FORMPAGE', name: 'formpage3', visible: true, isShowCaption: true, form: this })
, 
        druipart3: new FormDRUIPartModel({ caption: '', detailType: 'DRUIPART', name: 'druipart3', visible: true, isShowCaption: true, form: this })
, 
        formpage4: new FormPageModel({ caption: '培训记录', detailType: 'FORMPAGE', name: 'formpage4', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '培训立项标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '培训立项名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtrainplanname: new FormItemModel({ caption: '培训计划', detailType: 'FORMITEM', name: 'trmtrainplanname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        nd: new FormItemModel({ caption: '年度', detailType: 'FORMITEM', name: 'nd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        trmtrainplantermname: new FormItemModel({ caption: '培训立项名称', detailType: 'FORMITEM', name: 'trmtrainplantermname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jhkssj: new FormItemModel({ caption: '培训开始时间', detailType: 'FORMITEM', name: 'jhkssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jhjssj: new FormItemModel({ caption: '培训结束时间', detailType: 'FORMITEM', name: 'jhjssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtrainagencyname: new FormItemModel({ caption: '培训机构', detailType: 'FORMITEM', name: 'trmtrainagencyname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pxdd: new FormItemModel({ caption: '培训地点', detailType: 'FORMITEM', name: 'pxdd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtraincoursename: new FormItemModel({ caption: '课程', detailType: 'FORMITEM', name: 'trmtraincoursename', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtrainteachername: new FormItemModel({ caption: '讲师', detailType: 'FORMITEM', name: 'trmtrainteachername', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bzr: new FormItemModel({ caption: '班主任', detailType: 'FORMITEM', name: 'bzr', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bjzt: new FormItemModel({ caption: '班级状态', detailType: 'FORMITEM', name: 'bjzt', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtrainplanid: new FormItemModel({ caption: '培训计划标识', detailType: 'FORMITEM', name: 'trmtrainplanid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtraincourseid: new FormItemModel({ caption: '培训课程标识', detailType: 'FORMITEM', name: 'trmtraincourseid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtrainagencyid: new FormItemModel({ caption: '培训机构标识', detailType: 'FORMITEM', name: 'trmtrainagencyid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        trmtrainplantermid: new FormItemModel({ caption: '培训立项标识', detailType: 'FORMITEM', name: 'trmtrainplantermid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        form: new FormTabPanelModel({ caption: 'form', detailType: 'TABPANEL', name: 'form', visible: true, isShowCaption: true, form: this, tabPages: [{ name: 'formpage1', index: 0, visible: true }, { name: 'formpage2', index: 1, visible: true }, { name: 'formpage3', index: 2, visible: true }, { name: 'formpage4', index: 3, visible: true }] }),
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
     * 监控表单属性 trmtrainplanname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.trmtrainplanname')
    onTrmtrainplannameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtrainplanname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 nd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.nd')
    onNdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'nd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtrainplantermname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.trmtrainplantermname')
    onTrmtrainplantermnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtrainplantermname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jhkssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.jhkssj')
    onJhkssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jhkssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jhjssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.jhjssj')
    onJhjssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jhjssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtrainagencyname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.trmtrainagencyname')
    onTrmtrainagencynameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtrainagencyname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pxdd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pxdd')
    onPxddChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pxdd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtraincoursename 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.trmtraincoursename')
    onTrmtraincoursenameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtraincoursename', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtrainteachername 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.trmtrainteachername')
    onTrmtrainteachernameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtrainteachername', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bzr 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.bzr')
    onBzrChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bzr', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bjzt 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.bjzt')
    onBjztChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bjzt', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtrainplanid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.trmtrainplanid')
    onTrmtrainplanidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtrainplanid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtraincourseid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.trmtraincourseid')
    onTrmtraincourseidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtraincourseid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtrainagencyid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.trmtrainagencyid')
    onTrmtrainagencyidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtrainagencyid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 trmtrainplantermid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.trmtrainplantermid')
    onTrmtrainplantermidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'trmtrainplantermid', newVal: newVal, oldVal: oldVal });
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
        if(data.trmtrainplanterm){
            Object.assign(this.context,{trmtrainplanterm:data.trmtrainplanterm})
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
        copyData.trmtrainplanterm = copyData.srfkey;
        copyData.trmtrainplantermid = copyData.srfkey;
        Object.assign(this.context,{trmtrainplanterm:copyData.trmtrainplanterm})
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
        _this.$print({id:'trmtrainplanterm_main',popTitle:'主编辑表单'});
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
            this.$Notice.error({ title: '错误', desc: 'TrmTrainPlantermEditView视图表单loadAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'TrmTrainPlantermEditView视图表单loaddraftAction参数未配置' });
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
            if(data.trmtrainplanterm){
                Object.assign(this.context,{trmtrainplanterm:data.trmtrainplanterm})
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
            this.$Notice.error({ title: '错误', desc: 'TrmTrainPlantermEditView视图表单'+actionName+'参数未配置' });
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
                this.drcounter = 3;
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
                this.$Notice.error({ title: '错误', desc: 'TrmTrainPlantermEditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'TrmTrainPlantermEditView视图表单removeAction参数未配置' });
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
        if (!arg.trmtrainplanterm || Object.is(arg.trmtrainplanterm, '')) {
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