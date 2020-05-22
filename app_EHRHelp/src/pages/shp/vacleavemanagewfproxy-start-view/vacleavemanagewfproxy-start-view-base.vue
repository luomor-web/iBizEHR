<template>
<div class="view-container dewfproxystartview vacleavemanagewfproxy-start-view">
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
import VACLEAVEMANAGEService from '@/service/vacleavemanage/vacleavemanage-service';



/**
 * 流程启动基类
 *
 * @export
 * @class VACLEAVEMANAGEWFProxyStartViewBase
 * @extends {Vue}
 */
@Component({})
@VueLifeCycleProcessing
export default class VACLEAVEMANAGEWFProxyStartViewBase extends ViewBase {

    /**
     * 实体服务对象
     *
     * @type {VACLEAVEMANAGEService}
     * @memberof VACLEAVEMANAGEWFProxyStartViewBase
     */
    public appEntityService: VACLEAVEMANAGEService = new VACLEAVEMANAGEService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof VACLEAVEMANAGEWFProxyStartViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof VACLEAVEMANAGEWFProxyStartViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof VACLEAVEMANAGEWFProxyStartViewBase
	 */
	public viewtag: string = 'e659ffb581767694cfdeffc70644dcd7';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof VACLEAVEMANAGEWFProxyStartViewBase
     */
    protected srfparentdata: any = {};

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof VACLEAVEMANAGEWFProxyStartViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof VACLEAVEMANAGEWFProxyStartViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof VACLEAVEMANAGEWFProxyStartViewBase
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
     * @memberof VACLEAVEMANAGEWFProxyStartViewBase
     */
    public containerModel: any = {
        wflinks: [],
    };

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof VACLEAVEMANAGEWFProxyStartViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


	

    /**
     * 引擎初始化
     *
     * @public
     * @memberof VACLEAVEMANAGEWFProxyStartViewBase
     */
    public engineInit(): void {
    }





    /**
     * 销毁视图回调
     *
     * @memberof VACLEAVEMANAGEWFProxyStartViewBase
     */
    public destroyed(){
    }
    
    /**
     * iframe路径
     *
     * @memberof @memberof VACLEAVEMANAGEWFProxyStartViewBase
     */
    public iframeUrl:string ="";

    /**
     * 获取iframe路径
     *
     * @public
     * @memberof VACLEAVEMANAGEWFProxyStartViewBase
     */
    public getIframeUrl(){
        this.$http.post(`/vacleavemanages/${this.context['vacleavemanage']}/wfstart`,{}).then((response:any) =>{
            if (response && response.status === 200) {
                const data = response.data;
                //?srfwfproxydataid=${this.context.vacleavemanage};srfwfproxymoduleid=VACLEAVEMANAGE
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
@import './vacleavemanagewfproxy-start-view.less';
</style>