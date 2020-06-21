<template>
  <app-layout viewName="pcmgxxktempgridview" viewTitle="高校学科" :className="{ 'view-container': true, 'default-mode-view': true, 'degridview': true, 'pcmgxxktempgrid-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import PCMGxxkTempService from '@/service/pcmgxxk-temp/pcmgxxk-temp-service';

import GridViewEngine from '@engine/view/grid-view-engine';

import CodeListService from "@service/app/codelist-service";


/**
 * 高校学科基类
 *
 * @export
 * @class PCMGXXKTEMPGridViewBase
 * @extends {GridViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PCMGXXKTEMPGridViewBase extends GridViewBase {

    /**
     * 实体服务对象
     *
     * @type {PCMGxxkTempService}
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public appEntityService: PCMGxxkTempService = new PCMGxxkTempService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PCMGXXKTEMPGridViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PCMGXXKTEMPGridViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PCMGXXKTEMPGridViewBase
	 */
	public viewtag: string = '837202b8e92e08b7c5d64fddf63a106b';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PCMGXXKTEMPGridViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PCMGXXKTEMPGridViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PCMGXXKTEMPGridViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmgxxktemp.views.gridview.caption',
        srfTitle: 'entities.pcmgxxktemp.views.gridview.title',
        srfSubTitle: 'entities.pcmgxxktemp.views.gridview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PCMGXXKTEMPGridViewBase
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
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof PCMGXXKTEMPGridView
     */
    public toolBarModels: any = {
        tbitem3: { name: 'tbitem3', caption: '新建','isShowCaption':true,'isShowIcon':true, tooltip: '新建', iconcls: 'fa fa-file-text-o', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'New', target: '' }, class: '' },

        tbitem8: { name: 'tbitem8', caption: '删除','isShowCaption':true,'isShowIcon':true, tooltip: '删除', iconcls: 'fa fa-remove', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: 'SRFUR__JGLYGXML', uiaction: { tag: 'Remove', target: 'MULTIKEY' }, class: '' },

        deuiaction1: { name: 'deuiaction1', caption: '导入','isShowCaption':true,'isShowIcon':true, tooltip: '导入', iconcls: 'fa fa-upload', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: 'SRFUR__JGLYYPZSZYJTJ', uiaction: { tag: 'Import', target: '' }, class: '' },

    };





    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public engine: GridViewEngine = new GridViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PCMGXXKTEMPGridViewBase
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
            keyPSDEField: 'pcmgxxktemp',
            majorPSDEField: 'pcmgxxktempname',
            isLoadDefault: true,
        });
    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'tbitem3')) {
            this.toolbar_tbitem3_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem8')) {
            this.toolbar_tbitem8_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'deuiaction1')) {
            this.toolbar_deuiaction1_click(null, '', $event2);
        }
    }


    /**
     * grid 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public grid_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'selectionchange', $event);
    }


    /**
     * grid 部件 beforeload 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public grid_beforeload($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'beforeload', $event);
    }


    /**
     * grid 部件 rowdblclick 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public grid_rowdblclick($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'rowdblclick', $event);
    }


    /**
     * grid 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public grid_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'remove', $event);
    }


    /**
     * grid 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public grid_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'load', $event);
    }



    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem3_click(params: any = {}, tag?: any, $event?: any) {
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
        this.New(datas, contextJO,paramJO,  $event, xData,this,"PCMGxxkTemp");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem8_click(params: any = {}, tag?: any, $event?: any) {
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
        this.Remove(datas, contextJO,paramJO,  $event, xData,this,"PCMGxxkTemp");
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
        this.Import(datas, contextJO,paramJO,  $event, xData,this,"PCMGxxkTemp");
    }

    /**
     * 打开新建数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof PCMGXXKTEMPGridView
     */
    public newdata(args: any[],fullargs?:any[], params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
        let batchAddPSAppViews:Array<any>=[];
        batchAddPSAppViews=[
            {view:{viewname:'pcmgxmlmpickup-view',height: 0,width: 0,title: '高校名录数据多项选择视图'},
            res:['PcmGxml'],
            'resAppKey':'pcmgxmlid'},
            {view:{viewname:'pcmxkmlmpickup-view',height: 0,width: 0,title: '学科目录数据多项选择视图'},
            res:['PcmXkml'],
            'resAppKey':'pcmxkmlid'}
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
     * @memberof PCMGXXKTEMPGridView
     */
    public opendata(args: any[],fullargs?:any[],params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
    this.$Notice.warning({ title: '错误', desc: '未指定关系视图' });
    }


    /**
     * 新建
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public New(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
         const _this: any = this;
        if (_this.newdata && _this.newdata instanceof Function) {
            const data: any = {};
            _this.newdata([{ ...data }],[{ ...data }], params, $event, xData);
        } else {
            _this.$Notice.error({ title: '错误', desc: 'newdata 视图处理逻辑不存在，请添加!' });
        }
    }
    /**
     * 删除
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public Remove(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (!xData || !(xData.remove instanceof Function)) {
            return ;
        }
        xData.remove(args);
    }

    /**
     * 数据导入
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public Import(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (!xData || !(xData.importExcel instanceof Function) || !$event) {
            return ;
        }
        xData.importExcel(params);
    }


    /**
     * 销毁视图回调
     *
     * @memberof PCMGXXKTEMPGridViewBase
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
     * @memberof PCMGXXKTEMPGridViewBase
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
    * @memberof PCMGXXKTEMPGridViewBase
    */
    @Prop() public formDruipart?: Subject<ViewState>;

    /**
     * 搜索值
     *
     * @type {string}
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public query: string = '';

    /**
     * 是否展开搜索表单
     *
     * @type {boolean}
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public isExpandSearchForm: boolean = false;

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof PCMGXXKTEMPGridViewBase
     */
    public gridRowActiveMode: number | 0 | 1 | 2 = 0;

    /**
     * 快速搜索
     *
     * @param {*} $event
     * @memberof PCMGXXKTEMPGridViewBase
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
     * @memberof PCMGXXKTEMPGridViewBase
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
     * @memberof PCMGXXKTEMPGridViewBase
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
@import './pcmgxxktempgrid-view.less';
</style>