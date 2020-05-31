
<template>
<div class="view-container deredirectview pimperson-ability-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimpersonabilityredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimPersonAbilityService from '@/service/pim-person-ability/pim-person-ability-service';


import UIService from '@/uiservice/ui-service';


/**
 * 员工能力数据重定向视图基类
 *
 * @export
 * @class PIMPersonAbilityRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMPersonAbilityRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimPersonAbilityService}
     * @memberof PIMPersonAbilityRedirectViewBase
     */
    public appEntityService: PimPersonAbilityService = new PimPersonAbilityService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMPersonAbilityRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMPersonAbilityRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMPersonAbilityRedirectViewBase
	 */
	public viewtag: string = '65d8de4ae87e9b1fb24c674a215eb8e6';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMPersonAbilityRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMPersonAbilityRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMPersonAbilityRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMPersonAbilityRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimpersonability.views.redirectview.caption',
        srfTitle: 'entities.pimpersonability.views.redirectview.title',
        srfSubTitle: 'entities.pimpersonability.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMPersonAbilityRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMPersonAbilityRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMPersonAbilityRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMPersonAbilityRedirectViewBase
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
     * @memberof PIMPersonAbilityRedirectViewBase
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
@import './pimperson-ability-redirect-view.less';
</style>