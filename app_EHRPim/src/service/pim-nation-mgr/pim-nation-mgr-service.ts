import { Http,Util } from '@/utils';
import PimNationMgrServiceBase from './pim-nation-mgr-service-base';


/**
 * 民族管理服务对象
 *
 * @export
 * @class PimNationMgrService
 * @extends {PimNationMgrServiceBase}
 */
export default class PimNationMgrService extends PimNationMgrServiceBase {

    /**
     * Creates an instance of  PimNationMgrService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimNationMgrService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}