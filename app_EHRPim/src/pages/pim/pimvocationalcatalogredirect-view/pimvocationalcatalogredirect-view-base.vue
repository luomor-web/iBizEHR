
<template>
<div class="view-container deredirectview pimvocationalcatalogredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimvocationalcatalogredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimVocationalCatalogService from '@/service/pim-vocational-catalog/pim-vocational-catalog-service';


import UIService from '@/uiservice/ui-service';


/**
 * 职（执）业资格目录管理数据重定向视图基类
 *
 * @export
 * @class PIMVOCATIONALCATALOGRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMVOCATIONALCATALOGRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimVocationalCatalogService}
     * @memberof PIMVOCATIONALCATALOGRedirectViewBase
     */
    public appEntityService: PimVocationalCatalogService = new PimVocationalCatalogService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMVOCATIONALCATALOGRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMVOCATIONALCATALOGRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMVOCATIONALCATALOGRedirectViewBase
	 */
	public viewtag: string = '355c1899a4bbdfc4b1dd5651bf4c0fa3';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMVOCATIONALCATALOGRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMVOCATIONALCATALOGRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMVOCATIONALCATALOGRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMVOCATIONALCATALOGRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimvocationalcatalog.views.redirectview.caption',
        srfTitle: 'entities.pimvocationalcatalog.views.redirectview.title',
        srfSubTitle: 'entities.pimvocationalcatalog.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMVOCATIONALCATALOGRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMVOCATIONALCATALOGRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMVOCATIONALCATALOGRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMVOCATIONALCATALOGRedirectViewBase
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
     * @memberof PIMVOCATIONALCATALOGRedirectViewBase
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
@import './pimvocationalcatalogredirect-view.less';
</style>