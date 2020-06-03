import { Http,Util } from '@/utils';
import PimPersonChangeServiceBase from './pim-person-change-service-base';


/**
 * 人员信息变更审核服务对象
 *
 * @export
 * @class PimPersonChangeService
 * @extends {PimPersonChangeServiceBase}
 */
export default class PimPersonChangeService extends PimPersonChangeServiceBase {

    /**
     * Creates an instance of  PimPersonChangeService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimPersonChangeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}