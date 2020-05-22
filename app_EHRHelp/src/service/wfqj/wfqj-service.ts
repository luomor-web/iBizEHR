import { Http,Util } from '@/utils';
import WFQJServiceBase from './wfqj-service-base';


/**
 * 请假（WF）服务对象
 *
 * @export
 * @class WFQJService
 * @extends {WFQJServiceBase}
 */
export default class WFQJService extends WFQJServiceBase {

    /**
     * Creates an instance of  WFQJService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFQJService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}