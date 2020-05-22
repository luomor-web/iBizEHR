import { Http,Util } from '@/utils';
import PIMPersonAbilityServiceBase from './pimperson-ability-service-base';


/**
 * 员工能力服务对象
 *
 * @export
 * @class PIMPersonAbilityService
 * @extends {PIMPersonAbilityServiceBase}
 */
export default class PIMPersonAbilityService extends PIMPersonAbilityServiceBase {

    /**
     * Creates an instance of  PIMPersonAbilityService.
     * 
     * @param {*} [opts={}]
     * @memberof  PIMPersonAbilityService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}