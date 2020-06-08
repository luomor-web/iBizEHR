import { Http,Util } from '@/utils';
import TrmEmployeeRetionServiceBase from './trm-employee-retion-service-base';


/**
 * 员工培训报名服务对象
 *
 * @export
 * @class TrmEmployeeRetionService
 * @extends {TrmEmployeeRetionServiceBase}
 */
export default class TrmEmployeeRetionService extends TrmEmployeeRetionServiceBase {

    /**
     * Creates an instance of  TrmEmployeeRetionService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmEmployeeRetionService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}