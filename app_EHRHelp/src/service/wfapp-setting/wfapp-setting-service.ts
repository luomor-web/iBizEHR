import { Http,Util } from '@/utils';
import WFAppSettingServiceBase from './wfapp-setting-service-base';


/**
 * 工作流系统设定***服务对象
 *
 * @export
 * @class WFAppSettingService
 * @extends {WFAppSettingServiceBase}
 */
export default class WFAppSettingService extends WFAppSettingServiceBase {

    /**
     * Creates an instance of  WFAppSettingService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFAppSettingService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}