import { Http,Util } from '@/utils';
import TrmTrainPlanServiceBase from './trm-train-plan-service-base';


/**
 * 培训计划服务对象
 *
 * @export
 * @class TrmTrainPlanService
 * @extends {TrmTrainPlanServiceBase}
 */
export default class TrmTrainPlanService extends TrmTrainPlanServiceBase {

    /**
     * Creates an instance of  TrmTrainPlanService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainPlanService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}