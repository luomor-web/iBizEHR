import { Http,Util } from '@/utils';
import TrmTrainAddressServiceBase from './trm-train-address-service-base';


/**
 * 培训场地服务对象
 *
 * @export
 * @class TrmTrainAddressService
 * @extends {TrmTrainAddressServiceBase}
 */
export default class TrmTrainAddressService extends TrmTrainAddressServiceBase {

    /**
     * Creates an instance of  TrmTrainAddressService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrainAddressService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}