import { Http,Util } from '@/utils';
import CalContractTimeLogicBase from './cal-contract-time-logic-base';

/**
 * 计算合同签订次数
 *
 * @export
 * @class CalContractTimeLogic
 */
export default class CalContractTimeLogic extends CalContractTimeLogicBase{

    /**
     * Creates an instance of  CalContractTimeLogic
     * 
     * @param {*} [opts={}]
     * @memberof  CalContractTimeLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}