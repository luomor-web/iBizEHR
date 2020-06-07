import { Http,Util } from '@/utils';
import PimFaminfoServiceBase from './pim-faminfo-service-base';


/**
 * 家庭情况服务对象
 *
 * @export
 * @class PimFaminfoService
 * @extends {PimFaminfoServiceBase}
 */
export default class PimFaminfoService extends PimFaminfoServiceBase {

    /**
     * Creates an instance of  PimFaminfoService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimFaminfoService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}