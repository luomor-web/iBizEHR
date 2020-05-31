
<template>
<div class="view-container deredirectview ormpost-details-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormpostdetailsredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmPostDetailsService from '@/service/orm-post-details/orm-post-details-service';


import UIService from '@/uiservice/ui-service';


/**
 * 岗位明细数据重定向视图基类
 *
 * @export
 * @class ORMPostDetailsRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMPostDetailsRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmPostDetailsService}
     * @memberof ORMPostDetailsRedirectViewBase
     */
    public appEntityService: OrmPostDetailsService = new OrmPostDetailsService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMPostDetailsRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMPostDetailsRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMPostDetailsRedirectViewBase
	 */
	public viewtag: string = 'ed696bae9bae3cf67b0ffcf5cfae3f3b';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMPostDetailsRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMPostDetailsRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMPostDetailsRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMPostDetailsRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormpostdetails.views.redirectview.caption',
        srfTitle: 'entities.ormpostdetails.views.redirectview.title',
        srfSubTitle: 'entities.ormpostdetails.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMPostDetailsRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMPostDetailsRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMPostDetailsRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMPostDetailsRedirectViewBase
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
     * @memberof ORMPostDetailsRedirectViewBase
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
@import './ormpost-details-redirect-view.less';
</style>