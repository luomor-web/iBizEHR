
<template>
<div class="view-container deredirectview pimexitandentryredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimexitandentryredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PIMEXITANDENTRYService from '@/service/pimexitandentry/pimexitandentry-service';


import UIService from '@/uiservice/ui-service';


/**
 * 出入境管理数据重定向视图基类
 *
 * @export
 * @class PIMEXITANDENTRYRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMEXITANDENTRYRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PIMEXITANDENTRYService}
     * @memberof PIMEXITANDENTRYRedirectViewBase
     */
    public appEntityService: PIMEXITANDENTRYService = new PIMEXITANDENTRYService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMEXITANDENTRYRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMEXITANDENTRYRedirectViewBase
	 */
	public viewtag: string = '4d18ce5c2ced758971d6b38d64dd4a36';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMEXITANDENTRYRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMEXITANDENTRYRedirectViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMEXITANDENTRYRedirectViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMEXITANDENTRYRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimexitandentry.views.redirectview.caption',
        srfTitle: 'entities.pimexitandentry.views.redirectview.title',
        srfSubTitle: 'entities.pimexitandentry.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMEXITANDENTRYRedirectViewBase
     */
    public containerModel: any = {
        wflinks: [],
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMEXITANDENTRYRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @protected
     * @memberof PIMEXITANDENTRYRedirectViewBase
     */
    protected engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMEXITANDENTRYRedirectViewBase
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
     * @memberof PIMEXITANDENTRYRedirectViewBase
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
@import './pimexitandentryredirect-view.less';
</style>