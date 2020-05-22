import { Http,Util } from '@/utils';
import UserObjectServiceBase from './user-object-service-base';


/**
 * 用户对象***服务对象
 *
 * @export
 * @class UserObjectService
 * @extends {UserObjectServiceBase}
 */
export default class UserObjectService extends UserObjectServiceBase {

    /**
     * Creates an instance of  UserObjectService.
     * 
     * @param {*} [opts={}]
     * @memberof  UserObjectService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}