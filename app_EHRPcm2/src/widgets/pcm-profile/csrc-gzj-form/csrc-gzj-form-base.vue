<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='pcmprofile_csrc_gzj' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmprofile.csrc_gzj_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.grouppanel3.visible" :style="{}"  :lg="{ span: 16, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel3.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmprofile.csrc_gzj_form.details.grouppanel3')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.pcmprofilename.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='pcmprofilename' :itemRules="this.rules.pcmprofilename" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.pcmprofilename')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pcmprofilename.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pcmprofilename"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pcmprofilename.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.cym.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='cym' :itemRules="this.rules.cym" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.cym')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.cym.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.cym"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.cym.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.certificatetype.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='certificatetype' :itemRules="this.rules.certificatetype" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.certificatetype')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.certificatetype.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.certificatetype" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.certificatetype.disabled"  
    tag='EhrCodeList0231' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.certificatenumber.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='certificatenumber' :itemRules="this.rules.certificatenumber" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.certificatenumber')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.certificatenumber.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.certificatenumber"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.certificatenumber.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.birthday.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='birthday' :itemRules="this.rules.birthday" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.birthday')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.birthday.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.birthday"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.birthday.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.nl.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='nl' :itemRules="this.rules.nl" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.nl')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nl.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.nl"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.nl.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gender.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='gender' :itemRules="this.rules.gender" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.gender')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gender.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.gender" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.gender.disabled"  
    tag='EhrCodeList0072' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bloodtype.visible" :style="{}"  :lg="{ span: 12, offset: 0 }">
    <app-form-item name='bloodtype' :itemRules="this.rules.bloodtype" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.bloodtype')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bloodtype.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.bloodtype" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.bloodtype.disabled"  
    tag='EhrCodeList0018' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel4.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel4.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmprofile.csrc_gzj_form.details.grouppanel4')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.zp.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='zp' :itemRules="this.rules.zp" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.zp')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zp.error" :isEmptyCaption="false" labelPos="LEFT">
     <app-image-upload :multiple="true" :formState="formState" :ignorefieldvaluechange="ignorefieldvaluechange" @formitemvaluechange="onFormItemValueChange" :data="JSON.stringify(this.data)" name='zp' :value="data.zp" :disabled="detailsModel.zp.disabled" :uploadparams='{}' :exportparams='{}' style="height:160px;width:150px;overflow: auto;"></app-image-upload>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel5.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel5.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmprofile.csrc_gzj_form.details.grouppanel5')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.mobile.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='mobile' :itemRules="this.rules.mobile" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.mobile')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.mobile.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.mobile"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.mobile.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.email.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='email' :itemRules="this.rules.email" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.email')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.email.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.email"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.email.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.wedstate.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='wedstate' :itemRules="this.rules.wedstate" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.wedstate')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.wedstate.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.wedstate" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.wedstate.disabled"  
    tag='EhrCodeList0075' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.nation.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='nation' :itemRules="this.rules.nation" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.nation')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nation.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.nation" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.nation.disabled"  
    tag='EhrCodeList0066' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.hklx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='hklx' :itemRules="this.rules.hklx" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.hklx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.hklx.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.hklx" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.hklx.disabled"  
    tag='EhrCodeList0070' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.nativeplace.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='nativeplace' :itemRules="this.rules.nativeplace" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.nativeplace')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nativeplace.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-autocomplete 
    :data="data"
    :disabled="detailsModel.nativeplace.disabled" 
    name='nativeplace'
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :service="service"
    :acParams="{ }"
    valueitem='' 
    :value="data.nativeplace" 
    @formitemvaluechange="onFormItemValueChange"
    style="">
</app-autocomplete>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.rpr.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='rpr' :itemRules="this.rules.rpr" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.rpr')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rpr.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.rpr" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.rpr.disabled"  
    tag='EhrCodeList0001' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.address.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='address' :itemRules="this.rules.address" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.address')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.address.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-autocomplete 
    :data="data"
    :disabled="detailsModel.address.disabled" 
    name='address'
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :service="service"
    :acParams="{ }"
    valueitem='' 
    :value="data.address" 
    @formitemvaluechange="onFormItemValueChange"
    style="">
</app-autocomplete>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.csd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='csd' :itemRules="this.rules.csd" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.csd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.csd.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-autocomplete 
    :data="data"
    :disabled="detailsModel.csd.disabled" 
    name='csd'
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :service="service"
    :acParams="{ }"
    valueitem='' 
    :value="data.csd" 
    @formitemvaluechange="onFormItemValueChange"
    style="">
</app-autocomplete>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmprofile.csrc_gzj_form.details.grouppanel1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.polity.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='polity' :itemRules="this.rules.polity" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.polity')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.polity.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.polity" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.polity.disabled"  
    tag='EhrCodeList0029' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel2.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel2.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmprofile.csrc_gzj_form.details.grouppanel2')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.yglx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='yglx' :itemRules="this.rules.yglx" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.yglx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.yglx.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.yglx" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.yglx.disabled"  
    tag='EhrCodeList0096' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormorgname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ormorgname' :itemRules="this.rules.ormorgname" class='' :caption="$t('entities.pcmprofile.csrc_gzj_form.details.ormorgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormorgname.error" :isEmptyCaption="false" labelPos="LEFT">
    
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
  :pickupView="{ viewname: 'orm-org-ypzsyfpxxpickup-view', title: $t('entities.ormorg.views.ypzsyfpxxpickupview.title'), deResParameters: [], parameters: [{ pathName: 'ormorgs', parameterName: 'ormorg' }, { pathName: 'ypzsyfpxxpickupview', parameterName: 'ypzsyfpxxpickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

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
import PcmProfileService from '@/service/pcm-profile/pcm-profile-service';
import CSRC_GZJService from './csrc-gzj-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class CSRC_GZJBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof CSRC_GZJBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof CSRC_GZJBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof CSRC_GZJBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof CSRC_GZJBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof CSRC_GZJBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof CSRC_GZJBase
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof CSRC_GZJBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {CSRC_GZJService}
     * @memberof CSRC_GZJBase
     */
    public service: CSRC_GZJService = new CSRC_GZJService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PcmProfileService}
     * @memberof CSRC_GZJBase
     */
    public appEntityService: PcmProfileService = new PcmProfileService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof CSRC_GZJBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof CSRC_GZJBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof CSRC_GZJBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof CSRC_GZJBase
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof CSRC_GZJBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof CSRC_GZJBase
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof CSRC_GZJBase
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof CSRC_GZJBase
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof CSRC_GZJBase
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof CSRC_GZJBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof CSRC_GZJBase
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof CSRC_GZJBase
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof CSRC_GZJBase
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof CSRC_GZJBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof CSRC_GZJBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof CSRC_GZJBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof CSRC_GZJBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof CSRC_GZJBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof CSRC_GZJBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof CSRC_GZJBase
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
        pcmprofileid: null,
        cadidateid: null,
        elinkurl: null,
        pcmprofilename: null,
        cym: null,
        certificatetype: null,
        certificatenumber: null,
        birthday: null,
        nl: null,
        gender: null,
        bloodtype: null,
        zp: null,
        mobile: null,
        email: null,
        wedstate: null,
        nation: null,
        hklx: null,
        nativeplace: null,
        rpr: null,
        address: null,
        csd: null,
        profiletype: null,
        polity: null,
        yglx: null,
        ormorgid: null,
        ormorgname: null,
        rzqd: null,
        pcmprofile:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof CSRC_GZJBase
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof CSRC_GZJBase
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof CSRC_GZJBase
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof CSRC_GZJBase
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof CSRC_GZJBase
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
            { type: 'string', message: '应聘者ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '应聘者ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '应聘者ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '应聘者ID 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '姓名 值不能为空', trigger: 'blur' },
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
        pcmprofileid: [
            { type: 'string', message: '应聘者ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '应聘者ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '应聘者ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '应聘者ID 值不能为空', trigger: 'blur' },
        ],
        cadidateid: [
            { type: 'string', message: '应聘者编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '应聘者编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '应聘者编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '应聘者编号 值不能为空', trigger: 'blur' },
        ],
        elinkurl: [
            { type: 'string', message: '应聘者Elink详情 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '应聘者Elink详情 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '应聘者Elink详情 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '应聘者Elink详情 值不能为空', trigger: 'blur' },
        ],
        pcmprofilename: [
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '姓名 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '姓名 值不能为空', trigger: 'blur' },
        ],
        cym: [
            { type: 'string', message: '曾用名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '曾用名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '曾用名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '曾用名 值不能为空', trigger: 'blur' },
        ],
        certificatetype: [
            { type: 'string', message: '证件类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证件类型 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '证件类型 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '证件类型 值不能为空', trigger: 'blur' },
        ],
        certificatenumber: [
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '证件号码 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '证件号码 值不能为空', trigger: 'blur' },
        ],
        birthday: [
            { type: 'string', message: '出生日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '出生日期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '出生日期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '出生日期 值不能为空', trigger: 'blur' },
        ],
        nl: [
            { type: 'number', message: '年龄 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '年龄 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '年龄 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '年龄 值不能为空', trigger: 'blur' },
        ],
        gender: [
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'blur' },
        ],
        bloodtype: [
            { type: 'string', message: '血型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '血型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '血型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '血型 值不能为空', trigger: 'blur' },
        ],
        zp: [
            { type: 'string', message: '照片 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '照片 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '照片 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '照片 值不能为空', trigger: 'blur' },
        ],
        mobile: [
            { type: 'string', message: '手机号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '手机号 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '手机号 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '手机号 值不能为空', trigger: 'blur' },
        ],
        email: [
            { type: 'string', message: '邮箱 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '邮箱 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '邮箱 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '邮箱 值不能为空', trigger: 'blur' },
        ],
        wedstate: [
            { type: 'string', message: '婚姻状况 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '婚姻状况 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '婚姻状况 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '婚姻状况 值不能为空', trigger: 'blur' },
        ],
        nation: [
            { type: 'string', message: '民族 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '民族 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '民族 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '民族 值不能为空', trigger: 'blur' },
        ],
        hklx: [
            { type: 'string', message: '户口类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '户口类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '户口类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '户口类型 值不能为空', trigger: 'blur' },
        ],
        nativeplace: [
            { type: 'string', message: '籍贯 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '籍贯 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '籍贯 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '籍贯 值不能为空', trigger: 'blur' },
        ],
        rpr: [
            { type: 'string', message: '户籍所在地 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '户籍所在地 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '户籍所在地 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '户籍所在地 值不能为空', trigger: 'blur' },
        ],
        address: [
            { type: 'string', message: '通讯地址 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '通讯地址 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '通讯地址 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '通讯地址 值不能为空', trigger: 'blur' },
        ],
        csd: [
            { type: 'string', message: '出生地 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '出生地 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '出生地 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '出生地 值不能为空', trigger: 'blur' },
        ],
        profiletype: [
            { type: 'string', message: '应聘者状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '应聘者状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '应聘者状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '应聘者状态 值不能为空', trigger: 'blur' },
        ],
        polity: [
            { type: 'string', message: '政治面貌 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '政治面貌 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '政治面貌 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '政治面貌 值不能为空', trigger: 'blur' },
        ],
        yglx: [
            { type: 'string', message: '申报类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '申报类型 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '申报类型 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '申报类型 值不能为空', trigger: 'blur' },
        ],
        ormorgid: [
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'blur' },
        ],
        ormorgname: [
            { type: 'string', message: '组织名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织名称 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '组织名称 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '组织名称 值不能为空', trigger: 'blur' },
        ],
        rzqd: [
            { type: 'string', message: '入职渠道 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '入职渠道 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '入职渠道 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '入职渠道 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof CSRC_GZJBase
     */
    public detailsModel: any = {
        grouppanel3: new FormGroupPanelModel({ caption: '', detailType: 'GROUPPANEL', name: 'grouppanel3', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmprofile.csrc_gzj_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel4: new FormGroupPanelModel({ caption: '照片', detailType: 'GROUPPANEL', name: 'grouppanel4', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmprofile.csrc_gzj_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel5: new FormGroupPanelModel({ caption: '相关信息', detailType: 'GROUPPANEL', name: 'grouppanel5', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmprofile.csrc_gzj_form', extractMode: 'ITEM', details: [] } })
, 
        group1: new FormGroupPanelModel({ caption: '人员基本信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmprofile.csrc_gzj_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel1: new FormGroupPanelModel({ caption: '政治面貌', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmprofile.csrc_gzj_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel2: new FormGroupPanelModel({ caption: '职务相关', detailType: 'GROUPPANEL', name: 'grouppanel2', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmprofile.csrc_gzj_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '应聘者ID', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '姓名', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmprofileid: new FormItemModel({ caption: '应聘者ID', detailType: 'FORMITEM', name: 'pcmprofileid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        cadidateid: new FormItemModel({ caption: '应聘者编号', detailType: 'FORMITEM', name: 'cadidateid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        elinkurl: new FormItemModel({ caption: '应聘者Elink详情', detailType: 'FORMITEM', name: 'elinkurl', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmprofilename: new FormItemModel({ caption: '姓名', detailType: 'FORMITEM', name: 'pcmprofilename', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        cym: new FormItemModel({ caption: '曾用名', detailType: 'FORMITEM', name: 'cym', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        certificatetype: new FormItemModel({ caption: '证件类型', detailType: 'FORMITEM', name: 'certificatetype', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        certificatenumber: new FormItemModel({ caption: '证件号码', detailType: 'FORMITEM', name: 'certificatenumber', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        birthday: new FormItemModel({ caption: '出生日期', detailType: 'FORMITEM', name: 'birthday', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        nl: new FormItemModel({ caption: '年龄', detailType: 'FORMITEM', name: 'nl', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        gender: new FormItemModel({ caption: '性别', detailType: 'FORMITEM', name: 'gender', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        bloodtype: new FormItemModel({ caption: '血型', detailType: 'FORMITEM', name: 'bloodtype', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zp: new FormItemModel({ caption: '照片', detailType: 'FORMITEM', name: 'zp', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        mobile: new FormItemModel({ caption: '手机号', detailType: 'FORMITEM', name: 'mobile', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        email: new FormItemModel({ caption: '邮箱', detailType: 'FORMITEM', name: 'email', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        wedstate: new FormItemModel({ caption: '婚姻状况', detailType: 'FORMITEM', name: 'wedstate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        nation: new FormItemModel({ caption: '民族', detailType: 'FORMITEM', name: 'nation', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        hklx: new FormItemModel({ caption: '户口类型', detailType: 'FORMITEM', name: 'hklx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        nativeplace: new FormItemModel({ caption: '籍贯', detailType: 'FORMITEM', name: 'nativeplace', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        rpr: new FormItemModel({ caption: '户籍所在地', detailType: 'FORMITEM', name: 'rpr', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        address: new FormItemModel({ caption: '通讯地址', detailType: 'FORMITEM', name: 'address', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        csd: new FormItemModel({ caption: '出生地', detailType: 'FORMITEM', name: 'csd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        profiletype: new FormItemModel({ caption: '应聘者状态', detailType: 'FORMITEM', name: 'profiletype', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        polity: new FormItemModel({ caption: '政治面貌', detailType: 'FORMITEM', name: 'polity', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        yglx: new FormItemModel({ caption: '申报类型', detailType: 'FORMITEM', name: 'yglx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgid: new FormItemModel({ caption: '组织标识', detailType: 'FORMITEM', name: 'ormorgid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgname: new FormItemModel({ caption: '组织名称', detailType: 'FORMITEM', name: 'ormorgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        rzqd: new FormItemModel({ caption: '入职渠道', detailType: 'FORMITEM', name: 'rzqd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmprofileid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.pcmprofileid')
    onPcmprofileidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmprofileid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 cadidateid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.cadidateid')
    onCadidateidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'cadidateid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 elinkurl 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.elinkurl')
    onElinkurlChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'elinkurl', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmprofilename 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.pcmprofilename')
    onPcmprofilenameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmprofilename', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 cym 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.cym')
    onCymChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'cym', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 certificatetype 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.certificatetype')
    onCertificatetypeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'certificatetype', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 certificatenumber 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.certificatenumber')
    onCertificatenumberChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'certificatenumber', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 birthday 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.birthday')
    onBirthdayChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'birthday', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 nl 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.nl')
    onNlChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'nl', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gender 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.gender')
    onGenderChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gender', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bloodtype 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.bloodtype')
    onBloodtypeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bloodtype', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zp 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.zp')
    onZpChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zp', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 mobile 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.mobile')
    onMobileChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'mobile', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 email 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.email')
    onEmailChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'email', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 wedstate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.wedstate')
    onWedstateChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'wedstate', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 nation 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.nation')
    onNationChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'nation', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 hklx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.hklx')
    onHklxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'hklx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 nativeplace 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.nativeplace')
    onNativeplaceChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'nativeplace', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rpr 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.rpr')
    onRprChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rpr', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 address 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.address')
    onAddressChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'address', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 csd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.csd')
    onCsdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'csd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 profiletype 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.profiletype')
    onProfiletypeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'profiletype', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 polity 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.polity')
    onPolityChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'polity', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 yglx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.yglx')
    onYglxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'yglx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    @Watch('data.ormorgname')
    onOrmorgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rzqd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof CSRC_GZJBase
     */
    @Watch('data.rzqd')
    onRzqdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rzqd', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof CSRC_GZJBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                











































        if(Object.is(name, 'certificatenumber')){
            const details: string[] = ['gender', 'birthday', 'nl'];
            this.updateFormItems('PersonUpdateInfo', this.data, details, true);
        }
    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.pcmprofile){
            Object.assign(this.context,{pcmprofile:data.pcmprofile})
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof CSRC_GZJBase
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
     * @memberof @memberof CSRC_GZJBase
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.pcmprofile = copyData.srfkey;
        copyData.pcmprofileid = copyData.srfkey;
        Object.assign(this.context,{pcmprofile:copyData.pcmprofile})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof CSRC_GZJBase
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'pcmprofile_csrc_gzj',popTitle:'成熟人才招聘（挂职进新增）'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'PcmProfileGZJRYEditView视图表单loadAction参数未配置' });
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
     * @memberof CSRC_GZJBase
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'PcmProfileGZJRYEditView视图表单loaddraftAction参数未配置' });
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
            if(data.pcmprofile){
                Object.assign(this.context,{pcmprofile:data.pcmprofile})
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
     * @memberof CSRC_GZJBase
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
            this.$Notice.error({ title: '错误', desc: 'PcmProfileGZJRYEditView视图表单'+actionName+'参数未配置' });
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
     * @memberof CSRC_GZJBase
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
                this.$Notice.error({ title: '错误', desc: 'PcmProfileGZJRYEditView视图表单'+actionName+'参数未配置' });
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
    * @memberof CSRC_GZJBase
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'PcmProfileGZJRYEditView视图表单removeAction参数未配置' });
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.pcmprofile || Object.is(arg.pcmprofile, '')) {
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
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
    * @memberof CSRC_GZJBase
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
     * @memberof CSRC_GZJBase
     */
    public createDefault(){                    
        if (this.data.hasOwnProperty('profiletype')) {
            this.data['profiletype'] = '30';
        }
        if (this.data.hasOwnProperty('ormorgid')) {
            this.data['ormorgid'] = this.context['SRFORGID'];
        }
        if (this.data.hasOwnProperty('ormorgname')) {
            this.data['ormorgname'] = this.context['SRFORGNAME'];
        }
        if (this.data.hasOwnProperty('rzqd')) {
            this.data['rzqd'] = '85';
        }
    }

    /**
     * 更新默认值
     * @memberof CSRC_GZJBase
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './csrc-gzj-form.less';
</style>