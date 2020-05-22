<template>
  <app-layout viewName="vacleavemanagewfproxyresultview" viewTitle="请假管理" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'dewfproxyresultview': true, 'vacleavemanagewfproxy-result-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import VACLEAVEMANAGEService from '@/service/vacleavemanage/vacleavemanage-service';



/**
 * 请假管理基类
 *
 * @export
 * @class VACLEAVEMANAGEWFProxyResultViewBase
 * @extends {Vue}
 */
@Component({})
@VueLifeCycleProcessing
export default class VACLEAVEMANAGEWFProxyResultViewBase extends ViewBase {

    /**
     * 实体服务对象
     *
     * @type {VACLEAVEMANAGEService}
     * @memberof VACLEAVEMANAGEWFProxyResultViewBase
     */
    public appEntityService: VACLEAVEMANAGEService = new VACLEAVEMANAGEService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof VACLEAVEMANAGEWFProxyResultViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof VACLEAVEMANAGEWFProxyResultViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof VACLEAVEMANAGEWFProxyResultViewBase
	 */
	public viewtag: string = '50ad2b9dac52744dd9a8068dbde24da8';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof VACLEAVEMANAGEWFProxyResultViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof VACLEAVEMANAGEWFProxyResultViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof VACLEAVEMANAGEWFProxyResultViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof VACLEAVEMANAGEWFProxyResultViewBase
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
     * @memberof VACLEAVEMANAGEWFProxyResultViewBase
     */
    public containerModel: any = {
        wflinks: [],
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof VACLEAVEMANAGEWFProxyResultViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof VACLEAVEMANAGEWFProxyResultViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof VACLEAVEMANAGEWFProxyResultViewBase
     */
    public destroyed(){
    }

}
</script>

<style lang='less'>
@import './vacleavemanagewfproxy-result-view.less';
</style>