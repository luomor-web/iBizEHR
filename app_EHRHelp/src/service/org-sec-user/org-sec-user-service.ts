import { Http,Util } from '@/utils';
import OrgSecUserServiceBase from './org-sec-user-service-base';


/**
 * 组织部门人员服务对象
 *
 * @export
 * @class OrgSecUserService
 * @extends {OrgSecUserServiceBase}
 */
export default class OrgSecUserService extends OrgSecUserServiceBase {

    /**
     * Creates an instance of  OrgSecUserService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgSecUserService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}