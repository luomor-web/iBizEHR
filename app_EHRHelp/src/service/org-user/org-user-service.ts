import { Http,Util } from '@/utils';
import OrgUserServiceBase from './org-user-service-base';


/**
 * 组织人员服务对象
 *
 * @export
 * @class OrgUserService
 * @extends {OrgUserServiceBase}
 */
export default class OrgUserService extends OrgUserServiceBase {

    /**
     * Creates an instance of  OrgUserService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgUserService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}