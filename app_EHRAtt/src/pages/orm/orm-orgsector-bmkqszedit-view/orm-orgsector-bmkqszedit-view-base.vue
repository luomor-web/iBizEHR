<template>
  <app-layout viewName="ormorgsectorbmkqszeditview" viewTitle="部门管理" :className="{ 'view-container': true, 'default-mode-view': true, 'deeditview': true, 'orm-orgsector-bmkqszedit-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
                <view_form 
            :viewState="viewState"  
            :viewparams="viewparams" 
            :context="context" 
            :autosave="false" 
            :viewtag="viewtag"
            :showBusyIndicator="true"
            updateAction="Update"
            removeAction="Remove"
            loaddraftAction="GetDraft"
            loadAction="Get"
            createAction="Create"
            WFSubmitAction=""
            WFStartAction=""
            style='' 
            name="form"  
            ref='form' 
            @save="form_save($event)"  
            @remove="form_remove($event)"  
            @load="form_load($event)"  
            @closeview="closeView($event)">
        </view_form>

      </div>
    </template>
  </app-layout>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, EditViewBase } from '@/crm-core';
import OrmOrgsectorService from '@/service/orm-orgsector/orm-orgsector-service';

import EditViewEngine from '@engine/view/edit-view-engine';


/**
 * 部门管理基类
 *
 * @export
 * @class OrmOrgsectorBMKQSZEditViewBase
 * @extends {EditViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class OrmOrgsectorBMKQSZEditViewBase extends EditViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmOrgsectorService}
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    public appEntityService: OrmOrgsectorService = new OrmOrgsectorService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof OrmOrgsectorBMKQSZEditViewBase
	 */
	public viewtag: string = '402c44c268001c72d0260161d2bece56';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof OrmOrgsectorBMKQSZEditViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof OrmOrgsectorBMKQSZEditViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormorgsector.views.bmkqszeditview.caption',
        srfTitle: 'entities.ormorgsector.views.bmkqszeditview.title',
        srfSubTitle: 'entities.ormorgsector.views.bmkqszeditview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    public containerModel: any = {
        view_toolbar: { name: 'toolbar', type: 'TOOLBAR' },
        view_form: { name: 'form', type: 'FORM' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof OrmOrgsectorBMKQSZEditView
     */
    public toolBarModels: any = {
        deuiaction1: { name: 'deuiaction1', caption: '关闭','isShowCaption':true,'isShowIcon':true, tooltip: '关闭', iconcls: 'fa fa-sign-out', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'Exit', target: '' }, class: '' },

    };




    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    public engine: EditViewEngine = new EditViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'ormorgsector',
            majorPSDEField: 'orgsectorname',
            isLoadDefault: true,
        });
    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'deuiaction1')) {
            this.toolbar_deuiaction1_click(null, '', $event2);
        }
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    public form_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'load', $event);
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
        xData = this.$refs.form;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.Exit(datas, contextJO,paramJO,  $event, xData,this,"OrmOrgsector");
    }

    /**
     * 关闭
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof OrmOrgsectorBMKQSZEditViewBase
     */
    public Exit(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        this.closeView(args);
        if(window.parent){
            window.parent.postMessage([{ ...args }],'*');
        }
    }



    /**
     * 销毁视图回调
     *
     * @memberof OrmOrgsectorBMKQSZEditViewBase
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


}
</script>

<style lang='less'>
@import './orm-orgsector-bmkqszedit-view.less';
</style>