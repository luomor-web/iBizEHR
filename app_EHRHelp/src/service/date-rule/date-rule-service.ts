import { Http,Util } from '@/utils';
import DateRuleServiceBase from './date-rule-service-base';


/**
 * 生效日期规则服务对象
 *
 * @export
 * @class DateRuleService
 * @extends {DateRuleServiceBase}
 */
export default class DateRuleService extends DateRuleServiceBase {

    /**
     * Creates an instance of  DateRuleService.
     * 
     * @param {*} [opts={}]
     * @memberof  DateRuleService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}