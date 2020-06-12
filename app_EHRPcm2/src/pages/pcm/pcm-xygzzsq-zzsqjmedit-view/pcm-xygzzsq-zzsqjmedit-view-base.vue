<template>
  <app-layout viewName="pcmxygzzsqzzsqjmeditview" viewTitle="试用期员工转正" :className="{ 'view-container': true, 'default-mode-view': true, 'deeditview': true, 'pcm-xygzzsq-zzsqjmedit-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import PcmXygzzsqService from '@/service/pcm-xygzzsq/pcm-xygzzsq-service';

import EditViewEngine from '@engine/view/edit-view-engine';

import PcmXygzzsqUIService from '@/uiservice/pcm-xygzzsq/pcm-xygzzsq-ui-service';

/**
 * 试用期员工转正基类
 *
 * @export
 * @class PcmXygzzsqZZSQJMEditViewBase
 * @extends {EditViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmXygzzsqZZSQJMEditViewBase extends EditViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmXygzzsqService}
     * @memberof PcmXygzzsqZZSQJMEditViewBase
     */
    public appEntityService: PcmXygzzsqService = new PcmXygzzsqService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmXygzzsqZZSQJMEditViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmXygzzsqZZSQJMEditViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmXygzzsqZZSQJMEditViewBase
	 */
	public viewtag: string = 'c033c817e7c00e3eda6a72541f396992';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmXygzzsqZZSQJMEditViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmXygzzsqZZSQJMEditViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmXygzzsqZZSQJMEditViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmXygzzsqZZSQJMEditViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmxygzzsq.views.zzsqjmeditview.caption',
        srfTitle: 'entities.pcmxygzzsq.views.zzsqjmeditview.title',
        srfSubTitle: 'entities.pcmxygzzsq.views.zzsqjmeditview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmXygzzsqZZSQJMEditViewBase
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
     * @memberof PcmXygzzsqZZSQJMEditViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof PcmXygzzsqZZSQJMEditView
     */
    public toolBarModels: any = {
        deuiaction2_saveandexit: { name: 'deuiaction2_saveandexit', caption: '确认','isShowCaption':true,'isShowIcon':true, tooltip: '确认', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'SaveAndExit', target: 'SINGLEKEY' }, class: '' },

        deuiaction1: { name: 'deuiaction1', caption: '退出','isShowCaption':true,'isShowIcon':true, tooltip: '退出', iconcls: 'fa fa-sign-out', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'Exit', target: '' }, class: '' },

    };




    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PcmXygzzsqZZSQJMEditViewBase
     */
    public engine: EditViewEngine = new EditViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmXygzzsqZZSQJMEditViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'pcmxygzzsq',
            majorPSDEField: 'pcmxygzzsqname',
            isLoadDefault: true,
        });
    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqZZSQJMEditViewBase
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'deuiaction2_saveandexit')) {
            this.toolbar_deuiaction2_saveandexit_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'deuiaction1')) {
            this.toolbar_deuiaction1_click(null, '', $event2);
        }
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqZZSQJMEditViewBase
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqZZSQJMEditViewBase
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqZZSQJMEditViewBase
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
    public toolbar_deuiaction2_saveandexit_click(params: any = {}, tag?: any, $event?: any) {
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
        const curUIService:PcmXygzzsqUIService  = new PcmXygzzsqUIService();
        curUIService.PcmXygzzsq_SaveAndExit(datas,contextJO, paramJO,  $event, xData,this,"PcmXygzzsq");
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
        this.Exit(datas, contextJO,paramJO,  $event, xData,this,"PcmXygzzsq");
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
     * @memberof PcmXygzzsqZZSQJMEditViewBase
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
     * @memberof PcmXygzzsqZZSQJMEditViewBase
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
@import './pcm-xygzzsq-zzsqjmedit-view.less';
</style>