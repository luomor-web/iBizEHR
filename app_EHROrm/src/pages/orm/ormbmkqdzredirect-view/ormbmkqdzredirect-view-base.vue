
<template>
<div class="view-container deredirectview ormbmkqdzredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormbmkqdzredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmBmkqdzService from '@/service/orm-bmkqdz/orm-bmkqdz-service';


import UIService from '@/uiservice/ui-service';


/**
 * 部门地址维护数据重定向视图基类
 *
 * @export
 * @class ORMBMKQDZRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMBMKQDZRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmBmkqdzService}
     * @memberof ORMBMKQDZRedirectViewBase
     */
    public appEntityService: OrmBmkqdzService = new OrmBmkqdzService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMBMKQDZRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMBMKQDZRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMBMKQDZRedirectViewBase
	 */
	public viewtag: string = 'd767fa880cb475dc1d1b6c4b686d51fd';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMBMKQDZRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMBMKQDZRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMBMKQDZRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMBMKQDZRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormbmkqdz.views.redirectview.caption',
        srfTitle: 'entities.ormbmkqdz.views.redirectview.title',
        srfSubTitle: 'entities.ormbmkqdz.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMBMKQDZRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMBMKQDZRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMBMKQDZRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMBMKQDZRedirectViewBase
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
     * @memberof ORMBMKQDZRedirectViewBase
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
@import './ormbmkqdzredirect-view.less';
</style>