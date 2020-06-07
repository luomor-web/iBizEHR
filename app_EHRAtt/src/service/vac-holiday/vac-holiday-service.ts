import { Http,Util } from '@/utils';
import VacHolidayServiceBase from './vac-holiday-service-base';


/**
 * 节假日管理服务对象
 *
 * @export
 * @class VacHolidayService
 * @extends {VacHolidayServiceBase}
 */
export default class VacHolidayService extends VacHolidayServiceBase {

    /**
     * Creates an instance of  VacHolidayService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacHolidayService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}