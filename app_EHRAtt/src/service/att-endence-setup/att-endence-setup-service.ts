import { Http,Util } from '@/utils';
import AttEndenceSetupServiceBase from './att-endence-setup-service-base';


/**
 * 考勤设置服务对象
 *
 * @export
 * @class AttEndenceSetupService
 * @extends {AttEndenceSetupServiceBase}
 */
export default class AttEndenceSetupService extends AttEndenceSetupServiceBase {

    /**
     * Creates an instance of  AttEndenceSetupService.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndenceSetupService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}