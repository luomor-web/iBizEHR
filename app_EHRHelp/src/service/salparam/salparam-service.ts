import { Http,Util } from '@/utils';
import SALPARAMServiceBase from './salparam-service-base';


/**
 * 薪酬计算指标服务对象
 *
 * @export
 * @class SALPARAMService
 * @extends {SALPARAMServiceBase}
 */
export default class SALPARAMService extends SALPARAMServiceBase {

    /**
     * Creates an instance of  SALPARAMService.
     * 
     * @param {*} [opts={}]
     * @memberof  SALPARAMService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}