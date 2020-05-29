<template>
  <app-layout viewName="pcmzpmegltreeexpview" viewTitle="招聘名额管理树导航视图" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'detreeexpview': true, 'pcmzpmegltree-exp-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import PCMZPMEGLService from '@/service/pcmzpmegl/pcmzpmegl-service';

import TreeExpViewEngine from '@engine/view/tree-exp-view-engine';


/**
 * 招聘名额管理树导航视图基类
 *
 * @export
 * @class PCMZPMEGLTreeExpViewBase
 * @extends {TreeExpViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PCMZPMEGLTreeExpViewBase extends TreeExpViewBase {

    /**
     * 实体服务对象
     *
     * @type {PCMZPMEGLService}
     * @memberof PCMZPMEGLTreeExpViewBase
     */
    public appEntityService: PCMZPMEGLService = new PCMZPMEGLService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PCMZPMEGLTreeExpViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PCMZPMEGLTreeExpViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PCMZPMEGLTreeExpViewBase
	 */
	public viewtag: string = '1f920c8cc89727194baf86209f07b039';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PCMZPMEGLTreeExpViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PCMZPMEGLTreeExpViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PCMZPMEGLTreeExpViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PCMZPMEGLTreeExpViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmzpmegl.views.treeexpview.caption',
        srfTitle: 'entities.pcmzpmegl.views.treeexpview.title',
        srfSubTitle: 'entities.pcmzpmegl.views.treeexpview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PCMZPMEGLTreeExpViewBase
     */
    public containerModel: any = {
        view_treeexpbar: { name: 'treeexpbar', type: 'TREEEXPBAR' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PCMZPMEGLTreeExpViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PCMZPMEGLTreeExpViewBase
     */
    public engine: TreeExpViewEngine = new TreeExpViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PCMZPMEGLTreeExpViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            treeexpbar: this.$refs.treeexpbar,
            keyPSDEField: 'pcmzpmegl',
            majorPSDEField: 'pcmzpmeglname',
            isLoadDefault: true,
        });
    }


    /**
     * treeexpbar 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMZPMEGLTreeExpViewBase
     */
    public treeexpbar_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('treeexpbar', 'selectionchange', $event);
    }


    /**
     * treeexpbar 部件 activated 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMZPMEGLTreeExpViewBase
     */
    public treeexpbar_activated($event: any, $event2?: any) {
        this.engine.onCtrlEvent('treeexpbar', 'activated', $event);
    }


    /**
     * treeexpbar 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMZPMEGLTreeExpViewBase
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
     * @memberof PCMZPMEGLTreeExpView
     */
    public newdata(args: any[],fullargs?:any[], params?: any, $event?: any, xData?: any) {
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
     * @memberof PCMZPMEGLTreeExpView
     */
    public opendata(args: any[],fullargs?:any[],params?: any, $event?: any, xData?: any) {
    this.$Notice.warning({ title: '错误', desc: '未指定关系视图' });
    }




    /**
     * 销毁视图回调
     *
     * @memberof PCMZPMEGLTreeExpViewBase
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
     * @memberof PCMZPMEGLTreeExpView
     */
    public viewUID: string = 'pcm-pcmzpmegltree-exp-view';

}
</script>

<style lang='less'>
@import './pcmzpmegltree-exp-view.less';
</style>