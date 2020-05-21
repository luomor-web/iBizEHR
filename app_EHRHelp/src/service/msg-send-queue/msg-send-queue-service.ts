import { Http,Util } from '@/utils';
import MsgSendQueueServiceBase from './msg-send-queue-service-base';


/**
 * 消息发送队列服务对象
 *
 * @export
 * @class MsgSendQueueService
 * @extends {MsgSendQueueServiceBase}
 */
export default class MsgSendQueueService extends MsgSendQueueServiceBase {

    /**
     * Creates an instance of  MsgSendQueueService.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgSendQueueService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}