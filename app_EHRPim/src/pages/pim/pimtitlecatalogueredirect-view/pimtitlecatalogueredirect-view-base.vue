
<template>
<div class="view-container deredirectview pimtitlecatalogueredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimtitlecatalogueredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimTitleCatalogueService from '@/service/pim-title-catalogue/pim-title-catalogue-service';


import UIService from '@/uiservice/ui-service';


/**
 * 职称目录管理数据重定向视图基类
 *
 * @export
 * @class PIMTITLECATALOGUERedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMTITLECATALOGUERedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimTitleCatalogueService}
     * @memberof PIMTITLECATALOGUERedirectViewBase
     */
    public appEntityService: PimTitleCatalogueService = new PimTitleCatalogueService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMTITLECATALOGUERedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMTITLECATALOGUERedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMTITLECATALOGUERedirectViewBase
	 */
	public viewtag: string = 'a52ed72d7d95233b856d450e71ef4fee';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMTITLECATALOGUERedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMTITLECATALOGUERedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMTITLECATALOGUERedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMTITLECATALOGUERedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimtitlecatalogue.views.redirectview.caption',
        srfTitle: 'entities.pimtitlecatalogue.views.redirectview.title',
        srfSubTitle: 'entities.pimtitlecatalogue.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMTITLECATALOGUERedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMTITLECATALOGUERedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMTITLECATALOGUERedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMTITLECATALOGUERedirectViewBase
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
     * @memberof PIMTITLECATALOGUERedirectViewBase
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
@import './pimtitlecatalogueredirect-view.less';
</style>