import ViewEngine from './view-engine';

/**
 * 实体选择视图
 *
 * @export
 * @class MPickupViewEngine
 * @extends {ViewEngine}
 */
export default class MPickupViewEngine extends ViewEngine {

    /**
     * 选择视图面板
     *
     * @type {*}
     * @memberof MPickupViewEngine
     */
    public pickupViewPanel: any = null;

    /**
     * Creates an instance of MPickupViewEngine.
     * 
     * @memberof MPickupViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof MPickupViewEngine
     */
    public init(options: any): void {
        this.pickupViewPanel = options.pickupviewpanel;
        if (options.view.viewdata && options.view.viewdata.selectedData && Array.isArray(options.view.viewdata.selectedData)) {
            options.view.viewSelections = [...options.view.viewdata.selectedData];
            delete options.view.viewdata.selectedData;
        }
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof MPickupViewEngine
     */
    public load(): void {
        super.load();
        if (this.getPickupViewPanel()) {
            const tag = this.getPickupViewPanel().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        }
    }

    /**
     * 引擎事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof MPickupViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);

        if (Object.is(eventName, 'selectionchange')) {
            this.onSelectionChange(ctrlName, args);
        }
        if (Object.is(eventName, 'load')) {
            this.onLoad(ctrlName, args);
        }
        if (Object.is(eventName, 'activated')) {
            this.onSelectionChange(ctrlName, args);
            this.view.onCLickRight();
        }
    }

    /**
     * 值选中变化
     *
     * @param {string} ctrlName 选择视图面板名称
     * @param {any[]} args 选中数据
     * @memberof MPickupViewEngine
     */
    public onSelectionChange(ctrlName: string, args: any[]): void {
        this.view.containerModel[`view_${ctrlName}`].selections = [...JSON.parse(JSON.stringify(args))];

        Object.values(this.view.containerModel).forEach((model: any) => {
            if (!Object.is(model.type, 'PICKUPVIEWPANEL')) {
                return;
            }
        });
        const _disbaled: boolean = this.view.containerModel[`view_${ctrlName}`].selections.length > 0 ? true : false;
        this.view.containerModel.view_rightbtn = _disbaled;
        if(!this.view.isShowButton){
            this.view.$emit('viewdataschange', [...args]);
        }
    }

    /**
     * 视图加载完成
     *
     * @param {string} ctrlName 选择视图面板名称
     * @param {any[]} args 选中数据
     * @memberof MPickupViewEngine
     */
    public onLoad(ctrlName: string, args: any[]): void {
        this.view.containerModel[`view_${ctrlName}`].datas = [...JSON.parse(JSON.stringify(args))];
    }

    /**
     * 获取选择视图面板
     *
     * @returns {*}
     * @memberof MPickupViewEngine
     */
    public getPickupViewPanel(): any {
        return this.pickupViewPanel;
    }
}