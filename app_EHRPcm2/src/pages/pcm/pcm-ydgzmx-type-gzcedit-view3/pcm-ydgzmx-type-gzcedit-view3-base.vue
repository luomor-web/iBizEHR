<template>
  <app-layout viewName="pcmydgzmxtype_gzceditview3" viewTitle="异动挂职明细编辑视图(挂职出)" :className="{ 'view-container': true, 'default-mode-view': true, 'deeditview3': true, 'pcm-ydgzmx-type-gzcedit-view3': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
                    <view_drtab 
            :viewState="viewState"  
            name='drtab' 
            ref='drtab' 
            :viewparams="viewparams" 
            :context="context"
            parentName = "PcmYdgzmx"
            @selectionchange='drtab_selectionchange($event)' 
            @closeview='closeView($event)'>
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
        </view_drtab>

      </div>
    </template>
  </app-layout>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, EditView3Base } from '@/crm-core';
import PcmYdgzmxService from '@/service/pcm-ydgzmx/pcm-ydgzmx-service';

import EditView3Engine from '@engine/view/edit-view3-engine';


/**
 * 异动挂职明细编辑视图(挂职出)基类
 *
 * @export
 * @class PcmYdgzmxTYPE_GZCEditView3Base
 * @extends {EditView3Base}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmYdgzmxTYPE_GZCEditView3Base extends EditView3Base {

    /**
     * 实体服务对象
     *
     * @type {PcmYdgzmxService}
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public appEntityService: PcmYdgzmxService = new PcmYdgzmxService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmYdgzmxTYPE_GZCEditView3Base
	 */
	public viewtag: string = 'cba4cbdc06707a0fe65d285c479d827c';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmYdgzmxTYPE_GZCEditView3Base
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmYdgzmxTYPE_GZCEditView3Base
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public model: any = {
        srfCaption: 'entities.pcmydgzmx.views.type_gzceditview3.caption',
        srfTitle: 'entities.pcmydgzmx.views.type_gzceditview3.title',
        srfSubTitle: 'entities.pcmydgzmx.views.type_gzceditview3.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public containerModel: any = {
        view_drtab: { name: 'drtab', type: 'DRTAB' },
        view_toolbar: { name: 'toolbar', type: 'TOOLBAR' },
        view_form: { name: 'form', type: 'FORM' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof PcmYdgzmxTYPE_GZCEditView3
     */
    public toolBarModels: any = {
        tbitem3: { name: 'tbitem3', caption: '保存','isShowCaption':true,'isShowIcon':true, tooltip: '保存', iconcls: 'fa fa-save', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: 'SRFUR__JGLYZPMXME', uiaction: { tag: 'Save', target: '' }, class: '' },

        tbitem5: { name: 'tbitem5', caption: '保存并关闭','isShowCaption':true,'isShowIcon':true, tooltip: '保存并关闭', iconcls: 'sx-tb-saveandclose', icon: '../sasrfex/images/default/icon_saveandclose.png', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: 'SRFUR__JGLYXKML', uiaction: { tag: 'SaveAndExit', target: '' }, class: '' },

    };



    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public engine: EditView3Engine = new EditView3Engine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            drtab: this.$refs.drtab,
            keyPSDEField: 'pcmydgzmx',
            majorPSDEField: 'pcmydgzmxname',
            isLoadDefault: true,
        });
    }


    /**
     * drtab 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public drtab_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('drtab', 'selectionchange', $event);
    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'tbitem3')) {
            this.toolbar_tbitem3_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem5')) {
            this.toolbar_tbitem5_click(null, '', $event2);
        }
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
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
    public toolbar_tbitem3_click(params: any = {}, tag?: any, $event?: any) {
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
        this.Save(datas, contextJO,paramJO,  $event, xData,this,"PcmYdgzmx");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem5_click(params: any = {}, tag?: any, $event?: any) {
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
        this.SaveAndExit(datas, contextJO,paramJO,  $event, xData,this,"PcmYdgzmx");
    }

    /**
     * 保存
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public Save(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        // 界面行为容器对象 _this
        const _this: any = this;
        if (xData && xData.save instanceof Function) {
            xData.save().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                _this.$emit('viewdataschange', [{ ...response.data }]);
            });
        } else if (_this.save && _this.save instanceof Function) {
            _this.save();
        }
    }

    /**
     * 保存并关闭
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public SaveAndExit(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (xData && xData.saveAndExit instanceof Function) {
            xData.saveAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                if(window.parent){
                    window.parent.postMessage([{ ...response.data }],'*');
                }
            });
        } else if (_this.saveAndExit && _this.saveAndExit instanceof Function) {
            _this.saveAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                if(window.parent){
                    window.parent.postMessage([{ ...response.data }],'*');
                }
            });
        }
    }


    /**
     * 销毁视图回调
     *
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
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
     * 选中数据
     *
     * @type {*}
     * @memberof PcmYdgzmxTYPE_GZCEditView3Base
     */
    public selection: any = {};
    
}
</script>

<style lang='less'>
@import './pcm-ydgzmx-type-gzcedit-view3.less';
</style>