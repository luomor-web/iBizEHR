<template>
    <div class='pickupviewpanel'>
        <component 
          v-if="inited && view.viewname && !Object.is(view.viewname, '')" 
          :is="view.viewname"
          class="viewcontainer3"
          :viewdata="viewdata"
          :viewparam="viewparam"
          :viewDefaultUsage="false"
          :isSingleSelect="isSingleSelect"
          :selectedData="selectedData"
          :isShowButton="isShowButton"
          @viewdataschange="onViewDatasChange"
          @viewdatasactivated="viewDatasActivated"
          @viewload="onViewLoad">
        </component>
    </div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import ARCHIVESCENTERService from '@/service/archivescenter/archivescenter-service';
import PickupViewpickupviewpanelService from './pickup-viewpickupviewpanel-pickupviewpanel-service';

import PickupViewpickupviewpanelModel from './pickup-viewpickupviewpanel-pickupviewpanel-model';


@Component({
    components: {
      
    }
})
export default class PickupViewpickupviewpanelBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof PickupViewpickupviewpanel
     */
    @Prop() protected name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof PickupViewpickupviewpanel
     */
    @Prop() protected viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof PickupViewpickupviewpanel
     */
    @Prop() protected context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof PickupViewpickupviewpanel
     */
    @Prop() protected viewparams: any;

    /**
     * 视图状态事件
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof PickupViewpickupviewpanel
     */
    protected viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof PickupViewpickupviewpanel
     */
    protected getControlType(): string {
        return 'PICKUPVIEWPANEL'
    }



    /**
     * 建构部件服务对象
     *
     * @type {PickupViewpickupviewpanelService}
     * @memberof PickupViewpickupviewpanel
     */
    protected service: PickupViewpickupviewpanelService = new PickupViewpickupviewpanelService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {ARCHIVESCENTERService}
     * @memberof PickupViewpickupviewpanel
     */
    protected appEntityService: ARCHIVESCENTERService = new ARCHIVESCENTERService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof PickupViewpickupviewpanel
     */
    protected closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof PickupViewpickupviewpanel
     */
    public counterRefresh(){
        const _this:any =this;
        if(_this.counterServiceArray && _this.counterServiceArray.length >0){
            _this.counterServiceArray.forEach((item:any) =>{
                if(item.refreshData && item.refreshData instanceof Function){
                    item.refreshData();
                }
            })
        }
    }

    /**
     * 选中数据字符串
     *
     * @type {string}
     * @memberof PickupViewpickupviewpanel
     */
    @Prop() protected selectedData?: string;

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof PickupViewpickupviewpanel
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof PickupViewpickupviewpanel
     */
    public getData(): any {
        return {};
    }

    /**
     * 视图名称
     *
     * @type {*}
     * @memberof PickupViewpickupviewpanel
     */
    protected view: any = {
        viewname: 'archivescenterpickup-grid-view',
        data: {},
    }

    /**
     * 视图数据
     *
     * @type {*}
     * @memberof PickupViewpickupviewpanel
     */
    protected viewdata: string  = JSON.stringify(this.context);

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof PickupViewpickupviewpanel
     */
    protected viewparam: string  = JSON.stringify(this.viewparams);

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof PickupViewpickupviewpanel
     */
    @Prop({default: true}) protected isShowButton!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof PickupViewpickupviewpanel
     */
    @Prop() protected isSingleSelect?: boolean;

    /**
     * 初始化完成
     *
     * @type {boolean}
     * @memberof PickupViewpickupviewpanel
     */
    protected inited: boolean = false;

    /**
     * 视图数据变化
     *
     * @param {*} $event
     * @memberof PickupViewpickupviewpanel
     */
    protected onViewDatasChange($event: any): void {
        if($event.length>0){
          $event.forEach((item:any,index:any) => {
              let srfmajortext = item['position'];
              if(srfmajortext){
                Object.assign($event[index],{srfmajortext: srfmajortext});
              }
          });
        }
        this.$emit('selectionchange', $event);
    }

    /**
     * 视图数据被激活
     *
     * @param {*} $event
     * @memberof PickupViewpickupviewpanel
     */
    protected viewDatasActivated($event: any): void {
        this.$emit('activated', $event);
    }

    /**
     * 视图加载完成
     *
     * @param {*} $event
     * @memberof PickupViewpickupviewpanel
     */
    protected onViewLoad($event: any): void {
        this.$emit('load', $event);
    }

    /**
     * vue 生命周期
     *
     * @memberof PickupViewpickupviewpanel
     */
    protected created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof PickupViewpickupviewpanel
     */    
    protected afterCreated(){
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('load', action)) {
                    this.viewdata = JSON.stringify(this.context);
                    this.viewparam = JSON.stringify(Object.assign(data, this.viewparams));
                    this.inited = true;
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof PickupViewpickupviewpanel
     */
    protected destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof PickupViewpickupviewpanel
     */
    protected afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

}
</script>

<style lang='less'>
@import './pickup-viewpickupviewpanel-pickupviewpanel.less';
</style>