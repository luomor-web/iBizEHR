import Vue, { VNode, CreateElement } from "vue";

/**
 * 导航标签组件
 *
 * @export
 * @interface TabPageExp
 */
export declare interface TabPageExp {
    /**
     * 
     *
     * @param {*} path
     * @param {*} [keys]
     * @param {*} [options]
     * @returns {*}
     * @memberof TabPageExp
     */
    pathToRegexp(path: any, keys?: any, options?: any): any;
}

declare module "vue/types/vue" {
    interface Vue {
        /**
         * 代码表绘制对象
         *
         * @type {CodeList}
         * @memberof Vue
         */
        $pathToRegExp: TabPageExp;
    }
}
