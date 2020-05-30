
<template>
<div class="view-container deredirectview pimpatentredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimpatentredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimPatentService from '@/service/pim-patent/pim-patent-service';


import UIService from '@/uiservice/ui-service';


/**
 * 专利信息数据重定向视图基类
 *
 * @export
 * @class PIMPATENTRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMPATENTRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimPatentService}
     * @memberof PIMPATENTRedirectViewBase
     */
    public appEntityService: PimPatentService = new PimPatentService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMPATENTRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMPATENTRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMPATENTRedirectViewBase
	 */
	public viewtag: string = 'e7fca2c7c5771a2e110e331b4afe4fa5';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMPATENTRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMPATENTRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMPATENTRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMPATENTRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimpatent.views.redirectview.caption',
        srfTitle: 'entities.pimpatent.views.redirectview.title',
        srfSubTitle: 'entities.pimpatent.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMPATENTRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMPATENTRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMPATENTRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMPATENTRedirectViewBase
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
     * @memberof PIMPATENTRedirectViewBase
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
@import './pimpatentredirect-view.less';
</style>