import { Http,Util } from '@/utils';
import PimSearchModalServiceBase from './pim-search-modal-service-base';


/**
 * 组合查询记录服务对象
 *
 * @export
 * @class PimSearchModalService
 * @extends {PimSearchModalServiceBase}
 */
export default class PimSearchModalService extends PimSearchModalServiceBase {

    /**
     * Creates an instance of  PimSearchModalService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimSearchModalService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}