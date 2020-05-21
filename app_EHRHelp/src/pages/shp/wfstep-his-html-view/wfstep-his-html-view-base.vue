<template>
  <app-layout viewName="wfstephishtmlview" viewTitle="工作流步骤HTML视图" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'dehtmlview': true, 'wfstep-his-html-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
        
      </div>
    </template>
  </app-layout>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing } from '@/crm-core';
import WFStepService from '@/service/wfstep/wfstep-service';

import HtmlViewEngine from '@engine/view/html-view-engine';


/**
 * 工作流步骤HTML视图基类
 *
 * @export
 * @class WFStepHisHtmlViewBase
 * @extends {Vue}
 */
@Component({})
@VueLifeCycleProcessing
export default class WFStepHisHtmlViewBase extends ViewBase {

    /**
     * 实体服务对象
     *
     * @type {WFStepService}
     * @memberof WFStepHisHtmlViewBase
     */
    public appEntityService: WFStepService = new WFStepService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof WFStepHisHtmlViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof WFStepHisHtmlViewBase
	 */
	public viewtag: string = 'b89898b8f8c50e6e9e4a934fc9f06d3f';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof WFStepHisHtmlViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof WFStepHisHtmlViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof WFStepHisHtmlViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof WFStepHisHtmlViewBase
     */
    public model: any = {
        srfCaption: 'entities.wfstep.views.hishtmlview.caption',
        srfTitle: 'entities.wfstep.views.hishtmlview.title',
        srfSubTitle: 'entities.wfstep.views.hishtmlview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof WFStepHisHtmlViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof WFStepHisHtmlViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof WFStepHisHtmlViewBase
     */
    public engine: HtmlViewEngine = new HtmlViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof WFStepHisHtmlViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            keyPSDEField: 'wfstep',
            majorPSDEField: 'wfstepname',
            isLoadDefault: true,
        });
    }





    /**
     * 销毁视图回调
     *
     * @memberof WFStepHisHtmlViewBase
     */
    public destroyed(){
    }

}
</script>

<style lang='less'>
@import './wfstep-his-html-view.less';
</style>