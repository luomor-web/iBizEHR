<template>
  <app-layout viewName="pimpersonzhzceditview" viewTitle="证书信息编辑视图" :isShowCaptionBar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'deeditview': true, 'pimpersonzhzcedit-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import PIMPERSONService from '@/service/pimperson/pimperson-service';

import EditViewEngine from '@engine/view/edit-view-engine';


/**
 * 证书信息编辑视图基类
 *
 * @export
 * @class PIMPERSONZHZCEditViewBase
 * @extends {EditViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMPERSONZHZCEditViewBase extends EditViewBase {

    /**
     * 实体服务对象
     *
     * @type {PIMPERSONService}
     * @memberof PIMPERSONZHZCEditViewBase
     */
    public appEntityService: PIMPERSONService = new PIMPERSONService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMPERSONZHZCEditViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMPERSONZHZCEditViewBase
	 */
	public viewtag: string = 'a75234c9f1badf160bebfc6b1b00fc13';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMPERSONZHZCEditViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMPERSONZHZCEditViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMPERSONZHZCEditViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMPERSONZHZCEditViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimperson.views.zhzceditview.caption',
        srfTitle: 'entities.pimperson.views.zhzceditview.title',
        srfSubTitle: 'entities.pimperson.views.zhzceditview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMPERSONZHZCEditViewBase
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
     * @memberof PIMPERSONZHZCEditViewBase
     */
    public viewState: Subject<ViewState> = new Subject();

    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof PIMPERSONZHZCEditView
     */
    public toolBarModels: any = {
    };




    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PIMPERSONZHZCEditViewBase
     */
    public engine: EditViewEngine = new EditViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMPERSONZHZCEditViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'pimperson',
            majorPSDEField: 'pimpersonname',
            isLoadDefault: true,
        });
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PIMPERSONZHZCEditViewBase
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PIMPERSONZHZCEditViewBase
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PIMPERSONZHZCEditViewBase
     */
    public form_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'load', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMPERSONZHZCEditViewBase
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
@import './pimpersonzhzcedit-view.less';
</style>