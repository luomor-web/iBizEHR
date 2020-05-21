import { Http,Util } from '@/utils';
import WFStepActorServiceBase from './wfstep-actor-service-base';


/**
 * 工作流步骤操作者服务对象
 *
 * @export
 * @class WFStepActorService
 * @extends {WFStepActorServiceBase}
 */
export default class WFStepActorService extends WFStepActorServiceBase {

    /**
     * Creates an instance of  WFStepActorService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFStepActorService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}