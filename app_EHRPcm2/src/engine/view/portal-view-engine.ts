import ViewEngine from './view-engine';

/**
 * 实体数据看板视图界面引擎
 *
 * @export
 * @class PortalViewEngine
 * @extends {ViewEngine}
 */
export default class PortalViewEngine extends ViewEngine {

    /**
     * 数据面板部件
     *
     * @type {*}
     * @memberof PortalViewEngine
     */
    public dashboard: any = null;

    /**
     * Creates an instance of PortalViewEngine.
     * 
     * @memberof PortalViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof PortalViewEngine
     */
    public init(options: any): void {
        this.dashboard = options.dashboard;
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof PortalViewEngine
     */
    public load(): void {
        super.load();
        if (this.getDashboard() && this.isLoadDefault) {
            const tag = this.getDashboard().name;
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
     * @memberof PortalViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'dashboard')) {
            this.DashboardEvent(eventName, args);

        }
    }

    /**
     * 实体数据看板事件
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof PortalViewEngine
     */
    public DashboardEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'load')) {
            this.view.$emit('viewload', args);
        }
    }

    /**
     * 获取部件对象
     *
     * @returns {*}
     * @memberof PortalViewEngine
     */
    public getDashboard(): any {
        return this.dashboard;
    }

}