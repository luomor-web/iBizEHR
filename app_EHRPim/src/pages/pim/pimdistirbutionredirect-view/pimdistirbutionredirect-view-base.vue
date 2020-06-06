
<template>
<div class="view-container deredirectview pimdistirbutionredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimdistirbutionredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimDistirbutionService from '@/service/pim-distirbution/pim-distirbution-service';


import UIService from '@/uiservice/ui-service';


/**
 * 分配信息数据重定向视图基类
 *
 * @export
 * @class PIMDISTIRBUTIONRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMDISTIRBUTIONRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimDistirbutionService}
     * @memberof PIMDISTIRBUTIONRedirectViewBase
     */
    public appEntityService: PimDistirbutionService = new PimDistirbutionService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMDISTIRBUTIONRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMDISTIRBUTIONRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMDISTIRBUTIONRedirectViewBase
	 */
	public viewtag: string = 'd2626af89490fcbaed39b480fba63609';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMDISTIRBUTIONRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMDISTIRBUTIONRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMDISTIRBUTIONRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMDISTIRBUTIONRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimdistirbution.views.redirectview.caption',
        srfTitle: 'entities.pimdistirbution.views.redirectview.title',
        srfSubTitle: 'entities.pimdistirbution.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMDISTIRBUTIONRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMDISTIRBUTIONRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMDISTIRBUTIONRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMDISTIRBUTIONRedirectViewBase
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
     * @memberof PIMDISTIRBUTIONRedirectViewBase
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
@import './pimdistirbutionredirect-view.less';
</style>