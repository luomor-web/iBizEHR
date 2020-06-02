<template>
  <app-layout viewName="vacholidayruleskqgzwizardview" viewTitle="考勤规则向导" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'dewizardview': true, 'vac-holiday-rules-kqgzwizard-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import VacHolidayRulesService from '@/service/vac-holiday-rules/vac-holiday-rules-service';

import WizardViewEngine from '@engine/view/wizard-view-engine';


/**
 * 考勤规则向导基类
 *
 * @export
 * @class VacHolidayRulesKQGZWizardViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class VacHolidayRulesKQGZWizardViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {VacHolidayRulesService}
     * @memberof VacHolidayRulesKQGZWizardViewBase
     */
    public appEntityService: VacHolidayRulesService = new VacHolidayRulesService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof VacHolidayRulesKQGZWizardViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof VacHolidayRulesKQGZWizardViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof VacHolidayRulesKQGZWizardViewBase
	 */
	public viewtag: string = 'b7c9f4962c358749929067f91d7a09f8';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof VacHolidayRulesKQGZWizardViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof VacHolidayRulesKQGZWizardViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof VacHolidayRulesKQGZWizardViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof VacHolidayRulesKQGZWizardViewBase
     */
    public model: any = {
        srfCaption: 'entities.vacholidayrules.views.kqgzwizardview.caption',
        srfTitle: 'entities.vacholidayrules.views.kqgzwizardview.title',
        srfSubTitle: 'entities.vacholidayrules.views.kqgzwizardview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof VacHolidayRulesKQGZWizardViewBase
     */
    public containerModel: any = {
        view_wizardpanel: { name: 'wizardpanel', type: 'WIZARDPANEL' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof VacHolidayRulesKQGZWizardViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof VacHolidayRulesKQGZWizardViewBase
     */
    public engine: WizardViewEngine = new WizardViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof VacHolidayRulesKQGZWizardViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            wizardpanel: this.$refs.wizardpanel,
            keyPSDEField: 'vacholidayrules',
            majorPSDEField: 'vacholidayrulesname',
            isLoadDefault: true,
        });
    }


    /**
     * wizardpanel 部件 finish 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof VacHolidayRulesKQGZWizardViewBase
     */
    public wizardpanel_finish($event: any, $event2?: any) {
        this.engine.onCtrlEvent('wizardpanel', 'finish', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof VacHolidayRulesKQGZWizardViewBase
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
@import './vac-holiday-rules-kqgzwizard-view.less';
</style>