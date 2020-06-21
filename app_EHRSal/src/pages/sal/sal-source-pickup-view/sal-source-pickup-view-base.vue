<template>
  <app-layout viewName="salsourcepickupview" viewTitle="薪酬计算源数据选择视图" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'depickupview': true, 'sal-source-pickup-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
                :openMode="openMode"
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
import SalSourceService from '@/service/sal-source/sal-source-service';

import PickupViewEngine from '@engine/view/pickup-view-engine';


/**
 * 薪酬计算源数据选择视图基类
 *
 * @export
 * @class SalSourcePickupViewBase
 * @extends {PickupViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class SalSourcePickupViewBase extends PickupViewBase {

    /**
     * 实体服务对象
     *
     * @type {SalSourceService}
     * @memberof SalSourcePickupViewBase
     */
    public appEntityService: SalSourceService = new SalSourceService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof SalSourcePickupViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof SalSourcePickupViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof SalSourcePickupViewBase
	 */
	public viewtag: string = '58ac9e12f096070e815322949bd7c478';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof SalSourcePickupViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof SalSourcePickupViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof SalSourcePickupViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof SalSourcePickupViewBase
     */
    public model: any = {
        srfCaption: 'entities.salsource.views.pickupview.caption',
        srfTitle: 'entities.salsource.views.pickupview.title',
        srfSubTitle: 'entities.salsource.views.pickupview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof SalSourcePickupViewBase
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
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof SalSourcePickupViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof SalSourcePickupViewBase
     */
    public engine: PickupViewEngine = new PickupViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof SalSourcePickupViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            pickupviewpanel: this.$refs.pickupviewpanel,
            keyPSDEField: 'salsource',
            majorPSDEField: 'salsourcename',
            isLoadDefault: true,
        });
    }


    /**
     * pickupviewpanel 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SalSourcePickupViewBase
     */
    public pickupviewpanel_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', $event);
    }


    /**
     * pickupviewpanel 部件 activated 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SalSourcePickupViewBase
     */
    public pickupviewpanel_activated($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'activated', $event);
    }


    /**
     * pickupviewpanel 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SalSourcePickupViewBase
     */
    public pickupviewpanel_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'load', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof SalSourcePickupViewBase
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
     * @memberof SalSourcePickupViewBase
     */
    public selectedData: string = "";

    /**
     * 视图选中数据
     *
     * @type {any[]}
     * @memberof SalSourcePickupView
     */
    public viewSelections:any[] = [];

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof SalSourcePickupView
     */
    @Prop({default: true}) public isShowButton!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof SalSourcePickupView
     */
    public isSingleSelect: boolean = true;

    /**
     * 视图参数变更
     *
     * @protected
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof SalSourcePickupView
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
     * @memberof SalSourcePickupView
     */
    protected viewMounted(): void {
        if(this.viewparams.selectedData){
            this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', this.viewparams.selectedData);
        }
    }

    /**
     * 确定
     *
     * @memberof SalSourcePickupView
     */
    public onClickOk(): void {
        this.$emit('viewdataschange', this.viewSelections);
        this.$emit('close', null);
    }

    /**
     * 取消
     *
     * @memberof SalSourcePickupView
     */
    public onClickCancel(): void {
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './sal-source-pickup-view.less';
</style>