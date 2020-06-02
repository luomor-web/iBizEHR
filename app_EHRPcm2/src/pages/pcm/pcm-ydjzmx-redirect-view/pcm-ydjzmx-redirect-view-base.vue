
<template>
<div class="view-container deredirectview pcm-ydjzmx-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pcmydjzmxredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PcmYdjzmxService from '@/service/pcm-ydjzmx/pcm-ydjzmx-service';


import UIService from '@/uiservice/ui-service';


/**
 * 异动兼职明细数据重定向视图基类
 *
 * @export
 * @class PcmYdjzmxRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmYdjzmxRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmYdjzmxService}
     * @memberof PcmYdjzmxRedirectViewBase
     */
    public appEntityService: PcmYdjzmxService = new PcmYdjzmxService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmYdjzmxRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmYdjzmxRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmYdjzmxRedirectViewBase
	 */
	public viewtag: string = 'e35dfcf60724baf88634f4eba6f6b272';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmYdjzmxRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmYdjzmxRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmYdjzmxRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmYdjzmxRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmydjzmx.views.redirectview.caption',
        srfTitle: 'entities.pcmydjzmx.views.redirectview.title',
        srfSubTitle: 'entities.pcmydjzmx.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmYdjzmxRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PcmYdjzmxRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmYdjzmxRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PcmYdjzmxRedirectViewBase
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
     * @memberof PcmYdjzmxRedirectViewBase
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
@import './pcm-ydjzmx-redirect-view.less';
</style>