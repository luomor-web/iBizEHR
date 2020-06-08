import { Http,Util } from '@/utils';
import PimResearchFindingsServiceBase from './pim-research-findings-service-base';


/**
 * 科研成果服务对象
 *
 * @export
 * @class PimResearchFindingsService
 * @extends {PimResearchFindingsServiceBase}
 */
export default class PimResearchFindingsService extends PimResearchFindingsServiceBase {

    /**
     * Creates an instance of  PimResearchFindingsService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimResearchFindingsService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}