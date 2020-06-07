import { SearchViewEngine } from './search-view-engine';

/**
 * 实体图表视图界面引擎
 *
 * @export
 * @class ChartViewEngine
 * @extends {SearchViewEngine}
 */
export default class ChartViewEngine extends SearchViewEngine {

    /**
     * 图表对象
     *
     * @type {*}
     * @memberof ChartViewEngine
     */
    public chart: any;

    /**
     * 图表初始化
     *
     * @param {*} options
     * @memberof ChartViewEngine
     */
    public init(options: any): void {
        this.chart = options.chart;
        super.init(options);

    }

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof ChartViewEngine
     */
    public load(opts: any = {}): void {
        super.load(opts);
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof ChartViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'chart')) {
            this.chartEvent(eventName, args);
        }
    }

    /**
     * 图表事件
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof ChartViewEngine
     */
    public chartEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'beforeload')) {
            this.dataCtrlBeforeLoad(args)
        }
    }


    /**
     * 搜索表单加载完成
     *
     * @memberof ChartViewEngine
     */
    public onSearchFormLoad(): void {
        super.onSearchFormLoad();
        if (this.getChart() && this.isLoadDefault) {
            const tag = this.getChart().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: {} });
        }
        this.isLoadDefault = true;
    }

    /**
     * 获取图表
     *
     * @returns {*}
     * @memberof ChartViewEngine
     */
    public getChart(): any {
        return this.chart;
    }
}