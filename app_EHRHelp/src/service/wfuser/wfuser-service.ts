import { Http,Util } from '@/utils';
import WFUserServiceBase from './wfuser-service-base';


/**
 * 工作流用户服务对象
 *
 * @export
 * @class WFUserService
 * @extends {WFUserServiceBase}
 */
export default class WFUserService extends WFUserServiceBase {

    /**
     * Creates an instance of  WFUserService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}