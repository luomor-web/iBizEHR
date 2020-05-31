import { Http,Util } from '@/utils';
import SalPersonStdServiceBase from './sal-person-std-service-base';


/**
 * 员工薪酬标准服务对象
 *
 * @export
 * @class SalPersonStdService
 * @extends {SalPersonStdServiceBase}
 */
export default class SalPersonStdService extends SalPersonStdServiceBase {

    /**
     * Creates an instance of  SalPersonStdService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalPersonStdService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}