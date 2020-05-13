<template>
  <app-layout viewName="ormsignorgpickupview" viewTitle="法人主体数据选择视图" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'depickupview': true, 'orm-sign-org-pickup-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
                    <view_pickupviewpanel 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :isSingleSelect="isSingleSelect"
                :selectedData="selectedData"
                :isShowButton="isShowButton"
                name="pickupviewpanel"  
                ref='pickupviewpanel' 
                @selectionchange="pickupviewpanel_selectionchange($event)"  
                @activated="pickupviewpanel_activated($event)"  
                @load="pickupviewpanel_load($event)"  
                @closeview="closeView($event)">
            </view_pickupviewpanel>
            <card v-if="isShowButton" :dis-hover="true" :bordered="false" class="footer">
                <row :style="{ textAlign: 'right' }">
                    <i-button type="primary" :disabled="this.viewSelections.length > 0 ? false : true" @click="onClickOk">{{this.containerModel.view_okbtn.text}}</i-button>
                        &nbsp;&nbsp;
                    <i-button @click="onClickCancel">{{this.containerModel.view_cancelbtn.text}}</i-button>
                </row>
            </card>

      </div>
    </template>
  </app-layout>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, PickupViewBase } from '@/crm-core';
import OrmSignOrgService from '@/service/orm-sign-org/orm-sign-org-service';

import PickupViewEngine from '@engine/view/pickup-view-engine';


/**
 * 法人主体数据选择视图基类
 *
 * @export
 * @class OrmSignOrgPickupViewBase
 * @extends {PickupViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class OrmSignOrgPickupViewBase extends PickupViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmSignOrgService}
     * @memberof OrmSignOrgPickupViewBase
     */
    public appEntityService: OrmSignOrgService = new OrmSignOrgService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof OrmSignOrgPickupViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof OrmSignOrgPickupViewBase
	 */
	public viewtag: string = 'b2e88fc228c7b89b15bcb65d1b7b23a2';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof OrmSignOrgPickupViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof OrmSignOrgPickupViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof OrmSignOrgPickupViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof OrmSignOrgPickupViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormsignorg.views.pickupview.caption',
        srfTitle: 'entities.ormsignorg.views.pickupview.title',
        srfSubTitle: 'entities.ormsignorg.views.pickupview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof OrmSignOrgPickupViewBase
     */
    public containerModel: any = {
        view_pickupviewpanel: { name: 'pickupviewpanel', type: 'PICKUPVIEWPANEL' },
        view_okbtn: { name: 'okbtn', type: 'button', text: '确定', disabled: true },
        view_cancelbtn: { name: 'cancelbtn', type: 'button', text: '取消', disabled: false },
        view_leftbtn: { name: 'leftbtn', type: 'button', text: '左移', disabled: true },
        view_rightbtn: { name: 'rightbtn', type: 'button', text: '右移', disabled: true },
        view_allleftbtn: { name: 'allleftbtn', type: 'button', text: '全部左移', disabled: true },
        view_allrightbtn: { name: 'allrightbtn', type: 'button', text: '全部右移', disabled: true },
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof OrmSignOrgPickupViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @protected
     * @type {Engine}
     * @memberof OrmSignOrgPickupViewBase
     */
    protected engine: PickupViewEngine = new PickupViewEngine();
	

    /**
     * 引擎初始化
     *
     * @protected
     * @memberof OrmSignOrgPickupViewBase
     */
    protected engineInit(): void {
        this.engine.init({
            view: this,
            pickupviewpanel: this.$refs.pickupviewpanel,
            keyPSDEField: 'ormsignorg',
            majorPSDEField: 'ormsignorgname',
            isLoadDefault: true,
        });
    }


    /**
     * pickupviewpanel 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof OrmSignOrgPickupViewBase
     */
    public pickupviewpanel_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', $event);
    }


    /**
     * pickupviewpanel 部件 activated 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof OrmSignOrgPickupViewBase
     */
    public pickupviewpanel_activated($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'activated', $event);
    }


    /**
     * pickupviewpanel 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof OrmSignOrgPickupViewBase
     */
    public pickupviewpanel_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'load', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof OrmSignOrgPickupViewBase
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
     * 选中数据的字符串
     *
     * @type {string}
     * @memberof OrmSignOrgPickupView
     */
    protected selectedData: string = "";

    /**
     * 视图选中数据
     *
     * @type {any[]}
     * @memberof OrmSignOrgPickupView
     */
    public viewSelections:any[] = [];

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof OrmSignOrgPickupView
     */
    @Prop({default: true}) public isShowButton!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof OrmSignOrgPickupView
     */
    public isSingleSelect: boolean = true;

    /**
     * 视图参数变更
     *
     * @protected
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof OrmSignOrgPickupView
     */
    protected viewParamChange(newVal: any, oldVal: any): void {
        if(this.viewparams.selectedData){
            this.selectedData = JSON.stringify(this.viewparams.selectedData);
        }
    }

    /**
     * 视图组件挂载完毕
     *
     * @protected
     * @memberof OrmSignOrgPickupView
     */
    protected viewMounted(): void {
        if(this.viewparams.selectedData){
            this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', this.viewparams.selectedData);
        }
    }

    /**
     * 确定
     *
     * @memberof OrmSignOrgPickupView
     */
    public onClickOk(): void {
        this.$emit('viewdataschange', this.viewSelections);
        this.$emit('close', null);
    }

    /**
     * 取消
     *
     * @memberof OrmSignOrgPickupView
     */
    public onClickCancel(): void {
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './orm-sign-org-pickup-view.less';
</style>