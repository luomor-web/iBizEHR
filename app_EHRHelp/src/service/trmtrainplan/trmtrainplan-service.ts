import { Http,Util } from '@/utils';
import TRMTRAINPLANServiceBase from './trmtrainplan-service-base';


/**
 * 培训计划服务对象
 *
 * @export
 * @class TRMTRAINPLANService
 * @extends {TRMTRAINPLANServiceBase}
 */
export default class TRMTRAINPLANService extends TRMTRAINPLANServiceBase {

    /**
     * Creates an instance of  TRMTRAINPLANService.
     * 
     * @param {*} [opts={}]
     * @memberof  TRMTRAINPLANService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}