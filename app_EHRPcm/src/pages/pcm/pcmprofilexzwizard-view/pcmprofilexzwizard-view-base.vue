<template>
  <app-layout viewName="pcmprofilexzwizardview" viewTitle="校招应聘者信息录入向导" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'dewizardview': true, 'pcmprofilexzwizard-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import PCMPROFILEService from '@/service/pcmprofile/pcmprofile-service';

import WizardViewEngine from '@engine/view/wizard-view-engine';


/**
 * 校招应聘者信息录入向导基类
 *
 * @export
 * @class PCMPROFILEXZWizardViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PCMPROFILEXZWizardViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PCMPROFILEService}
     * @memberof PCMPROFILEXZWizardViewBase
     */
    public appEntityService: PCMPROFILEService = new PCMPROFILEService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PCMPROFILEXZWizardViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PCMPROFILEXZWizardViewBase
	 */
	public viewtag: string = '4229f6c634e435919e19f0af081f94e7';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PCMPROFILEXZWizardViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PCMPROFILEXZWizardViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PCMPROFILEXZWizardViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PCMPROFILEXZWizardViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmprofile.views.xzwizardview.caption',
        srfTitle: 'entities.pcmprofile.views.xzwizardview.title',
        srfSubTitle: 'entities.pcmprofile.views.xzwizardview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PCMPROFILEXZWizardViewBase
     */
    public containerModel: any = {
        view_wizardpanel: { name: 'wizardpanel', type: 'WIZARDPANEL' },
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof PCMPROFILEXZWizardViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @protected
     * @type {Engine}
     * @memberof PCMPROFILEXZWizardViewBase
     */
    protected engine: WizardViewEngine = new WizardViewEngine();
	

    /**
     * 引擎初始化
     *
     * @protected
     * @memberof PCMPROFILEXZWizardViewBase
     */
    protected engineInit(): void {
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
     * @memberof PCMPROFILEXZWizardViewBase
     */
    public wizardpanel_finish($event: any, $event2?: any) {
        this.engine.onCtrlEvent('wizardpanel', 'finish', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof PCMPROFILEXZWizardViewBase
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
@import './pcmprofilexzwizard-view.less';
</style>