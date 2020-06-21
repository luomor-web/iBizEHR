
<template>
  <app-layout viewName="trmtrainagencytabexpview" viewTitle="培训机构相关" :isShowCaptionBar="false" :isShowToolbar="false" :className="{ 'view-container': true, 'default-mode-view': true, 'detabexpview': true, 'trm-train-agency-tab-exp-view': true }" layoutMode="VIEW" :isShowUserInfo="isDefaultView()" :openMode="openMode" @close-view="closeView($event)">
    <template slot="headerLeft">
      <div class="view-header-left">

        <div class="view-caption" v-if="isDefaultView()">{{$t(model.srfCaption)}}</div>
        <modal-breadcrumb v-if="isModalView()"/>
      </div>
    </template>
    <template slot="content">
      <div class="view-content-wrapper">
        <view_tabexppanel 
    :viewState="viewState"  
    :viewparams="viewparams" 
    :context="context" 
    name="tabexppanel"  
    ref='tabexppanel' 
    @closeview="closeView($event)">
</view_tabexppanel>

      </div>
    </template>
  </app-layout>

</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, TabExpViewBase } from '@/crm-core';
import TrmTrainAgencyService from '@/service/trm-train-agency/trm-train-agency-service';

import TabExpViewEngine from '@engine/view/tab-exp-view-engine';


/**
 * 培训机构相关基类
 *
 * @export
 * @class TrmTrainAgencyTabExpViewBase
 * @extends {TabExpViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class TrmTrainAgencyTabExpViewBase extends TabExpViewBase {

    /**
     * 实体服务对象
     *
     * @type {TrmTrainAgencyService}
     * @memberof TrmTrainAgencyTabExpViewBase
     */
    public appEntityService: TrmTrainAgencyService = new TrmTrainAgencyService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof TrmTrainAgencyTabExpViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof TrmTrainAgencyTabExpViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof TrmTrainAgencyTabExpViewBase
	 */
	public viewtag: string = 'e3e00a371d740be659600f4165e2d737';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof TrmTrainAgencyTabExpViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof TrmTrainAgencyTabExpViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof TrmTrainAgencyTabExpViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof TrmTrainAgencyTabExpViewBase
     */
    public model: any = {
        srfCaption: 'entities.trmtrainagency.views.tabexpview.caption',
        srfTitle: 'entities.trmtrainagency.views.tabexpview.title',
        srfSubTitle: 'entities.trmtrainagency.views.tabexpview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof TrmTrainAgencyTabExpViewBase
     */
    public containerModel: any = {
        view_tabexppanel: { name: 'tabexppanel', type: 'TABEXPPANEL' },
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof TrmTrainAgencyTabExpViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof TrmTrainAgencyTabExpViewBase
     */
    public engine: TabExpViewEngine = new TabExpViewEngine();
	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof TrmTrainAgencyTabExpViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            keyPSDEField: 'trmtrainagency',
            majorPSDEField: 'trmtrainagencyname',
            isLoadDefault: true,
        });
    }





    /**
     * 销毁视图回调
     *
     * @memberof TrmTrainAgencyTabExpViewBase
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

}
</script>

<style lang='less'>
@import './trm-train-agency-tab-exp-view.less';
</style>