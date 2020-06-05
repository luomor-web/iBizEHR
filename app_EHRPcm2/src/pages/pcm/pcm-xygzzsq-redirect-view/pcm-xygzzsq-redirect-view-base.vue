
<template>
<div class="view-container deredirectview pcm-xygzzsq-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pcmxygzzsqredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PcmXygzzsqService from '@/service/pcm-xygzzsq/pcm-xygzzsq-service';


import UIService from '@/uiservice/ui-service';


/**
 * 试用期员工转正申请数据重定向视图基类
 *
 * @export
 * @class PcmXygzzsqRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmXygzzsqRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmXygzzsqService}
     * @memberof PcmXygzzsqRedirectViewBase
     */
    public appEntityService: PcmXygzzsqService = new PcmXygzzsqService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmXygzzsqRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmXygzzsqRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmXygzzsqRedirectViewBase
	 */
	public viewtag: string = '999153f1294f6e92da439ff8555f5b50';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmXygzzsqRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmXygzzsqRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmXygzzsqRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmXygzzsqRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmxygzzsq.views.redirectview.caption',
        srfTitle: 'entities.pcmxygzzsq.views.redirectview.title',
        srfSubTitle: 'entities.pcmxygzzsq.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmXygzzsqRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PcmXygzzsqRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmXygzzsqRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PcmXygzzsqRedirectViewBase
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
     * @memberof PcmXygzzsqRedirectViewBase
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
@import './pcm-xygzzsq-redirect-view.less';
</style>