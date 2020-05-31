import { Http,Util } from '@/utils';
import PimCorrectionApplyServiceBase from './pim-correction-apply-service-base';


/**
 * B/Y类员工转正申请明细（停用）服务对象
 *
 * @export
 * @class PimCorrectionApplyService
 * @extends {PimCorrectionApplyServiceBase}
 */
export default class PimCorrectionApplyService extends PimCorrectionApplyServiceBase {

    /**
     * Creates an instance of  PimCorrectionApplyService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimCorrectionApplyService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}