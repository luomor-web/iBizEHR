import { Http,Util } from '@/utils';
import TrmTrainDemandServiceBase from './trm-train-demand-service-base';


/**
 * 部门需求汇总服务对象
 *
 * @export
 * @class TrmTrainDemandService
 * @extends {TrmTrainDemandServiceBase}
 */
export default class TrmTrainDemandService extends TrmTrainDemandServiceBase {

    /**
     * Creates an instance of  TrmTrainDemandService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainDemandService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}