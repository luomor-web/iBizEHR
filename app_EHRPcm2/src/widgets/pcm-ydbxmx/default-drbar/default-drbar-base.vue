<template>
<layout class='app-dr-bar'>
    <sider :width="width">
        <el-menu
            :default-openeds="defaultOpeneds"
            :default-active="items[0].id"
            @select="onSelect"
            @open="onOpen"
            @close="onClose">
            <app-sider-menus :menus="items"></app-sider-menus>
        </el-menu>
    </sider>
    <content :style="{ width: `calc(100% - ${this.width + 1}px)` }">
        <div class='main-data' v-show="Object.is(this.selection.id, 'form')">
            <slot></slot>
        </div>
        <component
          v-if="!Object.is(this.selection.id, 'form') && this.selection.view && !Object.is(this.selection.view.viewname, '')"
          :is="selection.view.viewname"
          class="viewcontainer2"
          :viewDefaultUsage="false"
          :viewdata="JSON.stringify(selection.data)"
          :viewparam="JSON.stringify(selection.param)"
          :key="this.$util.createUUID()">
        </component>
    </content>
</layout>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import PcmYdbxmxService from '@/service/pcm-ydbxmx/pcm-ydbxmx-service';
import DefaultService from './default-drbar-service';



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
        return 'DRBAR'
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
     * @type {PcmYdbxmxService}
     * @memberof DefaultBase
     */
    public appEntityService: PcmYdbxmxService = new PcmYdbxmxService({ $store: this.$store });
    


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
     * 加载行为
     *
     * @type {string}
     * @memberof DefaultBase
     */
    @Prop() public loadAction?: string;

    /**
     *  表单数据
     *
     * @type {*}
     * @memberof DefaultBase
     */
    @Prop({default:{}}) public formData?:any;

    /**
     * 数据选中项
     *
     * @type {*}
     * @memberof DefaultBase
     */
    public selection: any = {};

    /**
     * 关系栏数据项
     *
     * @type {any[]}
     * @memberof DefaultBase
     */
    public items: any[] = [
        {
            text: "主表单",
            disabled: false,
            id: "form",
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
     * 默认打开项
     *
     * @type {string[]}
     * @memberof DefaultBase
     */
    public defaultOpeneds: string[] = [];

    /**
     * 父数据
     *
     * @public
     * @type {*}
     * @memberof DefaultBase
     */
    public parentData: any = {};

    /**
     * 宽度
     *
     * @type {number}
     * @memberof DefaultBase
     */
    public width: number = 240;

    /**
     * 生命周期
     *
     * @memberof DefaultBase
     */
    public created(): void {
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('state', action)) {
                    const state = !this.context.pcmydbxmx ? true : false;
                    this.setItemDisabled(this.items, state);
                }
            });
        }
        this.$nextTick(() => {
            this.onSelect(this.items[0].id)
            this.$emit('selectionchange', [this.items[0]]);
        });
    }

    /**
     * vue 生命周期
     *
     * @memberof DefaultBase
     */
    public destroyed() {
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
    public getDRBarItem(arg: any = {}): any {
        let expmode = arg.nodetype;
        if (!expmode) {
            expmode = '';
        }
        return undefined;
    }

    /**
     * 处理数据
     *
     * @public
     * @param {any[]} items
     * @memberof DefaultBase
     */
    public dataProcess(items: any[]): void {
        items.forEach((_item: any) => {
            if (_item.expanded) {
                this.defaultOpeneds.push(_item.id);
            }

            _item.disabled = false;
            if (_item.items && Array.isArray(_item.items) && _item.items.length > 0) {
                this.dataProcess(_item.items);
            }
        });
    }

    /**
     * 获取子项
     *
     * @param {any[]} items
     * @param {string} id
     * @returns {*}
     * @memberof DefaultBase
     */
    public getItem(items: any[], id: string): any {
        const item: any = {};
        items.some((_item: any) => {
            if (Object.is(_item.id, id)) {
                Object.assign(item, _item);
                return true;
            }
            if (_item.items && _item.items.length > 0) {
                const subItem = this.getItem(_item.items, id);
                if (Object.keys(subItem).length > 0) {
                    Object.assign(item, subItem);
                    return true;
                }
            }
            return false;
        });
        return item;
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
     * 节点选中
     *
     * @param {*} $event
     * @memberof DefaultBase
     */
    public onSelect($event: any): void {
        const item = this.getItem(this.items, $event);
        if (Object.is(item.id, this.selection.id)) {
            return;
        }
        this.$emit('selectionchange', [item]);
        let localNavParam:any = this.initNavParam(item);
        const refview = this.getDRBarItem({ nodetype: item.id });
        this.selection = {};
        const _context: any = { ...JSON.parse(JSON.stringify(this.context)) };
        if(localNavParam && localNavParam.localContext){
            Object.assign(_context,localNavParam.localContext);
        }
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

    /**
     * 子节点打开
     *
     * @param {*} $event
     * @memberof DefaultBase
     */
    public onOpen($event: any): void {
        const item = this.getItem(this.items, $event);
        if (Object.is(item.id, this.selection.id)) {
            return;
        }
        this.selection = {};
        Object.assign(this.selection, item);
        if (Object.is(item.id, 'form') || (item.viewname && !Object.is(item.viewname, ''))) {
            this.$emit('selectionchange', [this.selection]);
        }
    }

    /**
     * 子节点关闭
     *
     * @param {*} $event
     * @memberof DefaultBase
     */
    public onClose($event: any): void {
        const item = this.getItem(this.items, $event);
        if (Object.is(item.id, this.selection.id)) {
            return;
        }
        this.selection = {};
        Object.assign(this.selection, item);
        if (Object.is(item.id, 'form') || (item.viewname && !Object.is(item.viewname, ''))) {
            this.$emit('selectionchange', [this.selection]);
        }
    }

    /**
     * 设置关系项状态
     *
     * @param {any[]} items
     * @param {boolean} state
     * @memberof DefaultBase
     */
    public setItemDisabled(items: any[], state: boolean) {
        items.forEach((item: any) => {
            if (!Object.is(item.id, 'form')) {
                item.disabled = state;
            }
            if (item.items && Array.isArray(item.items)) {
                this.setItemDisabled(item.items, state);
            }
        });
    }

}
</script>

<style lang='less'>
@import './default-drbar.less';
</style>