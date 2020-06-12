import { Http,Util } from '@/utils';
import OrmUnitedPersonServiceBase from './orm-united-person-service-base';


/**
 * 统一身份库服务对象
 *
 * @export
 * @class OrmUnitedPersonService
 * @extends {OrmUnitedPersonServiceBase}
 */
export default class OrmUnitedPersonService extends OrmUnitedPersonServiceBase {

    /**
     * Creates an instance of  OrmUnitedPersonService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmUnitedPersonService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}