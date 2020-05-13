<template>
  <app-layout viewName="pimsearchfieldsetcomplexsearchcustomview" viewTitle="组合查询" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'decustomview': true, 'pim-search-field-set-com-plex-search-custom-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
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
import PimSearchFieldSetService from '@/service/pim-search-field-set/pim-search-field-set-service';



/**
 * 组合查询基类
 *
 * @export
 * @class PimSearchFieldSetComPlexSearchCustomViewBase
 * @extends {Vue}
 */
@Component({})
@VueLifeCycleProcessing
export default class PimSearchFieldSetComPlexSearchCustomViewBase extends Vue {

    /**
     * 实体服务对象
     *
     * @type {PimSearchFieldSetService}
     * @memberof PimSearchFieldSetComPlexSearchCustomViewBase
     */
    public appEntityService: PimSearchFieldSetService = new PimSearchFieldSetService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PimSearchFieldSetComPlexSearchCustomViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PimSearchFieldSetComPlexSearchCustomViewBase
	 */
	public viewtag: string = '561f02d608b8733d9d358e17dae644c0';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PimSearchFieldSetComPlexSearchCustomViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PimSearchFieldSetComPlexSearchCustomViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PimSearchFieldSetComPlexSearchCustomViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PimSearchFieldSetComPlexSearchCustomViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimsearchfieldset.views.complexsearchcustomview.caption',
        srfTitle: 'entities.pimsearchfieldset.views.complexsearchcustomview.title',
        srfSubTitle: 'entities.pimsearchfieldset.views.complexsearchcustomview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PimSearchFieldSetComPlexSearchCustomViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof PimSearchFieldSetComPlexSearchCustomViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @protected
     * @memberof PimSearchFieldSetComPlexSearchCustomViewBase
     */
    protected engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PimSearchFieldSetComPlexSearchCustomViewBase
     */
    public destroyed(){
    }

}
</script>

<style lang='less'>
@import './pim-search-field-set-com-plex-search-custom-view.less';
</style>