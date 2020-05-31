
<template>
<div class="view-container deredirectview pimenclosureredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="pimenclosureredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import PimEnclosureService from '@/service/pim-enclosure/pim-enclosure-service';


import UIService from '@/uiservice/ui-service';


/**
 * 附件信息数据重定向视图基类
 *
 * @export
 * @class PIMENCLOSURERedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class PIMENCLOSURERedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {PimEnclosureService}
     * @memberof PIMENCLOSURERedirectViewBase
     */
    public appEntityService: PimEnclosureService = new PimEnclosureService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof PIMENCLOSURERedirectViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof PIMENCLOSURERedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof PIMENCLOSURERedirectViewBase
	 */
	public viewtag: string = '853c2bd28e76a454408348d184680a39';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof PIMENCLOSURERedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof PIMENCLOSURERedirectViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof PIMENCLOSURERedirectViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof PIMENCLOSURERedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.pimenclosure.views.redirectview.caption',
        srfTitle: 'entities.pimenclosure.views.redirectview.title',
        srfSubTitle: 'entities.pimenclosure.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof PIMENCLOSURERedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof PIMENCLOSURERedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PIMENCLOSURERedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof PIMENCLOSURERedirectViewBase
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
     * @memberof PIMENCLOSURERedirectViewBase
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
@import './pimenclosureredirect-view.less';
</style>