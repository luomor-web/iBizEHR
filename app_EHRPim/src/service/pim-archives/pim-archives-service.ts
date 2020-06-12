import { Http,Util } from '@/utils';
import PimArchivesServiceBase from './pim-archives-service-base';


/**
 * 档案信息服务对象
 *
 * @export
 * @class PimArchivesService
 * @extends {PimArchivesServiceBase}
 */
export default class PimArchivesService extends PimArchivesServiceBase {

    /**
     * Creates an instance of  PimArchivesService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimArchivesService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}