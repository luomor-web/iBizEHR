import { Http,Util } from '@/utils';
import TrmStaffnodesServiceBase from './trm-staffnodes-service-base';


/**
 * 员工需求明细服务对象
 *
 * @export
 * @class TrmStaffnodesService
 * @extends {TrmStaffnodesServiceBase}
 */
export default class TrmStaffnodesService extends TrmStaffnodesServiceBase {

    /**
     * Creates an instance of  TrmStaffnodesService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmStaffnodesService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}