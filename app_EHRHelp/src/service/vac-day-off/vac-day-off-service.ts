import { Http,Util } from '@/utils';
import VacDayOffServiceBase from './vac-day-off-service-base';


/**
 * 调休日管理（停用）服务对象
 *
 * @export
 * @class VacDayOffService
 * @extends {VacDayOffServiceBase}
 */
export default class VacDayOffService extends VacDayOffServiceBase {

    /**
     * Creates an instance of  VacDayOffService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacDayOffService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}