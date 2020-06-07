import PopperJs from 'popper.js';
import Vue, { VNode, CreateElement } from "vue";
import { Subject } from 'rxjs';

/**
 * 悬浮窗实例
 *
 * @export
 * @interface AppPopover
 */
export declare interface AppPopover {
    /** 
     * 打开悬浮窗
     *
     * @param {MouseEvent} event 事件
     * @param {*} view 视图
     * @param {*} [viewParam={}] 视图参数
     * @param {*} data 行为参数
     * @param {string} [title] 标题
     * @param {PopperJs.Placement} [position='left'] 悬浮窗位置
     * @param {boolean} [isAutoClose=true] 是否自动关闭
     * @param {number} [width] 宽度
     * @param {number} [height] 高度
     * @returns {Subject<any>}
     * @memberof AppPopover
     */
    openPop(event: MouseEvent, view: any, viewParam: any, data: any, title?: string, position?: PopperJs.Placement, isAutoClose?: boolean, width?: number, height?: number): Subject<any>;
    /**
     * 打开悬浮窗
     *
     * @param {MouseEvent} event
     * @param {(h: CreateElement) => any} content
     * @param {string} [title]
     * @param {PopperJs.Placement} [position]
     * @param {boolean} [isAutoClose]
     * @param {number} [width]
     * @param {number} [height]
     * @memberof AppPopover
     */
    openPopover(event: MouseEvent, content: (h: CreateElement) => any, title?: string, position?: PopperJs.Placement, isAutoClose?: boolean, width?: number, height?: number): void;
    /**
     * 销毁popper(带回填数据)
     *
     * @memberof AppPopover
     */
    destroy(): void;
}

declare module "vue/types/vue" {
    interface Vue {
        /**
         * 悬浮窗实例
         *
         * @type {AppPopover}
         * @memberof Vue
         */
        $apppopover: AppPopover;
    }
}
