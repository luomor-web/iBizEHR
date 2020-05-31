import { Http,Util } from '@/utils';
import PimTitleCatalogueServiceBase from './pim-title-catalogue-service-base';


/**
 * 职称目录服务对象
 *
 * @export
 * @class PimTitleCatalogueService
 * @extends {PimTitleCatalogueServiceBase}
 */
export default class PimTitleCatalogueService extends PimTitleCatalogueServiceBase {

    /**
     * Creates an instance of  PimTitleCatalogueService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimTitleCatalogueService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}