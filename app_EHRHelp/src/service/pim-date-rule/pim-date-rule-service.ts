import { Http,Util } from '@/utils';
import PimDateRuleServiceBase from './pim-date-rule-service-base';


/**
 * 生效日期规则服务对象
 *
 * @export
 * @class PimDateRuleService
 * @extends {PimDateRuleServiceBase}
 */
export default class PimDateRuleService extends PimDateRuleServiceBase {

    /**
     * Creates an instance of  PimDateRuleService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimDateRuleService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}