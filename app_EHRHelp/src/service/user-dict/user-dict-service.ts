import { Http,Util } from '@/utils';
import UserDictServiceBase from './user-dict-service-base';


/**
 * 用户词典服务对象
 *
 * @export
 * @class UserDictService
 * @extends {UserDictServiceBase}
 */
export default class UserDictService extends UserDictServiceBase {

    /**
     * Creates an instance of  UserDictService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserDictService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}