<template>
  <app-layout viewName="socarchiveseditview" viewTitle="社保档案编辑视图" :className="{ 'view-container': true, 'default-mode-view': true, 'deeditview': true, 'soc-archives-edit-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import SocArchivesService from '@/service/soc-archives/soc-archives-service';

import EditViewEngine from '@engine/view/edit-view-engine';

import SocArchivesUIService from '@/uiservice/soc-archives/soc-archives-ui-service';

/**
 * 社保档案编辑视图基类
 *
 * @export
 * @class SocArchivesEditViewBase
 * @extends {EditViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class SocArchivesEditViewBase extends EditViewBase {

    /**
     * 实体服务对象
     *
     * @type {SocArchivesService}
     * @memberof SocArchivesEditViewBase
     */
    public appEntityService: SocArchivesService = new SocArchivesService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof SocArchivesEditViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof SocArchivesEditViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof SocArchivesEditViewBase
	 */
	public viewtag: string = '8d8165bf052eb9455044ec39843ef257';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof SocArchivesEditViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof SocArchivesEditViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof SocArchivesEditViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof SocArchivesEditViewBase
     */
    public model: any = {
        srfCaption: 'entities.socarchives.views.editview.caption',
        srfTitle: 'entities.socarchives.views.editview.title',
        srfSubTitle: 'entities.socarchives.views.editview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof SocArchivesEditViewBase
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
     * @memberof SocArchivesEditViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof SocArchivesEditView
     */
    public toolBarModels: any = {
        tbitem1_openeditview: { name: 'tbitem1_openeditview', caption: '编辑','isShowCaption':true,'isShowIcon':true, tooltip: '编辑', iconcls: 'fa fa-edit', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'OpenEditView', target: 'SINGLEKEY' }, class: '' },

    };




    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof SocArchivesEditViewBase
     */
    public engine: EditViewEngine = new EditViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof SocArchivesEditViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'socarchives',
            majorPSDEField: 'socarchivesname',
            isLoadDefault: true,
        });
    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SocArchivesEditViewBase
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
     * @memberof SocArchivesEditViewBase
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SocArchivesEditViewBase
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SocArchivesEditViewBase
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
        const curUIService:SocArchivesUIService  = new SocArchivesUIService();
        curUIService.SocArchives_OpenEditView(datas,contextJO, paramJO,  $event, xData,this,"SocArchives");
    }



    /**
     * 销毁视图回调
     *
     * @memberof SocArchivesEditViewBase
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
@import './soc-archives-edit-view.less';
</style>