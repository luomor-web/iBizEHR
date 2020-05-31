
<template>
<div class="view-container deredirectview ormbmgwbzredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormbmgwbzredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmBmgwbzService from '@/service/orm-bmgwbz/orm-bmgwbz-service';


import UIService from '@/uiservice/ui-service';


/**
 * 部门岗位编制数据重定向视图基类
 *
 * @export
 * @class ORMBMGWBZRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMBMGWBZRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmBmgwbzService}
     * @memberof ORMBMGWBZRedirectViewBase
     */
    public appEntityService: OrmBmgwbzService = new OrmBmgwbzService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMBMGWBZRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMBMGWBZRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMBMGWBZRedirectViewBase
	 */
	public viewtag: string = '1d4fbfcdc67086dfd37e4a0bef895b8d';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMBMGWBZRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMBMGWBZRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMBMGWBZRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMBMGWBZRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormbmgwbz.views.redirectview.caption',
        srfTitle: 'entities.ormbmgwbz.views.redirectview.title',
        srfSubTitle: 'entities.ormbmgwbz.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMBMGWBZRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMBMGWBZRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMBMGWBZRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMBMGWBZRedirectViewBase
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
     * @memberof ORMBMGWBZRedirectViewBase
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
@import './ormbmgwbzredirect-view.less';
</style>