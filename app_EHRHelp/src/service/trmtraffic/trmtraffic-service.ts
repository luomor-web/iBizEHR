import { Http,Util } from '@/utils';
import TRMTRAFFICServiceBase from './trmtraffic-service-base';


/**
 * 交通服务对象
 *
 * @export
 * @class TRMTRAFFICService
 * @extends {TRMTRAFFICServiceBase}
 */
export default class TRMTRAFFICService extends TRMTRAFFICServiceBase {

    /**
     * Creates an instance of  TRMTRAFFICService.
     * 
     * @param {*} [opts={}]
     * @memberof  TRMTRAFFICService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}