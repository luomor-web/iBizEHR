import { Http,Util } from '@/utils';
import WFUserGroupDetailServiceBase from './wfuser-group-detail-service-base';


/**
 * 工作流用户组成员***服务对象
 *
 * @export
 * @class WFUserGroupDetailService
 * @extends {WFUserGroupDetailServiceBase}
 */
export default class WFUserGroupDetailService extends WFUserGroupDetailServiceBase {

    /**
     * Creates an instance of  WFUserGroupDetailService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserGroupDetailService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}