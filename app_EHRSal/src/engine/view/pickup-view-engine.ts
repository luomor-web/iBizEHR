import ViewEngine from './view-engine';

/**
 * 实体选择视图
 *
 * @export
 * @class PickupViewEngine
 * @extends {ViewEngine}
 */
export default class PickupViewEngine extends ViewEngine {

    /**
     * 选择视图面板
     *
     * @type {*}
     * @memberof PickupViewEngine
     */
    public pickupViewPanel: any = null;

    /**
     * Creates an instance of PickupViewEngine.
     * 
     * @memberof PickupViewEngine
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
        this.pickupViewPanel = options.pickupviewpanel;
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof PickupViewEngine
     */
    public load(): void {
        this.view.viewSelections = [];
        super.load();
        if (this.getPickupViewPanel()) {
            const tag = this.getPickupViewPanel().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        }
    }

    /**
     * 
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof PickupViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);

        if (Object.is(eventName, 'selectionchange')) {
            this.onSelectionChange(args);
        }
        if (Object.is(eventName, 'activated')) {
            this.view.$emit('viewdatasactivated', args);
        }
    }

    /**
     * 值选中变化
     *
     * @param {any[]} args
     * @memberof PickupViewEngine
     */
    public onSelectionChange(args: any[]): void {
        this.view.viewSelections = [];
        this.view.viewSelections = [...args]
        const _disabled: boolean = this.view.viewSelections.length > 0 ? false : true;
        this.view.containerModel.view_okbtn.disabled = _disabled;
        if(!this.view.isShowButton){
            this.view.$emit('viewdataschange', [...args]);
        }
    }

    /**
     * 获取选择视图面板
     *
     * @returns {*}
     * @memberof PickupViewEngine
     */
    public getPickupViewPanel(): any {
        return this.pickupViewPanel;
    }
}