
<template>
<div class="view-container deredirectview pimstafftyperedirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimstafftyperedirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimStafftypeService from '@/service/pim-stafftype/pim-stafftype-service';


import UIService from '@/uiservice/ui-service';


/**
 * 员工类型管理数据重定向视图基类
 *
 * @export
 * @class PIMSTAFFTYPERedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMSTAFFTYPERedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimStafftypeService}
     * @memberof PIMSTAFFTYPERedirectViewBase
     */
    public appEntityService: PimStafftypeService = new PimStafftypeService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMSTAFFTYPERedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMSTAFFTYPERedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMSTAFFTYPERedirectViewBase
	 */
	public viewtag: string = 'f2a46591aa5789a2f008221d3e12836f';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMSTAFFTYPERedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMSTAFFTYPERedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMSTAFFTYPERedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMSTAFFTYPERedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimstafftype.views.redirectview.caption',
        srfTitle: 'entities.pimstafftype.views.redirectview.title',
        srfSubTitle: 'entities.pimstafftype.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMSTAFFTYPERedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMSTAFFTYPERedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMSTAFFTYPERedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMSTAFFTYPERedirectViewBase
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
     * @memberof PIMSTAFFTYPERedirectViewBase
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
@import './pimstafftyperedirect-view.less';
</style>