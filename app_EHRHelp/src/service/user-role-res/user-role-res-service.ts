import { Http,Util } from '@/utils';
import UserRoleResServiceBase from './user-role-res-service-base';


/**
 * 用户角色资源能力服务对象
 *
 * @export
 * @class UserRoleResService
 * @extends {UserRoleResServiceBase}
 */
export default class UserRoleResService extends UserRoleResServiceBase {

    /**
     * Creates an instance of  UserRoleResService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleResService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}