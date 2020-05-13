
<template>
<div class="view-container deredirectview pimarchivesredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimarchivesredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PIMARCHIVESService from '@/service/pimarchives/pimarchives-service';


import UIService from '@/uiservice/ui-service';


/**
 * 档案信息数据重定向视图基类
 *
 * @export
 * @class PIMARCHIVESRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMARCHIVESRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PIMARCHIVESService}
     * @memberof PIMARCHIVESRedirectViewBase
     */
    public appEntityService: PIMARCHIVESService = new PIMARCHIVESService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMARCHIVESRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMARCHIVESRedirectViewBase
	 */
	public viewtag: string = '21ccd254338305d40bc75d2c4fb6cd3f';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMARCHIVESRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMARCHIVESRedirectViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMARCHIVESRedirectViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMARCHIVESRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimarchives.views.redirectview.caption',
        srfTitle: 'entities.pimarchives.views.redirectview.title',
        srfSubTitle: 'entities.pimarchives.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMARCHIVESRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMARCHIVESRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @protected
     * @memberof PIMARCHIVESRedirectViewBase
     */
    protected engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMARCHIVESRedirectViewBase
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
     * @memberof PIMARCHIVESRedirectViewBase
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
@import './pimarchivesredirect-view.less';
</style>