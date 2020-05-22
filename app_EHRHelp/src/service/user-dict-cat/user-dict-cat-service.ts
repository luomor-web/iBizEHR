import { Http,Util } from '@/utils';
import UserDictCatServiceBase from './user-dict-cat-service-base';


/**
 * 用户词条类别***服务对象
 *
 * @export
 * @class UserDictCatService
 * @extends {UserDictCatServiceBase}
 */
export default class UserDictCatService extends UserDictCatServiceBase {

    /**
     * Creates an instance of  UserDictCatService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserDictCatService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}