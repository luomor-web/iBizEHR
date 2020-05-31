import { Http,Util } from '@/utils';
import PimWorkHistoryServiceBase from './pim-work-history-service-base';


/**
 * 工作履历服务对象
 *
 * @export
 * @class PimWorkHistoryService
 * @extends {PimWorkHistoryServiceBase}
 */
export default class PimWorkHistoryService extends PimWorkHistoryServiceBase {

    /**
     * Creates an instance of  PimWorkHistoryService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimWorkHistoryService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}