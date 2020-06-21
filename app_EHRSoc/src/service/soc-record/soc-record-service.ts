import { Http,Util } from '@/utils';
import SocRecordServiceBase from './soc-record-service-base';


/**
 * 社保缴费记录服务对象
 *
 * @export
 * @class SocRecordService
 * @extends {SocRecordServiceBase}
 */
export default class SocRecordService extends SocRecordServiceBase {

    /**
     * Creates an instance of  SocRecordService.
     * 
     * @param {*} [opts={}]
     * @memberof  SocRecordService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}