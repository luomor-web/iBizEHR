
<template>
<div class="view-container deredirectview ormpost-lib-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormpostlibredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmPostLibService from '@/service/orm-post-lib/orm-post-lib-service';


import UIService from '@/uiservice/ui-service';


/**
 * 岗位库数据重定向视图基类
 *
 * @export
 * @class ORMPostLibRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMPostLibRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmPostLibService}
     * @memberof ORMPostLibRedirectViewBase
     */
    public appEntityService: OrmPostLibService = new OrmPostLibService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMPostLibRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMPostLibRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMPostLibRedirectViewBase
	 */
	public viewtag: string = '0231831987f217c1ac06c9f2d435155e';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMPostLibRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMPostLibRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMPostLibRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMPostLibRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormpostlib.views.redirectview.caption',
        srfTitle: 'entities.ormpostlib.views.redirectview.title',
        srfSubTitle: 'entities.ormpostlib.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMPostLibRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMPostLibRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMPostLibRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMPostLibRedirectViewBase
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
     * @memberof ORMPostLibRedirectViewBase
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
@import './ormpost-lib-redirect-view.less';
</style>