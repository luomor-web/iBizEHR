import { Http,Util } from '@/utils';
import ATTENDANCERECORDServiceBase from './attendancerecord-service-base';


/**
 * 考勤记录服务对象
 *
 * @export
 * @class ATTENDANCERECORDService
 * @extends {ATTENDANCERECORDServiceBase}
 */
export default class ATTENDANCERECORDService extends ATTENDANCERECORDServiceBase {

    /**
     * Creates an instance of  ATTENDANCERECORDService.
     * 
     * @param {*} [opts={}]
     * @memberof  ATTENDANCERECORDService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}