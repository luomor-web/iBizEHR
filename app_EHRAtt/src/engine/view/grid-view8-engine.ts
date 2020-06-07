import GridViewEngine from './grid-view-engine';

/**
 * 视图引擎基础
 *
 * @export
 * @class GridView8Engine
 * @extends {GridViewEngine}
 */
export default class GridView8Engine extends GridViewEngine {

    /**
     * 表格部件
     *
     * @type {*}
     * @memberof GridView8Engine
     */
    protected grid: any;

    /**
     * 表格部件
     *
     * @protected
     * @type {*}
     * @memberof Grid8ViewEngine
     */
    protected totalgrid: any;

    /**
     * 选中数据集
     *
     * @protected
     * @type {any[]}
     * @memberof Grid8ViewEngine
     */
    public selections: any[] = [];

    /**
     * 选中数据集
     *
     * @protected
     * @type {any[]}
     * @memberof Grid8ViewEngine
     */
    public selections2: any[] = [];

    /**
     * Creates an instance of GridView8Engine.
     * @memberof GridView8Engine
     */
    constructor() {
        super();
    }

    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof GridView8Engine
     */
    public init(options: any = {}): void {
        this.grid = options.grid;
        this.totalgrid = options.totalgrid;
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @memberof MDViewEngine
     */
    public load(): void {
        super.load();
        this.load2();
    }

    /**
     * 加载
     *
     * @memberof Grid8ViewEngine
     */
    public load2(): void {
        if (this.getMDCtrl2()) {
            const tag = this.getMDCtrl2().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        }
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof GridView8Engine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(ctrlName, 'totalgrid')) {
            this.MD2Event(eventName, args);
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }


    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof GridView8Engine
     */
    public getMDCtrl(): any {
        return this.grid;
    }

    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof GridView8Engine
     */
    public getMDCtrl2(): any {
        return this.totalgrid;
    }

    /**
     * 删除
     *
     * @param {*} [arg={}]
     * @returns {void}
     * @memberof GridView8Engine
     */
    public removeData(items: any[] = []): void {
        let arg: any = {};
        // 获取要删除的数据集合
        if (!items || items == null || items.length === 0) {
            return;
        }

        let keys = '';
        items.forEach((item) => {
            let key = item.srfkey;
            if (!Object.is(keys, '')) {
                keys += ';';
            }
            keys += key;
        });
        arg.srfkeys = keys;

        const grid: any = this.getMDCtrl();
        if (grid) {
            grid.remove(arg);
        }
    }

    /**
     * 添加数据
     *
     * @param {any[]} [items=[]]
     * @memberof Grid8ViewEngine
     */
    public addBatchData(items: any[] = []): void {
        let arg: any = {};
        // 获取要添加的数据集合
        if (!items || items == null || items.length === 0) {
            return;
        }

        let keys = '';
        items.forEach((item) => {
            let key = item.srfkey;
            if (!Object.is(keys, '')) {
                keys += ';';
            }
            keys += key;
        });
        arg.srfkeys = keys;

        const grid: any = this.getMDCtrl();
        if (grid) {
            grid.addBatchData(arg);
        }
    }

    /**
     * 
     *
     * @param {string} eventName
     * @param {*} [args={}]
     * @memberof GridView8Engine
     */
    public MDEvent(eventName: string, args: any = {}): void {
        if (Object.is(eventName, 'rowclick')) {
            // this.***()
        }
        if (Object.is(eventName, 'rowdblclick')) {
            // this.doEdit(args);
        }
        if (Object.is(eventName, 'selectionchange')) {
            // this.***()
            this.selectionChange(args);
        }
        if (Object.is(eventName, 'remove')) {
            this.load2();
        }
    }

    /**
     * 
     *
     * @param {string} eventName
     * @param {*} [args={}]
     * @memberof GridView8Engine
     */
    public MD2Event(eventName: string, args: any = {}): void {
        if (Object.is(eventName, 'rowclick')) {
            // this.***()
        }
        if (Object.is(eventName, 'rowdblclick')) {
            // this.doEdit(args);
        }
        if (Object.is(eventName, 'selectionchange')) {
            // this.***()
            this.selectionChange2(args);
        }
    }

    /**
     * 选中变化
     *
     * @param {any[]} args
     * @memberof GridView8Engine
     */
    public selectionChange(args: any[]): void {
        this.selections = [...args];
    }

    /**
     * 选中变化
     *
     * @param {any[]} args
     * @memberof GridView8Engine
     */
    public selectionChange2(args: any[]): void {
        this.selections2 = [...args];
    }

    /**
     * 移动数据
     *
     * @memberof Grid8ViewEngine
     */
    public moveData() {
        this.addBatchData(this.selections2);
    }

    /**
     * 移动数据
     *
     * @memberof Grid8ViewEngine
     */
    public moveData2() {
        this.removeData(this.selections);
    }

    /**
     * 移动全部数据
     *
     * @memberof Grid8ViewEngine
     */
    public moveAllData() {
        if (this.getMDCtrl2()) {
            var items: any[] = this.getMDCtrl2().getDatas();
            this.addBatchData(items);
        }
    }

    /**
     * 移动全部数据
     *
     * @memberof Grid8ViewEngine
     */
    public moveAllData2() {
        if (this.getMDCtrl()) {
            var items: any[] = this.getMDCtrl().getDatas();
            this.removeData(items);
        }
    }
}
