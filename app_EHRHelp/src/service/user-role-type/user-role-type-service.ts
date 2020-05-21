import { Http,Util } from '@/utils';
import UserRoleTypeServiceBase from './user-role-type-service-base';


/**
 * 用户角色类型服务对象
 *
 * @export
 * @class UserRoleTypeService
 * @extends {UserRoleTypeServiceBase}
 */
export default class UserRoleTypeService extends UserRoleTypeServiceBase {

    /**
     * Creates an instance of  UserRoleTypeService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleTypeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}