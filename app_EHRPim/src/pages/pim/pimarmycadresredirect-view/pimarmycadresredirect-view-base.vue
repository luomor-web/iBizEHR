
<template>
<div class="view-container deredirectview pimarmycadresredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimarmycadresredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimArmycadresService from '@/service/pim-armycadres/pim-armycadres-service';


import UIService from '@/uiservice/ui-service';


/**
 * 军转干部数据重定向视图基类
 *
 * @export
 * @class PIMARMYCADRESRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMARMYCADRESRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimArmycadresService}
     * @memberof PIMARMYCADRESRedirectViewBase
     */
    public appEntityService: PimArmycadresService = new PimArmycadresService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMARMYCADRESRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMARMYCADRESRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMARMYCADRESRedirectViewBase
	 */
	public viewtag: string = '65666d5f1faaf5338ad9bb8dd33eb644';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMARMYCADRESRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMARMYCADRESRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMARMYCADRESRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMARMYCADRESRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimarmycadres.views.redirectview.caption',
        srfTitle: 'entities.pimarmycadres.views.redirectview.title',
        srfSubTitle: 'entities.pimarmycadres.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMARMYCADRESRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMARMYCADRESRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMARMYCADRESRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMARMYCADRESRedirectViewBase
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
     * @memberof PIMARMYCADRESRedirectViewBase
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
@import './pimarmycadresredirect-view.less';
</style>