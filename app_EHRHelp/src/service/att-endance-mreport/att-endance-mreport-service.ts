import { Http,Util } from '@/utils';
import AttEndanceMreportServiceBase from './att-endance-mreport-service-base';


/**
 * 考勤月报服务对象
 *
 * @export
 * @class AttEndanceMreportService
 * @extends {AttEndanceMreportServiceBase}
 */
export default class AttEndanceMreportService extends AttEndanceMreportServiceBase {

    /**
     * Creates an instance of  AttEndanceMreportService.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndanceMreportService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}