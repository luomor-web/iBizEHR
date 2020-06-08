import { Http,Util } from '@/utils';
import PimArchivesManageServiceBase from './pim-archives-manage-service-base';


/**
 * 档案管理服务对象
 *
 * @export
 * @class PimArchivesManageService
 * @extends {PimArchivesManageServiceBase}
 */
export default class PimArchivesManageService extends PimArchivesManageServiceBase {

    /**
     * Creates an instance of  PimArchivesManageService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimArchivesManageService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}