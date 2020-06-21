<template>
  <app-layout viewName="pcmddsqdmxjdsqwshgridview" viewTitle="借调查看" :className="{ 'view-container': true, 'default-mode-view': true, 'degridview': true, 'pcm-ddsqdmx-jdsqwshgrid-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="headerRight">
      <div class="view-header-right">
        <app-header-menus :toolbarModel="toolBarModels" @menu-click="toolbar_click($event)" mode="view" :openMode="openMode" :isEnableQuickSearch="true" searchPlaceholder="调动申请单明细名称，员工姓名，员工编号" v-model="query" @search="onSearch($event)"/>
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
    :showBusyIndicator="true"
    :isOpenEdit="false"
    :gridRowActiveMode="gridRowActiveMode"
    @save="onSave"
    updateAction=""
    removeAction="Remove"
    loaddraftAction=""
    loadAction=""
    createAction=""
    fetchAction="FetchJDSQMX"
    :newdata="newdata"
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
import PcmDdsqdmxService from '@/service/pcm-ddsqdmx/pcm-ddsqdmx-service';

import GridViewEngine from '@engine/view/grid-view-engine';

import PcmDdsqdmxUIService from '@/uiservice/pcm-ddsqdmx/pcm-ddsqdmx-ui-service';
import CodeListService from "@service/app/codelist-service";


/**
 * 借调查看基类
 *
 * @export
 * @class PcmDdsqdmxJDSQWSHGridViewBase
 * @extends {GridViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmDdsqdmxJDSQWSHGridViewBase extends GridViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmDdsqdmxService}
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public appEntityService: PcmDdsqdmxService = new PcmDdsqdmxService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmDdsqdmxJDSQWSHGridViewBase
	 */
	public viewtag: string = 'abdcfe13acda7c25247fdcdd483419a4';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmDdsqdmxJDSQWSHGridViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmDdsqdmxJDSQWSHGridViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmddsqdmx.views.jdsqwshgridview.caption',
        srfTitle: 'entities.pcmddsqdmx.views.jdsqwshgridview.title',
        srfSubTitle: 'entities.pcmddsqdmx.views.jdsqwshgridview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public containerModel: any = {
        view_toolbar: { name: 'toolbar', type: 'TOOLBAR' },
        view_grid: { name: 'grid', type: 'GRID' },
        view_searchform: { name: 'searchform', type: 'SEARCHFORM' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof PcmDdsqdmxJDSQWSHGridView
     */
    public toolBarModels: any = {
        deuiaction1_sqtg: { name: 'deuiaction1_sqtg', caption: '通过','isShowCaption':true,'isShowIcon':true, tooltip: '通过', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'SQTG', target: 'SINGLEKEY' }, class: '' },

        deuiaction1_sqbtg: { name: 'deuiaction1_sqbtg', caption: '不通过','isShowCaption':true,'isShowIcon':true, tooltip: '不通过', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'SQBTG', target: 'SINGLEKEY' }, class: '' },

        deuiaction6: { name: 'deuiaction6', caption: '导出','isShowCaption':true,'isShowIcon':true, tooltip: '导出', iconcls: 'fa fa-file-excel-o', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'ExportExcel', target: '' }, MaxRowCount: 5000, class: '' },

        deuiaction2: { name: 'deuiaction2', caption: '过滤','isShowCaption':true,'isShowIcon':true, tooltip: '过滤', iconcls: 'fa fa-filter', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: 'SRFUR__JGLYKQLX', uiaction: { tag: 'ToggleFilter', target: '' }, class: '' },

    };





    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public engine: GridViewEngine = new GridViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            opendata: (args: any[], params?: any, $event?: any, xData?: any) => {
                this.opendata(args, params, $event, xData);
            },
            newdata: (args: any[], params?: any, $event?: any, xData?: any) => {
                this.newdata(args, params, $event, xData);
            },
            grid: this.$refs.grid,
            searchform: this.$refs.searchform,
            keyPSDEField: 'pcmddsqdmx',
            majorPSDEField: 'pcmddsqdmxname',
            isLoadDefault: true,
        });
    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'deuiaction1_sqtg')) {
            this.toolbar_deuiaction1_sqtg_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'deuiaction1_sqbtg')) {
            this.toolbar_deuiaction1_sqbtg_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'deuiaction3')) {
            this.toolbar_deuiaction3_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'deuiaction6')) {
            this.toolbar_deuiaction6_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'deuiaction2')) {
            this.toolbar_deuiaction2_click(null, '', $event2);
        }
    }


    /**
     * grid 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public grid_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'selectionchange', $event);
    }


    /**
     * grid 部件 beforeload 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public grid_beforeload($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'beforeload', $event);
    }


    /**
     * grid 部件 rowdblclick 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public grid_rowdblclick($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'rowdblclick', $event);
    }


    /**
     * grid 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public grid_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'remove', $event);
    }


    /**
     * grid 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public grid_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'load', $event);
    }


    /**
     * searchform 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public searchform_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'save', $event);
    }


    /**
     * searchform 部件 search 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public searchform_search($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'search', $event);
    }


    /**
     * searchform 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public searchform_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'load', $event);
    }



    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_deuiaction1_sqtg_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        const curUIService:PcmDdsqdmxUIService  = new PcmDdsqdmxUIService();
        curUIService.PcmDdsqdmx_SQTG(datas,contextJO, paramJO,  $event, xData,this,"PcmDdsqdmx");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_deuiaction1_sqbtg_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        const curUIService:PcmDdsqdmxUIService  = new PcmDdsqdmxUIService();
        curUIService.PcmDdsqdmx_SQBTG(datas,contextJO, paramJO,  $event, xData,this,"PcmDdsqdmx");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_deuiaction3_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.OpenRowEdit(datas, contextJO,paramJO,  $event, xData,this,"PcmDdsqdmx");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_deuiaction6_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.ExportExcel(datas, contextJO,paramJO,  $event, xData,this,"PcmDdsqdmx");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_deuiaction2_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.ToggleFilter(datas, contextJO,paramJO,  $event, xData,this,"PcmDdsqdmx");
    }

    /**
     * 打开新建数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof PcmDdsqdmxJDSQWSHGridView
     */
    public newdata(args: any[],fullargs?:any[], params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
        let batchAddPSAppViews:Array<any>=[];
        batchAddPSAppViews=[
            {view:{viewname:'pim-distirbution-kddmpickup-view',height: 0,width: 0,title: '可调动的分配'},
            res:['PimDistirbution'],
            'resAppKey':'pimdistirbutionid'}
        ];
        if(batchAddPSAppViews.length == 0 || !this.context.srfparentdename){
            this.$Notice.warning({ title: '错误', desc: '批量添加需添加N:N关系' });
            return;
        }
        let openViewModel:any = batchAddPSAppViews.find((item:any) =>{
            return (item.res && (item.res[0] !== this.context.srfparentdename));
        })
        let otherViewModel:any = batchAddPSAppViews.find((item:any) =>{
            return (item.res && (item.res[0] == this.context.srfparentdename));
        })
        let container: Subject<any> = this.$appmodal.openModal(openViewModel.view, JSON.parse(JSON.stringify(this.context)), args[0]);
        container.subscribe((result: any) => {
            if (!result || !Object.is(result.ret, 'OK')) {
                return;
            }
            if(result.datas && result.datas.length == 0){
                return;
            }
            let requestParam:Array<any> = [];
            result.datas.forEach((record:any) => {
                let tempParam:any = {};
                tempParam[otherViewModel.resAppKey] = this.context['srfparentkey'];
                tempParam[openViewModel.resAppKey] = record.srfkey;
                requestParam.push(tempParam);
            });
            this.appEntityService.createBatch(JSON.parse(JSON.stringify(this.context)),requestParam,true).then((response:any) =>{
                if (!response || response.status !== 200) {
                    this.$Notice.error({ title: '错误', desc: '批处理操作失败' });
                    return;
                }
                if (!xData || !(xData.refresh instanceof Function)) {
                    return;
                }
                xData.refresh(result.datas);
            });
        });
    }


    /**
     * 打开编辑数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof PcmDdsqdmxJDSQWSHGridView
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
        if(tempContext.pcmddsqd && true){
            deResParameters = [
            { pathName: 'pcmddsqds', parameterName: 'pcmddsqd' },
            ]
        }
        const parameters: any[] = [
            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
            { pathName: 'sqjdsheditview', parameterName: 'sqjdsheditview' },
        ];
        const _this: any = this;
        const openIndexViewTab = (data: any) => {
            const routePath = this.$viewTool.buildUpRoutePath(this.$route, tempContext, deResParameters, parameters, args, data);
            this.$router.push(routePath);
        }
        openIndexViewTab(data);
    }


    /**
     * 开启行编辑
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    protected OpenRowEdit(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        
    }
    /**
     * 导出
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public ExportExcel(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (!xData || !(xData.exportExcel instanceof Function) || !$event) {
            return ;
        }
        xData.exportExcel($event.exportparms);
    }
    /**
     * 过滤
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public ToggleFilter(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (_this.hasOwnProperty('isExpandSearchForm')) {
            _this.isExpandSearchForm = !_this.isExpandSearchForm;
        }
    }


    /**
     * 销毁视图回调
     *
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
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
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
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
    * @memberof PcmDdsqdmxJDSQWSHGridViewBase
    */
    @Prop() public formDruipart?: Subject<ViewState>;

    /**
     * 搜索值
     *
     * @type {string}
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public query: string = '';

    /**
     * 是否展开搜索表单
     *
     * @type {boolean}
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public isExpandSearchForm: boolean = false;

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
     */
    public gridRowActiveMode: number | 0 | 1 | 2 = 2;

    /**
     * 快速搜索
     *
     * @param {*} $event
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
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
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
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
     * @memberof PcmDdsqdmxJDSQWSHGridViewBase
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
@import './pcm-ddsqdmx-jdsqwshgrid-view.less';
</style>