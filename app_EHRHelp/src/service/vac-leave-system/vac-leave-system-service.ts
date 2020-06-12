import { Http,Util } from '@/utils';
import VacLeaveSystemServiceBase from './vac-leave-system-service-base';


/**
 * 休假制度管理服务对象
 *
 * @export
 * @class VacLeaveSystemService
 * @extends {VacLeaveSystemServiceBase}
 */
export default class VacLeaveSystemService extends VacLeaveSystemServiceBase {

    /**
     * Creates an instance of  VacLeaveSystemService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacLeaveSystemService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}