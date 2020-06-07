import MDViewEngine from './md-view-engine';


/**
 * 视图引擎基础
 *
 * @export
 * @class GridViewEngine
 * @extends {MDViewEngine}
 */
export default class GridViewEngine extends MDViewEngine {

    /**
     * 表格部件
     *
     * @type {*}
     * @memberof GridViewEngine
     */
    protected grid: any;

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
        this.grid = options.grid;
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof GridViewEngine
     */
    public load(opts: any = {},isnotify:boolean=false): void {
        if(!this.view.isformDruipart){
            super.load(opts);
        }else{
            if(isnotify){
                super.load(opts);
            }
        }
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
        if (Object.is(ctrlName, 'grid')) {
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
        return this.grid;
    }

    /**
     * 事件处理
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof GridViewEngine
     */
    public MDCtrlEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'rowdblclick') && this.gridRowAllowActive(2)) {
            this.doEdit(args);
            return;
        }
        if (Object.is(eventName, 'selectionchange')) {
            this.selectionChange(args);
            if (this.gridRowAllowActive(1)) {
                this.doEdit(args);
            }
            return;
        }
        super.MDCtrlEvent(eventName, args);
    }

    /**
     * 表格是否被允许激活
     *
     * @param {number} mode
     * @returns {boolean}
     * @memberof GridViewEngine
     */
    public gridRowAllowActive(mode: number): boolean {
        return this.view.gridRowActiveMode === mode ? true : false;
    }
}