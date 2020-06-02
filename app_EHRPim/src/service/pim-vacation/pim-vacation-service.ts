import { Http,Util } from '@/utils';
import PimVacationServiceBase from './pim-vacation-service-base';


/**
 * 休假信息服务对象
 *
 * @export
 * @class PimVacationService
 * @extends {PimVacationServiceBase}
 */
export default class PimVacationService extends PimVacationServiceBase {

    /**
     * Creates an instance of  PimVacationService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimVacationService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}