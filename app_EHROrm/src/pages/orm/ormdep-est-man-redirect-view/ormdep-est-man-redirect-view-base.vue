
<template>
<div class="view-container deredirectview ormdep-est-man-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormdepestmanredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmDepEstManService from '@/service/orm-dep-est-man/orm-dep-est-man-service';


import UIService from '@/uiservice/ui-service';


/**
 * 部门编制管理数据重定向视图基类
 *
 * @export
 * @class ORMDepEstManRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMDepEstManRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmDepEstManService}
     * @memberof ORMDepEstManRedirectViewBase
     */
    public appEntityService: OrmDepEstManService = new OrmDepEstManService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMDepEstManRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMDepEstManRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMDepEstManRedirectViewBase
	 */
	public viewtag: string = '17be95697d6cb7660e00b03a30bfe5ee';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMDepEstManRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMDepEstManRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMDepEstManRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMDepEstManRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormdepestman.views.redirectview.caption',
        srfTitle: 'entities.ormdepestman.views.redirectview.title',
        srfSubTitle: 'entities.ormdepestman.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMDepEstManRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMDepEstManRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMDepEstManRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMDepEstManRedirectViewBase
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
     * @memberof ORMDepEstManRedirectViewBase
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
@import './ormdep-est-man-redirect-view.less';
</style>