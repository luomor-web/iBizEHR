
<template>
<div class="view-container deredirectview pcm-ydjdmx-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pcmydjdmxredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PcmYdjdmxService from '@/service/pcm-ydjdmx/pcm-ydjdmx-service';


import UIService from '@/uiservice/ui-service';


/**
 * 异动借调明细数据重定向视图基类
 *
 * @export
 * @class PcmYdjdmxRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmYdjdmxRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmYdjdmxService}
     * @memberof PcmYdjdmxRedirectViewBase
     */
    public appEntityService: PcmYdjdmxService = new PcmYdjdmxService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmYdjdmxRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmYdjdmxRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmYdjdmxRedirectViewBase
	 */
	public viewtag: string = 'bb2d76ba960ae38e69878295c4e9c2c9';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmYdjdmxRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmYdjdmxRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmYdjdmxRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmYdjdmxRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmydjdmx.views.redirectview.caption',
        srfTitle: 'entities.pcmydjdmx.views.redirectview.title',
        srfSubTitle: 'entities.pcmydjdmx.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmYdjdmxRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PcmYdjdmxRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmYdjdmxRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PcmYdjdmxRedirectViewBase
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
     * @memberof PcmYdjdmxRedirectViewBase
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
@import './pcm-ydjdmx-redirect-view.less';
</style>