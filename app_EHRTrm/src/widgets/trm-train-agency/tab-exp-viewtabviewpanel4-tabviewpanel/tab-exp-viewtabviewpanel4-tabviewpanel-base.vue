<template>
  <div class='tabviewpanel' style="height:100%;" v-if = 'isActivied' >
        <trm-hmatser-grid-view 
      class='viewcontainer2' 
      :viewdata="viewdata" 
      :viewparam="viewparam"
      @viewload="viewDatasChange($event)" 
      :viewDefaultUsage="false" >
    </trm-hmatser-grid-view>
  </div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import TrmTrainAgencyService from '@/service/trm-train-agency/trm-train-agency-service';
import TabExpViewtabviewpanel4Service from './tab-exp-viewtabviewpanel4-tabviewpanel-service';



@Component({
    components: {
      
    }
})
export default class TabExpViewtabviewpanel4Base extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof TabExpViewtabviewpanel4Base
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof TabExpViewtabviewpanel4Base
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof TabExpViewtabviewpanel4Base
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof TabExpViewtabviewpanel4Base
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof TabExpViewtabviewpanel4Base
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof TabExpViewtabviewpanel4Base
     */
    public getControlType(): string {
        return 'TABVIEWPANEL'
    }



    /**
     * 建构部件服务对象
     *
     * @type {TabExpViewtabviewpanel4Service}
     * @memberof TabExpViewtabviewpanel4Base
     */
    public service: TabExpViewtabviewpanel4Service = new TabExpViewtabviewpanel4Service({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {TrmTrainAgencyService}
     * @memberof TabExpViewtabviewpanel4Base
     */
    public appEntityService: TrmTrainAgencyService = new TrmTrainAgencyService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof TabExpViewtabviewpanel4Base
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof TabExpViewtabviewpanel4Base
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
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof TabExpViewtabviewpanel4Base
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof TabExpViewtabviewpanel4Base
     */
    public getData(): any {
        return null;
    }

    /**
     * 是否被激活
     *
     * @type {boolean}
     * @memberof TabExpViewtabviewpanel4Base
     */
    public isActivied: boolean = true;

    /**
     * 局部上下文
     *
     * @type {*}
     * @memberof TabExpViewtabviewpanel4Base
     */
    public localContext: any = null;

    /**
     * 局部视图参数
     *
     * @type {*}
     * @memberof TabExpViewtabviewpanel4Base
     */
    public localViewParam: any = null;

    /**
     * 传入上下文
     *
     * @type {string}
     * @memberof TabExpViewtabviewpanel4Base
     */
    public viewdata: string = JSON.stringify(this.context);

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof PickupViewpickupviewpanel
     */
    public viewparam: string = JSON.stringify(this.viewparams);

    /**
     * 视图面板过滤项
     *
     * @type {string}
     * @memberof TabExpViewtabviewpanel4Base
     */
    public navfilter: string = "";
             
    /**
     * vue 生命周期
     *
     * @returns
     * @memberof TabExpViewtabviewpanel4Base
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof TabExpViewtabviewpanel4Base
     */    
    public afterCreated(){
        this.initNavParam();
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                this.$forceUpdate();
                this.$nextTick(() => {
                    this.initNavParam();
                });
            });
        }
    }

    /**
     * 初始化导航参数
     *
     * @memberof TabExpViewtabviewpanel4Base
     */
    public initNavParam(){
        if(!Object.is(this.navfilter,"")){
            Object.assign(this.viewparams,{[this.navfilter]:this.context['majorentity']})
        }
        if(this.localContext && Object.keys(this.localContext).length >0){
            let _context:any = this.$util.computedNavData({},this.context,this.viewparams,this.localContext);
            Object.assign(this.context,_context);
        }
        if(this.localViewParam && Object.keys(this.localViewParam).length >0){
            let _param:any = this.$util.computedNavData({},this.context,this.viewparams,this.localViewParam);
            Object.assign(this.viewparams,_param);
        }
        this.viewdata =JSON.stringify(this.context);
        this.viewparam = JSON.stringify(this.viewparams);
    }

    /**
     * 视图数据变化
     *
     * @memberof TabExpViewtabviewpanel4Base
     */
    public viewDatasChange($event:any){
        this.$emit('viewpanelDatasChange',$event);
    }

    /**
     * vue 生命周期
     *
     * @memberof TabExpViewtabviewpanel4Base
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof TabExpViewtabviewpanel4Base
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }



}
</script>

<style lang='less'>
@import './tab-exp-viewtabviewpanel4-tabviewpanel.less';
</style>