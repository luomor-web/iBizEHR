
<template>
<div class="view-container deredirectview pimarchiveschangeredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimarchiveschangeredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimArchivesChangeService from '@/service/pim-archives-change/pim-archives-change-service';


import UIService from '@/uiservice/ui-service';


/**
 * 档案归档地变更记录数据重定向视图基类
 *
 * @export
 * @class PIMARCHIVESCHANGERedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMARCHIVESCHANGERedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimArchivesChangeService}
     * @memberof PIMARCHIVESCHANGERedirectViewBase
     */
    public appEntityService: PimArchivesChangeService = new PimArchivesChangeService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMARCHIVESCHANGERedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMARCHIVESCHANGERedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMARCHIVESCHANGERedirectViewBase
	 */
	public viewtag: string = '4b0a44b01a6a2f804c5a7b0986fdfb77';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMARCHIVESCHANGERedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMARCHIVESCHANGERedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMARCHIVESCHANGERedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMARCHIVESCHANGERedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimarchiveschange.views.redirectview.caption',
        srfTitle: 'entities.pimarchiveschange.views.redirectview.title',
        srfSubTitle: 'entities.pimarchiveschange.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMARCHIVESCHANGERedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMARCHIVESCHANGERedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMARCHIVESCHANGERedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMARCHIVESCHANGERedirectViewBase
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
     * @memberof PIMARCHIVESCHANGERedirectViewBase
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
@import './pimarchiveschangeredirect-view.less';
</style>