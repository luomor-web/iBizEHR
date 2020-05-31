
<template>
<div class="view-container deredirectview ormqybzwhredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormqybzwhredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmQybzwhService from '@/service/orm-qybzwh/orm-qybzwh-service';


import UIService from '@/uiservice/ui-service';


/**
 * 区域标准维护数据重定向视图基类
 *
 * @export
 * @class ORMQYBZWHRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMQYBZWHRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmQybzwhService}
     * @memberof ORMQYBZWHRedirectViewBase
     */
    public appEntityService: OrmQybzwhService = new OrmQybzwhService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMQYBZWHRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMQYBZWHRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMQYBZWHRedirectViewBase
	 */
	public viewtag: string = 'f72fc27e063edf4cb5d69cbf3af78c70';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMQYBZWHRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMQYBZWHRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMQYBZWHRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMQYBZWHRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormqybzwh.views.redirectview.caption',
        srfTitle: 'entities.ormqybzwh.views.redirectview.title',
        srfSubTitle: 'entities.ormqybzwh.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMQYBZWHRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMQYBZWHRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMQYBZWHRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMQYBZWHRedirectViewBase
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
     * @memberof ORMQYBZWHRedirectViewBase
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
@import './ormqybzwhredirect-view.less';
</style>