import { Http,Util } from '@/utils';
import WXEntAppServiceBase from './wxent-app-service-base';


/**
 * 微信企业应用服务对象
 *
 * @export
 * @class WXEntAppService
 * @extends {WXEntAppServiceBase}
 */
export default class WXEntAppService extends WXEntAppServiceBase {

    /**
     * Creates an instance of  WXEntAppService.
     * 
     * @param {*} [opts={}]
     * @memberof  WXEntAppService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}