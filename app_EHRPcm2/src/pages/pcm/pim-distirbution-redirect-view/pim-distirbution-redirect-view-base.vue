
<template>
<div class="view-container deredirectview pim-distirbution-redirect-view">
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
 * @class PimDistirbutionRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PimDistirbutionRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimDistirbutionService}
     * @memberof PimDistirbutionRedirectViewBase
     */
    public appEntityService: PimDistirbutionService = new PimDistirbutionService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PimDistirbutionRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PimDistirbutionRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PimDistirbutionRedirectViewBase
	 */
	public viewtag: string = '4aff675dc08f7125ee62afd49dcae323';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PimDistirbutionRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PimDistirbutionRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PimDistirbutionRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PimDistirbutionRedirectViewBase
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
     * @memberof PimDistirbutionRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PimDistirbutionRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PimDistirbutionRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PimDistirbutionRedirectViewBase
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
     * @memberof PimDistirbutionRedirectViewBase
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
@import './pim-distirbution-redirect-view.less';
</style>