import { Http,Util } from '@/utils';
import ATTENDANCEDATEServiceBase from './attendancedate-service-base';


/**
 * 考勤日期服务对象
 *
 * @export
 * @class ATTENDANCEDATEService
 * @extends {ATTENDANCEDATEServiceBase}
 */
export default class ATTENDANCEDATEService extends ATTENDANCEDATEServiceBase {

    /**
     * Creates an instance of  ATTENDANCEDATEService.
     * 
     * @param {*} [opts={}]
     * @memberof  ATTENDANCEDATEService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}