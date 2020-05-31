import { Vue, Component, Prop, Emit, Watch, Model } from 'vue-property-decorator';
import './app-header-menus.less';

/**
 * 绘制应用头部菜单
 *
 * @export
 * @class AppHeaderMenus
 * @extends {Vue}
 */
@Component({})
export class AppHeaderMenus extends Vue {

    /**
     * 所有菜单项
     *
     * @type {any[]}
     * @memberof AppHeaderMenus
     */
    @Prop({ default: () => [] })
    public menus!: any[];
    @Watch('menus', { deep: true, immediate: true })
    public watchMenus(menus: any[]): void {
        if (menus && menus.length > 0) {
            this.items = this.menus;
            this.$forceUpdate();
        }
    }

    /**
     * 展示菜单项
     *
     * @protected
     * @type {any[]}
     * @memberof AppHeaderMenus
     */
    protected items: any[] = [];

    /**
     * 工具栏模型
     *
     * @protected
     * @type {*}
     * @memberof AppHeaderMenus
     */
    @Prop()
    protected toolbarModel?: any;

    /**
     * 工具栏展示模式
     *
     * @protected
     * @type {('default' | 'view' | 'view2')}
     * @memberof AppHeaderMenus
     */
    @Prop({ default: 'default' })
    protected mode!: 'default' | 'view' | 'view2';

    /**
     * 视图呈现模式
     *
     * @type {string}
     * @memberof AppLayout
     */
    @Prop({ default: 'DEFAULT' })
    public openMode!: string;

    /**
     * 是否启用快捷搜索
     *
     * @protected
     * @type {boolean}
     * @memberof AppHeaderMenus
     */
    @Prop({ default: false })
    protected isEnableQuickSearch!: boolean;

    /**
     * 搜索框值
     *
     * @protected
     * @type {string}
     * @memberof AppHeaderMenus
     */
    @Model('change', { default: '' })
    protected searchValue!: string;

    /**
     * input绑定的搜索框值
     *
     * @protected
     * @type {string}
     * @memberof AppHeaderMenus
     */
    protected inputSearchValue: string = this.searchValue;

    /**
     * 搜索框提示内容
     *
     * @protected
     * @type {string}
     * @memberof AppHeaderMenus
     */
    @Prop({ default: '请输入' })
    protected searchPlaceholder!: string;

    /**
     * 是否激活搜索框
     *
     * @protected
     * @type {boolean}
     * @memberof AppHeaderMenus
     */
    protected isActiveSearch: boolean = false;

    /**
     * 监控工具栏模型
     *
     * @param {*} val
     * @param {*} oldVal
     * @memberof AppHeaderMenus
     */
    @Watch('toolbarModel', { deep: true, immediate: true })
    public watchToolbarModel(val: any, oldVal: any): void {
        if (val && Object.keys(val).length > 0) {
            this.items = [];
            const keys: string[] = Object.keys(val);
            keys.forEach((key: string) => {
                const value: any = val[key];
                if (Object.is(value.type, 'DEUIACTION')) {
                    this.items.push(val[key]);
                }
            });
        }
    }

    /**
     * 监控searchValue
     *
     * @param {*} val
     * @param {*} oldVal
     * @memberof AppHeaderMenus
     */
    @Watch('searchValue', { immediate: true })
    public watchSearchValue(val: any, oldVal: any): void {
        if(val && val !== this.inputSearchValue){
          this.inputSearchValue = val;
        }
    }

    /**
     * 是否为模式1呈现
     *
     * @protected
     * @returns {boolean}
     * @memberof AppHeaderMenus
     */
    protected isModeOne(): boolean {
        return (Object.is(this.mode, 'view') && !Object.is(this.openMode, 'MODAL'));
    }

    /**
     * 组件挂载完毕
     *
     * @memberof AppHeaderMenus
     */
    public mounted(): void {
        this.isActiveSearch = this.isModeOne();
    }

    /**
     * 工具栏
     *
     * @protected
     * @param {*} item
     * @returns {*}
     * @memberof AppHeaderMenus
     */
    @Emit('menu-click')
    protected menuClick(item: any): any {
        if (!item.tag) {
            item.tag = item.name
        }
        return item;
    }

    /**
     * 绘制项图标
     *
     * @protected
     * @param {*} item
     * @returns {*}
     * @memberof AppHeaderMenus
     */
    protected renderIcon(item: any): any {
        if (item) {
            if (item.icon && !Object.is(item.icon, '')) {
                return <div class="app-header-menu-item-img">
                    <img src={item.icon} />
                </div>;
            } else if (item.iconcls && !Object.is(item.iconcls, '')) {
                return <div class="app-header-menu-item-icon">
                    <i class={item.iconcls} aria-hidden="true" />
                </div>;
            }
        }
    }

    /**
     * 绘制菜单项
     *
     * @protected
     * @param {*} item
     * @returns {*}
     * @memberof AppHeaderMenus
     */
    protected renderMenuItem(item: any): any {
        item.class = item.class ? item.class : "";
        if (Object.is(this.mode, 'default')) {
            if (item.caption && !Object.is(item.caption, '')) {
                return <div class={"app-header-menu-item text"+item.class} disabled={item.disabled} on-click={() => this.menuClick(item)}>
                    {this.renderIcon(item)}
                    <div class="app-header-menu-item-text">{item.caption}</div>
                </div>;
            } else {
                return <div class={"app-header-menu-item icon"+item.class} disabled={item.disabled} on-click={() => this.menuClick(item)}>
                    <el-tooltip class="item" effect="dark" content={item.tooltip} placement="bottom" open-delay={300}>
                        {this.renderIcon(item)}
                    </el-tooltip>
                </div>;
            }
        } else if (Object.is(this.mode, 'view') || Object.is(this.mode, 'view2')) {
            const button: any = <i-button class={"app-header-view-menu-item"+item.class} type={this.isModeOne() ? 'text' : 'default'} disabled={item.disabled} on-click={() => this.menuClick(item)}>
               {item.isShowIcon?this.renderIcon(item):null}
               {item.isShowCaption?item.caption:null}
            </i-button>;
            if (item.tooltip && !Object.is(item.tooltip, '')) {
                return <el-tooltip class="app-header-view-menu-item-tooltip" effect="dark" content={item.tooltip} placement="bottom" open-delay={300}>{button}</el-tooltip>;
            }
            return button;
        }
    }

    /**
     * 激活搜索
     *
     * @protected
     * @memberof AppHeaderMenus
     */
    protected activeSearch(): void {
        this.isActiveSearch = true;
        this.$nextTick(() => {
            const search: any = this.$refs.search;
            if (search) {
                search.focus();
            }
        });
    }

    /**
     * 搜索框失去焦点
     *
     * @protected
     * @memberof AppHeaderMenus
     */
    protected searchBlur(): void {
        if (this.isModeOne()) {
            return;
        }
        this.isActiveSearch = false;
    }

    /**
     * 搜索事件
     *
     * @protected
     * @param {string} val
     * @memberof AppHeaderMenus
     */
    @Emit('search')
    protected search(val: string): void { }

    /**
     * 搜索值发生变化
     *
     * @protected
     * @param {*} val
     * @memberof AppHeaderMenus
     */
    protected searchValChange($event: any): void {
        this.$emit('change', this.inputSearchValue);
    }

    /**
     * 绘制搜索按钮
     *
     * @protected
     * @returns {*}
     * @memberof AppHeaderMenus
     */
    protected renderSearchMenu(): any {
        if (!this.isEnableQuickSearch) {
            return;
        }
        let searchMenu: any;
        if (Object.is(this.mode, 'default')) {
            searchMenu = <i class="ivu-icon ivu-icon-ios-search" on-click={() => this.activeSearch()} />
        } else if (Object.is(this.mode, 'view') || Object.is(this.mode, 'view2')) {
            searchMenu = <i-button type={this.isModeOne() ? 'text' : 'default'} shape="circle" icon="ios-search" on-click={() => this.activeSearch()} />
        }
        return <div class={"app-view-quick-search " + this.mode}>
            <i-input v-show={this.isActiveSearch} ref="search" v-model={this.inputSearchValue} autofocus autocomplete="on" search placeholder={this.searchPlaceholder} on-on-change={(e: any) => this.searchValChange(e)} on-on-blur={() => this.searchBlur()} on-on-search={(val: string) => this.search(val)} />
            {!this.isActiveSearch ? searchMenu : null}
        </div>
    }

    /**
     * 绘制头部菜单内容
     *
     * @returns {*}
     * @memberof AppHeaderMenus
     */
    public render(): any {
        return <div class="app-header-menus">
            {this.renderSearchMenu()}
            {this.items.map((item: any) => {
                if (!item.visabled) {
                    return;
                }
                return this.renderMenuItem(item);
            })}
        </div>;
    }

}