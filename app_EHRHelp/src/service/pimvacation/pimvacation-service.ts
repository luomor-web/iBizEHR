import { Http,Util } from '@/utils';
import PIMVACATIONServiceBase from './pimvacation-service-base';


/**
 * 休假信息服务对象
 *
 * @export
 * @class PIMVACATIONService
 * @extends {PIMVACATIONServiceBase}
 */
export default class PIMVACATIONService extends PIMVACATIONServiceBase {

    /**
     * Creates an instance of  PIMVACATIONService.
     * 
     * @param {*} [opts={}]
     * @memberof  PIMVACATIONService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}