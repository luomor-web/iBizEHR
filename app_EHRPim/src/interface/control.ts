/**
 * 部件接口
 *
 * @interface Control
 */
export interface ControlInterface {

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof Control
     */
    getDatas(): any[];

    /**
     * 获取单项数据
     *
     * @returns {*}
     * @memberof Control
     */
    getData(): any;
}