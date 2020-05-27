<template>
  <app-layout viewName="ormorgeditview9" viewTitle="组织信息" :className="{ 'view-container': true, 'default-mode-view': true, 'deeditview9': true, 'ormorgedit-view9': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import ORMORGService from '@/service/ormorg/ormorg-service';

import EditView9Engine from '@engine/view/edit-view9-engine';

import ORMORGUIService from '@/uiservice/ormorg/ormorg-ui-service';

/**
 * 组织信息基类
 *
 * @export
 * @class ORMORGEditView9Base
 * @extends {EditView9Base}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMORGEditView9Base extends EditView9Base {

    /**
     * 实体服务对象
     *
     * @type {ORMORGService}
     * @memberof ORMORGEditView9Base
     */
    public appEntityService: ORMORGService = new ORMORGService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMORGEditView9Base
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMORGEditView9Base
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMORGEditView9Base
	 */
	public viewtag: string = '975252aa8b53de1912591cca23064124';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMORGEditView9Base
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMORGEditView9Base
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMORGEditView9Base
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMORGEditView9Base
     */
    public model: any = {
        srfCaption: 'entities.ormorg.views.editview9.caption',
        srfTitle: 'entities.ormorg.views.editview9.title',
        srfSubTitle: 'entities.ormorg.views.editview9.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMORGEditView9Base
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
     * @memberof ORMORGEditView9Base
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof ORMORGEditView9
     */
    public toolBarModels: any = {
        deuiaction1: { name: 'deuiaction1', caption: '编辑','isShowCaption':true,'isShowIcon':true, tooltip: '编辑', iconcls: 'fa fa-edit', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'OpenEditView', target: 'SINGLEKEY' }, class: '' },

    };



    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof ORMORGEditView9Base
     */
    public engine: EditView9Engine = new EditView9Engine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMORGEditView9Base
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'ormorg',
            majorPSDEField: 'orgname',
            isLoadDefault: true,
        });
    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ORMORGEditView9Base
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
     * @memberof ORMORGEditView9Base
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ORMORGEditView9Base
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ORMORGEditView9Base
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
        const curUIService:ORMORGUIService  = new ORMORGUIService();
        curUIService.ORMORG_OpenEditView(datas,contextJO, paramJO,  $event, xData,this,"ORMORG");
    }



    /**
     * 销毁视图回调
     *
     * @memberof ORMORGEditView9Base
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
@import './ormorgedit-view9.less';
</style>