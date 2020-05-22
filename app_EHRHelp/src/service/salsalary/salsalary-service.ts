import { Http,Util } from '@/utils';
import SALSALARYServiceBase from './salsalary-service-base';


/**
 * 员工薪酬服务对象
 *
 * @export
 * @class SALSALARYService
 * @extends {SALSALARYServiceBase}
 */
export default class SALSALARYService extends SALSALARYServiceBase {

    /**
     * Creates an instance of  SALSALARYService.
     * 
     * @param {*} [opts={}]
     * @memberof  SALSALARYService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}