import { Http,Util } from '@/utils';
import UserRoleDataActionServiceBase from './user-role-data-action-service-base';


/**
 * 用户角色数据操作服务对象
 *
 * @export
 * @class UserRoleDataActionService
 * @extends {UserRoleDataActionServiceBase}
 */
export default class UserRoleDataActionService extends UserRoleDataActionServiceBase {

    /**
     * Creates an instance of  UserRoleDataActionService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDataActionService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}