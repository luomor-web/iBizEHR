
<template>
<div class="view-container deredirectview pimcontracttyperedirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimcontracttyperedirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimContractTypeService from '@/service/pim-contract-type/pim-contract-type-service';


import UIService from '@/uiservice/ui-service';


/**
 * 合同/协议类型管理数据重定向视图基类
 *
 * @export
 * @class PIMCONTRACTTYPERedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMCONTRACTTYPERedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimContractTypeService}
     * @memberof PIMCONTRACTTYPERedirectViewBase
     */
    public appEntityService: PimContractTypeService = new PimContractTypeService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMCONTRACTTYPERedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMCONTRACTTYPERedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMCONTRACTTYPERedirectViewBase
	 */
	public viewtag: string = 'bc1b818905f16a5ae7078e91eaf37670';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMCONTRACTTYPERedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMCONTRACTTYPERedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMCONTRACTTYPERedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMCONTRACTTYPERedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimcontracttype.views.redirectview.caption',
        srfTitle: 'entities.pimcontracttype.views.redirectview.title',
        srfSubTitle: 'entities.pimcontracttype.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMCONTRACTTYPERedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMCONTRACTTYPERedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMCONTRACTTYPERedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMCONTRACTTYPERedirectViewBase
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
     * @memberof PIMCONTRACTTYPERedirectViewBase
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
@import './pimcontracttyperedirect-view.less';
</style>