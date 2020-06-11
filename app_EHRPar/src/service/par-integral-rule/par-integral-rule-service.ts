import { Http,Util } from '@/utils';
import ParIntegralRuleServiceBase from './par-integral-rule-service-base';


/**
 * 积分规则服务对象
 *
 * @export
 * @class ParIntegralRuleService
 * @extends {ParIntegralRuleServiceBase}
 */
export default class ParIntegralRuleService extends ParIntegralRuleServiceBase {

    /**
     * Creates an instance of  ParIntegralRuleService.
     * 
     * @param {*} [opts={}]
     * @memberof  ParIntegralRuleService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}