import { Http,Util } from '@/utils';
import PimContractTypeServiceBase from './pim-contract-type-service-base';


/**
 * 合同类别服务对象
 *
 * @export
 * @class PimContractTypeService
 * @extends {PimContractTypeServiceBase}
 */
export default class PimContractTypeService extends PimContractTypeServiceBase {

    /**
     * Creates an instance of  PimContractTypeService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimContractTypeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}