import { Http,Util } from '@/utils';
import TRMSTAYServiceBase from './trmstay-service-base';


/**
 * 培训住宿服务对象
 *
 * @export
 * @class TRMSTAYService
 * @extends {TRMSTAYServiceBase}
 */
export default class TRMSTAYService extends TRMSTAYServiceBase {

    /**
     * Creates an instance of  TRMSTAYService.
     * 
     * @param {*} [opts={}]
     * @memberof  TRMSTAYService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}