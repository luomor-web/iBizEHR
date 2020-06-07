import { Vue, Component, Prop, Emit, Watch } from 'vue-property-decorator';
import './app-menus.less';

/**
 * 首页应用菜单
 *
 * @export
 * @class AppMenu
 * @extends {Vue}
 */
@Component({})
export class AppMenus extends Vue {

    /**
     * 当前激活菜单的Index
     *
     * @protected
     * @type {string}
     * @memberof AppMenus
     */
    protected defaultActive: string = '';

    /**
     * 默认展开的菜单项
     *
     * @protected
     * @type {string[]}
     * @memberof AppMenus
     */
    protected defaultOpeneds: string[] = [];

    /**
     * 菜单数据
     *
     * @type {any[]}
     * @memberof AppMenus
     */
    @Prop({
        default: () => []
    })
    public menus!: any[];

    /**
     * 监控菜单数据变化
     *
     * @param {any[]} val
     * @param {any[]} oldVal
     * @memberof AppMenus
     */
    @Watch('menus')
    public watchMenus(val: any[], oldVal: any[]): void {
        if (val && val.length > 0) {
            this.defaultCalculation();
        }
    }

    /**
     * 菜单对齐方向
     *
     * @type {CrmIndexService}
     * @memberof CrmIndex
     */
    @Prop({ default: '' })
    protected menuAlign!: string;

    /**
     * 菜单项点击
     *
     * @protected
     * @param {*} item
     * @returns {*}
     * @memberof AppMenus
     */
    @Emit('menu-click')
    protected menuClick(item: any): any { }

    /**
     * 菜单项激活
     *
     * @protected
     * @param {*} item
     * @memberof AppMenus
     */
    protected menuActive(item: any): void {
        this.defaultActive = item.id;
        this.menuClick(item);
    }

    /**
     * 计算菜单默认选中值
     *
     * @protected
     * @memberof AppMenus
     */
    protected defaultCalculation(): void {
        if (this.$route && this.$route.matched.length <= 1) {
            this.calcDefaultActive(this.menus);
            this.defaultOpeneds = this.defaultOpeneds.reverse();
            this.calcDefaultOpend(this.menus);
        }
    }

    /**
     * 递归计算默认选中
     *
     * @protected
     * @param {any[]} menus
     * @memberof AppMenus
     */
    protected calcDefaultActive(menus: any[]): boolean {
        return menus.find((item: any) => {
            if (item.items) {
                if (this.calcDefaultActive(item.items)) {
                    this.defaultOpeneds.push(item.id);
                    return true;
                }
            }
            if (item.opendefault) {
                this.defaultActive = item.id;
                this.menuActive(item);
                return true;
            }
        });
    }
    /**
     * 递归计算默认展开
     *
     * @protected
     * @param {any[]} menus
     * @memberof AppMenus
     */
    protected calcDefaultOpend(menus: any[]){
       menus.forEach((item: any) => {
            if (item.items) {
                this.calcDefaultOpend(item.items);
            }
            if(item.expanded){
                this.defaultOpeneds.push(item.id)
            }
        });
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
                return <div class="app-menu-item-img">
                    <img src={item.icon} />
                </div>;
            } else if (item.iconcls && !Object.is(item.iconcls, '')) {
                return <div class="app-menu-item-icon">
                    <i class={item.iconcls} aria-hidden="true" />
                </div>;
            }
        }
    }

    /**
     * 绘制左侧模式菜单项
     *
     * @protected
     * @param {*} item
     * @returns {*}
     * @memberof AppMenus
     */
    protected renderMenuItem(item: any): any {
        return item.type =='SEPERATOR' ? <divider key={item.id} /> : <el-menu-item index={item.id} on-click={() => this.menuActive(item)}>
            {this.renderIcon(item)}
            <span slot="title">{item.text}</span>
        </el-menu-item>
    }

    /**
     * 绘制左侧模式子菜单
     *
     * @protected
     * @param {*} item
     * @returns {*}
     * @memberof AppMenus
     */
    protected renderSubMenu(item: any): any {
        return <el-submenu index={item.id}>
            <template slot="title">
                {this.renderIcon(item)}
                <span>{item.text}</span>
            </template>
            {item.items.map((item: any) => {
                return this.renderMenuItem(item);
            })}
        </el-submenu>;
    }

    /**
     * 绘制Left模式菜单
     *
     * @protected
     * @returns {*}
     * @memberof AppMenus
     */
    protected renderLeftModeMenu(): any {
        return <div class="app-menus-vertical-wrapper">
            <el-menu class="app-menus-vertical" default-active={this.defaultActive} default-openeds={this.defaultOpeneds}>
                {this.menus.map((item: any) => {
                    if (item.hidden) {
                        return;
                    }
                    if (item.items && item.items.length > 0) {
                        return this.renderSubMenu(item);
                    }
                    return this.renderMenuItem(item);
                })}
            </el-menu>
        </div>;
    }

    /**
     * 绘制菜单内容
     *
     * @returns {*}
     * @memberof AppMenu
     */
    public render(): any {
        if (Object.is(this.menuAlign, 'LEFT')) {
            return this.renderLeftModeMenu();
        }
        return <div class="app-menus">
            <div class="app-menus-content">
                <ul class="app-menu-list">
                    {this.menus.map((item: any) => {
                        return <li class="app-menu-item" on-click={() => this.menuClick(item)}>
                            {this.renderIcon(item)}
                            <div class="app-menu-item-text">{item.text}</div>
                        </li>;
                    })}
                </ul>
            </div>
        </div>;
    }

}