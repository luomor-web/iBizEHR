
<template>
<div class="view-container deredirectview ormxmglredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormxmglredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmXmglService from '@/service/orm-xmgl/orm-xmgl-service';


import UIService from '@/uiservice/ui-service';


/**
 * 项目管理数据重定向视图基类
 *
 * @export
 * @class ORMXMGLRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMXMGLRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmXmglService}
     * @memberof ORMXMGLRedirectViewBase
     */
    public appEntityService: OrmXmglService = new OrmXmglService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMXMGLRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMXMGLRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMXMGLRedirectViewBase
	 */
	public viewtag: string = '99172040009032a7a1eb0afe352f14c8';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMXMGLRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMXMGLRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMXMGLRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMXMGLRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormxmgl.views.redirectview.caption',
        srfTitle: 'entities.ormxmgl.views.redirectview.title',
        srfSubTitle: 'entities.ormxmgl.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMXMGLRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMXMGLRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMXMGLRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMXMGLRedirectViewBase
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
     * @memberof ORMXMGLRedirectViewBase
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
@import './ormxmglredirect-view.less';
</style>