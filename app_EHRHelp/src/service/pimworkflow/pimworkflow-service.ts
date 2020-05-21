import { Http,Util } from '@/utils';
import PIMWorkflowServiceBase from './pimworkflow-service-base';


/**
 * 流程配置服务对象
 *
 * @export
 * @class PIMWorkflowService
 * @extends {PIMWorkflowServiceBase}
 */
export default class PIMWorkflowService extends PIMWorkflowServiceBase {

    /**
     * Creates an instance of  PIMWorkflowService.
     * 
     * @param {*} [opts={}]
     * @memberof  PIMWorkflowService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}