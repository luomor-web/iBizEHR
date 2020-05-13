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
import OrmSignOrgService from '@/service/orm-sign-org/orm-sign-org-service';
import HTQDDWWPickupViewpickupviewpanelService from './htqddwwpickup-viewpickupviewpanel-pickupviewpanel-service';

import HTQDDWWPickupViewpickupviewpanelModel from './htqddwwpickup-viewpickupviewpanel-pickupviewpanel-model';


@Component({
    components: {
      
    }
})
export default class HTQDDWWPickupViewpickupviewpanelBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    @Prop() protected name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    @Prop() protected viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    @Prop() protected context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    @Prop() protected viewparams: any;

    /**
     * 视图状态事件
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected getControlType(): string {
        return 'PICKUPVIEWPANEL'
    }



    /**
     * 建构部件服务对象
     *
     * @type {HTQDDWWPickupViewpickupviewpanelService}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected service: HTQDDWWPickupViewpickupviewpanelService = new HTQDDWWPickupViewpickupviewpanelService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {OrmSignOrgService}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected appEntityService: OrmSignOrgService = new OrmSignOrgService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof HTQDDWWPickupViewpickupviewpanel
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
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    @Prop() protected selectedData?: string;

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    public getData(): any {
        return {};
    }

    /**
     * 视图名称
     *
     * @type {*}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected view: any = {
        viewname: 'orm-sign-org-htqddwpickup-grid-view',
        data: {},
    }

    /**
     * 视图数据
     *
     * @type {*}
     * @memberof HTQDDWWPickupViewpickupviewpanel
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
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    @Prop({default: true}) protected isShowButton!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    @Prop() protected isSingleSelect?: boolean;

    /**
     * 初始化完成
     *
     * @type {boolean}
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected inited: boolean = false;

    /**
     * 视图数据变化
     *
     * @param {*} $event
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected onViewDatasChange($event: any): void {
        if($event.length>0){
          $event.forEach((item:any,index:any) => {
              let srfmajortext = item['ormsignorgname'];
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
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected viewDatasActivated($event: any): void {
        this.$emit('activated', $event);
    }

    /**
     * 视图加载完成
     *
     * @param {*} $event
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected onViewLoad($event: any): void {
        this.$emit('load', $event);
    }

    /**
     * vue 生命周期
     *
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof HTQDDWWPickupViewpickupviewpanel
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
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof HTQDDWWPickupViewpickupviewpanel
     */
    protected afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

}
</script>

<style lang='less'>
@import './htqddwwpickup-viewpickupviewpanel-pickupviewpanel.less';
</style>