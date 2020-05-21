import { Http,Util } from '@/utils';
import WXMessageServiceBase from './wxmessage-service-base';


/**
 * 微信消息服务对象
 *
 * @export
 * @class WXMessageService
 * @extends {WXMessageServiceBase}
 */
export default class WXMessageService extends WXMessageServiceBase {

    /**
     * Creates an instance of  WXMessageService.
     * 
     * @param {*} [opts={}]
     * @memberof  WXMessageService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}