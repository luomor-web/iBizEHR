
<template>
<div class="view-container deredirectview pimexpaccountredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimexpaccountredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimExpaccountService from '@/service/pim-expaccount/pim-expaccount-service';


import UIService from '@/uiservice/ui-service';


/**
 * 费用台账数据重定向视图基类
 *
 * @export
 * @class PIMEXPACCOUNTRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMEXPACCOUNTRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimExpaccountService}
     * @memberof PIMEXPACCOUNTRedirectViewBase
     */
    public appEntityService: PimExpaccountService = new PimExpaccountService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMEXPACCOUNTRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMEXPACCOUNTRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMEXPACCOUNTRedirectViewBase
	 */
	public viewtag: string = 'd5e7597c1af7bc7d6ebf289570809db1';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMEXPACCOUNTRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMEXPACCOUNTRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMEXPACCOUNTRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMEXPACCOUNTRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimexpaccount.views.redirectview.caption',
        srfTitle: 'entities.pimexpaccount.views.redirectview.title',
        srfSubTitle: 'entities.pimexpaccount.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMEXPACCOUNTRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMEXPACCOUNTRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMEXPACCOUNTRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMEXPACCOUNTRedirectViewBase
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
     * @memberof PIMEXPACCOUNTRedirectViewBase
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
@import './pimexpaccountredirect-view.less';
</style>