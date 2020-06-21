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
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import PimPersonService from '@/service/pim-person/pim-person-service';
import YXZFPPickupViewpickupviewpanelService from './yxzfppickup-viewpickupviewpanel-pickupviewpanel-service';

import YXZFPPickupViewpickupviewpanelModel from './yxzfppickup-viewpickupviewpanel-pickupviewpanel-model';


@Component({
    components: {
      
    }
})
export default class YXZFPPickupViewpickupviewpanelBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public getControlType(): string {
        return 'PICKUPVIEWPANEL'
    }



    /**
     * 建构部件服务对象
     *
     * @type {YXZFPPickupViewpickupviewpanelService}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public service: YXZFPPickupViewpickupviewpanelService = new YXZFPPickupViewpickupviewpanelService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PimPersonService}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public appEntityService: PimPersonService = new PimPersonService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof YXZFPPickupViewpickupviewpanelBase
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
     * @memberof YXZFPPickupViewpickupviewpanel
     */
    @Prop({ default: 'DEFAULT' })
    protected openMode!: 'DEFAULT' | 'MODAL';

    /**
     * 选中数据字符串
     *
     * @type {string}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    @Prop() public selectedData?: string;

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public getData(): any {
        return {};
    }

    /**
     * 视图名称
     *
     * @type {*}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public view: any = {
        viewname: 'pim-person-yxzfppickup-grid-view',
        data: {},
    }

    /**
     * 局部上下文
     *
     * @type {*}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public localContext: any = null;

    /**
     * 局部视图参数
     *
     * @type {*}
     * @memberof PickupViewpickupviewpanel
     */
    public localViewParam: any = null;

    /**
     * 视图数据
     *
     * @type {*}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public viewdata: string  = JSON.stringify(this.context);

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof PickupViewpickupviewpanel
     */
    public viewparam: string  = JSON.stringify(this.viewparams);

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    @Prop({default: true}) public isShowButton!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    @Prop() public isSingleSelect?: boolean;

    /**
     * 初始化完成
     *
     * @type {boolean}
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public inited: boolean = false;

    /**
     * 视图数据变化
     *
     * @param {*} $event
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public onViewDatasChange($event: any): void {
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
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public viewDatasActivated($event: any): void {
        this.$emit('activated', $event);
    }

    /**
     * 视图加载完成
     *
     * @param {*} $event
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public onViewLoad($event: any): void {
        this.$emit('load', $event);
    }

    /**
     * vue 生命周期
     *
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof YXZFPPickupViewpickupviewpanelBase
     */    
    public afterCreated(){
        this.initNavParam();
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
     * 初始化导航参数
     *
     *  @memberof YXZFPPickupViewpickupviewpanelBase
     */  
    public initNavParam(){
        if(this.localContext && Object.keys(this.localContext).length >0){
            let _context:any = this.$util.computedNavData({},this.context,this.viewparams,this.localContext);
            Object.assign(this.context,_context);
        }
        if(this.localViewParam && Object.keys(this.localViewParam).length >0){
            let _param:any = this.$util.computedNavData({},this.context,this.viewparams,this.localViewParam);
            Object.assign(this.viewparams,_param);
        }
        this.viewdata = JSON.stringify(this.context);
        this.viewparam = JSON.stringify(this.viewparams);
    }


    /**
     * vue 生命周期
     *
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof YXZFPPickupViewpickupviewpanelBase
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

}
</script>

<style lang='less'>
@import './yxzfppickup-viewpickupviewpanel-pickupviewpanel.less';
</style>