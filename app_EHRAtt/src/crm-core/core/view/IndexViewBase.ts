import { ViewBase } from './ViewBase';
import { Emit } from 'vue-property-decorator';

/**
 * 首页视图基类
 *
 * @export
 * @class IndexViewBase
 * @extends {ViewBase}
 */
export class IndexViewBase extends ViewBase {

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof ${srfclassname('${view.name}')}Base
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof IndexViewBase
     */
    protected srfparentdata: any = {};

    /**
     * 顶部菜单项
     *
     * @protected
     * @type {any[]}
     * @memberof IndexViewBase
     */
    protected topMenus: any[] = [];

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof IndexViewBase
     */
    public mounted() {
        super.mounted();
        this.viewState.next({ tag: "appmenu", action: "load", data: {} });
        this.$viewTool.setIndexParameters([
            { pathName: "index", parameterName: "index" }
        ]);
    }

    /**
     * 应用菜单项变更
     *
     * @protected
     * @param {any[]} menus
     * @memberof IndexViewBase
     */
    protected appMenusChange(menus: any[]): void {
        if (menus) {
            const item: any = menus.find((item: any) => Object.is(item.name, 'HomeTopMenus'));
            if (item && item.items) {
                this.topMenus = item.items;
                this.topMenus.forEach((item: any) => {
                    item.caption = item.text;
                    item.disabled = false;
                    item.visabled = true;
                });
            }
        }
    }

    /**
     * 顶部菜单项点击
     *
     * @protected
     * @param {*} menu
     * @memberof IndexViewBase
     */
    protected topMenuClick(menu: any): void {
        if (menu && this.$refs.appmenu) {
            (this.$refs.appmenu as any).click(menu);
        }
    }

}