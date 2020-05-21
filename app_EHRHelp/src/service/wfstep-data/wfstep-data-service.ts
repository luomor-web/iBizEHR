import { Http,Util } from '@/utils';
import WFStepDataServiceBase from './wfstep-data-service-base';


/**
 * 工作流步骤数据服务对象
 *
 * @export
 * @class WFStepDataService
 * @extends {WFStepDataServiceBase}
 */
export default class WFStepDataService extends WFStepDataServiceBase {

    /**
     * Creates an instance of  WFStepDataService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFStepDataService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}