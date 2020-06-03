
<template>
<div class="view-container deredirectview ormxmbmxredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormxmbmxredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmXmbmxService from '@/service/orm-xmbmx/orm-xmbmx-service';


import UIService from '@/uiservice/ui-service';


/**
 * 项目部明细数据重定向视图基类
 *
 * @export
 * @class ORMXMBMXRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMXMBMXRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmXmbmxService}
     * @memberof ORMXMBMXRedirectViewBase
     */
    public appEntityService: OrmXmbmxService = new OrmXmbmxService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMXMBMXRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMXMBMXRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMXMBMXRedirectViewBase
	 */
	public viewtag: string = '704777f8b0faf40b3d68b19a04e32ef0';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMXMBMXRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMXMBMXRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMXMBMXRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMXMBMXRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormxmbmx.views.redirectview.caption',
        srfTitle: 'entities.ormxmbmx.views.redirectview.title',
        srfSubTitle: 'entities.ormxmbmx.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMXMBMXRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMXMBMXRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMXMBMXRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMXMBMXRedirectViewBase
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
     * @memberof ORMXMBMXRedirectViewBase
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
@import './ormxmbmxredirect-view.less';
</style>