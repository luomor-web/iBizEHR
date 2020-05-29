import Vue, { VNode, CreateElement } from "vue";
import { Route } from "vue-router";

/**
 * 工具类
 *
 * @export
 * @interface ViewTool
 */
export declare interface ViewTool {
    /**
     * 处理路由路径
     *
     * @static
     * @param {Route} route 路由
     * @param {*} [viewParam={}]
     * @param {any[]} deResParameters 关系实体参数对象
     * @param {any[]} parameters 当前应用视图参数对象
     * @param {any[]} args 多项数据
     * @param {*} data 行为参数
     * @returns {string}
     * @memberof ViewTool
     */
    buildUpRoutePath(route: Route, viewParam: any, deResParameters: any[], parameters: any[], args: any[], data: any): string;
    /**
     * 获取首页根路径
     *
     * @param {Route} route
     * @returns {string}
     * @memberof ViewTool
     */
    getIndexRoutePath(route: Route): string;
    /**
     * 获取关系实体路径
     *
     * @static
     * @param {*} [viewParam={}] 视图参数
     * @param {any[]} deResParameters 关系实体参数对象
     * @param {any[]} args 多项数据
     * @returns {string}
     * @memberof ViewTool
     */
    getDeResRoutePath(viewParam: any, deResParameters: any[], args: any[]): string;
    /**
     * 当前激活路由路径
     *
     * @static
     * @param {any[]} parameters 当前应用视图参数对象
     * @param {any[]} args 多项数据
     * @param {*} data 行为参数
     * @returns {string}
     * @memberof ViewTool
     */
    getActiveRoutePath(parameters: any[], args: any[], data: any): string;
    /**
     * 格式化路由参数
     *
     * @static
     * @param {*} params
     * @returns {*}
     * @memberof ViewTool
     */
    formatRouteParams(params: any,route:any,context:any,viewparams:any): any;
    /**
     * 设置首页路由结构参数
     *
     * @static
     * @param {any[]} parameters
     * @memberof ViewTool
     */
    setIndexParameters(parameters: any[]): void;
    /**
     * 获取首页路由结构参数
     *
     * @static
     * @returns {any[]}
     * @memberof ViewTool
     */
    getIndexParameters(): any[];
    /**
     * 设置首页视图参数
     *
     * @static
     * @param {*} [viewParam={}]
     * @memberof ViewTool
     */
    setIndexViewParam(viewParam: Object): void;
    /**
     * 获取首页视图参数
     *
     * @static
     * @returns {*}
     * @memberof ViewTool
     */
    getIndexViewParam(): any;
}

declare module "vue/types/vue" {
    interface Vue {
        /**
         * 工具类
         *
         * @type {Verify}
         * @memberof Vue
         */
        $viewTool: ViewTool;
    }
}