import { Http,Util } from '@/utils';
import MsgTemplateServiceBase from './msg-template-service-base';


/**
 * 消息模板服务对象
 *
 * @export
 * @class MsgTemplateService
 * @extends {MsgTemplateServiceBase}
 */
export default class MsgTemplateService extends MsgTemplateServiceBase {

    /**
     * Creates an instance of  MsgTemplateService.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgTemplateService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}