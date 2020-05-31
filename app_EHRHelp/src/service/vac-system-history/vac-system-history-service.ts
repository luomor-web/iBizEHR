import { Http,Util } from '@/utils';
import VacSystemHistoryServiceBase from './vac-system-history-service-base';


/**
 * 制度历史服务对象
 *
 * @export
 * @class VacSystemHistoryService
 * @extends {VacSystemHistoryServiceBase}
 */
export default class VacSystemHistoryService extends VacSystemHistoryServiceBase {

    /**
     * Creates an instance of  VacSystemHistoryService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacSystemHistoryService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}