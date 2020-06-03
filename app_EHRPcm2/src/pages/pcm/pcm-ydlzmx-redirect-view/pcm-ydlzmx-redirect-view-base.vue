
<template>
<div class="view-container deredirectview pcm-ydlzmx-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pcmydlzmxredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PcmYdlzmxService from '@/service/pcm-ydlzmx/pcm-ydlzmx-service';


import UIService from '@/uiservice/ui-service';


/**
 * 异动离职明细数据重定向视图基类
 *
 * @export
 * @class PcmYdlzmxRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmYdlzmxRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmYdlzmxService}
     * @memberof PcmYdlzmxRedirectViewBase
     */
    public appEntityService: PcmYdlzmxService = new PcmYdlzmxService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmYdlzmxRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmYdlzmxRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmYdlzmxRedirectViewBase
	 */
	public viewtag: string = '3dc44356f3918afed9cfd0c70d585d24';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmYdlzmxRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmYdlzmxRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmYdlzmxRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmYdlzmxRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmydlzmx.views.redirectview.caption',
        srfTitle: 'entities.pcmydlzmx.views.redirectview.title',
        srfSubTitle: 'entities.pcmydlzmx.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmYdlzmxRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PcmYdlzmxRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmYdlzmxRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PcmYdlzmxRedirectViewBase
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
     * @memberof PcmYdlzmxRedirectViewBase
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
@import './pcm-ydlzmx-redirect-view.less';
</style>