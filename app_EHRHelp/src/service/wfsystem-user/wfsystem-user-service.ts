import { Http,Util } from '@/utils';
import WFSystemUserServiceBase from './wfsystem-user-service-base';


/**
 * 工作流系统用户***服务对象
 *
 * @export
 * @class WFSystemUserService
 * @extends {WFSystemUserServiceBase}
 */
export default class WFSystemUserService extends WFSystemUserServiceBase {

    /**
     * Creates an instance of  WFSystemUserService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFSystemUserService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}