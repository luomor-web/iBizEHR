import { Http,Util } from '@/utils';
import UserRoleDataServiceBase from './user-role-data-service-base';


/**
 * 数据对象能力服务对象
 *
 * @export
 * @class UserRoleDataService
 * @extends {UserRoleDataServiceBase}
 */
export default class UserRoleDataService extends UserRoleDataServiceBase {

    /**
     * Creates an instance of  UserRoleDataService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDataService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}