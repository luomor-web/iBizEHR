import { Http,Util } from '@/utils';
import PCMNoticeServiceBase from './pcmnotice-service-base';


/**
 * 提醒消息服务对象
 *
 * @export
 * @class PCMNoticeService
 * @extends {PCMNoticeServiceBase}
 */
export default class PCMNoticeService extends PCMNoticeServiceBase {

    /**
     * Creates an instance of  PCMNoticeService.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMNoticeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}