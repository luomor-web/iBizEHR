import { Http,Util } from '@/utils';
import SALPLANServiceBase from './salplan-service-base';


/**
 * 薪酬计算计划服务对象
 *
 * @export
 * @class SALPLANService
 * @extends {SALPLANServiceBase}
 */
export default class SALPLANService extends SALPLANServiceBase {

    /**
     * Creates an instance of  SALPLANService.
     * 
     * @param {*} [opts={}]
     * @memberof  SALPLANService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}