import Vue, { VNode, CreateElement } from "vue";

/**
 * 导航标签组件
 *
 * @export
 * @interface TabPageExp
 */
export declare interface TabPageExp {
    /**
     * 左移
     *
     * @memberof TabPageExp
     */
    leftMove(): void;
    /**
     * 右移
     *
     * @memberof TabPageExp
     */
    rightMove(): void;
    /**
     * 是否被选中
     *
     * @param {(string | number)} index
     * @returns {boolean}
     * @memberof TabPageExp
     */
    isActive(index: string | number): boolean;
    /**
     * 关闭页面
     *
     * @param {*} name
     * @memberof TabPageExp
     */
    onClose(name: any): void;
    /**
     * 是否显示关闭
     *
     * @returns {boolean}
     * @memberof TabPageExp
     */
    isClose(): boolean;
    /**
     * 切换分页
     *
     * @param {*} index
     * @memberof TabPageExp
     */
    changePage(index: any): void;
    /**
     * 设置当前页标题
     *
     * @param {string} routename 路由名称
     * @param {*} caption 视图标题
     * @param {string} [info] 视图信息
     * @memberof TabPageExp
     */
    setCurPageCaption(routename: string, caption: any, info?: string): void;
    /**
     * 移动至指定页面标签
     *
     * @param {*} to
     * @memberof TabPageExp
     */
    moveToView(to: any): void;
}

declare module "vue/types/vue" {
    interface Vue {
        /**
         * 代码表绘制对象
         *
         * @type {CodeList}
         * @memberof Vue
         */
        $tabPageExp: TabPageExp;
    }
}
