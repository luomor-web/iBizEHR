import { Http,Util } from '@/utils';
import OrmUserServiceBase from './orm-user-service-base';


/**
 * 用户管理服务对象
 *
 * @export
 * @class OrmUserService
 * @extends {OrmUserServiceBase}
 */
export default class OrmUserService extends OrmUserServiceBase {

    /**
     * Creates an instance of  OrmUserService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmUserService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}