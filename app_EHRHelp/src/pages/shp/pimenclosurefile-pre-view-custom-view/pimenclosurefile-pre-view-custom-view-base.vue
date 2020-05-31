<template>
  <app-layout viewName="pimenclosurefilepreviewcustomview" viewTitle="表格附件预览" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'decustomview': true, 'pimenclosurefile-pre-view-custom-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
        
      </div>
    </template>
  </app-layout>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing } from '@/crm-core';
import PimEnclosureService from '@/service/pim-enclosure/pim-enclosure-service';



/**
 * 表格附件预览基类
 *
 * @export
 * @class PIMENCLOSUREFilePreViewCustomViewBase
 * @extends {Vue}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMENCLOSUREFilePreViewCustomViewBase extends ViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimEnclosureService}
     * @memberof PIMENCLOSUREFilePreViewCustomViewBase
     */
    public appEntityService: PimEnclosureService = new PimEnclosureService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMENCLOSUREFilePreViewCustomViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMENCLOSUREFilePreViewCustomViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMENCLOSUREFilePreViewCustomViewBase
	 */
	public viewtag: string = 'fed525676864929d0d7b401aa86144d3';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMENCLOSUREFilePreViewCustomViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMENCLOSUREFilePreViewCustomViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMENCLOSUREFilePreViewCustomViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMENCLOSUREFilePreViewCustomViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimenclosure.views.filepreviewcustomview.caption',
        srfTitle: 'entities.pimenclosure.views.filepreviewcustomview.title',
        srfSubTitle: 'entities.pimenclosure.views.filepreviewcustomview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMENCLOSUREFilePreViewCustomViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMENCLOSUREFilePreViewCustomViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMENCLOSUREFilePreViewCustomViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMENCLOSUREFilePreViewCustomViewBase
     */
    public destroyed(){
    }

}
</script>

<style lang='less'>
@import './pimenclosurefile-pre-view-custom-view.less';
</style>