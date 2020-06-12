import { ChartSeries } from './chart-series';

/**
 * 雷达图序列模型
 *
 * @export
 * @class ChartRadarSeries
 */
export class ChartRadarSeries extends ChartSeries{

    /**
     * 分类属性
     *
     * @type {string}
     * @memberof ChartRadarSeries
     */
    public categorField: string = '';

    /**
     * 值属性
     *
     * @type {string}
     * @memberof ChartRadarSeries
     */
    public valueField: string = '';

    /**
     * 雷达图指示器
     *
     * @type {string}
     * @memberof ChartRadarSeries
     */
    public indicator: Array<any> = [];

    /**
     * 分类代码表
     *
     * @type {string}
     * @memberof ChartRadarSeries
     */
    public categorCodeList: any = null;

    /**
     * 维度编码
     *
     * @type {*}
     * @memberof ChartRadarSeries
     */
    public encode:any = null;


    /**
     * Creates an instance of ChartRadarSeries.
     * ChartRadarSeries 实例
     * 
     * @param {*} [opts={}]
     * @memberof ChartRadarSeries
     */
    constructor(opts: any = {}) {
        super(opts);
        this.categorField = !Object.is(opts.categorField, '') ? opts.categorField : '';
        this.categorCodeList = opts.categorCodeList ? opts.categorCodeList : null;
        this.valueField = !Object.is(opts.valueField, '') ? opts.valueField : '';
        this.encode = opts.encode ? opts.encode : null;
        this.indicator = opts.indicator ? opts.indicator:[];
    }

    /**
     * 设置分类属性
     *
     * @param {string} state
     * @memberof ChartRadarSeries
     */
    public setCategorField(state: string): void {
        this.categorField = state;
    }

    /**
     * 设置序列名称
     *
     * @param {string} state
     * @memberof ChartRadarSeries
     */
    public setValueField(state: string): void {
        this.valueField = state;
    }

    /**
     * 分类代码表
     *
     * @param {*} state
     * @memberof ChartRadarSeries
     */
    public setCategorCodeList(state: any): void {
        this.categorCodeList = state;
    }

    /**
     * 设置编码
     *
     * @param {*} state
     * @memberof ChartRadarSeries
     */
    public setEncode(state: any): void {
        this.encode = state;
    }

    /**
     * 设置雷达图指示器
     *
     * @param {*} state
     * @memberof ChartRadarSeries
     */
    public setIndicator(state: any): void {
        this.indicator = state;
    }

}