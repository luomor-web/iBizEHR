<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='pcmzpmegl_main' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmzpmegl.main_form.details.group1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.nd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='nd' :itemRules="this.rules.nd" class='' :caption="$t('entities.pcmzpmegl.main_form.details.nd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nd.error" :isEmptyCaption="false" labelPos="LEFT">
    
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
<i-col v-show="detailsModel.ormorgname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ormorgname' :itemRules="this.rules.ormorgname" class='' :caption="$t('entities.pcmzpmegl.main_form.details.ormorgname')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.ormorgname.error" :isEmptyCaption="false" labelPos="LEFT">
    
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
  :acParams="{ serviceName: 'OrmOrgService', interfaceName: 'FetchOrglist_Profile'}"
  valueitem='ormorgid' 
  :value="data.ormorgname" 
  editortype="" 
  :pickupView="{ viewname: 'ormorgpickup-view', title: $t('entities.ormorg.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'ormorgs', parameterName: 'ormorg' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel2.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel2.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmzpmegl.main_form.details.grouppanel2')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.xyzpame.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='xyzpame' :itemRules="this.rules.xyzpame" class='' :caption="$t('entities.pcmzpmegl.main_form.details.xyzpame')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xyzpame.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.xyzpame"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.xyzpame.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ybdrs_xza.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ybdrs_xza' :itemRules="this.rules.ybdrs_xza" class='' :caption="$t('entities.pcmzpmegl.main_form.details.ybdrs_xza')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.ybdrs_xza.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ybdrs_xza"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ybdrs_xza.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfce_xza.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sfce_xza' :itemRules="this.rules.sfce_xza" class='' :caption="$t('entities.pcmzpmegl.main_form.details.sfce_xza')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.sfce_xza.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-radio-group 
  v-model="data.sfce_xza"
  :data="data" 
  :context="context"
  :viewparams="viewparams"   
  :disabled="detailsModel.sfce_xza.disabled"  
  name="sfce_xza" 
  :localContext ='{ }' 
  :localParam ='{ }' 
  tag='EhrCodeList0181' 
  codelistType='STATIC' 
  style="">
</app-radio-group>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.xyzpbme.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='xyzpbme' :itemRules="this.rules.xyzpbme" class='' :caption="$t('entities.pcmzpmegl.main_form.details.xyzpbme')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xyzpbme.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.xyzpbme"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.xyzpbme.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ybdrs_xzb.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ybdrs_xzb' :itemRules="this.rules.ybdrs_xzb" class='' :caption="$t('entities.pcmzpmegl.main_form.details.ybdrs_xzb')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.ybdrs_xzb.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ybdrs_xzb"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ybdrs_xzb.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfce_xzb.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sfce_xzb' :itemRules="this.rules.sfce_xzb" class='' :caption="$t('entities.pcmzpmegl.main_form.details.sfce_xzb')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.sfce_xzb.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-radio-group 
  v-model="data.sfce_xzb"
  :data="data" 
  :context="context"
  :viewparams="viewparams"   
  :disabled="detailsModel.sfce_xzb.disabled"  
  name="sfce_xzb" 
  :localContext ='{ }' 
  :localParam ='{ }' 
  tag='EhrCodeList0181' 
  codelistType='STATIC' 
  style="">
</app-radio-group>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.xyzpxzyme.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='xyzpxzyme' :itemRules="this.rules.xyzpxzyme" class='' :caption="$t('entities.pcmzpmegl.main_form.details.xyzpxzyme')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xyzpxzyme.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.xyzpxzyme"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.xyzpxzyme.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ybdrs_xzxzy.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ybdrs_xzxzy' :itemRules="this.rules.ybdrs_xzxzy" class='' :caption="$t('entities.pcmzpmegl.main_form.details.ybdrs_xzxzy')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.ybdrs_xzxzy.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ybdrs_xzxzy"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ybdrs_xzxzy.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfce_xzxzy.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sfce_xzxzy' :itemRules="this.rules.sfce_xzxzy" class='' :caption="$t('entities.pcmzpmegl.main_form.details.sfce_xzxzy')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.sfce_xzxzy.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-radio-group 
  v-model="data.sfce_xzxzy"
  :data="data" 
  :context="context"
  :viewparams="viewparams"   
  :disabled="detailsModel.sfce_xzxzy.disabled"  
  name="sfce_xzxzy" 
  :localContext ='{ }' 
  :localParam ='{ }' 
  tag='EhrCodeList0181' 
  codelistType='STATIC' 
  style="">
</app-radio-group>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.shzpame.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='shzpame' :itemRules="this.rules.shzpame" class='' :caption="$t('entities.pcmzpmegl.main_form.details.shzpame')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.shzpame.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.shzpame"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.shzpame.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ybdrs_sza.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ybdrs_sza' :itemRules="this.rules.ybdrs_sza" class='' :caption="$t('entities.pcmzpmegl.main_form.details.ybdrs_sza')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.ybdrs_sza.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ybdrs_sza"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ybdrs_sza.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfce_sza.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sfce_sza' :itemRules="this.rules.sfce_sza" class='' :caption="$t('entities.pcmzpmegl.main_form.details.sfce_sza')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.sfce_sza.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-radio-group 
  v-model="data.sfce_sza"
  :data="data" 
  :context="context"
  :viewparams="viewparams"   
  :disabled="detailsModel.sfce_sza.disabled"  
  name="sfce_sza" 
  :localContext ='{ }' 
  :localParam ='{ }' 
  tag='EhrCodeList0181' 
  codelistType='STATIC' 
  style="">
</app-radio-group>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.shzpbme.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='shzpbme' :itemRules="this.rules.shzpbme" class='' :caption="$t('entities.pcmzpmegl.main_form.details.shzpbme')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.shzpbme.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.shzpbme"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.shzpbme.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ybdrs_szb.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ybdrs_szb' :itemRules="this.rules.ybdrs_szb" class='' :caption="$t('entities.pcmzpmegl.main_form.details.ybdrs_szb')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.ybdrs_szb.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ybdrs_szb"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ybdrs_szb.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfce_szb.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sfce_szb' :itemRules="this.rules.sfce_szb" class='' :caption="$t('entities.pcmzpmegl.main_form.details.sfce_szb')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.sfce_szb.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-radio-group 
  v-model="data.sfce_szb"
  :data="data" 
  :context="context"
  :viewparams="viewparams"   
  :disabled="detailsModel.sfce_szb.disabled"  
  name="sfce_szb" 
  :localContext ='{ }' 
  :localParam ='{ }' 
  tag='EhrCodeList0181' 
  codelistType='STATIC' 
  style="">
</app-radio-group>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.shzpyme.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='shzpyme' :itemRules="this.rules.shzpyme" class='' :caption="$t('entities.pcmzpmegl.main_form.details.shzpyme')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.shzpyme.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.shzpyme"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.shzpyme.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ybdrs_szy.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ybdrs_szy' :itemRules="this.rules.ybdrs_szy" class='' :caption="$t('entities.pcmzpmegl.main_form.details.ybdrs_szy')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.ybdrs_szy.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ybdrs_szy"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ybdrs_szy.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfce_szy.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sfce_szy' :itemRules="this.rules.sfce_szy" class='' :caption="$t('entities.pcmzpmegl.main_form.details.sfce_szy')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.sfce_szy.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-radio-group 
  v-model="data.sfce_szy"
  :data="data" 
  :context="context"
  :viewparams="viewparams"   
  :disabled="detailsModel.sfce_szy.disabled"  
  name="sfce_szy" 
  :localContext ='{ }' 
  :localParam ='{ }' 
  tag='EhrCodeList0181' 
  codelistType='STATIC' 
  style="">
</app-radio-group>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.shzpjhwme.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='shzpjhwme' :itemRules="this.rules.shzpjhwme" class='' :caption="$t('entities.pcmzpmegl.main_form.details.shzpjhwme')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.shzpjhwme.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.shzpjhwme"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.shzpjhwme.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ybdrs_szjhw.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ybdrs_szjhw' :itemRules="this.rules.ybdrs_szjhw" class='' :caption="$t('entities.pcmzpmegl.main_form.details.ybdrs_szjhw')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.ybdrs_szjhw.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ybdrs_szjhw"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ybdrs_szjhw.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfce_szjhw.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sfce_szjhw' :itemRules="this.rules.sfce_szjhw" class='' :caption="$t('entities.pcmzpmegl.main_form.details.sfce_szjhw')" uiStyle="DEFAULT" :labelWidth="180" :isShowCaption="true" :error="detailsModel.sfce_szjhw.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-radio-group 
  v-model="data.sfce_szjhw"
  :data="data" 
  :context="context"
  :viewparams="viewparams"   
  :disabled="detailsModel.sfce_szjhw.disabled"  
  name="sfce_szjhw" 
  :localContext ='{ }' 
  :localParam ='{ }' 
  tag='EhrCodeList0181' 
  codelistType='STATIC' 
  style="">
</app-radio-group>
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
import PcmZpmeglService from '@/service/pcm-zpmegl/pcm-zpmegl-service';
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
     * @type {PcmZpmeglService}
     * @memberof MainBase
     */
    public appEntityService: PcmZpmeglService = new PcmZpmeglService({ $store: this.$store });
    


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
        nd: null,
        ormorgid: null,
        ormorgname: null,
        xyzpame: null,
        ybdrs_xza: null,
        sfce_xza: null,
        xyzpbme: null,
        ybdrs_xzb: null,
        sfce_xzb: null,
        xyzpxzyme: null,
        ybdrs_xzxzy: null,
        sfce_xzxzy: null,
        shzpame: null,
        ybdrs_sza: null,
        sfce_sza: null,
        shzpbme: null,
        ybdrs_szb: null,
        sfce_szb: null,
        shzpyme: null,
        ybdrs_szy: null,
        sfce_szy: null,
        shzpjhwme: null,
        ybdrs_szjhw: null,
        sfce_szjhw: null,
        pcmzpmeglid: null,
        pcmzpmegl:null,
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
            { type: 'string', message: '招聘名额管理标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '招聘名额管理标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '招聘名额管理标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '招聘名额管理标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '招聘名额管理名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '招聘名额管理名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '招聘名额管理名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '招聘名额管理名称 值不能为空', trigger: 'blur' },
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
        nd: [
            { type: 'string', message: '年度 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '年度 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '年度 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '年度 值不能为空', trigger: 'blur' },
        ],
        ormorgid: [
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'blur' },
        ],
        ormorgname: [
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '组织 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '组织 值不能为空', trigger: 'blur' },
        ],
        xyzpame: [
            { type: 'number', message: '校招A名额 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '校招A名额 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '校招A名额 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '校招A名额 值不能为空', trigger: 'blur' },
        ],
        ybdrs_xza: [
            { type: 'number', message: '已使用名额（校招A） 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '已使用名额（校招A） 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '已使用名额（校招A） 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '已使用名额（校招A） 值不能为空', trigger: 'blur' },
        ],
        sfce_xza: [
            { type: 'string', message: '是否超额（校招A） 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '是否超额（校招A） 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '是否超额（校招A） 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '是否超额（校招A） 值不能为空', trigger: 'blur' },
        ],
        xyzpbme: [
            { type: 'number', message: '校招B名额 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '校招B名额 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '校招B名额 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '校招B名额 值不能为空', trigger: 'blur' },
        ],
        ybdrs_xzb: [
            { type: 'number', message: '已使用名额（校招B） 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '已使用名额（校招B） 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '已使用名额（校招B） 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '已使用名额（校招B） 值不能为空', trigger: 'blur' },
        ],
        sfce_xzb: [
            { type: 'string', message: '是否超额（校招B） 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '是否超额（校招B） 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '是否超额（校招B） 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '是否超额（校招B） 值不能为空', trigger: 'blur' },
        ],
        xyzpxzyme: [
            { type: 'number', message: '校招小专业名额 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '校招小专业名额 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '校招小专业名额 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '校招小专业名额 值不能为空', trigger: 'blur' },
        ],
        ybdrs_xzxzy: [
            { type: 'number', message: '已使用名额（校招小专业） 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '已使用名额（校招小专业） 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '已使用名额（校招小专业） 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '已使用名额（校招小专业） 值不能为空', trigger: 'blur' },
        ],
        sfce_xzxzy: [
            { type: 'string', message: '是否超额（校招小专业） 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '是否超额（校招小专业） 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '是否超额（校招小专业） 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '是否超额（校招小专业） 值不能为空', trigger: 'blur' },
        ],
        shzpame: [
            { type: 'number', message: '社招A名额 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '社招A名额 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '社招A名额 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '社招A名额 值不能为空', trigger: 'blur' },
        ],
        ybdrs_sza: [
            { type: 'number', message: '已使用名额（社招A） 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '已使用名额（社招A） 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '已使用名额（社招A） 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '已使用名额（社招A） 值不能为空', trigger: 'blur' },
        ],
        sfce_sza: [
            { type: 'string', message: '是否超额（社招A） 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '是否超额（社招A） 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '是否超额（社招A） 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '是否超额（社招A） 值不能为空', trigger: 'blur' },
        ],
        shzpbme: [
            { type: 'number', message: '社招B名额 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '社招B名额 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '社招B名额 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '社招B名额 值不能为空', trigger: 'blur' },
        ],
        ybdrs_szb: [
            { type: 'number', message: '已使用名额（社招B） 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '已使用名额（社招B） 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '已使用名额（社招B） 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '已使用名额（社招B） 值不能为空', trigger: 'blur' },
        ],
        sfce_szb: [
            { type: 'string', message: '是否超额（社招B） 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '是否超额（社招B） 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '是否超额（社招B） 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '是否超额（社招B） 值不能为空', trigger: 'blur' },
        ],
        shzpyme: [
            { type: 'number', message: '社招Y名额 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '社招Y名额 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '社招Y名额 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '社招Y名额 值不能为空', trigger: 'blur' },
        ],
        ybdrs_szy: [
            { type: 'number', message: '已使用名额（社招Y） 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '已使用名额（社招Y） 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '已使用名额（社招Y） 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '已使用名额（社招Y） 值不能为空', trigger: 'blur' },
        ],
        sfce_szy: [
            { type: 'string', message: '是否超额（社招Y） 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '是否超额（社招Y） 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '是否超额（社招Y） 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '是否超额（社招Y） 值不能为空', trigger: 'blur' },
        ],
        shzpjhwme: [
            { type: 'number', message: '社招计划外名额 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '社招计划外名额 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '社招计划外名额 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '社招计划外名额 值不能为空', trigger: 'blur' },
        ],
        ybdrs_szjhw: [
            { type: 'number', message: '已使用名额（社招计划外） 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '已使用名额（社招计划外） 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '已使用名额（社招计划外） 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '已使用名额（社招计划外） 值不能为空', trigger: 'blur' },
        ],
        sfce_szjhw: [
            { type: 'string', message: '是否超额（社招计划外） 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '是否超额（社招计划外） 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '是否超额（社招计划外） 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '是否超额（社招计划外） 值不能为空', trigger: 'blur' },
        ],
        pcmzpmeglid: [
            { type: 'string', message: '招聘名额管理标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '招聘名额管理标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '招聘名额管理标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '招聘名额管理标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof MainBase
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '招聘名额信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmzpmegl.main_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel2: new FormGroupPanelModel({ caption: '招聘名额分类', detailType: 'GROUPPANEL', name: 'grouppanel2', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmzpmegl.main_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '招聘名额管理标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '招聘名额管理名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        nd: new FormItemModel({ caption: '年度', detailType: 'FORMITEM', name: 'nd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgid: new FormItemModel({ caption: '组织标识', detailType: 'FORMITEM', name: 'ormorgid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgname: new FormItemModel({ caption: '组织', detailType: 'FORMITEM', name: 'ormorgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        xyzpame: new FormItemModel({ caption: '校招A名额', detailType: 'FORMITEM', name: 'xyzpame', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ybdrs_xza: new FormItemModel({ caption: '已使用名额（校招A）', detailType: 'FORMITEM', name: 'ybdrs_xza', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        sfce_xza: new FormItemModel({ caption: '是否超额（校招A）', detailType: 'FORMITEM', name: 'sfce_xza', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        xyzpbme: new FormItemModel({ caption: '校招B名额', detailType: 'FORMITEM', name: 'xyzpbme', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ybdrs_xzb: new FormItemModel({ caption: '已使用名额（校招B）', detailType: 'FORMITEM', name: 'ybdrs_xzb', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        sfce_xzb: new FormItemModel({ caption: '是否超额（校招B）', detailType: 'FORMITEM', name: 'sfce_xzb', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        xyzpxzyme: new FormItemModel({ caption: '校招小专业名额', detailType: 'FORMITEM', name: 'xyzpxzyme', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ybdrs_xzxzy: new FormItemModel({ caption: '已使用名额（校招小专业）', detailType: 'FORMITEM', name: 'ybdrs_xzxzy', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        sfce_xzxzy: new FormItemModel({ caption: '是否超额（校招小专业）', detailType: 'FORMITEM', name: 'sfce_xzxzy', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        shzpame: new FormItemModel({ caption: '社招A名额', detailType: 'FORMITEM', name: 'shzpame', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ybdrs_sza: new FormItemModel({ caption: '已使用名额（社招A）', detailType: 'FORMITEM', name: 'ybdrs_sza', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        sfce_sza: new FormItemModel({ caption: '是否超额（社招A）', detailType: 'FORMITEM', name: 'sfce_sza', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        shzpbme: new FormItemModel({ caption: '社招B名额', detailType: 'FORMITEM', name: 'shzpbme', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ybdrs_szb: new FormItemModel({ caption: '已使用名额（社招B）', detailType: 'FORMITEM', name: 'ybdrs_szb', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        sfce_szb: new FormItemModel({ caption: '是否超额（社招B）', detailType: 'FORMITEM', name: 'sfce_szb', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        shzpyme: new FormItemModel({ caption: '社招Y名额', detailType: 'FORMITEM', name: 'shzpyme', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ybdrs_szy: new FormItemModel({ caption: '已使用名额（社招Y）', detailType: 'FORMITEM', name: 'ybdrs_szy', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        sfce_szy: new FormItemModel({ caption: '是否超额（社招Y）', detailType: 'FORMITEM', name: 'sfce_szy', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        shzpjhwme: new FormItemModel({ caption: '社招计划外名额', detailType: 'FORMITEM', name: 'shzpjhwme', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ybdrs_szjhw: new FormItemModel({ caption: '已使用名额（社招计划外）', detailType: 'FORMITEM', name: 'ybdrs_szjhw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        sfce_szjhw: new FormItemModel({ caption: '是否超额（社招计划外）', detailType: 'FORMITEM', name: 'sfce_szjhw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        pcmzpmeglid: new FormItemModel({ caption: '招聘名额管理标识', detailType: 'FORMITEM', name: 'pcmzpmeglid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
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
     * 监控表单属性 ormorgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormorgid')
    onOrmorgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormorgname')
    onOrmorgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xyzpame 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.xyzpame')
    onXyzpameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xyzpame', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ybdrs_xza 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ybdrs_xza')
    onYbdrs_xzaChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ybdrs_xza', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfce_xza 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sfce_xza')
    onSfce_xzaChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfce_xza', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xyzpbme 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.xyzpbme')
    onXyzpbmeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xyzpbme', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ybdrs_xzb 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ybdrs_xzb')
    onYbdrs_xzbChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ybdrs_xzb', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfce_xzb 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sfce_xzb')
    onSfce_xzbChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfce_xzb', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xyzpxzyme 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.xyzpxzyme')
    onXyzpxzymeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xyzpxzyme', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ybdrs_xzxzy 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ybdrs_xzxzy')
    onYbdrs_xzxzyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ybdrs_xzxzy', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfce_xzxzy 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sfce_xzxzy')
    onSfce_xzxzyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfce_xzxzy', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 shzpame 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.shzpame')
    onShzpameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'shzpame', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ybdrs_sza 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ybdrs_sza')
    onYbdrs_szaChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ybdrs_sza', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfce_sza 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sfce_sza')
    onSfce_szaChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfce_sza', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 shzpbme 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.shzpbme')
    onShzpbmeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'shzpbme', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ybdrs_szb 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ybdrs_szb')
    onYbdrs_szbChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ybdrs_szb', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfce_szb 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sfce_szb')
    onSfce_szbChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfce_szb', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 shzpyme 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.shzpyme')
    onShzpymeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'shzpyme', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ybdrs_szy 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ybdrs_szy')
    onYbdrs_szyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ybdrs_szy', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfce_szy 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sfce_szy')
    onSfce_szyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfce_szy', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 shzpjhwme 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.shzpjhwme')
    onShzpjhwmeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'shzpjhwme', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ybdrs_szjhw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ybdrs_szjhw')
    onYbdrs_szjhwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ybdrs_szjhw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfce_szjhw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sfce_szjhw')
    onSfce_szjhwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfce_szjhw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmzpmeglid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pcmzpmeglid')
    onPcmzpmeglidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmzpmeglid', newVal: newVal, oldVal: oldVal });
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
        if(data.pcmzpmegl){
            Object.assign(this.context,{pcmzpmegl:data.pcmzpmegl})
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
        copyData.pcmzpmegl = copyData.srfkey;
        copyData.pcmzpmeglid = copyData.srfkey;
        Object.assign(this.context,{pcmzpmegl:copyData.pcmzpmegl})
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
        _this.$print({id:'pcmzpmegl_main',popTitle:'主编辑表单'});
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
            this.$Notice.error({ title: '错误', desc: 'PCMZPMEGLEditView视图表单loadAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'PCMZPMEGLEditView视图表单loaddraftAction参数未配置' });
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
            if(data.pcmzpmegl){
                Object.assign(this.context,{pcmzpmegl:data.pcmzpmegl})
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
            this.$Notice.error({ title: '错误', desc: 'PCMZPMEGLEditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PCMZPMEGLEditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PCMZPMEGLEditView视图表单removeAction参数未配置' });
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
        if (!arg.pcmzpmegl || Object.is(arg.pcmzpmegl, '')) {
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
        if (this.data.hasOwnProperty('ormorgid')) {
            this.data['ormorgid'] = this.context['SRFORGID'];
        }
        if (this.data.hasOwnProperty('ormorgname')) {
            this.data['ormorgname'] = this.context['SRFORGNAME'];
        }
        if (this.data.hasOwnProperty('ybdrs_xza')) {
            this.data['ybdrs_xza'] = 0;
        }
        if (this.data.hasOwnProperty('ybdrs_xzb')) {
            this.data['ybdrs_xzb'] = 0;
        }
        if (this.data.hasOwnProperty('ybdrs_xzxzy')) {
            this.data['ybdrs_xzxzy'] = 0;
        }
        if (this.data.hasOwnProperty('ybdrs_sza')) {
            this.data['ybdrs_sza'] = 0;
        }
        if (this.data.hasOwnProperty('ybdrs_szb')) {
            this.data['ybdrs_szb'] = 0;
        }
        if (this.data.hasOwnProperty('ybdrs_szy')) {
            this.data['ybdrs_szy'] = 0;
        }
        if (this.data.hasOwnProperty('ybdrs_szjhw')) {
            this.data['ybdrs_szjhw'] = 0;
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