
<template>
<div class="view-container deredirectview pimeducationredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimeducationredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimEducationService from '@/service/pim-education/pim-education-service';


import UIService from '@/uiservice/ui-service';


/**
 * 教育信息数据重定向视图基类
 *
 * @export
 * @class PIMEDUCATIONRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMEDUCATIONRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimEducationService}
     * @memberof PIMEDUCATIONRedirectViewBase
     */
    public appEntityService: PimEducationService = new PimEducationService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMEDUCATIONRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMEDUCATIONRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMEDUCATIONRedirectViewBase
	 */
	public viewtag: string = 'fed60f5ddd7904ea5e13a7ef07374f99';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMEDUCATIONRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMEDUCATIONRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMEDUCATIONRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMEDUCATIONRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimeducation.views.redirectview.caption',
        srfTitle: 'entities.pimeducation.views.redirectview.title',
        srfSubTitle: 'entities.pimeducation.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMEDUCATIONRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMEDUCATIONRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMEDUCATIONRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMEDUCATIONRedirectViewBase
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
     * @memberof PIMEDUCATIONRedirectViewBase
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
@import './pimeducationredirect-view.less';
</style>