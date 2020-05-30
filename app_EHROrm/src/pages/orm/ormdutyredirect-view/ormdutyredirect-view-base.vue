
<template>
<div class="view-container deredirectview ormdutyredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormdutyredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmDutyService from '@/service/orm-duty/orm-duty-service';


import UIService from '@/uiservice/ui-service';


/**
 * 职务管理数据重定向视图基类
 *
 * @export
 * @class ORMDUTYRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMDUTYRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmDutyService}
     * @memberof ORMDUTYRedirectViewBase
     */
    public appEntityService: OrmDutyService = new OrmDutyService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMDUTYRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMDUTYRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMDUTYRedirectViewBase
	 */
	public viewtag: string = '8c11143ae9815525844a449cb705f811';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMDUTYRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMDUTYRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMDUTYRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMDUTYRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormduty.views.redirectview.caption',
        srfTitle: 'entities.ormduty.views.redirectview.title',
        srfSubTitle: 'entities.ormduty.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMDUTYRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMDUTYRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMDUTYRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMDUTYRedirectViewBase
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
     * @memberof ORMDUTYRedirectViewBase
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
@import './ormdutyredirect-view.less';
</style>