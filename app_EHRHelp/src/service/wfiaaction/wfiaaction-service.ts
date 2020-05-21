import { Http,Util } from '@/utils';
import WFIAActionServiceBase from './wfiaaction-service-base';


/**
 * 工作流交互操作服务对象
 *
 * @export
 * @class WFIAActionService
 * @extends {WFIAActionServiceBase}
 */
export default class WFIAActionService extends WFIAActionServiceBase {

    /**
     * Creates an instance of  WFIAActionService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFIAActionService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}