import { Http,Util } from '@/utils';
import TrmStaffServiceBase from './trm-staff-service-base';


/**
 * 员工需求填报服务对象
 *
 * @export
 * @class TrmStaffService
 * @extends {TrmStaffServiceBase}
 */
export default class TrmStaffService extends TrmStaffServiceBase {

    /**
     * Creates an instance of  TrmStaffService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmStaffService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}