import { Http,Util } from '@/utils';
import OrmDutyServiceBase from './orm-duty-service-base';


/**
 * 职务管理服务对象
 *
 * @export
 * @class OrmDutyService
 * @extends {OrmDutyServiceBase}
 */
export default class OrmDutyService extends OrmDutyServiceBase {

    /**
     * Creates an instance of  OrmDutyService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmDutyService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}