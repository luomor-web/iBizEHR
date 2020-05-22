import { Http,Util } from '@/utils';
import UserGroupDetailServiceBase from './user-group-detail-service-base';


/**
 * 用户组成员***服务对象
 *
 * @export
 * @class UserGroupDetailService
 * @extends {UserGroupDetailServiceBase}
 */
export default class UserGroupDetailService extends UserGroupDetailServiceBase {

    /**
     * Creates an instance of  UserGroupDetailService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserGroupDetailService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}