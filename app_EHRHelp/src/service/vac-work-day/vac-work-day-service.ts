import { Http,Util } from '@/utils';
import VacWorkDayServiceBase from './vac-work-day-service-base';


/**
 * 工作日管理（停用）服务对象
 *
 * @export
 * @class VacWorkDayService
 * @extends {VacWorkDayServiceBase}
 */
export default class VacWorkDayService extends VacWorkDayServiceBase {

    /**
     * Creates an instance of  VacWorkDayService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacWorkDayService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}