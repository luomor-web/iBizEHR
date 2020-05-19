<template>
  <app-layout viewName="pimpersoneditview2" viewTitle="员工首页编辑视图" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'deeditview2': true, 'pimpersonedit-view2': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
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
import PIMPERSONService from '@/service/pimperson/pimperson-service';

import EditView2Engine from '@engine/view/edit-view2-engine';


/**
 * 员工首页编辑视图基类
 *
 * @export
 * @class PIMPERSONEditView2Base
 * @extends {EditView2Base}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMPERSONEditView2Base extends EditView2Base {

    /**
     * 实体服务对象
     *
     * @type {PIMPERSONService}
     * @memberof PIMPERSONEditView2Base
     */
    public appEntityService: PIMPERSONService = new PIMPERSONService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMPERSONEditView2Base
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMPERSONEditView2Base
	 */
	public viewtag: string = '29d56c84d92732195b0b61795c352dd6';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMPERSONEditView2Base
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMPERSONEditView2Base
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMPERSONEditView2Base
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMPERSONEditView2Base
     */
    public model: any = {
        srfCaption: 'entities.pimperson.views.editview2.caption',
        srfTitle: 'entities.pimperson.views.editview2.title',
        srfSubTitle: 'entities.pimperson.views.editview2.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMPERSONEditView2Base
     */
    public containerModel: any = {
        view_drbar: { name: 'drbar', type: 'DRBAR' },
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMPERSONEditView2Base
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PIMPERSONEditView2Base
     */
    public engine: EditView2Engine = new EditView2Engine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMPERSONEditView2Base
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            drbar: this.$refs.drbar,
            p2k: '0',
            keyPSDEField: 'pimperson',
            majorPSDEField: 'pimpersonname',
            isLoadDefault: true,
        });
    }


    /**
     * drbar 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PIMPERSONEditView2Base
     */
    public drbar_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('drbar', 'selectionchange', $event);
    }


    /**
     * drbar 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PIMPERSONEditView2Base
     */
    public drbar_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('drbar', 'load', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMPERSONEditView2Base
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
     * @memberof PIMPERSONEditView2
     */
    public selection: any = {};
    
}
</script>

<style lang='less'>
@import './pimpersonedit-view2.less';
</style>