import Vue, { VNode, CreateElement } from "vue";
import { Subject } from "rxjs";

/**
 * 抽屉实例
 *
 * @export
 * @interface AppDrawer
 */
export declare interface AppDrawer {
    /**
     * 打开抽屉
     *
     * @param {({ viewname: string, title: string, width?: number, height?: number, placement?: 'DRAWER_LEFT' | 'DRAWER_RIGHT' })} view 视图
     * @param {*} [viewParam={}] 视图参数
     * @param {*} [data={}] 行为参数
     * @returns {Subject<any>}
     * @memberof AppDrawer
     */
    openDrawer(view: { viewname: string, title: string, width?: number, height?: number, placement?: 'DRAWER_LEFT' | 'DRAWER_RIGHT' }, viewParam: any, data: any): Subject<any>;
}

declare module "vue/types/vue" {
    interface Vue {
        /**
         * 抽屉实例
         *
         * @type {AppDrawer}
         * @memberof Vue
         */
        $appdrawer: AppDrawer;
    }
}
