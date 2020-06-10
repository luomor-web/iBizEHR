import { Http,Util } from '@/utils';
import SalRuleDetailServiceBase from './sal-rule-detail-service-base';


/**
 * 薪酬规则明细服务对象
 *
 * @export
 * @class SalRuleDetailService
 * @extends {SalRuleDetailServiceBase}
 */
export default class SalRuleDetailService extends SalRuleDetailServiceBase {

    /**
     * Creates an instance of  SalRuleDetailService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalRuleDetailService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}