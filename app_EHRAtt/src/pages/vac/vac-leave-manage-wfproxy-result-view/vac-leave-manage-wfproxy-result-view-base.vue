<template>
  <app-layout viewName="vacleavemanagewfproxyresultview" viewTitle="请假管理" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'dewfproxyresultview': true, 'vac-leave-manage-wfproxy-result-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import VacLeaveManageService from '@/service/vac-leave-manage/vac-leave-manage-service';



/**
 * 请假管理基类
 *
 * @export
 * @class VacLeaveManageWFProxyResultViewBase
 * @extends {Vue}
 */
@Component({})
@VueLifeCycleProcessing
export default class VacLeaveManageWFProxyResultViewBase extends ViewBase {

    /**
     * 实体服务对象
     *
     * @type {VacLeaveManageService}
     * @memberof VacLeaveManageWFProxyResultViewBase
     */
    public appEntityService: VacLeaveManageService = new VacLeaveManageService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof VacLeaveManageWFProxyResultViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof VacLeaveManageWFProxyResultViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof VacLeaveManageWFProxyResultViewBase
	 */
	public viewtag: string = '0361b45e3b9378abb8d90087987f746b';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof VacLeaveManageWFProxyResultViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof VacLeaveManageWFProxyResultViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof VacLeaveManageWFProxyResultViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof VacLeaveManageWFProxyResultViewBase
     */
    public model: any = {
        srfCaption: 'entities.vacleavemanage.views.wfproxyresultview.caption',
        srfTitle: 'entities.vacleavemanage.views.wfproxyresultview.title',
        srfSubTitle: 'entities.vacleavemanage.views.wfproxyresultview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof VacLeaveManageWFProxyResultViewBase
     */
    public containerModel: any = {
        wflinks: [],
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof VacLeaveManageWFProxyResultViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof VacLeaveManageWFProxyResultViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof VacLeaveManageWFProxyResultViewBase
     */
    public destroyed(){
    }

}
</script>

<style lang='less'>
@import './vac-leave-manage-wfproxy-result-view.less';
</style>