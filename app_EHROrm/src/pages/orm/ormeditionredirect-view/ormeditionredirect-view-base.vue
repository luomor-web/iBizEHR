
<template>
<div class="view-container deredirectview ormeditionredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormeditionredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmEditionService from '@/service/orm-edition/orm-edition-service';


import UIService from '@/uiservice/ui-service';


/**
 * 版本对照表数据重定向视图基类
 *
 * @export
 * @class ORMEDITIONRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMEDITIONRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmEditionService}
     * @memberof ORMEDITIONRedirectViewBase
     */
    public appEntityService: OrmEditionService = new OrmEditionService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMEDITIONRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMEDITIONRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMEDITIONRedirectViewBase
	 */
	public viewtag: string = '91ff0900099e3673ffa5934e43993ffe';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMEDITIONRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMEDITIONRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMEDITIONRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMEDITIONRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormedition.views.redirectview.caption',
        srfTitle: 'entities.ormedition.views.redirectview.title',
        srfSubTitle: 'entities.ormedition.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMEDITIONRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMEDITIONRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMEDITIONRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMEDITIONRedirectViewBase
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
     * @memberof ORMEDITIONRedirectViewBase
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
@import './ormeditionredirect-view.less';
</style>