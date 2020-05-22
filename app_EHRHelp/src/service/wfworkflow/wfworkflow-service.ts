import { Http,Util } from '@/utils';
import WFWorkflowServiceBase from './wfworkflow-service-base';


/**
 * 工作流配置***服务对象
 *
 * @export
 * @class WFWorkflowService
 * @extends {WFWorkflowServiceBase}
 */
export default class WFWorkflowService extends WFWorkflowServiceBase {

    /**
     * Creates an instance of  WFWorkflowService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFWorkflowService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}