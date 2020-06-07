import { Http,Util } from '@/utils';
import VacLeaveTipsServiceBase from './vac-leave-tips-service-base';


/**
 * 请假提示服务对象
 *
 * @export
 * @class VacLeaveTipsService
 * @extends {VacLeaveTipsServiceBase}
 */
export default class VacLeaveTipsService extends VacLeaveTipsServiceBase {

    /**
     * Creates an instance of  VacLeaveTipsService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacLeaveTipsService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}