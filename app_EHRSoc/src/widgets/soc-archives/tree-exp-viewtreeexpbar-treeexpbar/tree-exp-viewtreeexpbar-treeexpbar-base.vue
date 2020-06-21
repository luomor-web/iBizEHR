<template>
    <split id="treeexpviewtreeexpbar" class='app-tree-exp-bar' v-model="split" mode="horizontal" @on-move-end="onSplitChange">
        <div slot='left'>
            <div class='tree-exp-bar-header'>
                <div>组织</div>
            </div>
            <div class='search-content'>
                <i-input :search="true"
                    @on-change="($event) => { this.srfnodefilter = $event.target.value; }"
                    @on-search="onSearch">
                </i-input>
            </div>
            <div class='tree-exp-content'>
                            <view_treeexpbar_tree 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :showBusyIndicator="true"
                updateAction='Update' 
                removeAction='Remove' 
                loadAction='Get' 
                createAction='Create' 
                :isSelectFirstDefault="true"
                :isBranchAvailable="true"
                name="treeexpbar_tree"  
                ref='treeexpbar_tree' 
                @selectionchange="treeexpbar_tree_selectionchange($event)"  
                @load="treeexpbar_tree_load($event)"  
                @closeview="closeView($event)">
            </view_treeexpbar_tree>
            </div>
        </div>
        <div slot='right'>
            <component 
              v-if="selection.view && !Object.is(this.selection.view.viewname, '')" 
              :is="selection.view.viewname"
              class="viewcontainer2"
              :viewDefaultUsage="false"
              :viewdata="JSON.stringify(selection.context)"
              :viewparam="JSON.stringify(selection.viewparam)"
              @viewdataschange="onViewDatasChange"
              @viewdatasactivated="viewDatasActivated"
              @viewload="onViewLoad">
            </component>
        </div>
    </split>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import SocArchivesService from '@/service/soc-archives/soc-archives-service';
import TreeExpViewtreeexpbarService from './tree-exp-viewtreeexpbar-treeexpbar-service';



@Component({
    components: {
      
    }
})
export default class TreeExpViewtreeexpbarBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof TreeExpViewtreeexpbarBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof TreeExpViewtreeexpbarBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof TreeExpViewtreeexpbarBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof TreeExpViewtreeexpbarBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public getControlType(): string {
        return 'TREEEXPBAR'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof TreeExpViewtreeexpbarBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {TreeExpViewtreeexpbarService}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public service: TreeExpViewtreeexpbarService = new TreeExpViewtreeexpbarService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {SocArchivesService}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public appEntityService: SocArchivesService = new SocArchivesService({ $store: this.$store });

    /**
     * treeexpbar_tree 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof TreeExpViewtreeexpbarBase
     */
    public treeexpbar_tree_selectionchange($event: any, $event2?: any) {
        this.treeexpbar_selectionchange($event, 'treeexpbar_tree', $event2);
    }

    /**
     * treeexpbar_tree 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof TreeExpViewtreeexpbarBase
     */
    public treeexpbar_tree_load($event: any, $event2?: any) {
        this.treeexpbar_load($event, 'treeexpbar_tree', $event2);
    }
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof TreeExpViewtreeexpbarBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof TreeExpViewtreeexpbarBase
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
     * 视图唯一标识
     *
     * @type {boolean}
     * @memberof TreeExpViewtreeexpbarBase
     */
    @Prop() public viewUID!:string;

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public getData(): any {
        return {};
    }

    /**
     * 选中数据
     *
     * @type {*}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public selection: any = {};

    /**
     * 控件宽度
     *
     * @type {number}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public ctrlWidth:number = 250;

    /**
     * 过滤值
     *
     * @type {string}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public srfnodefilter: string = '';

    /**
     * 刷新标识
     *
     * @public
     * @type {number}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public counter:number = 0;

    /**
     * 是否加载默认关联视图
     *
     * @public
     * @type {boolean}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public istLoadDefaultRefView: boolean = false;

    /**
     * 分割宽度
     *
     * @type {number}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public split: number = 0.2;

    /**
     * split值变化事件
     *
     * @memberof TreeExpViewtreeexpbarBase
     */
    public onSplitChange() {
        if(this.split){
          this.$store.commit("setViewSplit",{viewUID:this.viewUID,viewSplit:this.split});
        }
    }

    /**
     * 获取关系项视图
     *
     * @param {*} [arg={}]
     * @returns {*}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public getExpItemView(arg: any = {}): any {
        let expmode = arg.nodetype.toUpperCase();
        if (!expmode) {
            expmode = '';
        }
        if (Object.is(expmode, 'ALLORG')) {
            return {  
                viewname: 'soc-archives-grid-view', 
                parentdata: {},
                deKeyField:'socarchives'
			};
        }
        if (Object.is(expmode, 'SUBSUBORG')) {
            return {  
                viewname: 'soc-archives-org-grid-view', 
                parentdata: {"srfparentdefname":"n_ormorgid_eq","nodeid":"%NODEID%"},
                deKeyField:'socarchives'
			};
        }
        if (Object.is(expmode, 'SUBORG')) {
            return {  
                viewname: 'soc-archives-org-grid-view', 
                parentdata: {"srfparentdefname":"n_ormorgid_eq","nodeid":"%NODEID%"},
                deKeyField:'socarchives'
			};
        }
        return null;
    }

    /**
     * 树导航选中
     *
     * @param {any []} args
     * @param {string} [tag]
     * @param {*} [$event2]
     * @returns {void}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public treeexpbar_selectionchange(args: any [], tag?: string, $event2?: any): void {
        if (args.length === 0) {
            return ;
        }
        const arg:any = args[0];
        if (!arg.id) {
            return;
        }
        const nodetype = arg.id.split(';')[0];
        const refview = this.getExpItemView({ nodetype: nodetype });
        if (!refview) {
            return;
        }
        let tempViewparam:any = {};
        let tempContext:any ={};
        if(arg && arg.navfilter){
            this.counter += 1;
            Object.defineProperty(tempViewparam, arg.navfilter, {
                value : arg.srfkey,
                writable : true,
                enumerable : true,
                configurable : true
            })
            Object.assign(tempContext,{srfcounter:this.counter});
        }
        Object.assign(tempContext,JSON.parse(JSON.stringify(this.context)));
        if(arg.srfappctx){
            Object.assign(tempContext,JSON.parse(JSON.stringify(arg.srfappctx)));
        }
        // 计算导航上下文
        if(arg && arg.navigateContext && Object.keys(arg.navigateContext).length >0){
            let tempData:any = arg.curData?JSON.parse(JSON.stringify(arg.curData)):{};
            Object.assign(tempData,arg);
            let _context = this.$util.computedNavData(tempData,tempContext,tempViewparam,arg.navigateContext);
            Object.assign(tempContext,_context);
        }
        if(arg.srfparentdename){
            Object.assign(tempContext,{srfparentdename:arg.srfparentdename});
        }
        if(arg.srfparentkey){
            Object.assign(tempContext,{srfparentkey:arg.srfparentkey});
        }
        // 计算导航参数
        if(arg && arg.navigateParams && Object.keys(arg.navigateParams).length >0){
            let tempData:any = arg.curData?JSON.parse(JSON.stringify(arg.curData)):{};
            Object.assign(tempData,arg);
            let _params = this.$util.computedNavData(tempData,tempContext,tempViewparam,arg.navigateParams);
            Object.assign(tempViewparam,_params);
            this.counter += 1;
            Object.assign(tempContext,{srfcounter:this.counter});
        }
        this.selection = {};
        Object.assign(this.selection, { view: { viewname: refview.viewname } });
        Object.assign(this.selection,{'viewparam':tempViewparam,'context':tempContext});
        this.$emit('selectionchange',args);
        this.$forceUpdate();
    }

    /**
     * 树加载完成
     *
     * @param {any[]} args
     * @param {string} [tag]
     * @param {*} [$event2]
     * @returns {void}
     * @memberof TreeExpViewtreeexpbarBase
     */
    public treeexpbar_load(args: any[], tag?: string, $event2?: any): void {
        this.$emit('load',args);
    }

    /**
     * 执行搜索
     *
     * @memberof TreeExpViewtreeexpbarBase
     */
    public onSearch(): void {
        if (!this.viewState) {
            return;
        }
        this.istLoadDefaultRefView = false;
        this.viewState.next({ tag: 'treeexpbar_tree', action: 'filter', data: { srfnodefilter: this.srfnodefilter } });
    }

    /**
     * vue 声明周期
     *
     * @memberof @memberof TreeExpViewtreeexpbarBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof TreeExpViewtreeexpbarBase
     */    
    public afterCreated(){
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                this.istLoadDefaultRefView = false;
                this.viewState.next({ tag: 'treeexpbar_tree', action: action, data: data });
            });
        }
    }

    /**
    * Vue声明周期(组件渲染完毕)
    *
    * @memberof TreeExpViewtreeexpbarBase
    */
    public mounted() {
        this.afterMounted();     
    }

    /**
    * 执行mounted后的逻辑
    *
    * @memberof TreeExpViewtreeexpbarBase
    */
    public afterMounted(){ 
        if(this.$store.getters.getViewSplit(this.viewUID)){
            this.split = this.$store.getters.getViewSplit(this.viewUID);
        }else{
            let containerWidth:number = (document.getElementById("treeexpviewtreeexpbar") as any).offsetWidth;
            if(this.ctrlWidth){
                    this.split = this.ctrlWidth/containerWidth;
            }
            this.$store.commit("setViewSplit",{viewUID:this.viewUID,viewSplit:this.split}); 
        }  
    }


    /**
     * vue 生命周期
     *
     * @memberof TreeExpViewtreeexpbarBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof TreeExpViewtreeexpbarBase
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

    /**
     * 视图数据变化
     *
     * @param {*} $event
     * @memberof TreeExpViewtreeexpbarBase
     */
    public onViewDatasChange($event: any): void {
        this.$emit('selectionchange', $event);
    }

    /**
     * 视图数据被激活
     *
     * @param {*} $event
     * @memberof TreeExpViewtreeexpbarBase
     */
    public viewDatasActivated($event: any): void {
        this.$emit('activated', $event);
    }

    /**
     * 视图数据加载完成
     *
     * @param {*} $event
     * @memberof TreeExpViewtreeexpbarBase
     */
    public onViewLoad($event: any): void {
        this.$emit('load', $event);
    }
    
}
</script>

<style lang='less'>
@import './tree-exp-viewtreeexpbar-treeexpbar.less';
</style>
