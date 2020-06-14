<template>
  <app-layout viewName="pcmydtxmxmpickupview" viewTitle="异动病休明细数据多项选择视图" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'dempickupview': true, 'pcm-ydtxmx-mpickup-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
                <div class="content-container pickup-view">
            <div class="translate-contant">
                <div class="center">
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
                </div>
                <div class="translate-buttons">
                    <div class="buttons">
                        <i-button type="primary" :title="this.containerModel.view_rightbtn.text"
                            :disabled="this.containerModel.view_rightbtn.disabled"
                            @click="onCLickRight">
                            <i class="el-icon-arrow-right"></i>
                        </i-button>
                        <i-button type="primary" :title="this.containerModel.view_leftbtn.text"
                            :disabled="this.containerModel.view_leftbtn.disabled"
                            @click="onCLickLeft">
                            <i class="el-icon-arrow-left"></i>
                        </i-button>
                        <i-button type="primary" :title="this.containerModel.view_allrightbtn.text"
                            @click="onCLickAllRight">
                            <i class="el-icon-d-arrow-right"></i>
                        </i-button>
                        <i-button type="primary" :title="this.containerModel.view_allleftbtn.text"
                            @click="onCLickAllLeft">
                            <i class="el-icon-d-arrow-left"></i>
                        </i-button>
                    </div>
                </div>
                <div class="right">
                    <div class="mpicker-select">
                        <div v-for="(item, index) in viewSelections" :key="index" :class="item._select ? 'select' : ''" @click="selectionsClick(item)" @dblclick="selectionsDBLClick(item)">
                            <span>{{item.srfmajortext}}</span>
                        </div>
                    </div>
                </div>
            </div>
             <card :dis-hover="true" :bordered="false" class="footer">
                <row :style="{ textAlign: 'right' }">
                    <i-button type="primary"  :disabled="this.viewSelections.length > 0 ? false : true" @click="onClickOk">{{this.containerModel.view_okbtn.text}}</i-button>
                        &nbsp;&nbsp;
                    <i-button @click="onClickCancel">{{this.containerModel.view_cancelbtn.text}}</i-button>
                </row>
            </card>
        </div>

      </div>
    </template>
  </app-layout>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, MPickupViewBase } from '@/crm-core';
import PcmYdtxmxService from '@/service/pcm-ydtxmx/pcm-ydtxmx-service';

import MPickupViewEngine from '@engine/view/mpickup-view-engine';


/**
 * 异动病休明细数据多项选择视图基类
 *
 * @export
 * @class PcmYdtxmxMPickupViewBase
 * @extends {MPickupViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmYdtxmxMPickupViewBase extends MPickupViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmYdtxmxService}
     * @memberof PcmYdtxmxMPickupViewBase
     */
    public appEntityService: PcmYdtxmxService = new PcmYdtxmxService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmYdtxmxMPickupViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmYdtxmxMPickupViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmYdtxmxMPickupViewBase
	 */
	public viewtag: string = '2b8da8bc55d6bd7d631cb03f3f8bbee1';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmYdtxmxMPickupViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmYdtxmxMPickupViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmYdtxmxMPickupViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmYdtxmxMPickupViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmydtxmx.views.mpickupview.caption',
        srfTitle: 'entities.pcmydtxmx.views.mpickupview.title',
        srfSubTitle: 'entities.pcmydtxmx.views.mpickupview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmYdtxmxMPickupViewBase
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
     * @memberof PcmYdtxmxMPickupViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof PcmYdtxmxMPickupViewBase
     */
    public engine: MPickupViewEngine = new MPickupViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmYdtxmxMPickupViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            pickupviewpanel: this.$refs.pickupviewpanel,
            keyPSDEField: 'pcmydtxmx',
            majorPSDEField: 'pcmydtxmxname',
            isLoadDefault: true,
        });
    }


    /**
     * pickupviewpanel 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmYdtxmxMPickupViewBase
     */
    public pickupviewpanel_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', $event);
    }


    /**
     * pickupviewpanel 部件 activated 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmYdtxmxMPickupViewBase
     */
    public pickupviewpanel_activated($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'activated', $event);
    }


    /**
     * pickupviewpanel 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof PcmYdtxmxMPickupViewBase
     */
    public pickupviewpanel_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'load', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof PcmYdtxmxMPickupViewBase
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
     * 视图选中数据
     *
     * @type {any[]}
     * @memberof PcmYdtxmxMPickupView
     */
    public viewSelections:any[] = [];

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof PcmYdtxmxMPickupView
     */
    @Prop({default: true}) public isShowButton!: boolean;
    
    /**
     * 选中数据的字符串
     *
     * @type {string}
     * @memberof PcmYdtxmxMPickupView
     */
    public selectedData: string = "";

    /**
     * 是否初始化已选中项
     *
     * @type {any[]}
     * @memberof PcmYdtxmxMPickupView
     */
    public isInitSelected:boolean = false;
    
    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof PcmYdtxmxMPickupView
     */
    public isSingleSelect: boolean = false;

    /**
     * 视图参数变更
     *
     * @protected
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof PcmYdtxmxMPickupView
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
     * @memberof PcmYdtxmxMPickupView
     */
    protected viewMounted(): void {
        if(this.viewparams.selectedData){
            this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', this.viewparams.selectedData);
            this.onCLickRight();
        }
    }

    /**
     * 选中数据单击
     *
     * @param {*} item
     * @memberof PcmYdtxmxMPickupView
     */
    public selectionsClick(item:any):void {
        item._select = !item._select;
        const removeSelect: boolean = this.viewSelections.some((selection: any) => selection._select);
        this.containerModel.view_leftbtn.disabled = !removeSelect;
    }

    /**
     * 选中树双击
     *
     * @param {*} item
     * @memberof PcmYdtxmxMPickupView
     */
    public selectionsDBLClick(item:any):void {
        const index: number = this.viewSelections.findIndex((selection: any) => Object.is(selection.srfkey, item.srfkey));
        if (index !== -1) {
            this.viewSelections.splice(index, 1);
        }
        const removeSelect: boolean = this.viewSelections.some((selection: any) => selection._select);
        this.containerModel.view_leftbtn.disabled = !removeSelect;
        this.selectedData = JSON.stringify(this.viewSelections);
    }

    /**
     * 删除右侧全部选中数据
     *
     * @memberof PcmYdtxmxMPickupView
     */
    public onCLickLeft():void {
        const _selectiions = [...JSON.parse(JSON.stringify(this.viewSelections))];
        _selectiions.forEach((item: any) => {
            if (!item._select) {
                return;
            }
            const index = this.viewSelections.findIndex((selection: any) => Object.is(item.srfkey, selection.srfkey));
            if (index !== -1) {
                this.viewSelections.splice(index, 1);
            }
        });
        const removeSelect: boolean = this.viewSelections.some((selection: any) => selection._select);
        this.containerModel.view_leftbtn.disabled = !removeSelect;
        this.selectedData = JSON.stringify(this.viewSelections);
    }

    /**
     * 添加左侧选中数据
     *
     * @memberof PcmYdtxmxMPickupView
     */
    public onCLickRight():void {
        Object.values(this.containerModel).forEach((model: any) => {
            if (!Object.is(model.type, 'PICKUPVIEWPANEL')) {
                return;
            }
            let newSelections:any[] = [];
            model.selections.forEach((item: any) => {
                const index: number = this.viewSelections.findIndex((selection: any) => Object.is(item.srfkey, selection.srfkey));
                if (index === -1) {
                    let _item: any = { ...JSON.parse(JSON.stringify(item)) };
                    Object.assign(_item, { _select: false })
                    newSelections.push(_item);
                }else{
                    newSelections.push(this.viewSelections[index]);
                }
            });
            this.viewSelections = newSelections;
        });
        this.selectedData = JSON.stringify(this.viewSelections);
    }

    /**
     * 选中数据全部删除
     *
     * @memberof PcmYdtxmxMPickupView
     */
    public onCLickAllLeft():void {
        this.viewSelections = [];
        this.containerModel.view_leftbtn.disabled = true;
        this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', []);
        this.selectedData = JSON.stringify(this.viewSelections);
    }

    /**
     * 添加左侧面板所有数据到右侧
     *
     * @memberof PcmYdtxmxMPickupView
     */
    public onCLickAllRight():void {
        Object.values(this.containerModel).forEach((model: any) => {
            if (!Object.is(model.type, 'PICKUPVIEWPANEL')) {
                return;
            }
            if(model.datas.length>0){
                model.datas.forEach((data:any,index:any)=>{
                    Object.assign(data,{srfmajortext: data['pcmydtxmxname']});
                })
            }
            model.datas.forEach((item: any) => {
                const index: number = this.viewSelections.findIndex((selection: any) => Object.is(item.srfkey, selection.srfkey));
                if (index === -1) {
                    let _item: any = { ...JSON.parse(JSON.stringify(item)) };
                    Object.assign(_item, { _select: false })
                    this.viewSelections.push(_item);
                }
            });
        });
        this.selectedData = JSON.stringify(this.viewSelections);
    }

    /**
     * 确定
     *
     * @memberof PcmYdtxmxMPickupView
     */
    public onClickOk(): void {
        this.$emit('viewdataschange', this.viewSelections);
        this.$emit('close', null);
    }

    /**
     * 取消
     *
     * @memberof PcmYdtxmxMPickupView
     */
    public onClickCancel(): void {
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './pcm-ydtxmx-mpickup-view.less';
</style>