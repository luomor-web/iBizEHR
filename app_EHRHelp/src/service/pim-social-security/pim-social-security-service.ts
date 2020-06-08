import { Http,Util } from '@/utils';
import PimSocialSecurityServiceBase from './pim-social-security-service-base';


/**
 * 社保信息服务对象
 *
 * @export
 * @class PimSocialSecurityService
 * @extends {PimSocialSecurityServiceBase}
 */
export default class PimSocialSecurityService extends PimSocialSecurityServiceBase {

    /**
     * Creates an instance of  PimSocialSecurityService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimSocialSecurityService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}