import { Http,Util } from '@/utils';
import AttEnsummaryServiceBase from './att-ensummary-service-base';


/**
 * 考勤汇总服务对象
 *
 * @export
 * @class AttEnsummaryService
 * @extends {AttEnsummaryServiceBase}
 */
export default class AttEnsummaryService extends AttEnsummaryServiceBase {

    /**
     * Creates an instance of  AttEnsummaryService.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEnsummaryService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}