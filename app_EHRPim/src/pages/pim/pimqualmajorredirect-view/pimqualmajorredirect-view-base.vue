
<template>
<div class="view-container deredirectview pimqualmajorredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimqualmajorredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimQualMajorService from '@/service/pim-qual-major/pim-qual-major-service';


import UIService from '@/uiservice/ui-service';


/**
 * 执业资格专业数据重定向视图基类
 *
 * @export
 * @class PIMQUALMAJORRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMQUALMAJORRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimQualMajorService}
     * @memberof PIMQUALMAJORRedirectViewBase
     */
    public appEntityService: PimQualMajorService = new PimQualMajorService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMQUALMAJORRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMQUALMAJORRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMQUALMAJORRedirectViewBase
	 */
	public viewtag: string = 'df1f1e4f44013b7f69b45de627f168ad';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMQUALMAJORRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMQUALMAJORRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMQUALMAJORRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMQUALMAJORRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimqualmajor.views.redirectview.caption',
        srfTitle: 'entities.pimqualmajor.views.redirectview.title',
        srfSubTitle: 'entities.pimqualmajor.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMQUALMAJORRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMQUALMAJORRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMQUALMAJORRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMQUALMAJORRedirectViewBase
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
     * @memberof PIMQUALMAJORRedirectViewBase
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
@import './pimqualmajorredirect-view.less';
</style>