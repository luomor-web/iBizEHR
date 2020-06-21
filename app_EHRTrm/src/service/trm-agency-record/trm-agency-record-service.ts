import { Http,Util } from '@/utils';
import TrmAgencyRecordServiceBase from './trm-agency-record-service-base';


/**
 * 机构培训记录服务对象
 *
 * @export
 * @class TrmAgencyRecordService
 * @extends {TrmAgencyRecordServiceBase}
 */
export default class TrmAgencyRecordService extends TrmAgencyRecordServiceBase {

    /**
     * Creates an instance of  TrmAgencyRecordService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmAgencyRecordService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}