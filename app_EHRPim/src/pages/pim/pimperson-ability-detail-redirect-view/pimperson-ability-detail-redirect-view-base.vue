
<template>
<div class="view-container deredirectview pimperson-ability-detail-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimpersonabilitydetailredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimPersonAbilityDetailService from '@/service/pim-person-ability-detail/pim-person-ability-detail-service';


import UIService from '@/uiservice/ui-service';


/**
 * 员工能力明细数据重定向视图基类
 *
 * @export
 * @class PIMPersonAbilityDetailRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMPersonAbilityDetailRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimPersonAbilityDetailService}
     * @memberof PIMPersonAbilityDetailRedirectViewBase
     */
    public appEntityService: PimPersonAbilityDetailService = new PimPersonAbilityDetailService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMPersonAbilityDetailRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMPersonAbilityDetailRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMPersonAbilityDetailRedirectViewBase
	 */
	public viewtag: string = '5d82eae7535225e388c48188353bb36d';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMPersonAbilityDetailRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMPersonAbilityDetailRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMPersonAbilityDetailRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMPersonAbilityDetailRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimpersonabilitydetail.views.redirectview.caption',
        srfTitle: 'entities.pimpersonabilitydetail.views.redirectview.title',
        srfSubTitle: 'entities.pimpersonabilitydetail.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMPersonAbilityDetailRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMPersonAbilityDetailRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMPersonAbilityDetailRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMPersonAbilityDetailRedirectViewBase
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
     * @memberof PIMPersonAbilityDetailRedirectViewBase
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
@import './pimperson-ability-detail-redirect-view.less';
</style>