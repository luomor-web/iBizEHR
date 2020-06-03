
<template>
<div class="view-container deredirectview pcm-yddgmx-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pcmyddgmxredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PcmYddgmxService from '@/service/pcm-yddgmx/pcm-yddgmx-service';


import UIService from '@/uiservice/ui-service';


/**
 * 异动待岗明细数据重定向视图基类
 *
 * @export
 * @class PcmYddgmxRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmYddgmxRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmYddgmxService}
     * @memberof PcmYddgmxRedirectViewBase
     */
    public appEntityService: PcmYddgmxService = new PcmYddgmxService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmYddgmxRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmYddgmxRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmYddgmxRedirectViewBase
	 */
	public viewtag: string = '19385e5cb8a1ad05ef37b71f9a293b6a';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmYddgmxRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmYddgmxRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmYddgmxRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmYddgmxRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmyddgmx.views.redirectview.caption',
        srfTitle: 'entities.pcmyddgmx.views.redirectview.title',
        srfSubTitle: 'entities.pcmyddgmx.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmYddgmxRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PcmYddgmxRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmYddgmxRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PcmYddgmxRedirectViewBase
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
     * @memberof PcmYddgmxRedirectViewBase
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
@import './pcm-yddgmx-redirect-view.less';
</style>