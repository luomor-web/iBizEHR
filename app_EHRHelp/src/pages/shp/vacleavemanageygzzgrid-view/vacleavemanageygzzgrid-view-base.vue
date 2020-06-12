<template>
  <app-layout viewName="vacleavemanageygzzgridview" viewTitle="休假申请" :className="{ 'view-container': true, 'default-mode-view': true, 'degridview': true, 'vacleavemanageygzzgrid-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="headerRight">
      <div class="view-header-right">
        <app-header-menus :toolbarModel="toolBarModels" @menu-click="toolbar_click($event)" mode="view" :openMode="openMode" :isEnableQuickSearch="true" searchPlaceholder="请假人员" v-model="query" @search="onSearch($event)"/>
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
    fetchAction="FetchGR"
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
import VacLeaveManageService from '@/service/vac-leave-manage/vac-leave-manage-service';

import GridViewEngine from '@engine/view/grid-view-engine';

import VacLeaveManageUIService from '@/uiservice/vac-leave-manage/vac-leave-manage-ui-service';
import CodeListService from "@service/app/codelist-service";


/**
 * 休假申请基类
 *
 * @export
 * @class VACLEAVEMANAGEYGZZGridViewBase
 * @extends {GridViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class VACLEAVEMANAGEYGZZGridViewBase extends GridViewBase {

    /**
     * 实体服务对象
     *
     * @type {VacLeaveManageService}
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public appEntityService: VacLeaveManageService = new VacLeaveManageService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof VACLEAVEMANAGEYGZZGridViewBase
	 */
	public viewtag: string = '5bfc1e915d05e3e6fd7dc0694aa9d26c';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof VACLEAVEMANAGEYGZZGridViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof VACLEAVEMANAGEYGZZGridViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public model: any = {
        srfCaption: 'entities.vacleavemanage.views.ygzzgridview.caption',
        srfTitle: 'entities.vacleavemanage.views.ygzzgridview.title',
        srfSubTitle: 'entities.vacleavemanage.views.ygzzgridview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
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
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof VACLEAVEMANAGEYGZZGridView
     */
    public toolBarModels: any = {
        tbitem1_xjqj: { name: 'tbitem1_xjqj', caption: '新建','isShowCaption':true,'isShowIcon':true, tooltip: '新建', iconcls: 'fa fa-file-text-o', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'XJQJ', target: 'NONE' }, class: '' },

        tbitem1_kscqj: { name: 'tbitem1_kscqj', caption: '删除','isShowCaption':true,'isShowIcon':true, tooltip: '删除', iconcls: 'fa fa-remove', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: 'KSCQJ', uiaction: { tag: 'KSCQJ', target: 'SINGLEKEY' }, class: '' },

        tbitem13: { name: 'tbitem13', caption: '导出','isShowCaption':true,'isShowIcon':true, tooltip: '导出', iconcls: 'fa fa-file-excel-o', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'ExportExcel', target: '' }, MaxRowCount: 5000, class: '' },

        tbitem18: { name: 'tbitem18', caption: '帮助','isShowCaption':true,'isShowIcon':true, tooltip: '帮助', iconcls: 'fa fa-question', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'Help', target: '' }, class: '' },

    };





    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public engine: GridViewEngine = new GridViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
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
            keyPSDEField: 'vacleavemanage',
            majorPSDEField: 'pimpersonname',
            isLoadDefault: true,
        });
    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'tbitem1_xjqj')) {
            this.toolbar_tbitem1_xjqj_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem1_kscqj')) {
            this.toolbar_tbitem1_kscqj_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'deuiaction1')) {
            this.toolbar_deuiaction1_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem13')) {
            this.toolbar_tbitem13_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem18')) {
            this.toolbar_tbitem18_click(null, '', $event2);
        }
    }


    /**
     * grid 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public grid_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'selectionchange', $event);
    }


    /**
     * grid 部件 beforeload 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public grid_beforeload($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'beforeload', $event);
    }


    /**
     * grid 部件 rowdblclick 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public grid_rowdblclick($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'rowdblclick', $event);
    }


    /**
     * grid 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public grid_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'remove', $event);
    }


    /**
     * grid 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public grid_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'load', $event);
    }


    /**
     * searchform 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public searchform_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'save', $event);
    }


    /**
     * searchform 部件 search 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public searchform_search($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'search', $event);
    }


    /**
     * searchform 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
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
    public toolbar_tbitem1_xjqj_click(params: any = {}, tag?: any, $event?: any) {
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
        const curUIService:VacLeaveManageUIService  = new VacLeaveManageUIService();
        curUIService.VacLeaveManage_XJQJ(datas,contextJO, paramJO,  $event, xData,this,"VacLeaveManage");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem1_kscqj_click(params: any = {}, tag?: any, $event?: any) {
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
        const curUIService:VacLeaveManageUIService  = new VacLeaveManageUIService();
        curUIService.VacLeaveManage_KSCQJ(datas,contextJO, paramJO,  $event, xData,this,"VacLeaveManage");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_deuiaction1_click(params: any = {}, tag?: any, $event?: any) {
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
        this.OpenRowEdit(datas, contextJO,paramJO,  $event, xData,this,"VacLeaveManage");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem13_click(params: any = {}, tag?: any, $event?: any) {
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
        this.ExportExcel(datas, contextJO,paramJO,  $event, xData,this,"VacLeaveManage");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem18_click(params: any = {}, tag?: any, $event?: any) {
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
        this.Help(datas, contextJO,paramJO,  $event, xData,this,"VacLeaveManage");
    }

    /**
     * 打开新建数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof VACLEAVEMANAGEYGZZGridView
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
     * @memberof VACLEAVEMANAGEYGZZGridView
     */
    public opendata(args: any[],fullargs?:any[],params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
    this.$Notice.warning({ title: '错误', desc: '未指定关系视图' });
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
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
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
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public ExportExcel(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (!xData || !(xData.exportExcel instanceof Function) || !$event) {
            return ;
        }
        xData.exportExcel($event.exportparms);
    }
    /**
     * 帮助
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public Help(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        this.$Notice.error({ title: '错误', desc: '帮助未支持' });
    }


    /**
     * 销毁视图回调
     *
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
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
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
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
    * @memberof VACLEAVEMANAGEYGZZGridViewBase
    */
    @Prop() public formDruipart?: Subject<ViewState>;

    /**
     * 搜索值
     *
     * @type {string}
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public query: string = '';

    /**
     * 是否展开搜索表单
     *
     * @type {boolean}
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public isExpandSearchForm: boolean = false;

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
     */
    public gridRowActiveMode: number | 0 | 1 | 2 = 2;

    /**
     * 快速搜索
     *
     * @param {*} $event
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
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
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
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
     * @memberof VACLEAVEMANAGEYGZZGridViewBase
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
@import './vacleavemanageygzzgrid-view.less';
</style>