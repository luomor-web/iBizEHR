import { Http,Util } from '@/utils';
import OrmOrgServiceBase from './orm-org-service-base';


/**
 * 组织管理服务对象
 *
 * @export
 * @class OrmOrgService
 * @extends {OrmOrgServiceBase}
 */
export default class OrmOrgService extends OrmOrgServiceBase {

    /**
     * Creates an instance of  OrmOrgService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmOrgService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}