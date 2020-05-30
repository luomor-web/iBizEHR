import { Http,Util } from '@/utils';
import PimContractServiceBase from './pim-contract-service-base';


/**
 * 合同信息服务对象
 *
 * @export
 * @class PimContractService
 * @extends {PimContractServiceBase}
 */
export default class PimContractService extends PimContractServiceBase {

    /**
     * Creates an instance of  PimContractService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimContractService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}