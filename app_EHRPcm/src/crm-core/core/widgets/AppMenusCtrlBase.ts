import { CtrlBase } from './CtrlBase';
import { Emit } from 'vue-property-decorator';

/**
 * 应用菜单基类
 *
 * @export
 * @class AppMenusCtrlBase
 * @extends {CtrlBase}
 */
export class AppMenusCtrlBase extends CtrlBase {

    /**
     * 菜单数据
     *
     * @protected
     * @type {any[]}
     * @memberof AppMenusCtrlBase
     */
    protected menus: any[] = [];

    /**
     * 计数器数据
     *
     * @protected
     * @type {*}
     * @memberof AppMenusCtrlBase
     */
    protected counterdata: any = {};

    /**
     * 菜单模型
     *
     * @protected
     * @type {IndexMode}
     * @memberof Index
     */
    protected menuModel?: any;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof AppMenusCtrlBase
     */
    public getControlType(): string {
        return "APPMENU";
    }

    /**
     * vue  生命周期
     *
     * @memberof AppMenusCtrlBase
     */
    public created() {
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(
                ({ tag, action, data }: any) => {
                    if (!Object.is(tag, this.name)) {
                        return;
                    }
                    this.load(data);
                }
            );
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof AppMenusCtrlBase
     */
    public destroyed() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

    /**
     * 获取菜单项数据
     *
     * @protected
     * @param {any[]} items
     * @param {string} name
     * @returns
     * @memberof AppMenusCtrlBase
     */
    protected compute(items: any[], name: string) {
        const item: any = {};
        items.some((_item: any) => {
            if (name && Object.is(_item.name, name)) {
                Object.assign(item, _item);
                return true;
            }
            if (_item.items && Array.isArray(_item.items)) {
                const subItem = this.compute(_item.items, name);
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
     * 菜单项选中处理
     *
     * @param {*} index
     * @param {any[]} indexs
     * @returns
     * @memberof AppMenusCtrlBase
     */
    public select(index: any, indexs: any[]) {
        let item = this.compute(this.menus, index);
        if (Object.keys(item).length === 0) {
            return;
        }
        this.click(item);
    }

    /**
     * 菜单点击
     *
     * @protected
     * @param {*} item 菜单数据
     * @memberof AppMenusCtrlBase
     */
    protected click(item: any) { }

    /**
     * 数据加载
     *
     * @param {*} data
     * @memberof Index
     */
    public load(data: any) {
        this.menus = this.menuModel.getAppMenuItems();
        this.menusChange();
    }

    /**
     * 菜单变更
     *
     * @returns {*}
     * @memberof AppMenusCtrlBase
     */
    @Emit('menus-change')
    public menusChange(): any {
        return this.menus;
    }

}