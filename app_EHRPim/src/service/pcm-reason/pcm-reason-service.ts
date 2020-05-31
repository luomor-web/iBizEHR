import { Http,Util } from '@/utils';
import PcmReasonServiceBase from './pcm-reason-service-base';


/**
 * 配置原因代码表服务对象
 *
 * @export
 * @class PcmReasonService
 * @extends {PcmReasonServiceBase}
 */
export default class PcmReasonService extends PcmReasonServiceBase {

    /**
     * Creates an instance of  PcmReasonService.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmReasonService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}