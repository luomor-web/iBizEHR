import { Http,Util } from '@/utils';
import PimArchivesRecordServiceBase from './pim-archives-record-service-base';


/**
 * 档案目录缺失记录服务对象
 *
 * @export
 * @class PimArchivesRecordService
 * @extends {PimArchivesRecordServiceBase}
 */
export default class PimArchivesRecordService extends PimArchivesRecordServiceBase {

    /**
     * Creates an instance of  PimArchivesRecordService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimArchivesRecordService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}