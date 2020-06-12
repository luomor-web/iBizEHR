<template>
  <app-layout viewName="pcmpracticeexperiencesxjy_wsswbjgridview" viewTitle="实习信息" :className="{ 'view-container': true, 'default-mode-view': true, 'degridview': true, 'pcmpracticeexperiencesxjy-wsswbjgrid-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import PcmPracticeExperienceService from '@/service/pcm-practice-experience/pcm-practice-experience-service';

import GridViewEngine from '@engine/view/grid-view-engine';

import CodeListService from "@service/app/codelist-service";


/**
 * 实习信息基类
 *
 * @export
 * @class PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
 * @extends {GridViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase extends GridViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmPracticeExperienceService}
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public appEntityService: PcmPracticeExperienceService = new PcmPracticeExperienceService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
	 */
	public viewtag: string = 'c8ed6bc3b1fb98097433f84d7b885917';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmpracticeexperience.views.sxjy_wsswbjgridview.caption',
        srfTitle: 'entities.pcmpracticeexperience.views.sxjy_wsswbjgridview.title',
        srfSubTitle: 'entities.pcmpracticeexperience.views.sxjy_wsswbjgridview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
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
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridView
     */
    public toolBarModels: any = {
    };





    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public engine: GridViewEngine = new GridViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            opendata: (args: any[], params?: any, $event?: any, xData?: any) => {
                this.opendata(args, params, $event, xData);
            },
            grid: this.$refs.grid,
            keyPSDEField: 'pcmpracticeexperience',
            majorPSDEField: 'pcmpracticeexperiencename',
            isLoadDefault: true,
        });
    }


    /**
     * grid 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public grid_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'selectionchange', $event);
    }


    /**
     * grid 部件 beforeload 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public grid_beforeload($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'beforeload', $event);
    }


    /**
     * grid 部件 rowdblclick 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public grid_rowdblclick($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'rowdblclick', $event);
    }


    /**
     * grid 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public grid_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'remove', $event);
    }


    /**
     * grid 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
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
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridView
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
            { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
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
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
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
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
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
    * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
    */
    @Prop() public formDruipart?: Subject<ViewState>;

    /**
     * 搜索值
     *
     * @type {string}
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public query: string = '';

    /**
     * 是否展开搜索表单
     *
     * @type {boolean}
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public isExpandSearchForm: boolean = false;

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
     */
    public gridRowActiveMode: number | 0 | 1 | 2 = 0;

    /**
     * 快速搜索
     *
     * @param {*} $event
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
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
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
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
     * @memberof PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase
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
@import './pcmpracticeexperiencesxjy-wsswbjgrid-view.less';
</style>