
<template>
<div class="view-container deredirectview pimresearchfindingsredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimresearchfindingsredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimResearchFindingsService from '@/service/pim-research-findings/pim-research-findings-service';


import UIService from '@/uiservice/ui-service';


/**
 * 科研成果数据重定向视图基类
 *
 * @export
 * @class PIMRESEARCHFINDINGSRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMRESEARCHFINDINGSRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimResearchFindingsService}
     * @memberof PIMRESEARCHFINDINGSRedirectViewBase
     */
    public appEntityService: PimResearchFindingsService = new PimResearchFindingsService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMRESEARCHFINDINGSRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMRESEARCHFINDINGSRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMRESEARCHFINDINGSRedirectViewBase
	 */
	public viewtag: string = 'd914a6f2f5bb02ac70cd225e69d8ee4c';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMRESEARCHFINDINGSRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMRESEARCHFINDINGSRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMRESEARCHFINDINGSRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMRESEARCHFINDINGSRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimresearchfindings.views.redirectview.caption',
        srfTitle: 'entities.pimresearchfindings.views.redirectview.title',
        srfSubTitle: 'entities.pimresearchfindings.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMRESEARCHFINDINGSRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMRESEARCHFINDINGSRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMRESEARCHFINDINGSRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMRESEARCHFINDINGSRedirectViewBase
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
     * @memberof PIMRESEARCHFINDINGSRedirectViewBase
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
@import './pimresearchfindingsredirect-view.less';
</style>