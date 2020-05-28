import { Http,Util } from '@/utils';
import PimSearchFieldSetServiceBase from './pim-search-field-set-service-base';


/**
 * 组合查询条件设置服务对象
 *
 * @export
 * @class PimSearchFieldSetService
 * @extends {PimSearchFieldSetServiceBase}
 */
export default class PimSearchFieldSetService extends PimSearchFieldSetServiceBase {

    /**
     * Creates an instance of  PimSearchFieldSetService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimSearchFieldSetService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}