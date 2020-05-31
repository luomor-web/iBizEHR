
<template>
<div class="view-container deredirectview pimqualtyperedirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimqualtyperedirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimQualTypeService from '@/service/pim-qual-type/pim-qual-type-service';


import UIService from '@/uiservice/ui-service';


/**
 * 执业资格类别数据重定向视图基类
 *
 * @export
 * @class PIMQUALTYPERedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMQUALTYPERedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimQualTypeService}
     * @memberof PIMQUALTYPERedirectViewBase
     */
    public appEntityService: PimQualTypeService = new PimQualTypeService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMQUALTYPERedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMQUALTYPERedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMQUALTYPERedirectViewBase
	 */
	public viewtag: string = 'ddad3ed0b796b2992aab7492cf507dda';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMQUALTYPERedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMQUALTYPERedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMQUALTYPERedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMQUALTYPERedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimqualtype.views.redirectview.caption',
        srfTitle: 'entities.pimqualtype.views.redirectview.title',
        srfSubTitle: 'entities.pimqualtype.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMQUALTYPERedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMQUALTYPERedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMQUALTYPERedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMQUALTYPERedirectViewBase
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
     * @memberof PIMQUALTYPERedirectViewBase
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
@import './pimqualtyperedirect-view.less';
</style>