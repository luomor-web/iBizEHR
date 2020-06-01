<template>
<div class="view-container dewfproxystartview vac-leave-manage-wfproxy-start-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="vacleavemanagewfproxystartview"></app-studioaction>
    <card class='view-card   view-no-toolbar' :disHover="true" :padding="0" :bordered="false">
        <div class="content-container">
            <iframe :src="iframeUrl" height="100%" width="100%" seamless="seamless" frameborder="0" scrolling="auto"></iframe>
        </div>
    </card>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { UIActionTool, Util } from '@/utils';
import { VueLifeCycleProcessing } from '@/crm-core';
import VacLeaveManageService from '@/service/vac-leave-manage/vac-leave-manage-service';



/**
 * 流程启动基类
 *
 * @export
 * @class VacLeaveManageWFProxyStartViewBase
 * @extends {Vue}
 */
@Component({})
@VueLifeCycleProcessing
export default class VacLeaveManageWFProxyStartViewBase extends ViewBase {

    /**
     * 实体服务对象
     *
     * @type {VacLeaveManageService}
     * @memberof VacLeaveManageWFProxyStartViewBase
     */
    public appEntityService: VacLeaveManageService = new VacLeaveManageService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof VacLeaveManageWFProxyStartViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof VacLeaveManageWFProxyStartViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof VacLeaveManageWFProxyStartViewBase
	 */
	public viewtag: string = '3b1af739a51547cab59a33fc26d11c54';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof VacLeaveManageWFProxyStartViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof VacLeaveManageWFProxyStartViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof VacLeaveManageWFProxyStartViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof VacLeaveManageWFProxyStartViewBase
     */
    public model: any = {
        srfCaption: 'entities.vacleavemanage.views.wfproxystartview.caption',
        srfTitle: 'entities.vacleavemanage.views.wfproxystartview.title',
        srfSubTitle: 'entities.vacleavemanage.views.wfproxystartview.subtitle',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof VacLeaveManageWFProxyStartViewBase
     */
    public containerModel: any = {
        wflinks: [],
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof VacLeaveManageWFProxyStartViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof VacLeaveManageWFProxyStartViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof VacLeaveManageWFProxyStartViewBase
     */
    public destroyed(){
    }
    
    /**
     * iframe路径
     *
     * @memberof @memberof VacLeaveManageWFProxyStartViewBase
     */
    public iframeUrl:string ="";

    /**
     * 获取iframe路径
     *
     * @public
     * @memberof VacLeaveManageWFProxyStartViewBase
     */
    public getIframeUrl(){
        this.$http.post(`/vacleavemanages/${this.context['vacleavemanage']}/wfstart`,{}).then((response:any) =>{
            if (response && response.status === 200) {
                const data = response.data;
                //?srfwfproxydataid=${this.context.vacleavemanage};srfwfproxymoduleid=VacLeaveManage
                this.iframeUrl = `${data.url}`;   
            }
        }).catch((response:any) =>{
            if (response && response.status === 401) {
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        })
    }


}
</script>

<style lang='less'>
@import './vac-leave-manage-wfproxy-start-view.less';
</style>