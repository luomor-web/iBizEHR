import { ChartDataSetField } from './chart-dataset-field';

/**
 * 图表序列模型
 *
 * @export
 * @class ChartSeries
 */
export class ChartSeries {

    /**
     * 序列类型
     *
     * @type {string}
     * @memberof ChartSeries
     */
    public type: string = '';

    /**
     * 图表对象
     *
     * @type {*}
     * @memberof ChartSeries
     */
    public chart: any = null;

    /**
     * 序列名称
     *
     * @type {string}
     * @memberof ChartSeries
     */
    public name: string = '';

    /**
     * 序列标题
     *
     * @type {string}
     * @memberof ChartSeries
     */
    public caption: string = '';

    /**
     * 序列标识属性
     *
     * @type {string}
     * @memberof ChartSeries
     */
    public seriesIdField: string = '';

    /**
     * 序列名称属性
     *
     * @type {string}
     * @memberof ChartSeries
     */
    public seriesNameField: string = '';

    /**
     * 序列标识名称键值对
     *
     * @type {any}
     * @memberof ChartSeries
     */
    public seriesMap:any = null;

    /**
     * 对象索引
     *
     * @type {number}
     * @memberof ChartSeries
     */
    public index: number = 0;

    /**
     * 序列映射数据
     *
     * @type {*}
     * @memberof ChartSeries
     */
    public dataSet: any = [];

    /**
     * 预置配置
     *
     * @type {number}
     * @memberof ChartSeries
     */
    public ecxObject:any;

    /**
     * 用户自定义配置
     *
     * @type {number}
     * @memberof ChartSeries
     */
    public ecObject:any;

    /**
     * 序列索引
     *
     * @type {number}
     * @memberof ChartSeries
     */
    public seriesIndex:number = 0;

    /**
     * 数据集属性集合
     *
     * @type {Array<ChartDataSetField>}
     * @memberof ChartSeries
     */
    public dataSetFields:Array<ChartDataSetField> = [];

    /**
     * 取值方式
     * 'column'：默认，dataset 的列对应于系列，从而 dataset 中每一列是一个维度（dimension）
     * 'row'：dataset 的行对应于系列，从而 dataset 中每一行是一个维度（dimension
     *
     * @type {string}
     * @memberof ChartSeries
     */
    public seriesLayoutBy:string = "column";

    /**
     * 序列代码表
     *
     * @type {*}
     * @memberof ChartSeries
     */
    public seriesCodeList:any;

    /**
     * Creates an instance of ChartSeries.
     * ChartSeries 实例
     * 
     * @param {*} [opts={}]
     * @memberof ChartSeries
     */
    constructor(opts: any = {}) {
        this.type = !Object.is(opts.type, '') ? opts.type : '';
        this.name = !Object.is(opts.name, '') ? opts.name : '';
        this.caption = !Object.is(opts.caption, '') ? opts.caption : '';
        this.seriesIdField = (opts.seriesIdField && !Object.is(opts.seriesIdField, '')) ? opts.seriesIdField : (opts.seriesNameField && !Object.is(opts.seriesNameField, '')) ? opts.seriesNameField : '';
        this.seriesNameField = !Object.is(opts.seriesNameField, '') ? opts.seriesNameField : '';
        this.index = this.index ? this.index : 0;
        this.chart = opts.chart ? opts.chart : null;
        this.dataSet = opts.dataSet ? opts.dataSet : [];
        this.ecxObject = opts.ecxObject ? opts.ecxObject : null;
        this.ecObject = opts.ecObject ? opts.ecObject : null;
        this.seriesLayoutBy = opts.seriesLayoutBy ? opts.seriesLayoutBy:"column";
        this.dataSetFields = opts.dataSetFields ? opts.dataSetFields:[];
        this.seriesMap = opts.seriesMap ? opts.seriesMap:null;
        this.seriesIndex = opts.seriesIndex? opts.seriesIndex:0;
        this.seriesCodeList = opts.seriesCodeList?opts.seriesCodeList:null;
    }

    /**
     * 设置序列类型
     *
     * @param {string} state
     * @memberof ChartSeries
     */
    public setType(state: string): void {
        this.type = state;
    }

    /**
     * 设置序列名称
     *
     * @param {string} state
     * @memberof ChartSeries
     */
    public setCaption(state: string): void {
        this.caption = state;
    }

    /**
     * 设置序列标题
     *
     * @param {string} state
     * @memberof ChartSeries
     */
    public setName(state: string): void {
        this.name = state;
    }

    /**
     * 设置数据集
     *
     * @param {*} state
     * @memberof ChartSeries
     */
    public setDataSet(state: any): void {
        this.dataSet = state;
    }

    /**
     * 设置序列标识名称键值对
     *
     * @param {*} state
     * @memberof ChartSeries
     */
    public setSeriesMap(state: any): void {
        this.seriesMap = state;
    }

    /**
     * 设置序列映射的图表
     *
     * @param {*} state
     * @memberof ChartSeries
     */
    public setChart(state: any): void {
        this.chart = state;
    }

    /**
     * 设置序列标识属性
     *
     * @param {*} state
     * @memberof ChartSeries
     */
    public setSeriesIdField(state: any): void {
        this.seriesIdField = state;
    }

    /**
     * 设置序列名称属性
     *
     * @param {*} state
     * @memberof ChartSeries
     */
    public setSeriesNameField(state: any): void {
        this.seriesNameField = state;
    }

    /**
     * 设置对象索引
     *
     * @param {number} state
     * @memberof ChartSeries
     */
    public setIndex(state: number): void {
        this.index = state;
    }

    /**
     * 设置预置配置
     *
     * @param {*} state
     * @memberof ChartSeries
     */
    public setECXObject(state: any): void {
        this.ecxObject = state;
    }

    /**
     * 设置用户自定义参数
     *
     * @param {*} state
     * @memberof ChartSeries
     */
    public setECObject(state: any): void {
        this.ecObject = state;
    }

    /**
     * 设置取值方式
     *
     * @param {string} state
     * @memberof ChartSeries
     */
    public setSeriesLayoutBy(state: string): void {
        this.seriesLayoutBy = state;
    }

    /**
     * 设置数据集属性集合
     *
     * @param {Array<ChartDataSetField>} state
     * @memberof ChartSeries
     */
    public setDataSetFields(state: Array<ChartDataSetField>): void {
        this.dataSetFields = state;
    }

    /**
     * 设置序列索引
     *
     * @param {number} state
     * @memberof ChartSeries
     */
    public setSeriesIndex(state: number): void {
        this.seriesIndex = state;
    }

    /**
     * 设置序列代码表
     *
     * @param {any} state
     * @memberof ChartSeries
     */
    public setSeriesCodeList(state: any): void {
        this.seriesCodeList = state;
    }
}