import { Http,Util } from '@/utils';
import SocRuleServiceBase from './soc-rule-service-base';


/**
 * 社保规则服务对象
 *
 * @export
 * @class SocRuleService
 * @extends {SocRuleServiceBase}
 */
export default class SocRuleService extends SocRuleServiceBase {

    /**
     * Creates an instance of  SocRuleService.
     * 
     * @param {*} [opts={}]
     * @memberof  SocRuleService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}