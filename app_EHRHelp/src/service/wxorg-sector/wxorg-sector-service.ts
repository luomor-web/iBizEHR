import { Http,Util } from '@/utils';
import WXOrgSectorServiceBase from './wxorg-sector-service-base';


/**
 * 微信部门服务对象
 *
 * @export
 * @class WXOrgSectorService
 * @extends {WXOrgSectorServiceBase}
 */
export default class WXOrgSectorService extends WXOrgSectorServiceBase {

    /**
     * Creates an instance of  WXOrgSectorService.
     * 
     * @param {*} [opts={}]
     * @memberof  WXOrgSectorService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}