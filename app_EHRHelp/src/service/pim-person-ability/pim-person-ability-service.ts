import { Http,Util } from '@/utils';
import PimPersonAbilityServiceBase from './pim-person-ability-service-base';


/**
 * 员工能力服务对象
 *
 * @export
 * @class PimPersonAbilityService
 * @extends {PimPersonAbilityServiceBase}
 */
export default class PimPersonAbilityService extends PimPersonAbilityServiceBase {

    /**
     * Creates an instance of  PimPersonAbilityService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimPersonAbilityService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}