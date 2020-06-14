import Vue, { VNode, CreateElement } from "vue";

/**
 * 导航标签组件
 *
 * @export
 * @interface UIActionTool
 */
export declare interface UIActionTool {

    /**
     * 处理应用上下文参数
     * 
     * @param actionTarget 数据目标
     * @param args  传入数据对象
     * @param parentContext 父上下文
     * @param parentParams  父参数
     * @param param 传入应用上下数据参数
     */
    handleContextParam(actionTarget: any, args: any,parentContext:any,parentParams:any, context: any):any;

    /**
     * 处理界面行为参数
     * 
     * @param actionTarget 数据目标
     * @param args  传入数据对象
     * @param parentContext 父上下文
     * @param parentParams  父参数
     * @param param 传入界面行为附加参数
     */
    handleActionParam(actionTarget: any, args: any,parentContext:any,parentParams:any, params: any):any;
}

declare module "vue/types/vue" {
    interface Vue {
        /**
         * 代码表绘制对象
         *
         * @type {CodeList}
         * @memberof Vue
         */
        $uiActionTool: UIActionTool;
    }
}
