import { Http,Util } from '@/utils';
import VacSituationServiceBase from './vac-situation-service-base';


/**
 * 用户休假情况服务对象
 *
 * @export
 * @class VacSituationService
 * @extends {VacSituationServiceBase}
 */
export default class VacSituationService extends VacSituationServiceBase {

    /**
     * Creates an instance of  VacSituationService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacSituationService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}