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
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import PIMPERSONService from '@/service/pimperson/pimperson-service';
import YGCDService from './ygcd-drbar-service';



@Component({
    components: {
      
    }
})
export default class YGCDBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof YGCD
     */
    @Prop() protected name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof YGCD
     */
    @Prop() protected viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof YGCD
     */
    @Prop() protected context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof YGCD
     */
    @Prop() protected viewparams: any;

    /**
     * 视图状态事件
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof YGCD
     */
    protected viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof YGCD
     */
    protected getControlType(): string {
        return 'DRBAR'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof YGCD
     */    
    protected counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {YGCDService}
     * @memberof YGCD
     */
    protected service: YGCDService = new YGCDService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PIMPERSONService}
     * @memberof YGCD
     */
    protected appEntityService: PIMPERSONService = new PIMPERSONService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof YGCD
     */
    protected closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof YGCD
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
     * @memberof YGCD
     */
    public getDatas(): any[] {
        return this.items;
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof YGCD
     */
    public getData(): any {
        return this.selection;
    }

    /**
     * 加载行为
     *
     * @type {string}
     * @memberof YGCD
     */
    @Prop() public loadAction?: string;

    /**
     * 数据选中项
     *
     * @type {*}
     * @memberof YGCD
     */
    public selection: any = {};

    /**
     * 关系栏数据项
     *
     * @type {any[]}
     * @memberof YGCD
     */
    public items: any[] = [
        {
            text: "员工信息",
            disabled: false,
            id: "dritem24",
            iconcls: '',
            icon: '../../../img/jcgl/1/gerenxinxi.png',
        },
        {
            text: "分配信息",
            disabled: false,
            id: "dritem7",
            iconcls: '',
            icon: '../../../img/jcgl/1/fenpeixinxi.png',
        },
        {
            text: "教育信息",
            disabled: false,
            id: "dritem4",
            iconcls: '',
            icon: '../../../img/jcgl/1/jiaoyuxinxi.png',
        },
        {
            text: "语言能力",
            disabled: false,
            id: "dritem14",
            iconcls: '',
            icon: '../../../img/jcgl/1/yuyanshuiping.png',
        },
        {
            text: "家庭情况",
            disabled: false,
            id: "dritem3",
            iconcls: '',
            icon: '../../../img/jcgl/1/jiatingqingkuang.png',
        },
        {
            text: "工作履历",
            disabled: false,
            id: "dritem1",
            iconcls: '',
            icon: '../../../img/jcgl/1/gongzuolvli.png',
        },
        {
            text: "档案信息",
            disabled: false,
            id: "dritem18",
            iconcls: '',
            icon: '../../../img/jcgl/1/danganxinxi.png',
        },
        {
            text: "绩效信息",
            disabled: false,
            id: "dritem6",
            iconcls: '',
            icon: '../../../img/jcgl/1/jixiaoxinxi.png',
        },
        {
            text: "考勤信息",
            disabled: false,
            id: "dritem22",
            iconcls: '',
            icon: '../../../img/jcgl/1/kaoqinxinxi.png',
        },
        {
            text: "合同信息",
            disabled: false,
            id: "dritem9",
            iconcls: '',
            icon: '../../../img/jcgl/1/hetongxinxi.png',
        },
        {
            text: "证书信息",
            disabled: false,
            id: "dritem26",
            iconcls: '',
            icon: '../../../img/jcgl/1/zhiyezigemuluguanli.png',
        },
        {
            text: "奖励惩罚",
            disabled: false,
            id: "dritem23",
            iconcls: '',
            icon: '../../../img/jcgl/1/jianglichengfa.png',
        },
        {
            text: "培训记录",
            disabled: false,
            id: "dritem20",
            iconcls: '',
            icon: '../../../img/kfgl/1/peixunjiluguanli.png',
        },
        {
            text: "军转干部",
            disabled: false,
            id: "dritem17",
            iconcls: '',
            icon: '../../../img/jcgl/1/junzhuanganbu.png',
        },
        {
            text: "学术成果",
            disabled: false,
            id: "dritem27",
            iconcls: '',
            icon: '../../../img/jcgl/1/keyanchengguo.png',
        },
        {
            text: "能力模型",
            disabled: false,
            id: "dritem25",
            iconcls: 'fa fa-pencil',
            icon: '',
        },
    ];

    /**
     * 默认打开项
     *
     * @type {string[]}
     * @memberof YGCD
     */
    public defaultOpeneds: string[] = [];

    /**
     * 父数据
     *
     * @private
     * @type {*}
     * @memberof YGCD
     */
    private parentData: any = {};

    /**
     * 宽度
     *
     * @type {number}
     * @memberof YGCD
     */
    public width: number = 240;

    /**
     * 生命周期
     *
     * @memberof YGCD
     */
    public created(): void {
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('state', action)) {
                    const state = !this.context.pimperson ? true : false;
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
     * @memberof YGCD
     */
    public destroyed() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

    /**
     * 获取关系项
     *
     * @private
     * @param {*} [arg={}]
     * @returns {*}
     * @memberof YGCD
     */
    private getDRBarItem(arg: any = {}): any {
        let expmode = arg.nodetype;
        if (!expmode) {
            expmode = '';
        }
        if (Object.is(expmode, 'dritem3')) {
            return {  
                viewname: 'pimfaminfopimfim-grid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem20')) {
            return {  
                viewname: 'trmtrianpersongrid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem14')) {
            return {  
                viewname: 'pimlanguageabilityyynlgrid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem23')) {
            return {  
                viewname: 'pimrewardpunishmentpim-jangl-grid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem4')) {
            return {  
                viewname: 'pimeducationpim-edu-grid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem22')) {
            return {  
                viewname: 'attendancemreportmxwsc-grid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem25')) {
            return {  
                viewname: 'pimperson-ability-grid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem7')) {
            return {  
                viewname: 'pimdistirbutionygfen-pei-grid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem24')) {
            return {  
                viewname: 'pimpersonzdedit-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem6')) {
            return {  
                viewname: 'pimachievementspim-jix-grid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem27')) {
            return {  
                viewname: 'pimpersonxscgedit-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem9')) {
            return {  
                viewname: 'pimcontractwssgrid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem26')) {
            return {  
                viewname: 'pimpersonzhzcedit-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem1')) {
            return {  
                viewname: 'pimworkhistorypim-work-grid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem17')) {
            return {  
                viewname: 'pimarmycadresarmygrid-view', 
                parentdatajo: {},
			};
        }
        if (Object.is(expmode, 'dritem18')) {
            return {  
                viewname: 'pimarchivespim-danga-grid-view', 
                parentdatajo: {},
			};
        }
        return undefined;
    }

    /**
     * 处理数据
     *
     * @private
     * @param {any[]} items
     * @memberof YGCD
     */
    private dataProcess(items: any[]): void {
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
     * @memberof YGCD
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
     * 节点选中
     *
     * @param {*} $event
     * @memberof YGCD
     */
    public onSelect($event: any): void {
        const item = this.getItem(this.items, $event);
        if (Object.is(item.id, this.selection.id)) {
            return;
        }

        this.$emit('selectionchange', [item]);

        const refview = this.getDRBarItem({ nodetype: item.id });
        this.selection = {};
        const _context: any = { ...JSON.parse(JSON.stringify(this.context)) };
        const _params: any = { ...JSON.parse(JSON.stringify(this.viewparams)) };
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
     * @memberof YGCD
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
     * @memberof YGCD
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
     * @memberof YGCD
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
@import './ygcd-drbar.less';
</style>