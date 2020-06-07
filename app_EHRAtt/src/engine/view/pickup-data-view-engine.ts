import MDViewEngine from './md-view-engine';

/**
 * 视图引擎基础
 *
 * @export
 * @class GridViewEngine
 * @extends {MDViewEngine}
 */
export default class PickupDataViewEngine extends MDViewEngine {

    /**
     * 数据视图部件
     *
     * @type {*}
     * @memberof FormPickupDataViewEngine
     */
    protected dataview: any;

    /**
     * Creates an instance of GridViewEngine.
     * @memberof GridViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof GridViewEngine
     */
    public init(options: any = {}): void {
        this.dataview = options.dataview;
        super.init(options);
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof GridViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(ctrlName, 'dataview')) {
            this.MDCtrlEvent(eventName, args);
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }


    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof GridViewEngine
     */
    public getMDCtrl(): any {
        return this.dataview;
    }

}