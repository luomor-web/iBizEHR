import { Http,Util } from '@/utils';
import UserGroupServiceBase from './user-group-service-base';


/**
 * 用户组***服务对象
 *
 * @export
 * @class UserGroupService
 * @extends {UserGroupServiceBase}
 */
export default class UserGroupService extends UserGroupServiceBase {

    /**
     * Creates an instance of  UserGroupService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserGroupService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}