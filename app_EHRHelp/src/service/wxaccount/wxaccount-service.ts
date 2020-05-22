import { Http,Util } from '@/utils';
import WXAccountServiceBase from './wxaccount-service-base';


/**
 * 微信公众号***服务对象
 *
 * @export
 * @class WXAccountService
 * @extends {WXAccountServiceBase}
 */
export default class WXAccountService extends WXAccountServiceBase {

    /**
     * Creates an instance of  WXAccountService.
     * 
     * @param {*} [opts={}]
     * @memberof  WXAccountService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}