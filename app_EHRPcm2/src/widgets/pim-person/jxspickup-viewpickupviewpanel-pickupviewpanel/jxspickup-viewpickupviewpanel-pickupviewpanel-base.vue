<template>
    <div class='pickupviewpanel'>
        <component 
          v-if="inited && view.viewname && !Object.is(view.viewname, '')" 
          :is="view.viewname"
          class="viewcontainer3"
          :openMode="openMode"
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
import PimPersonService from '@/service/pim-person/pim-person-service';
import JXSPickupViewpickupviewpanelService from './jxspickup-viewpickupviewpanel-pickupviewpanel-service';

import JXSPickupViewpickupviewpanelModel from './jxspickup-viewpickupviewpanel-pickupviewpanel-model';


@Component({
    components: {
      
    }
})
export default class JXSPickupViewpickupviewpanelBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof JXSPickupViewpickupviewpanel
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof JXSPickupViewpickupviewpanel
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof JXSPickupViewpickupviewpanel
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof JXSPickupViewpickupviewpanel
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof JXSPickupViewpickupviewpanel
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof JXSPickupViewpickupviewpanel
     */
    public getControlType(): string {
        return 'PICKUPVIEWPANEL'
    }



    /**
     * 建构部件服务对象
     *
     * @type {JXSPickupViewpickupviewpanelService}
     * @memberof JXSPickupViewpickupviewpanel
     */
    public service: JXSPickupViewpickupviewpanelService = new JXSPickupViewpickupviewpanelService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PimPersonService}
     * @memberof JXSPickupViewpickupviewpanel
     */
    public appEntityService: PimPersonService = new PimPersonService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof JXSPickupViewpickupviewpanel
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof JXSPickupViewpickupviewpanel
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
     * 视图打开模式
     *
     * @protected
     * @type {('DEFAULT' | 'MODAL')}
     * @memberof JXSPickupViewpickupviewpanel
     */
    @Prop({ default: 'DEFAULT' })
    protected openMode!: 'DEFAULT' | 'MODAL';

    /**
     * 选中数据字符串
     *
     * @type {string}
     * @memberof JXSPickupViewpickupviewpanel
     */
    @Prop() protected selectedData?: string;

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof JXSPickupViewpickupviewpanel
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof JXSPickupViewpickupviewpanel
     */
    public getData(): any {
        return {};
    }

    /**
     * 视图名称
     *
     * @type {*}
     * @memberof JXSPickupViewpickupviewpanel
     */
    protected view: any = {
        viewname: 'pim-person-jxqpickup-grid-view',
        data: {},
    }

    /**
     * 视图数据
     *
     * @type {*}
     * @memberof JXSPickupViewpickupviewpanel
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
     * @memberof JXSPickupViewpickupviewpanel
     */
    @Prop({default: true}) protected isShowButton!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof JXSPickupViewpickupviewpanel
     */
    @Prop() protected isSingleSelect?: boolean;

    /**
     * 初始化完成
     *
     * @type {boolean}
     * @memberof JXSPickupViewpickupviewpanel
     */
    protected inited: boolean = false;

    /**
     * 视图数据变化
     *
     * @param {*} $event
     * @memberof JXSPickupViewpickupviewpanel
     */
    protected onViewDatasChange($event: any): void {
        if($event.length>0){
          $event.forEach((item:any,index:any) => {
              let srfmajortext = item['pimpersonname'];
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
     * @memberof JXSPickupViewpickupviewpanel
     */
    protected viewDatasActivated($event: any): void {
        this.$emit('activated', $event);
    }

    /**
     * 视图加载完成
     *
     * @param {*} $event
     * @memberof JXSPickupViewpickupviewpanel
     */
    protected onViewLoad($event: any): void {
        this.$emit('load', $event);
    }

    /**
     * vue 生命周期
     *
     * @memberof JXSPickupViewpickupviewpanel
     */
    protected created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof JXSPickupViewpickupviewpanel
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
     * @memberof JXSPickupViewpickupviewpanel
     */
    protected destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof JXSPickupViewpickupviewpanel
     */
    protected afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

}
</script>

<style lang='less'>
@import './jxspickup-viewpickupviewpanel-pickupviewpanel.less';
</style>