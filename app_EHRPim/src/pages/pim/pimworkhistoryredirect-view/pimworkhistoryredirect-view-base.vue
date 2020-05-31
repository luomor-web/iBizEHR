
<template>
<div class="view-container deredirectview pimworkhistoryredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimworkhistoryredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimWorkHistoryService from '@/service/pim-work-history/pim-work-history-service';


import UIService from '@/uiservice/ui-service';


/**
 * 工作履历数据重定向视图基类
 *
 * @export
 * @class PIMWORKHISTORYRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMWORKHISTORYRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimWorkHistoryService}
     * @memberof PIMWORKHISTORYRedirectViewBase
     */
    public appEntityService: PimWorkHistoryService = new PimWorkHistoryService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMWORKHISTORYRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMWORKHISTORYRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMWORKHISTORYRedirectViewBase
	 */
	public viewtag: string = '0a71d00c555b79769fe55bc9387c367e';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMWORKHISTORYRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMWORKHISTORYRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMWORKHISTORYRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMWORKHISTORYRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimworkhistory.views.redirectview.caption',
        srfTitle: 'entities.pimworkhistory.views.redirectview.title',
        srfSubTitle: 'entities.pimworkhistory.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMWORKHISTORYRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMWORKHISTORYRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMWORKHISTORYRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMWORKHISTORYRedirectViewBase
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
     * @memberof PIMWORKHISTORYRedirectViewBase
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
@import './pimworkhistoryredirect-view.less';
</style>