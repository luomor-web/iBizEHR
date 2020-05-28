import { Http,Util } from '@/utils';
import UnitedPersonServiceBase from './united-person-service-base';


/**
 * 统一身份库服务对象
 *
 * @export
 * @class UnitedPersonService
 * @extends {UnitedPersonServiceBase}
 */
export default class UnitedPersonService extends UnitedPersonServiceBase {

    /**
     * Creates an instance of  UnitedPersonService.
     * 
     * @param {*} [opts={}]
     * @memberof  UnitedPersonService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}