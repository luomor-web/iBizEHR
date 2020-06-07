import ViewEngine from './view-engine';

/**
 * 列表导航视图界面引擎
 *
 * @export
 * @class ListExpViewEngine
 * @extends {ViewEngine}
 */
export default class ListExpViewEngine extends ViewEngine {

    /**
     * 列表导航栏部件
     *
     * @type {*}
     * @memberof ListExpViewEngine
     */
    public listExpBar: any = null;

    /**
     * Creates an instance of ListExpViewEngine.
     * 
     * @memberof ListExpViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof ListExpViewEngine
     */
    public init(options: any): void {
        this.listExpBar = options.listexpbar;
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof ListExpViewEngine
     */
    public load(): void {
        super.load();
        if (this.getListExpBar() && this.isLoadDefault) {
            const tag = this.getListExpBar().name;
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
     * @memberof ListExpViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'listexpbar')) {
            this.listExpBarEvent(eventName, args);

        }
    }

    /**
     * 列表导航事件
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof ListExpViewEngine
     */
    public listExpBarEvent(eventName: string, args: any): void {
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
     * @memberof ListExpViewEngine
     */
    public getListExpBar(): any {
        return this.listExpBar;
    }


}