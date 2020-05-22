import { Http,Util } from '@/utils';
import WXAccessTokenServiceBase from './wxaccess-token-service-base';


/**
 * 微信访问票据***服务对象
 *
 * @export
 * @class WXAccessTokenService
 * @extends {WXAccessTokenServiceBase}
 */
export default class WXAccessTokenService extends WXAccessTokenServiceBase {

    /**
     * Creates an instance of  WXAccessTokenService.
     * 
     * @param {*} [opts={}]
     * @memberof  WXAccessTokenService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}