import { Http,Util } from '@/utils';
import SalPlanServiceBase from './sal-plan-service-base';


/**
 * 薪酬计算计划服务对象
 *
 * @export
 * @class SalPlanService
 * @extends {SalPlanServiceBase}
 */
export default class SalPlanService extends SalPlanServiceBase {

    /**
     * Creates an instance of  SalPlanService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalPlanService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}