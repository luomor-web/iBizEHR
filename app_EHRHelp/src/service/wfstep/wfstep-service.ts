import { Http,Util } from '@/utils';
import WFStepServiceBase from './wfstep-service-base';


/**
 * 工作流步骤服务对象
 *
 * @export
 * @class WFStepService
 * @extends {WFStepServiceBase}
 */
export default class WFStepService extends WFStepServiceBase {

    /**
     * Creates an instance of  WFStepService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFStepService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}