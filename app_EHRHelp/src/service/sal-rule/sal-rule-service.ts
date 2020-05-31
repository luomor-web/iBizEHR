import { Http,Util } from '@/utils';
import SalRuleServiceBase from './sal-rule-service-base';


/**
 * 薪酬规则服务对象
 *
 * @export
 * @class SalRuleService
 * @extends {SalRuleServiceBase}
 */
export default class SalRuleService extends SalRuleServiceBase {

    /**
     * Creates an instance of  SalRuleService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalRuleService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}