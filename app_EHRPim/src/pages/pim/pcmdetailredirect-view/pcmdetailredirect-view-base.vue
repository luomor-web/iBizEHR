
<template>
<div class="view-container deredirectview pcmdetailredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pcmdetailredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PcmDetailService from '@/service/pcm-detail/pcm-detail-service';


import UIService from '@/uiservice/ui-service';


/**
 * 人员明细表数据重定向视图基类
 *
 * @export
 * @class PCMDETAILRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PCMDETAILRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmDetailService}
     * @memberof PCMDETAILRedirectViewBase
     */
    public appEntityService: PcmDetailService = new PcmDetailService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PCMDETAILRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PCMDETAILRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PCMDETAILRedirectViewBase
	 */
	public viewtag: string = 'fe36e01368dc1faab06e9c03ff5bab6c';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PCMDETAILRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PCMDETAILRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PCMDETAILRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PCMDETAILRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmdetail.views.redirectview.caption',
        srfTitle: 'entities.pcmdetail.views.redirectview.title',
        srfSubTitle: 'entities.pcmdetail.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PCMDETAILRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PCMDETAILRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PCMDETAILRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PCMDETAILRedirectViewBase
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
     * 初始化视图
     *
     * @memberof PCMDETAILRedirectViewBase
     */    
    public async viewInit(){
        const {srfkey:srfkey,srfappde:srfappde} = this.viewparams;
        const uiService:UIService = new UIService();
        const targetService:any = await uiService.getService(srfappde.toLowerCase());
        targetService.getRDAppView(srfkey,true).then((res:any) =>{
            if(res && res.viewname && res.srfappde){
                const path:string =`/${res.srfappde}/${srfkey}/${res.viewname}`;
                this.$router.push({path:path});
            }else{
                console.error("未查找到重定向视图")
            }
        })
    }


}
</script>

<style lang='less'>
@import './pcmdetailredirect-view.less';
</style>