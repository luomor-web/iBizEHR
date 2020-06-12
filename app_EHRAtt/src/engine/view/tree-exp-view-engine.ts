import ViewEngine from './view-engine';

/**
 * 实体树导航视图界面引擎
 *
 * @export
 * @class TreeExpView
 * @extends {ViewEngine}
 */
export default class TreeExpView extends ViewEngine {

    /**
     * 选择视图面板
     *
     * @type {*}
     * @memberof TreeExpView
     */
    public treeExpBar: any = null;

    /**
     * Creates an instance of TreeExpView.
     * 
     * @memberof TreeExpView
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof TreeExpView
     */
    public init(options: any): void {
        this.treeExpBar = options.treeexpbar;
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof TreeExpView
     */
    public load(): void {
        super.load();

        if (this.getTreeExpBar() && this.isLoadDefault) {
            const tag = this.getTreeExpBar().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.context });
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
     * @memberof TreeExpView
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'treeexpbar')) {
            this.treeExpBarEvent(eventName, args);

        }
    }

    /**
     * 树导航事件
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof TreeExpView
     */
    public treeExpBarEvent(eventName: string, args: any): void {
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
     * 获取部件对象那
     *
     * @returns {*}
     * @memberof TreeExpView
     */
    public getTreeExpBar(): any {
        return this.treeExpBar;
    }


}