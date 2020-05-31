
<template>
<div class="view-container deredirectview pimtypecontractredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimtypecontractredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimTypeContractService from '@/service/pim-type-contract/pim-type-contract-service';


import UIService from '@/uiservice/ui-service';


/**
 * 合同类型数据重定向视图基类
 *
 * @export
 * @class PIMTYPECONTRACTRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMTYPECONTRACTRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimTypeContractService}
     * @memberof PIMTYPECONTRACTRedirectViewBase
     */
    public appEntityService: PimTypeContractService = new PimTypeContractService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMTYPECONTRACTRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMTYPECONTRACTRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMTYPECONTRACTRedirectViewBase
	 */
	public viewtag: string = '900f6d253620ef1d48d8cfb5d5544a48';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMTYPECONTRACTRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMTYPECONTRACTRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMTYPECONTRACTRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMTYPECONTRACTRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimtypecontract.views.redirectview.caption',
        srfTitle: 'entities.pimtypecontract.views.redirectview.title',
        srfSubTitle: 'entities.pimtypecontract.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMTYPECONTRACTRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMTYPECONTRACTRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMTYPECONTRACTRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMTYPECONTRACTRedirectViewBase
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
     * @memberof PIMTYPECONTRACTRedirectViewBase
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
@import './pimtypecontractredirect-view.less';
</style>