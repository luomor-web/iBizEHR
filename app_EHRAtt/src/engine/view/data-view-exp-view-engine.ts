import ViewEngine from './view-engine';

/**
 * 卡片视图导航视图界面引擎
 *
 * @export
 * @class DataViewExpViewEngine
 * @extends {ViewEngine}
 */
export default class DataViewExpViewEngine extends ViewEngine {

    /**
     * 卡片导航栏部件
     *
     * @type {*}
     * @memberof DataViewExpViewEngine
     */
    public dataviewExpBar: any = null;

    /**
     * Creates an instance of DataViewExpViewEngine.
     * 
     * @memberof DataViewExpViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof DataViewExpViewEngine
     */
    public init(options: any): void {
        this.dataviewExpBar = options.dataviewexpbar;
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof DataViewExpViewEngine
     */
    public load(): void {
        super.load();
        if (this.getDataviewExpBar() && this.isLoadDefault) {
            const tag = this.getDataviewExpBar().name;
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
     * @memberof DataViewExpViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'dataviewexpbar')) {
            this.dataviewExpBarEvent(eventName, args);

        }
    }

    /**
     * 卡片导航事件
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof DataViewExpViewEngine
     */
    public dataviewExpBarEvent(eventName: string, args: any): void {
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
     * @memberof DataViewExpViewEngine
     */
    public getDataviewExpBar(): any {
        return this.dataviewExpBar;
    }


}