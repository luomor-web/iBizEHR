
<template>
<div class="view-container deredirectview pcm-ydbxmx-redirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pcmydbxmxredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PcmYdbxmxService from '@/service/pcm-ydbxmx/pcm-ydbxmx-service';


import UIService from '@/uiservice/ui-service';


/**
 * 异动病休明细数据重定向视图基类
 *
 * @export
 * @class PcmYdbxmxRedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PcmYdbxmxRedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PcmYdbxmxService}
     * @memberof PcmYdbxmxRedirectViewBase
     */
    public appEntityService: PcmYdbxmxService = new PcmYdbxmxService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PcmYdbxmxRedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PcmYdbxmxRedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PcmYdbxmxRedirectViewBase
	 */
	public viewtag: string = '634aeaa7c4db8f6ffaade689f25804f8';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PcmYdbxmxRedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PcmYdbxmxRedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PcmYdbxmxRedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PcmYdbxmxRedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pcmydbxmx.views.redirectview.caption',
        srfTitle: 'entities.pcmydbxmx.views.redirectview.title',
        srfSubTitle: 'entities.pcmydbxmx.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PcmYdbxmxRedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PcmYdbxmxRedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PcmYdbxmxRedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PcmYdbxmxRedirectViewBase
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
     * @memberof PcmYdbxmxRedirectViewBase
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
@import './pcm-ydbxmx-redirect-view.less';
</style>