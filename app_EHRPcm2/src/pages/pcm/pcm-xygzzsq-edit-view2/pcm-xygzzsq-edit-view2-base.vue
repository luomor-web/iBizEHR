<template>
  <app-layout viewName="pcmxygzzsqeditview2" viewTitle="试用期员工转正申请编辑视图" :className="{ 'view-container': true, 'default-mode-view': true, 'deeditview2': true, 'pcm-xygzzsq-edit-view2': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
            :formData="formData"
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
import PcmXygzzsqService from '@/service/pcm-xygzzsq/pcm-xygzzsq-service';

import EditView2Engine from '@engine/view/edit-view2-engine';


/**
 * 试用期员工转正申请编辑视图基类
 *
 * @export
 * @class PcmXygzzsqEditView2Base
 * @extends {EditView2Base}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmXygzzsqEditView2Base extends EditView2Base {

    /**
     * 实体服务对象
     *
     * @type {PcmXygzzsqService}
     * @memberof PcmXygzzsqEditView2Base
     */
    public appEntityService: PcmXygzzsqService = new PcmXygzzsqService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmXygzzsqEditView2Base
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmXygzzsqEditView2Base
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmXygzzsqEditView2Base
	 */
	public viewtag: string = 'ae79a8c5e519c5ae185b82826828ee27';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmXygzzsqEditView2Base
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmXygzzsqEditView2Base
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmXygzzsqEditView2Base
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmXygzzsqEditView2Base
     */
    public model: any = {
        srfCaption: 'entities.pcmxygzzsq.views.editview2.caption',
        srfTitle: 'entities.pcmxygzzsq.views.editview2.title',
        srfSubTitle: 'entities.pcmxygzzsq.views.editview2.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmXygzzsqEditView2Base
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
     * @memberof PcmXygzzsqEditView2Base
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof PcmXygzzsqEditView2
     */
    public toolBarModels: any = {
        tbitem3: { name: 'tbitem3', caption: '保存','isShowCaption':true,'isShowIcon':true, tooltip: '保存', iconcls: 'fa fa-save', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: 'SRFUR__JGLYZPMXME', uiaction: { tag: 'Save', target: '' }, class: '' },

        tbitem4: { name: 'tbitem4', caption: '保存并新建','isShowCaption':true,'isShowIcon':true, tooltip: '保存并新建', iconcls: 'sx-tb-saveandnew', icon: '../sasrfex/images/default/icon_saveandnew.png', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'SaveAndNew', target: '' }, class: '' },

        tbitem5: { name: 'tbitem5', caption: '保存并关闭','isShowCaption':true,'isShowIcon':true, tooltip: '保存并关闭', iconcls: 'sx-tb-saveandclose', icon: '../sasrfex/images/default/icon_saveandclose.png', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: 'SRFUR__JGLYXKML', uiaction: { tag: 'SaveAndExit', target: '' }, class: '' },

        tbitem7: { name: 'tbitem7', caption: '删除并关闭','isShowCaption':true,'isShowIcon':true, tooltip: '删除并关闭', iconcls: 'fa fa-remove', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'RemoveAndExit', target: 'SINGLEKEY' }, class: '' },

        tbitem22: { name: 'tbitem22', caption: '帮助','isShowCaption':true,'isShowIcon':true, tooltip: '帮助', iconcls: 'fa fa-question', icon: '', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'Help', target: '' }, class: '' },

    };



    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PcmXygzzsqEditView2Base
     */
    public engine: EditView2Engine = new EditView2Engine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmXygzzsqEditView2Base
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            drbar: this.$refs.drbar,
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
     * @memberof PcmXygzzsqEditView2Base
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'tbitem3')) {
            this.toolbar_tbitem3_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem4')) {
            this.toolbar_tbitem4_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem5')) {
            this.toolbar_tbitem5_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem7')) {
            this.toolbar_tbitem7_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem10')) {
            this.toolbar_tbitem10_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem15')) {
            this.toolbar_tbitem15_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem22')) {
            this.toolbar_tbitem22_click(null, '', $event2);
        }
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqEditView2Base
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqEditView2Base
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqEditView2Base
     */
    public form_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'load', $event);
    }


    /**
     * drbar 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqEditView2Base
     */
    public drbar_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('drbar', 'selectionchange', $event);
    }


    /**
     * drbar 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmXygzzsqEditView2Base
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
        this.Save(datas, contextJO,paramJO,  $event, xData,this,"PcmXygzzsq");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem4_click(params: any = {}, tag?: any, $event?: any) {
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
        this.SaveAndNew(datas, contextJO,paramJO,  $event, xData,this,"PcmXygzzsq");
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
        this.SaveAndExit(datas, contextJO,paramJO,  $event, xData,this,"PcmXygzzsq");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem7_click(params: any = {}, tag?: any, $event?: any) {
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
        this.RemoveAndExit(datas, contextJO,paramJO,  $event, xData,this,"PcmXygzzsq");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem10_click(params: any = {}, tag?: any, $event?: any) {
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
        this.ViewWFStep(datas, contextJO,paramJO,  $event, xData,this,"PcmXygzzsq");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem15_click(params: any = {}, tag?: any, $event?: any) {
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
        this.Print(datas, contextJO,paramJO,  $event, xData,this,"PcmXygzzsq");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem22_click(params: any = {}, tag?: any, $event?: any) {
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
        this.Help(datas, contextJO,paramJO,  $event, xData,this,"PcmXygzzsq");
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
     * @memberof PcmXygzzsqEditView2Base
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
     * 保存并新建
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PcmXygzzsqEditView2Base
     */
    public SaveAndNew(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (!xData || !(xData.saveAndNew instanceof Function)) {
            return;
        }
        xData.saveAndNew().then((response: any) => {
            if (!response || response.status !== 200) {
                _this.$emit('viewdataschange', JSON.stringify({status:'error',action:'saveAndNew'}));
                return;
            }
            _this.$emit('viewdataschange', JSON.stringify({status:'success',action:'saveAndNew',data:response.data}));
            if (xData.autoLoad instanceof Function) {
                xData.autoLoad();
            }
        });
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
     * @memberof PcmXygzzsqEditView2Base
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
     * 删除并关闭
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PcmXygzzsqEditView2Base
     */
    public RemoveAndExit(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (xData && xData.removeAndExit instanceof Function) {
            xData.removeAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                if(window.parent){
                    window.parent.postMessage([{ ...response.data }],'*');
                }
            });
        } else if (_this.removeAndExit && _this.removeAndExit instanceof Function) {
            _this.removeAndExit().then((response: any) => {
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
     * 当前流程步骤
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PcmXygzzsqEditView2Base
     */
    public ViewWFStep(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        let _this:any = this;
        if (!xData || !(xData.wfsubmit instanceof Function)) {
            return;
        }
        xData.wfsubmit(args).then((response: any) => {
            if (!response || response.status !== 200) {
                return;
            }
            const { data: _data } = response;

            if (_this.viewdata) {
                _this.$emit('viewdataschange', [{ ..._data }]);
                _this.$emit('close');
            } else if (_this.$tabPageExp) {
                _this.$tabPageExp.onClose(_this.$route.fullPath);
            }
        });
    }
    /**
     * 打印
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PcmXygzzsqEditView2Base
     */
    public Print(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        let _this:any = this;
        if (!xData || !(xData.print instanceof Function) || !$event) {
            return ;
        }
        xData.print();
    }
    /**
     * 帮助
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof PcmXygzzsqEditView2Base
     */
    public Help(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        this.$Notice.error({ title: '错误', desc: '帮助未支持' });
    }


    /**
     * 销毁视图回调
     *
     * @memberof PcmXygzzsqEditView2Base
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
     * @memberof PcmXygzzsqEditView2Base
     */
    public selection: any = {};

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof PcmXygzzsqEditView2Base
     */
    public formData:any = {};
    
}
</script>

<style lang='less'>
@import './pcm-xygzzsq-edit-view2.less';
</style>