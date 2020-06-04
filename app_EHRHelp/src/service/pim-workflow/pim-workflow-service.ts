import { Http,Util } from '@/utils';
import PimWorkflowServiceBase from './pim-workflow-service-base';


/**
 * 流程配置服务对象
 *
 * @export
 * @class PimWorkflowService
 * @extends {PimWorkflowServiceBase}
 */
export default class PimWorkflowService extends PimWorkflowServiceBase {

    /**
     * Creates an instance of  PimWorkflowService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimWorkflowService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}