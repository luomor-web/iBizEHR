import { Http,Util } from '@/utils';
import PimArchivalCatalogueServiceBase from './pim-archival-catalogue-service-base';


/**
 * 档案目录服务对象
 *
 * @export
 * @class PimArchivalCatalogueService
 * @extends {PimArchivalCatalogueServiceBase}
 */
export default class PimArchivalCatalogueService extends PimArchivalCatalogueServiceBase {

    /**
     * Creates an instance of  PimArchivalCatalogueService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimArchivalCatalogueService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}