<template>
  <app-layout viewName="pcmprofileqtzpwizardview" viewTitle="其他招聘应聘者信息录入向导" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'dewizardview': true, 'pcmprofileqtzpwizard-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
                    <view_wizardpanel 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
              :showBusyIndicator="true"
                finishAction='Save' 
                initAction='Create' 
                name="wizardpanel"  
                ref='wizardpanel' 
                @finish="wizardpanel_finish($event)"  
                @closeview="closeView($event)">
            </view_wizardpanel>

      </div>
    </template>
  </app-layout>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PCMPROFILEService from '@/service/pcmprofile/pcmprofile-service';

import WizardViewEngine from '@engine/view/wizard-view-engine';


/**
 * 其他招聘应聘者信息录入向导基类
 *
 * @export
 * @class PCMPROFILEQTZPWizardViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PCMPROFILEQTZPWizardViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PCMPROFILEService}
     * @memberof PCMPROFILEQTZPWizardViewBase
     */
    public appEntityService: PCMPROFILEService = new PCMPROFILEService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PCMPROFILEQTZPWizardViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PCMPROFILEQTZPWizardViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PCMPROFILEQTZPWizardViewBase
	 */
	public viewtag: string = 'b8a30edae7c11d128c2162bbf21def52';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PCMPROFILEQTZPWizardViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PCMPROFILEQTZPWizardViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PCMPROFILEQTZPWizardViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PCMPROFILEQTZPWizardViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmprofile.views.qtzpwizardview.caption',
        srfTitle: 'entities.pcmprofile.views.qtzpwizardview.title',
        srfSubTitle: 'entities.pcmprofile.views.qtzpwizardview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PCMPROFILEQTZPWizardViewBase
     */
    public containerModel: any = {
        view_wizardpanel: { name: 'wizardpanel', type: 'WIZARDPANEL' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PCMPROFILEQTZPWizardViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PCMPROFILEQTZPWizardViewBase
     */
    public engine: WizardViewEngine = new WizardViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PCMPROFILEQTZPWizardViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            wizardpanel: this.$refs.wizardpanel,
            keyPSDEField: 'pcmprofile',
            majorPSDEField: 'pcmprofilename',
            isLoadDefault: true,
        });
    }


    /**
     * wizardpanel 部件 finish 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMPROFILEQTZPWizardViewBase
     */
    public wizardpanel_finish($event: any, $event2?: any) {
        this.engine.onCtrlEvent('wizardpanel', 'finish', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof PCMPROFILEQTZPWizardViewBase
     */
    public destroyed(){
        if(this.viewDefaultUsage){
            let localStoreLength = Object.keys(localStorage);
            if(localStoreLength.length > 0){
                localStoreLength.forEach((item:string) =>{
                if(item.startsWith(this.context.srfsessionid)){
                    localStorage.removeItem(item);
                }
                })
            }
        }
    }

}
</script>

<style lang='less'>
@import './pcmprofileqtzpwizard-view.less';
</style>