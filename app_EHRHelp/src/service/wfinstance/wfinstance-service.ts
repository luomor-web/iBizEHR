import { Http,Util } from '@/utils';
import WFInstanceServiceBase from './wfinstance-service-base';


/**
 * 工作流实例服务对象
 *
 * @export
 * @class WFInstanceService
 * @extends {WFInstanceServiceBase}
 */
export default class WFInstanceService extends WFInstanceServiceBase {

    /**
     * Creates an instance of  WFInstanceService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFInstanceService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}