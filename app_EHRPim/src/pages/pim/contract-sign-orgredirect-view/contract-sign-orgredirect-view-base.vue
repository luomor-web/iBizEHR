
<template>
<div class="view-container deredirectview contract-sign-orgredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="contractsignorgredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimContractSignOrgService from '@/service/pim-contract-sign-org/pim-contract-sign-org-service';


import UIService from '@/uiservice/ui-service';


/**
 * 签约主体单位数据重定向视图基类
 *
 * @export
 * @class ContractSignORGRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ContractSignORGRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimContractSignOrgService}
     * @memberof ContractSignORGRedirectViewBase
     */
    public appEntityService: PimContractSignOrgService = new PimContractSignOrgService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ContractSignORGRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ContractSignORGRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ContractSignORGRedirectViewBase
	 */
	public viewtag: string = 'daad0739d561a4bfde57e4cf39d337a9';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ContractSignORGRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ContractSignORGRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ContractSignORGRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ContractSignORGRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimcontractsignorg.views.redirectview.caption',
        srfTitle: 'entities.pimcontractsignorg.views.redirectview.title',
        srfSubTitle: 'entities.pimcontractsignorg.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ContractSignORGRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ContractSignORGRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ContractSignORGRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ContractSignORGRedirectViewBase
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
     * @memberof ContractSignORGRedirectViewBase
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
@import './contract-sign-orgredirect-view.less';
</style>