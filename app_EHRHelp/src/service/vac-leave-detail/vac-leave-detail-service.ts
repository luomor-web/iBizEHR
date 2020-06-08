import { Http,Util } from '@/utils';
import VacLeaveDetailServiceBase from './vac-leave-detail-service-base';


/**
 * 请假明细服务对象
 *
 * @export
 * @class VacLeaveDetailService
 * @extends {VacLeaveDetailServiceBase}
 */
export default class VacLeaveDetailService extends VacLeaveDetailServiceBase {

    /**
     * Creates an instance of  VacLeaveDetailService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacLeaveDetailService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}