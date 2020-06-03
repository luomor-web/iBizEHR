import ViewEngine from './view-engine';

/**
 * 表格导航视图界面引擎
 *
 * @export
 * @class GridExpViewEngine
 * @extends {ViewEngine}
 */
export default class GridExpViewEngine extends ViewEngine {

    /**
     * 表格导航栏部件
     *
     * @type {*}
     * @memberof GridExpViewEngine
     */
    public gridExpBar: any = null;

    /**
     * Creates an instance of GridExpViewEngine.
     * 
     * @memberof GridExpViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof GridExpViewEngine
     */
    public init(options: any): void {
        this.gridExpBar = options.gridexpbar;
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof GridExpViewEngine
     */
    public load(): void {
        super.load();
        if (this.getGridExpBar() && this.isLoadDefault) {
            const tag = this.getGridExpBar().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        } else {
            this.isLoadDefault = true;
        }
    }

    /**
     * 部件事件机制
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof GridExpViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'gridexpbar')) {
            this.gridExpBarEvent(eventName, args);

        }
    }

    /**
     * 表格导航事件
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof GridExpViewEngine
     */
    public gridExpBarEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'load')) {
            this.view.$emit('viewload', args);
        }
        if (Object.is(eventName, 'selectionchange')) {
            this.view.$emit('viewdataschange', args);
        }
        if (Object.is(eventName, 'activated')) {
            this.view.$emit('viewdatasactivated', args);
        }
    }

    /**
     * 获取部件对象
     *
     * @returns {*}
     * @memberof GridExpViewEngine
     */
    public getGridExpBar(): any {
        return this.gridExpBar;
    }


}