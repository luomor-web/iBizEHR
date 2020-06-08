import { Http,Util } from '@/utils';
import PcmLogServiceBase from './pcm-log-service-base';


/**
 * 配置变动日志服务对象
 *
 * @export
 * @class PcmLogService
 * @extends {PcmLogServiceBase}
 */
export default class PcmLogService extends PcmLogServiceBase {

    /**
     * Creates an instance of  PcmLogService.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmLogService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}