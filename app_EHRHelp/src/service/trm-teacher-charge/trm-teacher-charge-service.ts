import { Http,Util } from '@/utils';
import TrmTeacherChargeServiceBase from './trm-teacher-charge-service-base';


/**
 * 讲师收费记录服务对象
 *
 * @export
 * @class TrmTeacherChargeService
 * @extends {TrmTeacherChargeServiceBase}
 */
export default class TrmTeacherChargeService extends TrmTeacherChargeServiceBase {

    /**
     * Creates an instance of  TrmTeacherChargeService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTeacherChargeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}