import { Http,Util } from '@/utils';
import SalSourceServiceBase from './sal-source-service-base';


/**
 * 薪酬计算源服务对象
 *
 * @export
 * @class SalSourceService
 * @extends {SalSourceServiceBase}
 */
export default class SalSourceService extends SalSourceServiceBase {

    /**
     * Creates an instance of  SalSourceService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalSourceService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}