<template>
  <app-layout viewName="attendancemreportkqybtreeexpview" viewTitle="考勤月报树导航视图" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'detreeexpview': true, 'att-endance-mreport-kqybtree-exp-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
                    <view_treeexpbar 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :viewUID="viewUID"
                name="treeexpbar"  
                ref='treeexpbar' 
                @selectionchange="treeexpbar_selectionchange($event)"  
                @activated="treeexpbar_activated($event)"  
                @load="treeexpbar_load($event)"  
                @closeview="closeView($event)">
            </view_treeexpbar>

      </div>
    </template>
  </app-layout>

</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, TreeExpViewBase } from '@/crm-core';
import AttEndanceMreportService from '@/service/att-endance-mreport/att-endance-mreport-service';

import TreeExpViewEngine from '@engine/view/tree-exp-view-engine';


/**
 * 考勤月报树导航视图基类
 *
 * @export
 * @class AttEndanceMreportKQYBTreeExpViewBase
 * @extends {TreeExpViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class AttEndanceMreportKQYBTreeExpViewBase extends TreeExpViewBase {

    /**
     * 实体服务对象
     *
     * @type {AttEndanceMreportService}
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    public appEntityService: AttEndanceMreportService = new AttEndanceMreportService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof AttEndanceMreportKQYBTreeExpViewBase
	 */
	public viewtag: string = 'b3d5e8674764efcf3f73cf0b6292d898';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof AttEndanceMreportKQYBTreeExpViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof AttEndanceMreportKQYBTreeExpViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    public model: any = {
        srfCaption: 'entities.attendancemreport.views.kqybtreeexpview.caption',
        srfTitle: 'entities.attendancemreport.views.kqybtreeexpview.title',
        srfSubTitle: 'entities.attendancemreport.views.kqybtreeexpview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    public containerModel: any = {
        view_treeexpbar: { name: 'treeexpbar', type: 'TREEEXPBAR' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    public engine: TreeExpViewEngine = new TreeExpViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            treeexpbar: this.$refs.treeexpbar,
            keyPSDEField: 'attendancemreport',
            majorPSDEField: 'attendancemreportname',
            isLoadDefault: true,
        });
    }


    /**
     * treeexpbar 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    public treeexpbar_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('treeexpbar', 'selectionchange', $event);
    }


    /**
     * treeexpbar 部件 activated 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    public treeexpbar_activated($event: any, $event2?: any) {
        this.engine.onCtrlEvent('treeexpbar', 'activated', $event);
    }


    /**
     * treeexpbar 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    public treeexpbar_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('treeexpbar', 'load', $event);
    }



    /**
     * 打开新建数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof AttEndanceMreportKQYBTreeExpView
     */
    public newdata(args: any[],fullargs?:any[], params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
    this.$Notice.warning({ title: '错误', desc: '未指定关系视图' });
    }


    /**
     * 打开编辑数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof AttEndanceMreportKQYBTreeExpView
     */
    public opendata(args: any[],fullargs?:any[],params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
    this.$Notice.warning({ title: '错误', desc: '未指定关系视图' });
    }




    /**
     * 销毁视图回调
     *
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
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
     * 视图唯一标识
     *
     * @type {string}
     * @memberof AttEndanceMreportKQYBTreeExpViewBase
     */
    public viewUID: string = 'att-att-endance-mreport-kqybtree-exp-view';

}
</script>

<style lang='less'>
@import './att-endance-mreport-kqybtree-exp-view.less';
</style>