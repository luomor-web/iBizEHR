import { Http,Util } from '@/utils';
import PCMReasonServiceBase from './pcmreason-service-base';


/**
 * 配置原因代码表服务对象
 *
 * @export
 * @class PCMReasonService
 * @extends {PCMReasonServiceBase}
 */
export default class PCMReasonService extends PCMReasonServiceBase {

    /**
     * Creates an instance of  PCMReasonService.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMReasonService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}