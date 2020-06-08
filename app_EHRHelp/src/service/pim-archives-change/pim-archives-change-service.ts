import { Http,Util } from '@/utils';
import PimArchivesChangeServiceBase from './pim-archives-change-service-base';


/**
 * 档案归档地变更记录服务对象
 *
 * @export
 * @class PimArchivesChangeService
 * @extends {PimArchivesChangeServiceBase}
 */
export default class PimArchivesChangeService extends PimArchivesChangeServiceBase {

    /**
     * Creates an instance of  PimArchivesChangeService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimArchivesChangeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}