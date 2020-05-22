import { Http,Util } from '@/utils';
import SALLOGServiceBase from './sallog-service-base';


/**
 * 薪酬调整日志服务对象
 *
 * @export
 * @class SALLOGService
 * @extends {SALLOGServiceBase}
 */
export default class SALLOGService extends SALLOGServiceBase {

    /**
     * Creates an instance of  SALLOGService.
     * 
     * @param {*} [opts={}]
     * @memberof  SALLOGService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}