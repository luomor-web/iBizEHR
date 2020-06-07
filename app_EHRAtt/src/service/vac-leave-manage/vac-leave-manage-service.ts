import { Http,Util } from '@/utils';
import VacLeaveManageServiceBase from './vac-leave-manage-service-base';


/**
 * 请假管理服务对象
 *
 * @export
 * @class VacLeaveManageService
 * @extends {VacLeaveManageServiceBase}
 */
export default class VacLeaveManageService extends VacLeaveManageServiceBase {

    /**
     * Creates an instance of  VacLeaveManageService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacLeaveManageService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}