<template>
    <div class = "drtab">
        <tabs :animated='false' class='app-dr-tab' name='default' @on-click="tabPanelClick">
                <tab-pane v-if="isShowSlot" :index='0' name='form' tab='default' class='' :disabled='items[0].disabled'
                label='异动挂职明细'>
                <div class='main-data'>
                    <slot></slot>
                </div>
            </tab-pane>
            </tabs>
    </div>    
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import PcmYdgzmxService from '@/service/pcm-ydgzmx/pcm-ydgzmx-service';
import DefaultService from './default-drtab-service';



@Component({
    components: {
      
    }
})
export default class DefaultBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof DefaultBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof DefaultBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof DefaultBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof DefaultBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof DefaultBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof DefaultBase
     */
    public getControlType(): string {
        return 'DRTAB'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof DefaultBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {DefaultService}
     * @memberof DefaultBase
     */
    public service: DefaultService = new DefaultService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PcmYdgzmxService}
     * @memberof DefaultBase
     */
    public appEntityService: PcmYdgzmxService = new PcmYdgzmxService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof DefaultBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof DefaultBase
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
     * 是否显示插槽
     *
     * @type {string}
     * @memberof DefaultBase
     */
    @Prop({default:true}) public isShowSlot?: boolean;

    /**
     *  应用实体参数名称
     *
     * @type string
     * @memberof DefaultBase
     */
    @Prop() public parentName!: string;

    /**
     *  表单数据
     *
     * @type {*}
     * @memberof DefaultBase
     */
    @Prop({default:{}}) public formData?:any;
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof DefaultBase
     */
    public getDatas(): any[] {
        return this.items;
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof DefaultBase
     */
    public getData(): any {
        return this.selection;
    }

    /**
     * 数据选中项
     *
     * @type {*}
     * @memberof DefaultBase
     */
    public selection: any = {};

    /**
     * 父数据
     *
     * @public
     * @type {*}
     * @memberof DefaultBase
     */
    public parentData: any = {};

    /**
     * 关系栏数据项
     *
     * @type {any[]}
     * @memberof DefaultBase
     */
    public items: any[] = [
        {
            index: 0, 
            id: 'form',
            name: 'form', 
            text: '异动挂职明细', 
            disabled: false, 
        },
    ];

    /**
     * 关系栏数据项导航参数集合
     *
     * @type {any[]}
     * @memberof DefaultBase
     */
    public navParamsArray:Array<any> = [
    ];

    /**
     * 生命周期
     *
     * @memberof DefaultBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof DefaultBase
     */    
    public afterCreated(){
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('state', action)) {
                    const state = !this.context.pcmydgzmx ? true : false;
                    this.setItemDisabled(state);
                }
            });
        }
        this.$nextTick(() => {
            this.$emit('selectionchange', [this.items[0]]);
        });
    }

    /**
     * vue 生命周期
     *
     * @memberof DefaultBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof DefaultBase
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

    /**
     * 获取关系项
     *
     * @public
     * @param {*} [arg={}]
     * @returns {*}
     * @memberof DefaultBase
     */
    public getDRTabItem(arg: any = {}): any {
        let expmode = arg.nodetype.toUpperCase();
        if (!expmode) {
            expmode = '';
        }
        return undefined;
    }

    /**
     * 设置关系项状态
     *
     * @param {boolean} state
     * @memberof DefaultBase
     */
    public setItemDisabled(state: boolean): void {
        this.items.forEach((item: any) => {
            if (Object.is(item.name, 'form')) {
                item.disabled = false;
            } else {
                item.disabled = state;
            }
        });
    }

    /**
     * 获取数据项
     *
     * @public
     * @param {string} id
     * @returns {*}
     * @memberof DefaultBase
     */
    public getItem(id: string): any {
        const arr: any[] = this.items.filter((_item: any) => Object.is(_item.id, id));
        if (arr) {
            return arr[0];
        }
        return null;
    }

    /**
     * 初始化导航参数
     *
     * @param {*} drItem
     * @memberof DefaultBase
     */
    public initNavParam(drItem:any){
        let returnNavParam:any = {};
        if(drItem && drItem.id){
            let curDRItem:any = this.navParamsArray.find((item:any) =>{
                return Object.is(item.id,drItem.id);
            })
            if(curDRItem){
                let localContext:any = curDRItem.localContext;
                let localViewParam:any = curDRItem.localViewParam;
                if(localContext && Object.keys(localContext).length >0){
                    let _context:any = this.$util.computedNavData(this.formData,this.context,this.viewparams,localContext);
                    returnNavParam.localContext = _context;
                }
                if(localViewParam && Object.keys(localViewParam).length >0){
                    let _params:any = this.$util.computedNavData(this.formData,this.context,this.viewparams,localViewParam);
                    returnNavParam.localViewParam = _params;
                }
                return returnNavParam;
            }else{
                return null;
            }
        }
    }

    /**
     * 选中节点
     *
     * @param {*} $event
     * @memberof DefaultBase
     */
    public tabPanelClick($event: any): void {
        const item = this.getItem($event);
        if (Object.is(item.id, this.selection.id)) {
            return;
        }
        this.$emit('selectionchange', [item]);
        let localNavParam:any = this.initNavParam(item);
        const refview = this.getDRTabItem({ nodetype: item.id });
        this.selection = {};
        const _context: any = { ...JSON.parse(JSON.stringify(this.context)) };
        if(localNavParam && localNavParam.localContext){
            Object.assign(_context,localNavParam.localContext);
        }
        Object.assign(_context,{srfparentdename:this.parentName,srfparentkey:_context[this.parentName.toLowerCase()]});
        const _params: any = {};
        if(localNavParam && localNavParam.localViewParam){
            Object.assign(_params,localNavParam.localViewParam);
        }
        if (refview && refview.parentdatajo) {
            Object.assign(_context, refview.parentdatajo);
            Object.assign(this.selection, { view: { viewname: refview.viewname }, data: _context, param: _params });
        }
        Object.assign(this.selection, item);
    }

}
</script>

<style lang='less'>
@import './default-drtab.less';
</style>