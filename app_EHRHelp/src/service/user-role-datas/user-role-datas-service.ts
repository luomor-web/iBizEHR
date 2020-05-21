import { Http,Util } from '@/utils';
import UserRoleDatasServiceBase from './user-role-datas-service-base';


/**
 * 用户角色数据能力服务对象
 *
 * @export
 * @class UserRoleDatasService
 * @extends {UserRoleDatasServiceBase}
 */
export default class UserRoleDatasService extends UserRoleDatasServiceBase {

    /**
     * Creates an instance of  UserRoleDatasService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserRoleDatasService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}