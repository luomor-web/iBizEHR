/**
 * 图表数据集属性模型
 *
 * @export
 * @class ChartDataSetField
 */
export class ChartDataSetField {

    /**
     * 图表属性名称
     *
     * @type {string}
     * @memberof ChartDataSetField
     */
    public name: string = '';

    /**
     * 图表属性代码表
     *
     * @type {*}
     * @memberof ChartDataSetField
     */
    public codelist: any = null;

    /**
     * 是否分组属性
     *
     * @type {boolean}
     * @memberof ChartDataSetField
     */
    public isGroupField: boolean = false;

    /**
     * 分组模式
     *
     * @type {string}
     * @memberof ChartDataSetField
     */
    public groupMode:string ="";

    /**
     * Creates an instance of ChartDataSetField.
     * ChartDataSetField 实例
     * 
     * @param {*} [opts={}]
     * @memberof ChartDataSetField
     */
    constructor(opts: any = {}) {
        this.name = !Object.is(opts.name, '') ? opts.name : '';
        this.codelist = opts.codelist?opts.codelist:null;
        this.isGroupField = opts.isGroupField?opts.isGroupField:false;
        this.groupMode = !Object.is(opts.groupMode, '') ? opts.groupMode : '';
    }

    /**
     * 设置图表属性名称
     *
     * @param {string} state
     * @memberof ChartDataSetField
     */
    public setName(state: string): void {
        this.name = state;
    }

    /**
     * 设置图表属性代码表
     *
     * @param {*} state
     * @memberof ChartDataSetField
     */
    public setCodeList(state: any): void {
        this.codelist = state;
    }

    /**
     * 设置分组属性
     *
     * @param {boolean} state
     * @memberof ChartDataSetField
     */
    public setisGroupField(state: boolean): void {
        this.isGroupField = state;
    }

    /**
     * 设置属性分组模式
     *
     * @param {string} state
     * @memberof ChartDataSetField
     */
    public setGroupMode(state: string): void {
        this.groupMode = state;
    }
}