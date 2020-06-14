import DataViewEngine from './data-view-engine';


/**
 * 视图引擎基础
 *
 * @export
 * @class DataViewEngine
 * @extends {MDViewEngine}
 */
export default class KanBanViewEngine extends DataViewEngine {

    /**
     * 表格部件
     *
     * @type {*}
     * @memberof DataViewEngine
     */
    protected kanban: any;


    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof DataViewEngine
     */
    public init(options: any = {}): void {
        this.kanban = options.kanban;
        super.init(options);
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof DataViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(ctrlName, 'kanban')) {
            this.MDCtrlEvent(eventName, args);
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }


    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof DataViewEngine
     */
    public getMDCtrl(): any {
        return this.kanban;
    }
}