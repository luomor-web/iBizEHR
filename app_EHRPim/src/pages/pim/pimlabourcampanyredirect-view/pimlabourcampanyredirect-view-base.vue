
<template>
<div class="view-container deredirectview pimlabourcampanyredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimlabourcampanyredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimLabourcampanyService from '@/service/pim-labourcampany/pim-labourcampany-service';


import UIService from '@/uiservice/ui-service';


/**
 * 劳务派遣公司管理数据重定向视图基类
 *
 * @export
 * @class PIMLABOURCAMPANYRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMLABOURCAMPANYRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimLabourcampanyService}
     * @memberof PIMLABOURCAMPANYRedirectViewBase
     */
    public appEntityService: PimLabourcampanyService = new PimLabourcampanyService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMLABOURCAMPANYRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMLABOURCAMPANYRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMLABOURCAMPANYRedirectViewBase
	 */
	public viewtag: string = '9557e0658a255da307e5bb12da12c2c5';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMLABOURCAMPANYRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMLABOURCAMPANYRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMLABOURCAMPANYRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMLABOURCAMPANYRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimlabourcampany.views.redirectview.caption',
        srfTitle: 'entities.pimlabourcampany.views.redirectview.title',
        srfSubTitle: 'entities.pimlabourcampany.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMLABOURCAMPANYRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMLABOURCAMPANYRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMLABOURCAMPANYRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMLABOURCAMPANYRedirectViewBase
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
     * @memberof PIMLABOURCAMPANYRedirectViewBase
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
@import './pimlabourcampanyredirect-view.less';
</style>