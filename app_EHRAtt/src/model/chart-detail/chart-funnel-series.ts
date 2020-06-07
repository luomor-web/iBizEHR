import { ChartSeries } from './chart-series';

/**
 * 漏斗图序列模型
 *
 * @export
 * @class ChartFunnelSeries
 */
export class ChartFunnelSeries extends ChartSeries{

    /**
     * 分类属性
     *
     * @type {string}
     * @memberof ChartFunnelSeries
     */
    public categorField: string = '';

    /**
     * 值属性
     *
     * @type {string}
     * @memberof ChartFunnelSeries
     */
    public valueField: string = '';

    /**
     * 分类代码表
     *
     * @type {string}
     * @memberof ChartFunnelSeries
     */
    public categorCodeList: any = null;

    /**
     * 维度定义
     *
     * @type {string}
     * @memberof ChartFunnelSeries
     */
    public dimensions:Array<string> = [];

    /**
     * 维度编码
     *
     * @type {*}
     * @memberof ChartFunnelSeries
     */
    public encode:any = null;


    /**
     * Creates an instance of ChartFunnelSeries.
     * ChartFunnelSeries 实例
     * 
     * @param {*} [opts={}]
     * @memberof ChartFunnelSeries
     */
    constructor(opts: any = {}) {
        super(opts);
        this.categorField = !Object.is(opts.categorField, '') ? opts.categorField : '';
        this.categorCodeList = opts.categorCodeList ? opts.categorCodeList : null;
        this.valueField = !Object.is(opts.valueField, '') ? opts.valueField : '';
        this.dimensions = opts.dimensions ? opts.dimensions :'';
        this.encode = opts.encode ? opts.encode : null;
    }

    /**
     * 设置分类属性
     *
     * @param {string} state
     * @memberof ChartFunnelSeries
     */
    public setCategorField(state: string): void {
        this.categorField = state;
    }

    /**
     * 设置序列名称
     *
     * @param {string} state
     * @memberof ChartFunnelSeries
     */
    public setValueField(state: string): void {
        this.valueField = state;
    }

    /**
     * 分类代码表
     *
     * @param {*} state
     * @memberof ChartFunnelSeries
     */
    public setCategorCodeList(state: any): void {
        this.categorCodeList = state;
    }

    /**
     * 维度定义
     *
     * @param {*} state
     * @memberof ChartFunnelSeries
     */
    public setDimensions(state: any): void {
        this.dimensions = state;
    }

    /**
     * 设置编码
     *
     * @param {*} state
     * @memberof ChartFunnelSeries
     */
    public setEncode(state: any): void {
        this.encode = state;
    }

}