import { Http,Util } from '@/utils';
import UserDictItemServiceBase from './user-dict-item-service-base';


/**
 * 用户词条***服务对象
 *
 * @export
 * @class UserDictItemService
 * @extends {UserDictItemServiceBase}
 */
export default class UserDictItemService extends UserDictItemServiceBase {

    /**
     * Creates an instance of  UserDictItemService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserDictItemService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}