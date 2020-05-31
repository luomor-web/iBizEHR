import { Http,Util } from '@/utils';
import OrmSignOrgServiceBase from './orm-sign-org-service-base';


/**
 * 法人主体服务对象
 *
 * @export
 * @class OrmSignOrgService
 * @extends {OrmSignOrgServiceBase}
 */
export default class OrmSignOrgService extends OrmSignOrgServiceBase {

    /**
     * Creates an instance of  OrmSignOrgService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmSignOrgService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}