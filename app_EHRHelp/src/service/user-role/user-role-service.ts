import { Http,Util } from '@/utils';
import UserRoleServiceBase from './user-role-service-base';


/**
 * 用户角色服务对象
 *
 * @export
 * @class UserRoleService
 * @extends {UserRoleServiceBase}
 */
export default class UserRoleService extends UserRoleServiceBase {

    /**
     * Creates an instance of  UserRoleService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}