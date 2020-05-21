import { Http,Util } from '@/utils';
import UserRoleDataDetailServiceBase from './user-role-data-detail-service-base';


/**
 * 数据对象能力明细服务对象
 *
 * @export
 * @class UserRoleDataDetailService
 * @extends {UserRoleDataDetailServiceBase}
 */
export default class UserRoleDataDetailService extends UserRoleDataDetailServiceBase {

    /**
     * Creates an instance of  UserRoleDataDetailService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDataDetailService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}