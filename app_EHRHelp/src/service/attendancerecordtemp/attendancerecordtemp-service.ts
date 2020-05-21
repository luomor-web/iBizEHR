import { Http,Util } from '@/utils';
import ATTENDANCERECORDTEMPServiceBase from './attendancerecordtemp-service-base';


/**
 * 考勤记录(中间表)服务对象
 *
 * @export
 * @class ATTENDANCERECORDTEMPService
 * @extends {ATTENDANCERECORDTEMPServiceBase}
 */
export default class ATTENDANCERECORDTEMPService extends ATTENDANCERECORDTEMPServiceBase {

    /**
     * Creates an instance of  ATTENDANCERECORDTEMPService.
     * 
     * @param {*} [opts={}]
     * @memberof  ATTENDANCERECORDTEMPService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}