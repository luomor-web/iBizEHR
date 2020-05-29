
<template>
<div class="view-container deredirectview pimarchivesloanandreturnredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimarchivesloanandreturnredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimArchiveSloanandreturnService from '@/service/pim-archive-sloanandreturn/pim-archive-sloanandreturn-service';


import UIService from '@/uiservice/ui-service';


/**
 * 档案借阅及归还记录数据重定向视图基类
 *
 * @export
 * @class PIMARCHIVESLOANANDRETURNRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMARCHIVESLOANANDRETURNRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimArchiveSloanandreturnService}
     * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
     */
    public appEntityService: PimArchiveSloanandreturnService = new PimArchiveSloanandreturnService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
	 */
	public viewtag: string = '36b293e164659669524c79c96504b743';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimarchivesloanandreturn.views.redirectview.caption',
        srfTitle: 'entities.pimarchivesloanandreturn.views.redirectview.title',
        srfSubTitle: 'entities.pimarchivesloanandreturn.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
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
     * @memberof PIMARCHIVESLOANANDRETURNRedirectViewBase
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
@import './pimarchivesloanandreturnredirect-view.less';
</style>