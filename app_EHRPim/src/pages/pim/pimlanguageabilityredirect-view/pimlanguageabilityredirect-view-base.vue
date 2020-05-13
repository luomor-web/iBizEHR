
<template>
<div class="view-container deredirectview pimlanguageabilityredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimlanguageabilityredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PIMLANGUAGEABILITYService from '@/service/pimlanguageability/pimlanguageability-service';


import UIService from '@/uiservice/ui-service';


/**
 * 语言能力数据重定向视图基类
 *
 * @export
 * @class PIMLANGUAGEABILITYRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMLANGUAGEABILITYRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PIMLANGUAGEABILITYService}
     * @memberof PIMLANGUAGEABILITYRedirectViewBase
     */
    public appEntityService: PIMLANGUAGEABILITYService = new PIMLANGUAGEABILITYService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMLANGUAGEABILITYRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMLANGUAGEABILITYRedirectViewBase
	 */
	public viewtag: string = '1c019f22b42bcf349089d90bbccc5e3d';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMLANGUAGEABILITYRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMLANGUAGEABILITYRedirectViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMLANGUAGEABILITYRedirectViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMLANGUAGEABILITYRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimlanguageability.views.redirectview.caption',
        srfTitle: 'entities.pimlanguageability.views.redirectview.title',
        srfSubTitle: 'entities.pimlanguageability.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMLANGUAGEABILITYRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMLANGUAGEABILITYRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @protected
     * @memberof PIMLANGUAGEABILITYRedirectViewBase
     */
    protected engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMLANGUAGEABILITYRedirectViewBase
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
     * @memberof PIMLANGUAGEABILITYRedirectViewBase
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
@import './pimlanguageabilityredirect-view.less';
</style>