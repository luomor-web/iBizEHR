<template>
  <app-layout viewName="ormorgsectormpickupview" viewTitle="部门管理数据多项选择视图" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'dempickupview': true, 'ormorgsectormpickup-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import ORMORGSECTORService from '@/service/ormorgsector/ormorgsector-service';

import MPickupViewEngine from '@engine/view/mpickup-view-engine';


/**
 * 部门管理数据多项选择视图基类
 *
 * @export
 * @class ORMORGSECTORMPickupViewBase
 * @extends {MPickupViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMORGSECTORMPickupViewBase extends MPickupViewBase {

    /**
     * 实体服务对象
     *
     * @type {ORMORGSECTORService}
     * @memberof ORMORGSECTORMPickupViewBase
     */
    public appEntityService: ORMORGSECTORService = new ORMORGSECTORService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMORGSECTORMPickupViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMORGSECTORMPickupViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMORGSECTORMPickupViewBase
	 */
	public viewtag: string = '0e46f8be3d5e20ad6335a555f1980a61';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMORGSECTORMPickupViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMORGSECTORMPickupViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMORGSECTORMPickupViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMORGSECTORMPickupViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormorgsector.views.mpickupview.caption',
        srfTitle: 'entities.ormorgsector.views.mpickupview.title',
        srfSubTitle: 'entities.ormorgsector.views.mpickupview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMORGSECTORMPickupViewBase
     */
    public containerModel: any = {
        view_pickupviewpanel: { name: 'pickupviewpanel', type: 'PICKUPVIEWPANEL' },
        view_searchform: { name: 'searchform', type: 'SEARCHFORM' },
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
     * @memberof ORMORGSECTORMPickupViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof ORMORGSECTORMPickupViewBase
     */
    public engine: MPickupViewEngine = new MPickupViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMORGSECTORMPickupViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            pickupviewpanel: this.$refs.pickupviewpanel,
            keyPSDEField: 'ormorgsector',
            majorPSDEField: 'orgsectorname',
            isLoadDefault: true,
        });
    }


    /**
     * pickupviewpanel 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ORMORGSECTORMPickupViewBase
     */
    public pickupviewpanel_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', $event);
    }


    /**
     * pickupviewpanel 部件 activated 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ORMORGSECTORMPickupViewBase
     */
    public pickupviewpanel_activated($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'activated', $event);
    }


    /**
     * pickupviewpanel 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ORMORGSECTORMPickupViewBase
     */
    public pickupviewpanel_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'load', $event);
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMORGSECTORMPickupViewBase
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
     * @memberof ORMORGSECTORMPickupView
     */
    public viewSelections:any[] = [];

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof ORMORGSECTORMPickupView
     */
    @Prop({default: true}) public isShowButton!: boolean;
    
    /**
     * 选中数据的字符串
     *
     * @type {string}
     * @memberof ORMORGSECTORMPickupView
     */
    public selectedData: string = "";

    /**
     * 是否初始化已选中项
     *
     * @type {any[]}
     * @memberof ORMORGSECTORMPickupView
     */
    public isInitSelected:boolean = false;
    
    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof ORMORGSECTORMPickupView
     */
    public isSingleSelect: boolean = false;

    /**
     * 视图参数变更
     *
     * @protected
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ORMORGSECTORMPickupView
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
     * @memberof ORMORGSECTORMPickupView
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
     * @memberof ORMORGSECTORMPickupView
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
     * @memberof ORMORGSECTORMPickupView
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
     * @memberof ORMORGSECTORMPickupView
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
     * @memberof ORMORGSECTORMPickupView
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
    }

    /**
     * 选中数据全部删除
     *
     * @memberof ORMORGSECTORMPickupView
     */
    public onCLickAllLeft():void {
        this.viewSelections = [];
        this.containerModel.view_leftbtn.disabled = true;
        this.selectedData = JSON.stringify(this.viewSelections);
    }

    /**
     * 添加左侧面板所有数据到右侧
     *
     * @memberof ORMORGSECTORMPickupView
     */
    public onCLickAllRight():void {
        Object.values(this.containerModel).forEach((model: any) => {
            if (!Object.is(model.type, 'PICKUPVIEWPANEL')) {
                return;
            }
            if(model.datas.length>0){
                model.datas.forEach((data:any,index:any)=>{
                    Object.assign(data,{srfmajortext: data['orgsectorname']});
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
    }

    /**
     * 确定
     *
     * @memberof ORMORGSECTORMPickupView
     */
    public onClickOk(): void {
        this.$emit('viewdataschange', this.viewSelections);
        this.$emit('close', null);
    }

    /**
     * 取消
     *
     * @memberof ORMORGSECTORMPickupView
     */
    public onClickCancel(): void {
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './ormorgsectormpickup-view.less';
</style>