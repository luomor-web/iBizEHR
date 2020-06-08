import { Http,Util } from '@/utils';
import PcmNoticeServiceBase from './pcm-notice-service-base';


/**
 * 提醒消息服务对象
 *
 * @export
 * @class PcmNoticeService
 * @extends {PcmNoticeServiceBase}
 */
export default class PcmNoticeService extends PcmNoticeServiceBase {

    /**
     * Creates an instance of  PcmNoticeService.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmNoticeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}