import { Http,Util } from '@/utils';
import TRMSTAFFServiceBase from './trmstaff-service-base';


/**
 * 员工需求填报服务对象
 *
 * @export
 * @class TRMSTAFFService
 * @extends {TRMSTAFFServiceBase}
 */
export default class TRMSTAFFService extends TRMSTAFFServiceBase {

    /**
     * Creates an instance of  TRMSTAFFService.
     * 
     * @param {*} [opts={}]
     * @memberof  TRMSTAFFService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}