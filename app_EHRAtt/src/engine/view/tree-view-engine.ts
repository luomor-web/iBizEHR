import ViewEngine from './view-engine';

/**
 * 实体树视图界面引擎
 *
 * @export
 * @class TreeViewEngine
 * @extends {ViewEngine}
 */
export default class TreeViewEngine extends ViewEngine {

    /**
     * 树部件对象
     *
     * @type {*}
     * @memberof TreeViewEngine
     */
    public tree: any;

    /**
     * Creates an instance of TreeViewEngine.
     * 
     * @memberof TreeViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof PickupViewEngine
     */
    public init(options: any): void {
        this.tree = options.tree;
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @memberof TreeViewEngine
     */
    public load(): void {
        super.load();
        if (this.getTreeView() && this.isLoadDefault) {
            const tag = this.getTreeView().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        } else {
            this.isLoadDefault = true;
        }
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof TreeViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);

        if (Object.is(eventName, 'load')) {
            this.onLoad(args);
        }
        if (Object.is(eventName, 'selectionchange')) {
            this.onSelectionChange(args);
        }
    }

    /**
     * 部件加载完
     *
     * @param {*} args
     * @memberof TreeViewEngine
     */
    public onLoad(args: any): void { }

    /**
     * 选中处理
     *
     * @param {any[]} args
     * @memberof TreeViewEngine
     */
    public onSelectionChange(args: any[]): void { }


    /**
     * 
     *获取树视图部件
     * @returns {*}
     * @memberof TreeViewEngine
     */
    public getTreeView(): any {
        return this.tree;
    }


}