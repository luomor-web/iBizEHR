import { Http,Util } from '@/utils';
import PimVocationalCatalogServiceBase from './pim-vocational-catalog-service-base';


/**
 * 执（职）业资格管理服务对象
 *
 * @export
 * @class PimVocationalCatalogService
 * @extends {PimVocationalCatalogServiceBase}
 */
export default class PimVocationalCatalogService extends PimVocationalCatalogServiceBase {

    /**
     * Creates an instance of  PimVocationalCatalogService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimVocationalCatalogService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}