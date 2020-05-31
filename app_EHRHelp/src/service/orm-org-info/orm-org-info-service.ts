import { Http,Util } from '@/utils';
import OrmOrgInfoServiceBase from './orm-org-info-service-base';


/**
 * 组织信息服务对象
 *
 * @export
 * @class OrmOrgInfoService
 * @extends {OrmOrgInfoServiceBase}
 */
export default class OrmOrgInfoService extends OrmOrgInfoServiceBase {

    /**
     * Creates an instance of  OrmOrgInfoService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmOrgInfoService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}