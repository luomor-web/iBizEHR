import { Http,Util } from '@/utils';
import VACSITUATIONServiceBase from './vacsituation-service-base';


/**
 * 用户休假情况服务对象
 *
 * @export
 * @class VACSITUATIONService
 * @extends {VACSITUATIONServiceBase}
 */
export default class VACSITUATIONService extends VACSITUATIONServiceBase {

    /**
     * Creates an instance of  VACSITUATIONService.
     * 
     * @param {*} [opts={}]
     * @memberof  VACSITUATIONService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}