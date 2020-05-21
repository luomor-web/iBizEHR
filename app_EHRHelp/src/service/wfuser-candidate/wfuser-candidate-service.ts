import { Http,Util } from '@/utils';
import WFUserCandidateServiceBase from './wfuser-candidate-service-base';


/**
 * 工作流用户候选者服务对象
 *
 * @export
 * @class WFUserCandidateService
 * @extends {WFUserCandidateServiceBase}
 */
export default class WFUserCandidateService extends WFUserCandidateServiceBase {

    /**
     * Creates an instance of  WFUserCandidateService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserCandidateService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}