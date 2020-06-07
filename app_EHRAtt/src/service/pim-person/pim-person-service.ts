import { Http,Util } from '@/utils';
import PimPersonServiceBase from './pim-person-service-base';


/**
 * 人员信息服务对象
 *
 * @export
 * @class PimPersonService
 * @extends {PimPersonServiceBase}
 */
export default class PimPersonService extends PimPersonServiceBase {

    /**
     * Creates an instance of  PimPersonService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimPersonService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}