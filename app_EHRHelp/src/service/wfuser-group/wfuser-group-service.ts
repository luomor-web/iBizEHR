import { Http,Util } from '@/utils';
import WFUserGroupServiceBase from './wfuser-group-service-base';


/**
 * 工作流用户组服务对象
 *
 * @export
 * @class WFUserGroupService
 * @extends {WFUserGroupServiceBase}
 */
export default class WFUserGroupService extends WFUserGroupServiceBase {

    /**
     * Creates an instance of  WFUserGroupService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserGroupService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}