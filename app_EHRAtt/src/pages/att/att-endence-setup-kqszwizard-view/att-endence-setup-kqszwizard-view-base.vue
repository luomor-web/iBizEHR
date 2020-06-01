<template>
  <app-layout viewName="attendencesetupkqszwizardview" viewTitle="考勤设置向导视图" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'dewizardview': true, 'att-endence-setup-kqszwizard-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import AttEndenceSetupService from '@/service/att-endence-setup/att-endence-setup-service';

import WizardViewEngine from '@engine/view/wizard-view-engine';


/**
 * 考勤设置向导视图基类
 *
 * @export
 * @class AttEndenceSetupKQSZWizardViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class AttEndenceSetupKQSZWizardViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {AttEndenceSetupService}
     * @memberof AttEndenceSetupKQSZWizardViewBase
     */
    public appEntityService: AttEndenceSetupService = new AttEndenceSetupService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof AttEndenceSetupKQSZWizardViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof AttEndenceSetupKQSZWizardViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof AttEndenceSetupKQSZWizardViewBase
	 */
	public viewtag: string = '74aaa92a32b08041d98ae05afa42f240';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof AttEndenceSetupKQSZWizardViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof AttEndenceSetupKQSZWizardViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof AttEndenceSetupKQSZWizardViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof AttEndenceSetupKQSZWizardViewBase
     */
    public model: any = {
        srfCaption: 'entities.attendencesetup.views.kqszwizardview.caption',
        srfTitle: 'entities.attendencesetup.views.kqszwizardview.title',
        srfSubTitle: 'entities.attendencesetup.views.kqszwizardview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof AttEndenceSetupKQSZWizardViewBase
     */
    public containerModel: any = {
        view_wizardpanel: { name: 'wizardpanel', type: 'WIZARDPANEL' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof AttEndenceSetupKQSZWizardViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof AttEndenceSetupKQSZWizardViewBase
     */
    public engine: WizardViewEngine = new WizardViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AttEndenceSetupKQSZWizardViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            wizardpanel: this.$refs.wizardpanel,
            keyPSDEField: 'attendencesetup',
            majorPSDEField: 'attendencesetupname',
            isLoadDefault: true,
        });
    }


    /**
     * wizardpanel 部件 finish 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof AttEndenceSetupKQSZWizardViewBase
     */
    public wizardpanel_finish($event: any, $event2?: any) {
        this.engine.onCtrlEvent('wizardpanel', 'finish', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof AttEndenceSetupKQSZWizardViewBase
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
@import './att-endence-setup-kqszwizard-view.less';
</style>