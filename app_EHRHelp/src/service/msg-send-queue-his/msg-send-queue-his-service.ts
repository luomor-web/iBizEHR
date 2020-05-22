import { Http,Util } from '@/utils';
import MsgSendQueueHisServiceBase from './msg-send-queue-his-service-base';


/**
 * 消息发送队列（历史）***服务对象
 *
 * @export
 * @class MsgSendQueueHisService
 * @extends {MsgSendQueueHisServiceBase}
 */
export default class MsgSendQueueHisService extends MsgSendQueueHisServiceBase {

    /**
     * Creates an instance of  MsgSendQueueHisService.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgSendQueueHisService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}