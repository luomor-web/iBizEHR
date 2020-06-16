import { Http,Util } from '@/utils';
import TrmTrainOutApplyServiceBase from './trm-train-out-apply-service-base';


/**
 * 外部培训申请服务对象
 *
 * @export
 * @class TrmTrainOutApplyService
 * @extends {TrmTrainOutApplyServiceBase}
 */
export default class TrmTrainOutApplyService extends TrmTrainOutApplyServiceBase {

    /**
     * Creates an instance of  TrmTrainOutApplyService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainOutApplyService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}