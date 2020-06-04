import { Http,Util } from '@/utils';
import PimExpaccountServiceBase from './pim-expaccount-service-base';


/**
 * 费用台账服务对象
 *
 * @export
 * @class PimExpaccountService
 * @extends {PimExpaccountServiceBase}
 */
export default class PimExpaccountService extends PimExpaccountServiceBase {

    /**
     * Creates an instance of  PimExpaccountService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimExpaccountService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}