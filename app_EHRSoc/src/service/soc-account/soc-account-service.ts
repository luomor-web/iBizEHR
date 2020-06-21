import { Http,Util } from '@/utils';
import SocAccountServiceBase from './soc-account-service-base';


/**
 * 参保账户服务对象
 *
 * @export
 * @class SocAccountService
 * @extends {SocAccountServiceBase}
 */
export default class SocAccountService extends SocAccountServiceBase {

    /**
     * Creates an instance of  SocAccountService.
     * 
     * @param {*} [opts={}]
     * @memberof  SocAccountService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}