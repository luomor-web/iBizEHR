
<template>
<div class="view-container deredirectview archivescenterredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="archivescenterredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimArchivesCenterService from '@/service/pim-archives-center/pim-archives-center-service';


import UIService from '@/uiservice/ui-service';


/**
 * 档案室管理数据重定向视图基类
 *
 * @export
 * @class ARCHIVESCENTERRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ARCHIVESCENTERRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimArchivesCenterService}
     * @memberof ARCHIVESCENTERRedirectViewBase
     */
    public appEntityService: PimArchivesCenterService = new PimArchivesCenterService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ARCHIVESCENTERRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ARCHIVESCENTERRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ARCHIVESCENTERRedirectViewBase
	 */
	public viewtag: string = 'a7e8b69c03b08804486b80e82085c394';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ARCHIVESCENTERRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ARCHIVESCENTERRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ARCHIVESCENTERRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ARCHIVESCENTERRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimarchivescenter.views.redirectview.caption',
        srfTitle: 'entities.pimarchivescenter.views.redirectview.title',
        srfSubTitle: 'entities.pimarchivescenter.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ARCHIVESCENTERRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ARCHIVESCENTERRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ARCHIVESCENTERRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ARCHIVESCENTERRedirectViewBase
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
     * @memberof ARCHIVESCENTERRedirectViewBase
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
@import './archivescenterredirect-view.less';
</style>