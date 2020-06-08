import { Http,Util } from '@/utils';
import SalParamServiceBase from './sal-param-service-base';


/**
 * 薪酬计算指标服务对象
 *
 * @export
 * @class SalParamService
 * @extends {SalParamServiceBase}
 */
export default class SalParamService extends SalParamServiceBase {

    /**
     * Creates an instance of  SalParamService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalParamService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}