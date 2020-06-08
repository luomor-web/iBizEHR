import { Http,Util } from '@/utils';
import AttendRecordDetailServiceBase from './attend-record-detail-service-base';


/**
 * 考勤记录明细服务对象
 *
 * @export
 * @class AttendRecordDetailService
 * @extends {AttendRecordDetailServiceBase}
 */
export default class AttendRecordDetailService extends AttendRecordDetailServiceBase {

    /**
     * Creates an instance of  AttendRecordDetailService.
     * 
     * @param {*} [opts={}]
     * @memberof  AttendRecordDetailService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}