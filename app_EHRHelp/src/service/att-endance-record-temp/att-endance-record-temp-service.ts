import { Http,Util } from '@/utils';
import AttEndanceRecordTempServiceBase from './att-endance-record-temp-service-base';


/**
 * 考勤记录(中间表)服务对象
 *
 * @export
 * @class AttEndanceRecordTempService
 * @extends {AttEndanceRecordTempServiceBase}
 */
export default class AttEndanceRecordTempService extends AttEndanceRecordTempServiceBase {

    /**
     * Creates an instance of  AttEndanceRecordTempService.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndanceRecordTempService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}