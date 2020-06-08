import { Http,Util } from '@/utils';
import VacSituationDetailServiceBase from './vac-situation-detail-service-base';


/**
 * 休假明细服务对象
 *
 * @export
 * @class VacSituationDetailService
 * @extends {VacSituationDetailServiceBase}
 */
export default class VacSituationDetailService extends VacSituationDetailServiceBase {

    /**
     * Creates an instance of  VacSituationDetailService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacSituationDetailService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}