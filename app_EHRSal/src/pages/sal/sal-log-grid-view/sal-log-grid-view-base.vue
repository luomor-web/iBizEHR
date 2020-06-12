<template>
  <app-layout viewName="salloggridview" viewTitle="薪酬调整日志表格视图" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'degridview': true, 'sal-log-grid-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
    :showBusyIndicator="true"
    :isOpenEdit="false"
    :gridRowActiveMode="gridRowActiveMode"
    @save="onSave"
    updateAction=""
    removeAction="Remove"
    loaddraftAction=""
    loadAction=""
    createAction=""
    fetchAction="FetchDefault"
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
import SalLogService from '@/service/sal-log/sal-log-service';

import GridViewEngine from '@engine/view/grid-view-engine';

import CodeListService from "@service/app/codelist-service";


/**
 * 薪酬调整日志表格视图基类
 *
 * @export
 * @class SalLogGridViewBase
 * @extends {GridViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class SalLogGridViewBase extends GridViewBase {

    /**
     * 实体服务对象
     *
     * @type {SalLogService}
     * @memberof SalLogGridViewBase
     */
    public appEntityService: SalLogService = new SalLogService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof SalLogGridViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof SalLogGridViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof SalLogGridViewBase
	 */
	public viewtag: string = '591ef016b72d181a6bd6fed984f235a7';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof SalLogGridViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof SalLogGridViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof SalLogGridViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof SalLogGridViewBase
     */
    public model: any = {
        srfCaption: 'entities.sallog.views.gridview.caption',
        srfTitle: 'entities.sallog.views.gridview.title',
        srfSubTitle: 'entities.sallog.views.gridview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof SalLogGridViewBase
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
     * @memberof SalLogGridViewBase
     */
    public viewState: Subject<ViewState> = new Subject();




    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof SalLogGridViewBase
     */
    public engine: GridViewEngine = new GridViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof SalLogGridViewBase
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
            keyPSDEField: 'sallog',
            majorPSDEField: 'sallogname',
            isLoadDefault: true,
        });
    }


    /**
     * grid 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SalLogGridViewBase
     */
    public grid_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'selectionchange', $event);
    }


    /**
     * grid 部件 beforeload 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SalLogGridViewBase
     */
    public grid_beforeload($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'beforeload', $event);
    }


    /**
     * grid 部件 rowdblclick 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SalLogGridViewBase
     */
    public grid_rowdblclick($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'rowdblclick', $event);
    }


    /**
     * grid 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SalLogGridViewBase
     */
    public grid_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'remove', $event);
    }


    /**
     * grid 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SalLogGridViewBase
     */
    public grid_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'load', $event);
    }


    /**
     * searchform 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SalLogGridViewBase
     */
    public searchform_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'save', $event);
    }


    /**
     * searchform 部件 search 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SalLogGridViewBase
     */
    public searchform_search($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'search', $event);
    }


    /**
     * searchform 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SalLogGridViewBase
     */
    public searchform_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'load', $event);
    }



    /**
     * 打开新建数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof SalLogGridView
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
     * @memberof SalLogGridView
     */
    public opendata(args: any[],fullargs?:any[],params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
    this.$Notice.warning({ title: '错误', desc: '未指定关系视图' });
    }




    /**
     * 销毁视图回调
     *
     * @memberof SalLogGridViewBase
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
     * @memberof SalLogGridViewBase
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
    * @memberof SalLogGridViewBase
    */
    @Prop() public formDruipart?: Subject<ViewState>;

    /**
     * 搜索值
     *
     * @type {string}
     * @memberof SalLogGridViewBase
     */
    public query: string = '';

    /**
     * 是否展开搜索表单
     *
     * @type {boolean}
     * @memberof SalLogGridViewBase
     */
    public isExpandSearchForm: boolean = false;

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof SalLogGridViewBase
     */
    public gridRowActiveMode: number | 0 | 1 | 2 = 2;

    /**
     * 快速搜索
     *
     * @param {*} $event
     * @memberof SalLogGridViewBase
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
     * @memberof SalLogGridViewBase
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
     * @memberof SalLogGridViewBase
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
@import './sal-log-grid-view.less';
</style>