import { Http,Util } from '@/utils';
import WFReminderServiceBase from './wfreminder-service-base';


/**
 * 工作流工作催办服务对象
 *
 * @export
 * @class WFReminderService
 * @extends {WFReminderServiceBase}
 */
export default class WFReminderService extends WFReminderServiceBase {

    /**
     * Creates an instance of  WFReminderService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFReminderService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}