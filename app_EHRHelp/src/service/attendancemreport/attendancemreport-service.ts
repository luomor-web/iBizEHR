import { Http,Util } from '@/utils';
import ATTENDANCEMREPORTServiceBase from './attendancemreport-service-base';


/**
 * 考勤月报服务对象
 *
 * @export
 * @class ATTENDANCEMREPORTService
 * @extends {ATTENDANCEMREPORTServiceBase}
 */
export default class ATTENDANCEMREPORTService extends ATTENDANCEMREPORTServiceBase {

    /**
     * Creates an instance of  ATTENDANCEMREPORTService.
     * 
     * @param {*} [opts={}]
     * @memberof  ATTENDANCEMREPORTService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}