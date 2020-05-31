import { Http,Util } from '@/utils';
import AttEndanceSettingsServiceBase from './att-endance-settings-service-base';


/**
 * 考勤人员服务对象
 *
 * @export
 * @class AttEndanceSettingsService
 * @extends {AttEndanceSettingsServiceBase}
 */
export default class AttEndanceSettingsService extends AttEndanceSettingsServiceBase {

    /**
     * Creates an instance of  AttEndanceSettingsService.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndanceSettingsService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}