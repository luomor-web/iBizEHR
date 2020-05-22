import { Http,Util } from '@/utils';
import MsgAccountServiceBase from './msg-account-service-base';


/**
 * 消息账户***服务对象
 *
 * @export
 * @class MsgAccountService
 * @extends {MsgAccountServiceBase}
 */
export default class MsgAccountService extends MsgAccountServiceBase {

    /**
     * Creates an instance of  MsgAccountService.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgAccountService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}