import { Http,Util } from '@/utils';
import TrmStayServiceBase from './trm-stay-service-base';


/**
 * 培训住宿服务对象
 *
 * @export
 * @class TrmStayService
 * @extends {TrmStayServiceBase}
 */
export default class TrmStayService extends TrmStayServiceBase {

    /**
     * Creates an instance of  TrmStayService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmStayService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}