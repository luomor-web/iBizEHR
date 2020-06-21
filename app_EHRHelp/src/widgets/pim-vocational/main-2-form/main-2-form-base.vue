<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='pimvocational_main_2' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimvocational.main_2_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.zgzsbh.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zgzsbh' :itemRules="this.rules.zgzsbh" class='' :caption="$t('entities.pimvocational.main_2_form.details.zgzsbh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zgzsbh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zgzsbh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zgzsbh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zslx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zslx' :itemRules="this.rules.zslx" class='' :caption="$t('entities.pimvocational.main_2_form.details.zslx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zslx.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.zslx" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.zslx.disabled"  
    tag='EhrCodeList0109' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pimqualtypename.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pimqualtypename' :itemRules="this.rules.pimqualtypename" class='' :caption="$t('entities.pimvocational.main_2_form.details.pimqualtypename')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimqualtypename.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.pimqualtypename.disabled"
  name='pimqualtypename'
  deMajorField='pimqualtypename'
  deKeyField='pimqualtype'
  :service="service"
  :acParams="{ serviceName: 'PimQualTypeService', interfaceName: 'FetchDefault'}"
  valueitem='pimqualtypeid' 
  :value="data.pimqualtypename" 
  editortype="" 
  :pickupView="{ viewname: 'pimqualtypepickup-view', title: $t('entities.pimqualtype.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'pimqualtypes', parameterName: 'pimqualtype' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.pimqualmajorname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pimqualmajorname' :itemRules="this.rules.pimqualmajorname" class='' :caption="$t('entities.pimvocational.main_2_form.details.pimqualmajorname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimqualmajorname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.pimqualmajorname.disabled"
  name='pimqualmajorname'
  deMajorField='zyzgzy'
  deKeyField='pimqualmajor'
  :service="service"
  :acParams="{ serviceName: 'PimQualMajorService', interfaceName: 'FetchXZZGZY'}"
  valueitem='pimqualmajorid' 
  :value="data.pimqualmajorname" 
  editortype="" 
  :pickupView="{ viewname: 'pimqualmajorpickup-view', title: $t('entities.pimqualmajor.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'pimqualmajors', parameterName: 'pimqualmajor' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.zgsydw.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zgsydw' :itemRules="this.rules.zgsydw" class='' :caption="$t('entities.pimvocational.main_2_form.details.zgsydw')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zgsydw.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zgsydw"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zgsydw.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.practqualcertno.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='practqualcertno' :itemRules="this.rules.practqualcertno" class='' :caption="$t('entities.pimvocational.main_2_form.details.practqualcertno')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.practqualcertno.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.practqualcertno"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.practqualcertno.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.regisnumber.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='regisnumber' :itemRules="this.rules.regisnumber" class='' :caption="$t('entities.pimvocational.main_2_form.details.regisnumber')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.regisnumber.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.regisnumber"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.regisnumber.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormsignorgname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ormsignorgname' :itemRules="this.rules.ormsignorgname" class='' :caption="$t('entities.pimvocational.main_2_form.details.ormsignorgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormsignorgname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.ormsignorgname.disabled"
  name='ormsignorgname'
  deMajorField='ormsignorgname'
  deKeyField='ormsignorg'
  :service="service"
  :acParams="{ serviceName: 'OrmSignOrgService', interfaceName: 'FetchCKBDWDFRZT'}"
  valueitem='ormsignorgid' 
  :value="data.ormsignorgname" 
  editortype="" 
  :pickupView="{ viewname: 'orm-sign-org-bdwpickup-view', title: $t('entities.ormsignorg.views.bdwpickupview.title'), deResParameters: [], parameters: [{ pathName: 'ormsignorgs', parameterName: 'ormsignorg' }, { pathName: 'bdwpickupview', parameterName: 'bdwpickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.socsecpayunit.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='socsecpayunit' :itemRules="this.rules.socsecpayunit" class='' :caption="$t('entities.pimvocational.main_2_form.details.socsecpayunit')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.socsecpayunit.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.socsecpayunit"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.socsecpayunit.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bcardnumber.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='bcardnumber' :itemRules="this.rules.bcardnumber" class='' :caption="$t('entities.pimvocational.main_2_form.details.bcardnumber')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bcardnumber.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bcardnumber"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.bcardnumber.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimvocational.main_2_form.details.grouppanel1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.zghqrq.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zghqrq' :itemRules="this.rules.zghqrq" class='' :caption="$t('entities.pimvocational.main_2_form.details.zghqrq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zghqrq.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.zghqrq" :disabled="detailsModel.zghqrq.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.zghqrq = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.cszcsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='cszcsj' :itemRules="this.rules.cszcsj" class='' :caption="$t('entities.pimvocational.main_2_form.details.cszcsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.cszcsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.cszcsj" :disabled="detailsModel.cszcsj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.cszcsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.xzcsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='xzcsj' :itemRules="this.rules.xzcsj" class='' :caption="$t('entities.pimvocational.main_2_form.details.xzcsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xzcsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.xzcsj" :disabled="detailsModel.xzcsj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.xzcsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sxrq.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sxrq' :itemRules="this.rules.sxrq" class='' :caption="$t('entities.pimvocational.main_2_form.details.sxrq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sxrq.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.sxrq" :disabled="detailsModel.sxrq.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.sxrq = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.fzyxq.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='fzyxq' :itemRules="this.rules.fzyxq" class='' :caption="$t('entities.pimvocational.main_2_form.details.fzyxq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fzyxq.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.fzyxq"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.fzyxq.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.nsqk.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='nsqk' :itemRules="this.rules.nsqk" class='' :caption="$t('entities.pimvocational.main_2_form.details.nsqk')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nsqk.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.nsqk"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.nsqk.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.syqk.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='syqk' :itemRules="this.rules.syqk" class='' :caption="$t('entities.pimvocational.main_2_form.details.syqk')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.syqk.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.syqk"  :disabled="detailsModel.syqk.disabled" type='textarea' style="" ></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.alteration.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='alteration' :itemRules="this.rules.alteration" class='' :caption="$t('entities.pimvocational.main_2_form.details.alteration')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.alteration.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.alteration"  :disabled="detailsModel.alteration.disabled" type='textarea' style="" ></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.fj.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='fj' :itemRules="this.rules.fj" class='' :caption="$t('entities.pimvocational.main_2_form.details.fj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fj.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-file-upload :formState="formState" :ignorefieldvaluechange="ignorefieldvaluechange" @formitemvaluechange="onFormItemValueChange" :data="JSON.stringify(this.data)" name='fj' :value="data.fj" :disabled="detailsModel.fj.disabled" :uploadparams='{}' :exportparams='{}'  style="overflow: auto;"></app-file-upload>
</app-form-item>

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
import PimVocationalService from '@/service/pim-vocational/pim-vocational-service';
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
     * @type {PimVocationalService}
     * @memberof Main_2Base
     */
    public appEntityService: PimVocationalService = new PimVocationalService({ $store: this.$store });
    


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
        zgzsbh: null,
        zslx: null,
        pimqualtypename: null,
        pimqualmajorname: null,
        zsmc: null,
        zgsydw: null,
        practqualcertno: null,
        regisnumber: null,
        ormsignorgname: null,
        socsecpayunit: null,
        bcardnumber: null,
        ormorgid: null,
        pimvocationalcatalogid: null,
        ormorgsectorid: null,
        jlss: null,
        pimpersonid: null,
        ormorgid2: null,
        zghqrq: null,
        cszcsj: null,
        xzcsj: null,
        sxrq: null,
        fzyxq: null,
        nsqk: null,
        syqk: null,
        alteration: null,
        fj: null,
        pimvocationalid: null,
        pimqualtypeid: null,
        pimqualmajorid: null,
        ormsignorgid: null,
        pimvocational:null,
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
            { type: 'string', message: '执（职）业资格信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '执（职）业资格信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '执（职）业资格信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '执（职）业资格信息标识 值不能为空', trigger: 'blur' },
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
        zgzsbh: [
            { type: 'string', message: '证书编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证书编号 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '证书编号 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '证书编号 值不能为空', trigger: 'blur' },
        ],
        zslx: [
            { type: 'string', message: '证书类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证书类型 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '证书类型 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '证书类型 值不能为空', trigger: 'blur' },
        ],
        pimqualtypename: [
            { type: 'string', message: '岗位技能证书 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '岗位技能证书 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '岗位技能证书 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '岗位技能证书 值不能为空', trigger: 'blur' },
        ],
        pimqualmajorname: [
            { type: 'string', message: '职业资格专业 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职业资格专业 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '职业资格专业 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '职业资格专业 值不能为空', trigger: 'blur' },
        ],
        zsmc: [
            { type: 'string', message: '证书名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证书名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '证书名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '证书名称 值不能为空', trigger: 'blur' },
        ],
        zgsydw: [
            { type: 'string', message: '签发机构 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '签发机构 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '签发机构 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '签发机构 值不能为空', trigger: 'blur' },
        ],
        practqualcertno: [
            { type: 'string', message: '执业资格证书编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '执业资格证书编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '执业资格证书编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '执业资格证书编号 值不能为空', trigger: 'blur' },
        ],
        regisnumber: [
            { type: 'string', message: '注册编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '注册编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '注册编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '注册编号 值不能为空', trigger: 'blur' },
        ],
        ormsignorgname: [
            { type: 'string', message: '注册单位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '注册单位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '注册单位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '注册单位 值不能为空', trigger: 'blur' },
        ],
        socsecpayunit: [
            { type: 'string', message: '社保缴纳单位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '社保缴纳单位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '社保缴纳单位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '社保缴纳单位 值不能为空', trigger: 'blur' },
        ],
        bcardnumber: [
            { type: 'string', message: '一建配套B证编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '一建配套B证编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '一建配套B证编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '一建配套B证编号 值不能为空', trigger: 'blur' },
        ],
        ormorgid: [
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'blur' },
        ],
        pimvocationalcatalogid: [
            { type: 'string', message: '职（执）业资格管理标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职（执）业资格管理标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职（执）业资格管理标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职（执）业资格管理标识 值不能为空', trigger: 'blur' },
        ],
        ormorgsectorid: [
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'blur' },
        ],
        jlss: [
            { type: 'string', message: '记录所属 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '记录所属 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '记录所属 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '记录所属 值不能为空', trigger: 'blur' },
        ],
        pimpersonid: [
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
        ],
        ormorgid2: [
            { type: 'string', message: '组织ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织ID 值不能为空', trigger: 'blur' },
        ],
        zghqrq: [
            { type: 'string', message: '签发日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '签发日期 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '签发日期 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '签发日期 值不能为空', trigger: 'blur' },
        ],
        cszcsj: [
            { type: 'string', message: '初始注册时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '初始注册时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '初始注册时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '初始注册时间 值不能为空', trigger: 'blur' },
        ],
        xzcsj: [
            { type: 'string', message: '续注册时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '续注册时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '续注册时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '续注册时间 值不能为空', trigger: 'blur' },
        ],
        sxrq: [
            { type: 'string', message: '失效日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '失效日期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '失效日期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '失效日期 值不能为空', trigger: 'blur' },
        ],
        fzyxq: [
            { type: 'string', message: '发证有效期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '发证有效期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '发证有效期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '发证有效期 值不能为空', trigger: 'blur' },
        ],
        nsqk: [
            { type: 'string', message: '年审情况 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '年审情况 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '年审情况 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '年审情况 值不能为空', trigger: 'blur' },
        ],
        syqk: [
            { type: 'string', message: '使用情况 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '使用情况 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '使用情况 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '使用情况 值不能为空', trigger: 'blur' },
        ],
        alteration: [
            { type: 'string', message: '变更情况 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '变更情况 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '变更情况 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '变更情况 值不能为空', trigger: 'blur' },
        ],
        fj: [
            { type: 'string', message: '附件 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '附件 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '附件 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '附件 值不能为空', trigger: 'blur' },
        ],
        pimvocationalid: [
            { type: 'string', message: '执（职）业资格信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '执（职）业资格信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '执（职）业资格信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '执（职）业资格信息标识 值不能为空', trigger: 'blur' },
        ],
        pimqualtypeid: [
            { type: 'string', message: '岗位（技能）证书ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '岗位（技能）证书ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '岗位（技能）证书ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '岗位（技能）证书ID 值不能为空', trigger: 'blur' },
        ],
        pimqualmajorid: [
            { type: 'string', message: '执业资格专业编码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '执业资格专业编码 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '执业资格专业编码 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '执业资格专业编码 值不能为空', trigger: 'blur' },
        ],
        ormsignorgid: [
            { type: 'string', message: '法人主体标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '法人主体标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '法人主体标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '法人主体标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof Main_2Base
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '证书信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimvocational.main_2_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel1: new FormGroupPanelModel({ caption: '资格获得情况', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimvocational.main_2_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '执（职）业资格信息标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
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
        zgzsbh: new FormItemModel({ caption: '证书编号', detailType: 'FORMITEM', name: 'zgzsbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zslx: new FormItemModel({ caption: '证书类型', detailType: 'FORMITEM', name: 'zslx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimqualtypename: new FormItemModel({ caption: '岗位技能证书', detailType: 'FORMITEM', name: 'pimqualtypename', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimqualmajorname: new FormItemModel({ caption: '职业资格专业', detailType: 'FORMITEM', name: 'pimqualmajorname', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zsmc: new FormItemModel({ caption: '证书名称', detailType: 'FORMITEM', name: 'zsmc', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        zgsydw: new FormItemModel({ caption: '签发机构', detailType: 'FORMITEM', name: 'zgsydw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        practqualcertno: new FormItemModel({ caption: '执业资格证书编号', detailType: 'FORMITEM', name: 'practqualcertno', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        regisnumber: new FormItemModel({ caption: '注册编号', detailType: 'FORMITEM', name: 'regisnumber', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormsignorgname: new FormItemModel({ caption: '注册单位', detailType: 'FORMITEM', name: 'ormsignorgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        socsecpayunit: new FormItemModel({ caption: '社保缴纳单位', detailType: 'FORMITEM', name: 'socsecpayunit', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bcardnumber: new FormItemModel({ caption: '一建配套B证编号', detailType: 'FORMITEM', name: 'bcardnumber', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgid: new FormItemModel({ caption: '组织标识', detailType: 'FORMITEM', name: 'ormorgid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimvocationalcatalogid: new FormItemModel({ caption: '职（执）业资格管理标识', detailType: 'FORMITEM', name: 'pimvocationalcatalogid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgsectorid: new FormItemModel({ caption: '部门标识', detailType: 'FORMITEM', name: 'ormorgsectorid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jlss: new FormItemModel({ caption: '记录所属', detailType: 'FORMITEM', name: 'jlss', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonid: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'pimpersonid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgid2: new FormItemModel({ caption: '组织ID', detailType: 'FORMITEM', name: 'ormorgid2', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zghqrq: new FormItemModel({ caption: '签发日期', detailType: 'FORMITEM', name: 'zghqrq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        cszcsj: new FormItemModel({ caption: '初始注册时间', detailType: 'FORMITEM', name: 'cszcsj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        xzcsj: new FormItemModel({ caption: '续注册时间', detailType: 'FORMITEM', name: 'xzcsj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sxrq: new FormItemModel({ caption: '失效日期', detailType: 'FORMITEM', name: 'sxrq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        fzyxq: new FormItemModel({ caption: '发证有效期', detailType: 'FORMITEM', name: 'fzyxq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        nsqk: new FormItemModel({ caption: '年审情况', detailType: 'FORMITEM', name: 'nsqk', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        syqk: new FormItemModel({ caption: '使用情况', detailType: 'FORMITEM', name: 'syqk', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        alteration: new FormItemModel({ caption: '变更情况', detailType: 'FORMITEM', name: 'alteration', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        fj: new FormItemModel({ caption: '附件', detailType: 'FORMITEM', name: 'fj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimvocationalid: new FormItemModel({ caption: '执（职）业资格信息标识', detailType: 'FORMITEM', name: 'pimvocationalid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimqualtypeid: new FormItemModel({ caption: '岗位（技能）证书ID', detailType: 'FORMITEM', name: 'pimqualtypeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimqualmajorid: new FormItemModel({ caption: '执业资格专业编码', detailType: 'FORMITEM', name: 'pimqualmajorid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormsignorgid: new FormItemModel({ caption: '法人主体标识', detailType: 'FORMITEM', name: 'ormsignorgid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
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
     * 监控表单属性 zgzsbh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.zgzsbh')
    onZgzsbhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zgzsbh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zslx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.zslx')
    onZslxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zslx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimqualtypename 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.pimqualtypename')
    onPimqualtypenameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimqualtypename', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimqualmajorname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.pimqualmajorname')
    onPimqualmajornameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimqualmajorname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zsmc 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.zsmc')
    onZsmcChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zsmc', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zgsydw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.zgsydw')
    onZgsydwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zgsydw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 practqualcertno 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.practqualcertno')
    onPractqualcertnoChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'practqualcertno', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 regisnumber 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.regisnumber')
    onRegisnumberChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'regisnumber', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormsignorgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.ormsignorgname')
    onOrmsignorgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormsignorgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 socsecpayunit 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.socsecpayunit')
    onSocsecpayunitChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'socsecpayunit', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bcardnumber 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.bcardnumber')
    onBcardnumberChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bcardnumber', newVal: newVal, oldVal: oldVal });
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
     * 监控表单属性 pimvocationalcatalogid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.pimvocationalcatalogid')
    onPimvocationalcatalogidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimvocationalcatalogid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgsectorid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.ormorgsectorid')
    onOrmorgsectoridChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgsectorid', newVal: newVal, oldVal: oldVal });
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
     * 监控表单属性 ormorgid2 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.ormorgid2')
    onOrmorgid2Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgid2', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zghqrq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.zghqrq')
    onZghqrqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zghqrq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 cszcsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.cszcsj')
    onCszcsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'cszcsj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xzcsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.xzcsj')
    onXzcsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xzcsj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sxrq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.sxrq')
    onSxrqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sxrq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 fzyxq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.fzyxq')
    onFzyxqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'fzyxq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 nsqk 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.nsqk')
    onNsqkChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'nsqk', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 syqk 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.syqk')
    onSyqkChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'syqk', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 alteration 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.alteration')
    onAlterationChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'alteration', newVal: newVal, oldVal: oldVal });
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
     * 监控表单属性 pimvocationalid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.pimvocationalid')
    onPimvocationalidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimvocationalid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimqualtypeid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.pimqualtypeid')
    onPimqualtypeidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimqualtypeid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimqualmajorid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.pimqualmajorid')
    onPimqualmajoridChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimqualmajorid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormsignorgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main_2Base
     */
    @Watch('data.ormsignorgid')
    onOrmsignorgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormsignorgid', newVal: newVal, oldVal: oldVal });
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
                













        if (Object.is(name, '') || Object.is(name, 'zslx')) {
            let ret = false;
            const _zslx = this.data.zslx;
            if (this.$verify.testCond(_zslx, 'EQ', '5')) {
                ret = true;
            }
            this.detailsModel.pimqualtypename.setDisabled(!ret);
        }
        if (Object.is(name, '') || Object.is(name, 'zslx')) {
            let ret = false;
            const _zslx = this.data.zslx;
            if (this.$verify.testCond(_zslx, 'EQ', '5')) {
                ret = true;
            }
            this.detailsModel.pimqualtypename.setVisible(ret);
        }

        if (Object.is(name, '') || Object.is(name, 'zslx')) {
            let ret = false;
            const _zslx = this.data.zslx;
            if (this.$verify.testCond(_zslx, 'EQ', '10')) {
                ret = true;
            }
            this.detailsModel.pimqualmajorname.setVisible(ret);
        }



























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
        if(data.pimvocational){
            Object.assign(this.context,{pimvocational:data.pimvocational})
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
        copyData.pimvocational = copyData.srfkey;
        copyData.pimvocationalid = copyData.srfkey;
        Object.assign(this.context,{pimvocational:copyData.pimvocational})
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
        _this.$print({id:'pimvocational_main_2',popTitle:'主编辑表单(个人)'});
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
            this.$Notice.error({ title: '错误', desc: 'PIMVOCATIONALGREditView视图表单loadAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'PIMVOCATIONALGREditView视图表单loaddraftAction参数未配置' });
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
            if(data.pimvocational){
                Object.assign(this.context,{pimvocational:data.pimvocational})
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
            this.$Notice.error({ title: '错误', desc: 'PIMVOCATIONALGREditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PIMVOCATIONALGREditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PIMVOCATIONALGREditView视图表单removeAction参数未配置' });
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
        if (!arg.pimvocational || Object.is(arg.pimvocational, '')) {
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
        if (this.data.hasOwnProperty('jlss')) {
            this.data['jlss'] = '20';
        }
        if (this.data.hasOwnProperty('pimpersonid')) {
            this.data['pimpersonid'] = this.context['SRFSELFSERVICEID'];
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