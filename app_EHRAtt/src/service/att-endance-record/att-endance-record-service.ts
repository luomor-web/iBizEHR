import { Http,Util } from '@/utils';
import AttEndanceRecordServiceBase from './att-endance-record-service-base';


/**
 * 考勤记录服务对象
 *
 * @export
 * @class AttEndanceRecordService
 * @extends {AttEndanceRecordServiceBase}
 */
export default class AttEndanceRecordService extends AttEndanceRecordServiceBase {

    /**
     * Creates an instance of  AttEndanceRecordService.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndanceRecordService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}