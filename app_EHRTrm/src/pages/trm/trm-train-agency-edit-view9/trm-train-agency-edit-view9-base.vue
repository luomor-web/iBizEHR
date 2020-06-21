<template>
  <app-layout viewName="trmtrainagencyeditview9" viewTitle="培训机构编辑视图" :className="{ 'view-container': true, 'default-mode-view': true, 'deeditview9': true, 'trm-train-agency-edit-view9': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import { VueLifeCycleProcessing, EditView9Base } from '@/crm-core';
import TrmTrainAgencyService from '@/service/trm-train-agency/trm-train-agency-service';

import EditView9Engine from '@engine/view/edit-view9-engine';

import TrmTrainAgencyUIService from '@/uiservice/trm-train-agency/trm-train-agency-ui-service';

/**
 * 培训机构编辑视图基类
 *
 * @export
 * @class TrmTrainAgencyEditView9Base
 * @extends {EditView9Base}
 */
@Component({})
@VueLifeCycleProcessing
export default class TrmTrainAgencyEditView9Base extends EditView9Base {

    /**
     * 实体服务对象
     *
     * @type {TrmTrainAgencyService}
     * @memberof TrmTrainAgencyEditView9Base
     */
    public appEntityService: TrmTrainAgencyService = new TrmTrainAgencyService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof TrmTrainAgencyEditView9Base
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof TrmTrainAgencyEditView9Base
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof TrmTrainAgencyEditView9Base
	 */
	public viewtag: string = '693a64777bc436f97363770cc82631c0';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof TrmTrainAgencyEditView9Base
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof TrmTrainAgencyEditView9Base
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof TrmTrainAgencyEditView9Base
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof TrmTrainAgencyEditView9Base
     */
    public model: any = {
        srfCaption: 'entities.trmtrainagency.views.editview9.caption',
        srfTitle: 'entities.trmtrainagency.views.editview9.title',
        srfSubTitle: 'entities.trmtrainagency.views.editview9.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof TrmTrainAgencyEditView9Base
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
     * @memberof TrmTrainAgencyEditView9Base
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof TrmTrainAgencyEditView9
     */
    public toolBarModels: any = {
        tbitem1_openeditview_sep: {  name: 'tbitem1_openeditview_sep', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { }, class: '' },
        tbitem1_openeditview: { name: 'tbitem1_openeditview', caption: '编辑','isShowCaption':true,'isShowIcon':true, tooltip: '编辑', iconcls: 'sx-tb-edit', icon: '../sasrfex/images/default/icon_edit.png', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'OpenEditView', target: 'SINGLEKEY' }, class: '' },

    };



    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof TrmTrainAgencyEditView9Base
     */
    public engine: EditView9Engine = new EditView9Engine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof TrmTrainAgencyEditView9Base
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'trmtrainagency',
            majorPSDEField: 'trmtrainagencyname',
            isLoadDefault: true,
        });
    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof TrmTrainAgencyEditView9Base
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'tbitem1_openeditview')) {
            this.toolbar_tbitem1_openeditview_click(null, '', $event2);
        }
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof TrmTrainAgencyEditView9Base
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof TrmTrainAgencyEditView9Base
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof TrmTrainAgencyEditView9Base
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
    public toolbar_tbitem1_openeditview_click(params: any = {}, tag?: any, $event?: any) {
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
        const curUIService:TrmTrainAgencyUIService  = new TrmTrainAgencyUIService();
        curUIService.TrmTrainAgency_OpenEditView(datas,contextJO, paramJO,  $event, xData,this,"TrmTrainAgency");
    }



    /**
     * 销毁视图回调
     *
     * @memberof TrmTrainAgencyEditView9Base
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
    * meditview9状态下发变量
    *
    * @memberof IBZSAM02MobEditView
    */
    @Prop() public panelState ?:Subject<ViewState>;




    /**
     * 视图组件挂载完毕
     *
     * @protected
     * @memberof ViewBase
     */
    protected viewMounted(): void {
        if(this.panelState){
            this.panelState.subscribe((res:any) =>{
                if(Object.is(res.tag,'meditviewpanel')){
                    if(Object.is(res.action,'save')){
                        this.viewState.next({ tag:'form', action: 'save', data:res.data});
                    }
                    if(Object.is(res.action,'remove')){
                        this.viewState.next({ tag:'form', action: 'remove', data:res.data});
                    }
                }
            });
        }
    }

}
</script>

<style lang='less'>
@import './trm-train-agency-edit-view9.less';
</style>