
<template>
<div class="view-container deredirectview archivesmanageredirect-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="archivesmanageredirectview"></app-studioaction>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing, WizardViewBase } from '@/crm-core';
import ARCHIVESMANAGEService from '@/service/archivesmanage/archivesmanage-service';


import UIService from '@/uiservice/ui-service';


/**
 * 档案管理数据重定向视图基类
 *
 * @export
 * @class ARCHIVESMANAGERedirectViewBase
 * @extends {WizardViewBase}
 */
@Component({})
@VueLifeCycleProcessing
export default class ARCHIVESMANAGERedirectViewBase extends WizardViewBase {

    /**
     * 实体服务对象
     *
     * @type {ARCHIVESMANAGEService}
     * @memberof ARCHIVESMANAGERedirectViewBase
     */
    public appEntityService: ARCHIVESMANAGEService = new ARCHIVESMANAGEService;

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ARCHIVESMANAGERedirectViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof ARCHIVESMANAGERedirectViewBase
	 */
	public viewtag: string = 'f2d70fefe4800e93ea8ceae9466079da';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof ARCHIVESMANAGERedirectViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ARCHIVESMANAGERedirectViewBase
	 */
    protected customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof ARCHIVESMANAGERedirectViewBase
	 */
    protected customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof ARCHIVESMANAGERedirectViewBase
     */
    public model: any = {
        srfCaption: 'entities.archivesmanage.views.redirectview.caption',
        srfTitle: 'entities.archivesmanage.views.redirectview.title',
        srfSubTitle: 'entities.archivesmanage.views.redirectview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof ARCHIVESMANAGERedirectViewBase
     */
    public containerModel: any = {
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof ARCHIVESMANAGERedirectViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ARCHIVESMANAGERedirectViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof ARCHIVESMANAGERedirectViewBase
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
     * @memberof ARCHIVESMANAGERedirectViewBase
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
@import './archivesmanageredirect-view.less';
</style>