<template>
  <app-layout viewName="ormorgallleveltwoorgpickupview" viewTitle="管理单位" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'depickupview': true, 'ormorgall-level-two-org-pickup-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import ORMORGService from '@/service/ormorg/ormorg-service';

import PickupViewEngine from '@engine/view/pickup-view-engine';


/**
 * 管理单位基类
 *
 * @export
 * @class ORMORGAllLevelTwoOrgPickupViewBase
 * @extends {PickupViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMORGAllLevelTwoOrgPickupViewBase extends PickupViewBase {

    /**
     * 实体服务对象
     *
     * @type {ORMORGService}
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
     */
    public appEntityService: ORMORGService = new ORMORGService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMORGAllLevelTwoOrgPickupViewBase
	 */
	public viewtag: string = 'b3bea7eebaa3725e7530ca9d74511cf5';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMORGAllLevelTwoOrgPickupViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMORGAllLevelTwoOrgPickupViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormorg.views.allleveltwoorgpickupview.caption',
        srfTitle: 'entities.ormorg.views.allleveltwoorgpickupview.title',
        srfSubTitle: 'entities.ormorg.views.allleveltwoorgpickupview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
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
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @protected
     * @type {Engine}
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
     */
    protected engine: PickupViewEngine = new PickupViewEngine();
	

    /**
     * 引擎初始化
     *
     * @protected
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
     */
    protected engineInit(): void {
        this.engine.init({
            view: this,
            pickupviewpanel: this.$refs.pickupviewpanel,
            keyPSDEField: 'ormorg',
            majorPSDEField: 'orgname',
            isLoadDefault: true,
        });
    }


    /**
     * pickupviewpanel 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
     */
    public pickupviewpanel_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', $event);
    }


    /**
     * pickupviewpanel 部件 activated 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
     */
    public pickupviewpanel_activated($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'activated', $event);
    }


    /**
     * pickupviewpanel 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
     */
    public pickupviewpanel_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'load', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMORGAllLevelTwoOrgPickupViewBase
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
     * @memberof ORMORGAllLevelTwoOrgPickupView
     */
    protected selectedData: string = "";

    /**
     * 视图选中数据
     *
     * @type {any[]}
     * @memberof ORMORGAllLevelTwoOrgPickupView
     */
    public viewSelections:any[] = [];

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof ORMORGAllLevelTwoOrgPickupView
     */
    @Prop({default: true}) public isShowButton!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof ORMORGAllLevelTwoOrgPickupView
     */
    public isSingleSelect: boolean = true;

    /**
     * 视图参数变更
     *
     * @protected
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ORMORGAllLevelTwoOrgPickupView
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
     * @memberof ORMORGAllLevelTwoOrgPickupView
     */
    protected viewMounted(): void {
        if(this.viewparams.selectedData){
            this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', this.viewparams.selectedData);
        }
    }

    /**
     * 确定
     *
     * @memberof ORMORGAllLevelTwoOrgPickupView
     */
    public onClickOk(): void {
        this.$emit('viewdataschange', this.viewSelections);
        this.$emit('close', null);
    }

    /**
     * 取消
     *
     * @memberof ORMORGAllLevelTwoOrgPickupView
     */
    public onClickCancel(): void {
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './ormorgall-level-two-org-pickup-view.less';
</style>