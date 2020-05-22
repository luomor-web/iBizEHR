import { Http,Util } from '@/utils';
import UserRoleDetailServiceBase from './user-role-detail-service-base';


/**
 * 用户角色成员***服务对象
 *
 * @export
 * @class UserRoleDetailService
 * @extends {UserRoleDetailServiceBase}
 */
export default class UserRoleDetailService extends UserRoleDetailServiceBase {

    /**
     * Creates an instance of  UserRoleDetailService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDetailService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}