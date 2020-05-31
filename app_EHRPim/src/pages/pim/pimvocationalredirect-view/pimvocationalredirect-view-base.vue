
<template>
<div class="view-container deredirectview pimvocationalredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimvocationalredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimVocationalService from '@/service/pim-vocational/pim-vocational-service';


import UIService from '@/uiservice/ui-service';


/**
 * 执（职）业资格信息数据重定向视图基类
 *
 * @export
 * @class PIMVOCATIONALRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMVOCATIONALRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimVocationalService}
     * @memberof PIMVOCATIONALRedirectViewBase
     */
    public appEntityService: PimVocationalService = new PimVocationalService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMVOCATIONALRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMVOCATIONALRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMVOCATIONALRedirectViewBase
	 */
	public viewtag: string = '2e06f3062712093583d2319e9aac4f1e';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMVOCATIONALRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMVOCATIONALRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMVOCATIONALRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMVOCATIONALRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimvocational.views.redirectview.caption',
        srfTitle: 'entities.pimvocational.views.redirectview.title',
        srfSubTitle: 'entities.pimvocational.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMVOCATIONALRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMVOCATIONALRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMVOCATIONALRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMVOCATIONALRedirectViewBase
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
     * @memberof PIMVOCATIONALRedirectViewBase
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
@import './pimvocationalredirect-view.less';
</style>