<template>
  <app-layout viewName="ehrportalview" viewTitle="Ehr门户首页" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'appportalview': true, 'ehr-portal-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
                    <view_dashboard 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="JSON.parse(JSON.stringify(context))" 
                :isEnableCustomized = "false"
                name="dashboard"  
                ref='dashboard' 
                @closeview="closeView($event)">
            </view_dashboard>

      </div>
    </template>
  </app-layout>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, PortalViewBase } from '@/crm-core';



/**
 * Ehr门户首页基类
 *
 * @export
 * @class EhrPortalViewBase
 * @extends {PortalViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class EhrPortalViewBase extends PortalViewBase {


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof EhrPortalViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof EhrPortalViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof EhrPortalViewBase
	 */
	public viewtag: string = '7C5E0D47-0C7A-43F4-B137-CB4EC96FE1D6';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof EhrPortalViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof EhrPortalViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof EhrPortalViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof EhrPortalViewBase
     */
    public model: any = {
        srfCaption: 'app.views.ehrportalview.caption',
        srfTitle: 'app.views.ehrportalview.title',
        srfSubTitle: 'app.views.ehrportalview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof EhrPortalViewBase
     */
    public containerModel: any = {
        view_dashboard: { name: 'dashboard', type: 'DASHBOARD' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof EhrPortalViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof EhrPortalViewBase
     */
    public engineInit(): void {
    }





    /**
     * 应用起始页面
     *
     * @type {boolean}
     * @memberof EhrPortalView
     */
    public isDefaultPage: boolean = false;
    
}
</script>

<style lang='less'>
@import './ehr-portal-view.less';
</style>