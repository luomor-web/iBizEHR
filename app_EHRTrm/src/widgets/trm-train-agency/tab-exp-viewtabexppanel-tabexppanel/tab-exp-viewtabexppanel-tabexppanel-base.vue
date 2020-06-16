
<template>
  <div class='tabviewpanel' style="height:100%;">
        <tabs :animated="false" class='tabexppanel' name='tabexpviewtabexppanel' @on-click="tabPanelClick">
        <tab-pane :index="0" name='tabviewpanel4' tab='tabexpviewtabexppanel' class=''  
            :label="(h) =>{
                return h('div', [
                    h('span', '培训班主任'),
                    h('Badge', {
                        props: {
                            count: undefined,
                            type: 'primary'
                        }
                    })
                ])
            }" >
            <view_tabviewpanel4 
    :viewState="viewState"  
    :viewparams="JSON.parse(JSON.stringify(viewparams))" 
    :context="JSON.parse(JSON.stringify(context))" 
    v-if="isInit.tabviewpanel4"
    name="tabviewpanel4"  
    ref='tabviewpanel4'
    @viewpanelDatasChange = "tabViewPanelDatasChange"
    @closeview="closeView($event)">
</view_tabviewpanel4>
        </tab-pane>
        <tab-pane :index="1" name='tabviewpanel' tab='tabexpviewtabexppanel' class=''  
            :label="(h) =>{
                return h('div', [
                    h('span', '培训机构信息'),
                    h('Badge', {
                        props: {
                            count: undefined,
                            type: 'primary'
                        }
                    })
                ])
            }" >
            <view_tabviewpanel 
    :viewState="viewState"  
    :viewparams="JSON.parse(JSON.stringify(viewparams))" 
    :context="JSON.parse(JSON.stringify(context))" 
    v-if="isInit.tabviewpanel"
    name="tabviewpanel"  
    ref='tabviewpanel'
    @viewpanelDatasChange = "tabViewPanelDatasChange"
    @closeview="closeView($event)">
</view_tabviewpanel>
        </tab-pane>
        <tab-pane :index="2" name='tabviewpanel2' tab='tabexpviewtabexppanel' class=''  
            :label="(h) =>{
                return h('div', [
                    h('span', '培训师资'),
                    h('Badge', {
                        props: {
                            count: undefined,
                            type: 'primary'
                        }
                    })
                ])
            }" >
            <view_tabviewpanel2 
    :viewState="viewState"  
    :viewparams="JSON.parse(JSON.stringify(viewparams))" 
    :context="JSON.parse(JSON.stringify(context))" 
    v-if="isInit.tabviewpanel2"
    name="tabviewpanel2"  
    ref='tabviewpanel2'
    @viewpanelDatasChange = "tabViewPanelDatasChange"
    @closeview="closeView($event)">
</view_tabviewpanel2>
        </tab-pane>
        <tab-pane :index="3" name='tabviewpanel3' tab='tabexpviewtabexppanel' class=''  
            :label="(h) =>{
                return h('div', [
                    h('span', '培训记录'),
                    h('Badge', {
                        props: {
                            count: undefined,
                            type: 'primary'
                        }
                    })
                ])
            }" >
            <view_tabviewpanel3 
    :viewState="viewState"  
    :viewparams="JSON.parse(JSON.stringify(viewparams))" 
    :context="JSON.parse(JSON.stringify(context))" 
    v-if="isInit.tabviewpanel3"
    name="tabviewpanel3"  
    ref='tabviewpanel3'
    @viewpanelDatasChange = "tabViewPanelDatasChange"
    @closeview="closeView($event)">
</view_tabviewpanel3>
        </tab-pane>
    </tabs>
  </div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import TrmTrainAgencyService from '@/service/trm-train-agency/trm-train-agency-service';
import TabExpViewtabexppanelService from './tab-exp-viewtabexppanel-tabexppanel-service';



@Component({
    components: {
      
    }
})
export default class TabExpViewtabexppanelBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof TabExpViewtabexppanel
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof TabExpViewtabexppanel
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof TabExpViewtabexppanel
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof TabExpViewtabexppanel
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof TabExpViewtabexppanel
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof TabExpViewtabexppanel
     */
    public getControlType(): string {
        return 'TABEXPPANEL'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof TabExpViewtabexppanel
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {TabExpViewtabexppanelService}
     * @memberof TabExpViewtabexppanel
     */
    public service: TabExpViewtabexppanelService = new TabExpViewtabexppanelService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {TrmTrainAgencyService}
     * @memberof TabExpViewtabexppanel
     */
    public appEntityService: TrmTrainAgencyService = new TrmTrainAgencyService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof TabExpViewtabexppanel
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof TabExpViewtabexppanel
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
     * 是否初始化
     *
     * @returns {any}
     * @memberof TabExpViewtabexppanel
     */
    public isInit: any = {
        tabviewpanel4:  true ,
        tabviewpanel:  false ,
        tabviewpanel2:  false ,
        tabviewpanel3:  false ,
    }

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof TabExpViewtabexppanel
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof TabExpViewtabexppanel
     */
    public getData(): any {
        return null;
    }

    /**
     * 行为参数
     *
     * @public
     * @type {*}
     * @memberof TabExpViewtabexppanel
     */
    public action:any = '';

    /**
     * 被激活的分页面板
     *
     * @type {string}
     * @memberof TabExpViewtabexppanel
     */
    public activiedTabViewPanel: string = 'tabviewpanel4';

    /**
     * 分页视图面板数据变更
     *
     * @memberof TabExpViewtabexppanel
     */
    public tabViewPanelDatasChange(){
        this.counterRefresh();
    }

    /**
     * vue 生命周期
     *
     * @returns
     * @memberof TabExpViewtabexppanel
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof TabExpViewtabexppanel
     */    
    public afterCreated(){
        //设置分页导航srfparentdename和srfparentkey
        if(this.context.trmtrainagency){
            Object.assign(this.context,{srfparentdename:'TrmTrainAgency',srfparentkey:this.context.trmtrainagency})
        }
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                this.action = action;
                this.viewState.next({ tag: this.activiedTabViewPanel, action: action, data: data });
                this.$forceUpdate();
            });
        }
    }    

    /**
     * vue 生命周期
     *
     * @memberof TabExpViewtabexppanel
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof TabExpViewtabexppanel
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

    /**
     * 分页面板选中
     *
     * @param {*} $event
     * @returns
     * @memberof TabExpViewtabexppanel
     */
    public tabPanelClick($event: any) {
        if (!$event) {
            return;
        }
        this.isInit[$event] = true;
        if (!this.viewState) {
            return;
        }
        this.activiedTabViewPanel = $event;
        this.viewState.next({ tag: this.activiedTabViewPanel, action: this.action, data: {}});
    }



}
</script>

<style lang='less'>
@import './tab-exp-viewtabexppanel-tabexppanel.less';
</style>