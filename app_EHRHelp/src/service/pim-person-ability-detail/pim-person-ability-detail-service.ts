import { Http,Util } from '@/utils';
import PimPersonAbilityDetailServiceBase from './pim-person-ability-detail-service-base';


/**
 * 员工能力明细服务对象
 *
 * @export
 * @class PimPersonAbilityDetailService
 * @extends {PimPersonAbilityDetailServiceBase}
 */
export default class PimPersonAbilityDetailService extends PimPersonAbilityDetailServiceBase {

    /**
     * Creates an instance of  PimPersonAbilityDetailService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimPersonAbilityDetailService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}