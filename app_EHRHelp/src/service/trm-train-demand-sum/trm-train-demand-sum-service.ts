import { Http,Util } from '@/utils';
import TrmTrainDemandSumServiceBase from './trm-train-demand-sum-service-base';


/**
 * 培训需求汇总明细服务对象
 *
 * @export
 * @class TrmTrainDemandSumService
 * @extends {TrmTrainDemandSumServiceBase}
 */
export default class TrmTrainDemandSumService extends TrmTrainDemandSumServiceBase {

    /**
     * Creates an instance of  TrmTrainDemandSumService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainDemandSumService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}