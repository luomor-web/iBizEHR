import { ChartSeries } from './chart-series';

/**
 * 折线图序列模型
 *
 * @export
 * @class ChartLineSeries
 */
export class ChartLineSeries extends ChartSeries{

    /**
     * 分类属性
     *
     * @type {string}
     * @memberof ChartLineSeries
     */
    public categorField: string = '';

    /**
     * 值属性
     *
     * @type {string}
     * @memberof ChartLineSeries
     */
    public valueField: string = '';

    /**
     * 分类代码表
     *
     * @type {string}
     * @memberof ChartLineSeries
     */
    public categorCodeList: any = null;

    /**
     * 维度定义
     *
     * @type {string}
     * @memberof ChartLineSeries
     */
    public dimensions:Array<string> = [];

    /**
     * 维度编码
     *
     * @type {*}
     * @memberof ChartLineSeries
     */
    public encode:any = null;

    /**
     * 序列模板
     *
     * @type {*}
     * @memberof ChartLineSeries
     */
    public seriesTemp:any = null;


    /**
     * Creates an instance of ChartLineSeries.
     * ChartLineSeries 实例
     * 
     * @param {*} [opts={}]
     * @memberof ChartLineSeries
     */
    constructor(opts: any = {}) {
        super(opts);
        this.categorField = !Object.is(opts.categorField, '') ? opts.categorField : '';
        this.categorCodeList = opts.categorCodeList ? opts.categorCodeList : null;
        this.valueField = !Object.is(opts.valueField, '') ? opts.valueField : '';
        this.dimensions = opts.dimensions ? opts.dimensions :'';
        this.encode = opts.encode ? opts.encode : null;
        this.seriesTemp = opts.seriesTemp ? opts.seriesTemp:null;
    }

    /**
     * 设置分类属性
     *
     * @param {string} state
     * @memberof ChartLineSeries
     */
    public setCategorField(state: string): void {
        this.categorField = state;
    }

    /**
     * 设置序列名称
     *
     * @param {string} state
     * @memberof ChartLineSeries
     */
    public setValueField(state: string): void {
        this.valueField = state;
    }

    /**
     * 分类代码表
     *
     * @param {*} state
     * @memberof ChartLineSeries
     */
    public setCategorCodeList(state: any): void {
        this.categorCodeList = state;
    }

    /**
     * 维度定义
     *
     * @param {*} state
     * @memberof ChartLineSeries
     */
    public setDimensions(state: any): void {
        this.dimensions = state;
    }

    /**
     * 设置编码
     *
     * @param {*} state
     * @memberof ChartLineSeries
     */
    public setEncode(state: any): void {
        this.encode = state;
    }

    /**
     * 设置序列模板
     *
     * @param {*} state
     * @memberof ChartLineSeries
     */
    public setSeriesTemp(state: any): void {
        this.seriesTemp = state;
    }

}