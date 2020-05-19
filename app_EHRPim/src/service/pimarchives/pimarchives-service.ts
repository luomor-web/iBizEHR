import { Http,Util } from '@/utils';
import PIMARCHIVESServiceBase from './pimarchives-service-base';


/**
 * 档案信息服务对象
 *
 * @export
 * @class PIMARCHIVESService
 * @extends {PIMARCHIVESServiceBase}
 */
export default class PIMARCHIVESService extends PIMARCHIVESServiceBase {

    /**
     * Creates an instance of  PIMARCHIVESService.
     * 
     * @param {*} [opts={}]
     * @memberof  PIMARCHIVESService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}