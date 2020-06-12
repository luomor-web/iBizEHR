import { Http,Util } from '@/utils';
import PersonStateMgrServiceBase from './person-state-mgr-service-base';


/**
 * 员工状态管理服务对象
 *
 * @export
 * @class PersonStateMgrService
 * @extends {PersonStateMgrServiceBase}
 */
export default class PersonStateMgrService extends PersonStateMgrServiceBase {

    /**
     * Creates an instance of  PersonStateMgrService.
     * 
     * @param {*} [opts={}]
     * @memberof  PersonStateMgrService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}