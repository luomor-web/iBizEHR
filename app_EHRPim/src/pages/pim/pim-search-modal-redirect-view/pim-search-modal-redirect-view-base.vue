
<template>
<div class="view-container deredirectview pim-search-modal-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimsearchmodalredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimSearchModalService from '@/service/pim-search-modal/pim-search-modal-service';


import UIService from '@/uiservice/ui-service';


/**
 * 组合查询模版数据重定向视图基类
 *
 * @export
 * @class PimSearchModalRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PimSearchModalRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimSearchModalService}
     * @memberof PimSearchModalRedirectViewBase
     */
    public appEntityService: PimSearchModalService = new PimSearchModalService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PimSearchModalRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PimSearchModalRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PimSearchModalRedirectViewBase
	 */
	public viewtag: string = '62e8d8dfb03473c101fd454a15af8a56';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PimSearchModalRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PimSearchModalRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PimSearchModalRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PimSearchModalRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimsearchmodal.views.redirectview.caption',
        srfTitle: 'entities.pimsearchmodal.views.redirectview.title',
        srfSubTitle: 'entities.pimsearchmodal.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PimSearchModalRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PimSearchModalRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PimSearchModalRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PimSearchModalRedirectViewBase
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
     * @memberof PimSearchModalRedirectViewBase
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
@import './pim-search-modal-redirect-view.less';
</style>