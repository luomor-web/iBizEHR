
<template>
<div class="view-container deredirectview pim-search-field-set-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimsearchfieldsetredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimSearchFieldSetService from '@/service/pim-search-field-set/pim-search-field-set-service';


import UIService from '@/uiservice/ui-service';


/**
 * 组合查询条件设置数据重定向视图基类
 *
 * @export
 * @class PimSearchFieldSetRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PimSearchFieldSetRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimSearchFieldSetService}
     * @memberof PimSearchFieldSetRedirectViewBase
     */
    public appEntityService: PimSearchFieldSetService = new PimSearchFieldSetService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PimSearchFieldSetRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PimSearchFieldSetRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PimSearchFieldSetRedirectViewBase
	 */
	public viewtag: string = '9aee91cb29c180641d3ac7feefc6b752';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PimSearchFieldSetRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PimSearchFieldSetRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PimSearchFieldSetRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PimSearchFieldSetRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimsearchfieldset.views.redirectview.caption',
        srfTitle: 'entities.pimsearchfieldset.views.redirectview.title',
        srfSubTitle: 'entities.pimsearchfieldset.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PimSearchFieldSetRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PimSearchFieldSetRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PimSearchFieldSetRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PimSearchFieldSetRedirectViewBase
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
     * @memberof PimSearchFieldSetRedirectViewBase
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
@import './pim-search-field-set-redirect-view.less';
</style>