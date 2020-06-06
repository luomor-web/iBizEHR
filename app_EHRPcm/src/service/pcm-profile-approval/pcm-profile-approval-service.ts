import { Http,Util } from '@/utils';
import PcmProfileApprovalServiceBase from './pcm-profile-approval-service-base';


/**
 * 应聘者审批表服务对象
 *
 * @export
 * @class PcmProfileApprovalService
 * @extends {PcmProfileApprovalServiceBase}
 */
export default class PcmProfileApprovalService extends PcmProfileApprovalServiceBase {

    /**
     * Creates an instance of  PcmProfileApprovalService.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmProfileApprovalService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}