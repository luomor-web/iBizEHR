
<template>
<div class="view-container deredirectview ormxmbqredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ormxmbqredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import OrmXmbqService from '@/service/orm-xmbq/orm-xmbq-service';


import UIService from '@/uiservice/ui-service';


/**
 * 项目标签数据重定向视图基类
 *
 * @export
 * @class ORMXMBQRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ORMXMBQRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {OrmXmbqService}
     * @memberof ORMXMBQRedirectViewBase
     */
    public appEntityService: OrmXmbqService = new OrmXmbqService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ORMXMBQRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ORMXMBQRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ORMXMBQRedirectViewBase
	 */
	public viewtag: string = '01b62bf4ee2d769386b7340ce0194d03';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ORMXMBQRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ORMXMBQRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ORMXMBQRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ORMXMBQRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.ormxmbq.views.redirectview.caption',
        srfTitle: 'entities.ormxmbq.views.redirectview.title',
        srfSubTitle: 'entities.ormxmbq.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ORMXMBQRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof ORMXMBQRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ORMXMBQRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ORMXMBQRedirectViewBase
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
     * @memberof ORMXMBQRedirectViewBase
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
@import './ormxmbqredirect-view.less';
</style>