<template>
  <app-layout viewName="pimportalview" viewTitle="Pim门户首页" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'appportalview': true, 'pim-portal-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
                :isEnableCustomized = "true"
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
 * Pim门户首页基类
 *
 * @export
 * @class PimPortalViewBase
 * @extends {PortalViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PimPortalViewBase extends PortalViewBase {

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PimPortalViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PimPortalViewBase
	 */
	public viewtag: string = '8be166f8e5b8aec59faf7bdd19555a32';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PimPortalViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PimPortalViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PimPortalViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PimPortalViewBase
     */
    public model: any = {
        srfCaption: 'app.views.pimportalview.caption',
        srfTitle: 'app.views.pimportalview.title',
        srfSubTitle: 'app.views.pimportalview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PimPortalViewBase
     */
    public containerModel: any = {
        view_dashboard: { name: 'dashboard', type: 'DASHBOARD' },
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof PimPortalViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PimPortalViewBase
     */
    public engineInit(): void {
    }





    /**
     * 应用起始页面
     *
     * @type {boolean}
     * @memberof PimPortalView
     */
    public isDefaultPage: boolean = false;
    
}
</script>

<style lang='less'>
@import './pim-portal-view.less';
</style>