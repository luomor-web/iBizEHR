import { Http,Util } from '@/utils';
import TrmTrafficServiceBase from './trm-traffic-service-base';


/**
 * 交通服务对象
 *
 * @export
 * @class TrmTrafficService
 * @extends {TrmTrafficServiceBase}
 */
export default class TrmTrafficService extends TrmTrafficServiceBase {

    /**
     * Creates an instance of  TrmTrafficService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTrafficService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}