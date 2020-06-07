import { Http,Util } from '@/utils';
import VacHolidayRulesServiceBase from './vac-holiday-rules-service-base';


/**
 * 考勤规则服务对象
 *
 * @export
 * @class VacHolidayRulesService
 * @extends {VacHolidayRulesServiceBase}
 */
export default class VacHolidayRulesService extends VacHolidayRulesServiceBase {

    /**
     * Creates an instance of  VacHolidayRulesService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacHolidayRulesService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}