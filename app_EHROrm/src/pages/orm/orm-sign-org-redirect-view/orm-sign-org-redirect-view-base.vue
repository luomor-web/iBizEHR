
<template>
<div class="view-container deredirectview orm-sign-org-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormsignorgredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmSignOrgService from '@/service/orm-sign-org/orm-sign-org-service';


import UIService from '@/uiservice/ui-service';


/**
 * 法人主体数据重定向视图基类
 *
 * @export
 * @class OrmSignOrgRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class OrmSignOrgRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmSignOrgService}
     * @memberof OrmSignOrgRedirectViewBase
     */
    public appEntityService: OrmSignOrgService = new OrmSignOrgService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof OrmSignOrgRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof OrmSignOrgRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof OrmSignOrgRedirectViewBase
	 */
	public viewtag: string = 'deea2383f175de0941090857fad7e76b';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof OrmSignOrgRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof OrmSignOrgRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof OrmSignOrgRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof OrmSignOrgRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormsignorg.views.redirectview.caption',
        srfTitle: 'entities.ormsignorg.views.redirectview.title',
        srfSubTitle: 'entities.ormsignorg.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof OrmSignOrgRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof OrmSignOrgRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof OrmSignOrgRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof OrmSignOrgRedirectViewBase
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
     * @memberof OrmSignOrgRedirectViewBase
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
@import './orm-sign-org-redirect-view.less';
</style>