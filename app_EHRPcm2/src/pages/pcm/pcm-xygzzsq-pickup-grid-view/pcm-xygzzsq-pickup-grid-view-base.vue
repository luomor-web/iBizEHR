<template>
  <app-layout viewName="pcmxygzzsqpickupgridview" viewTitle="试用期员工转正申请选择表格视图" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'depickupgridview': true, 'pcm-xygzzsq-pickup-grid-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
                    <view_searchform 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :showBusyIndicator="true"
                v-show="isExpandSearchForm"
                loaddraftAction="FilterGetDraft"
                loadAction="FilterGet"
            
                name="searchform"  
                ref='searchform' 
                @save="searchform_save($event)"  
                @search="searchform_search($event)"  
                @load="searchform_load($event)"  
                @closeview="closeView($event)">
            </view_searchform>
            <view_grid 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :isSingleSelect="isSingleSelect"
                :selectedData="selectedData"
                :showBusyIndicator="true"
                updateAction=""
                removeAction="Remove"
                loaddraftAction=""
                loadAction=""
                createAction=""
                fetchAction="FetchDefault"
                name="grid"  
                ref='grid' 
                @selectionchange="grid_selectionchange($event)"  
                @beforeload="grid_beforeload($event)"  
                @rowdblclick="grid_rowdblclick($event)"  
                @load="grid_load($event)"  
                @closeview="closeView($event)">
            </view_grid>

      </div>
    </template>
  </app-layout>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, PickupViewBase } from '@/crm-core';
import PcmXygzzsqService from '@/service/pcm-xygzzsq/pcm-xygzzsq-service';

import PickupGridViewEngine from '@engine/view/pickup-grid-view-engine';


/**
 * 试用期员工转正申请选择表格视图基类
 *
 * @export
 * @class PcmXygzzsqPickupGridViewBase
 * @extends {PickupViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmXygzzsqPickupGridViewBase extends PickupViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmXygzzsqService}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public appEntityService: PcmXygzzsqService = new PcmXygzzsqService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmXygzzsqPickupGridViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmXygzzsqPickupGridViewBase
	 */
	public viewtag: string = '52dfa733a583ee824acb9bc4eda06164';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmXygzzsqPickupGridViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmXygzzsqPickupGridViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmxygzzsq.views.pickupgridview.caption',
        srfTitle: 'entities.pcmxygzzsq.views.pickupgridview.title',
        srfSubTitle: 'entities.pcmxygzzsq.views.pickupgridview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public containerModel: any = {
        view_grid: { name: 'grid', type: 'GRID' },
        view_searchform: { name: 'searchform', type: 'SEARCHFORM' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public engine: PickupGridViewEngine = new PickupGridViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            grid: this.$refs.grid,
            searchform: this.$refs.searchform,
            keyPSDEField: 'pcmxygzzsq',
            majorPSDEField: 'pcmxygzzsqname',
            isLoadDefault: true,
        });
    }


    /**
     * grid 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public grid_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'selectionchange', $event);
    }


    /**
     * grid 部件 beforeload 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public grid_beforeload($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'beforeload', $event);
    }


    /**
     * grid 部件 rowdblclick 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public grid_rowdblclick($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'rowdblclick', $event);
    }


    /**
     * grid 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public grid_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'load', $event);
    }


    /**
     * searchform 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public searchform_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'save', $event);
    }


    /**
     * searchform 部件 search 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public searchform_search($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'search', $event);
    }


    /**
     * searchform 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public searchform_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'load', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof PcmXygzzsqPickupGridViewBase
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
    /**
     * 选中数据字符串
     *
     * @type {string}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    @Prop() public selectedData?: string;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    @Prop() public isSingleSelect?: boolean;

    /**
     * 搜索值
     *
     * @type {string}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public query: string = '';

    /**
     * 是否展开搜索表单
     *
     * @type {boolean}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public isExpandSearchForm: boolean = true;

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public gridRowActiveMode: number | 0 | 1 | 2 = 2;

    /**
     * 快速搜索
     *
     * @param {*} $event
     * @memberof PcmXygzzsqPickupGridViewBase
     */
    public onSearch($event: any): void {
        const refs: any = this.$refs;
        if (refs.grid) {
            refs.grid.load({});
        }
    }

}
</script>

<style lang='less'>
@import './pcm-xygzzsq-pickup-grid-view.less';
</style>