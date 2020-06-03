
<template>
<div class="view-container deredirectview ormqyglredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormqyglredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmQyglService from '@/service/orm-qygl/orm-qygl-service';


import UIService from '@/uiservice/ui-service';


/**
 * 区域管理数据重定向视图基类
 *
 * @export
 * @class ORMQYGLRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMQYGLRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmQyglService}
     * @memberof ORMQYGLRedirectViewBase
     */
    public appEntityService: OrmQyglService = new OrmQyglService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMQYGLRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMQYGLRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMQYGLRedirectViewBase
	 */
	public viewtag: string = 'febdc6dc53b2c8189fb687e14db69506';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMQYGLRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMQYGLRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMQYGLRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMQYGLRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormqygl.views.redirectview.caption',
        srfTitle: 'entities.ormqygl.views.redirectview.title',
        srfSubTitle: 'entities.ormqygl.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMQYGLRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMQYGLRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMQYGLRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMQYGLRedirectViewBase
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
     * @memberof ORMQYGLRedirectViewBase
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
@import './ormqyglredirect-view.less';
</style>