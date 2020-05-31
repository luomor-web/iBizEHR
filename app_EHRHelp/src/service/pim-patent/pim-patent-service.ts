import { Http,Util } from '@/utils';
import PimPatentServiceBase from './pim-patent-service-base';


/**
 * 专利信息服务对象
 *
 * @export
 * @class PimPatentService
 * @extends {PimPatentServiceBase}
 */
export default class PimPatentService extends PimPatentServiceBase {

    /**
     * Creates an instance of  PimPatentService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimPatentService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}