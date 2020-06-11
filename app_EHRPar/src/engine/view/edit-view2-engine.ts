import EditViewEngine from './edit-view-engine';

/**
 * 实体编辑视图（左右关系）界面引擎
 *
 * @export
 * @class EditView2Engine
 * @extends {EditViewEngine}
 */
export default class EditView2Engine extends EditViewEngine {

    /**
     * 数据关系栏
     *
     * @protected
     * @type {*}
     * @memberof EditView2Engine
     */
    protected drBar: any;

    /**
     * Creates an instance of EditView2Engine.
     * 
     * @memberof EditView2Engine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} [options={}]
     * @memberof EditView2Engine
     */
    public init(options: any = {}): void {
        this.drBar = options.drbar;
        super.init(options);
    }

    /**
     * 部件事件机制
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof EditView2Engine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'drbar')) {
            this.drbarEvent(eventName, args);
        }
    }

    /**
     * 数据关系栏事件
     *
     * @param {string} eventName
     * @param {any[]} args
     * @memberof EditView2Engine
     */
    public drbarEvent(eventName: string, args: any[]): void {
        if (Object.is(eventName, 'selectionchange')) {
            this.drBarSelectionChange(args);
        }
    }

    /**
     * 数据关系栏选中
     *
     * @param {any[]} args
     * @memberof EditView2Engine
     */
    public drBarSelectionChange(args: any[]): void {
        const item = args[0];
        if (!item || Object.keys(item).length === 0) {
            return;
        }
        this.view.selection = {};
        Object.assign(this.view.selection, JSON.parse(JSON.stringify(item)));
    }

    /**
     * 表单加载完成
     *
     * @param {*} [arg={}]
     * @memberof EditView2Engine
     */
    public onFormLoad(arg: any = {}): void {
        super.onFormLoad(arg);
        if (this.getDRBar()) {
            const tag = this.getDRBar().name;
            this.setViewState2({ tag: tag, action: 'state', viewdata: this.view.vieparams });
        }
    }

    /**
     * 表单保存完成
     *
     * @param {*} [arg={}]
     * @memberof EditView2Engine
     */
    public onFormSave(arg: any = {}): void {
        super.onFormSave(arg);
        if (this.getDRBar()) {
            const tag = this.getDRBar().name;
            this.setViewState2({ tag: tag, action: 'state', viewdata: this.view.viewparams });
        }
    }

    /**
     * 获取关系
     *
     * @returns {*}
     * @memberof EditView2Engine
     */
    public getDRBar(): any {
        return this.drBar;
    }
}