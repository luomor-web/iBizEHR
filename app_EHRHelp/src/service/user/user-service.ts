import { Http,Util } from '@/utils';
import UserServiceBase from './user-service-base';


/**
 * 用户服务对象
 *
 * @export
 * @class UserService
 * @extends {UserServiceBase}
 */
export default class UserService extends UserServiceBase {

    /**
     * Creates an instance of  UserService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}