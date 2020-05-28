
<template>
<div class="view-container deredirectview ormorgsectorredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormorgsectorredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmOrgsectorService from '@/service/orm-orgsector/orm-orgsector-service';


import UIService from '@/uiservice/ui-service';


/**
 * 部门管理数据重定向视图基类
 *
 * @export
 * @class ORMORGSECTORRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMORGSECTORRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmOrgsectorService}
     * @memberof ORMORGSECTORRedirectViewBase
     */
    public appEntityService: OrmOrgsectorService = new OrmOrgsectorService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMORGSECTORRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMORGSECTORRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMORGSECTORRedirectViewBase
	 */
	public viewtag: string = '3b499b8332625ad5e778ebf48c9c5f8b';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMORGSECTORRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMORGSECTORRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMORGSECTORRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMORGSECTORRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormorgsector.views.redirectview.caption',
        srfTitle: 'entities.ormorgsector.views.redirectview.title',
        srfSubTitle: 'entities.ormorgsector.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMORGSECTORRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMORGSECTORRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMORGSECTORRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMORGSECTORRedirectViewBase
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
     * @memberof ORMORGSECTORRedirectViewBase
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
@import './ormorgsectorredirect-view.less';
</style>