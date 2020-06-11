<template>
  <app-layout viewName="parexamcycleeditview2" viewTitle="考核周期编辑视图" :className="{ 'view-container': true, 'default-mode-view': true, 'deeditview2': true, 'par-exam-cycle-edit-view2': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
                    <view_drbar 
            :viewState="viewState"
            loadAction='get'  
            name='drbar' 
            ref='drbar' 
            :viewparams="viewparams" 
            :context="context"
            @selectionchange="drbar_selectionchange($event)"
            @load="drbar_load($event)"
            @closeview="closeView($event)">
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
        </view_drbar>

      </div>
    </template>
  </app-layout>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, EditView2Base } from '@/crm-core';
import ParExamCycleService from '@/service/par-exam-cycle/par-exam-cycle-service';

import EditView2Engine from '@engine/view/edit-view2-engine';


/**
 * 考核周期编辑视图基类
 *
 * @export
 * @class ParExamCycleEditView2Base
 * @extends {EditView2Base}
 */
@Component({})
@VueLifeCycleProcessing
export default class ParExamCycleEditView2Base extends EditView2Base {

    /**
     * 实体服务对象
     *
     * @type {ParExamCycleService}
     * @memberof ParExamCycleEditView2Base
     */
    public appEntityService: ParExamCycleService = new ParExamCycleService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ParExamCycleEditView2Base
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ParExamCycleEditView2Base
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ParExamCycleEditView2Base
	 */
	public viewtag: string = '1e42ac493a08f87edf0c49360e4450e3';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ParExamCycleEditView2Base
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ParExamCycleEditView2Base
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ParExamCycleEditView2Base
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ParExamCycleEditView2Base
     */
    public model: any = {
        srfCaption: 'entities.parexamcycle.views.editview2.caption',
        srfTitle: 'entities.parexamcycle.views.editview2.title',
        srfSubTitle: 'entities.parexamcycle.views.editview2.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ParExamCycleEditView2Base
     */
    public containerModel: any = {
        view_toolbar: { name: 'toolbar', type: 'TOOLBAR' },
        view_form: { name: 'form', type: 'FORM' },
        view_drbar: { name: 'drbar', type: 'DRBAR' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ParExamCycleEditView2Base
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof ParExamCycleEditView2
     */
    public toolBarModels: any = {
        tbitem3: { name: 'tbitem3', caption: '保存','isShowCaption':true,'isShowIcon':true, tooltip: '保存', iconcls: 'fa fa-save', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: 'SRFUR__JGLYZPMXME', uiaction: { tag: 'Save', target: '' }, class: '' },

    };



    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof ParExamCycleEditView2Base
     */
    public engine: EditView2Engine = new EditView2Engine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ParExamCycleEditView2Base
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            drbar: this.$refs.drbar,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'parexamcycle',
            majorPSDEField: 'parexamcyclename',
            isLoadDefault: true,
        });
    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ParExamCycleEditView2Base
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'tbitem3')) {
            this.toolbar_tbitem3_click(null, '', $event2);
        }
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ParExamCycleEditView2Base
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ParExamCycleEditView2Base
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ParExamCycleEditView2Base
     */
    public form_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'load', $event);
    }


    /**
     * drbar 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ParExamCycleEditView2Base
     */
    public drbar_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('drbar', 'selectionchange', $event);
    }


    /**
     * drbar 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ParExamCycleEditView2Base
     */
    public drbar_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('drbar', 'load', $event);
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
        this.Save(datas, contextJO,paramJO,  $event, xData,this,"ParExamCycle");
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
     * @memberof ParExamCycleEditView2Base
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
     * 销毁视图回调
     *
     * @memberof ParExamCycleEditView2Base
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
     * @memberof ParExamCycleEditView2
     */
    public selection: any = {};
    
}
</script>

<style lang='less'>
@import './par-exam-cycle-edit-view2.less';
</style>