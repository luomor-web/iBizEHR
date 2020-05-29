import { Http,Util } from '@/utils';
import DynaChartServiceBase from './dyna-chart-service-base';


/**
 * 动态图表服务对象
 *
 * @export
 * @class DynaChartService
 * @extends {DynaChartServiceBase}
 */
export default class DynaChartService extends DynaChartServiceBase {

    /**
     * Creates an instance of  DynaChartService.
     * 
     * @param {*} [opts={}]
     * @memberof  DynaChartService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}