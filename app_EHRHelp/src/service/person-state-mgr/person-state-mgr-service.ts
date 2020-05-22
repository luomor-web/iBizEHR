import { Http,Util } from '@/utils';
import PersonStateMGRServiceBase from './person-state-mgr-service-base';


/**
 * 员工状态管理服务对象
 *
 * @export
 * @class PersonStateMGRService
 * @extends {PersonStateMGRServiceBase}
 */
export default class PersonStateMGRService extends PersonStateMGRServiceBase {

    /**
     * Creates an instance of  PersonStateMGRService.
     * 
     * @param {*} [opts={}]
     * @memberof  PersonStateMGRService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}