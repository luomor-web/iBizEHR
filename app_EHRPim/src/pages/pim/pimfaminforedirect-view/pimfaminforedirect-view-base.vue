
<template>
<div class="view-container deredirectview pimfaminforedirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimfaminforedirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimFaminfoService from '@/service/pim-faminfo/pim-faminfo-service';


import UIService from '@/uiservice/ui-service';


/**
 * 家庭情况数据重定向视图基类
 *
 * @export
 * @class PIMFAMINFORedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMFAMINFORedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimFaminfoService}
     * @memberof PIMFAMINFORedirectViewBase
     */
    public appEntityService: PimFaminfoService = new PimFaminfoService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMFAMINFORedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMFAMINFORedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMFAMINFORedirectViewBase
	 */
	public viewtag: string = 'fcfe84d61ee46b0dad5a3eee3af5053b';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMFAMINFORedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMFAMINFORedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMFAMINFORedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMFAMINFORedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimfaminfo.views.redirectview.caption',
        srfTitle: 'entities.pimfaminfo.views.redirectview.title',
        srfSubTitle: 'entities.pimfaminfo.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMFAMINFORedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMFAMINFORedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMFAMINFORedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMFAMINFORedirectViewBase
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
     * @memberof PIMFAMINFORedirectViewBase
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
@import './pimfaminforedirect-view.less';
</style>