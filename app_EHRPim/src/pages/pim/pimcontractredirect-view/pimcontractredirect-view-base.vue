
<template>
<div class="view-container deredirectview pimcontractredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimcontractredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimContractService from '@/service/pim-contract/pim-contract-service';


import UIService from '@/uiservice/ui-service';


/**
 * 合同信息数据重定向视图基类
 *
 * @export
 * @class PIMCONTRACTRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMCONTRACTRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimContractService}
     * @memberof PIMCONTRACTRedirectViewBase
     */
    public appEntityService: PimContractService = new PimContractService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMCONTRACTRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMCONTRACTRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMCONTRACTRedirectViewBase
	 */
	public viewtag: string = '8b8c482e363815008539658f7a9c53e3';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMCONTRACTRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMCONTRACTRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMCONTRACTRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMCONTRACTRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimcontract.views.redirectview.caption',
        srfTitle: 'entities.pimcontract.views.redirectview.title',
        srfSubTitle: 'entities.pimcontract.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMCONTRACTRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMCONTRACTRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMCONTRACTRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMCONTRACTRedirectViewBase
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
     * @memberof PIMCONTRACTRedirectViewBase
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
@import './pimcontractredirect-view.less';
</style>