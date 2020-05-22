import { Http,Util } from '@/utils';
import QUESTIONSServiceBase from './questions-service-base';


/**
 * 问题收集服务对象
 *
 * @export
 * @class QUESTIONSService
 * @extends {QUESTIONSServiceBase}
 */
export default class QUESTIONSService extends QUESTIONSServiceBase {

    /**
     * Creates an instance of  QUESTIONSService.
     * 
     * @param {*} [opts={}]
     * @memberof  QUESTIONSService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}