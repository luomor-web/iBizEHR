<template>
  <app-layout viewName="pcmworkresumegzll_wsswbjgridview" viewTitle="工作履历表格视图" :className="{ 'view-container': true, 'default-mode-view': true, 'degridview': true, 'pcmworkresumegzll-wsswbjgrid-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="headerRight">
      <div class="view-header-right">
        <app-header-menus :toolbarModel="toolBarModels" @menu-click="toolbar_click($event)" mode="view" :openMode="openMode"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
        <view_grid 
    :viewState="viewState"  
    :viewparams="viewparams" 
    :context="context" 
    :isSingleSelect="isSingleSelect"
    :showBusyIndicator="true"
    :isOpenEdit="false"
    :gridRowActiveMode="gridRowActiveMode"
    @save="onSave"
    updateAction="Update"
    removeAction="Remove"
    loaddraftAction="GetDraft"
    loadAction="Get"
    createAction="Create"
    fetchAction="FetchDefault"
    :opendata="opendata"
    name="grid"  
    ref='grid' 
    @selectionchange="grid_selectionchange($event)"  
    @beforeload="grid_beforeload($event)"  
    @rowdblclick="grid_rowdblclick($event)"  
    @remove="grid_remove($event)"  
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
import { VueLifeCycleProcessing, GridViewBase } from '@/crm-core';
import PcmWorkResumeService from '@/service/pcm-work-resume/pcm-work-resume-service';

import GridViewEngine from '@engine/view/grid-view-engine';

import CodeListService from "@service/app/codelist-service";


/**
 * 工作履历表格视图基类
 *
 * @export
 * @class PCMWORKRESUMEGZLL_WSSWBJGridViewBase
 * @extends {GridViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PCMWORKRESUMEGZLL_WSSWBJGridViewBase extends GridViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmWorkResumeService}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public appEntityService: PcmWorkResumeService = new PcmWorkResumeService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
	 */
	public viewtag: string = '01a06bd6730d3199229fd1b9f8aca1a8';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmworkresume.views.gzll_wsswbjgridview.caption',
        srfTitle: 'entities.pcmworkresume.views.gzll_wsswbjgridview.title',
        srfSubTitle: 'entities.pcmworkresume.views.gzll_wsswbjgridview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public containerModel: any = {
        view_toolbar: { name: 'toolbar', type: 'TOOLBAR' },
        view_grid: { name: 'grid', type: 'GRID' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridView
     */
    public toolBarModels: any = {
    };





    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public engine: GridViewEngine = new GridViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            opendata: (args: any[], params?: any, $event?: any, xData?: any) => {
                this.opendata(args, params, $event, xData);
            },
            grid: this.$refs.grid,
            keyPSDEField: 'pcmworkresume',
            majorPSDEField: 'pcmworkresumename',
            isLoadDefault: true,
        });
    }


    /**
     * grid 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public grid_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'selectionchange', $event);
    }


    /**
     * grid 部件 beforeload 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public grid_beforeload($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'beforeload', $event);
    }


    /**
     * grid 部件 rowdblclick 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public grid_rowdblclick($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'rowdblclick', $event);
    }


    /**
     * grid 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public grid_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'remove', $event);
    }


    /**
     * grid 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public grid_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'load', $event);
    }



    /**
     * 打开编辑数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridView
     */
    public opendata(args: any[],fullargs?:any[],params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
        const data: any = {};
        let tempContext = JSON.parse(JSON.stringify(this.context));
        if(args.length >0){
            Object.assign(tempContext,args[0]);
        }
        let deResParameters: any[] = [];
        if(tempContext.pcmprofile && true){
            deResParameters = [
            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
            ]
        }
        const parameters: any[] = [
            { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
            { pathName: 'editview', parameterName: 'editview' },
        ];
        const _this: any = this;
        const openIndexViewTab = (data: any) => {
            const routePath = this.$viewTool.buildUpRoutePath(this.$route, tempContext, deResParameters, parameters, args, data);
            this.$router.push(routePath);
        }
        openIndexViewTab(data);
    }




    /**
     * 销毁视图回调
     *
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
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
     * 是否单选
     *
     * @type {boolean}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public isSingleSelect: boolean = false;


    /**
     * Vue声明周期
     *
     * @memberof ViewBase
     */
    public created() {
        super.created();
        if(this.formDruipart){
            this.formDruipart.subscribe((res:any) =>{
                if(Object.is(res.action,'save')){
                    this.viewState.next({ tag:'grid', action: 'save', data: this.viewparams });
                }
                if(Object.is(res.action,'load')){
                    const _this: any = this;
                    _this.engine.load(res.data,true);
                }
            });
        }
    }

    /**
    * 界面关系通讯对象
    *
    * @type {Subject<ViewState>}
    * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
    */
    @Prop() public formDruipart?: Subject<ViewState>;

    /**
     * 搜索值
     *
     * @type {string}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public query: string = '';

    /**
     * 是否展开搜索表单
     *
     * @type {boolean}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public isExpandSearchForm: boolean = false;

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public gridRowActiveMode: number | 0 | 1 | 2 = 0;

    /**
     * 快速搜索
     *
     * @param {*} $event
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    public onSearch($event: any): void {
        const grid: any = this.$refs.grid;
        if (grid) {
            grid.load(this.context);
        }
    }

    /**
     * grid 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ENTITYTEST1Usr2GridViewBase
     */
    public onSave($event: any) {
        this.$emit('drdatasaved', $event);
    }

    /**
     * 刷新数据
     *
     * @readonly
     * @type {(number | null)}
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    get refreshdata(): number | null {
        return this.$store.getters['viewaction/getRefreshData'](this.viewtag);
    }

    /**
     * 监控数据变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @returns
     * @memberof PCMWORKRESUMEGZLL_WSSWBJGridViewBase
     */
    @Watch('refreshdata')
    onRefreshData(newVal: any, oldVal: any) {
        if (newVal === null || newVal === undefined) {
            return;
        }
        if (newVal === 0) {
            return;
        }
        const grid: any = this.$refs.grid;
        if (grid) {
            grid.load({});
        }
    }

}
</script>

<style lang='less'>
@import './pcmworkresumegzll-wsswbjgrid-view.less';
</style>