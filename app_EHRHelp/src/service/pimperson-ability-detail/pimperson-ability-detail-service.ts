import { Http,Util } from '@/utils';
import PIMPersonAbilityDetailServiceBase from './pimperson-ability-detail-service-base';


/**
 * 员工能力明细服务对象
 *
 * @export
 * @class PIMPersonAbilityDetailService
 * @extends {PIMPersonAbilityDetailServiceBase}
 */
export default class PIMPersonAbilityDetailService extends PIMPersonAbilityDetailServiceBase {

    /**
     * Creates an instance of  PIMPersonAbilityDetailService.
     * 
     * @param {*} [opts={}]
     * @memberof  PIMPersonAbilityDetailService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}