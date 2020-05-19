<template>
  <app-layout viewName="pimpersonchangeeditview" viewTitle="员工信息审核编辑视图" :className="{ 'view-container': true, 'default-mode-view': true, 'deeditview': true, 'pimpersonchangeedit-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import PIMPERSONCHANGEService from '@/service/pimpersonchange/pimpersonchange-service';

import EditViewEngine from '@engine/view/edit-view-engine';

import PIMPERSONCHANGEUIService from '@/uiservice/pimpersonchange/pimpersonchange-ui-service';

/**
 * 员工信息审核编辑视图基类
 *
 * @export
 * @class PIMPERSONCHANGEEditViewBase
 * @extends {EditViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMPERSONCHANGEEditViewBase extends EditViewBase {

    /**
     * 实体服务对象
     *
     * @type {PIMPERSONCHANGEService}
     * @memberof PIMPERSONCHANGEEditViewBase
     */
    public appEntityService: PIMPERSONCHANGEService = new PIMPERSONCHANGEService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMPERSONCHANGEEditViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMPERSONCHANGEEditViewBase
	 */
	public viewtag: string = '24219eb43eca0c36fcaa2b3a9c84c991';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMPERSONCHANGEEditViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMPERSONCHANGEEditViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMPERSONCHANGEEditViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMPERSONCHANGEEditViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimpersonchange.views.editview.caption',
        srfTitle: 'entities.pimpersonchange.views.editview.title',
        srfSubTitle: 'entities.pimpersonchange.views.editview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMPERSONCHANGEEditViewBase
     */
    public containerModel: any = {
        view_toolbar: { name: 'toolbar', type: 'TOOLBAR' },
        view_form: { name: 'form', type: 'FORM' },
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMPERSONCHANGEEditViewBase
     */
    public viewState: Subject<ViewState> = new Subject();

    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof PIMPERSONCHANGEEditView
     */
    public toolBarModels: any = {
        deuiaction2_qr: { name: 'deuiaction2_qr', caption: '同意','isShowCaption':true,'isShowIcon':true, tooltip: '同意', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'QR', target: 'MULTIKEY' }, class: '' },

        deuiaction2_bh: { name: 'deuiaction2_bh', caption: '拒绝','isShowCaption':true,'isShowIcon':true, tooltip: '拒绝', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'BH', target: 'SINGLEKEY' }, class: '' },

        deuiaction1: { name: 'deuiaction1', caption: '退出','isShowCaption':true,'isShowIcon':true, tooltip: '退出', iconcls: 'fa fa-sign-out', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'Exit', target: '' }, class: '' },

    };




    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PIMPERSONCHANGEEditViewBase
     */
    public engine: EditViewEngine = new EditViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMPERSONCHANGEEditViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'pimpersonchange',
            majorPSDEField: 'pimpersonchangename',
            isLoadDefault: true,
        });
    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PIMPERSONCHANGEEditViewBase
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'deuiaction2_qr')) {
            this.toolbar_deuiaction2_qr_click($event, '', $event2);
        }
        if (Object.is($event.tag, 'deuiaction2_bh')) {
            this.toolbar_deuiaction2_bh_click($event, '', $event2);
        }
        if (Object.is($event.tag, 'deuiaction1')) {
            this.toolbar_deuiaction1_click($event, '', $event2);
        }
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PIMPERSONCHANGEEditViewBase
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PIMPERSONCHANGEEditViewBase
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PIMPERSONCHANGEEditViewBase
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
    public toolbar_deuiaction2_qr_click(params: any = {}, tag?: any, $event?: any) {
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
        // 界面行为
        const curUIService:PIMPERSONCHANGEUIService  = new PIMPERSONCHANGEUIService();
        curUIService.PIMPERSONCHANGE_QR(datas,contextJO, paramJO,  $event, xData,this,"PIMPERSONCHANGE");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_deuiaction2_bh_click(params: any = {}, tag?: any, $event?: any) {
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
        // 界面行为
        const curUIService:PIMPERSONCHANGEUIService  = new PIMPERSONCHANGEUIService();
        curUIService.PIMPERSONCHANGE_BH(datas,contextJO, paramJO,  $event, xData,this,"PIMPERSONCHANGE");
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
        // 界面行为
        this.Exit(datas, contextJO,paramJO,  $event, xData,this,"PIMPERSONCHANGE");
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
     * @memberof PIMPERSONCHANGEEditViewBase
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
     * @memberof PIMPERSONCHANGEEditViewBase
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
@import './pimpersonchangeedit-view.less';
</style>