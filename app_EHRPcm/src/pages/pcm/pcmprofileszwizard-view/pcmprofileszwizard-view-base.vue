<template>
  <app-layout viewName="pcmprofileszwizardview" viewTitle="社招应聘者信息录入向导" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'dewizardview': true, 'pcmprofileszwizard-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
                finishAction='Update' 
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
import PcmProfileService from '@/service/pcm-profile/pcm-profile-service';

import WizardViewEngine from '@engine/view/wizard-view-engine';


/**
 * 社招应聘者信息录入向导基类
 *
 * @export
 * @class PCMPROFILESZWizardViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PCMPROFILESZWizardViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmProfileService}
     * @memberof PCMPROFILESZWizardViewBase
     */
    public appEntityService: PcmProfileService = new PcmProfileService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PCMPROFILESZWizardViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PCMPROFILESZWizardViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PCMPROFILESZWizardViewBase
	 */
	public viewtag: string = 'c20756541eb3db24da51a2a9e8db3b80';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PCMPROFILESZWizardViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PCMPROFILESZWizardViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PCMPROFILESZWizardViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PCMPROFILESZWizardViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmprofile.views.szwizardview.caption',
        srfTitle: 'entities.pcmprofile.views.szwizardview.title',
        srfSubTitle: 'entities.pcmprofile.views.szwizardview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PCMPROFILESZWizardViewBase
     */
    public containerModel: any = {
        view_wizardpanel: { name: 'wizardpanel', type: 'WIZARDPANEL' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PCMPROFILESZWizardViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PCMPROFILESZWizardViewBase
     */
    public engine: WizardViewEngine = new WizardViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PCMPROFILESZWizardViewBase
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
     * @memberof PCMPROFILESZWizardViewBase
     */
    public wizardpanel_finish($event: any, $event2?: any) {
        this.engine.onCtrlEvent('wizardpanel', 'finish', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof PCMPROFILESZWizardViewBase
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
@import './pcmprofileszwizard-view.less';
</style>