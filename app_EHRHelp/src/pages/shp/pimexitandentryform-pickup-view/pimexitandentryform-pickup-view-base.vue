<template>
  <app-layout viewName="pimexitandentryformpickupview" viewTitle="出入境管理数据选择视图" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'depickupview': true, 'pimexitandentryform-pickup-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
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
import PimExitandentryService from '@/service/pim-exitandentry/pim-exitandentry-service';

import PickupViewEngine from '@engine/view/pickup-view-engine';


/**
 * 出入境管理数据选择视图基类
 *
 * @export
 * @class PIMEXITANDENTRYFormPickupViewBase
 * @extends {PickupViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMEXITANDENTRYFormPickupViewBase extends PickupViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimExitandentryService}
     * @memberof PIMEXITANDENTRYFormPickupViewBase
     */
    public appEntityService: PimExitandentryService = new PimExitandentryService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMEXITANDENTRYFormPickupViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMEXITANDENTRYFormPickupViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMEXITANDENTRYFormPickupViewBase
	 */
	public viewtag: string = '6b4343785d96d91df5085d7821b3927e';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMEXITANDENTRYFormPickupViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMEXITANDENTRYFormPickupViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMEXITANDENTRYFormPickupViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMEXITANDENTRYFormPickupViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimexitandentry.views.formpickupview.caption',
        srfTitle: 'entities.pimexitandentry.views.formpickupview.title',
        srfSubTitle: 'entities.pimexitandentry.views.formpickupview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMEXITANDENTRYFormPickupViewBase
     */
    public containerModel: any = {
        view_okbtn: { name: 'okbtn', type: 'button', text: '确定', disabled: true },
        view_cancelbtn: { name: 'cancelbtn', type: 'button', text: '取消', disabled: false },
        view_leftbtn: { name: 'leftbtn', type: 'button', text: '左移', disabled: true },
        view_rightbtn: { name: 'rightbtn', type: 'button', text: '右移', disabled: true },
        view_allleftbtn: { name: 'allleftbtn', type: 'button', text: '全部左移', disabled: true },
        view_allrightbtn: { name: 'allrightbtn', type: 'button', text: '全部右移', disabled: true },
        wflinks: [],
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMEXITANDENTRYFormPickupViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PIMEXITANDENTRYFormPickupViewBase
     */
    public engine: PickupViewEngine = new PickupViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMEXITANDENTRYFormPickupViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            keyPSDEField: 'pimexitandentry',
            majorPSDEField: 'pimexitandentryname',
            isLoadDefault: true,
        });
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMEXITANDENTRYFormPickupViewBase
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
     * @memberof PIMEXITANDENTRYFormPickupViewBase
     */
    public selectedData: string = "";

    /**
     * 视图选中数据
     *
     * @type {any[]}
     * @memberof PIMEXITANDENTRYFormPickupView
     */
    public viewSelections:any[] = [];

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof PIMEXITANDENTRYFormPickupView
     */
    @Prop({default: true}) public isShowButton!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof PIMEXITANDENTRYFormPickupView
     */
    public isSingleSelect: boolean = true;

    /**
     * 视图参数变更
     *
     * @protected
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof PIMEXITANDENTRYFormPickupView
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
     * @memberof PIMEXITANDENTRYFormPickupView
     */
    protected viewMounted(): void {
        if(this.viewparams.selectedData){
            this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', this.viewparams.selectedData);
        }
    }

    /**
     * 确定
     *
     * @memberof PIMEXITANDENTRYFormPickupView
     */
    public onClickOk(): void {
        this.$emit('viewdataschange', this.viewSelections);
        this.$emit('close', null);
    }

    /**
     * 取消
     *
     * @memberof PIMEXITANDENTRYFormPickupView
     */
    public onClickCancel(): void {
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './pimexitandentryform-pickup-view.less';
</style>