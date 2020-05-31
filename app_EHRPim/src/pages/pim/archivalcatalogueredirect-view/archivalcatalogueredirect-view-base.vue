
<template>
<div class="view-container deredirectview archivalcatalogueredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="archivalcatalogueredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimArchivalCatalogueService from '@/service/pim-archival-catalogue/pim-archival-catalogue-service';


import UIService from '@/uiservice/ui-service';


/**
 * 档案目录数据重定向视图基类
 *
 * @export
 * @class ARCHIVALCATALOGUERedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ARCHIVALCATALOGUERedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimArchivalCatalogueService}
     * @memberof ARCHIVALCATALOGUERedirectViewBase
     */
    public appEntityService: PimArchivalCatalogueService = new PimArchivalCatalogueService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ARCHIVALCATALOGUERedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ARCHIVALCATALOGUERedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ARCHIVALCATALOGUERedirectViewBase
	 */
	public viewtag: string = '7fc157542aabc5fefbe82f0915e7f8fc';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ARCHIVALCATALOGUERedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ARCHIVALCATALOGUERedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ARCHIVALCATALOGUERedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ARCHIVALCATALOGUERedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimarchivalcatalogue.views.redirectview.caption',
        srfTitle: 'entities.pimarchivalcatalogue.views.redirectview.title',
        srfSubTitle: 'entities.pimarchivalcatalogue.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ARCHIVALCATALOGUERedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ARCHIVALCATALOGUERedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ARCHIVALCATALOGUERedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ARCHIVALCATALOGUERedirectViewBase
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
     * @memberof ARCHIVALCATALOGUERedirectViewBase
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
@import './archivalcatalogueredirect-view.less';
</style>