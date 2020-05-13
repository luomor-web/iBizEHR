
<template>
<div class="view-container deredirectview pimmajorsetyperedirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimmajorsetyperedirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PIMMAJORSETYPEService from '@/service/pimmajorsetype/pimmajorsetype-service';


import UIService from '@/uiservice/ui-service';


/**
 * 专业序列类型数据重定向视图基类
 *
 * @export
 * @class PIMMAJORSETYPERedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMMAJORSETYPERedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PIMMAJORSETYPEService}
     * @memberof PIMMAJORSETYPERedirectViewBase
     */
    public appEntityService: PIMMAJORSETYPEService = new PIMMAJORSETYPEService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMMAJORSETYPERedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMMAJORSETYPERedirectViewBase
	 */
	public viewtag: string = 'f8ca53db69de42d1b555d77b30ad8a8b';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMMAJORSETYPERedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMMAJORSETYPERedirectViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMMAJORSETYPERedirectViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMMAJORSETYPERedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimmajorsetype.views.redirectview.caption',
        srfTitle: 'entities.pimmajorsetype.views.redirectview.title',
        srfSubTitle: 'entities.pimmajorsetype.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMMAJORSETYPERedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMMAJORSETYPERedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @protected
     * @memberof PIMMAJORSETYPERedirectViewBase
     */
    protected engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMMAJORSETYPERedirectViewBase
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
     * @memberof PIMMAJORSETYPERedirectViewBase
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
@import './pimmajorsetyperedirect-view.less';
</style>