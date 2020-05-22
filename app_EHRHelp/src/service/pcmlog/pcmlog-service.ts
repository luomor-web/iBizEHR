import { Http,Util } from '@/utils';
import PCMLOGServiceBase from './pcmlog-service-base';


/**
 * 配置变动日志服务对象
 *
 * @export
 * @class PCMLOGService
 * @extends {PCMLOGServiceBase}
 */
export default class PCMLOGService extends PCMLOGServiceBase {

    /**
     * Creates an instance of  PCMLOGService.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMLOGService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}